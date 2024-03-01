package Modelo;

import static Vista.Menu.Escritorio;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class Funciones {
    public void actualizarPanel(JPanel panel){
        Escritorio.removeAll();
        Escritorio.add(panel, BorderLayout.CENTER);
        Escritorio.repaint();
        Escritorio.revalidate();
    }
}
