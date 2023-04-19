package uniandes.dpoo.taller4.view.footer;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.taller4.controller.Controller;

public class TriesContainer extends JPanel {
    private JTextField triesValueField = new JTextField();
    private int triesValue;

    public TriesContainer(Controller control) {
        add(new JLabel("Intentos: "));
        triesValueField.setPreferredSize(new Dimension(200, 18));
        triesValueField.setEnabled(false);
        triesValueField.setText(triesValue + "");
        add(triesValueField);
    }

    public void setTriesValue(int triesValue) {
        this.triesValue = triesValue;
        triesValueField.setText(triesValue + "");
    }

}
