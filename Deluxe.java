public class Deluxe extends Room{
    /**
     * Constructs a Room object with a given room name
     *
     * @param roomName
     */
    Deluxe(String roomName, double baseRate) {
        super(roomName, baseRate);
    }


    /**
     * Gets the price of the room.
     *
     * @return the price of the room
     */
    @Override
    public double getPrice(){
        double percentMore = getBaseRate() * 0.2;
        return getBaseRate() + percentMore;
    }

    /**
     * Gets the type of the room.
     *
     * @return the type of the room
     */
    @Override
    public String getRoomType(){
        return "Deluxe";
    }
}
