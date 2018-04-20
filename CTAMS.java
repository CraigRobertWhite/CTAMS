import java.awt.*;
import java.util.*;
import javax.swing.*;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 * CTAMS is the main class that holds the GUI and bulk of the program.
 *
 * @author Craig White
 * @version 2.0
 * @since 2018-04-13
 */
public class CTAMS extends javax.swing.JFrame
{

    private ArrayList<Director> directors = new ArrayList<Director>();          //List to hold all current directors
    private ArrayList<Actor> actors = new ArrayList<Actor>();                   //List to hold all current actors
    private ArrayList<Event> events = new ArrayList<Event>();                   //List to hold all events
    private ArrayList<String> parts = new ArrayList<String>();                  //List to hold all parts of events
    private ArrayList<Audition> auditions = new ArrayList<Audition>();          //List to hold all current auditions
    private String[] arrayOfStrings = null;                                     //Array that holds strings when converting lists

    //The following are the days in each month. This may seem super inefficient but it's the best way I know when dealing with JLists
    private String[] january = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                        "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                        "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] february = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                         "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                         "22", "23", "24", "25", "26", "27", "28"};
    private String[] march = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                      "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                      "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] april = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                      "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                      "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    private String[] may = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                    "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                    "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] june = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                     "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                     "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    private String[] july = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                     "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                     "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] august = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                       "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                       "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] september = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                          "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                          "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    private String[] october = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                        "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                        "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
    private String[] november = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                         "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                         "22", "23", "24", "25", "26", "27", "28", "29", "30"};
    private String[] december = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
                         "12", "13", "14", "15", "16", "17", "18", "19", "20", "21",
                         "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};

    private Director selectedDirector = null;                                   //Current Selected Director
    private Actor selectedActor = null;                                         //Current Selected Actor

    private Boolean directorSelected = null;                                    //If a director is logged in (true) or an actor (false)
    private Boolean directorFirstLogin = true;                                  //Keep track if it's the first director to log in

    /**
     * Class constructor. Creates new form CTAMS.
     */
    public CTAMS()
    {
        initComponents();                                                       //Initialize components
        hidePanels();                                                           //Close all open JPanels
        startPanel.setVisible(true);                                            //Open start panel

        //Set login settings for fields (This is mostly just aesthetics)
        nameField.setForeground(Color.gray);                                    //Set nameField's text color to gray
        nameField.setText("username");                                          //Set nameField's text to 'username'
        passwordField.setEchoChar((char) 0);                                    //Set the echo character of passwordField to normal characters
        passwordField.setForeground(Color.gray);                                //Set passwordField's text color to gray
        passwordField.setText("password");                                      //Set passwordField's text to 'password'
        eventNameField.setForeground(Color.gray);                               //Set eventNameField's text color to gray
        partField.setForeground(Color.gray);                                    //Set partField's text color to gray
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        directorMenuPanel = new javax.swing.JPanel();
        directorMenuMarginPanel = new javax.swing.JPanel();
        directorLogoutButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        nameLabelDirectorMenu = new javax.swing.JLabel();
        eventSelectionPanel = new javax.swing.JPanel();
        eventsComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        addEventButton = new javax.swing.JButton();
        editEventButton = new javax.swing.JButton();
        deleteEventButton = new javax.swing.JButton();
        eventManagementPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        eventNameField = new javax.swing.JTextField();
        dateOfEventLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        dateYearList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        dateMonthList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        dateDayList = new javax.swing.JList<>();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        auditionDayList = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        auditionMonthList = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        auditionYearList = new javax.swing.JList<>();
        dateOfAuditionsLabel = new javax.swing.JLabel();
        updateEventButton = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        partsList = new javax.swing.JList<>();
        partField = new javax.swing.JTextField();
        addPartButton = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        removePartButton = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        auditionsPanel = new javax.swing.JPanel();
        setRatingButton = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        auditionsList = new javax.swing.JList<>();
        actorMenuPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        ActorLogoutButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        nameLabelActorMenu = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        actorEventList = new javax.swing.JList<>();
        selectAuditionButton = new javax.swing.JButton();
        auditionDetailsButton = new javax.swing.JButton();
        auditionResultsButton = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        currentAuditionLabel = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        actorPartList = new javax.swing.JList<>();
        jLabel13 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        firstLoginPanel = new javax.swing.JPanel();
        firstLoginWelcomeNameField = new javax.swing.JLabel();
        actorsRegisteredLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        getToWorkButton = new javax.swing.JButton();
        startPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        directorSelection = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        actorSelection = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        logInPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        nameSeperator = new javax.swing.JSeparator();
        passwordSeperator = new javax.swing.JSeparator();
        passwordLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        signUpButton = new javax.swing.JButton();
        signInButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        blankPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(32, 33, 35));
        setResizable(false);

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        directorMenuPanel.setBackground(new java.awt.Color(32, 33, 35));
        directorMenuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        directorMenuMarginPanel.setBackground(new java.awt.Color(255, 255, 255));

        directorLogoutButton.setBackground(new java.awt.Color(32, 33, 35));
        directorLogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        directorLogoutButton.setText("Log Out");
        directorLogoutButton.setBorder(null);
        directorLogoutButton.setBorderPainted(false);
        directorLogoutButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                directorLogoutButtonActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ctamsbetav2/Avatar-grey-small.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setDefaultCapable(false);
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });

        nameLabelDirectorMenu.setBackground(new java.awt.Color(255, 255, 255));
        nameLabelDirectorMenu.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nameLabelDirectorMenu.setForeground(new java.awt.Color(0, 0, 0));
        nameLabelDirectorMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout directorMenuMarginPanelLayout = new javax.swing.GroupLayout(directorMenuMarginPanel);
        directorMenuMarginPanel.setLayout(directorMenuMarginPanelLayout);
        directorMenuMarginPanelLayout.setHorizontalGroup(
            directorMenuMarginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(directorMenuMarginPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(directorMenuMarginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabelDirectorMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(directorLogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        directorMenuMarginPanelLayout.setVerticalGroup(
            directorMenuMarginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, directorMenuMarginPanelLayout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(nameLabelDirectorMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(directorLogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        directorMenuPanel.add(directorMenuMarginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        eventSelectionPanel.setBackground(new java.awt.Color(32, 33, 35));

        eventsComboBox.setForeground(new java.awt.Color(0, 0, 0));

        jLabel7.setBackground(new java.awt.Color(32, 33, 35));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Select an event to manage");

        addEventButton.setBackground(new java.awt.Color(255, 255, 255));
        addEventButton.setForeground(new java.awt.Color(0, 0, 0));
        addEventButton.setText("Add");
        addEventButton.setBorder(null);
        addEventButton.setBorderPainted(false);
        addEventButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addEventButtonActionPerformed(evt);
            }
        });

        editEventButton.setBackground(new java.awt.Color(255, 255, 255));
        editEventButton.setForeground(new java.awt.Color(0, 0, 0));
        editEventButton.setText("Edit");
        editEventButton.setBorder(null);
        editEventButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                editEventButtonActionPerformed(evt);
            }
        });

        deleteEventButton.setBackground(new java.awt.Color(255, 255, 255));
        deleteEventButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteEventButton.setText("Delete");
        deleteEventButton.setBorder(null);
        deleteEventButton.setBorderPainted(false);
        deleteEventButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteEventButtonActionPerformed(evt);
            }
        });

        eventManagementPanel.setBackground(new java.awt.Color(32, 33, 35));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name of Event");

        eventNameField.setBackground(new java.awt.Color(32, 33, 35));
        eventNameField.setForeground(new java.awt.Color(255, 255, 255));
        eventNameField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        eventNameField.setText("event name");
        eventNameField.setBorder(null);
        eventNameField.setOpaque(false);
        eventNameField.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                eventNameFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                eventNameFieldMouseExited(evt);
            }
        });
        eventNameField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                eventNameFieldActionPerformed(evt);
            }
        });
        eventNameField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                eventNameFieldKeyPressed(evt);
            }
        });

        dateOfEventLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateOfEventLabel.setText("Date of Event");

        jSeparator3.setForeground(new java.awt.Color(255, 255, 255));

        dateYearList.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "2018", "2019", "2020" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(dateYearList);

        dateMonthList.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        dateMonthList.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                dateMonthListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dateMonthList);

        dateDayList.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(dateDayList);

        jSeparator4.setForeground(new java.awt.Color(255, 255, 255));

        auditionDayList.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(auditionDayList);

        auditionMonthList.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        auditionMonthList.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                auditionMonthListMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(auditionMonthList);

        auditionYearList.setModel(new javax.swing.AbstractListModel<String>()
        {
            String[] strings = { "2018", "2019", "2020" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(auditionYearList);

        dateOfAuditionsLabel.setForeground(new java.awt.Color(255, 255, 255));
        dateOfAuditionsLabel.setText("Date of Auditions for Event");

        updateEventButton.setBackground(new java.awt.Color(255, 255, 255));
        updateEventButton.setForeground(new java.awt.Color(0, 0, 0));
        updateEventButton.setText("Create Event");
        updateEventButton.setBorder(null);
        updateEventButton.setBorderPainted(false);
        updateEventButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                updateEventButtonActionPerformed(evt);
            }
        });

        jSeparator5.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel9.setBackground(new java.awt.Color(32, 33, 35));
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("List of Parts");

        jScrollPane8.setViewportView(partsList);

        partField.setBackground(new java.awt.Color(32, 33, 35));
        partField.setForeground(new java.awt.Color(255, 255, 255));
        partField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        partField.setText("part");
        partField.setBorder(null);
        partField.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                partFieldMouseClicked(evt);
            }
        });
        partField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                partFieldActionPerformed(evt);
            }
        });

        addPartButton.setBackground(new java.awt.Color(255, 255, 255));
        addPartButton.setForeground(new java.awt.Color(0, 0, 0));
        addPartButton.setText("Add");
        addPartButton.setBorder(null);
        addPartButton.setBorderPainted(false);
        addPartButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addPartButtonActionPerformed(evt);
            }
        });

        jSeparator6.setBackground(new java.awt.Color(32, 33, 35));
        jSeparator6.setForeground(new java.awt.Color(255, 255, 255));

        removePartButton.setBackground(new java.awt.Color(255, 255, 255));
        removePartButton.setForeground(new java.awt.Color(0, 0, 0));
        removePartButton.setText("Remove");
        removePartButton.setBorder(null);
        removePartButton.setBorderPainted(false);
        removePartButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removePartButtonActionPerformed(evt);
            }
        });

        jSeparator7.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout eventManagementPanelLayout = new javax.swing.GroupLayout(eventManagementPanel);
        eventManagementPanel.setLayout(eventManagementPanelLayout);
        eventManagementPanelLayout.setHorizontalGroup(
            eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventManagementPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eventManagementPanelLayout.createSequentialGroup()
                        .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(eventManagementPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(eventManagementPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8)
                            .addComponent(dateOfEventLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eventNameField)
                            .addComponent(jSeparator3)
                            .addComponent(jSeparator4)
                            .addComponent(dateOfAuditionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(eventManagementPanelLayout.createSequentialGroup()
                                .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(addPartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removePartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(partField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(updateEventButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        eventManagementPanelLayout.setVerticalGroup(
            eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventManagementPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator7)
                    .addGroup(eventManagementPanelLayout.createSequentialGroup()
                        .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(eventManagementPanelLayout.createSequentialGroup()
                                .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(eventManagementPanelLayout.createSequentialGroup()
                                        .addComponent(eventNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateOfEventLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateOfAuditionsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                    .addGroup(eventManagementPanelLayout.createSequentialGroup()
                                        .addComponent(partField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(eventManagementPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(addPartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(removePartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(updateEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        auditionsPanel.setBackground(new java.awt.Color(32, 33, 35));

        setRatingButton.setBackground(new java.awt.Color(255, 255, 255));
        setRatingButton.setForeground(new java.awt.Color(0, 0, 0));
        setRatingButton.setText("Set Rating");
        setRatingButton.setBorder(null);
        setRatingButton.setBorderPainted(false);
        setRatingButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                setRatingButtonActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(32, 33, 35));
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("List of Auditions");

        jScrollPane7.setViewportView(auditionsList);

        javax.swing.GroupLayout auditionsPanelLayout = new javax.swing.GroupLayout(auditionsPanel);
        auditionsPanel.setLayout(auditionsPanelLayout);
        auditionsPanelLayout.setHorizontalGroup(
            auditionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(auditionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(auditionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7)
                    .addGroup(auditionsPanelLayout.createSequentialGroup()
                        .addGroup(auditionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(auditionsPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(setRatingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        auditionsPanelLayout.setVerticalGroup(
            auditionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, auditionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(setRatingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout eventSelectionPanelLayout = new javax.swing.GroupLayout(eventSelectionPanel);
        eventSelectionPanel.setLayout(eventSelectionPanelLayout);
        eventSelectionPanelLayout.setHorizontalGroup(
            eventSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventSelectionPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(eventSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(eventSelectionPanelLayout.createSequentialGroup()
                        .addComponent(eventsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eventSelectionPanelLayout.createSequentialGroup()
                        .addComponent(eventManagementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(auditionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43))
        );
        eventSelectionPanelLayout.setVerticalGroup(
            eventSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventSelectionPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(eventSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eventsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteEventButton, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eventSelectionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(eventManagementPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(auditionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        directorMenuPanel.add(eventSelectionPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 750, 500));

        jLayeredPane1.add(directorMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 500));

        actorMenuPanel.setBackground(new java.awt.Color(32, 33, 35));
        actorMenuPanel.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ActorLogoutButton.setBackground(new java.awt.Color(32, 33, 35));
        ActorLogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        ActorLogoutButton.setText("Log Out");
        ActorLogoutButton.setBorder(null);
        ActorLogoutButton.setBorderPainted(false);
        ActorLogoutButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ActorLogoutButtonActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ctamsbetav2/Avatar-grey-small.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setDefaultCapable(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        nameLabelActorMenu.setBackground(new java.awt.Color(255, 255, 255));
        nameLabelActorMenu.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        nameLabelActorMenu.setForeground(new java.awt.Color(0, 0, 0));
        nameLabelActorMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabelActorMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(ActorLogoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(nameLabelActorMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(ActorLogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        actorMenuPanel.add(jPanel1);
        jPanel1.setBounds(0, 0, 186, 500);

        jPanel3.setBackground(new java.awt.Color(32, 33, 35));

        actorEventList.setBackground(new java.awt.Color(255, 255, 255));
        actorEventList.setForeground(new java.awt.Color(0, 0, 0));
        actorEventList.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                actorEventListMouseClicked(evt);
            }
        });
        actorEventList.addListSelectionListener(new javax.swing.event.ListSelectionListener()
        {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt)
            {
                actorEventListValueChanged(evt);
            }
        });
        jScrollPane9.setViewportView(actorEventList);

        selectAuditionButton.setBackground(new java.awt.Color(255, 255, 255));
        selectAuditionButton.setForeground(new java.awt.Color(0, 0, 0));
        selectAuditionButton.setText("Select");
        selectAuditionButton.setBorder(null);
        selectAuditionButton.setBorderPainted(false);
        selectAuditionButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                selectAuditionButtonMouseClicked(evt);
            }
        });
        selectAuditionButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectAuditionButtonActionPerformed(evt);
            }
        });

        auditionDetailsButton.setBackground(new java.awt.Color(255, 255, 255));
        auditionDetailsButton.setForeground(new java.awt.Color(0, 0, 0));
        auditionDetailsButton.setText("Details");
        auditionDetailsButton.setBorder(null);
        auditionDetailsButton.setBorderPainted(false);
        auditionDetailsButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                auditionDetailsButtonActionPerformed(evt);
            }
        });

        auditionResultsButton.setBackground(new java.awt.Color(255, 255, 255));
        auditionResultsButton.setForeground(new java.awt.Color(0, 0, 0));
        auditionResultsButton.setText("Check Results");
        auditionResultsButton.setBorder(null);
        auditionResultsButton.setBorderPainted(false);
        auditionResultsButton.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                auditionResultsButtonMouseClicked(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(32, 33, 35));
        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Events Accepting Auditions");

        currentAuditionLabel.setBackground(new java.awt.Color(32, 33, 35));
        currentAuditionLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        currentAuditionLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentAuditionLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentAuditionLabel.setText("Current Audition");

        actorPartList.setBackground(new java.awt.Color(255, 255, 255));
        actorPartList.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane11.setViewportView(actorPartList);

        jLabel13.setBackground(new java.awt.Color(32, 33, 35));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Parts Available");

        jSeparator8.setBackground(new java.awt.Color(32, 33, 35));
        jSeparator8.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator8.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(auditionDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(selectAuditionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentAuditionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(auditionResultsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(90, 90, 90)))
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(auditionDetailsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectAuditionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(currentAuditionLabel)
                .addGap(18, 18, 18)
                .addComponent(auditionResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        actorMenuPanel.add(jPanel3);
        jPanel3.setBounds(180, 0, 730, 500);

        jLayeredPane1.add(actorMenuPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 500));

        firstLoginPanel.setBackground(new java.awt.Color(32, 33, 35));

        firstLoginWelcomeNameField.setBackground(new java.awt.Color(32, 33, 35));
        firstLoginWelcomeNameField.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        firstLoginWelcomeNameField.setForeground(new java.awt.Color(255, 255, 255));
        firstLoginWelcomeNameField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstLoginWelcomeNameField.setText("Welcome,");

        actorsRegisteredLabel.setBackground(new java.awt.Color(32, 33, 35));
        actorsRegisteredLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        actorsRegisteredLabel.setForeground(new java.awt.Color(255, 255, 255));
        actorsRegisteredLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actorsRegisteredLabel.setText("There are currently  actors looking to audition at your theatre.");

        jSeparator2.setBackground(new java.awt.Color(32, 33, 35));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        getToWorkButton.setBackground(new java.awt.Color(255, 255, 255));
        getToWorkButton.setForeground(new java.awt.Color(0, 0, 0));
        getToWorkButton.setText("Let's get to work");
        getToWorkButton.setBorder(null);
        getToWorkButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                getToWorkButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout firstLoginPanelLayout = new javax.swing.GroupLayout(firstLoginPanel);
        firstLoginPanel.setLayout(firstLoginPanelLayout);
        firstLoginPanelLayout.setHorizontalGroup(
            firstLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstLoginPanelLayout.createSequentialGroup()
                .addGroup(firstLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(firstLoginWelcomeNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(actorsRegisteredLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(firstLoginPanelLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, firstLoginPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(getToWorkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        firstLoginPanelLayout.setVerticalGroup(
            firstLoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstLoginPanelLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(firstLoginWelcomeNameField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actorsRegisteredLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                .addComponent(getToWorkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jLayeredPane1.add(firstLoginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 500));

        startPanel.setBackground(new java.awt.Color(32, 33, 35));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome to the Community Theatre Audition Management System");

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Are you a ");

        directorSelection.setBackground(new java.awt.Color(32, 33, 35));
        directorSelection.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        directorSelection.setForeground(new java.awt.Color(255, 255, 255));
        directorSelection.setText("Director");
        directorSelection.setBorder(null);
        directorSelection.setBorderPainted(false);
        directorSelection.setMargin(new java.awt.Insets(0, 0, 0, 0));
        directorSelection.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                directorSelectionActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("or an");

        actorSelection.setBackground(new java.awt.Color(32, 33, 35));
        actorSelection.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        actorSelection.setForeground(new java.awt.Color(255, 255, 255));
        actorSelection.setText("Actor");
        actorSelection.setBorder(null);
        actorSelection.setBorderPainted(false);
        actorSelection.setMargin(new java.awt.Insets(0, 0, 0, 0));
        actorSelection.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                actorSelectionActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("?");

        javax.swing.GroupLayout startPanelLayout = new javax.swing.GroupLayout(startPanel);
        startPanel.setLayout(startPanelLayout);
        startPanelLayout.setHorizontalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(directorSelection)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(actorSelection)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(264, 264, 264))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))))
        );
        startPanelLayout.setVerticalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(directorSelection)
                    .addComponent(jLabel4)
                    .addComponent(actorSelection)
                    .addComponent(jLabel5))
                .addContainerGap(222, Short.MAX_VALUE))
        );

        jLayeredPane1.add(startPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 500));

        logInPanel.setBackground(new java.awt.Color(32, 33, 35));
        logInPanel.setForeground(new java.awt.Color(255, 255, 255));

        nameLabel.setForeground(new java.awt.Color(255, 255, 255));
        nameLabel.setText("Name");

        nameField.setBackground(new java.awt.Color(32, 33, 35));
        nameField.setForeground(new java.awt.Color(255, 255, 255));
        nameField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nameField.setText("username");
        nameField.setBorder(null);
        nameField.setCaretColor(new java.awt.Color(255, 255, 255));
        nameField.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                nameFieldMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                nameFieldMouseExited(evt);
            }
        });
        nameField.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                nameFieldKeyPressed(evt);
            }
        });

        nameSeperator.setForeground(new java.awt.Color(255, 255, 255));

        passwordSeperator.setForeground(new java.awt.Color(187, 187, 187));

        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password");

        passwordField.setBackground(new java.awt.Color(32, 33, 35));
        passwordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        passwordField.setText("jPasswordField1");
        passwordField.setBorder(null);
        passwordField.setCaretColor(new java.awt.Color(255, 255, 255));
        passwordField.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                passwordFieldMouseClicked(evt);
            }
        });
        passwordField.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                passwordFieldActionPerformed(evt);
            }
        });

        signUpButton.setBackground(new java.awt.Color(255, 255, 255));
        signUpButton.setForeground(new java.awt.Color(0, 0, 0));
        signUpButton.setText("Sign Up");
        signUpButton.setBorder(null);
        signUpButton.setBorderPainted(false);
        signUpButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                signUpButtonActionPerformed(evt);
            }
        });

        signInButton.setBackground(new java.awt.Color(255, 255, 255));
        signInButton.setForeground(new java.awt.Color(0, 0, 0));
        signInButton.setText("Sign In");
        signInButton.setBorder(null);
        signInButton.setBorderPainted(false);
        signInButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                signInButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Dialog", 1, 80)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CTAMS");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Welcomes You");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        backButton.setBackground(new java.awt.Color(32, 33, 35));
        backButton.setForeground(new java.awt.Color(80, 80, 80));
        backButton.setText("back");
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout logInPanelLayout = new javax.swing.GroupLayout(logInPanel);
        logInPanel.setLayout(logInPanelLayout);
        logInPanelLayout.setHorizontalGroup(
            logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logInPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordLabel)
                                .addComponent(passwordSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logInPanelLayout.createSequentialGroup()
                                    .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameLabel)
                                .addComponent(nameField)
                                .addComponent(nameSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );
        logInPanelLayout.setVerticalGroup(
            logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logInPanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(nameLabel)
                .addGap(24, 24, 24)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addGap(18, 18, 18)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(logInPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addContainerGap(136, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLayeredPane1.add(logInPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 910, 500));

        javax.swing.GroupLayout blankPanelLayout = new javax.swing.GroupLayout(blankPanel);
        blankPanel.setLayout(blankPanelLayout);
        blankPanelLayout.setHorizontalGroup(
            blankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
        );
        blankPanelLayout.setVerticalGroup(
            blankPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        jLayeredPane1.add(blankPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Class constructor. Creates new form CTAMS.
     */
    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_signUpButtonActionPerformed
    {//GEN-HEADEREND:event_signUpButtonActionPerformed
        Boolean nameError = false;                                              //Boolean to keep track if there is a name error

        if (directorSelected == true)                                           //If a director is logging in
        {
            if(nameField.getText().equals("username") || nameField.getText().equals("")) //If the username is 'username' or empty
            {
                nameError = true;                                               //Set nameError to true
                JOptionPane.showMessageDialog(this, "Username not allowed.");   //Inform user that the username is not allowed
            }
            else
            {
                for (Director d : directors)                                    //Loop through the directors
                {
                    if (nameField.getText().equals(d.getName()))                //If the username is already taken
                    {
                        nameError = true;                                       //Set namError to true
                        JOptionPane.showMessageDialog(this, "Username not available."); //Prompt user for a different username
                        break;                                                  //Escape the for each loop
                    }
                }
            }

            if (nameError == false)                                             //If there are no name errors
            {
                if (passwordField.getText().equals("password"))
                {
                    JOptionPane.showMessageDialog(this, "Choose a different password"); //Prompt user for a different password
                }
                else
                {
                    //Create a new director and add it to the list of directors
                    String name = nameField.getText();
                    String password = passwordField.getText();
                    Director director = new Director(name, password);
                    directors.add(director);
                }
            }
        }
        else if (directorSelected == false)                                     //If an actor is logging in
        {
            if(nameField.getText().equals("username") || nameField.getText().equals("")) //If the username is 'username' or empty
            {
                nameError = true;                                               //Set nameError to true
                JOptionPane.showMessageDialog(this, "Username not allowed.");   //Inform user that the username is not allowed
            }
            else
            {
                for (Actor a : actors)                                          //Loop through the actors
                {
                    if (nameField.getText().equals(a.getName()) || nameField.getText().equals("username")) //If the username is taken
                    {
                        nameError = true;                                       //Set namError to true
                        JOptionPane.showMessageDialog(this, "Username not available."); //Prompt user for a different username
                        break;                                                  //Escape the for each loop
                    }
                }
            }

            if (nameError == false)                                             //If there are no name errors
            {
                if (passwordField.getText().equals("password"))
                {
                    JOptionPane.showMessageDialog(this, "Choose a different password"); //Prompt user for a different password
                }
                else
                {
                    //Create a new actor and add it to the list of actors
                    String name = nameField.getText();
                    String password = passwordField.getText();
                    Actor actor = new Actor(name, password);
                    actors.add(actor);
                }
            }
        }
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_signInButtonActionPerformed
    {//GEN-HEADEREND:event_signInButtonActionPerformed
        Boolean nameError = true;                                               //Boolean to keep track if there is a name error

        if (directorSelected == true)                                           //If a director is logging in
        {
            for (Director d : directors)                                        //Loop through the directors
            {
                if (nameField.getText().toLowerCase().equals(d.getName().toLowerCase())) //If there is a director with the inputted username
                {
                    nameError = false;
                    selectedDirector = d;                                       //Select the director

                    if (d.getPassword().equals(passwordField.getText()))        //If the password is correct
                    {
                        hidePanels();                                           //Hide panels
                        nameLabelDirectorMenu.setText(selectedDirector.getName()); //Set the name label to the director's name

                        if (directorFirstLogin == true)                         //If this is the first director to login
                        {
                            directorMenuPanel.setVisible(false);                //Hide director menu panel
                            firstLoginPanel.setVisible(true);                   //Show the first director login panel (Used to inform directors of actors currently waiting for events to audition for)

                            //Format the first login panel
                            firstLoginWelcomeNameField.setText("Welcome, " + selectedDirector.getName());
                            firstLoginWelcomeNameField.setHorizontalAlignment(JTextField.CENTER);
                            actorsRegisteredLabel.setText("There are currently " + actors.size() + " actors looking to audition at your theatre.");
                            actorsRegisteredLabel.setHorizontalAlignment(JTextField.CENTER);

                            directorFirstLogin = false;                         //Set the first director login to false
                        }
                        else                                                    //If this isn't the first director to login
                        {
                            firstLoginPanel.setVisible(false);                  //Hide the first login panel
                            directorMenuPanel.setVisible(true);                 //Show the director menu panel
                            directorMenuMarginPanel.setVisible(true);           //Show the director menu margin panel
                            eventSelectionPanel.setVisible(true);               //Show the event selection panel
                        }
                    }
                    else                                                        //If the password is incorrect
                    {
                        //Inform the user that the password is incorrect
                        JOptionPane.showMessageDialog(this, "Incorrect Password");
                    }

                    break;                                                      //Escape the loop
                }
            }
            if(nameError)                                                       //If there are no directors with the inputted username
            {
                //Inform the user that they have inputted in incorrect username
                JOptionPane.showMessageDialog(this, "Incorrect Username");
            }
        }
        else if (directorSelected == false)                                     //If an actor is logging in
        {
            for (Actor a : actors)
            {
                if (nameField.getText().toLowerCase().equals(a.getName().toLowerCase())) //If there is an actor with the inputted username
                {
                    selectedActor = a;                                          //Select the actor

                    if (a.getPassword().equals(passwordField.getText()))        //If the password is correct
                    {
                        hidePanels();                                           //Hide panels
                        nameLabelActorMenu.setText(selectedActor.getName());    //Set the name label to the actor's name
                        actorEventList.setModel(eventsComboBox.getModel());     //Populate the list of events with events in the director's ComboBox
                        actorMenuPanel.setVisible(true);                        //Show the actor menu panel
                        actorPartList.setModel(new DefaultListModel());         //Empty the part list

                        if (selectedActor.getAudition() != null)                //If the actor has an audition
                        {
                            //Set the current audition label to the actor's current audition
                            currentAuditionLabel.setText("Applying to be a(n) " + selectedActor.getAudition().getPart() + " for the " + selectedActor.getAudition().getEvent().getName() + " event.");
                        }
                        else                                                    //If the actor doesn't have an audition
                        {
                            //Set the current audition label to default
                            currentAuditionLabel.setText("Current Audition");
                        }
                    }
                    else
                    {
                        //Inform the user that they have inputted an incorrect password
                        JOptionPane.showMessageDialog(this, "Incorrect Password");
                    }

                    break;                                                      //Escape the loop
                }
                else                                                            //If the user has inputted an incorrect username
                {
                    //Inform the user that they have inputted an incorrect username
                    JOptionPane.showMessageDialog(this, "Incorrect Username");
                }
            }
        }
    }//GEN-LAST:event_signInButtonActionPerformed

    private void directorSelectionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_directorSelectionActionPerformed
    {//GEN-HEADEREND:event_directorSelectionActionPerformed
        directorSelected = true;                                                //A director is logging in
        hidePanels();                                                           //Hide panels
        logInPanel.setVisible(true);                                            //Show login panel
    }//GEN-LAST:event_directorSelectionActionPerformed

    private void actorSelectionActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_actorSelectionActionPerformed
    {//GEN-HEADEREND:event_actorSelectionActionPerformed
        directorSelected = false;                                               //An actor is logging in
        hidePanels();                                                           //Hide panels
        logInPanel.setVisible(true);                                            //Show login panel
    }//GEN-LAST:event_actorSelectionActionPerformed

    private void ActorLogoutButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_ActorLogoutButtonActionPerformed
    {//GEN-HEADEREND:event_ActorLogoutButtonActionPerformed
        logOut();                                                               //Log out
    }//GEN-LAST:event_ActorLogoutButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nameFieldMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nameFieldMouseExited
    {//GEN-HEADEREND:event_nameFieldMouseExited

    }//GEN-LAST:event_nameFieldMouseExited

    private void nameFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_nameFieldKeyPressed
    {//GEN-HEADEREND:event_nameFieldKeyPressed

    }//GEN-LAST:event_nameFieldKeyPressed

    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_passwordFieldMouseClicked
    {//GEN-HEADEREND:event_passwordFieldMouseClicked
        //Format field for input
        passwordField.setForeground(Color.white);
        passwordField.setText("");
        passwordField.setEchoChar('•');
    }//GEN-LAST:event_passwordFieldMouseClicked

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_passwordFieldActionPerformed
    {//GEN-HEADEREND:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void nameFieldMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_nameFieldMouseClicked
    {//GEN-HEADEREND:event_nameFieldMouseClicked
        //Format field for input
        nameField.setForeground(Color.white);
        nameField.setText("");
    }//GEN-LAST:event_nameFieldMouseClicked

    private void directorLogoutButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_directorLogoutButtonActionPerformed
    {//GEN-HEADEREND:event_directorLogoutButtonActionPerformed
        if (eventManagementPanel.isVisible() == true)                           //If the event management panel is open
        {
            //Prompt user to save changes
            JOptionPane.showMessageDialog(this, "There are unsaved changes. Please check that you have saved your work.");
        }
        else                                                                    //If the event management panel is not open
        {
            logOut();                                                           //Log out
            resetEventManagementPanel();                                        //Reset event management panel
            auditionsList.clearSelection();                                     //Clear auditions list
        }
    }//GEN-LAST:event_directorLogoutButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void getToWorkButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_getToWorkButtonActionPerformed
    {//GEN-HEADEREND:event_getToWorkButtonActionPerformed
        firstLoginPanel.setVisible(false);                                      //Hide the first login panel
        eventManagementPanel.setVisible(false);                                 //Hide the event management panel
        auditionsPanel.setVisible(false);                                       //Hide the auditions panel
        directorMenuPanel.setVisible(true);                                     //Show the director menu panel
        directorMenuMarginPanel.setVisible(true);                               //Show the director menu margin panel
        eventSelectionPanel.setVisible(true);                                   //Show the event selection panel
    }//GEN-LAST:event_getToWorkButtonActionPerformed

    private void addEventButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addEventButtonActionPerformed
    {//GEN-HEADEREND:event_addEventButtonActionPerformed
        eventManagementPanel.setVisible(true);                                  //Show the event management panel
        resetEventManagementPanel();                                            //Reset the event management panel
        updateEventButton.setText("Create Event");                              //set the update button's text to 'Create Event'
    }//GEN-LAST:event_addEventButtonActionPerformed

    private void editEventButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_editEventButtonActionPerformed
    {//GEN-HEADEREND:event_editEventButtonActionPerformed
        eventManagementPanel.setVisible(true);                                  //Show the eventManagementPanel
        auditionsPanel.setVisible(true);                                        //Show the auditionsPanel
        updateEventButton.setText("Update Event");                              //Set button text to 'Update Event'

        if (eventsComboBox.getItemCount() == 0)                                 //If the Events ComboBox is empty
        {
            //Prompt user to add a new event
            JOptionPane.showMessageDialog(this, "There are no events to edit. Please add a new one.");
        }
        else                                                                    //If the Events ComboBox has events
        {
            if (eventsComboBox.getSelectedIndex() == -1)                        //If the Events ComboBox is not selected
            {
                //Prompt user to select an event
                JOptionPane.showMessageDialog(this, "Please select an event to edit.");
            }
            else                                                                //If the an event in the ComboBox is selected
            {
                String s = eventsComboBox.getSelectedItem().toString();         //Create a temp string and store the selected event into it
                Event selected = null;                                          //Create a temp event to store the selected event

                for (Event e : events)                                          //Loop through an event
                {
                    if (s.equals(e.getName()))                                  //If the string is equal to the
                    {
                        selected = e;                                           //Select the event
                        break;                                                  //Escape from the loop
                    }
                }

                if (arrayOfStrings != null)                                     //If the array of strings is not empty
                {
                    Event e = selected;                                         //Select the event
                    Audition selected1 = null;                                  //Create a temp audition
                    int i = 0;                                                  //Counter
                    arrayOfStrings = new String[auditions.size()];              //set the array of strings equal to a new array with the size of the auditions list

                    for (Audition a : auditions)                                //Loop through the auditions
                    {
                        if (e.equals(a.getEvent()))                             //If the event is equal to the audition's event
                        {
                            selected1 = a;                                      //Select the audition
                            arrayOfStrings[i] = a.toString();                   //Populate the array of strings with the audition
                            i++;                                                //Increment the counter
//                            break;                                              //Escape the loop (Testing command)
                        }
                    }

                    auditionsList.setListData(arrayOfStrings);                  //Place array (full of parts) into part list
                }

                eventNameField.setText(selected.getName());                     //Populate the name field with the event's name
                dateDayList.setSelectedIndex(Integer.parseInt(selected.getEventDay()) - 1); //Select the day of the event in the list

                switch (selected.getEventMonth())                               //Select the month of the event in the list
                {
                    case "January":
                        dateMonthList.setSelectedIndex(0);
                        break;
                    case "February":
                        dateMonthList.setSelectedIndex(1);
                        break;
                    case "March":
                        dateMonthList.setSelectedIndex(2);
                        break;
                    case "April":
                        dateMonthList.setSelectedIndex(3);
                        break;
                    case "May":
                        dateMonthList.setSelectedIndex(4);
                        break;
                    case "June":
                        dateMonthList.setSelectedIndex(5);
                        break;
                    case "July":
                        dateMonthList.setSelectedIndex(6);
                        break;
                    case "August":
                        dateMonthList.setSelectedIndex(7);
                        break;
                    case "September":
                        dateMonthList.setSelectedIndex(8);
                        break;
                    case "October":
                        dateMonthList.setSelectedIndex(9);
                        break;
                    case "November":
                        dateMonthList.setSelectedIndex(10);
                        break;
                    case "December":
                        dateMonthList.setSelectedIndex(11);
                        break;
                }

                dateYearList.setSelectedIndex(Integer.parseInt(selected.getEventYear()) - 2018); //Select the year of the event in the list
                auditionDayList.setSelectedIndex(Integer.parseInt(selected.getAuditionDay()) - 1); //Select the day of the audition in the list

                switch (selected.getAuditionMonth())                            //Select the month of the audition in the list
                {
                    case "January":
                        auditionMonthList.setSelectedIndex(0);
                        break;
                    case "February":
                        auditionMonthList.setSelectedIndex(1);
                        break;
                    case "March":
                        auditionMonthList.setSelectedIndex(2);
                        break;
                    case "April":
                        auditionMonthList.setSelectedIndex(3);
                        break;
                    case "May":
                        auditionMonthList.setSelectedIndex(4);
                        break;
                    case "June":
                        auditionMonthList.setSelectedIndex(5);
                        break;
                    case "July":
                        auditionMonthList.setSelectedIndex(6);
                        break;
                    case "August":
                        auditionMonthList.setSelectedIndex(7);
                        break;
                    case "September":
                        auditionMonthList.setSelectedIndex(8);
                        break;
                    case "October":
                        auditionMonthList.setSelectedIndex(9);
                        break;
                    case "November":
                        auditionMonthList.setSelectedIndex(10);
                        break;
                    case "December":
                        auditionMonthList.setSelectedIndex(11);
                        break;
                }

                auditionYearList.setSelectedIndex(Integer.parseInt(selected.getAuditionYear()) - 2018); //Select the year of the audition in the list
                parts = selected.getParts();                                    //Set the parts arraylist equal to the selected event's parts
                partsList.setListData(parts.toArray(new String[parts.size()])); //Populate the parts list with the parts array list

            }
        }
    }//GEN-LAST:event_editEventButtonActionPerformed

    private void eventNameFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_eventNameFieldActionPerformed
    {//GEN-HEADEREND:event_eventNameFieldActionPerformed

    }//GEN-LAST:event_eventNameFieldActionPerformed

    private void eventNameFieldMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_eventNameFieldMouseExited
    {//GEN-HEADEREND:event_eventNameFieldMouseExited
        if (eventNameField.getText().equals("event name") || eventNameField.getText().equals(""))  //If the event name is default or empty
        {
            //Change the labels to be default
            dateOfEventLabel.setText("Date of Event");
            dateOfAuditionsLabel.setText("Date of Auditions for Event");
        }
        else                                                                    //If the event name is changed
        {
            //Change the labels to display the new event name
            dateOfEventLabel.setText("Date of " + eventNameField.getText());
            dateOfAuditionsLabel.setText("Date of Auditions for " + eventNameField.getText());
        }
    }//GEN-LAST:event_eventNameFieldMouseExited

    private void partFieldActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_partFieldActionPerformed
    {//GEN-HEADEREND:event_partFieldActionPerformed

    }//GEN-LAST:event_partFieldActionPerformed

    private void addPartButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addPartButtonActionPerformed
    {//GEN-HEADEREND:event_addPartButtonActionPerformed
        parts.add(partField.getText());                                         //Add a new part to the array list
        partsList.setListData(parts.toArray(new String[parts.size()]));         //Set the JList to reflect the array list
    }//GEN-LAST:event_addPartButtonActionPerformed

    private void updateEventButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_updateEventButtonActionPerformed
    {//GEN-HEADEREND:event_updateEventButtonActionPerformed
        //If missing something
        if (eventNameField.getText().equals("")
                || eventNameField.getText().equals("event name")
                || dateDayList.isSelectionEmpty()
                || dateMonthList.isSelectionEmpty()
                || dateYearList.isSelectionEmpty()
                || auditionDayList.isSelectionEmpty()
                || auditionMonthList.isSelectionEmpty()
                || auditionYearList.isSelectionEmpty()
                || partsList.getModel().getSize() == 0)
        {
            //Prompt user to fill in missing information
            JOptionPane.showMessageDialog(this, "You're missing something. Go back.");
        }
        else                                                                    //If all information is filled in
        {
            int eventMonthNumber = 0;                                           //int to store the converted event month     (String to int)
            int auditionMonthNumber = 0;                                        //int to store the converted audition month  (String to int)

            switch (dateMonthList.getSelectedValue())                           //Convert the selected event month into an int
            {
                case "January":
                    eventMonthNumber = 0;
                    break;
                case "February":
                    eventMonthNumber = 1;
                    break;
                case "March":
                    eventMonthNumber = 2;
                    break;
                case "April":
                    eventMonthNumber = 3;
                    break;
                case "May":
                    eventMonthNumber = 4;
                    break;
                case "June":
                    eventMonthNumber = 5;
                    break;
                case "July":
                    eventMonthNumber = 6;
                    break;
                case "August":
                    eventMonthNumber = 7;
                    break;
                case "September":
                    eventMonthNumber = 8;
                    break;
                case "October":
                    eventMonthNumber = 9;
                    break;
                case "November":
                    eventMonthNumber = 10;
                    break;
                case "December":
                    eventMonthNumber = 11;
                    break;
            }

            switch (auditionMonthList.getSelectedValue())                       //Convert the selected audition month into an int
            {
                case "January":
                    auditionMonthNumber = 0;
                    break;
                case "February":
                    auditionMonthNumber = 1;
                    break;
                case "March":
                    auditionMonthNumber = 2;
                    break;
                case "April":
                    auditionMonthNumber = 3;
                    break;
                case "May":
                    auditionMonthNumber = 4;
                    break;
                case "June":
                    auditionMonthNumber = 5;
                    break;
                case "July":
                    auditionMonthNumber = 6;
                    break;
                case "August":
                    auditionMonthNumber = 7;
                    break;
                case "September":
                    auditionMonthNumber = 8;
                    break;
                case "October":
                    auditionMonthNumber = 9;
                    break;
                case "November":
                    auditionMonthNumber = 10;
                    break;
                case "December":
                    auditionMonthNumber = 11;
                    break;
            }

            //If the event date is before the audition date
            if (eventMonthNumber <= auditionMonthNumber
                    && Integer.parseInt(dateDayList.getSelectedValue()) <= Integer.parseInt(auditionDayList.getSelectedValue())
                    && Integer.parseInt(dateYearList.getSelectedValue()) <= Integer.parseInt(auditionYearList.getSelectedValue()))
            {
                //Prompt the user to correct the dates
                JOptionPane.showMessageDialog(this, "The event cannot be before the auditions. Check the dates.");
            }
            else                                                                //If the event date is after the audition date
            {
                Boolean sameName = false;                                       //Boolean to keep track of if the events have the same name
                Event selected = null;                                          //Temporary event to use as the selected event
                Boolean finished = true;                                        //Boolean to determine when user is finished updating

                for (Event e : events)                                          //Loop through events
                {
                    if (e.getName().equals(eventNameField.getText()))           //If there is another event with the same name
                    {
                        selected = e;                                           //Select the event
                        sameName = true;                                        //sameName is set to true

                        if (updateEventButton.getText().equals("Create Event")) //If we are adding and not editing events
                        {
                            //Inform user that there is an event with that name already
                            JOptionPane.showMessageDialog(this, "There is already an event with this name. Try renaming this one.");

                            finished = false;                                   //We are not finished with adding an event
                        }
                        else                                                    //If we are editing and not adding events
                        {
                            //Update all event information
                            selected.setName(eventNameField.getText());
                            selected.setEventDay(dateDayList.getSelectedValue());
                            selected.setEventMonth(dateMonthList.getSelectedValue());
                            selected.setEventYear(dateYearList.getSelectedValue());
                            selected.setAuditionDay(auditionDayList.getSelectedValue());
                            selected.setAuditionMonth(auditionMonthList.getSelectedValue());
                            selected.setAuditionYear(auditionYearList.getSelectedValue());
                            selected.setParts(parts);

                            finished = true;                                    //We are finished updating the event
                        }

                        break;                                                  //Escape the for each loop
                    }
                }

                if (sameName == false)                                          //If there are no other events with this name
                {
                    if (updateEventButton.getText().equals("Create Event"))     //If we are adding and not editing events
                    {
                        //Create a new event with the provided information
                        Event event = new Event(eventNameField.getText(),
                                                dateDayList.getSelectedValue(),
                                                dateMonthList.getSelectedValue(),
                                                dateYearList.getSelectedValue(),
                                                auditionDayList.getSelectedValue(),
                                                auditionMonthList.getSelectedValue(),
                                                auditionYearList.getSelectedValue(),
                                                parts);

                        events.add(event);                                      //Add the newly created event to the list of events

                        eventsComboBox.addItem(eventNameField.getText());       //Add the event to the events ComboBox

                        finished = true;                                        //We are finished creating the event
                    }
                    else                                                        //If updating event with a new name
                    {
                        //Update all event information
                        selected.setName(eventNameField.getText());
                        selected.setEventDay(dateDayList.getSelectedValue());
                        selected.setEventMonth(dateMonthList.getSelectedValue());
                        selected.setEventYear(dateYearList.getSelectedValue());
                        selected.setAuditionDay(auditionDayList.getSelectedValue());
                        selected.setAuditionMonth(auditionMonthList.getSelectedValue());
                        selected.setAuditionYear(auditionYearList.getSelectedValue());
                        selected.setParts(parts);

                        finished = true;                                        //We are finished updating the event
                    }
                }

                if (finished == true)                                           //If the user is finished editing the event
                {
                    eventManagementPanel.setVisible(false);                     //Hide the event management panel
                    auditionsPanel.setVisible(false);                           //Hide the audtions list panel
                }
            }
        }
    }//GEN-LAST:event_updateEventButtonActionPerformed

    /**
     * Remove selected element from partsList
     */
    private void removePartButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_removePartButtonActionPerformed
    {//GEN-HEADEREND:event_removePartButtonActionPerformed
        parts = removeElement(parts, partsList.getSelectedValue());             //Remove element from parts
        partsList.setListData(parts.toArray(new String[parts.size()]));         //Populate list with partsList
    }//GEN-LAST:event_removePartButtonActionPerformed

    /**
     * When the user click the eventNameField, empty it and turn the text white
     */
    private void eventNameFieldMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_eventNameFieldMouseClicked
    {//GEN-HEADEREND:event_eventNameFieldMouseClicked
        eventNameField.setText("");                                             //Empty the field
        eventNameField.setForeground(Color.white);                              //Color text white
    }//GEN-LAST:event_eventNameFieldMouseClicked

    /**
     * When the user click the partField, empty it and turn the text white
     */
    private void partFieldMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_partFieldMouseClicked
    {//GEN-HEADEREND:event_partFieldMouseClicked
        partField.setText("");                                                  //Empty the field
        partField.setForeground(Color.white);                                   //Color text white
    }//GEN-LAST:event_partFieldMouseClicked

    private void setRatingButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_setRatingButtonActionPerformed
    {//GEN-HEADEREND:event_setRatingButtonActionPerformed
        String s = auditionsList.getSelectedValue();                            //Create a new string and set it equal to the selected audition
        Audition selected = null;                                               //Create a new null audition for a temp

        for (Audition a : auditions)                                            //Loop through the auditions
        {
            if (s.equals(a.toString()))                                         //If the selected element is equal to the toString of an audition
            {
                selected = a;                                                   //Select the audition
                break;                                                          //Escape the for each loop
            }
        }

        Object[] options = {1, 2, 3, 4, 5};                                     //Rating options (1-5)

        //Prompt user for rating of audition
        int n = JOptionPane.showOptionDialog(this,
                                            "What rating would you give his/her audition",
                                            "Audition Rating",
                                            JOptionPane.YES_NO_CANCEL_OPTION,
                                            JOptionPane.QUESTION_MESSAGE,
                                            null,
                                            options,
                                            options[4]);

        selected.setRating(n + 1);                                              //Set audition rating
    }//GEN-LAST:event_setRatingButtonActionPerformed

    private void eventNameFieldKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_eventNameFieldKeyPressed
    {//GEN-HEADEREND:event_eventNameFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_eventNameFieldKeyPressed

    /**
     * Display the parts that correlate with selected events
     */
    private void deleteEventButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteEventButtonActionPerformed
    {//GEN-HEADEREND:event_deleteEventButtonActionPerformed
        if (eventsComboBox.getSelectedIndex() == -1)                            //If eventsComboBox is not selected
        {
            JOptionPane.showMessageDialog(this, "Please select an event.");     //Prompt user for selection
        }
        else                                                                    //If eventsComboBox is selected
        {
            String[] choices = {"Yes", "No"};                                   //String array of choices (Yes or No)

            //Prompt user for confirmation of the deletion of the event
            int response = JOptionPane.showOptionDialog(this,
                                                        "This will delete the selected event."
                                                        + " Are you sure?", "Select One",
                                                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                                                        null, choices, choices[0]);

            if (response == 0)                                                  //If user selects yes
            {
                String selection = eventsComboBox.getSelectedItem().toString(); //Create a new string equal to the selected item
                eventsComboBox.removeItem(eventsComboBox.getSelectedItem());    //Remove the item from the ComboBox

                Event selected = null;                                          //Create a new null Event

                for (Event e : events)                                          //Loop through the events
                {
                    if (selection.equals(e.getName()))                          //If the selected item's name is equal to the even name
                    {
                        selected = e;                                           //Select the event
                        break;                                                  //Escape the for each loop
                    }
                }

                events.remove(selected);                                        //Remove the event from the arraylist
            }
        }

        eventManagementPanel.setVisible(false);                                 //Hide the event management panel
        auditionsPanel.setVisible(false);                                       //Hide the auditions list panel
    }//GEN-LAST:event_deleteEventButtonActionPerformed

    private void selectAuditionButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectAuditionButtonActionPerformed
    {//GEN-HEADEREND:event_selectAuditionButtonActionPerformed

    }//GEN-LAST:event_selectAuditionButtonActionPerformed

    private void actorEventListValueChanged(javax.swing.event.ListSelectionEvent evt)//GEN-FIRST:event_actorEventListValueChanged
    {//GEN-HEADEREND:event_actorEventListValueChanged

    }//GEN-LAST:event_actorEventListValueChanged

    /**
     * Display the parts that correlate with selected events
     */
    private void actorEventListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_actorEventListMouseClicked
    {//GEN-HEADEREND:event_actorEventListMouseClicked
        Event selected = events.get(actorEventList.getSelectedIndex());         //Create a new event equal to the selected index of the event list

        String[] listData = new String[selected.getParts().size()];             //Create a String array equal to the size of the parts of the event

        for (int i = 0; i < listData.length; i++)                               //For loop through the array
        {
            listData[i] = selected.getParts().get(i);                           //Store parts into the array
        }

        actorPartList.setListData(listData);                                    //Place array (full of parts) into part list
    }//GEN-LAST:event_actorEventListMouseClicked

    /**
     * Display a dialog box with information about the selected event
     */
    private void auditionDetailsButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_auditionDetailsButtonActionPerformed
    {//GEN-HEADEREND:event_auditionDetailsButtonActionPerformed
        String s = actorEventList.getSelectedValue();                           //Create a new string and set it equal to the selected event
        Event selected = null;                                                  //Create a new null Event

        for (Event e : events)                                                  //Loop through the events
        {
            if (s.equals(e.getName()))                                          //If the selected element is equal to the name of an event
            {
                selected = e;                                                   //Select the event
                break;                                                          //Escape the for each loop
            }
        }

        //Display dialog box with dates of the Event and the Audition
        JOptionPane.showMessageDialog(this, "Event Date: " + selected.getEventMonth()
                                        + " " + selected.getEventDay() + ", "
                                        + selected.getEventYear() + "\n"
                                        + "Audition Date: " + selected.getAuditionMonth()
                                        + " " + selected.getAuditionDay() + ", "
                                        + selected.getAuditionYear(),
                                        selected.getName(), JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_auditionDetailsButtonActionPerformed

    private void selectAuditionButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_selectAuditionButtonMouseClicked
    {//GEN-HEADEREND:event_selectAuditionButtonMouseClicked
        String s = actorEventList.getSelectedValue();                           //Create a new string and set it equal to the selected event
        Event selectedEvent = null;

        for (Event e : events)                                                  //Loop through the events
        {
            if (s.equals(e.getName()))                                          //If the selected element is equal to the name of an event
            {
                selectedEvent = e;                                              //Select the event
                break;                                                          //Escape the for each loop
            }
        }

        Audition audition = new Audition(selectedActor, selectedEvent,          //Create a new audition
                                            actorPartList.getSelectedValue());

        selectedActor.setAudition(audition);                                    //Store created audition in the logged-in actor

        currentAuditionLabel.setText("Applying to be a(n) "                     //Display the actor's audition through a label
                                    + selectedActor.getAudition().getPart()
                                    + " for the "
                                    + selectedActor.getAudition().getEvent().getName()
                                    + " event.");

        Audition selectedAudition = null;                                       //Create a new null audition as a temp

        for (Audition a : auditions)                                            //Loop through the auditions
        {
            if (audition.getActor().getName().equals(a.getActor().getName()))   //If the actor name is equal to the actor name of the audition
            {
                selectedAudition = a;                                           //Select the audition
                int placement = auditions.indexOf(a);                           //Determine the index of the selected audition in the list

                auditions.set(placement, audition);                             //Replace found audition with actor's new audition

                break;                                                          //Escape the for each loop
            }
        }

        if (selectedAudition == null)                                           //If the actor doesn't already have an audition
        {
            auditions.add(audition);                                            //Add the audition to the list instead of replacing it
        }

        arrayOfStrings = new String[auditions.size()];                          //Set the array equal to a new array with the length of the list
        int i = 0;                                                              //Counter

        for (Audition a : auditions)                                            //Loop through the auditions
        {
            arrayOfStrings[i] = a.toString();                                   //Populate array with the toString of each list element
            i++;                                                                //Increment counter for populating the array
        }
    }//GEN-LAST:event_selectAuditionButtonMouseClicked

    /**
     * Create an audition and populate label
     */
    private void auditionResultsButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_auditionResultsButtonMouseClicked
    {//GEN-HEADEREND:event_auditionResultsButtonMouseClicked
        if (selectedActor.getAudition() != null)                                                //If the selected actor has an audition
        {
            if (selectedActor.getAudition().getRating() > 0)                                    //If the selected actor's audition is rated
            {
                JOptionPane.showMessageDialog(this, "Your audition's rating: "                  //Display the actor's audition's rating
                                                    + selectedActor.getAudition().getRating());
            }
            else                                                                                //If the selected actor's audition is not rated
            {
                JOptionPane.showMessageDialog(this, "Your audition has not been rated yet.");   //Inform actor their audition hasn't been rated
            }
        }
        else                                                                                    //If the user does not have an audition
        {
            JOptionPane.showMessageDialog(this, "You do not have an audition yet.");            //Inform them that they do not have an audition
        }
    }//GEN-LAST:event_auditionResultsButtonMouseClicked

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_backButtonActionPerformed
    {//GEN-HEADEREND:event_backButtonActionPerformed
        hidePanels();                                                           //Hide all open panels
        startPanel.setVisible(true);                                            //Open start panel
    }//GEN-LAST:event_backButtonActionPerformed

    private void dateMonthListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_dateMonthListMouseClicked
    {//GEN-HEADEREND:event_dateMonthListMouseClicked
        switch(dateMonthList.getSelectedValue())                                //Set the correct number of days by month
        {
            case "January":
                dateDayList.setListData(january);
                break;
            case "February":
                dateDayList.setListData(february);
                break;
            case "March":
                dateDayList.setListData(march);
                break;
            case "April":
                dateDayList.setListData(april);
                break;
            case "May":
                dateDayList.setListData(may);
                break;
            case "June":
                dateDayList.setListData(june);
                break;
            case "July":
                dateDayList.setListData(july);
                break;
            case "August":
                dateDayList.setListData(august);
                break;
            case "September":
                dateDayList.setListData(september);
                break;
            case "October":
                dateDayList.setListData(october);
                break;
            case "November":
                dateDayList.setListData(november);
                break;
            case "December":
                dateDayList.setListData(december);
                break;
        }
    }//GEN-LAST:event_dateMonthListMouseClicked

    private void auditionMonthListMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_auditionMonthListMouseClicked
    {//GEN-HEADEREND:event_auditionMonthListMouseClicked
        switch(auditionMonthList.getSelectedValue())                            //Set the correct number of days by month
        {
            case "January":
                auditionDayList.setListData(january);
                break;
            case "February":
                auditionDayList.setListData(february);
                break;
            case "March":
                auditionDayList.setListData(march);
                break;
            case "April":
                auditionDayList.setListData(april);
                break;
            case "May":
                auditionDayList.setListData(may);
                break;
            case "June":
                auditionDayList.setListData(june);
                break;
            case "July":
                auditionDayList.setListData(july);
                break;
            case "August":
                auditionDayList.setListData(august);
                break;
            case "September":
                auditionDayList.setListData(september);
                break;
            case "October":
                auditionDayList.setListData(october);
                break;
            case "November":
                auditionDayList.setListData(november);
                break;
            case "December":
                auditionDayList.setListData(december);
                break;
        }
    }//GEN-LAST:event_auditionMonthListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ActorLogoutButton;
    private javax.swing.JList<String> actorEventList;
    private javax.swing.JPanel actorMenuPanel;
    private javax.swing.JList<String> actorPartList;
    private javax.swing.JButton actorSelection;
    private javax.swing.JLabel actorsRegisteredLabel;
    private javax.swing.JButton addEventButton;
    private javax.swing.JButton addPartButton;
    private javax.swing.JList<String> auditionDayList;
    private javax.swing.JButton auditionDetailsButton;
    private javax.swing.JList<String> auditionMonthList;
    private javax.swing.JButton auditionResultsButton;
    private javax.swing.JList<String> auditionYearList;
    private javax.swing.JList<String> auditionsList;
    private javax.swing.JPanel auditionsPanel;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel blankPanel;
    private javax.swing.JLabel currentAuditionLabel;
    private javax.swing.JList<String> dateDayList;
    private javax.swing.JList<String> dateMonthList;
    private javax.swing.JLabel dateOfAuditionsLabel;
    private javax.swing.JLabel dateOfEventLabel;
    private javax.swing.JList<String> dateYearList;
    private javax.swing.JButton deleteEventButton;
    private javax.swing.JButton directorLogoutButton;
    private javax.swing.JPanel directorMenuMarginPanel;
    private javax.swing.JPanel directorMenuPanel;
    private javax.swing.JButton directorSelection;
    private javax.swing.JButton editEventButton;
    private javax.swing.JPanel eventManagementPanel;
    private javax.swing.JTextField eventNameField;
    private javax.swing.JPanel eventSelectionPanel;
    private javax.swing.JComboBox<String> eventsComboBox;
    private javax.swing.JPanel firstLoginPanel;
    private javax.swing.JLabel firstLoginWelcomeNameField;
    private javax.swing.JButton getToWorkButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JPanel logInPanel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabelActorMenu;
    private javax.swing.JLabel nameLabelDirectorMenu;
    private javax.swing.JSeparator nameSeperator;
    private javax.swing.JTextField partField;
    private javax.swing.JList<String> partsList;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JSeparator passwordSeperator;
    private javax.swing.JButton removePartButton;
    private javax.swing.JButton selectAuditionButton;
    private javax.swing.JButton setRatingButton;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JPanel startPanel;
    private javax.swing.JButton updateEventButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Hides all open panels
     */
    private void hidePanels()
    {
        actorMenuPanel.setVisible(false);                                       //Hides actorMenuPanel
        blankPanel.setVisible(false);                                           //Hides blankPanel
        logInPanel.setVisible(false);                                           //Hides logInPanel
        startPanel.setVisible(false);                                           //Hides startPanel
        directorMenuPanel.setVisible(false);                                    //Hides directorMenuPanel
        auditionsPanel.setVisible(false);                                       //Hides auditionsListPanel
        eventManagementPanel.setVisible(false);                                 //Hides eventManagementPanel
        firstLoginPanel.setVisible(false);                                      //Hides firsLoginPanel
    }

    /**
     * Remove an element from a string ArrayList
     *
     * @param input
     * @param remove
     * @return ArrayList<String>
     */
    private ArrayList<String> removeElement(ArrayList<String> input, String remove)
    {
        ArrayList<String> tempList = new ArrayList<String>();                   //Create a temparary string arraylist

        for (int i = 0; i < input.size(); i++)                                  //For loop through the 'input' arraylist
        {
            String temp = input.get(i);                                         //New string variable being set equal to an element of the 'input'

            if (temp.equals(remove))                                            //If the temp string variable is equal to the 'remove' variable
            {
                input.remove(i);                                                //Remove the temp variable from the temparary string arraylist
            }
        }

        for (String s : input)                                                  //For each loop through the original input arraylist
        {
            tempList.add(s);                                                    //Add the strings into the arraylist
        }

        return tempList;                                                        //Return the new string arraylist
    }

    /**
     * Reset the Event Management Panel
     */
    private void resetEventManagementPanel()
    {
        eventNameField.setText("event name");                                   //Set eventnameField to 'event name'
        dateOfEventLabel.setText("Date of Event");                              //Set dateOfEventLabel to 'Date of Event'
        dateOfAuditionsLabel.setText("Date of Auditions for Event");            //Set eventnameField to 'Date of Auditions for Event'
        dateDayList.clearSelection();                                           //Unselect dateDayList
        dateMonthList.clearSelection();                                         //Unselect dateMonthList
        dateYearList.clearSelection();                                          //Unselect dateYearList
        auditionDayList.clearSelection();                                       //Unselect auditionDayList
        auditionMonthList.clearSelection();                                     //Unselect auditionMonthList
        auditionYearList.clearSelection();                                      //Unselect auditionYearList
        partField.setText("part");                                              //Set partField to 'part'
        partsList.clearSelection();                                             //Unselect partsList
        partsList.removeAll();                                                  //Remove all elements from partsList
        parts = new ArrayList<String>();                                        //Set parts equal to a new string arraylist
        partsList.setModel(new DefaultListModel());                             //set partsList equal to a new model (clearing it)
    }

    /**
     *
     */
    private void logOut()
    {
        selectedDirector = null;                                                //Deselect director
        selectedActor = null;                                                   //Deselect actor (this doesn't need to be here except for peace of mind)
        directorSelected = null;                                                //Deselect either director or actor

        //Format login screen
        nameField.setForeground(Color.gray);
        nameField.setText("username");
        passwordField.setEchoChar((char) 0);
        passwordField.setForeground(Color.gray);
        passwordField.setText("password");

        hidePanels();                                                           //Hide panels
        startPanel.setVisible(true);                                            //Show start panel
    }
}
