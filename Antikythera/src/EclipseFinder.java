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

    public List<SolarEclipse> GetSolarEclipses()
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

        solarEclipses.sort(Comparator.comparing(SolarEclipse::getYear, Comparator.reverseOrder())
                .thenComparing(SolarEclipse::getMonth, Comparator.reverseOrder())
                .thenComparing(SolarEclipse::getDays, Comparator.reverseOrder())
                .thenComparing(SolarEclipse::getHours, Comparator.reverseOrder())
                .thenComparing(SolarEclipse::getMinutes, Comparator.reverseOrder())
                .thenComparing(SolarEclipse::getSeconds, Comparator.reverseOrder()));

        return solarEclipses;
    }

    public List<LunarEclipse> GetLunarEclipses()
    {
        List<LunarEclipse> lunarEclipses = new ArrayList<>();

        ResultSet rs = SqlExecutor.RunQuery("", "SELECT * FROM LunarEclipses;");

        try {
            while (rs.next())
            {
                lunarEclipses.add(SqlSerializer.LunarEclipseFromSql(rs));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }

        lunarEclipses.sort(Comparator.comparing(LunarEclipse::getYear, Comparator.reverseOrder())
                .thenComparing(LunarEclipse::getMonth, Comparator.reverseOrder())
                .thenComparing(LunarEclipse::getDays, Comparator.reverseOrder())
                .thenComparing(LunarEclipse::getHours, Comparator.reverseOrder())
                .thenComparing(LunarEclipse::getMinutes, Comparator.reverseOrder())
                .thenComparing(LunarEclipse::getSeconds, Comparator.reverseOrder()));

        return lunarEclipses;
    }

    public int GetMostRecentSolarSaros(List<SolarEclipse> eclipses)
    {
        return eclipses.size() == 0 ? -1 : eclipses.get(0).saros;
    }

    public int GetMostRecentLunarSaros(List<LunarEclipse> eclipses)
    {
        return eclipses.size() == 0 ? -1 : eclipses.get(0).saros;
    }

    public void PrintSolarEclipses(List<SolarEclipse> eclipses)
    {
        for (int i = 0; i < eclipses.size(); i++)
            System.out.println(eclipses.get(i).time.toString());

        if (eclipses.size() > 0)
            System.out.println("The most recent Solar Eclipse occured at: " + eclipses.get(0).time + ".");
    }

    public void PrintLunarEclipses(List<SolarEclipse> eclipses)
    {
        for (int i = 0; i < eclipses.size(); i++)
            System.out.println(eclipses.get(i).time.toString());

        if (eclipses.size() > 0)
            System.out.println("The most recent Lunar Eclipse occured at: " + eclipses.get(0).time + ".");
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