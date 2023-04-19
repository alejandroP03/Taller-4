package uniandes.dpoo.taller4.view.header;

import javax.swing.JPanel;

import uniandes.dpoo.taller4.controller.Controller;
import uniandes.dpoo.taller4.modelo.Difficulty;
import uniandes.dpoo.taller4.view.main.GameBoard;

public class GameSettingsHeader extends JPanel {
    Controller control;
    GameBoard board;

    public GameSettingsHeader(Controller control, GameBoard board) {
        this.control = control;
        this.board = board;
        add(new SettingsBoardSizeContainer(this, control.getBoardDimentions()));
        add(new SettingsDifficultyContainer(this, control.getDifficulty()));
    }

    public void setBoardSize(int newBoardSize) {
        control.setBoardDimentions(newBoardSize);
        control.newGame();

    }

    public void setDifficulty(Difficulty newDiff) {
        control.setDifficulty(newDiff);
        control.newGame();
    }

}
