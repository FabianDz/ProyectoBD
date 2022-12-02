package formularios;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;

public class Altas extends JInternalFrame {
    private JPanel pAltas;

    public Altas() {
        super("Altas: ");
        setContentPane(pAltas);
        setSize(280, 400);
        setBackground(new Color(225, 225, 225));
        setResizable(false);
        setVisible(true);
    }
}
