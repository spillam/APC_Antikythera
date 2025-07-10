import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EclipseFinder {
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

    public void PredictNextEclipse()
    {

    }
}