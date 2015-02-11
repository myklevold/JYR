package gui;

import javax.swing.*;
import java.awt.*;

public class CountryPanel extends JPanel {
    private JTextField countryTextField;
    private JButton forecastButton;


    public CountryPanel() {
        setLayout(new GridLayout(1, 3));
        add(new JLabel("Please enter country"));
        add(countryTextField = new JTextField(5));
        add(forecastButton = new JButton("Forecast"));
    }

    public JTextField getCountryTextField() {
        return countryTextField;
    }

    public JButton getForecastButton() {
        return forecastButton;
    }
}
