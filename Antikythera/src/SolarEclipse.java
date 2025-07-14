public class SolarEclipse {
    public int saros, centralDuration;
    public float magnitude;
    public String type, visibility;

    public UniversalTime time;

    public SolarEclipse(UniversalTime in_time, int in_saros, float in_magnitude, int in_centralDuration, String in_type, String in_visibility)
    {
        time = in_time;
        saros = in_saros;
        magnitude = in_magnitude;
        centralDuration = in_centralDuration;
        type = in_type;
        visibility = in_visibility;
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
        System.out.println("Date: " + getMonth() + "/" + getDays() + "/" + getYear() + " " + getHours() + ":" + getMinutes() + ":" + getSeconds() + ", Saros: " + saros + ", Magnitude: " + magnitude + " Duration: " + centralDuration + "s, Type: " + type + ", Visibility: " + visibility);
    }
}