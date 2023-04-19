package uniandes.dpoo.taller4.view.header;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import uniandes.dpoo.taller4.modelo.Difficulty;

public class SettingsDifficultyContainer extends JPanel {
    private GameSettingsHeader observer;
    private List<GameDiffBtn> diffBtns = new ArrayList<GameDiffBtn>();

    private ItemListener btnsListener = new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            GameDiffBtn focusBtn = (GameDiffBtn) e.getItem();

            observer.setDifficulty(focusBtn.getDiff());

            // TODO Hacer que solo se vea el seleccionado
        }
    };

    public SettingsDifficultyContainer(GameSettingsHeader observer, Difficulty defaultDifficulty) {
        this.observer = observer;
        setVisible(true);
        add(new JLabel("Dificultad: "));

        for (Difficulty diff : Difficulty.values()) {
            GameDiffBtn newBtn = new GameDiffBtn(diff, btnsListener, diff.equals(defaultDifficulty));
            diffBtns.add(newBtn);
            add(newBtn);
        }

    }

    private class GameDiffBtn extends JCheckBox {
        // TODO Cambiar los JCheckBox por JRadioButton
        private Difficulty diff;

        public GameDiffBtn(Difficulty diff, ItemListener listener, boolean isFocus) {
            this.diff = diff;
            setText(diff.getName());
            addItemListener(listener);
            setSelected(isFocus);
        }

        public Difficulty getDiff() {
            return diff;
        }

    }

}