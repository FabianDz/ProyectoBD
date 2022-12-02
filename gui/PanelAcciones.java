package gui;

/**Imports**/
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**Clase PanelAcciones**/
public class PanelAcciones extends JPanel {
    /*Variables*/
    //Botones de accion
    private JButton jbAlta, jbBaja, jbConsulta, jbCambio, jbSalir;
    //GridBagConstrains
    private GridBagConstraints gbc = new GridBagConstraints();

    /*Metodos*/

    //Constructor
    public PanelAcciones(){
        setBounds(20,140,230,220);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Acciones"));
        Botones();
    }
    //Botones
    private void Botones(){
        gbc.insets = new Insets(10, 10 ,10 ,10);
        //Alta
        jbAlta = new JButton("Alta");
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        add(jbAlta, gbc);
        //Baja
        jbBaja = new JButton("Baja");
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        add(jbBaja, gbc);
        //Consulta
        jbConsulta = new JButton("Consulta");
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
        add(jbConsulta, gbc);
        //Cambio
        jbCambio = new JButton("Cambio");
            gbc.gridx = 2;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
        add(jbCambio, gbc);
        //Salir
        jbSalir = new JButton("Salir");
            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        add(jbSalir, gbc);
        setVisible(true);
    }


}
