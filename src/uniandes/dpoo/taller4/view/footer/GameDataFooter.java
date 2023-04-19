package uniandes.dpoo.taller4.view.footer;

import javax.swing.Box;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.controller.Controller;

public class GameDataFooter extends JPanel {
    private TriesContainer triesContainer;
    private PlayerNameContainer playerNameContainer;

    public GameDataFooter(Controller control) {
        triesContainer = new TriesContainer(control);
        playerNameContainer = new PlayerNameContainer(control);
        add(triesContainer);
        add(Box.createHorizontalGlue());
        add(playerNameContainer);
    }

    public void updateTries(int tries) {
        this.triesContainer.setTriesValue(tries);
    }

    public void switchPlayer() {
        this.playerNameContainer.allowSwitchPlayer();
    }
}
