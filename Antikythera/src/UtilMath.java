import java.lang.Object;
import java.lang.Math;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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

    public static double atan2d(double x, double y) {
        return radeg*(Math.atan(y/x)) - (180 - (Math.PI*x));
    }

    //Normalize an angle between 0 and 360 degrees
    public static double fnrev(double x) {
        x = x % 360;
        //if (x < 0) x += 360;
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

        System.out.print("Hour (0-23): ");
        int hour = scanner.nextInt();

        System.out.print("Minute (0-59): ");
        int minute = scanner.nextInt();

        System.out.print("Second (0-59): ");
        int second = scanner.nextInt();

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

        // Convert input time to UTC using your UniversalTime class
        UniversalTime ut = new UniversalTime(year, month, day, hour, minute, second, zoneId);

        // Get UTC values
        int y = ut.getYear();
        int m = ut.getMonth();
        int d = ut.getDays();
        int h = ut.getHours();
        int min = ut.getMinutes();
        int sec = ut.getSeconds();

        // Julian Day Number calculation (with time of day)
        if (m <= 2) {
            y--;
            m += 12;
        }

        double a = Math.floor(y / 100.0);
        double b = 2 - a + Math.floor(a / 4.0);

        double dayFraction = (h + min / 60.0 + sec / 3600.0) / 24.0;

        double jd = Math.floor(365.25 * (y + 4716)) + Math.floor(30.6001 * (m + 1)) + d + b - 1524.5 + dayFraction;

        // Return days since J2000.0 (Jan 1, 2000 at 12:00 TT), which is JD 2451545.0
        return jd - 2451545.0;
    }






}
