
package gui;

/**Imports**/

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**Clase VentanaMain**/
public class VentanaMain extends WindowAdapter {

	/*Variables*/
	//Ventana
    private JFrame vM;
    //Panel
    private PanelAcciones pA;
    private PanelCampos pC;
    //Escritorio
    private Escritorio jdp;

	/*Metodos*/
	//Constructor
	public VentanaMain(){
		//Instanciar Ventana
		vM = new JFrame("Sistema Medico");
		vM.setLayout(null);
        //Panel Campos
        pC = new PanelCampos();
        vM.add(pC);
        //Panel Acciones
        pA = new PanelAcciones();
        vM.add(pA);
        //Desktop
        jdp = new Escritorio();
        vM.add(jdp);

        vM.getContentPane().setBackground(new Color(225, 225, 225));
        vM.setResizable(false);
        vM.setSize(600,700);
        vM.addWindowListener(this);
        vM.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        vM.setVisible(true);
        vM.setLocationRelativeTo(null);

        //Instanciar Desktop

    }

    //Overrides
    @Override
    public void windowClosing(WindowEvent e){
        System.out.println("Cerrando Ventana");
        if (JOptionPane.showConfirmDialog(null,"¿Desea salir del sistema?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
            vM.dispose();
            System.exit(0);
        }
    }

    //Main
    public static void main(String[] args) {
        new VentanaMain();
    }

}

/*
Conexión a Base de Datos Mysql
• Pantalla de Acceso al Sistema
• Alta, Baja, Consulta y Cambio de Médicos y Pacientes
• Alta, Baja, Consulta y Cambio de Hospitales
• Alta, Baja, Consulta y Cambio de Estudios de Laboratorio
• Salir del Sistema
*/