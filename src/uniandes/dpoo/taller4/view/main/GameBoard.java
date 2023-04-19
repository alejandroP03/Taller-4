package uniandes.dpoo.taller4.view.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.controller.Controller;

public class GameBoard extends JPanel {
    private Controller control;
    private int dimentions;
    private int[][][] cardPositions;

    public GameBoard(Controller control) {
        this.control = control;
        setMinimumSize(new Dimension(600, 600));
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
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("data/luz.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Graphics2D g2d = (Graphics2D) g;
        dimentions = control.getBoardDimentions();
        cardPositions = new int[dimentions][dimentions][2];
        boolean[][] boardDisposition = control.getBoardLights();

        int squareSize = Math.min((this.getHeight() - 20) / dimentions,
                (this.getWidth() - 20) / dimentions);

        for (int i = 0; i < dimentions; i++) {
            for (int j = 0; j < dimentions; j++) {
                g2d.setColor(boardDisposition[i][j] ? new Color(241, 173, 1) : new Color(2, 25, 36));
                g2d.fill(new RoundRectangle2D.Double((i * squareSize) + 10, (j * squareSize) + 10, squareSize - 10,
                        squareSize - 10, 15, 15));

                if (boardDisposition[i][j]) {
                    g2d.drawImage(image, (i * squareSize) + 20, (j * squareSize) + 20, squareSize - 30, squareSize - 30,
                            null);
                }
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

        // Como cada posicion guarda la posicion de la esquina superior derecha, se debe
        // sumar el tamaño de la carta
        int maxRight = cardPositions[iPos][0][0] + cardPositions[1][0][0];
        int maxBottom = cardPositions[0][jPos][1] + cardPositions[0][1][1];
        if (x > maxRight || y > maxBottom) {
            iPos = -1;
            jPos = -1;
        }

        return new int[] { iPos, jPos };
    }

}