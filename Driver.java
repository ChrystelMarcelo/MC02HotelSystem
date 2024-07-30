import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents the main driver for managing a hotel system
 */
public class Driver {
    public static void main(String[] args) {

        HotelSystemGUI GUI = new HotelSystemGUI();
        HotelSystem hrs = new HotelSystem();
        Controller controller = new Controller(GUI, hrs);


        Scanner menuChoice = new Scanner(System.in);

        int exit = 0;

        do {
            System.out.println("==========================================");
            System.out.println("  /     _/_    //                       ");
            System.out.println(" /_  __ /  _  //    _ _ _   _  _ _   , ,");
            System.out.println("/ /_(_)(__(/_(/_   / / / /_(/_/ / /_(_/_");
            System.out.println("==========================================");

            System.out.println("1: Add Hotel ");
            System.out.println("2: View Hotels ");
            System.out.println("3: Manage Hotel ");
            System.out.println("4: Book Room ");
            System.out.println("5: Exit Application ");
            System.out.println("=======================");
            System.out.println("Select Menu (1-5): ");

            int choice = -1;

            try {
                choice = menuChoice.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer between 1 and 5.");
                menuChoice.next();
                continue;
            }

            switch (choice) {
                case 1:
                    hrs.createHotel();
                    break;
                case 2:
                    hrs.viewHotel();
                    break;
                case 3:
                    hrs.manageHotel();
                    break;
                case 4:
                    hrs.bookRoom();
                    break;
                case 5:
                    System.exit(exit);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (true);


        }


    }


