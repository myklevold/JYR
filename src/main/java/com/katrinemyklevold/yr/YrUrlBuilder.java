package com.katrinemyklevold.yr;

public class YrUrlBuilder {
    private YrUrlBuilder() {}

    private static final String startURL = "http://www.yr.no/place/";

    public static String buildYrUrl(boolean hourByHourForecast, String... urlParts) {
        String endUrl;
        if (hourByHourForecast) {
            endUrl = "forecast_hour_by_hour.xml";
        } else {
            endUrl = "forecast.xml";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(startURL);

        for (String urlPart : urlParts) {
            stringBuilder.append(urlPart);
            stringBuilder.append("/");
        }

        stringBuilder.append(endUrl);

        return stringBuilder.toString();
    }
}
