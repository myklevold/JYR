package yr;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.*;


public class ForecastFetcher {

	public Forecast fetchForecast(String stringUrl) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
		URL url = new URL(stringUrl);
		InputStream stream = url.openStream();
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(stream);

		Forecast forecast = new Forecast();

		//jumps into the credit tag in the xml to search for link
		//we do this because other tags may also be named link and we want the one in the credit tag
		Node credit = getNodeByXpath("/weatherdata/credit", doc);
		Node creditText = getNodeByXpath("link/@text", credit);
		Node creditLink = getNodeByXpath("link/@url", credit);

		forecast.setCredit(creditText.getTextContent());
		forecast.setCreditLink(creditLink.getTextContent());

		//jumps into the location tag in the xml to search for name, country and timezoneid 
		//we do this because other tags may also be named name, country etc and we want the ones in the location tag
		Node location = getNodeByXpath("/weatherdata/location", doc); 
		Node name = getNodeByXpath("name", location);
		Node country = getNodeByXpath("country", location);
		Node timeZoneId = getNodeByXpath("timezone/@id", location);
		Node altitude = getNodeByXpath("location/@altitude", location);

		forecast.setName(name.getTextContent());
		forecast.setCountry(country.getTextContent());
		forecast.setTimeZone(timeZoneId.getTextContent());
		forecast.setAltitude(altitude.getTextContent());

		//jumps into the tabular tag in the xml to search for times 
		//we do this because other tags may also be named times etc and we want the ones in the tabular tag
		Node tabular = getNodeByXpath("/weatherdata/forecast/tabular", doc);
		NodeList times = getNodesByXpath("time", tabular);

		List<Time> listOfTimes = new ArrayList<>();

		for(int i = 0; i < times.getLength(); ++i) {
			Time currentTime = new Time();
			Node currentTimeNode = times.item(i);
			currentTime.setFrom(currentTimeNode.getAttributes().getNamedItem("from").getNodeValue());
			currentTime.setTo(currentTimeNode.getAttributes().getNamedItem("to").getNodeValue());

			//temperature unit & value
			Node temperatureNode = getNodeByXpath("temperature", currentTimeNode);
			int temperatureValue = Integer.valueOf(temperatureNode.getAttributes().getNamedItem("value").getNodeValue());
			String unit = temperatureNode.getAttributes().getNamedItem("unit").getNodeValue();
			currentTime.setTemperatureValue(temperatureValue);
			currentTime.setTemperatureUnit(unit);

			//winddirection
			Node windDirectionNode = getNodeByXpath("windDirection", currentTimeNode);
			String windDirection = windDirectionNode.getAttributes().getNamedItem("name").getNodeValue();
			currentTime.setWindDirection(windDirection);

			//windSpeed mps & txt
			Node windSpeedNode = getNodeByXpath("windSpeed", currentTimeNode);
			double windSpeedValue = Double.valueOf(windSpeedNode.getAttributes().getNamedItem("mps").getNodeValue());
			String windSpeedTxt = windSpeedNode.getAttributes().getNamedItem("name").getNodeValue();
			currentTime.setWindSpeedMPS(windSpeedValue);
			currentTime.setWindSpeedTxt(windSpeedTxt);

			listOfTimes.add(currentTime);
		}
		forecast.setListOfTimes(listOfTimes);

		return forecast;
	}


	private static Node getNodeByXpath(String xpath, Node document) throws XPathExpressionException {
		XPath xPath = XPathFactory.newInstance().newXPath();
        return (Node) xPath.evaluate(xpath, document, XPathConstants.NODE);
	}

	private static NodeList getNodesByXpath(String xpath, Node document) throws XPathExpressionException {
		XPath xPath = XPathFactory.newInstance().newXPath();
        return (NodeList) xPath.evaluate(xpath, document, XPathConstants.NODESET);
	}
}
