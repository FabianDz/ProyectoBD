package formularios.Pacientes;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacCambios extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    String idPer;
    private JPanel jpCambios;
    private JLabel Label0;
    private JTextField tfApellido;
    private JTextField tfTelefono;
    private JLabel Label4;
    private JLabel Label5;
    private JTextField tfPeso;
    private JLabel Label6;
    private JTextField tfTalla;
    private JLabel Label7;
    private JTextField tfPadecimiento;
    private JLabel Label8;
    private JTextField tfEstudios;
    private JTextField tfEdad;
    private JTextField tfNombre;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel Label3;
    private JLabel Label9;
    private JLabel Label10;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JLabel Label11;
    private JTextField tfID;
    private JButton buscarButton;

    public PacCambios() {
        setContentPane(jpCambios);
        setTitle("Cambios: Pacientes");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;

                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("SELECT * FROM personas, pacientes WHERE personas.id = pacientes.persona_id AND pacientes.id = ?");
                    prepared.setInt(1, Integer.valueOf(tfID.getText()));
                    result = prepared.executeQuery();

                    if(result.next()){
                        idPer = result.getString("persona_id");
                        tfNombre.setText(result.getString("nombre"));
                        tfApellido.setText(result.getString("apellido"));
                        tfTelefono.setText(result.getString("telefono"));
                        tfPeso.setText(result.getString("peso"));
                        tfTalla.setText(result.getString("talla"));
                        tfPadecimiento.setText(result.getString("procedimiento"));
                        tfEstudios.setText(result.getString("num_estudios"));
                        tfEdad.setText(result.getString("edad"));
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
                    prepared = conexion.prepareStatement("UPDATE personas SET nombre= ?, apellido= ?, telefono= ?"+" WHERE id = ?;");
                    prepared.setString(1, tfNombre.getText());
                    prepared.setString(2, tfApellido.getText());
                    prepared.setString(3, tfTelefono.getText());
                    prepared.setInt(4, Integer.valueOf(idPer));
                    prepared.executeUpdate();

                    prepared = conexion.prepareStatement("UPDATE pacientes SET edad= ?, peso= ?, talla= ?, procedimiento= ?, num_estudios= ?"+ " WHERE id = ?;");
                    prepared.setString(1, tfEdad.getText());
                    prepared.setString(2, tfPeso.getText());
                    prepared.setString(3, tfTalla.getText());
                    prepared.setString(4, tfPadecimiento.getText());
                    prepared.setString(5, tfEstudios.getText());
                    prepared.setString(6, tfID.getText());
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
        tfNombre.setText(null);
        tfApellido.setText(null);
        tfTelefono.setText(null);
        tfPeso.setText(null);
        tfTalla.setText(null);
        tfPadecimiento.setText(null);
        tfEstudios.setText(null);
        tfEdad.setText(null);
    }
}
