
package gui;

/**Imports**/
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


/**Clase VentanaMain**/
public class VentanaMain extends WindowAdapter{
	/*Variables*/
	//Ventana
	JFrame vM;
	//Barra de herramientas
	JMenuBar jmb;
	//Pestañas
	JMenu jmAlta, jmBaja, jmConsulta, jmCambio, jmSalir;
	//Elementos de Pestañas
	JMenuItem jmiMedicos, jmiPacientes, jmiHospitales, jmiEstudiosLab;

	/*Metodos*/

	//Constructor
	public VentanaMain(){
		//Instanciar Ventana
		vM = new JFrame("Sistema Medico");
		vM.setLayout(null);
        vM.getContentPane().setBackground(new Color(225,225,255));
        vM.setResizable(false);
        vM.setSize(600,700);
        vM.addWindowListener(this);
        vM.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //Instanciar Barra de herramientas
        jmb = new JMenuBar();
        //Pestaña Alta
        jmAlta = new JMenu("Alta");
        jmb.add(jmAlta);
        	//Item Medicos
        	jmiMedicos = new JMenuItem("Medicos");
        		//Botton add
        		jmAlta.add(jmiMedicos);

        //Insercion de la barra
        vM.setJMenuBar(jmb);

        /*Fin metodo constructor*/
        vM.setVisible(true);
        vM.setLocation(null);
    }
	
	//Main
	public static void main(String[] args) {
		new VentanaMain();
	}

	/*Overrides*/
    //Cerrar ventana con X
    @Override
    public void windowClosing(WindowEvent e){
        System.out.println("Cerrando ventana");
        if(JOptionPane.showConfirmDialog(null, "¿Deseas salir del Sistema?","Confirmacion", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE)==JOptionPane.YES_OPTION){
           vM.dispose();
           System.exit(0);
        }
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