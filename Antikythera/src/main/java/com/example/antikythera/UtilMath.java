package com.example.antikythera;

import java.lang.Math;
import java.time.ZoneId;
import java.util.Scanner;


public class UtilMath {

    //Constants
    //pi = Math.PI;
    public static double radeg = 180/Math.PI;

    //Trig. functions
    //arcsin = Math.asin(double a)
    //arccos = Math.acos(double a)
    //arctan = Math.atan(double a)
    //sin = Math.sin(double a)
    //cos = Math.cos(double a)
    //tan = Math.tan(double a)

    //Trig. functions in degrees
    public static double sind(double x) { return Math.sin(x/radeg); }
    public static double cosd(double x) { return Math.cos(x/radeg); }
    public static double tand(double x) { //degrees tan
        return Math.tan(x/radeg);
    }
    //Trig. arc functions in degrees
    public static double asind(double x) { return radeg*Math.asin(x); }
    public static double acosd(double x) { return 90 - Math.acos(x); }
    public static double atand(double x) { return radeg*Math.atan(x); }

    //arctan in all four quadrants
    public static double atan2(double x, double y) {
        if(x < 0) { //atan(y/x) - pi*(x<0)
            return (Math.atan(y/x)) - (Math.PI*x);
        }
        else {
            return 0; //this does not work, x has to be less than 0, but we need to return something if it isn't
        }
    }

    public static double atan2d(double y, double x) {
        //return radeg*(Math.atan(y/x)) - (180 - (Math.PI*x));
        return Math.toDegrees(Math.atan2(y, x));
    }

    //Normalize an angle between 0 and 360 degrees
    public static double fnrev(double x) {
        //x = x % 360;
        while (x < 0) {
            x += 360;
        }
        return x;
    }


    //Cube Root = Math.cbrt(double x)

    //compute d (Julian Dates)
    //Parameters are in Universal Time
    //The parameters will be user input, which they will enter in whatever timezone they choose
    public static double d() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("On what date do you want to find the planet's information?");

        System.out.print("Year: ");
        int year = scanner.nextInt();

        System.out.print("Month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Day: ");
        int day = scanner.nextInt();

        /*
        System.out.print("Hour (0-23): ");
        int hour = scanner.nextInt();

        System.out.print("Minute (0-59): ");
        int minute = scanner.nextInt();

        System.out.print("Second (0-59): ");
        int second = scanner.nextInt();
*/

        //these numbers aren't need for Julian Dates computation
        int hour = 0;
        int minute = 0;
        int second = 0;

        System.out.println("What timezone are you in?");
        System.out.println("Select Timezone: (1) Eastern, (2) Central, (3) Mountain, (4) Pacific");
        int tzChoice = scanner.nextInt();

        ZoneId zoneId;

        switch (tzChoice) {
            case 1: zoneId = ZoneId.of("America/New_York"); break;
            case 2: zoneId = ZoneId.of("America/Chicago"); break;
            case 3: zoneId = ZoneId.of("America/Denver"); break;
            case 4: zoneId = ZoneId.of("America/Los_Angeles"); break;
            default:
                System.out.println("Invalid timezone selection. Defaulting to GMT.");
                zoneId = ZoneId.of("GMT");
        }

        //convert the users inputted time (and the time should have been converted) into UTC
        UniversalTime ut = new UniversalTime(year, month, day, hour, minute, second, zoneId);

        //get UTC values
        int y = ut.getYear();
        int m = ut.getMonth();
        int day_calc = ut.getDays();

        //there is some weird stuff with months 1 and 2
        if (m <= 2) {
            y--;
            m += 12;
        }


        double d = 367 * y - (7*(y + ((m+9)/12)))/4 + (275*m)/9 + day_calc - 730530;

        return d;
    }






}
