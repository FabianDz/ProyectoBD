package formularios.Pacientes;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacAltas extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    String idPer;
    private JPanel jpAltas;
    private JTextField tfNombre;
    private JLabel Label1;
    private JTextField tfApellido;
    private JLabel Label2;
    private JTextField tfTelefono;
    private JLabel Label3;
    private JLabel Label0;
    private JLabel Label4;
    private JTextField tfPeso;
    private JTextField tfTalla;
    private JTextField tfPadecimiento;
    private JTextField tfEstudios;
    private JTextField tfEdad;
    private JLabel Label5;
    private JLabel Label6;
    private JLabel Label7;
    private JLabel Label8;
    private JLabel Label9;
    private JButton limpiarButton;
    private JButton guardarButton;

    public PacAltas() {
        setContentPane(jpAltas);
        this.setTitle("Altas: Pacientes");

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

                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("INSERT INTO personas(nombre, apellido, telefono) "+ "VALUES(?,?,?)");
                    prepared.setString(1, tfNombre.getText());
                    prepared.setString(2, tfApellido.getText());
                    prepared.setString(3, tfTelefono.getText());
                    prepared.executeUpdate();

                    prepared = conexion.prepareStatement("SELECT LAST_INSERT_ID() FROM personas");
                    result = prepared.executeQuery();

                    if(result.next()){
                        idPer = result.getString( 1);
                    }

                    prepared = conexion.prepareStatement("INSERT INTO pacientes(edad, peso, talla, procedimiento, num_estudios, persona_id) "+ "VALUES(?,?,?,?,?,?)");
                    prepared.setString(1, tfEdad.getText());
                    prepared.setString(2, tfPeso.getText());
                    prepared.setString(3, tfTalla.getText());
                    prepared.setString(4, tfPadecimiento.getText());
                    prepared.setString(5, tfEstudios.getText());
                    prepared.setString(6, idPer);
                    prepared.executeUpdate();

                    if(result.next()){
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