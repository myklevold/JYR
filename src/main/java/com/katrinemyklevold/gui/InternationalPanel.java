package com.katrinemyklevold.gui;

import javax.swing.*;
import java.awt.*;

public class InternationalPanel extends JPanel {
    private final JTextField stateTxtField;
    private final JTextField cityTxtField;
    private final JCheckBox hourByHourForecast;
    private final JButton backInternationalButton;
    private final JButton enterInternationalButton;

    public InternationalPanel() {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("State"));
        add(stateTxtField = new JTextField(5));
        add(new JLabel("City"));
        add(cityTxtField = new JTextField(5));
        add(hourByHourForecast = new JCheckBox("Hour-By-Hour Forecast"));
        add(new JLabel(""));
        add(backInternationalButton = new JButton("Back"));
        add(enterInternationalButton = new JButton("Enter"));
    }

    public JTextField getStateTxtField() {
        return stateTxtField;
    }

    public JTextField getCityTxtField() {
        return cityTxtField;
    }

    public JCheckBox getHourByHourForecast() {
        return hourByHourForecast;
    }

    public JButton getBackInternationalButton() {
        return backInternationalButton;
    }

    public JButton getEnterInternationalButton() {
        return enterInternationalButton;
    }
}
