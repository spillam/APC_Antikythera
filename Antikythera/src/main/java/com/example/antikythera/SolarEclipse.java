package com.example.antikythera;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class SolarEclipse {
    public int saros, centralDuration;
    public float magnitude;
    public String type, visibility;

    public UniversalTime time;

    private final SimpleIntegerProperty Saros;
    private final SimpleFloatProperty Magnitude;
    private final SimpleStringProperty Type;
    private final SimpleStringProperty Time;

    public SolarEclipse(UniversalTime in_time, int in_saros, float in_magnitude, int in_centralDuration, String in_type, String in_visibility)
    {
        time = in_time;
        saros = in_saros;
        magnitude = in_magnitude;
        centralDuration = in_centralDuration;
        type = in_type;
        visibility = in_visibility;
        Saros = new SimpleIntegerProperty(saros);
        Magnitude = new SimpleFloatProperty(magnitude);
        Type = new SimpleStringProperty(type);
        Time = new SimpleStringProperty(time.toString().split(" ")[0]);
    }

    public int getSaros()
    {
        return saros;
    }

    public void setSaros(int value)
    {
        saros = value;
        Saros.set(value);
    }

    public float getMagnitude()
    {
        return magnitude;
    }

    public void setMagnitude(int value)
    {
        magnitude = value;
        Magnitude.set(value);
    }

    public void setTime(String value)
    {
        // Empty because we can never set time from a string, but JavaFX expects this function anyway
    }

    public String getTime()
    {
        return Time.getValue();
    }

    public int getYear()
    {
        return time.getYear();
    }

    public int getMonth()
    {
        return time.getMonth();
    }

    public int getDays()
    {
        return time.getDays();
    }

    public int getHours()
    {
        return time.getHours();
    }

    public int getMinutes()
    {
        return time.getMinutes();
    }

    public int getSeconds()
    {
        return time.getSeconds();
    }

    public String getVisibility(){
        return visibility;
    }

    public String getType(){
        return type;
    }

    public void printAll()
    {
        System.out.println("Saros: " + saros + ", Date (UDT): " + getMonth() + "/" + getDays() + "/" + getYear() + " " + getHours() + ":" + getMinutes() + ":" + getSeconds() + ", Magnitude: " + magnitude + " Central Duration: " + centralDuration + "s, Type: " + type + ", Visibility: " + visibility);
    }
}