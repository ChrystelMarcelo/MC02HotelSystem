/**
 * Represents a reservation made by a guest for a room in a hotel.
 */
public class Reservation {
    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;
    private double totalPrice;
    private String discountCode;
    private Hotel hotel;

    /**
     * Constructs a new Reservation object.
     * @param guestName    The name of the guest making the reservation.
     * @param checkInDate  The check-in date of the reservation
     * @param checkOutDate The check-out date of the reservation
     * @param room         The Room object reserved by the guest.
     */
    Reservation(Hotel hotel, String guestName, int checkInDate, int checkOutDate, Room room, String discountCode){
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.discountCode = discountCode;
        this.hotel = hotel;
        room.setIsAvailable(false);
        this.totalPrice = calculateTotalPrice();
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


    /**
     * Calculates the total price for the reservation.
     *
     * @return the total price for the reservation
     */
    public double calculateTotalPrice(){
        double totalPrice = 0.0;
        for (int day = checkInDate; day < checkOutDate; day++) {
            totalPrice = totalPrice + hotel.getPriceForDate(day, room);
        }
        totalPrice = applyDiscount(totalPrice, checkOutDate - checkInDate);
        return totalPrice;
    }

    /**
     * Recalculates and updates the total price for the reservation.
     */
    public void recalculateTotalPrice(){
        this.totalPrice = calculateTotalPrice();
    }


    /**
     * Applies a discount to the total price based on the discount code.
     *
     * @param totalPrice the original total price
     * @param numberOfDays the number of days for the reservation
     * @return the total price after applying the discount
     */
    private double applyDiscount(double totalPrice, int numberOfDays){
        switch(discountCode){
            case "I_WORK_HERE":
                return totalPrice - (totalPrice* 0.1);
            case "STAY4_GET1":
                if(numberOfDays >= 5){
                    return totalPrice - (totalPrice/numberOfDays);
                }
                break;
            case "PAYDAY":
                if(checkPayday(checkInDate, checkOutDate)){
                    return totalPrice - (totalPrice * 0.07);
                }
                break;
            default:
                return totalPrice;
        }

        return totalPrice;
    }

    /**
     * Checks if date is applicable to discount PAYDAY
     *
     * @param checkInDate the check-in date
     * @param checkOutDate the check-out date
     * @return true if reservation date applies to discount PAYDAY, otherwise false
     */
    private boolean checkPayday(int checkInDate, int checkOutDate){
        int i;

        for(i = checkInDate; i < checkOutDate; i++){
            if (i == 15 || i == 30){
                return true;
            }
        }
        return false;
    }


}
