package uniandes.dpoo.taller4.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import uniandes.dpoo.taller4.modelo.Difficulty;
import uniandes.dpoo.taller4.modelo.RegistroTop10;
import uniandes.dpoo.taller4.modelo.Tablero;
import uniandes.dpoo.taller4.modelo.Top10;
import uniandes.dpoo.taller4.view.GameWindow;

public class Controller {

    private GameWindow window;

    // DEFAULT VALUES
    private int boardDimentions = 5;
    private Difficulty difficulty = Difficulty.EASY;
    private String activePlayer = "Unknown Player";

    private Tablero board = new Tablero(getBoardDimentions());
    private Top10 top10 = new Top10();

    public Controller(GameWindow window) {
        this.window = window;
        top10.cargarRecords(new File("data/top10.csv"));
    }

    public String getActivePlayer() {
        return activePlayer;
    }

    public int getBoardDimentions() {
        return boardDimentions;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void updateGameTries() {
        window.getBody().updateGameTries(board.darJugadas());
    }

    public void setActivePlayer(String activePlayer) {
        this.activePlayer = activePlayer;
    }

    public void setBoardDimentions(int boardDimentions) {
        this.boardDimentions = boardDimentions;
        this.board = new Tablero(getBoardDimentions());
        window.repaint();
        window.revalidate();
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        window.repaint();
        window.revalidate();
    }

    public boolean[][] getBoardLights() {
        return board.darTablero();
    }

    public void play(int x, int y) throws FileNotFoundException, UnsupportedEncodingException {
        if (x != -1 && y != -1) {
            board.jugar(x, y);
            this.updateGameTries();
            window.repaint();
            window.revalidate();
            this.isWin();
        }
    }

    public void isWin() throws FileNotFoundException, UnsupportedEncodingException {
        if (board.tableroIluminado()) {
            top10.agregarRegistro(activePlayer, board.calcularPuntaje());
            window.showWinMessage();
            this.saveTop10();
        }
    }

    public void newGame() {
        board = new Tablero(boardDimentions);
        board.desordenar(difficulty.getNumOfMoves() * boardDimentions);
        board.salvar_tablero();
        window.repaint();
        window.revalidate();
    }

    public void restartGame() {
        board.reiniciar();
        this.updateGameTries();
        window.repaint();
        window.revalidate();
    }

    public void saveTop10() throws FileNotFoundException, UnsupportedEncodingException {
        top10.salvarRecords(new File("data/top10.csv"));
    }

    public Collection<RegistroTop10> getTop10() {
        return top10.darRegistros();
    }
}