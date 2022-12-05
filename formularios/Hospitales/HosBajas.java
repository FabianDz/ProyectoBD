package formularios.Hospitales;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HosBajas extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    private JPanel jpBajas;
    private JLabel Label0;
    private JLabel Label1;
    private JTextField tfNombre;
    private JLabel Label2;
    private JTextField tfTipo;
    private JLabel Label11;
    private JTextField tfID;
    private JButton buscarButton;
    private JLabel Label10;
    private JButton eliminarButton;

    public HosBajas() {
        setContentPane(jpBajas);

        this.setTitle("Bajas: Hospitales");
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
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                int resultado;

                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("DELETE FROM hospitales WHERE id = ?");
                    prepared.setInt(1, Integer.valueOf(tfID.getText()));
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
        tfTipo.setText(null);
    }
}
