public class Executive extends Room{
    /**
     * Constructs an Executive Room object with a given room name
     *
     * @param roomName
     */
    Executive(String roomName, double baseRate) {
        super(roomName, baseRate);
    }

    /**
     * Gets the price of the room.
     *
     * @return the price of the room
     */
    @Override
    public double getPrice(){
        double percentMore = getBaseRate() * 0.35;
        return getBaseRate() + percentMore;
    }

    /**
     * Gets the type of the room.
     *
     * @return the type of the room
     */
    @Override
    public String getRoomType(){
        return "Executive";
    }


}
