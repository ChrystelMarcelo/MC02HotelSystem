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
        initializeManageHotelListeners();
        initializeBookRoomListener();
        gui.setActionListener(this);
        gui.setDocumentListener(this);
    }

    public void updateView(){

    }

    //NEW WINDOWS
    private void createHotelView(){
        view.createHotelWindow("Add Hotel");
    }

    private void viewHotelView(){
        view.viewHotelWindow("View Hotel");
        //model.viewHotel();
    }

    private void manageHotelView(){
        view.manageHotelView("Manage Hotel");
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
        String selectHotelName = view.getManageHotelName();
        Hotel selectedHotel = null;

        for(Hotel hotel: model.getHotelList()){
            if(hotel.hotelFound(selectHotelName)){
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        }
        view.changeHotelNameView("Change Hotel Name");
    }

    private void addRoomView(){
        String selectHotelName = view.getManageHotelName();
        Hotel selectedHotel = null;

        for(Hotel hotel: model.getHotelList()){
            if(hotel.hotelFound(selectHotelName)){
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        }
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



    // CREATE HOTEL CONTROLLER
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

    //VIEW HOTEL CONTROLLERS

    private void initializeViewHotelListeners() {
        view.getHighLevelInfoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleViewHotel(true);
            }
        });

        view.getLowLevelInfoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleViewHotel(false);
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

        view.getViewSelectReservation().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSelectReservation(e);
            }
        });
    }

    private void handleViewHotel(boolean isHighLevel){
        String selectedHotelName = view.getViewHotelName();
        Hotel selectedHotel = null;

        for (Hotel hotel : model.getHotelList()) {
            if (hotel.hotelFound(selectedHotelName)) {
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
        String roomName = view.getSelectRoomName();
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

        Room foundRoom = null;
        for (Room r : selectedHotel.getRoomList()) {
            if (r.getRoomName().equalsIgnoreCase(roomName)) {
                foundRoom = r;
                break;
            }
        }

        if (foundRoom == null) {
            JOptionPane.showMessageDialog(view, "Room doesn't exist!");
        } else {
            String selectedRoom = selectedHotel.printRoomDetails(roomName);
            view.displaySelectedRoom(selectedRoom);
        }
    }



    private void handleSelectReservation(ActionEvent e){
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
        String reservationName = view.getSelectReservationName();
        String selectedReservation = selectedHotel.printReservationDetails(reservationName);
        if(selectedReservation.equals("Reservation Not Found.")){
            JOptionPane.showMessageDialog(view, "Reservation Not Found.");
        }
        view.displaySelectedReservation(selectedReservation);

    }


    // MANAGE HOTEL CONTROLLERS

    private void initializeManageHotelListeners() {
        view.getChangeHotelNameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleChangeHotelName();
            }
        });

        view.getStandardRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddStandardRoom();
            }
        });

        view.getDeluxeRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddDeluxeRoom();
            }
        });

        view.getExecutiveRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddExecutiveRoom();
            }
        });

        view.getRemoveRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRemoveRoom();
            }
        });

        view.getUpdateBasePriceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleUpdateBasePrice();
            }
        });
    }

    private void handleChangeHotelName(){
        String selectHotelName = view.getManageHotelName();
        Hotel selectedHotel = null;
        String newHotelName = view.getChangeHotelName();

        for(Hotel hotel: model.getHotelList()){
            if(hotel.hotelFound(selectHotelName)){
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        } else if(selectedHotel.hotelExists(newHotelName, model.getHotelList())){
            JOptionPane.showMessageDialog(view, "Hotel Name Already Exists!");
            return;
        }


        selectedHotel.setHotelName(newHotelName);
        JOptionPane.showMessageDialog(view," Hotel Name Changed Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

    }

    private void handleAddStandardRoom(){
        String selectHotelName = view.getManageHotelName();
        String newRoomName = view.getSelectRoomName();
        Hotel selectedHotel = null;

        for(Hotel hotel: model.getHotelList()){
            if(hotel.hotelFound(selectHotelName)){
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        }

        for(Room r: selectedHotel.getRoomList()){
            if(r.getRoomName().equalsIgnoreCase(newRoomName)){
                JOptionPane.showMessageDialog(view, "Room Already Exists!");
                return;
            }

        }

        if(selectedHotel.getRoomList().size() < 50){
            selectedHotel.addStandardRoom(newRoomName);
            JOptionPane.showMessageDialog(view,"Standard Room Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Standard Room Successfully Added");
        }



    }

    private void handleAddDeluxeRoom(){
        String selectHotelName = view.getManageHotelName();
        String newRoomName = view.getSelectRoomName();
        Hotel selectedHotel = null;

        for(Hotel hotel: model.getHotelList()){
            if(hotel.hotelFound(selectHotelName)){
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        }

        for(Room r: selectedHotel.getRoomList()){
            if(r.getRoomName().equalsIgnoreCase(newRoomName)){
                JOptionPane.showMessageDialog(view, "Room Already Exists!");
                return;
            }

        }

        if(selectedHotel.getRoomList().size() < 50){
            selectedHotel.addDeluxeRoom(newRoomName);
            JOptionPane.showMessageDialog(view,"Deluxe Room Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Deluxe Room Successfully Added");
        }

    }

    private void handleAddExecutiveRoom(){
        String selectHotelName = view.getManageHotelName();
        String newRoomName = view.getSelectRoomName();
        Hotel selectedHotel = null;

        for(Hotel hotel: model.getHotelList()){
            if(hotel.hotelFound(selectHotelName)){
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        }

        for(Room r: selectedHotel.getRoomList()){
            if(r.getRoomName().equalsIgnoreCase(newRoomName)){
                JOptionPane.showMessageDialog(view, "Room Already Exists!");
                return;
            }

        }

        if(selectedHotel.getRoomList().size() < 50){
            selectedHotel.addExecutiveRoom(newRoomName);
            JOptionPane.showMessageDialog(view,"Executive Room Added Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Executive Room Successfully Added");
        }

    }

    private void handleRemoveRoom(){
        String selectHotelName = view.getManageHotelName();
        String selectRemoveName = view.getRemoveRoomName();
        Hotel selectedHotel = null;

        for(Hotel hotel: model.getHotelList()){
            if(hotel.hotelFound(selectHotelName)){
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            return;
        }

        if(selectedHotel.removeRoom(selectRemoveName)){
            JOptionPane.showMessageDialog(view,"Room Removed Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Room Removed Successfully!");
        }else{
            JOptionPane.showMessageDialog(view, "Could Not Remove Room", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void handleUpdateBasePrice(){
        String selectedHotelName = view.getManageHotelName();

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

        try{
            double updatePrice = view.getUpdateBasePrice();
            if(selectedHotel.updateBasePrice(updatePrice)){
                JOptionPane.showMessageDialog(view, "Base Price Updated Sucessfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(view, "Error: Price Invalid/ Reservation exists");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(view, "Invalid Price. Please enter valid price");
        }
    }



    // BOOK ROOM CONTROLLERS

    private void initializeBookRoomListener(){
        view.getBookRoomButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleBookRoom();
            }
        });
    }

    private void handleBookRoom(){
        String selectedHotelName = view.getBookRoomHotelName();
        String guestName = view.getBookGuestName();
        int checkInDate = view.getCheckInDate();
        int checkOutDate = view.getCheckOutDate();
        String roomToBook = view.getRoomToBook();;
        String discountCode = view.getDiscountCode();

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

        Room selectedRoom = null;
        for (Room r : selectedHotel.getRoomList()) {
            if (r.getRoomName().equalsIgnoreCase(roomToBook)) {
                selectedRoom = r;
                break;
            }
        }

        if (selectedRoom == null) {
            JOptionPane.showMessageDialog(view, "Room not found");
            return;
        }

        if(checkInDate < 1 || checkInDate > 31){
            JOptionPane.showMessageDialog(view, "Invalid check-in date. Please enter a date between 1 and 31.");
        }else if(checkInDate == 31){
            JOptionPane.showMessageDialog(view, "Can't check in at the end of the month.");
        }else if(checkOutDate < 1 || checkOutDate > 31){
            JOptionPane.showMessageDialog(view, "Invalid check-in date. Please enter a date between 1 and 31.");
        }else if(checkOutDate == 1){
            JOptionPane.showMessageDialog(view, "Can't check out at the start of the month.");
        }


        boolean reservationAdded = selectedHotel.addReservation(selectedHotel,guestName, checkInDate, checkOutDate, roomToBook, discountCode);

        if(reservationAdded){
            JOptionPane.showMessageDialog(view, "Room Successfully Booked!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(view, "Room is not available for the selected dates");
        }

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
