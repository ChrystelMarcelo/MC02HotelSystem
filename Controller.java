import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener{
    private HotelSystemGUI view;
    private HotelSystem model;


    public Controller(HotelSystemGUI gui, HotelSystem hotelSystem){
        this.view = gui;
        this.model = hotelSystem;

        initializeCreateHotelListener();
        initializeViewHotelListeners();
        initializeManageHotelListeners();
        initializeBookRoomListener();
        gui.setActionListener(this);
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
        view.removeRoomView("Remove Room");
    }

    private void updateRoomBasePriceView(){
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
        view.updateBasePriceView("Update Room Base Price");
    }

    private void removeReservationView(){
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
        view.removeReservationView("Remove Reservation");
    }

    private void removeHotelView(){
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
        view.removeHotelView("Remove Hotel");
    }

    private void modifyDatePriceView(){
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
        view.modifyDatePrice("Modify Date Price");
    }



    //CREATE HOTEL CONTROLLERS

    private void initializeCreateHotelListener(){
        view.getCreateHotelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCreateHotel();
            }
        });
    }

    private void handleCreateHotel(){
        String hotelName = view.getHotelName();
        int roomCount = view.getRoomCount();

        boolean hotelExist = false;
        for (Hotel h : model.getHotelList()) {
            if (h.hotelFound(hotelName)) {
                hotelExist = true;
            }
        }

        if(hotelExist){
            JOptionPane.showMessageDialog(view, "Hotel Already Exists!");
        }else if((roomCount < 1) || (roomCount > 50)){
            JOptionPane.showMessageDialog(view, "Enter number of rooms from 1 - 50 only. ");
            }

        Hotel hotel = new Hotel(hotelName, roomCount);
        model.getHotelList().add(hotel);
        JOptionPane.showMessageDialog(view, hotelName + " Hotel Added Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        System.out.println(hotelName + " hotel successfully added in the system");
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
            System.out.println(selectedRoom);
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
        System.out.println(selectedReservation);

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

        view.getRemoveReservationButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRemoveReservation();
            }
        });

        view.getRemoveHotelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleRemoveHotel();
            }
        });

        view.getModifyDatePriceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDatePriceModifier();
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

        if(selectedHotel.hotelExists(newHotelName, model.getHotelList())){
            JOptionPane.showMessageDialog(view, "Hotel Name Already Exists!");
            System.out.println("Hotel Name Already Exists!");
            return;
        }


        selectedHotel.setHotelName(newHotelName);
        JOptionPane.showMessageDialog(view," Hotel Name Changed Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Hotel Name Changed Successfully");

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

        for(Room r: selectedHotel.getRoomList()){
            if(r.getRoomName().equalsIgnoreCase(newRoomName)){
                JOptionPane.showMessageDialog(view, "Room Already Exists!");
                System.out.println("Room Already Exists!");
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

        for(Room r: selectedHotel.getRoomList()){
            if(r.getRoomName().equalsIgnoreCase(newRoomName)){
                JOptionPane.showMessageDialog(view, "Room Already Exists!");
                System.out.println("Room Already Exists!");
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
        for(Room r: selectedHotel.getRoomList()){
            if(r.getRoomName().equalsIgnoreCase(newRoomName)){
                JOptionPane.showMessageDialog(view, "Room Already Exists!");
                System.out.println("Room Already Exists!");
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

        if(selectedHotel.removeRoom(selectRemoveName)){
            JOptionPane.showMessageDialog(view,"Room Removed Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Room Removed Successfully!");
        }else{
            JOptionPane.showMessageDialog(view, "Could Not Remove Room", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Could Not Remove Room");
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

        try{
            double updatePrice = view.getUpdateBasePrice();
            if(selectedHotel.updateBasePrice(updatePrice)){
                JOptionPane.showMessageDialog(view, "Base Price Updated Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Base Price Update Successfully!");
            }else{
                JOptionPane.showMessageDialog(view, "Error: Price Invalid/ Reservation exists");
                System.out.println("Error: Price Invalid/ Reservation exists");
            }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(view, "Invalid Price. Please enter valid price");
            System.out.println("Invalid Price. Please enter valid price");
        }
    }

    private void handleRemoveReservation(){
        String selectedHotelName = view.getManageHotelName();
        String guestName = view.getRemoveReservation();

        Hotel selectedHotel = null;
        for (Hotel hotel : model.getHotelList()) {
            if (hotel.getHotelName().equals(selectedHotelName)) {
                selectedHotel = hotel;
                break;
            }
        }

        if(!selectedHotel.isReservationEmpty()){
            boolean removedRes = selectedHotel.removeReservation(guestName);
            if(removedRes){
                JOptionPane.showMessageDialog(view, "Reservation Removed", "Success", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Reservation Removed");
            }
        }else{
            JOptionPane.showMessageDialog(view, "No Reservation Exists", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println("No Reservation Exists");
        }
    }

    private void handleRemoveHotel(){
        String selectedHotelName = view.getManageHotelName();
        Hotel selectedHotel = null;
        for (Hotel hotel : model.getHotelList()) {
            if (hotel.getHotelName().equals(selectedHotelName)) {
                selectedHotel = hotel;
                break;
            }
        }

        boolean removeHotel = selectedHotel.removeHotel(selectedHotelName, model.getHotelList());
        if(removeHotel){
            JOptionPane.showMessageDialog(view, "Hotel Removed", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Hotel Removed");
        }
    }

    private void handleDatePriceModifier(){
        int i;
        String selectedHotelName = view.getManageHotelName();
        int day = view.getDateForModifier();
        double modifier = view.getPriceForModifier();

        Hotel selectedHotel = null;
        for (Hotel hotel : model.getHotelList()) {
            if (hotel.getHotelName().equals(selectedHotelName)) {
                selectedHotel = hotel;
                break;
            }
        }


        if(!selectedHotel.isReservationEmpty()){
            selectedHotel.setDatePriceModifier(day, modifier);
            selectedHotel.updateAffectedReservation(day);
            JOptionPane.showMessageDialog(view, "Price Modified", "Success", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Price Modified");
        }else{
            JOptionPane.showMessageDialog(view, "There are currently no reservations in the system", "Error!", JOptionPane.ERROR_MESSAGE);
            System.out.println("There are currently no reservations in the system");
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

    private void handleBookRoom() {
        String selectedHotelName = view.getBookRoomHotelName();
        String guestName = view.getBookGuestName();
        String checkInDateStr = view.getCheckInDate();
        String checkOutDateStr = view.getCheckOutDate();
        String roomToBook = view.getRoomToBook();
        String discountCode = view.getDiscountCode();


        if (selectedHotelName.isEmpty() || guestName.isEmpty() || checkInDateStr.isEmpty() || checkOutDateStr.isEmpty() || roomToBook.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Fields must be filled out.");
            System.out.println("Fields must be filled out");
            return;
        }



        int checkInDate;
        int checkOutDate;

        try {
            checkInDate = Integer.parseInt(checkInDateStr);
            checkOutDate = Integer.parseInt(checkOutDateStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Check-in and check-out dates must be valid numbers.");
            System.out.println("Check-in and check-out dates must be valid numbers.");
            return;
        }


        if (checkInDate < 1 || checkInDate > 31) {
            JOptionPane.showMessageDialog(view, "Invalid check-in date. Please enter a date between 1 and 31.");
            System.out.println("Invalid check-in date. Please enter a date between 1 and 31.");
            return;
        }
        if (checkInDate == 31) {
            JOptionPane.showMessageDialog(view, "Can't check in at the end of the month.");
            System.out.println("Can't check in at the end of the month.");
            return;
        }
        if (checkOutDate < 1 || checkOutDate > 31) {
            JOptionPane.showMessageDialog(view, "Invalid check-out date. Please enter a date between 1 and 31.");
            System.out.println("Invalid check-out date. Please enter a date between 1 and 31.");
            return;
        }
        if (checkOutDate == 1) {
            JOptionPane.showMessageDialog(view, "Can't check out at the start of the month.");
            System.out.println("Can't check out at the start of the month.");
            return;
        }


        Hotel selectedHotel = null;
        for (Hotel hotel : model.getHotelList()) {
            if (hotel.getHotelName().equals(selectedHotelName)) {
                selectedHotel = hotel;
                break;
            }
        }

        if (selectedHotel == null) {
            JOptionPane.showMessageDialog(view, "Hotel not found.");
            System.out.println("Hotel not found.");
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
            System.out.println("Room not found.");
            return;
        }


        boolean reservationAdded = selectedHotel.addReservation(selectedHotel, guestName, checkInDate, checkOutDate, roomToBook, discountCode);

        if (reservationAdded) {
            JOptionPane.showMessageDialog(view, "Room Successfully Booked!", "Success!", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Room Successfully Booked!");
        } else {
            JOptionPane.showMessageDialog(view, "Room is not available for the selected dates");
            System.out.println("Room is not available for the selected dates");
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
        }
    }


}
