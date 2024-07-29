import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener, DocumentListener {
    private HotelSystemGUI view;
    private HotelSystem model;


    public Controller(HotelSystemGUI gui, HotelSystem hotelSystem){
        this.view = gui;
        this.model = hotelSystem;

        updateView();
        initializeViewHotelListeners();
        gui.setActionListener(this);
        gui.setDocumentListener(this);
    }

    public void updateView(){

    }

    private void createHotelView(){
        view.createHotelWindow("Add Hotel");
    }

    private void viewHotelView(){
        view.viewHotelWindow("View Hotel");
        //model.viewHotel();
    }


    private void manageHotelView(){
        view.manageHotelView("Manage Hotel");
        model.manageHotel();
    }

    private void bookRoomView(){
        view.bookRoomView("Book Room");
    }

    private void availableRoomView(){
        view.viewAvailableRooms("Available Rooms");
    }

    private void selectRoomView(){
        view.viewSelectRoom("Room Information");
    }

    private void selectReservationView(){
        view.viewSelectReservation("Reservation Information");
    }

    private void changeHotelNameView(){
        view.changeHotelNameView("Change Hotel Name");
    }

    private void addRoomView(){
        view.addRoomView("Add Room");
    }

    private void removeRoomView(){
        view.removeRoomView("Remove Room");
    }

    private void updateRoomBasePriceView(){
        view.updateBasePriceView("Update Room Base Price");
    }

    private void removeReservationView(){
        view.removeReservationView("Remove Reservation");
    }

    private void removeHotelView(){
        view.removeHotelView("Remove Hotel");
    }

    private void modifyDatePriceView(){
        view.modifyDatePrice("Modify Date Price");
    }

    private void createHotel() {
        String hotelName = view.getHotelName();
        int roomCount = view.getRoomCount();

        if (hotelName == null || hotelName.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Hotel name cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (roomCount == -1) {
            return;
        }

        boolean hotelExist = false;
        for (Hotel h : model.getHotelList()) {
            if (h.hotelFound(hotelName)) {
                hotelExist = true;
                break;
            }
        }

        if (hotelExist) {
            JOptionPane.showMessageDialog(view, "Hotel already exists! Please input another hotel name.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            model.createHotel(hotelName, roomCount);
            JOptionPane.showMessageDialog(view, hotelName + " hotel successfully added in the system", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void initializeViewHotelListeners() {
        view.getHighLevelInfoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleViewHotel(e, true);
            }
        });

        view.getLowLevelInfoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleViewHotel(e, false);
            }
        });

        view.getViewAvailableRooms().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAvailableRooms(e);
            }
        });

        view.getViewSelectRoom().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSelectRoom(e);
            }
        });


    }

    private void handleAvailableRooms(ActionEvent e){
        String selectedHotelName = view.getViewHotelName();
        Hotel selectedHotel = null;
        for (Hotel hotel : model.getHotelList()) {
            if (hotel.getHotelName().equals(selectedHotelName)) {
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        }

        try {
            int date = view.getTfDate();
            String availability = selectedHotel.displayAvailableAndBookedRooms(date);
            view.displayAvailability(availability);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Invalid date format. Please enter a valid date.");
        }
    }

    private void handleSelectRoom(ActionEvent e){
        String selectedHotelName = view.getViewHotelName();
        Hotel selectedHotel = null;
        for (Hotel hotel : model.getHotelList()) {
            if (hotel.getHotelName().equals(selectedHotelName)) {
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        }
        String roomName = view.getSelectRoomName();
        String selectedRoom = selectedHotel.printRoomDetails(roomName);
        view.displaySelectedRoom(selectedRoom);
    }


    private void handleViewHotel(ActionEvent e, boolean isHighLevel){
        String selectedHotelName = view.getViewHotelName();
        Hotel selectedHotel = null;

        for (Hotel hotel : model.getHotelList()) {
            if (hotel.getHotelName().equals(selectedHotelName)) {
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        }

        if (isHighLevel) {
            displayHighLevelInfo(selectedHotel);
        } else {
            displayLowLevelInfo(selectedHotel);
        }
    }

    private void displayLowLevelInfo(Hotel hotel){
        view.lowInfoView("Low Level Information");
    }


    private void displayHighLevelInfo(Hotel hotel){
        view.highInfoView("High Level Information", hotel.getHotelName(), hotel.getRoomCount());
    }




    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        // Check each character to see if it is a digit or a minus sign at the start
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && c == '-') {
                // Allow a minus sign only at the start
                continue;
            }
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    // For Creating New Window
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Create Hotel")){
            createHotelView();
        }else if(e.getActionCommand().equals("View Hotel")){
            viewHotelView();
        }else if(e.getActionCommand().equals("Manage Hotel")){
            manageHotelView();
        }else if(e.getActionCommand().equals("Book Room")){
            bookRoomView();
        }else if(e.getActionCommand().equals("Available Rooms")){
            availableRoomView();
        }else if(e.getActionCommand().equals("Select Room")){
            selectRoomView();
        }else if(e.getActionCommand().equals("Select Reservation")){
            selectReservationView();
        }else if(e.getActionCommand().equals("Change Hotel Name")){
            changeHotelNameView();
        }else if(e.getActionCommand().equals("Add Room")){
            addRoomView();
        }else if(e.getActionCommand().equals("Remove Room")){
            removeRoomView();
        }else if(e.getActionCommand().equals("Update Room Base Price")){
            updateRoomBasePriceView();
        }else if(e.getActionCommand().equals("Remove Reservation")){
            removeReservationView();
        }else if(e.getActionCommand().equals("Remove Hotel")){
            removeHotelView();
        }else if(e.getActionCommand().equals("Modify Date Price")){
            modifyDatePriceView();
        }else if(e.getActionCommand().equals("Confirm Hotel")){
            createHotel();
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {

    }

    @Override
    public void removeUpdate(DocumentEvent e) {

    }

    @Override
    public void changedUpdate(DocumentEvent e) {

    }
}
