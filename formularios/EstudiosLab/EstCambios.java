package formularios.EstudiosLab;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstCambios extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    private JPanel jpCambios;
    private JLabel Label0;
    private JLabel Label1;
    private JTextField tfTipo;
    private JLabel Label2;
    private JTextField tfFecha;
    private JTextField tfPaciente;
    private JLabel Label3;
    private JLabel Label10;
    private JLabel Label11;
    private JTextField tfID;
    private JButton buscarButton;
    private JButton guardarButton;
    private JButton limpiarButton;

    public EstCambios() {
        setContentPane(jpCambios);
        this.setTitle("Cambios: Estudios de Laboratorio");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;

                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("SELECT * FROM estudios_laboratorio WHERE id = ?");
                    prepared.setInt(1, Integer.valueOf(tfID.getText()));
                    result = prepared.executeQuery();

                    if(result.next()){
                        tfTipo.setText(result.getString("tipo_estudio"));
                        tfFecha.setText(result.getString("fecha_estudio"));
                        tfPaciente.setText(result.getString("paciente_id"));
                    }else{
                        JOptionPane.showMessageDialog(null,"No Encontrado", "Info", JOptionPane.ERROR_MESSAGE);
                    }
                    conexion.close();
                } catch (Exception f) {
                    System.err.println("Error: "+f);
                }
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                int resultado;

                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("UPDATE estudios_laboratorio SET tipo_estudio= ?, fecha_estudio= ?, paciente_id= ?"+" WHERE id = ?;");
                    prepared.setString(1, tfTipo.getText());
                    prepared.setString(2, tfFecha.getText());
                    prepared.setString(3, tfPaciente.getText());
                    prepared.setString(4, tfID.getText());
                    resultado = prepared.executeUpdate();

                    if(resultado > 0){
                        JOptionPane.showMessageDialog(null,"Actualizado", "Info", JOptionPane.ERROR_MESSAGE);
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null,"No Actualizadp", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    conexion.close();
                } catch (Exception g) {
                    System.err.println("Error: "+g);
                }
            }
        });
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });

    }
    private void limpiar(){ // metodo para limpiar los textfields
        tfTipo.setText(null);
        tfFecha.setText(null);
        tfPaciente.setText(null);
    }
}
