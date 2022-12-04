
package gui;

/**Imports**/

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    //Opcion-Switch
    private Integer Opcion;

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

        //Acciones
        pA.getJbSalir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cerrando Ventana");
                if (JOptionPane.showConfirmDialog(null,"¿Desea salir del sistema?", "Confirmación",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        pA.getJbAlta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.removeAll();
                Opcion = pC.getJcbCampo().getSelectedIndex();
                switch (Opcion){
                    case 1:
                        jdp.add(jdp.getFmAlt());
                        break;
                    case 2:
                        jdp.add(jdp.getFpAlt());
                        break;
                    case 3:
                        jdp.add(jdp.getFhAlt());
                        break;
                    case 4:
                        jdp.add(jdp.getFeAlt());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Selecciona un Campo", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        });
        pA.getJbBaja().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.removeAll();
                Opcion = pC.getJcbCampo().getSelectedIndex();
                switch (Opcion){
                    case 1:
                        jdp.add(jdp.getFmBaj());
                        break;
                    case 2:
                        jdp.add(jdp.getFpBaj());
                        break;
                    case 3:
                        jdp.add(jdp.getFhBaj());
                        break;
                    case 4:
                        jdp.add(jdp.getFeBaj());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Selecciona un Campo", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        });
        pA.getJbCambio().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.removeAll();
                Opcion = pC.getJcbCampo().getSelectedIndex();
                switch (Opcion){
                    case 1:
                        jdp.add(jdp.getFmCam());
                        break;
                    case 2:
                        jdp.add(jdp.getFpCam());
                        break;
                    case 3:
                        jdp.add(jdp.getFhCam());
                        break;
                    case 4:
                        jdp.add(jdp.getFeCam());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Selecciona un Campo", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        });
        pA.getJbConsulta().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jdp.removeAll();
                Opcion = pC.getJcbCampo().getSelectedIndex();
                switch (Opcion){
                    case 1:
                        jdp.add(jdp.getFmCon());
                        break;
                    case 2:
                        jdp.add(jdp.getFpCon());
                        break;
                    case 3:
                        jdp.add(jdp.getFhCon());
                        break;
                    case 4:
                        jdp.add(jdp.getFeCon());
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Selecciona un Campo", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            }
        });

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