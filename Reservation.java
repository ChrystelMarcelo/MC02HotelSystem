import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a reservation made by a guest for a room in a hotel.
 */
public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;
    private double totalPrice;

    /**
     * Constructs a new Reservation object.
     * @param guestName    The name of the guest making the reservation.
     * @param checkInDate  The check-in date of the reservation
     * @param checkOutDate The check-out date of the reservation
     * @param room         The Room object reserved by the guest.
     */
    Reservation(String guestName, int checkInDate, int checkOutDate, Room room){
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.totalPrice = (checkOutDate - checkInDate) * room.getRoomPrice();
        room.setIsAvailable(false);
    }

    /**
     * Returns the total price of the reservation.
     * @return The total price of the reservation.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Returns the check-in date of the reservation.
     * @return The check-in date of the reservation.
     */
    public int getCheckInDate() {
        return checkInDate;
    }

    /**
     * Returns the check-out date of the reservation.
     * @return The check-out date of the reservation.
     */
    public int getCheckOutDate() {
        return checkOutDate;
    }


    /**
     * Returns the name of the guest who made the reservation.
     * @return The name of the guest.
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Returns the Room object associated with this reservation.
     * @return The Room object reserved by the guest.
     */
    public Room getRoom() {
        return room;
    }


}
