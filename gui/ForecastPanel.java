package gui;

import yr.Forecast;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ForecastPanel extends JPanel {
    private JButton newPlaceButton;

    public ForecastPanel(Forecast forecast) {
        setLayout(new GridLayout(3, 1));

        JPanel creditPanel = new JPanel();
        creditPanel.setLayout(new GridLayout(2,1));
        creditPanel.add(new JLabel(forecast.getCredit()));
        creditPanel.add(new JLabel(forecast.getCreditLink()));

        JPanel middlePanel = new JPanel();
        JPanel locationPanel = new JPanel();
        middlePanel.setLayout(new GridLayout(1, 2));
        locationPanel.setLayout(new GridLayout(4, 1));

        locationPanel.add(new JLabel(forecast.getName()));
        locationPanel.add(new JLabel(forecast.getCountry()));
        locationPanel.add(new JLabel("Timezone: " + forecast.getTimeZone()));
        locationPanel.add(new JLabel("Altitude: " + forecast.getAltitude() + " moh"));

        TitledBorder title;
        title = BorderFactory.createTitledBorder("Location");
        locationPanel.setBorder(title);
        newPlaceButton = new JButton("New Place");
        newPlaceButton.setPreferredSize(new Dimension(25, 30));

        middlePanel.add(locationPanel);
        middlePanel.add(newPlaceButton);

        add(creditPanel);
        add(middlePanel);

        //Table start
        int listOfTimesSize = forecast.getListOfTimes().size();

        String[] columnNames = {"From", "To", "Temperature", "Wind Direction", "WindSpeed"};
        Object[][] forecastData = new Object[listOfTimesSize][columnNames.length];

        for(int row = 0; row < forecastData.length; ++row) {
            for(int c = 0; c < forecastData[row].length; ++c) {
                //forecastData[row][c] = input.nextInt();
                switch (c) {
                    case 0:
                        forecastData[row][c] = forecast.getListOfTimes().get(row).getFrom();
                        break;
                    case 1:
                        forecastData[row][c] = forecast.getListOfTimes().get(row).getTo();
                        break;
                    case 2:
                        forecastData[row][c] = forecast.getListOfTimes().get(row).getTemperatureValue() + " " +
                                forecast.getListOfTimes().get(row).getTemperatureUnit();
                        break;
                    case 3:
                        forecastData[row][c] = forecast.getListOfTimes().get(row).getWindDirection();
                        break;
                    case 4:
                        forecastData[row][c] = forecast.getListOfTimes().get(row).getWindSpeedMPS() + " mps, " +
                                forecast.getListOfTimes().get(row).getWindSpeedTxt();
                        break;
                    default:
                        break;
                }
            }
        }

        final JTable table = new JTable(forecastData, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 500));
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);

        add(creditPanel);
        add(middlePanel);
        add(scrollPane);

    }

    public JButton getNewPlaceButton() {
        return newPlaceButton;
    }
}
