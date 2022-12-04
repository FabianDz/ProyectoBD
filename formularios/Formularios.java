package formularios;

import gui.Escritorio;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

public class Formularios extends JInternalFrame {
    private JPanel jpFormulario;
    private JButton salirButton;
    private String sNom;
    private Integer iCerrar;

    public Integer getCerrar() {
        return iCerrar;
    }

    public void setCerrar(Integer cerrar) {
        iCerrar = cerrar;
    }

    public JPanel getJpFormulario() {
        return jpFormulario;
    }

    public String getsNom() {
        return sNom;
    }

    public void setJpFormulario(JPanel jpFormulario) {
        this.jpFormulario = jpFormulario;
    }

    public void setsNom(String sNom) {
        this.sNom = sNom;
    }

    public Formularios() {
        setContentPane(jpFormulario);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), sNom));
        setBackground(new Color(225, 225, 225));
        setResizable(false);
        try {
            this.setMaximum(true);
        } catch(PropertyVetoException e) { e.printStackTrace(); }
        setVisible(true);

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cerrando Ventana");
                if (JOptionPane.showConfirmDialog(null,"¿Desea salir del formulario?", "Confirmación",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
                    dispose();
                }
            }
        });

    }




}

