package uniandes.dpoo.taller4.view;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatLightLaf;

import uniandes.dpoo.taller4.controller.Controller;

public class GameWindow extends JFrame {

    private Controller control = new Controller(this);
    private Body body = new Body(control);

    public GameWindow() {
        setTitle("LightsOut");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setMinimumSize(new Dimension(600, 600));
        setVisible(true);
        setContentPane(body);
        revalidate();
        repaint();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    control.saveTop10();
                } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    public Body getBody() {
        return body;
    }

    public void showWinMessage() {
        JOptionPane.showMessageDialog(this, String.format("¡Felicidades, %s has ganado!", control.getActivePlayer()));
        control.newGame();
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        new GameWindow();
    }

    // TODO Meterle mas diseño
}
