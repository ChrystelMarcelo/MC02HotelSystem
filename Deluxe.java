public class Deluxe extends Room{
    /**
     * Constructs a Room object with a given room name
     *
     * @param roomName
     */
    Deluxe(String roomName, double baseRate) {
        super(roomName, baseRate);
    }


    @Override
    public double getPrice(){
        double percentMore = getBaseRate() * 0.2;
        return getBaseRate() + percentMore;
    }

    @Override
    public String getRoomType(){
        return "Deluxe";
    }
}
