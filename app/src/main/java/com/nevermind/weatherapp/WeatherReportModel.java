package com.nevermind.weatherapp;

public class WeatherReportModel {


    private String datetime;
    private float datetimeEpoch;
    private float tempmax;
    private float tempmin;
    private float temp;
    private float feelslikemax;
    private float feelslikemin;
    private float feelslike;
    private float dew;
    private float humidity;
    private float windgust;
    private float windspeed;
    private String sunrise;
    private String sunset;
    private String conditions;
    private String description;

    public WeatherReportModel(String datetime, float datetimeEpoch, float tempmax, float tempmin, float temp, float feelslikemax, float feelslikemin, float feelslike, float dew, float humidity, float windgust, float windspeed, String sunrise, String sunset, String conditions, String description) {
        this.datetime = datetime;
        this.datetimeEpoch = datetimeEpoch;
        this.tempmax = tempmax;
        this.tempmin = tempmin;
        this.temp = temp;
        this.feelslikemax = feelslikemax;
        this.feelslikemin = feelslikemin;
        this.feelslike = feelslike;
        this.dew = dew;
        this.humidity = humidity;
        this.windgust = windgust;
        this.windspeed = windspeed;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.conditions = conditions;
        this.description = description;
    }

    public WeatherReportModel() {
    }


    @Override
    public String toString() {
        return
                " Date: " + datetime + "\n" +
                " Current: " + temp + "\n" +
                " Max Temp: " + tempmax + "\n" +
                " Min Temp: " + tempmin + "\n" +
                " Feels Like: " + feelslike + "\n" +
                " Sunrise: " + sunrise + "\n" +
                " Sunset: " + sunset + "\n" +
                " Weather Description : " + description + "\n" +
                " Weather Conditions: " + conditions;
    }

    public String getDate() {
        return datetime;
    }

    public void setDate(String date) {
        this.datetime = date;
    }

    public float getDatetimeEpoch() {
        return datetimeEpoch;
    }

    public void setDatetimeEpoch(float datetimeEpoch) {
        this.datetimeEpoch = datetimeEpoch;
    }

    public float getTempmax() {
        return tempmax;
    }

    public void setTempmax(float tempmax) {
        this.tempmax = tempmax;
    }

    public float getTempmin() {
        return tempmin;
    }

    public void setTempmin(float tempmin) {
        this.tempmin = tempmin;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeelslikemax() {
        return feelslikemax;
    }

    public void setFeelslikemax(float feelslikemax) {
        this.feelslikemax = feelslikemax;
    }

    public float getFeelslikemin() {
        return feelslikemin;
    }

    public void setFeelslikemin(float feelslikemin) {
        this.feelslikemin = feelslikemin;
    }

    public float getFeelslike() {
        return feelslike;
    }

    public void setFeelslike(float feelslike) {
        this.feelslike = feelslike;
    }

    public float getDew() {
        return dew;
    }

    public void setDew(float dew) {
        this.dew = dew;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getWindgust() {
        return windgust;
    }

    public void setWindgust(float windgust) {
        this.windgust = windgust;
    }

    public float getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(float windspeed) {
        this.windspeed = windspeed;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}