import java.util.ArrayList;

/**
 *The Hotel class represents a hotel with a list of rooms and reservations.
 */
public class Hotel {
    private String hotelName;
    private ArrayList<Room> roomList;
    private ArrayList<Reservation> reservations;
    private ArrayList<Double> datePriceModifier;
    private int roomCount;

    /**
     * Constructs a Hotel object with the given name and room count.
     * @param hotelName the name of the hotel
     * @param roomCount the number of rooms in the hotel
     */
    Hotel(String hotelName, int roomCount) {
        int i;

        this.hotelName = hotelName;
        this.roomList = new ArrayList<>(); // Rooms in a Hotel
        this.reservations = new ArrayList<>(roomCount);
        this.roomCount = roomCount;
        this.datePriceModifier = new ArrayList<>();

        for(i = 0; i < 31; i++){
            this.datePriceModifier.add(1.0);
        }

        for (i = 0; i < roomCount; i++) {
            Room room;
            String roomName = "Room " + (i + 1);
            if(i % 3 == 0){
                room = new Standard(roomName, 1299f);
            } else if (i % 3 == 1) {
                room = new Deluxe(roomName, 1299f);
            } else {
                room = new Executive(roomName, 1299f);
            }
            roomList.add(room);
        }
    }

    /**
     * Returns the list of rooms in the hotel.
     * @return the list of rooms
     */
    public ArrayList<Room> getRoomList() {
        return roomList;
    }

    /**
     * Checks if there are any reservations in the hotel.
     * @return true if there are no reservations, false otherwise
     */
    public boolean isReservationEmpty() {
        if (reservations.isEmpty()) {
            System.out.println("There are currently no reservations in the system");
            return true;
        }
        return false;
    }

    /**
     * Checks if the hotel name matches the given name.
     * @param hotelName the name to check
     * @return true if the names match, false otherwise
     */
    public boolean hotelFound(String hotelName) {
        return this.hotelName.equals(hotelName);
    }

    /**
     * Checks if hotel name matches with any hotel names in hotel array list
     * @param hotelName
     * @param hotelList
     * @return true if hotel name matches with any hotel names in hotelList, false otherwise
     */
    public boolean hotelExists(String hotelName, ArrayList<Hotel> hotelList) {
        for (Hotel h : hotelList) {
            if (h.getHotelName().equalsIgnoreCase(hotelName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the name of the hotel.
     * @param hotelName the new name of the hotel
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Returns the name of the hotel.
     * @return the name of the hotel
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Returns the number of rooms in the hotel.
     * @return the number of rooms
     */
    public int getRoomCount() {
        return roomCount;
    }

    /**
     * Adds a new room to the hotel.
     * @param roomName the name of the new room
     */
    public void addStandardRoom(String roomName) {
        roomList.add(new Standard(roomName, 1299f));
        this.roomCount++;
    }

    public void addDeluxeRoom(String roomName){
        roomList.add(new Deluxe(roomName, 1299f));
        this.roomCount++;
    }

    public void addExecutiveRoom(String roomName){
        roomList.add(new Executive(roomName, 1299f));
        this.roomCount++;
    }



    /**
     * Removes a room from the hotel if it is not reserved.
     * @param roomName the name of the room to remove
     * @return true if the room was removed, false otherwise
     */
    public boolean removeRoom(String roomName) {
        if (roomList.isEmpty()) {
            System.out.println("Room list is empty. Cannot remove room.");
            return false;
        }
        for (Room r : roomList) {
            if (r.getRoomName().equalsIgnoreCase(roomName)) {
                if (r.getIsAvailable()) {
                    roomList.remove(r);
                    this.roomCount--;
                    return true;
                } else {
                    System.out.println("Room is not available for removal.");
                    return false;
                }
            }
        }
        System.out.println("Room not found.");
        return false;
    }

    /**
     * Updates the base price of all rooms in the hotel.
     * @param roomPrice the new base price for all rooms
     * @return true if the price was updated, false otherwise
     */
    public boolean updateBasePrice(double roomPrice) {
        if (roomPrice < 100.0) {
            System.out.println("Price must be greater than or equal to 100.0");
            return false;
        }

        for(Reservation r: reservations){
            if(!reservations.isEmpty()){
                System.out.println("Cannot change price if reservations still exist.");
                return false;
            }
        }

        for (Room r : roomList) {
            r.setRoomPrice(roomPrice);
        }
        return true;
    }

    /**
     * Removes a reservation by the guest name.
     * @param guestName the name of the guest
     * @return true if the reservation was removed, false otherwise
     */
    public boolean removeReservation(String guestName) {
        for (int i = 0; i < reservations.size(); i++) {
            Reservation r = reservations.get(i);
            if (r.getGuestName().equalsIgnoreCase(guestName)) {
                reservations.remove(i);
                return true;
            }
        }
        System.out.println("Guest Name has no reservation ");
        return false;
    }

    /**
     * Removes a hotel from the given list by hotel name.
     * @param hotelName the name of the hotel to remove
     * @param hotelList the list of hotels
     * @return true if the hotel was removed, false otherwise
     */
    public boolean removeHotel(String hotelName, ArrayList<Hotel> hotelList) {
        for (int i = 0; i < hotelList.size(); i++) {
            Hotel h = hotelList.get(i);
            if (h.getHotelName().equalsIgnoreCase(hotelName)) {
                hotelList.remove(i);
                return true;
            }
        }
        System.out.println("Hotel not found in the system.");
        return false;
    }

    /**
     * Adds a new reservation to the hotel.
     * @param guestName the name of the guest
     * @param checkInDate the check-in date
     * @param checkOutDate the check-out date
     * @param roomName the name of the room
     * @return true if the reservation was added, false otherwise
     */
    public boolean addReservation(Hotel hotel, String guestName, int checkInDate, int checkOutDate, String roomName, String discountCode) {
        for (Reservation res : reservations) {
            if (res.getRoom().getRoomName().equalsIgnoreCase(roomName)) {
                if (!(checkOutDate <= res.getCheckInDate() || checkInDate >= res.getCheckOutDate())) {
                    return false; // Dates overlap
                }
            } else if (res.getGuestName().equals(guestName)) {
                System.out.println("Guest has already booked");
                return false;
            }
        }

        Room room = null;
        for (Room r : roomList) {
            if (r.getRoomName().equalsIgnoreCase(roomName)) {
                room = r;
                break;
            }
        }

        if (room != null) {
            Reservation newReservation = new Reservation(hotel, guestName, checkInDate, checkOutDate, room, discountCode);
            reservations.add(newReservation);
            return true;
        }
        System.out.println("Room not found.");
        return false;
    }

    /**
     * Prints the names of all rooms in the hotel.
     */
    public void printRooms() {
        for (Room r : roomList) {
            System.out.println(r.getRoomName());
        }
    }

    /**
     * Estimates and prints the total earnings for the month based on reservations.
     */
    public void estimatedEarnings() {
        double totalEarnings = 0;
        for (Reservation res : reservations) {
            totalEarnings += res.getTotalPrice();
        }
        System.out.println("Estimated earnings for the month: " + totalEarnings);
        System.out.println("=======================");
    }

    /**
     * Displays the number of available and booked rooms on a given date.
     * @param date the date to check
     */
    public String displayAvailableAndBookedRooms(int date) {
        int availableRooms = 0;
        int bookedRooms = 0;

        for (Room room : roomList) {
            boolean isBooked = false;
            for (Reservation res : reservations) {
                if (res.getRoom().getRoomName().equals(room.getRoomName()) &&
                        res.getCheckInDate() <= date && res.getCheckOutDate() >= date) {
                    isBooked = true;
                    break;
                }
            }
            if (isBooked) {
                bookedRooms++;
            } else {
                availableRooms++;
            }
        }

        System.out.println("=======================");
        System.out.println("Total Number of Available Rooms on day " + date + " of the month: " + availableRooms);
        System.out.println("Total Number of Booked Rooms on day " + date + " of the month: " + bookedRooms);
        System.out.println("=======================");

        return "Total Number of Available Rooms on day " + date + " of the month: " + availableRooms + "\n" + "Total Number of Booked Rooms on day " + date + " of the month: " + bookedRooms;
    }

    /**
     * Prints the details of a specific room by name.
     * @param roomName the name of the room
     */
    public String printRoomDetails(String roomName) {
        StringBuilder output = new StringBuilder();

        for (Room r : roomList) {
            if (r.getRoomName().equalsIgnoreCase(roomName)) {
                output.append("=======================\n");
                output.append("Room Name: ").append(r.getRoomName()).append("\n");
                output.append("Room Type: ").append(r.getRoomType()).append("\n");
                output.append("Price per Night: ").append(r.getPrice()).append("\n");
                output.append("Availability: \n");

                for (int day = 1; day <= 31; day++) {
                    String status = (r.isAvailableMonth(day, reservations) ? "Available" : "Booked");
                    output.append("Day ").append(day).append(": ").append(status).append("\n");
                }
                output.append("=======================\n");

                return output.toString(); // Return the output if the room is found
            }
        }

        output.append("Room not found.\n");
        return output.toString(); // Return the output if the room is not found
    }

    /**
     * Prints the reservation details of a specific guest by name.
     * @param guestName the name of the guest
     */
    public void printReservationDetails(String guestName) {
        boolean reservationFound = false;

        for (Reservation r : reservations) {
            if (r.getGuestName().equalsIgnoreCase(guestName)) {
                System.out.println("=======================");
                System.out.println("Guest Name: " + r.getGuestName());
                System.out.println("Room Name: " + r.getRoom().getRoomName());
                System.out.println("Check-In Date: " + r.getCheckInDate());
                System.out.println("Check-Out Date: " + r.getCheckOutDate());
                System.out.println("Total Booking Price: " + r.getTotalPrice());
                System.out.println("Price Per Night: " + r.getRoom().getPrice());
                System.out.println("=======================");
                reservationFound = true;
                break;
            }
        }

        if (!reservationFound) {
            System.out.println("Reservation Not Found");
        }
    }




    public void setDatePriceModifier(int day, double modifier){
        if(day >= 1 && day <= 31){
            datePriceModifier.set(day-1, modifier);
        }
    }

    public double getPriceForDate(int day, Room room){
        if(day >= 1 && day <= 31){
            return datePriceModifier.get(day - 1) * room.getPrice();
        }
        return room.getPrice();
    }

    public void updateAffectedReservation(int day){
        for(Reservation reservation: reservations){
            if(reservation.getCheckInDate() <= day && reservation.getCheckOutDate() > day){
                reservation.recalculateTotalPrice();
            }
        }
    }

    public ArrayList<Double> getDatePriceModifier(){
        return datePriceModifier;
    }




}
