package formularios.Medicos;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MedAltas extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    String idPer;
    private JPanel jpAltas;
    private JLabel Label1;
    private JTextField tfNombre;
    private JLabel Label3;
    private JTextField tfTelefono;
    private JLabel Label2;
    private JTextField tfApellido;
    private JLabel Label5;
    private JTextField tfCedula;
    private JLabel Label4;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JLabel Label0;
    private JTextField tfHospital;
    private JLabel Label6;

    public MedAltas() {
        setContentPane(jpAltas);
        this.setTitle("Altas: Medicos");
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

                    prepared = conexion.prepareStatement("INSERT INTO medicos(cedula, persona_id, hospital_id) "+ "VALUES(?,?,?)");
                    prepared.setString(1, tfCedula.getText());
                    prepared.setString(2, idPer);
                    prepared.setString(3, tfHospital.getText());
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
        tfCedula.setText(null);
        tfHospital.setText(null);
    }

}
