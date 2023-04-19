package uniandes.dpoo.taller4.view;

import java.awt.Color;
import java.util.Collection;

import javax.swing.JDialog;
import javax.swing.JList;

import uniandes.dpoo.taller4.controller.Controller;
import uniandes.dpoo.taller4.modelo.RegistroTop10;

public class Top10Dialog extends JDialog {
    private Controller control;
    private JList<String> top10List;

    public Top10Dialog(Controller control) {
        this.control = control;
        setTitle("Top 10 Jugadores");
        setSize(400, 600);
        setResizable(false);
        getList();
        top10List.setBackground(new Color(142, 202, 230));
        
        add(top10List);
        setVisible(true);

    }

    private void getList() {
        Collection<RegistroTop10> top10 = control.getTop10();
        String[] top10Array = new String[top10.size()];
        int i = 0;
        for (RegistroTop10 register : top10) {
            top10Array[i] = i + ". " + register.darNombre() + " - " + register.darPuntos();
            i++;
        }

        top10List = new JList<String>(top10Array);
    }
}