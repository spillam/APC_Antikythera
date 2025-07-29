package com.example.antikythera;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlSerializer {
    /*public static String StudentToSql(Student student, String tableName) {
        String sp = ", ";
        return "INSERT INTO STUDENTS VALUES (" +
                student.GetID() + sp +
                student.GetFirstName() + sp +
                student.GetLastName() + sp +
                student.GetGraduationYear() + sp +
                student.GetMajor() + sp +
                student.GetEmail() + ");";
    }

    */

    /*
    public static Student StudentFromSql(ResultSet rs)
    {
        try {
            String name = rs.getString("NAME"),
                    surname = rs.getString("SURNAME"),
                    id = rs.getString("ID"),
                    major = rs.getString("MAJOR"),
                    email = rs.getString("EMAIL");

            int gradYear = rs.getInt("GRADYEAR");

            return new Student(name, surname, id, gradYear, major, email);
        } catch (SQLException e) {
            System.out.println("Error parsing Student object. " + e);
            return null;
        }
    }*/

    public static LunarEclipse LunarEclipseFromSql(ResultSet rs) {
        try {
            int year = rs.getInt("Year");
            int month = rs.getInt("Month");
            int day = rs.getInt("Day");
            int hours = rs.getInt("Hours");
            int minutes = rs.getInt("Minutes");
            int seconds = rs.getInt("Seconds");
            int saros = rs.getInt("Saros");
            float magnitude = rs.getFloat("Magnitude");
            int centralDuration = rs.getInt("CentralD");
            String type = rs.getString("Type");
            String visibility = rs.getString("Visibility");
            UniversalTime time = new UniversalTime(year, month, day, hours, minutes, seconds);
            return new LunarEclipse(time, saros, magnitude, centralDuration, type, visibility);
        } catch (SQLException e) {
            System.out.println("Error parsing Lunar Eclipse object. " + e);
            return null;
        }
    }

    public static SolarEclipse SolarEclipseFromSql(ResultSet rs) {
        try {
            int year = rs.getInt("Year");
            int month = rs.getInt("Month");
            int day = rs.getInt("Day");
            int hours = rs.getInt("Hours");
            int minutes = rs.getInt("Minutes");
            int seconds = rs.getInt("Seconds");
            int saros = rs.getInt("Saros");
            float magnitude = rs.getFloat("Magnitude");
            int centralDuration = rs.getInt("CentralD");
            String type = rs.getString("Type");
            String visibility = rs.getString("Visibility");
            UniversalTime time = new UniversalTime(year, month, day, hours, minutes, seconds);
            return new SolarEclipse(time, saros, magnitude, centralDuration, type, visibility);
        } catch (SQLException e) {
            System.out.println("Error parsing Solar Eclipse object. " + e);
            return null;
        }
    }
}