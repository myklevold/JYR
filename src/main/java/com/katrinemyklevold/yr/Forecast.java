package com.katrinemyklevold.yr;

import java.util.List;

public class Forecast {
	private String credit;
	private String creditLink;
	private String name;
	private String country; 
	private String timeZone;
	private String altitude;
	private List<Time> listOfTimes;

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCreditLink() {
        return creditLink;
    }

    public void setCreditLink(String creditLink) {
        this.creditLink = creditLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public List<Time> getListOfTimes() {
        return listOfTimes;
    }

    public void setListOfTimes(List<Time> listOfTimes) {
        this.listOfTimes = listOfTimes;
    }
}
