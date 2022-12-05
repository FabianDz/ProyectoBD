package formularios.Hospitales;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class HosAltas extends Formularios {
    PreparedStatement prepared;
    private JPanel jpAltas;
    private JLabel Label1;
    private JTextField tfNombre;
    private JLabel Label2;
    private JTextField tfTipo;
    private JButton guardarButton;
    private JButton limpiarButton;
    private JLabel Label0;

    public HosAltas() {
        setContentPane(jpAltas);
        this.setTitle("Altas: Hospitales");
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;
                int resultado;

                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("insert into hospitales(nombre, tipo) "+ "VALUES(?,?)");
                    prepared.setString(1, tfNombre.getText());
                    prepared.setString(2, tfTipo.getText());
                    resultado = prepared.executeUpdate();

                    if(resultado > 0){
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
        tfTipo.setText(null);
    }
}
