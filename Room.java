import java.util.ArrayList;


/**
 * The Room Class represents a room in a hotel
 */
public class Room {
    private String roomName;
    private double roomPricePerNight;
    private boolean available;


    /**
     * Constructs a Room object with a given room name
     * @param roomName
     */
    Room(String roomName){
        this.roomName = roomName;
        this.roomPricePerNight = 1299f;
        this.available = true;
    }


    /**
     * Returns the name of the room
     * @return the name of the room
     */
    public String getRoomName(){
        return this.roomName;
    }


    /**
     * Sets the base price per night
     * @param roomPrice the base price of the room
     */
    public void setRoomPrice(double roomPrice){
        roomPricePerNight = roomPrice;
    }

    /**
     * Returns the base price per night
     * @return the base price per night
     */
    public double getRoomPrice(){
        return roomPricePerNight;
    }

    /**
     * Sets the availability of a room
     * @param isBooked availability of a room
     */
    public void setIsAvailable(boolean isBooked){
        this.available = isBooked;
    }

    /**
     * Returns availability of a room
     * @return availability of a room
     */
    public boolean getIsAvailable() {
        return available;
    }


    /**
     * Returns if room is available on a date in a month
     * @param date the day of a month
     * @param reservations list of reservations
     * @return false if date is booked, true if otherwise
     */
    public boolean isAvailableMonth(int date, ArrayList<Reservation> reservations) {
        for (Reservation res : reservations) {
            if (date >= res.getCheckInDate() && date <= res.getCheckOutDate()) {
                return false;
            }
        }
        return true;
    }

}

