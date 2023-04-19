package uniandes.dpoo.taller4.view.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import javax.swing.JPanel;

import uniandes.dpoo.taller4.controller.Controller;

public class GameBoard extends JPanel {
    private Controller control;
    private int dimentions;
    private int[][][] cardPositions;

    public GameBoard(Controller control) {
        this.control = control;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int[] pos = getIndexFromSize(e.getX(), e.getY());
                try {
                    control.play(pos[0], pos[1]);
                } catch (FileNotFoundException | UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        dimentions = control.getBoardDimentions();
        cardPositions = new int[dimentions][dimentions][2];
        boolean[][] boardDisposition = control.getBoardLights();

        int squareSize = Math.min((this.getHeight() - 20) / dimentions,
                (this.getWidth() - 20) / dimentions);

        for (int i = 0; i < dimentions; i++) {
            for (int j = 0; j < dimentions; j++) {
                g2d.setColor(boardDisposition[i][j] ? Color.YELLOW : Color.GRAY);
                g2d.fillRect((i * squareSize) + 10, (j * squareSize) + 10, squareSize - 10, squareSize - 10);
                cardPositions[i][j] = new int[] { (i * squareSize) + 10, (j * squareSize) + 10 };
            }
        }
    }

    private int[] getIndexFromSize(int x, int y) {
        int iPos = -1;
        int jPos = -1;

        for (int i = 0; i < cardPositions.length; i++) {
            if (cardPositions[i][0][0] <= x)
                iPos = i;
            if (cardPositions[0][i][1] <= y)
                jPos = i;
        }

        // TODO que sea -1 si selecciona a fuera de la grilla

        return new int[] { iPos, jPos };
    }

}