package uniandes.dpoo.taller4.view.header;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsBoardSizeContainer extends JPanel {
    private Map<String, Integer> boardDimMap = new HashMap<String, Integer>(
            Map.of("5X5", 5, "7X7", 7, "10X10", 10, "12X12", 12));
    private JComboBox<String> sizeSelector = new JComboBox<String>(
            Arrays.copyOf(boardDimMap.keySet().toArray(), boardDimMap.keySet().size(), String[].class));

    public SettingsBoardSizeContainer(GameSettingsHeader observer, int defaultSize) {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(new JLabel("Tamaño"));

        sizeSelector.setSelectedItem(defaultSize + "X" + defaultSize);
        sizeSelector.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                observer.setBoardSize(boardDimMap.get(e.getItem().toString()));
            }

        });
        add(sizeSelector);
    }

}