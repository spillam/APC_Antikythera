import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    //slime

    public static void SQLMode() {
        // connection string
        var url = "jdbc:sqlite:Antikythera/Data/assignment3.db";
        Scanner scanner = new Scanner(System.in);

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
                    System.out.println("[Insert Data Here]");
                    System.out.println("[Insert Data Here]");
                    System.out.println("[Insert Data Here]");

                    break;
                }

                case 2:
                {

                    System.out.println("Follow an Astrological Body\n");

                    int userSelectionBody = -1;

                    while (userSelectionBody != 0)
                    {
                        System.out.println("Please select from the following options:");
                        System.out.println("1.) Sun");
                        System.out.println("2.) Moon");
                        System.out.println("3.) Mercury");
                        System.out.println("4.) Venus");
                        System.out.println("5.) Earth");
                        System.out.println("6.) Mars");
                        System.out.println("7.) Jupiter");
                        System.out.println("8.) Saturn");
                        System.out.println("0.) Exit");

                        userSelectionBody = scanner.nextInt();

                        if (userSelectionBody < 0 || userSelectionBody > 8)
                            System.out.println("Invalid selection. Please try again.\n");

                        switch(userSelectionBody)
                        {
                            case 1:
                            {
                                // Sun
                                System.out.println("Showing Data for the Sun.");
                                break;
                            }
                            case 2:
                            {
                                // Moon
                                System.out.println("Showing Data for the Moon.");
                                break;
                            }
                            case 3:
                            {
                                // Mercury
                                System.out.println("Showing Data for Mercury.");
                            }
                            case 4:
                            {
                                // Venus
                                System.out.println("Showing Data for Venus.");
                            }
                            case 5:
                            {
                                // Earth
                                System.out.println("Showing Data for Earth.");
                            }
                            case 6:
                            {
                                // Mars
                                System.out.println("Showing Data for Mars.");
                            }
                            case 7:
                            {
                                // Jupiter
                                System.out.println("Showing Data for Jupiter.");
                            }
                            case 8:
                            {
                                // Saturn
                                System.out.println("Showing Data for Saturn.");
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
                    System.out.println("Follow an Astrological Body\n");

                    int userSelectionBody = -1;

                    while (userSelectionBody != 0) {
                        System.out.println("Please select from the following options:");
                        System.out.println("1.) Sun");
                        System.out.println("2.) Moon");
                        System.out.println("0.) Exit");

                        userSelectionBody = scanner.nextInt();

                        switch (userSelectionBody) {
                            case 1: {
                                // Sun
                                System.out.println("Showing Data from Solar Eclipses.");
                                break;
                            }
                            case 2: {
                                // Moon
                                System.out.println("Showing data from Lunar Eclipses.");
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
    }

    public static void main(String[] args) {
        SQLMode();
    }
}