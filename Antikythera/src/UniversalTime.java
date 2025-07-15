import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

// How to use:
// Universal time represents GMT time (London time). To convert a time from a timezone, please use the first construtor.
// Create a ZonedDateTime object for the parameter. I posted some links in the discord to the documentation for ZonedDateTime and ZoneId.
// This will AUTOMATICALLY convert it to universal time.

// You can then do operations like adding days, hours, minutes, seconds, etc. To add months or years, convert them into days
// so that the math doesn't screw up.

// You can also get the year, month, day, hours, etc. directly from this object using getYear(), getMonth(), getDay(), etc.

// If you want to convert the universal time to another Time Zone, please use the ToZonedDate() function at the bottom.
// Happy time travelling! - Ethan

public class UniversalTime {
    int year, month, day, hour, minute, second;

    public UniversalTime(ZonedDateTime in_zdt)
    {
        ZonedDateTime zdt = in_zdt.withZoneSameInstant(ZoneId.of("GMT"));
        setYears(zdt.getYear());
        setMonth(zdt.getMonth().getValue() - 1);
        day = zdt.getDayOfMonth();
        hour = zdt.getHour();
        minute = zdt.getMinute();
        second = zdt.getSecond();
    }

    public UniversalTime(int in_year, int in_month, int in_day, int in_hour, int in_minute, int in_second, ZoneId zId)
    {
        ZonedDateTime zdt = ZonedDateTime.of(in_year, in_month, in_day, in_hour, in_minute, in_second, 0, zId).withZoneSameInstant(ZoneId.of("GMT"));
        year = zdt.getYear();
        month = zdt.getMonth().getValue(); //why was this -1?
        day = zdt.getDayOfMonth();
        hour = zdt.getHour();
        minute = zdt.getMinute();
        second = zdt.getSecond();
    }

    public UniversalTime(int in_year, int in_month, int in_day, int in_hour, int in_minute, int in_second)
    {
        year = in_year;
        month = in_month;
        day = in_day;
        hour = in_hour;
        minute = in_minute;
        second = in_second;
    }

    public int getYear()
    {
        return year;
    }

    public int getMonth()
    {
        return month;
    }

    public int getDays()
    {
        return day;
    }

    public int getHours()
    {
        return hour;
    }

    public int getMinutes()
    {
        return minute;
    }

    public int getSeconds()
    {
        return second;
    }

    void setYears(int value)
    {
        year = value;
    }

    void setMonth(int value)
    {
        setYears(year + (value / 12));
        month = (value % 12) + 1;
    }

    public static int[] DayCount = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    int GetDayCount(int in_month, int in_year)
    {
        if (in_month == 2)
            return (in_year % 4 == 0 && (in_year % 100 != 0 || in_year % 400 == 0)) ? 29 : DayCount[in_month - 1];

        return DayCount[in_month - 1];
    }

    public void addDays(int value)
    {
        int newDay = day + value;
        while (newDay > GetDayCount(month, year))
        {
            newDay -= GetDayCount(month, year);
            setMonth(month);
        }

        day = newDay;
    }

    public void addHours(int value)
    {
        int newHour = value + hour;

        addDays(newHour / 24);
        hour = newHour % 24;
    }

    public void addMinutes(int value)
    {
        int newMinute = value + minute;
        addHours(newMinute / 60);
        minute = newMinute % 60;
    }

    public void addSeconds(int value)
    {
        int newSecond = value + second;
        addMinutes(newSecond / 60);
        second = newSecond % 60;
    }

    public String toString()
    {
        return ToZonedDate(ZoneId.of("GMT")).format(DateTimeFormatter.ofPattern("MM/dd/yyyy - HH:mm:ss Z"));
    }

    public ZonedDateTime ToZonedDate(ZoneId zId)
    {
        return ZonedDateTime.of(year, month, day, hour, minute, second, 0, ZoneId.of("GMT")).withZoneSameInstant(zId);
    }
}