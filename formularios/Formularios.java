package formularios;

import javax.swing.BorderFactory;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;

public class Formularios extends JInternalFrame implements InternalFrameListener {
    private JPanel jpFormulario;

    public Formularios() {
        setContentPane(jpFormulario);
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black)));
        setBackground(new Color(225, 225, 225));
        setResizable(false);
        setClosable(true);
        addInternalFrameListener(this);
        setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
        try {
            this.setMaximum(true);
        } catch(PropertyVetoException e) { e.printStackTrace(); }
        setVisible(true);

    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        System.out.println("Cerrando Ventana");
        if (JOptionPane.showConfirmDialog(null,"¿Desea salir del formulario?", "Confirmación",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)== JOptionPane.YES_OPTION){
            dispose();
        }
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {

    }
}

