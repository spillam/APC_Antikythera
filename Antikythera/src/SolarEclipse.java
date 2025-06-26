public class SolarEclipse {
    public int year, month, day, hours, minutes, seconds, saros, centralDuration;
    public float magnitude;
    public String type, visibility;

    public SolarEclipse(int in_year, int in_month, int in_day, int in_hours, int in_minutes, int in_seconds, int in_saros, float in_magnitude, int in_centralDuration, String in_type, String in_visibility)
    {
        year = in_year;
        month = in_month;
        day = in_day;
        hours = in_hours;
        minutes = in_minutes;
        seconds = in_seconds;
        saros = in_saros;
        magnitude = in_magnitude;
        centralDuration = in_centralDuration;
        type = in_type;
        visibility = in_visibility;
    }

    public void printAll()
    {
        System.out.println("Solar Eclipse:\nDate: " + year + "/" + month + "/" + day + " " + hours + ":" + minutes + ":" + seconds + ", Saros: " + saros + ", Magnitude: " + magnitude + " Duration: " + centralDuration + "s, Type: " + type + ", Visibility: " + visibility);
    }
}