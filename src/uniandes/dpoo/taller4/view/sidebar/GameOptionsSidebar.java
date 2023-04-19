package uniandes.dpoo.taller4.view.sidebar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.controller.Controller;
import uniandes.dpoo.taller4.view.Top10Dialog;
import uniandes.dpoo.taller4.view.footer.GameDataFooter;

public class GameOptionsSidebar extends JPanel {

    private JButton newGameButton = new SidebarBtn("Nuevo juego");
    private JButton restartGameButton = new SidebarBtn("Reiniciar juego");
    private JButton top10Button = new SidebarBtn("Top 10");
    private JButton switchPlayerButton = new SidebarBtn("Cambiar jugador");

    public GameOptionsSidebar(Controller control, GameDataFooter footer) {
        add(newGameButton);
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.newGame();
            }
        });

        add(restartGameButton);
        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.restartGame();
            }
        });

        add(top10Button);
        top10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Top10Dialog(control);
            }
        });

        add(switchPlayerButton);
        switchPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                footer.switchPlayer();
            }
        });
    }

    private class SidebarBtn extends JButton {
        public SidebarBtn(String text) {
            setAlignmentX(CENTER_ALIGNMENT);
            setMinimumSize(new Dimension(150, 50));
            setMaximumSize(new Dimension(150, 50));
            setText(text);
        }
    }

}

// UML
/*
 * 
 * 
 * + SidebarBtn(text: String)
 * 
 * 
 */