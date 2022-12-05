package formularios.Hospitales;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class HosConsultas extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    private JPanel jpConsultas;
    private JLabel Label0;
    private JLabel Label1;
    private JTextField tfNombre;
    private JLabel Label2;
    private JTextField tfTipo;
    private JLabel Label11;
    private JTextField tfID;
    private JButton buscarButton;
    private JLabel Label10;

    public HosConsultas() {
        setContentPane(jpConsultas);
        this.setTitle("Consultas: Hospitales");
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
}
