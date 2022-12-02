package gui;

/**Imports**/
import formularios.Altas;

import javax.swing.JDesktopPane;

/**Clase Escritorio**/
public class Escritorio extends JDesktopPane {
    /*Variables*/
    //Vetanas Formularios
    private Altas fA;
    /*Metodos*/

    //Constructor
    public Escritorio(){
        setBounds(270,20,290,500);
        fA = new Altas();
        add(fA);
    }
}
