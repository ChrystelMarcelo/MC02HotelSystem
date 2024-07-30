public class Standard extends Room {
    /**
     * Constructs a Standard Room object with a given room name
     *
     * @param roomName
     */
    Standard(String roomName, double roomPrice) {
        super(roomName, roomPrice);
    }

    /**
     * Gets the price of the room.
     *
     * @return the price of the room
     */
    @Override
    public double getPrice() {
        return getBaseRate();
    }

    /**
     * Gets the type of the room.
     *
     * @return the type of the room
     */
    @Override
    public String getRoomType(){
        return "Standard";
    }
}
