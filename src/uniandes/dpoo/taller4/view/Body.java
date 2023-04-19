package uniandes.dpoo.taller4.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.controller.Controller;
import uniandes.dpoo.taller4.view.footer.GameDataFooter;
import uniandes.dpoo.taller4.view.header.GameSettingsHeader;
import uniandes.dpoo.taller4.view.main.GameBoard;
import uniandes.dpoo.taller4.view.sidebar.GameOptionsSidebar;

public class Body extends JPanel {
    private Controller control;
    private GameBoard board;
    private GameSettingsHeader header;
    private GameOptionsSidebar sidebar;
    private GameDataFooter footer;

    public Body(Controller newControl) {
        control = newControl;
        control.newGame();
        footer = new GameDataFooter(control);
        board = new GameBoard(control);
        header = new GameSettingsHeader(control, board);
        sidebar = new GameOptionsSidebar(control, footer);

        setLayout(new GridBagLayout());

        GridBagConstraints gridParams = new GridBagConstraints();

        gridParams.gridx = 0;
        gridParams.gridy = 0;
        gridParams.gridwidth = 3;
        gridParams.fill = GridBagConstraints.HORIZONTAL;
        add(header, gridParams);

        gridParams.gridx = 2;
        gridParams.gridy = 1;
        gridParams.gridwidth = 1;
        gridParams.weightx = .15;
        gridParams.weighty = .75;
        gridParams.fill = GridBagConstraints.BOTH;
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        add(sidebar, gridParams);

        gridParams.gridx = 0;
        gridParams.gridy = 1;
        gridParams.gridwidth = 2;
        gridParams.weightx = .85;
        add(board, gridParams);

        gridParams.gridy = 2;
        gridParams.gridwidth = 3;
        gridParams.weighty = 0;
        gridParams.weightx = 1;
        gridParams.fill = GridBagConstraints.HORIZONTAL;
        footer.setLayout(new BoxLayout(footer, BoxLayout.X_AXIS));
        add(footer, gridParams);
    }

    public void updateGameTries(int tries) {
        footer.updateTries(tries);
    }

}
