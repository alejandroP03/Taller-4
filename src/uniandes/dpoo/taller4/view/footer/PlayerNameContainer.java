package uniandes.dpoo.taller4.view.footer;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.taller4.controller.Controller;

public class PlayerNameContainer extends JPanel {
    JTextField playerNameField = new JTextField();
    Controller control;

    public PlayerNameContainer(Controller control) {
        this.control = control;
        add(new JLabel("Jugador: "));
        playerNameField.setPreferredSize(new Dimension(200, 18));
        playerNameField.setText(control.getActivePlayer());
        playerNameField.setEnabled(false);
        
        add(playerNameField);
    }

    public void allowSwitchPlayer() {
        playerNameField.setEnabled(true);
        playerNameField.requestFocus(true);
        playerNameField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.setActivePlayer(playerNameField.getText());
                playerNameField.setEnabled(false);
            }
        });
    }

}
