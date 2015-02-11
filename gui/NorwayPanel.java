package gui;

import javax.swing.*;
import java.awt.*;

public class NorwayPanel extends JPanel {


    private final JTextField fylkeTxtField;
    private final JTextField kommuneTxtField;
    private final JTextField byTxtField;
    private final JCheckBox hourByHourForecast;
    private final JButton backNorwayButton;
    private final JButton enterNorwayButton;

    public NorwayPanel() {
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Fylke"));
        add(fylkeTxtField = new JTextField(5));
        add(new JLabel("Kommune"));
        add(kommuneTxtField = new JTextField(5));
        add(new JLabel("By"));
        add(byTxtField = new JTextField(5));
        add(hourByHourForecast = new JCheckBox("Hour-By-Hour Forecast"));
        add(new JLabel(""));
        add(backNorwayButton = new JButton("Back"));
        add(enterNorwayButton = new JButton("Enter"));
    }

    public JTextField getFylkeTxtField() {
        return fylkeTxtField;
    }

    public JTextField getKommuneTxtField() {
        return kommuneTxtField;
    }

    public JTextField getByTxtField() {
        return byTxtField;
    }

    public JCheckBox getHourByHourForecast() {
        return hourByHourForecast;
    }

    public JButton getBackNorwayButton() {
        return backNorwayButton;
    }

    public JButton getEnterNorwayButton() {
        return enterNorwayButton;
    }
}
