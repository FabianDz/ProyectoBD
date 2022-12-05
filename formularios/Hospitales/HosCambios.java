package formularios.Hospitales;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HosCambios extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    private JPanel jpCambios;
    private JLabel Label0;
    private JLabel Label1;
    private JTextField tfNombre;
    private JLabel Label2;
    private JTextField tfTipo;
    private JLabel Label11;
    private JTextField tfID;
    private JButton buscarButton;
    private JLabel Label10;
    private JButton guardarButton;
    private JButton limpiarButton;

    public HosCambios() {
        setContentPane(jpCambios);
        this.setTitle("Cambios: Hospitales");
        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                    prepared = conexion.prepareStatement("UPDATE hospitales SET nombre= ?, tipo= ?"+" WHERE id = ?;");
                    prepared.setString(1, tfNombre.getText());
                    prepared.setString(2, tfTipo.getText());
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
                    prepared = conexion.prepareStatement("SELECT * FROM hospitales WHERE id = ?");
                    prepared.setInt(1, Integer.valueOf(tfID.getText()));
                    result = prepared.executeQuery();

                    if(result.next()){
                        tfNombre.setText(result.getString("nombre"));
                        tfTipo.setText(result.getString("tipo"));
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
        tfTipo.setText(null);
    }
}
