package formularios.Medicos;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedBajas extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    String idPer;
    private JPanel jpBajas;
    private JLabel Label0;
    private JTextField tfApellido;
    private JTextField tfTelefono;
    private JLabel Label4;
    private JLabel Label5;
    private JTextField tfCedula;
    private JTextField tfNombre;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JButton eliminarButton;
    private JLabel Label10;
    private JLabel Label11;
    private JTextField tfID;
    private JButton buscarButton;
    private JTextField tfHospital;
    private JLabel Label6;

    public MedBajas() {
        setContentPane(jpBajas);
        this.setTitle("Bajas: Medicos");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("SELECT * FROM personas, medicos WHERE personas.id = persona_id AND medicos.id = ?");
                    prepared.setInt(1, Integer.valueOf(tfID.getText()));
                    result = prepared.executeQuery();

                    if(result.next()){
                        idPer = result.getString("persona_id");
                        tfNombre.setText(result.getString("nombre"));
                        tfApellido.setText(result.getString("apellido"));
                        tfTelefono.setText(result.getString("telefono"));
                        tfCedula.setText(result.getString("cedula"));
                        tfHospital.setText(result.getString("hospital_id"));
                    }else{
                        JOptionPane.showMessageDialog(null,"No Encontrado", "Info", JOptionPane.ERROR_MESSAGE);
                    }
                    conexion.close();
                } catch (Exception f) {
                    System.err.println("Error: "+f);
                }
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                int resultado;
                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("DELETE FROM medicos WHERE id = ?");
                    prepared.setInt(1, Integer.valueOf(tfID.getText()));
                    prepared.executeUpdate();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("DELETE FROM personas WHERE id = ?");
                    prepared.setInt(1, Integer.valueOf(idPer));
                    resultado = prepared.executeUpdate();

                    if(resultado > 0){
                        JOptionPane.showMessageDialog(null,"Eliminado", "Info", JOptionPane.ERROR_MESSAGE);
                        limpiar();
                    }else{
                        JOptionPane.showMessageDialog(null,"No Eliminado", "Info", JOptionPane.ERROR_MESSAGE);
                    }
                    conexion.close();
                } catch (Exception g) {
                    System.err.println("Error: "+g);
                }
            }
        });
    }
    private void limpiar(){ // metodo para limpiar los textfields
        tfNombre.setText(null);
        tfApellido.setText(null);
        tfTelefono.setText(null);
        tfCedula.setText(null);
        tfHospital.setText(null);
    }
}

