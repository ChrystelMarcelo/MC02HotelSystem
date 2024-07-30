import java.util.ArrayList;
import java.util.Scanner;


/**
 * Represents a hotel management system that allows creating, viewing, managing hotels,
 * and booking rooms within those hotels.
 */
public class HotelSystem {
    ArrayList<Hotel> hotelList = new ArrayList<>();
    Scanner Scanner = new Scanner(System.in);

    /**
     * Constructs a Hotel System Object
     */
    HotelSystem() {
    }

    /**
     * Method that creates a hotel
     */
    public void createHotel() {
        boolean hotelExit = false;
        do {

            System.out.println("=======================");
            System.out.print("Enter hotel name (enter 'exit' to back):");
            String hotelNameInput = Scanner.nextLine();
            System.out.println("=======================");

            if (hotelNameInput.equals("exit")) {
                hotelExit = true;
                continue;
            }

            boolean hotelExist = false;
            for (Hotel h : hotelList) {
                if (h.hotelFound(hotelNameInput)) {
                    hotelExist = true;
                }
            }

            int roomCount;

            if (hotelExist)
                System.out.println("Hotel already exists! Please input another hotel name: ");
            else {
                System.out.println("=======================");
                System.out.print("Enter number of rooms (1 - 50): (enter 'exit' to back):");

                if (Scanner.hasNextInt()) {
                    roomCount = Scanner.nextInt();
                    Scanner.nextLine();

                    if ((roomCount < 1) || (roomCount > 50)) {
                        System.out.println("Enter number of rooms from 1 - 50 only. ");
                        continue;
                    }
                } else {
                    String roomScanInput = Scanner.next();
                    if (roomScanInput.equals("exit")) {
                        hotelExit = true;
                        continue;
                    } else {
                        System.out.println("Invalid Input Please Try Again.");
                        continue;
                    }

                }
                System.out.println("=======================");

                Hotel hotel = new Hotel(hotelNameInput, roomCount);
                hotelList.add(hotel);
                System.out.println(hotelNameInput + " hotel successfully added in the system");

            }


        } while (!hotelExit);
    }


    /**
     * Method that views current information from a selected hotel
     */
    public void viewHotel() {
        int i = 1;
        System.out.println("=======================");
        System.out.println("Current Hotels In The System: ");
        for(Hotel h: hotelList){
            System.out.println(i +": " + h.getHotelName() + " Hotel");
            i++;
        }
        System.out.println("=======================");

        if (!hotelList.isEmpty()) {
            Scanner selectHotelView = new Scanner(System.in);
            System.out.println("=======================");
            System.out.print("Enter selected hotel: ");
            String choiceHotel = selectHotelView.nextLine();
            System.out.println("=======================");

            boolean hotelFound = false;
            for (Hotel h : hotelList) {
                if (h.hotelFound(choiceHotel)) {
                    hotelFound = true;
                    Scanner viewHotel = new Scanner(System.in);
                    System.out.println("=======================");
                    System.out.println("1: High Level Information ");
                    System.out.println("2: Low Level Information ");
                    System.out.println("=======================");
                    System.out.println("Select Information (1-2): ");

                    if (viewHotel.hasNextInt()) {
                        int choiceInfo = viewHotel.nextInt();
                        viewHotel.nextLine();

                        switch (choiceInfo) {

                            case 1: // High Level Information
                                System.out.println("=======================");
                                System.out.println("Hotel Name: " + h.getHotelName());
                                System.out.println("Total number of rooms: " + h.getRoomCount());
                                h.estimatedEarnings();
                                break;

                            case 2: // Low Level Information
                                Scanner subViewOption = new Scanner(System.in);
                                System.out.println("=======================");
                                System.out.println("1: View Total Number of Available and Booked Rooms");
                                System.out.println("2: View Information About a Selected Room");
                                System.out.println("3: View Information About a Selected Reservation");
                                System.out.println("=======================");
                                System.out.print("Select an option: ");
                                int subViewHotel = subViewOption.nextInt();
                                subViewOption.nextLine();

                                switch (subViewHotel) {
                                    case 1:
                                        System.out.println("Enter date to check availability of rooms(1-31): ");
                                        int dateCheck = Scanner.nextInt();
                                        h.displayAvailableAndBookedRooms(dateCheck);
                                        break;

                                    case 2:
                                        System.out.println("Enter Room Name to View (e.g. Room 1):  ");
                                        String roomView = Scanner.nextLine();
                                        String printRoom = h.printRoomDetails(roomView);
                                        System.out.println(printRoom);
                                        break;

                                    case 3:
                                        System.out.println("Enter guest name under reservation made:  ");
                                        String reservationSelect = Scanner.nextLine();
                                        String printReservation = h.printReservationDetails(reservationSelect);
                                        System.out.println(printReservation);
                                        break;

                                    default:
                                        break;
                                }
                                break;

                            default:
                                System.out.println("Invalid Input. Please try again. ");
                                break;
                        }
                    } else {
                        System.out.println("Invalid Input. Please enter a number. ");
                        Scanner.next();
                    }
                    break;
                }
            }
            if (!hotelFound) {
                System.out.println("Hotel is not in the System. ");
            }
        }
        else {
            System.out.println("There are currently no hotels in the system. ");
        }

    }


    /**
     * Method that modifies the different configurations from a selected hotel
     */
    public void manageHotel() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        do {
            if (!hotelList.isEmpty()) {
                System.out.println("Enter Hotel Name to Manage (enter 'exit' to back): ");
                String hotelManage = scanner.nextLine();

                if (hotelManage.equalsIgnoreCase("exit")) {
                    exit = true;
                    continue;
                }
                boolean hotelFound = false;

                for (Hotel h : hotelList) {
                    if (h.hotelFound(hotelManage)) {
                        hotelFound = true;
                        System.out.println("=======================");
                        System.out.println("1: Change name of hotel");
                        System.out.println("2: Add Room");
                        System.out.println("3: Remove Room");
                        System.out.println("4: Update Base Price of Rooms");
                        System.out.println("5: Remove Reservation");
                        System.out.println("6: Remove Hotel");
                        System.out.println("7: Modify Date Price");
                        System.out.println("8: Back To Menu");
                        System.out.println("=======================");
                        System.out.println("Choose Option (1-8): ");
                        int option = scanner.nextInt();
                        scanner.nextLine();

                        switch (option) {
                            case 1:
                                System.out.println("Enter New Hotel Name: ");
                                String newName = scanner.nextLine();
                                System.out.println("Confirm Change? (1: yes / 2: no): ");
                                int confirm1 = scanner.nextInt();
                                scanner.nextLine();

                                if (confirm1 == 1) {
                                    if (!h.hotelExists(newName, hotelList)) {
                                        h.setHotelName(newName);
                                        System.out.println("Hotel Name Changed Successfully! ");
                                        exit = true;
                                    } else {
                                        System.out.println("Hotel Name Already Exists! ");
                                        exit = true;
                                    }
                                }
                                exit = true;
                                break;

                            case 2:
                                System.out.println("Enter New Room Name (e.g., Room 1): ");
                                String roomAdd = scanner.nextLine();
                                System.out.println("Select Room Type to add: ");
                                System.out.println("1: Standard Room");
                                System.out.println("2: Deluxe Room");
                                System.out.println("3: Executive Room");
                                int addRoomType = scanner.nextInt();
                                System.out.println("Confirm Change? (1: yes / 2: no): ");
                                int confirm2 = scanner.nextInt();
                                scanner.nextLine();

                                if (confirm2 == 1) {
                                    boolean roomExists = false;
                                    for (Room r : h.getRoomList()) {
                                        if (r.getRoomName().equalsIgnoreCase(roomAdd)) {
                                            roomExists = true;
                                            break;
                                        }
                                    }
                                    if (!roomExists && h.getRoomList().size() < 50) {
                                        if(addRoomType == 1){
                                            h.addStandardRoom(roomAdd);
                                            System.out.println("Room Successfully Added");
                                            exit = true;
                                        } else if(addRoomType == 2){
                                            h.addDeluxeRoom(roomAdd);
                                            System.out.println("Room Successfully Added");
                                            exit = true;
                                        } else if(addRoomType == 3){
                                            h.addExecutiveRoom(roomAdd);
                                            System.out.println("Room Successfully Added");
                                            exit = true;
                                        }
                                    } else {
                                        System.out.println("Error: Room already exists or maximum room limit reached.");
                                        exit = true;
                                    }
                                }
                                exit = true;
                                break;

                            case 3:
                                System.out.println("Enter Room Name to Remove (e.g., Room 1): ");
                                String roomRemove = scanner.nextLine();
                                System.out.println("Confirm Change? (1: yes / 2: no): ");
                                int confirm3 = scanner.nextInt();
                                scanner.nextLine();

                                if (confirm3 == 1) {
                                    if (h.removeRoom(roomRemove)) {
                                        System.out.println("Room Successfully Removed");
                                        exit = true;
                                    } else {
                                        System.out.println("Error: Could not remove room.");
                                        exit = true;
                                    }
                                }
                                break;

                            case 4:
                                System.out.println("Enter New Room Base Price: ");
                                double roomBasePrice = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Confirm Change? (1: yes / 2: no): ");
                                int confirm4 = scanner.nextInt();
                                scanner.nextLine();

                                if (confirm4 == 1) {
                                    boolean updated = h.updateBasePrice(roomBasePrice);
                                    if (updated) {
                                        System.out.println("Room Base Price Updated Successfully ");
                                    }
                                }
                                exit = true;
                                break;

                            case 5:
                                if (!h.isReservationEmpty()) {
                                    System.out.println("Enter guest name under reservation made: ");
                                    String guestNameRes = scanner.nextLine();
                                    System.out.println("Confirm Change? (1: yes / 2: no): ");
                                    int confirm5 = scanner.nextInt();
                                    scanner.nextLine();

                                    if (confirm5 == 1) {
                                        boolean removedRes = h.removeReservation(guestNameRes);
                                        if (removedRes) {
                                            System.out.println("Reservation Removed");
                                            exit = true;
                                        }
                                    }
                                } else {
                                    System.out.println("No reservations exist.");
                                    exit = true;
                                }
                                exit = true;
                                break;

                            case 6:
                                System.out.println("Confirm Change? (1: yes / 2: no): ");
                                int confirm6 = scanner.nextInt();
                                scanner.nextLine();

                                if (confirm6 == 1) {
                                    boolean removeHotel = h.removeHotel(hotelManage, hotelList);
                                    if (removeHotel) {
                                        System.out.println("Hotel Removed");
                                        exit = true;
                                    }
                                }
                                exit = true;
                                break;

                            case 7:
                                if(!h.isReservationEmpty()) {
                                    int i, numDays, day;
                                    double modifier = 0.0;
                                    System.out.println("Enter number of days for which you want to set price modifiers: ");
                                    numDays = scanner.nextInt();

                                    for (i = 0; i < numDays; i++) {
                                        System.out.print("Enter day (1-31): ");
                                        day = scanner.nextInt();
                                        System.out.print("Enter price modifier for day(e.g. 0.5 for 50%): ");
                                        modifier = scanner.nextDouble();
                                        h.setDatePriceModifier(day, modifier);
                                        System.out.println("Price Modifier: " + h.getDatePriceModifier());
                                        h.updateAffectedReservation(day);
                                        System.out.println("Price Modified");
                                    }
                                }
                                exit = true;
                                break;

                            case 8:
                                exit = true;
                                break;

                            default:
                                System.out.println("Invalid Input. ");
                                break;
                        }
                    }
                }

                if (!hotelFound) {
                    System.out.println("Hotel not found. ");
                }
            } else {
                System.out.println("There are no hotels in the system. ");
                exit = true;
            }
        } while (!exit);
    }


    /**
     * Method that books a room from a selected hotel
     */
   public void bookRoom(){
       boolean exit = false;
       do {
           if (!hotelList.isEmpty()) {
               System.out.println("Input Hotel To Book a Room: ");
               String hotelBook = Scanner.nextLine();
               Hotel selectedHotel = null;
               for (Hotel h : hotelList) {
                   if (h.hotelFound(hotelBook)) {
                       selectedHotel = h;
                       break;
                   }
               }

               if (selectedHotel != null) {
                   System.out.println("Enter guest name: ");
                   String guestName = Scanner.nextLine();

                   int checkInDate = -1;
                   while (checkInDate < 1 || checkInDate > 31) {
                       System.out.println("Input check-in date (1-31): ");
                       checkInDate = Scanner.nextInt();
                       if (checkInDate < 1 || checkInDate > 31) {
                           System.out.println("Invalid check-in date. Please enter a date between 1 and 31.");
                       } else if (checkInDate == 31) {
                           System.out.println("Can't check in at the end of the month.");
                           checkInDate = -1;
                       }
                   }

                   int checkOutDate = -1;
                   while (checkOutDate < 1 || checkOutDate > 31) {
                       System.out.println("Input check-out date (1-31): ");
                       checkOutDate = Scanner.nextInt();
                       if (checkOutDate < 1 || checkOutDate > 31) {
                           System.out.println("Invalid check-out date. Please enter a date between 1 and 31.");
                       } else if (checkOutDate == 1) {
                           System.out.println("Can't check out at the start of the month.");
                           checkOutDate = -1;
                       }
                   }

                   Scanner.nextLine();

                   System.out.println("Select Room To Book: ");
                   String roomToBook = Scanner.nextLine();
                   Room selectedRoom = null;
                   for (Room r : selectedHotel.getRoomList()) {
                       if (r.getRoomName().equalsIgnoreCase(roomToBook)) {
                           selectedRoom = r;
                           break;
                       }
                   }
                   if (selectedRoom != null) {
                       System.out.println("Input Discount Code: ");
                       System.out.println("Type 'N/A' if none ");
                       String discountCode = Scanner.nextLine();
                       boolean reservationAdded = selectedHotel.addReservation(selectedHotel,guestName, checkInDate, checkOutDate, roomToBook, discountCode);
                       if (reservationAdded) {
                           System.out.println("Room Successfully Booked!");
                           exit = true;
                       } else {
                           System.out.println("Room is not available for the selected dates");
                           exit = true;
                       }
                   } else {
                       System.out.println("Invalid Room Name. Please Try Again");
                       exit = true;
                   }
               } else {
                   System.out.println("Hotel Does Not Exist");
                   exit = true;
               }
           } else {
               System.out.println("There are no hotels in the system.");
               exit = true;
           }

       } while (!exit);

   }

    public ArrayList<Hotel> getHotelList(){
        return hotelList;
    }

}



