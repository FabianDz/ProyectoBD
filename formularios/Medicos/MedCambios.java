package formularios.Medicos;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedCambios extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    String idPer;
    private JPanel jpCambios;
    private JLabel Label10;
    private JLabel Label11;
    private JTextField tfID;
    private JButton buscarButton;
    private JLabel Label0;
    private JLabel Label1;
    private JTextField tfNombre;
    private JLabel Label2;
    private JTextField tfApellido;
    private JLabel Label3;
    private JTextField tfTelefono;
    private JLabel Label4;
    private JLabel Label5;
    private JTextField tfCedula;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JTextField tfHospital;
    private JLabel Label6;

    public MedCambios() {
        setContentPane(jpCambios);
        this.setTitle("Cambios: Medicos");
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
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
                    prepared = conexion.prepareStatement("UPDATE personas SET nombre= ?, apellido= ?, telefono= ?"+" WHERE id = ?;");
                    prepared.setString(1, tfNombre.getText());
                    prepared.setString(2, tfApellido.getText());
                    prepared.setString(3, tfTelefono.getText());
                    prepared.setInt(4, Integer.valueOf(idPer));
                    prepared.executeUpdate();

                    prepared = conexion.prepareStatement("UPDATE medicos SET cedula= ?, hospital_id= ?"+ " WHERE id = ?;");
                    prepared.setString(1, tfCedula.getText());
                    prepared.setString(2, tfHospital.getText());
                    prepared.setString(3, tfID.getText());
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
    }
    private void limpiar(){ // metodo para limpiar los textfields
        tfNombre.setText(null);
        tfApellido.setText(null);
        tfTelefono.setText(null);
        tfCedula.setText(null);
        tfHospital.setText(null);
    }
}
