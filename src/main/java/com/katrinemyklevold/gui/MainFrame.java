package com.katrinemyklevold.gui;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import com.katrinemyklevold.yr.*;
import org.xml.sax.SAXException;

import java.awt.event.*;
import java.io.IOException;

public class MainFrame extends JFrame {
	private ForecastPanel forecastPanel;
    private NorwayPanel norwayPanel;
    private CountryPanel countryPanel;
    private InternationalPanel internationalPanel;

	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setTitle("Forecast");
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}

	public MainFrame() {
		createCountryPanel();
	}

	private void createCountryPanel() {
		countryPanel = new CountryPanel();
		
		add(countryPanel);

        countryPanel.getForecastButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().removeAll();
                String country = countryPanel.getCountryTextField().getText();
                if (country.equalsIgnoreCase("norway")) {
                    createNorwayPanel();
                    getContentPane().add(norwayPanel);
                    repaint();
                    pack();
                    printAll(getGraphics());
                } else {
                    createInternationalPanel();
                    getContentPane().add(internationalPanel);
                    repaint();
                    pack();
                    printAll(getGraphics());
                }
			}
		});
	}

	private void createNorwayPanel() {
		norwayPanel = new NorwayPanel();

        norwayPanel.getBackNorwayButton().addActionListener(new BackActionListener());

        norwayPanel.getEnterNorwayButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String country = countryPanel.getCountryTextField().getText();
                String fylke = norwayPanel.getFylkeTxtField().getText();
                String kommune = norwayPanel.getKommuneTxtField().getText();
                String by = norwayPanel.getByTxtField().getText();

                String url = YrUrlBuilder.buildYrUrl(norwayPanel.getHourByHourForecast().isSelected(), country, fylke, kommune, by);
                setupForecast(url);
            }
        });
	}

	private void createInternationalPanel() {
		internationalPanel = new InternationalPanel();


		internationalPanel.getBackInternationalButton().addActionListener(new BackActionListener());

		internationalPanel.getEnterInternationalButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String country = countryPanel.getCountryTextField().getText();
                String state = internationalPanel.getStateTxtField().getText();
                String city = internationalPanel.getCityTxtField().getText();

                String url = YrUrlBuilder.buildYrUrl(internationalPanel.getHourByHourForecast().isSelected(), country, state, city);
                setupForecast(url);
            }
        });
	}

    private void setupForecast(String url) {
        try {
            showForecast(url);
        } catch (XPathExpressionException | IOException
                | ParserConfigurationException | SAXException e1) {
            // TODO Deal with errors
            e1.printStackTrace();
        }

        getContentPane().removeAll();
        getContentPane().add(forecastPanel);
        repaint();
        pack();
        printAll(getGraphics());
    }



	private void showForecast(String url) throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
		Forecast forecast = new ForecastFetcher().fetchForecast(url);
		forecastPanel = new ForecastPanel(forecast);


		forecastPanel.getNewPlaceButton().addActionListener(new BackActionListener());
	}

    private class BackActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            getContentPane().removeAll();
            getContentPane().add(countryPanel);
            repaint();
            pack();
            printAll(getGraphics());
        }
    }
}