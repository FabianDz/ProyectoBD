package formularios.EstudiosLab;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstAltas extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    private JPanel jpAltas;
    private JLabel Label1;
    private JTextField tfTipo;
    private JLabel Label3;
    private JTextField tfPaciente;
    private JLabel Label2;
    private JTextField tfFecha;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JLabel Label0;

    public EstAltas() {
        setContentPane(jpAltas);
        this.setTitle("Altas: Estudios de Laboratorio");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                int resultado;

                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("INSERT INTO estudios_laboratorio (tipo_estudio, fecha_estudio, paciente_id) "+ "VALUES(?,?,?)");
                    prepared.setString(1, tfTipo.getText());
                    prepared.setString(2, tfFecha.getText());
                    prepared.setString(3, tfPaciente.getText());
                    resultado = prepared.executeUpdate();

                    if(resultado > 0){
                        JOptionPane.showMessageDialog(null,"Agregado", "Info", JOptionPane.ERROR_MESSAGE);
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null,"No Agregado", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    conexion.close();
                } catch (Exception f) {
                    System.err.println("Error: "+f);
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
