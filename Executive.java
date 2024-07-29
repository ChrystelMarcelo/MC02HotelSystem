public class Executive extends Room{
    /**
     * Constructs a Room object with a given room name
     *
     * @param roomName
     */
    Executive(String roomName, double baseRate) {
        super(roomName, baseRate);
    }

    @Override
    public double getPrice(){
        double percentMore = getBaseRate() * 0.35;
        return getBaseRate() + percentMore;
    }

    @Override
    public String getRoomType(){
        return "Executive";
    }


}
