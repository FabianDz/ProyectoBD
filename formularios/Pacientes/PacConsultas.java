package formularios.Pacientes;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PacConsultas extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    String idPer;
    private JPanel jpConsultas;
    private JLabel Label10;
    private JLabel Label0;
    private JTextField tfNombre;
    private JLabel Label1;
    private JLabel Label2;
    private JTextField tfApellido;
    private JLabel Label3;
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
    private JLabel Label9;
    private JTextField tfEdad;
    private JLabel Label11;
    private JTextField tfID;
    private JButton buscarButton;

    public PacConsultas() {
        setContentPane(jpConsultas);
        this.setTitle("Consultas: Pacientes");
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
}