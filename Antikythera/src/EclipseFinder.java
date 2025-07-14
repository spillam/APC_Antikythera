import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EclipseFinder {

    static double SarosCycle = 6585.3211;
    static double ThreeSarosCycles = SarosCycle * 3.0;
    static double SarosCycleLeftoverSeconds = 27743.04;
    static double ThreeSarosCycleLeftoverSeconds = SarosCycleLeftoverSeconds * 3;

    public List<SolarEclipse> GetEclipses()
    {
        List<SolarEclipse> solarEclipses = new ArrayList<>();

        ResultSet rs = SqlExecutor.RunQuery("", "SELECT * FROM SolarEclipses;");

        try {
            while (rs.next())
            {
                solarEclipses.add(SqlSerializer.SolarEclipseFromSql(rs));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

        solarEclipses.sort(Comparator.comparing(SolarEclipse::getYear)
                .thenComparing(SolarEclipse::getMonth)
                .thenComparing(SolarEclipse::getDays)
                .thenComparing(SolarEclipse::getHours)
                .thenComparing(SolarEclipse::getMinutes)
                .thenComparing(SolarEclipse::getSeconds));

        return solarEclipses;
    }

    static void NextSameEclipse(SolarEclipse pastEclipse) {

        UniversalTime solarUT = new UniversalTime(pastEclipse.getYear(), pastEclipse.getMonth(), pastEclipse.getDays(),
                pastEclipse.getHours(), pastEclipse.getMinutes(), pastEclipse.getSeconds());

        System.out.println("Anchor year (from past eclipse): " + solarUT.getYear());
        System.out.println("Anchor month (from past eclipse): " + solarUT.getMonth());
        System.out.println("Anchor day (from past eclipse): " + solarUT.getDays());
        System.out.println("Anchor hour (from past eclipse): " + solarUT.getHours());
        System.out.println("Anchor minute (from past eclipse): " + solarUT.getMinutes());
        System.out.println("Anchor second (from past eclipse): " + solarUT.getSeconds());

        solarUT.addSeconds((int) ThreeSarosCycleLeftoverSeconds);
        solarUT.addDays((int) ThreeSarosCycles);
        /*
        System.out.println("Year of next same eclipse in same location: " + solarUT.getYear());
        System.out.println("Month of next same eclipse in same location: " + solarUT.getMonth());
        System.out.println("Day of next same eclipse in same location: " + solarUT.getDays());
        System.out.println("Hour of next same eclipse in same location: " + solarUT.getHours());
        System.out.println("Minute of next same eclipse in same location: " + solarUT.getMinutes());
        System.out.println("Second of next same eclipse in same location: " + solarUT.getSeconds());
         */

        System.out.println("The next solar eclipse in approximately the same location (likely visible in: " + pastEclipse.getVisibility() + ") will occur on "
                + solarUT.getMonth() + "/" + solarUT.getDays() + "/" + solarUT.getYear() + " (MM/DD/YEAR) and will likely be " + pastEclipse.getType());

    }

    static void NextSameEclipse(LunarEclipse pastEclipse) {

        UniversalTime lunarUT = new UniversalTime(pastEclipse.getYear(), pastEclipse.getMonth(), pastEclipse.getDays(),
                pastEclipse.getHours(), pastEclipse.getMinutes(), pastEclipse.getSeconds());

        System.out.println("Anchor year (from past eclipse): " + lunarUT.getYear());
        System.out.println("Anchor month (from past eclipse): " + lunarUT.getMonth());
        System.out.println("Anchor day (from past eclipse): " + lunarUT.getDays());
        System.out.println("Anchor hour (from past eclipse): " + lunarUT.getHours());
        System.out.println("Anchor minute (from past eclipse): " + lunarUT.getMinutes());
        System.out.println("Anchor second (from past eclipse): " + lunarUT.getSeconds());

        lunarUT.addSeconds((int) ThreeSarosCycleLeftoverSeconds);
        lunarUT.addDays((int) ThreeSarosCycles);


        System.out.println("The next lunar eclipse in approximately the same location (likely visible in: " + pastEclipse.getVisibility() + ") will occur on "
                + lunarUT.getMonth() + "/" + lunarUT.getDays() + "/" + lunarUT.getYear() + " (MM/DD/YEAR) and will likely be " + pastEclipse.getType());

    }

    public void PredictNextSolarEclipse()
    {

    }
}