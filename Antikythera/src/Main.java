import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void SQLMode() {
        // connection string
        var url = "jdbc:sqlite:Antikythera/Data/antikythera.db";
        Scanner scanner = new Scanner(System.in);
        SqlExecutor.OpenDatabase(url);

        // TO-DO: User Interface
        System.out.println("Welcome to The Antikythera Replication Project");

        int userSelectionMain = -1;

        while (userSelectionMain != 0)
        {
            System.out.println("\nPlease select from the following options: ");
            System.out.println("1.) See Today's Alignments");
            System.out.println("2.) Follow Astrological Body");
            System.out.println("3.) Eclipse Predictions");
            System.out.println("0.) End Session");

            userSelectionMain = scanner.nextInt();

            switch (userSelectionMain)
            {
                case 1:
                {
                    System.out.println("See Today's Alignments\n");
                    System.out.println("Today's Alignments are as Follows:");

                    UniversalTime ut = new UniversalTime(ZonedDateTime.now(ZoneId.of("GMT")));

                    int y = ut.getYear();
                    int m = ut.getMonth();
                    int day_calc = ut.getDays();

                    //there is some weird stuff with months 1 and 2
                    if (m <= 2) {
                        y--;
                        m += 12;
                    }

                    double d = 367 * y - (7*(y + ((m+9)/12)))/4 + (275*m)/9 + day_calc - 730530;

                    System.out.println("Sun: \n");
                    Planets.Sun(d);
                    System.out.println();
                    System.out.println("Moon: \n");
                    Planets.Moon(d);
                    System.out.println();
                    System.out.println("Mercury: \n");
                    Planets.Mercury(d);
                    System.out.println();
                    System.out.println("Venus: \n");
                    Planets.Venus(d);
                    System.out.println();
                    System.out.println("Mars: \n");
                    Planets.Mars(d);
                    System.out.println();
                    System.out.println("Jupiter: \n");
                    Planets.Jupiter(d);
                    System.out.println();
                    System.out.println("Saturn: \n");
                    Planets.Saturn(d);
                    System.out.println();
                    System.out.println("Uranus: \n");
                    Planets.Uranus(d);
                    System.out.println();
                    System.out.println("Neptune: \n");
                    Planets.Neptune(d);
                    System.out.println();

                    break;
                }

                case 2:
                {
                    System.out.println("Follow an Astrological Body\n");

                    double d = UtilMath.d();

                    int userSelectionBody = -1;

                    while (userSelectionBody != 0)
                    {
                        System.out.println("Please select from the following options:");
                        System.out.println("1.) Sun");
                        System.out.println("2.) Moon");
                        System.out.println("3.) Mercury");
                        System.out.println("4.) Venus");
                        System.out.println("5.) Mars");
                        System.out.println("6.) Jupiter");
                        System.out.println("7.) Saturn");
                        System.out.println("8.) Uranus");
                        System.out.println("9.) Neptune");
                        System.out.println("0.) Exit");

                        userSelectionBody = scanner.nextInt();

                        if (userSelectionBody < 0 || userSelectionBody > 8)
                            System.out.println("Invalid selection. Please try again.\n");

                        switch(userSelectionBody)
                        {
                            case 1:
                            {
                                // Sun
                                Planets.Sun(d);
                                break;
                            }
                            case 2:
                            {
                                // Moon
                                Planets.Moon(d);
                                break;
                            }
                            case 3:
                            {
                                // Mercury
                                Planets.Mercury(d);
                                break;
                            }
                            case 4:
                            {
                                // Venus
                                Planets.Venus(d);
                                break;
                            }
                            case 5:
                            {
                                // Mars
                                Planets.Mars(d);
                                break;
                            }
                            case 6:
                            {
                                Planets.Jupiter(d);
                                break;
                            }
                            case 7:
                            {
                                Planets.Saturn(d);
                                break;
                            }
                            case 8:
                            {
                                Planets.Uranus(d);
                                break;
                            }
                            case 9:
                            {
                                Planets.Neptune(d);
                                break;
                            }
                            case 0:
                            {
                                break;
                            }
                            default:
                            {
                                System.out.println("Invalid selection. Please try again.");
                                break;
                            }
                        }

                        // Other logic
                    }

                    break;
                }

                case 3:
                {
                    System.out.println("Predict the Next Eclipse\n");
                    EclipseFinder ef = new EclipseFinder();

                    int userSelectionBody = -1;

                    while (userSelectionBody != 0) {
                        System.out.println("Please select from the following options:");
                        System.out.println("1.) View Solar Eclipses");
                        System.out.println("2.) View Lunar Eclipses");
                        System.out.println("3.) Predict Similar Solar via Saros");
                        System.out.println("4.) Predict Similar Lunar via Saros");
                        System.out.println("5.) Predict Next Solar Eclipse");
                        System.out.println("6.) Predict Next Lunar Eclipse");
                        System.out.println("0.) Exit");

                        userSelectionBody = scanner.nextInt();

                        switch (userSelectionBody) {
                            case 1: {
                                // Sun
                                System.out.println("Showing Data from Solar Eclipses.");
                                List<SolarEclipse> solarEclipses = ef.GetSolarEclipses();

                                for(int i = 0; i < solarEclipses.size(); i++)
                                {
                                    solarEclipses.get(i).printAll();
                                }

                                break;
                            }
                            case 2: {
                                // Moon
                                System.out.println("Showing data from Lunar Eclipses.");
                                List<LunarEclipse> lunarEclipses = ef.GetLunarEclipses();

                                for(int i = 0; i < lunarEclipses.size(); i++)
                                {
                                    lunarEclipses.get(i).printAll();
                                }

                                break;
                            }
                            case 3: {
                                try {
                                    EclipseFinder.NextSameSolarEclipse();
                                }
                                catch (SQLException e) {
                                    System.out.println(e);
                                }
                            }
                            case 4: {
                                try {
                                    EclipseFinder.NextSameLunarEclipse();
                                }
                                catch (SQLException e) {
                                    System.out.println(e);
                                }
                            }
                            case 5: {
                                SolarEclipse next = ef.PredictNextSolarEclipse();

                                System.out.println("Predicting next solar eclipse...");
                                System.out.println("The next solar eclipse will happen at: " + next.time + ". And have the following: ");

                                next.printAll();

                                break;
                            }
                            case 6: {
                                LunarEclipse next = ef.PredictNextLunarEclipse();

                                System.out.println("Predicting next lunar eclipse...");
                                System.out.println("The next lunar eclipse will happen at: " + next.time + ". And have the following: ");

                                next.printAll();

                                break;
                            }
                            case 0: {
                                // Exit
                                break;
                            }
                            default: {
                                System.out.println("Invalid selection. Please try again.");
                            }
                        }
                    }

                    break;
                }

                case 0:
                {
                    break;
                }

                default:
                {
                    System.out.println("Invalid selection. Please try again.");
                    break;
                }
            }
        }

        System.out.println("Thank you for visiting the Antikythera Replication Project.");

        /*try (var conn = DriverManager.getConnection(url)) {
            Statement statement = conn.createStatement();

            //Insert SQL working here

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/

        SqlExecutor.CloseDatabase();
    }

    public static void main(String[] args) {
        SQLMode();
    }
}