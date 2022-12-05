package formularios.Pacientes;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacBajas extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    String idPer;
    private JPanel jpBajas;
    private JLabel Label1;
    private JTextField tfNombre;
    private JLabel Label3;
    private JTextField tfTelefono;
    private JLabel Label2;
    private JTextField tfApellido;
    private JLabel Label5;
    private JLabel Label6;
    private JLabel Label7;
    private JLabel Label8;
    private JLabel Label9;
    private JTextField tfPeso;
    private JTextField tfTalla;
    private JTextField tfPadecimiento;
    private JTextField tfEstudios;
    private JLabel Label4;
    private JButton eliminarButton;
    private JLabel Label0;
    private JTextField tfEdad;
    private JLabel Label10;
    private JTextField tfID;
    private JLabel Label11;
    private JButton buscarButton;

    public PacBajas() {
        setContentPane(jpBajas);
        this.setTitle("Bajas: Pacientes");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                int resultado;

                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("DELETE FROM pacientes WHERE id = ?");
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
