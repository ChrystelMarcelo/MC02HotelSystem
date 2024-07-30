import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionListener;

public class HotelSystemGUI extends JFrame {


    private JButton addHotel;
    private JButton viewHotel;
    private JButton manageHotel;
    private JButton bookRoom;
    private JButton backButton;
    private JButton createHotel;

    private JButton highLevelInfo;
    private JButton lowLevelInfo;
    private JButton availableRooms;
    private JButton selectRoom;
    private JButton selectReservation;
    private JButton viewAvailableRooms;
    private JButton viewSelectRoom;
    private JButton viewSelectReservation;

    private JButton changeHotelName;
    private JButton addRoom;
    private JButton removeRoom;
    private JButton updateBasePrice;
    private JButton removeReservation;
    private JButton removeHotel;
    private JButton modifyDatePrice;

    private JButton changeHotel;
    private JButton standardRoom;
    private JButton deluxeRoom;
    private JButton executiveRoom;

    private JButton removeNameRoom;

    private JButton reserveRoom;
    private JButton updateBasePriceRoom;
    private JButton removeGuestReservation;
    private JButton removeHotelName;
    private JButton changeDatePrice;

    private JTextField tfHotelName;
    private JTextField tfViewHotelName;
    private JTextField tfRoomCount;
    private JTextField tfDate;
    private JTextField tfRoomName;
    private JTextField tfGuestName;
    private JTextField tfCheckIn;
    private JTextField tfCheckOut;
    private JTextField tfPriceModifier;
    private JTextField tfViewRoomSelect;
    private JTextField tfManageHotelName;
    private JTextField tfChangeHotelName;
    private JTextField tfAddRoomName;

    private JTextArea taAvailability;
    private JTextArea taRoomInfo;
    private JTextArea taReservationInfo;


    HotelSystemGUI(){
        super("Hotel System");
        HotelMenuGUI();
    }

    public void HotelMenuGUI(){
        setLayout(new BorderLayout());

        setSize(500, 600);
        init();

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private void init(){
        //NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblHotel = new JLabel("Hotel Menu");
        lblHotel.setForeground(Color.white);
        lblHotel.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblHotel);

        this.add(panelNorth, BorderLayout.NORTH);

        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);


        // HOTEL MENU BUTTONS
        addHotel = new JButton("Create Hotel");
        addHotel.setBounds(100, 50, 300, 50);
        panelCenter.add(addHotel);
        viewHotel = new JButton("View Hotel");
        viewHotel.setBounds(100, 120, 300, 50);
        panelCenter.add(viewHotel);
        manageHotel = new JButton("Manage Hotel");
        manageHotel.setBounds(100, 190, 300, 50);
        panelCenter.add(manageHotel);
        bookRoom = new JButton("Book Room");
        bookRoom.setBounds(100, 260, 300, 50);
        panelCenter.add(bookRoom);

        //CREATE HOTEL BUTTON
        createHotel = new JButton("Confirm Hotel");

        // VIEW HOTEL BUTTONS
        highLevelInfo = new JButton("High Info");
        lowLevelInfo = new JButton("Low Info");
        availableRooms = new JButton("Available Rooms");
        selectRoom = new JButton("Select Room");
        selectReservation = new JButton("Select Reservation");
        viewAvailableRooms = new JButton("View Rooms");
        viewSelectRoom = new JButton("View Room");
        viewSelectReservation = new JButton("View Reservation");

        //MANAGE HOTEL BUTTONS
        changeHotelName = new JButton("Change Hotel Name");
        addRoom = new JButton("Add Room");
        removeRoom = new JButton("Remove Room");
        updateBasePrice = new JButton("Update Room Base Price");
        removeReservation = new JButton("Remove Reservation");
        removeHotel = new JButton("Remove Hotel");
        modifyDatePrice = new JButton("Modify Date Price");

        // change hotel name button
        changeHotel = new JButton("Change Hotel Name");

        //add room button
        standardRoom = new JButton("Add Standard Room");
        deluxeRoom = new JButton("Add Deluxe Room");
        executiveRoom = new JButton("Add Executive Room");

        //removeRoom
        removeNameRoom = new JButton("Remove Room No.");

        //updateBasePrice
        updateBasePriceRoom = new JButton("Update Price");

        //removeReservation
        removeGuestReservation = new JButton("Remove Booking");

        //removeHotel
        removeHotelName = new JButton("Discard Hotel");

        //modifyDatePrice
        changeDatePrice = new JButton("Modify Price");

        this.add(panelCenter, BorderLayout.CENTER);
    }


    public void createHotelWindow(String title){
        JFrame createHotelFrame = new JFrame(title);
        createHotelFrame.setSize(500, 600);
        createHotelFrame.setLayout(new BorderLayout());


        inCreateHotel(createHotelFrame);


        createHotelFrame.setVisible(true);
        setResizable(false);
        createHotelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private void inCreateHotel(JFrame frame){
        //NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lbladdHotel = new JLabel("Create Hotel");
        lbladdHotel.setForeground(Color.white);
        lbladdHotel.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lbladdHotel);

        frame.add(panelNorth, BorderLayout.NORTH);

        //CENTER PANEL

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter Hotel Name: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(175, 50, 300, 50);
        panelCenter.add(lblHotelName);

        tfHotelName = new JTextField(20);
        tfHotelName.setBounds(100, 100, 300, 35);
        panelCenter.add(tfHotelName);

        JLabel lblRoomCount = new JLabel("Enter Number of Rooms: ");
        lblRoomCount.setForeground(Color.black);
        lblRoomCount.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblRoomCount.setBounds(175, 150, 300, 50);
        panelCenter.add(lblRoomCount);

        tfRoomCount = new JTextField(20);
        tfRoomCount.setBounds(100, 200, 300, 35);
        panelCenter.add(tfRoomCount);


        createHotel.setBounds(100, 350, 300, 50);
        panelCenter.add(createHotel);

        frame.add(panelCenter, BorderLayout.CENTER);


        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.dispose());
        panelSouth.add(backButton);

        frame.add(panelSouth, BorderLayout.SOUTH);
    }


    public void viewHotelWindow(String title){
        JFrame viewHotelFrame = new JFrame(title);
        viewHotelFrame.setSize(500, 600);
        viewHotelFrame.setLayout(new BorderLayout());

        inViewHotel(viewHotelFrame);

        viewHotelFrame.setVisible(true);
        setResizable(false);
        viewHotelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inViewHotel(JFrame frame){
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("View Hotel");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        frame.add(panelNorth, BorderLayout.NORTH);

        //CENTER PANEL

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter Selected Hotel Name: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(150, 50, 300, 50);
        panelCenter.add(lblHotelName);

        tfViewHotelName = new JTextField(20);
        tfViewHotelName.setBounds(100, 100, 300, 35);
        panelCenter.add(tfViewHotelName);



        highLevelInfo.setBounds(100, 250, 300, 50);
        panelCenter.add(highLevelInfo);


        lowLevelInfo.setBounds(100, 300, 300, 50);
        panelCenter.add(lowLevelInfo);

        frame.add(panelCenter, BorderLayout.CENTER);


        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.dispose());
        panelSouth.add(backButton);

        frame.add(panelSouth, BorderLayout.SOUTH);


    }

    public void highInfoView(String title, String hotelName, int roomCount){
        JFrame highInfoFrame = new JFrame(title);
        highInfoFrame.setSize(500, 600);
        highInfoFrame.setLayout(new BorderLayout());

        //North PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("High Level Information");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        highInfoFrame.add(panelNorth, BorderLayout.NORTH);

        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.setBackground(Color.white);

        JLabel lblHotelInfo = new JLabel("<html>Hotel Name: " + hotelName + "<br>Total Number of Rooms: " + roomCount + "</html>");
        lblHotelInfo.setForeground(Color.black);
        lblHotelInfo.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelCenter.add(lblHotelInfo);

        highInfoFrame.add(panelCenter, BorderLayout.CENTER);


        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> highInfoFrame.dispose());
        panelSouth.add(backButton);

        highInfoFrame.add(panelSouth, BorderLayout.SOUTH);


        highInfoFrame.setVisible(true);
        setResizable(false);
        highInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void lowInfoView(String title){
        JFrame lowInfoFrame = new JFrame(title);
        lowInfoFrame.setSize(500, 600);
        lowInfoFrame.setLayout(new BorderLayout());

        inLowInfo(lowInfoFrame);

        lowInfoFrame.setVisible(true);
        setResizable(false);
        lowInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inLowInfo(JFrame frame){
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Low Level Information");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        frame.add(panelNorth, BorderLayout.NORTH);


        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        availableRooms.setBounds(100, 50, 300, 50);
        panelCenter.add(availableRooms);

        selectRoom.setBounds(100, 120, 300, 50);
        panelCenter.add(selectRoom);

        selectReservation.setBounds(100, 190, 300, 50);
        panelCenter.add(selectReservation);

        frame.add(panelCenter, BorderLayout.CENTER);

        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.dispose());
        panelSouth.add(backButton);

        frame.add(panelSouth, BorderLayout.SOUTH);
    }

    public void viewAvailableRooms(String title){
        JFrame availableRoomsFrame = new JFrame(title);
        availableRoomsFrame.setSize(500, 600);
        availableRoomsFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Available and Booked Rooms");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        availableRoomsFrame.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblDate = new JLabel("Enter Date To Check Availability: ");
        lblDate.setForeground(Color.black);
        lblDate.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblDate.setBounds(130, 50, 300, 50);
        panelCenter.add(lblDate);

        tfDate = new JTextField();
        tfDate.setBounds(100, 100, 300, 35);
        panelCenter.add(tfDate);


        viewAvailableRooms.setBounds(100, 150, 300, 50);
        panelCenter.add(viewAvailableRooms);

        taAvailability = new JTextArea();
        taAvailability.setEditable(false);
        taAvailability.setLineWrap(true);
        taAvailability.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(taAvailability);
        scrollPane.setBounds(100, 250, 300, 200);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelCenter.add(scrollPane);

        availableRoomsFrame.add(panelCenter, BorderLayout.CENTER);

        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> availableRoomsFrame.dispose());
        panelSouth.add(backButton);

        availableRoomsFrame.add(panelSouth, BorderLayout.SOUTH);


        availableRoomsFrame.setVisible(true);
        setResizable(false);
        availableRoomsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void viewSelectRoom(String title){
        JFrame selectedRoomFrame = new JFrame(title);
        selectedRoomFrame.setSize(500, 600);
        selectedRoomFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Room Information");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        selectedRoomFrame.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblDate = new JLabel("Enter Room Name to View: ");
        lblDate.setForeground(Color.black);
        lblDate.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblDate.setBounds(150, 50, 300, 50);
        panelCenter.add(lblDate);

        tfViewRoomSelect = new JTextField();
        tfViewRoomSelect.setBounds(100, 100, 300, 35);
        panelCenter.add(tfViewRoomSelect);


        viewSelectRoom.setBounds(100, 150, 300, 50);
        panelCenter.add(viewSelectRoom);

        taRoomInfo = new JTextArea();
        taRoomInfo.setEditable(false);
        taRoomInfo.setLineWrap(true);
        taRoomInfo.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(taRoomInfo);
        scrollPane.setBounds(80, 250, 350, 200);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelCenter.add(scrollPane);

        selectedRoomFrame.add(panelCenter, BorderLayout.CENTER);


        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> selectedRoomFrame.dispose());
        panelSouth.add(backButton);

        selectedRoomFrame.add(panelSouth, BorderLayout.SOUTH);


        selectedRoomFrame.setVisible(true);
        setResizable(false);
        selectedRoomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void viewSelectReservation(String title){
        JFrame selectedReservationFrame = new JFrame(title);
        selectedReservationFrame.setSize(500, 600);
        selectedReservationFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Reservation Information");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        selectedReservationFrame.add(panelNorth, BorderLayout.NORTH);

        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblDate = new JLabel("Enter Guest Name Under Reservation: ");
        lblDate.setForeground(Color.black);
        lblDate.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblDate.setBounds(110, 50, 300, 50);
        panelCenter.add(lblDate);

        tfGuestName = new JTextField();
        tfGuestName.setBounds(100, 100, 300, 35);
        panelCenter.add(tfGuestName);


        viewSelectReservation.setBounds(100, 150, 300, 50);
        panelCenter.add(viewSelectReservation);

        taReservationInfo = new JTextArea();
        taReservationInfo .setEditable(false);
        taReservationInfo .setLineWrap(true);
        taReservationInfo .setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(taReservationInfo);
        scrollPane.setBounds(100, 250, 300, 200);

        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panelCenter.add(scrollPane);

        selectedReservationFrame.add(panelCenter, BorderLayout.CENTER);


        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> selectedReservationFrame.dispose());
        panelSouth.add(backButton);

        selectedReservationFrame.add(panelSouth, BorderLayout.SOUTH);


        selectedReservationFrame.setVisible(true);
        setResizable(false);
        selectedReservationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }




    public void manageHotelView(String title){
        JFrame manageHotelFrame = new JFrame(title);
        manageHotelFrame.setSize(500, 600);
        manageHotelFrame.setLayout(new BorderLayout());


        inManageHotel(manageHotelFrame);


        manageHotelFrame.setVisible(true);
        setResizable(false);
        manageHotelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void inManageHotel(JFrame frame){
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Manage Hotel");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        frame.add(panelNorth, BorderLayout.NORTH);

        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter Hotel Name to Manage: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(140, 10, 300, 50);
        panelCenter.add(lblHotelName);

        tfManageHotelName = new JTextField(20);
        tfManageHotelName.setBounds(100, 45, 300, 35);
        panelCenter.add(tfManageHotelName);


        changeHotelName.setBounds(100, 100, 300, 50);
        panelCenter.add(changeHotelName);


        addRoom.setBounds(100, 150, 300, 50);
        panelCenter.add(addRoom);


        removeRoom.setBounds(100, 200, 300, 50);
        panelCenter.add(removeRoom);


        updateBasePrice.setBounds(100, 250, 300, 50);
        panelCenter.add(updateBasePrice);


        removeReservation.setBounds(100, 300, 300, 50);
        panelCenter.add(removeReservation);


        removeHotel.setBounds(100, 350, 300, 50);
        panelCenter.add(removeHotel);


        modifyDatePrice.setBounds(100, 400, 300, 50);
        panelCenter.add(modifyDatePrice);

        frame.add(panelCenter, BorderLayout.CENTER);



        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.dispose());
        panelSouth.add(backButton);

        frame.add(panelSouth, BorderLayout.SOUTH);

    }


    public void changeHotelNameView(String title){
        JFrame changeHotelNameFrame = new JFrame(title);
        changeHotelNameFrame.setSize(500, 600);
        changeHotelNameFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Change Hotel Name");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        changeHotelNameFrame.add(panelNorth, BorderLayout.NORTH);

        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter New Hotel Name: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(150, 50, 300, 50);
        panelCenter.add(lblHotelName);

        tfChangeHotelName = new JTextField(20);
        tfChangeHotelName.setBounds(100, 100, 300, 35);
        panelCenter.add(tfChangeHotelName);

        changeHotel.setBounds(100, 200, 300, 50);
        panelCenter.add(changeHotel);



        changeHotelNameFrame.add(panelCenter, BorderLayout.CENTER);

        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> changeHotelNameFrame.dispose());
        panelSouth.add(backButton);

        changeHotelNameFrame.add(panelSouth, BorderLayout.SOUTH);


        changeHotelNameFrame.setVisible(true);
        setResizable(false);
        changeHotelNameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void addRoomView(String title){

        JFrame addRoomViewFrame = new JFrame(title);
        addRoomViewFrame.setSize(500, 600);
        addRoomViewFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Add Room");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);
        addRoomViewFrame.add(panelNorth, BorderLayout.NORTH);


        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter New Room Name: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(150, 50, 300, 50);
        panelCenter.add(lblHotelName);

        tfAddRoomName = new JTextField(20);
        tfAddRoomName.setBounds(100, 100, 300, 35);
        panelCenter.add(tfAddRoomName);


        standardRoom.setBounds(100, 200, 300, 50);
        panelCenter.add(standardRoom);

        deluxeRoom.setBounds(100, 250, 300, 50);
        panelCenter.add(deluxeRoom);

        executiveRoom.setBounds(100, 300, 300, 50);
        panelCenter.add(executiveRoom);


        addRoomViewFrame.add(panelCenter, BorderLayout.CENTER);


        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> addRoomViewFrame.dispose());
        panelSouth.add(backButton);

        addRoomViewFrame.add(panelSouth, BorderLayout.SOUTH);



        addRoomViewFrame.setVisible(true);
        setResizable(false);
        addRoomViewFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void removeRoomView(String title){
        JFrame removeRoomFrame = new JFrame(title);
        removeRoomFrame.setSize(500, 600);
        removeRoomFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Remove Room");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        removeRoomFrame.add(panelNorth, BorderLayout.NORTH);


        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter Room Name To Remove: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(130, 50, 300, 50);
        panelCenter.add(lblHotelName);

        tfRoomName = new JTextField(20);
        tfRoomName.setBounds(100, 100, 300, 35);
        panelCenter.add(tfRoomName);

        removeNameRoom.setBounds(100, 200, 300, 50);
        panelCenter.add(removeNameRoom);

        removeRoomFrame.add(panelCenter, BorderLayout.CENTER);

        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> removeRoomFrame.dispose());
        panelSouth.add(backButton);

        removeRoomFrame.add(panelSouth, BorderLayout.SOUTH);


        removeRoomFrame.setVisible(true);
        setResizable(false);
        removeRoomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void updateBasePriceView(String title){
        JFrame updateBasePriceFrame = new JFrame(title);
        updateBasePriceFrame.setSize(500, 600);
        updateBasePriceFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Update Base Price");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        updateBasePriceFrame.add(panelNorth, BorderLayout.NORTH);

        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter New Base Price: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(150, 50, 300, 50);
        panelCenter.add(lblHotelName);

        tfRoomName = new JTextField(20);
        tfRoomName.setBounds(100, 100, 300, 35);
        panelCenter.add(tfRoomName);

        updateBasePriceRoom.setBounds(100, 200, 300, 50);
        panelCenter.add(updateBasePriceRoom);

        updateBasePriceFrame.add(panelCenter, BorderLayout.CENTER);


        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> updateBasePriceFrame.dispose());
        panelSouth.add(backButton);

        updateBasePriceFrame.add(panelSouth, BorderLayout.SOUTH);

        updateBasePriceFrame.setVisible(true);
        setResizable(false);
        updateBasePriceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void removeReservationView(String title){
        JFrame removeReservationFrame = new JFrame(title);
        removeReservationFrame.setSize(500, 600);
        removeReservationFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Remove Reservation");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        removeReservationFrame.add(panelNorth, BorderLayout.NORTH);

        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter Guest Name Under Reservation: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(105, 50, 300, 50);
        panelCenter.add(lblHotelName);

        tfRoomName = new JTextField(20);
        tfRoomName.setBounds(100, 100, 300, 35);
        panelCenter.add(tfRoomName);

        removeGuestReservation.setBounds(100, 200, 300, 50);
        panelCenter.add(removeGuestReservation);

        removeReservationFrame.add(panelCenter, BorderLayout.CENTER);


        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> removeReservationFrame.dispose());
        panelSouth.add(backButton);

        removeReservationFrame.add(panelSouth, BorderLayout.SOUTH);

        removeReservationFrame.setVisible(true);
        setResizable(false);
        removeReservationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void removeHotelView(String title){
        JFrame removeHotelFrame = new JFrame(title);
        removeHotelFrame.setSize(500, 600);
        removeHotelFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Remove Hotel");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        removeHotelFrame.add(panelNorth, BorderLayout.NORTH);


        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter Hotel Name to Remove: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(120, 50, 300, 50);
        panelCenter.add(lblHotelName);

        tfRoomName = new JTextField(20);
        tfRoomName.setBounds(100, 100, 300, 35);
        panelCenter.add(tfRoomName);

        removeHotelName.setBounds(100, 200, 300, 50);
        panelCenter.add(removeHotelName);

        removeHotelFrame.add(panelCenter, BorderLayout.CENTER);

        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> removeHotelFrame.dispose());
        panelSouth.add(backButton);

        removeHotelFrame.add(panelSouth, BorderLayout.SOUTH);

        removeHotelFrame.setVisible(true);
        setResizable(false);
        removeHotelFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void modifyDatePrice(String title){
        JFrame modifyDatePriceFrame = new JFrame(title);
        modifyDatePriceFrame.setSize(500, 600);
        modifyDatePriceFrame.setLayout(new BorderLayout());

        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Modify Date Price");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);

        modifyDatePriceFrame.add(panelNorth, BorderLayout.NORTH);


        //CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter Number Of Days To Modify: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(105, 30, 300, 50);
        panelCenter.add(lblHotelName);

        tfHotelName = new JTextField(20);
        tfHotelName.setBounds(100, 70, 300, 35);
        panelCenter.add(tfHotelName);

        JLabel lblDate = new JLabel("Enter day(1-31): ");
        lblDate.setForeground(Color.black);
        lblDate.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblDate.setBounds(110, 110, 300, 50);
        panelCenter.add(lblDate);

        tfDate = new JTextField(20);
        tfDate.setBounds(100, 150, 300, 35);
        panelCenter.add(tfDate);

        JLabel lblPriceModifier = new JLabel("Enter Price Modifier: ");
        lblPriceModifier.setForeground(Color.black);
        lblPriceModifier.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblPriceModifier.setBounds(110, 190, 300, 50);
        panelCenter.add(lblPriceModifier);

        tfPriceModifier = new JTextField(20);
        tfPriceModifier.setBounds(100, 230, 300, 35);
        panelCenter.add(tfPriceModifier);

        changeDatePrice.setBounds(100, 300, 300, 50);
        panelCenter.add(changeDatePrice);

        modifyDatePriceFrame.add(panelCenter, BorderLayout.CENTER);

        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> modifyDatePriceFrame.dispose());
        panelSouth.add(backButton);

        modifyDatePriceFrame.add(panelSouth, BorderLayout.SOUTH);

        modifyDatePriceFrame.setVisible(true);
        setResizable(false);
        modifyDatePriceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public void bookRoomView(String title){
        JFrame bookRoomFrame = new JFrame(title);
        bookRoomFrame.setSize(500, 600);
        bookRoomFrame.setLayout(new BorderLayout());


        inBookRoom(bookRoomFrame);


        bookRoomFrame.setVisible(true);
        setResizable(false);
        bookRoomFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    private void inBookRoom(JFrame frame){
        // NORTH PANEL
        JPanel panelNorth = new JPanel();
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(Color.PINK);

        JLabel lblTitle = new JLabel("Book Room");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        panelNorth.add(lblTitle);


        // CENTER PANEL
        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(null);
        panelCenter.setBackground(Color.white);

        JLabel lblHotelName = new JLabel("Enter Hotel To Book Room: ");
        lblHotelName.setForeground(Color.black);
        lblHotelName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblHotelName.setBounds(150, 5, 300, 50);
        panelCenter.add(lblHotelName);

        tfHotelName = new JTextField(20);
        tfHotelName.setBounds(100, 40, 300, 35);
        panelCenter.add(tfHotelName);

        JLabel lblGuestName = new JLabel("Enter Guest Name: ");
        lblGuestName.setForeground(Color.black);
        lblGuestName.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblGuestName.setBounds(175, 70, 300, 50);
        panelCenter.add(lblGuestName);

        tfGuestName = new JTextField(20);
        tfGuestName.setBounds(100, 105, 300, 35);
        panelCenter.add(tfGuestName);


        JLabel lblCheckIn = new JLabel("Check-In Date: ");
        lblCheckIn.setForeground(Color.black);
        lblCheckIn.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblCheckIn.setBounds(190, 140, 300, 50);
        panelCenter.add(lblCheckIn);

        tfCheckIn = new JTextField(20);
        tfCheckIn.setBounds(100, 175, 300, 35);
        panelCenter.add(tfCheckIn);

        JLabel lblCheckOut = new JLabel("Check-Out Date: ");
        lblCheckOut.setForeground(Color.black);
        lblCheckOut.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblCheckOut.setBounds(190, 210, 300, 50);
        panelCenter.add(lblCheckOut);

        tfCheckOut = new JTextField(20);
        tfCheckOut.setBounds(100, 245, 300, 35);
        panelCenter.add(tfCheckOut);


        JLabel lblroomBook = new JLabel("Room To Book ");
        lblroomBook.setForeground(Color.black);
        lblroomBook.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblroomBook.setBounds(190, 280, 300, 50);
        panelCenter.add(lblroomBook);

        tfCheckOut = new JTextField(20);
        tfCheckOut.setBounds(100, 315, 300, 35);
        panelCenter.add(tfCheckOut);

        JLabel lblDiscountCode = new JLabel("Discount Code ");
        lblDiscountCode.setForeground(Color.black);
        lblDiscountCode.setFont(new Font("Verdana", Font.PLAIN, 15));
        lblDiscountCode.setBounds(190, 350, 300, 50);
        panelCenter.add(lblDiscountCode);

        tfCheckOut = new JTextField(20);
        tfCheckOut.setBounds(100, 385, 300, 35);
        panelCenter.add(tfCheckOut);


        reserveRoom = new JButton("Book Room");
        reserveRoom.setBounds(100, 440, 300, 50);
        panelCenter.add(reserveRoom);

        frame.add(panelCenter, BorderLayout.CENTER);


        //SOUTH PANEL with BACK BUTTON
        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new FlowLayout());
        panelSouth.setBackground(Color.PINK);

        backButton = new JButton("Back");
        backButton.addActionListener(e -> frame.dispose());
        panelSouth.add(backButton);

        frame.add(panelSouth, BorderLayout.SOUTH);


        frame.add(panelNorth, BorderLayout.NORTH);
    }






    public String getHotelName(){
        return tfHotelName.getText();
    }

    public String getViewHotelName(){
        return tfViewHotelName.getText();
    }

    public int getTfDate(){
        return Integer.parseInt(tfDate.getText());
    }

    public void displayAvailability(String availability) {
        taAvailability.setText(availability);
        taAvailability.setVisible(true);
    }

    public void displaySelectedRoom(String selectedRoom){
        taRoomInfo.setText(selectedRoom);
        taRoomInfo.setVisible(true);
    }

    public void displaySelectedReservation(String selectedReservation){
        taReservationInfo.setText(selectedReservation);
        taReservationInfo.setVisible(true);
    }

    public String getSelectRoomName(){
        return tfViewRoomSelect.getText();
    }

    public String getSelectReservationName(){
        return tfGuestName.getText();
    }

    public int getRoomCount() {
        String roomCountStr = tfRoomCount.getText();

        if (roomCountStr == null || roomCountStr.isEmpty()) {
            // Handle the case where the input is empty
            System.out.println("Room count cannot be empty.");
            return -1; // or any other value indicating an invalid input
        }

        if (!isNumeric(roomCountStr)) {
            // Handle the case where the input is not numeric
            System.out.println("Invalid room count. Please enter a numeric value.");
            return -1; // or any other value indicating an invalid input
        }

        int roomCount = Integer.parseInt(roomCountStr);

        if (roomCount < 1 || roomCount > 50) {
            // Handle the case where the room count is out of the acceptable range
            System.out.println("Enter number of rooms from 1 - 50 only.");
            return -1; // or any other value indicating an invalid input
        }

        return roomCount;
    }



    public JButton getHighLevelInfoButton(){

        return highLevelInfo;
    }

    public JButton getLowLevelInfoButton(){

        return lowLevelInfo;
    }

    public JButton getViewAvailableRooms(){

        return viewAvailableRooms;
    }

    public JButton getViewSelectRoom(){
        return viewSelectRoom;
    }

    public JButton getViewSelectReservation(){
        return viewSelectReservation;
    }


    //MANAGE HOTEL FUNCTIONS

    public String getManageHotelName(){
        return tfManageHotelName.getText();
    }

    public String getChangeHotelName(){
        return tfChangeHotelName.getText();
    }


    public JButton getChangeHotelNameButton(){
        return changeHotel;
    }

    public JButton getAddRoomButton(){
        return addRoom;
    }
    
    public JButton getStandardRoomButton(){
        return standardRoom;
    }
    
    public JButton getDeluxeRoomButton(){
        return deluxeRoom;
    }
    
    public JButton getExecutiveRoomButton(){
        return deluxeRoom;
    }
    
    public JButton getRemoveRoomButton(){
        return removeRoom;
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









    public void setActionListener(ActionListener listener){
        addHotel.addActionListener(listener);
        viewHotel.addActionListener(listener);
        manageHotel.addActionListener(listener);
        bookRoom.addActionListener(listener);
        highLevelInfo.addActionListener(listener);
        lowLevelInfo.addActionListener(listener);
        availableRooms.addActionListener(listener);
        selectRoom.addActionListener(listener);
        selectReservation.addActionListener(listener);
        changeHotelName.addActionListener(listener);
        addRoom.addActionListener(listener);
        removeRoom.addActionListener(listener);
        updateBasePrice.addActionListener(listener);
        removeReservation.addActionListener(listener);
        removeHotel.addActionListener(listener);
        modifyDatePrice.addActionListener(listener);
        createHotel.addActionListener(listener);
    }

    public void setDocumentListener(DocumentListener listener){
        // tfName.getDocument().addDocumentListener(listener);
    }

}
