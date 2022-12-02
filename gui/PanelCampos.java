package gui;

/**Imports**/
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;

/**Clase PanelCampos**/
public class PanelCampos extends JPanel {
    /*Variables*/
    //Combo Boton Campo
    private JComboBox jcbCampo;
    //Items Campo
    private String [] campos = {"Selecciona un campo...","Medicos","Pacientes","Hospitales", "Estudios de Lab"};

    /*Metodos*/

    //Constructor
    public PanelCampos(){
        setBounds(20,20,230,100);
        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2), "Campos"));
        ComboBox();
    }

    //Combo Box
    private void ComboBox(){
        //Instanciar JComboBox
        jcbCampo = new JComboBox(campos);
        add(jcbCampo);
        setVisible(true);
    }
}
