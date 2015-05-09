package com.katrinemyklevold.yr;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

public class ForecastFetcherIntegrationTest {
	private Forecast forecast;
	
	@Before
	public void beforeTests() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
		ForecastFetcher forecastFetcher = new ForecastFetcher();
		
		String externalUrlPerhaps = this.getClass().getResource("kongsberg.xml").toExternalForm();
		forecast = forecastFetcher.fetchForecast(externalUrlPerhaps);
	}
	
	@Test
	public void fetchTest() throws XPathExpressionException, IOException, ParserConfigurationException, SAXException {
		assertNotNull(forecast);
	}
	
	@Test
	public void creditTest() {
		assertEquals(forecast.getCredit(), "Værvarsel fra yr.no, levert av NRK og Meteorologisk institutt");
		assertEquals(forecast.getCreditLink(), "http://www.yr.no/sted/Norge/Buskerud/Kongsberg/Kongsberg/");
	}
	
	@Test 
	public void nameTest() {
		assertEquals(forecast.getName(), "Kongsberg");
	}
	
	@Test
	public void countryTest() {
		assertEquals(forecast.getCountry(), "Norge");
	}
	
	@Test 
	public void timeZoneTest() {
		assertEquals(forecast.getTimeZone(), "Europe/Oslo");
	}
	
	@Test
	public void altitudeTest() {
		assertEquals(forecast.getAltitude(), "164");
	}
	
	@Test
	public void listOfTimesTest() {
		assertEquals(forecast.getListOfTimes().size(), 36);
		Time firstTime =  forecast.getListOfTimes().get(0);
		assertEquals(firstTime.getFrom(), "2015-05-09T18:00:00");
		assertEquals(firstTime.getTo(), "2015-05-10T00:00:00");
		assertEquals(firstTime.getTemperatureUnit(), "celsius");
		assertEquals(firstTime.getTemperatureValue(), 4);
		assertEquals(firstTime.getWindDirection(), "Vest-sørvest");
		assertEquals(firstTime.getWindSpeedMPS(), 1.2, 0.001);
		assertEquals(firstTime.getWindSpeedTxt(), "Flau vind");
	}
}


