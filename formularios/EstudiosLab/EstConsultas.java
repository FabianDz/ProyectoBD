package formularios.EstudiosLab;

import formularios.Formularios;
import utils.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EstConsultas extends Formularios {
    PreparedStatement prepared;
    ResultSet result;
    private JPanel jpConsultas;
    private JLabel Label0;
    private JLabel Label1;
    private JTextField tfTipo;
    private JLabel Label2;
    private JTextField tfFecha;
    private JTextField tfPaciente;
    private JLabel Label3;
    private JLabel Label10;
    private JLabel Label11;
    private JTextField tfID;
    private JButton buscarButton;

    public EstConsultas() {
        setContentPane(jpConsultas);
        this.setTitle("Consultas: Estudios de Laboratorio");
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection conexion = null;

                try {
                    Conexion conectar = new Conexion();
                    conexion = conectar.getConnection();
                    prepared = conexion.prepareStatement("SELECT * FROM estudios_laboratorio WHERE id = ?");
                    prepared.setInt(1, Integer.valueOf(tfID.getText()));
                    result = prepared.executeQuery();

                    if(result.next()){
                        tfTipo.setText(result.getString("tipo_estudio"));
                        tfFecha.setText(result.getString("fecha_estudio"));
                        tfPaciente.setText(result.getString("paciente_id"));
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
