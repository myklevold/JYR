package com.katrinemyklevold.yr;

public class Time {
	private String from;
	private String to;
	private String temperatureUnit;
	private int temperatureValue;
	private String windDirection;
	private double windSpeedMPS;
	private String windSpeedTxt;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getTemperatureUnit() {
		return temperatureUnit;
	}
	public void setTemperatureUnit(String temperatureUnit) {
		this.temperatureUnit = temperatureUnit;
	}
	public int getTemperatureValue() {
		return temperatureValue;
	}
	public void setTemperatureValue(int temperatureValue) {
		this.temperatureValue = temperatureValue;
	}
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windirection) {
		this.windDirection = windirection;
	}
	public double getWindSpeedMPS() {
		return windSpeedMPS;
	}
	public void setWindSpeedMPS(double windSpeedMPS) {
		this.windSpeedMPS = windSpeedMPS;
	}
	public String getWindSpeedTxt() {
		return windSpeedTxt;
	}
	public void setWindSpeedTxt(String windSpeedTxt) {
		this.windSpeedTxt = windSpeedTxt;
	}
}
