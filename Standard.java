public class Standard extends Room {
    /**
     * Constructs a Room object with a given room name
     *
     * @param roomName
     */
    Standard(String roomName, double roomPrice) {
        super(roomName, roomPrice);
    }

    @Override
    public double getPrice() {
        return getBaseRate();
    }

    @Override
    public String getRoomType(){
        return "Standard";
    }
}
