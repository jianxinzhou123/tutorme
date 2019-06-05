package login;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

/*********************************************************** START OF THE LOGIN *****************************************************/

public class Login {
	
	private JFrame frame;
	static private JTextField usernameInput;
	static private JPasswordField passwordField;
	static String passingUsername; //the id that you pass into tutor me client
	static int ID;
	static boolean found;
	static String[] credentialDatabase_username= new String[1000];
	static String[] credentialDatabase_pwd= new String[1000];
    static String[] email= new String[100];
    static String[] paymentMethod= new String[1000];
    static double[] credits= new double[1000];
    static String[] subscriptions= new String[1000];
    static boolean[] hasAppt= new boolean[1000];
    static String[] date = new String[1000];		
    static String[] time = new String[1000];
    static String[] dateAndtime = new String[1000];
    static String[] problem = new String[1000];
    static String[] userType = new String[1000];
    static boolean[] accountEXISTS = new boolean[1000];
    static boolean[] apptConfirmed = new boolean[1000];
    static int[] apptUsedFlag = new int[1000];
    int loginFlag = 0;
    int revalidateFlag = 0;
    double rate = 10;
	String classSelected_queue;
	String classSelected_schedule;
	String educationLevel_queue;
	String educationLevel_schedule;
	private JTextField registerUsernameField;
	private JPasswordField registerPasswordField;
	private JPasswordField confirmPasswordField;
	private JTextField emailField;
	DecimalFormat df = new DecimalFormat("#0.00");

    static void Database() {
    	
    	userType[0] = "ADMIN";
    	userType[1] = "NORMAL";
    	userType[2] = "TUTOR";
    	userType[3] = "NORMAL";
    	

		credentialDatabase_username[0] = "admin";
		credentialDatabase_username[1] = "student";
		credentialDatabase_username[2] = "tutor";
		credentialDatabase_username[3] = "subscriber";
		
				
		credentialDatabase_pwd[0]="admin";
		credentialDatabase_pwd[1] = "student";
		credentialDatabase_pwd[2] = "tutor";
		credentialDatabase_pwd[3] = "subscriber";

		email[0]="admin@admin.com";
		email[1]="jzhou104@syr.edu";
		email[2]="tutor@tutor.me";
		email[3]="imavip@vip.com";
		
		paymentMethod[0] = "N/A";
		paymentMethod[1] = "MASTER";
		paymentMethod[2] = "VISA";
		paymentMethod[3] = "VISA";
		
		credits[0]= 9999999;
		credits[1]= 50;
		credits[2]= 0;
		credits[3] = 82;
		
		subscriptions[0]="FREE";
		subscriptions[1]="NO";
		subscriptions[2]="FREE";
		subscriptions[3]="YES";
		
		hasAppt[0] = true;
		hasAppt[1] = false;
		hasAppt[2] = false;
		hasAppt[3] = true;
		
		date[0] = "Feburary 15, 2018";
		date[1] = null;
		date[2] = null;
		date[3] = "March 2, 2018";
		
		time[0] = "2:30 PM";
		time[1] = null;
		time[2] = null;
		time[3] = "2:30 AM";
		
		dateAndtime[0] = date[0]+ " " + time[0];
		dateAndtime[1] = date[1]+ " " + time[1];
		dateAndtime[2] = date[2]+ " " + time[2];
		dateAndtime[3] = date[3]+ " " + time[3];
		
		problem[0] = "huge problem omg pls help";
		problem[1] = null;
		problem[2] = null;
		problem[3] = "help please :D";
		
		accountEXISTS[0]=true;
		accountEXISTS[1]=true;
		accountEXISTS[2]=true;
		accountEXISTS[3]=true;
		
		apptConfirmed[0]=true;
		apptConfirmed[1]=false;
		apptConfirmed[2]=false;
		apptConfirmed[3]=false;

		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());  // This line gives Windows Theme
				    } 
				catch (Exception e) 
				{
				      e.printStackTrace();
				    }
				
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}


	public Login() {
		if (loginFlag==0) 
		{
			Database();
			loginFlag = 1;
			initialize();
		}
		else
		{
			initialize();
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	/*********************************************************** START OF THE LOGIN *****************************************************/
	/** @wbp.parser.entryPoint */
	void initialize() {
		
		JOptionPane.showMessageDialog(null, "As a demo, this program uses a local database.\nAll data entries/modifications will be removed upon closing.\nSQL implementation will be done upon request.", "Important Notice", JOptionPane.INFORMATION_MESSAGE);
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("tutorMeIcon.png"));
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setTitle("Tutor.Me Login JAVA Re-Distrubtable - FINAL DEMO");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel logo = new JLabel("Tutor.Me");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setForeground(Color.ORANGE);
		logo.setFont(new Font("Elephant", Font.ITALIC, 37));
		logo.setBounds(0, 28, 444, 49);
		frame.getContentPane().add(logo);
		
		JLabel slogan = new JLabel("Brings you a brand new tutoring experience.");
		slogan.setHorizontalAlignment(SwingConstants.CENTER);
		slogan.setBounds(0, 70, 444, 14);
		frame.getContentPane().add(slogan);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(99, 112, 72, 14);
		frame.getContentPane().add(usernameLabel);
		
		usernameInput = new JTextField();
		usernameInput.setBounds(172, 109, 180, 20);
		frame.getContentPane().add(usernameInput);
		usernameInput.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(99, 137, 72, 14);
		frame.getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(172, 134, 180, 20);
		frame.getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("Login"); 
		loginButton.setBounds(56, 180, 89, 23);
		frame.getContentPane().add(loginButton);
		//loginButton.setEnabled(false);
		
		JButton registerButton = new JButton("Register");
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				JOptionPane.showMessageDialog(null, "Please note that the PAYMENT OPTION is currently dysfunctional.\nYour preferred payment option will be recorded, but no credentials will be needed.", "Important Notice", JOptionPane.INFORMATION_MESSAGE);
				Register();
			}
		});
		registerButton.setBounds(165, 180, 89, 23);
		frame.getContentPane().add(registerButton);
		registerButton.setFocusPainted(false);
		//registerButton.setEnabled(false);

		JButton forgotPassButton = new JButton("Forgot Pass");
		forgotPassButton.setBounds(272, 180, 110, 23);
		frame.getContentPane().add(forgotPassButton);
		forgotPassButton.setFocusPainted(false);
		//forgotPassButton.setEnabled(false);
		
		JSeparator loginPageSeperator = new JSeparator();
		loginPageSeperator.setBounds(35, 224, 368, 2);
		frame.getContentPane().add(loginPageSeperator);
		
		JLabel lblSam = new JLabel("2018 \u00A9 Sam (Jianxin) Zhou, Matt Paddock, Steven Szachara, Ryan Bull - All Rights Reserved.");
		lblSam.setHorizontalAlignment(SwingConstants.CENTER);
		lblSam.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblSam.setBounds(0, 237, 444, 14);
	
		frame.getContentPane().add(lblSam);
		
		JLabel lblDemo = new JLabel("DEMO");
		lblDemo.setHorizontalAlignment(SwingConstants.CENTER);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        lblDemo.setBorder(border);
		lblDemo.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblDemo);
		
		JLabel lblLocal = new JLabel("NET");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setForeground(Color.LIGHT_GRAY);
		lblLocal.setBorder(border);
		lblLocal.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblLocal.setBounds(10, 28, 46, 14);
		frame.getContentPane().add(lblLocal);
		
		JLabel lblSQL = new JLabel("SQL");
		lblSQL.setForeground(Color.LIGHT_GRAY);
		lblSQL.setHorizontalAlignment(SwingConstants.CENTER);
		lblSQL.setBorder(new LineBorder(Color.LIGHT_GRAY));
		lblSQL.setBounds(10, 45, 46, 14); //editline
		
		frame.getContentPane().add(lblSQL);
		
		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
	
				String id = usernameInput.getText().toLowerCase();
				passingUsername = usernameInput.getText();
				String pwd = passwordField.getText();
				
				if (usernameInput.getText().isEmpty() || passwordField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Missing a field.");
				}
				
				else if (checkArrayID(credentialDatabase_username, id)==false)
				{
					JOptionPane.showMessageDialog(null, "Unmatching credential.");
					Toolkit.getDefaultToolkit().beep();
				}
				else if (checkArrayID(credentialDatabase_username, id)==true)
					{
						for(int i = 0; i<credentialDatabase_username.length; i++)
							{	
								if(credentialDatabase_username[i].toLowerCase().equals(id.toLowerCase())) {
									if(credentialDatabase_pwd[i].equals(pwd))
									{
										if(Login.userType[i].equals("TUTOR") || (Login.userType[i].equals("ADMIN")))
										{
											ID = i;
											frame.dispose(); TutorMe(); advisorPanel(); usernameInput.setText(""); passwordField.setText("");
										}
										else
										{
											ID = i;
											frame.dispose(); TutorMe(); usernameInput.setText(""); passwordField.setText("");
										}
										 
									}
									else	
									{
										JOptionPane.showMessageDialog(null, "Unmatching credential.");
										Toolkit.getDefaultToolkit().beep();

									}
								}
							}
						}
				
				/*if(!credentialDatabase_username[credentialDatabase_username.length].equals(id)) {
					System.out.println("no id found");
				}*/
			}
		});
		
		forgotPassButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose(); ForgotPassword();
			}
		});
	}
	
	/*********************************************************** START OF THE CLIENT *****************************************************/
	
	void TutorMe() {

	    JFrame TutorMeFrame;

		TutorMeFrame = new JFrame();
		TutorMeFrame.setBounds(100, 100, 800, 600);
		TutorMeFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("tutorMeIcon.png"));
		TutorMeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TutorMeFrame.getContentPane().setLayout(null);
		TutorMeFrame.setResizable(false);
		TutorMeFrame.setTitle("Tutor.Me Student Portal - " + Login.credentialDatabase_username[Login.ID] + " | USERTYPE: " + Login.userType[Login.ID]);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		TutorMeFrame.setLocation(dim.width/2-TutorMeFrame.getSize().width/2, dim.height/2-TutorMeFrame.getSize().height/2);

		
		JLabel Title = new JLabel("Tutor.Me");
		Title.setForeground(Color.ORANGE);
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("Elephant", Font.ITALIC, 37));
		Title.setBounds(0, 11, 784, 49);
		TutorMeFrame.getContentPane().add(Title);
		
		JPanel SummaryPanel = new JPanel();
		SummaryPanel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Account Summary", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		SummaryPanel.setBounds(8, 102, 212, 123);
		TutorMeFrame.getContentPane().add(SummaryPanel);
		SummaryPanel.setLayout(null);

		
		JLabel usernameLabel = new JLabel("Username: ");
		SummaryPanel.add(usernameLabel);
		usernameLabel.setBounds(10, 22, 104, 14);
		
		JLabel paymentMethodLabel = new JLabel("Payment Method:");
		paymentMethodLabel.setBounds(10, 47, 119, 14);
		SummaryPanel.add(paymentMethodLabel);
		
		JLabel currentCreditsLabel = new JLabel("Current Credits:");
		currentCreditsLabel.setBounds(10, 72, 104, 14);
		SummaryPanel.add(currentCreditsLabel);
		
		JLabel subcriptionsLabel = new JLabel("Subscription:");
		subcriptionsLabel.setBounds(10, 97, 104, 14);
		SummaryPanel.add(subcriptionsLabel);
		
		JLabel usernameDisplay = new JLabel(Login.credentialDatabase_username[Login.ID]);
		usernameDisplay.setBounds(124, 22, 78, 14);
		SummaryPanel.add(usernameDisplay);
		
		JLabel paymentMethodDisplay = new JLabel(Login.paymentMethod[Login.ID]);
		paymentMethodDisplay.setBounds(124, 47, 78, 14);
		SummaryPanel.add(paymentMethodDisplay);
		
		JLabel currentCreditsDisplay = new JLabel("" + (df.format(Login.credits[Login.ID])));
		currentCreditsDisplay.setBounds(124, 72, 78, 14);
		SummaryPanel.add(currentCreditsDisplay);
		
		JLabel subscriptionsDisplay = new JLabel(Login.subscriptions[Login.ID]);
		subscriptionsDisplay.setBounds(124, 97, 78, 14);
		SummaryPanel.add(subscriptionsDisplay);
		
		JPanel PreferredSubjects = new JPanel();
		PreferredSubjects.setLayout(null);
		PreferredSubjects.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Preferred Subjects", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		PreferredSubjects.setBounds(224, 102, 333, 123);
		TutorMeFrame.getContentPane().add(PreferredSubjects);
		
		
		JRadioButton englishRadio = new JRadioButton("English");
		englishRadio.setBounds(6, 17, 81, 23);
		PreferredSubjects.add(englishRadio);
		
		
		JRadioButton mathRadio = new JRadioButton("Math");
		mathRadio.setBounds(6, 43, 81, 23);
		PreferredSubjects.add(mathRadio);
		
		JRadioButton historyRadio = new JRadioButton("History");
		historyRadio.setBounds(6, 67, 81, 23);
		PreferredSubjects.add(historyRadio);
		
		JRadioButton foreignLanguageRadio = new JRadioButton("Foreign Lan");
		foreignLanguageRadio.setBounds(6, 93, 107, 23);
		PreferredSubjects.add(foreignLanguageRadio);
		
		JRadioButton scienceRadio = new JRadioButton("Science");
		scienceRadio.setBounds(93, 17, 81, 23);
		PreferredSubjects.add(scienceRadio);
		
		JRadioButton artsRadio = new JRadioButton("Arts");
		artsRadio.setBounds(93, 43, 81, 23);
		PreferredSubjects.add(artsRadio);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(199, 17, 1, 106);
		PreferredSubjects.add(separator_1);
		
		JSeparator preferredSubjectsSeperator = new JSeparator();
		preferredSubjectsSeperator.setBounds(188, 17, 1, 94);
		PreferredSubjects.add(preferredSubjectsSeperator);
		preferredSubjectsSeperator.setOrientation(SwingConstants.VERTICAL);
		
		JRadioButton lvElementaryRadio = new JRadioButton("Grade 1-5");
		lvElementaryRadio.setHorizontalAlignment(SwingConstants.CENTER);
		lvElementaryRadio.setBounds(196, 17, 131, 23);
		PreferredSubjects.add(lvElementaryRadio);
		
		JRadioButton lvMiddleSchoolRadio = new JRadioButton("Grade 6-8");
		lvMiddleSchoolRadio.setHorizontalAlignment(SwingConstants.CENTER);
		lvMiddleSchoolRadio.setBounds(199, 43, 128, 23);
		PreferredSubjects.add(lvMiddleSchoolRadio);
		
		JRadioButton lvHighSchoolRadio = new JRadioButton("Grade 9-12");
		lvHighSchoolRadio.setHorizontalAlignment(SwingConstants.CENTER);
		lvHighSchoolRadio.setBounds(199, 67, 128, 23);
		PreferredSubjects.add(lvHighSchoolRadio);
		
		JRadioButton lvCollegeRadio = new JRadioButton("Higher Ed");
		lvCollegeRadio.setHorizontalAlignment(SwingConstants.CENTER);
		lvCollegeRadio.setBounds(199, 93, 128, 23);
		PreferredSubjects.add(lvCollegeRadio);
		
		JSeparator logo_seperator = new JSeparator();
		logo_seperator.setBounds(10, 83, 774, 2);
		TutorMeFrame.getContentPane().add(logo_seperator);
		
		JPanel Options = new JPanel();
		Options.setLayout(null);
		Options.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Options", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		Options.setBounds(561, 102, 223, 123);
		TutorMeFrame.getContentPane().add(Options);
		
		JButton topUpCredits = new JButton("Top Up Credits");
		topUpCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Login.userType[Login.ID].equals("NORMAL")) {
				TutorMeFrame.dispose();
				topUp();
				currentCreditsDisplay.setText("" + df.format(Login.credits[Login.ID]));
				}
				else
				{
				JOptionPane.showMessageDialog(null, "This account is not available for credit funding.");
				}
			}
		});
		topUpCredits.setBounds(10, 21, 203, 23);
		Options.add(topUpCredits);
		topUpCredits.setFocusPainted(false);
		
		JButton btnEmailDevs = new JButton("Email Devs");
		btnEmailDevs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Okay. Here's the email address: jzhou104@syr.edu.", "Email Request", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnEmailDevs.setBounds(10, 89, 203, 23);
		Options.add(btnEmailDevs);
		btnEmailDevs.setFocusPainted(false);
		
		JButton purchaseSubscription = new JButton("Purchase Subscription");
		purchaseSubscription.setBounds(10, 43, 203, 23);
		Options.add(purchaseSubscription);
		purchaseSubscription.setFocusPainted(false);
		
		JButton FAQ = new JButton("FAQ");
		FAQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			FAQ();
			}
		});
		FAQ.setBounds(10, 66, 203, 23);
		Options.add(FAQ);
		FAQ.setFocusPainted(false);
		
		JLabel sloganLabel = new JLabel("Brings you a brand new tutoring experience.");
		sloganLabel.setHorizontalAlignment(SwingConstants.CENTER);
		sloganLabel.setBounds(0, 58, 784, 14);
		TutorMeFrame.getContentPane().add(sloganLabel);
		
		JButton queueUpButton = new JButton("I NEED A TUTOR NOW!");
		queueUpButton.setBounds(10, 271, 210, 49);
		TutorMeFrame.getContentPane().add(queueUpButton);
		queueUpButton.setFocusPainted(false);
		
		JSeparator schedulingSeperator = new JSeparator();
		schedulingSeperator.setBounds(10, 331, 774, 2);
		TutorMeFrame.getContentPane().add(schedulingSeperator);
		
		JPanel scheduleAppointmentPanel = new JPanel();
		scheduleAppointmentPanel.setLayout(null);
		scheduleAppointmentPanel.setBorder(new TitledBorder(new LineBorder(new Color(169, 169, 169), 4, true), "Schedule An Appointment", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scheduleAppointmentPanel.setBounds(10, 337, 774, 223);
		TutorMeFrame.getContentPane().add(scheduleAppointmentPanel);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Preferred Subjects", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(20, 21, 362, 123);
		scheduleAppointmentPanel.add(panel);
		
		JRadioButton englishRadioSchedule = new JRadioButton("English");
		englishRadioSchedule.setBounds(6, 17, 85, 23);
		panel.add(englishRadioSchedule);
		
		JRadioButton mathRadioSchedule = new JRadioButton("Math");
		mathRadioSchedule.setBounds(6, 43, 85, 23);
		panel.add(mathRadioSchedule);
		
		JRadioButton historyRadioSchedule = new JRadioButton("History");
		historyRadioSchedule.setBounds(6, 67, 85, 23);
		panel.add(historyRadioSchedule);
		
		JRadioButton foreignLanRadioSchedule = new JRadioButton("Foreign Lan");
		foreignLanRadioSchedule.setBounds(6, 93, 107, 23);
		panel.add(foreignLanRadioSchedule);
		
		JRadioButton scienceRadioSchedule = new JRadioButton("Science");
		scienceRadioSchedule.setBounds(93, 17, 81, 23);
		panel.add(scienceRadioSchedule);
		
		JRadioButton artsRadioSchedule = new JRadioButton("Arts");
		artsRadioSchedule.setBounds(93, 43, 81, 23);
		panel.add(artsRadioSchedule);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(199, 17, 1, 106);
		panel.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(180, 17, 1, 94);
		panel.add(separator_2);
		
		JRadioButton elementarySchedule = new JRadioButton("Grade 1-5");
		elementarySchedule.setHorizontalAlignment(SwingConstants.CENTER);
		elementarySchedule.setBounds(188, 17, 168, 23);
		panel.add(elementarySchedule);
		
		JRadioButton msSchedule = new JRadioButton("Grade 6-8");
		msSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		msSchedule.setBounds(188, 43, 168, 23);
		panel.add(msSchedule);
		
		JRadioButton hsSchedule = new JRadioButton("Grade 9-12");
		hsSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		hsSchedule.setBounds(188, 67, 168, 23);
		panel.add(hsSchedule);
		
		JRadioButton higherEdSchedule = new JRadioButton("Higher Ed");
		higherEdSchedule.setHorizontalAlignment(SwingConstants.CENTER);
		higherEdSchedule.setBounds(188, 93, 168, 23);
		panel.add(higherEdSchedule);
	
		JButton cancelAppointment = new JButton("Cancel Appointment");
		cancelAppointment.setBounds(205, 155, 177, 47);
		scheduleAppointmentPanel.add(cancelAppointment);
		cancelAppointment.setFocusPainted(false);
		
		JButton scheduleButton = new JButton("Schedule for Later");
		scheduleButton.setForeground(Color.BLACK);
		scheduleButton.setBounds(18, 155, 177, 47);
		scheduleAppointmentPanel.add(scheduleButton);
		scheduleButton.setFocusPainted(false);
		if(Login.hasAppt[Login.ID]==(true))
		{
			scheduleButton.setEnabled(false);
		}
		else
		{
			cancelAppointment.setEnabled(false);
		}
		
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(399, 30, 2, 173);
		scheduleAppointmentPanel.add(separator_3);
		
		JPanel scheduleProperties = new JPanel();
		scheduleProperties.setBounds(411, 21, 335, 181);
		scheduleAppointmentPanel.add(scheduleProperties);
		scheduleProperties.setLayout(null);
		scheduleProperties.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Schedule Properties", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		
		JLabel lblSelectTime = new JLabel("Select Time:");
		lblSelectTime.setBounds(10, 72, 109, 14);
		scheduleProperties.add(lblSelectTime);
		
		DatePicker datePicker = new DatePicker();
		datePicker.setBounds(129, 27, 180, 26);
		scheduleProperties.add(datePicker);
		datePicker.setDateToToday();
		if(Login.hasAppt[Login.ID]==true)
		{
			datePicker.setEnabled(false);
			datePicker.setText(Login.date[Login.ID]);;
		}
		else 
			datePicker.setEnabled(true);

		
		TimePicker timePicker = new TimePicker();
		timePicker.setBounds(129, 68, 180, 23);
		scheduleProperties.add(timePicker);
		if(Login.hasAppt[Login.ID]==true)
		{
			timePicker.setEnabled(false);
			timePicker.setText(Login.time[Login.ID]);;
		}
		else 
			timePicker.setEnabled(true);

			
		JLabel problemLabel = new JLabel("Problem:");
		problemLabel.setBounds(10, 122, 109, 14);
		scheduleProperties.add(problemLabel);
		
		
		JTextArea problemBox = new JTextArea();
		problemBox.setWrapStyleWord(true);
		problemBox.setLineWrap(true);
		//panel_1.add(textArea);
		JScrollPane scroll = new JScrollPane(problemBox);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(129, 102, 180, 68);
		scheduleProperties.add(scroll);
		if(Login.hasAppt[Login.ID]==true)
		{
			problemBox.setEnabled(false);
			problemBox.setText(Login.problem[Login.ID]);;
		}
		else 
			problemBox.setEnabled(true);
		
		
		JLabel lblSelectDate = new JLabel("Select Date:");
		lblSelectDate.setBounds(10, 32, 109, 14);
		scheduleProperties.add(lblSelectDate);
		scheduleProperties.revalidate();
		scheduleProperties.repaint();
		
		scheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(scheduleButton.isEnabled()) {
					
					if(englishRadioSchedule.isSelected()==false && historyRadioSchedule.isSelected()==false && mathRadioSchedule.isSelected()==false && foreignLanRadioSchedule.isSelected()==false &&
					   scienceRadioSchedule.isSelected()==false && artsRadioSchedule.isSelected()==false || elementarySchedule.isSelected()==false && msSchedule.isSelected()==false
				       && hsSchedule.isSelected()==false && higherEdSchedule.isSelected()==false || timePicker.getText().isEmpty() || datePicker.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "FAILURE: You must complete the above fields before scheduling for an appointment!");
					}
					
					
					else 
					{
						if(Login.credits[Login.ID]-50<0 && (Login.subscriptions[Login.ID]!="FREE" && Login.subscriptions[Login.ID]!="YES"))
					{
						JOptionPane.showMessageDialog(null, "You don't have enough credits! Please top up!", "Not Enough Credits", JOptionPane.INFORMATION_MESSAGE);
					}
					
					else {
						String apptDate = datePicker.getText();
						String apptTime = timePicker.getText();
						String problem = problemBox.getText();
						int result = JOptionPane.showConfirmDialog(null, "You selected: " + educationLevel_schedule + " - " + classSelected_schedule + ".\nDate: " + apptDate + "\nTime: " + apptTime + "\nProblem: " + problem + "\nWill cost: 50 redits\n\nProceed?");
					
					if (result == JOptionPane.YES_OPTION)
					{
						if(Login.subscriptions[Login.ID].equals("FREE")||Login.subscriptions[Login.ID].equals("YES"))
						{
							JOptionPane.showMessageDialog(null, "You are a paid subscriber.\nYour credits are not charged.", "Subscription Detected", JOptionPane.INFORMATION_MESSAGE);
						}
						JOptionPane.showMessageDialog(null, "Your appointment has been requested. Please be on time.\nWe will shoot you an email to " + Login.email[Login.ID] + " once the tutor is ready.", "Scheduled Successfully", JOptionPane.INFORMATION_MESSAGE);
						if(Login.subscriptions[Login.ID]!="YES" && Login.subscriptions[Login.ID]!="FREE")
						{
						Login.credits[Login.ID]=Login.credits[Login.ID]-50;
						currentCreditsDisplay.setText("" + Login.credits[Login.ID]);
						}
						Login.hasAppt[Login.ID]=true;
						Login.date[Login.ID]=apptDate;
						Login.time[Login.ID]=apptTime;
						Login.problem[Login.ID]=problem;
						Login.apptUsedFlag[Login.ID]=0;
						Login.apptConfirmed[Login.ID]=false;
						Login.dateAndtime[Login.ID]=Login.date[Login.ID] + " " + Login.time[Login.ID];
						cancelAppointment.setEnabled(true);
						scheduleButton.setEnabled(false);
						timePicker.setEnabled(false);
						datePicker.setEnabled(false);
						problemBox.setEnabled(false);
					}
					
					else 
					{	
						JOptionPane.showMessageDialog(null, "Transaction canceled.", "Appointment Not Scheduled", JOptionPane.INFORMATION_MESSAGE);
					}
						}	
					}
				}
			}
		});
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 236, 774, 26);
		TutorMeFrame.getContentPane().add(progressBar);
		progressBar.setStringPainted(true);
		progressBar.setMinimum(0);
		progressBar.setMaximum(100);
		progressBar.setValue(0);
		progressBar.setString("0%");
		
		JButton resetButton = new JButton("Reset");
		resetButton.setBounds(420, 271, 177, 49);
		TutorMeFrame.getContentPane().add(resetButton);
		resetButton.setFocusPainted(false);
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.setBounds(607, 271, 177, 49);
		TutorMeFrame.getContentPane().add(logOutButton);
		logOutButton.setFocusPainted(false);
		
		
		englishRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(englishRadio.isSelected())
				{
					mathRadio.setSelected(false);
					historyRadio.setSelected(false);
					foreignLanguageRadio.setSelected(false);
					scienceRadio.setSelected(false);
					artsRadio.setSelected(false);
					classSelected_queue = englishRadio.getLabel();
				}
			}
		});
		
		mathRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(mathRadio.isSelected())
				{
					englishRadio.setSelected(false);
					historyRadio.setSelected(false);
					foreignLanguageRadio.setSelected(false);
					scienceRadio.setSelected(false);
					artsRadio.setSelected(false);
					classSelected_queue = mathRadio.getLabel();
					
				}
			}
		});
		
		historyRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(historyRadio.isSelected())
				{
					englishRadio.setSelected(false);
					mathRadio.setSelected(false);
					foreignLanguageRadio.setSelected(false);
					scienceRadio.setSelected(false);
					artsRadio.setSelected(false);
					classSelected_queue = historyRadio.getLabel();
					
				}
			}
		});
		
		foreignLanguageRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(foreignLanguageRadio.isSelected())
				{
					englishRadio.setSelected(false);
					mathRadio.setSelected(false);
					historyRadio.setSelected(false);
					scienceRadio.setSelected(false);
					artsRadio.setSelected(false);
					classSelected_queue = foreignLanguageRadio.getLabel();
					
				}
			}
		});
		
		scienceRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(scienceRadio.isSelected())
				{
					englishRadio.setSelected(false);
					mathRadio.setSelected(false);
					historyRadio.setSelected(false);
					foreignLanguageRadio.setSelected(false);
					artsRadio.setSelected(false);
					classSelected_queue = scienceRadio.getLabel();
					
				}
			}
		});
		
		artsRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(artsRadio.isSelected())
				{
					englishRadio.setSelected(false);
					mathRadio.setSelected(false);
					historyRadio.setSelected(false);
					foreignLanguageRadio.setSelected(false);
					scienceRadio.setSelected(false);
					classSelected_queue = artsRadio.getLabel();
					
				}
			}
		});
		
		lvElementaryRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(lvElementaryRadio.isSelected())
				{
					lvMiddleSchoolRadio.setSelected(false);
					lvHighSchoolRadio.setSelected(false);
					lvCollegeRadio.setSelected(false);
					educationLevel_queue = lvElementaryRadio.getLabel();
				}
			}
		});
		
		lvMiddleSchoolRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(lvMiddleSchoolRadio.isSelected())
				{
					lvElementaryRadio.setSelected(false);
					lvHighSchoolRadio.setSelected(false);
					lvCollegeRadio.setSelected(false);
					educationLevel_queue = lvMiddleSchoolRadio.getLabel();
				}
			}
		});
		
		lvHighSchoolRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(lvHighSchoolRadio.isSelected())
				{
					lvElementaryRadio.setSelected(false);
					lvMiddleSchoolRadio.setSelected(false);
					lvCollegeRadio.setSelected(false);
					educationLevel_queue = lvHighSchoolRadio.getLabel();
				}
			}
		});
		
		lvCollegeRadio.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(lvCollegeRadio.isSelected())
				{
					lvElementaryRadio.setSelected(false);
					lvMiddleSchoolRadio.setSelected(false);
					lvHighSchoolRadio.setSelected(false);
					educationLevel_queue = lvCollegeRadio.getLabel();
				}
			}
		});
		
		JButton cancelQueueUp = new JButton("Cancel Queue");
		cancelQueueUp.setBounds(233, 271, 177, 49);
		TutorMeFrame.getContentPane().add(cancelQueueUp);
		cancelQueueUp.setEnabled(false);
		cancelQueueUp.setFocusPainted(false);
		
		cancelQueueUp.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(cancelQueueUp.isEnabled()) {
					cancelQueueUp.setText("Cancel");
					cancelQueueUp.setEnabled(false);
					queueUpButton.setEnabled(true);
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "SUCCESS: Your session has ended.");
					progressBar.setValue(0);
					progressBar.setStringPainted(true);
					progressBar.setString("0%");
				}
			}
		});
		
		queueUpButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(queueUpButton.isEnabled()) {
					if(englishRadio.isSelected()==false && historyRadio.isSelected()==false && mathRadio.isSelected()==false && foreignLanguageRadio.isSelected()==false &&
					   scienceRadio.isSelected()==false && artsRadio.isSelected()==false || lvElementaryRadio.isSelected()==false && lvMiddleSchoolRadio.isSelected()==false
				       && lvHighSchoolRadio.isSelected()==false && lvCollegeRadio.isSelected()==false)
					{
						JOptionPane.showMessageDialog(null, "FAILURE: You must complete the above fields before queuing up for the tutoring session!");
					}
				
					else {
						if(Login.credits[Login.ID]-50<0 && (Login.subscriptions[Login.ID]!="FREE" && Login.subscriptions[Login.ID]!="YES"))
						{
							JOptionPane.showMessageDialog(null, "You don't have enough credits! Please top up!", "Not Enough Credits", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							
							int result = JOptionPane.showConfirmDialog(null, "You selected: " + educationLevel_queue + " - " + classSelected_queue + "\nWill cost: 50 redits\n\nProceed?");
							
							if (result == JOptionPane.YES_OPTION)
							{
								if(Login.subscriptions[Login.ID].equals("FREE")||Login.subscriptions[Login.ID].equals("YES"))
								{
									JOptionPane.showMessageDialog(null, "You are a paid subscriber.\nYour credits are not charged.", "Subscription Detected", JOptionPane.INFORMATION_MESSAGE);
								}
								JOptionPane.showMessageDialog(null, "You are now searching for a tutor. Please wait...", "Queued Successfully", JOptionPane.INFORMATION_MESSAGE);
					
						cancelQueueUp.setEnabled(true);
						while(progressBar.getValue()!=100) {
							progressBar.setStringPainted(true);
							progressBar.setString("Now loading...");
							if (progressBar.getValue()<=100) {
								progressBar.setValue(progressBar.getValue()+5);
								progressBar.setString("100%");}						
							}
								JOptionPane.showMessageDialog(null, "Your tutor match has been found.\nOpening a new window in Google Chrome...", "Found", JOptionPane.INFORMATION_MESSAGE);
								
								try {
						            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome app2/Main/index.jsp"});
						        } catch (Exception e) {

						        }				
								
								if(Login.subscriptions[Login.ID]!="YES" && Login.subscriptions[Login.ID]!="FREE")
								{
								Login.credits[Login.ID]=Login.credits[Login.ID]-50;
								currentCreditsDisplay.setText("" + Login.credits[Login.ID]);
								}
								queueUpButton.setEnabled(false);
								cancelQueueUp.setText("End Session");
								
							}
							
							else 
							{	
								JOptionPane.showMessageDialog(null, "Transaction canceled.", "Queue Unsuccessful", JOptionPane.INFORMATION_MESSAGE);
							}
							}
						}
					}
				}
			});
		
		
		englishRadioSchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(englishRadioSchedule.isSelected())
				{
					mathRadioSchedule.setSelected(false);
					historyRadioSchedule.setSelected(false);
					foreignLanRadioSchedule.setSelected(false);
					scienceRadioSchedule.setSelected(false);
					artsRadioSchedule.setSelected(false);
					classSelected_schedule = englishRadioSchedule.getLabel();
				}
				
			}
		});
		
		mathRadioSchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(mathRadioSchedule.isSelected())
				{
					englishRadioSchedule.setSelected(false);
					historyRadioSchedule.setSelected(false);
					foreignLanRadioSchedule.setSelected(false);
					scienceRadioSchedule.setSelected(false);
					artsRadioSchedule.setSelected(false);
					classSelected_schedule = mathRadioSchedule.getLabel();
				}
				
			}
		});
		
		historyRadioSchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(historyRadioSchedule.isSelected())
				{
					mathRadioSchedule.setSelected(false);
					englishRadioSchedule.setSelected(false);
					foreignLanRadioSchedule.setSelected(false);
					scienceRadioSchedule.setSelected(false);
					artsRadioSchedule.setSelected(false);
					classSelected_schedule = historyRadioSchedule.getLabel();
				}
				
			}
		});
		
		foreignLanRadioSchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(foreignLanRadioSchedule.isSelected())
				{
					mathRadioSchedule.setSelected(false);
					englishRadioSchedule.setSelected(false);
					historyRadioSchedule.setSelected(false);
					scienceRadioSchedule.setSelected(false);
					artsRadioSchedule.setSelected(false);
					classSelected_schedule = foreignLanRadioSchedule.getLabel();
				}
				
			}
		});
		
		scienceRadioSchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(scienceRadioSchedule.isSelected())
				{
					mathRadioSchedule.setSelected(false);
					englishRadioSchedule.setSelected(false);
					foreignLanRadioSchedule.setSelected(false);
					historyRadioSchedule.setSelected(false);
					artsRadioSchedule.setSelected(false);
					classSelected_schedule = scienceRadioSchedule.getLabel();
				}
				
			}
		});
		
		artsRadioSchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(artsRadioSchedule.isSelected())
				{
					mathRadioSchedule.setSelected(false);
					englishRadioSchedule.setSelected(false);
					foreignLanRadioSchedule.setSelected(false);
					scienceRadioSchedule.setSelected(false);
					historyRadioSchedule.setSelected(false);
					classSelected_schedule = artsRadioSchedule.getLabel();
				}
				
			}
		});
		
		elementarySchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(elementarySchedule.isSelected())
				{
					msSchedule.setSelected(false);
					hsSchedule.setSelected(false);
					higherEdSchedule.setSelected(false);
					educationLevel_schedule = elementarySchedule.getLabel();
				}
				
			}
		});
		
		msSchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(msSchedule.isSelected())
				{
					elementarySchedule.setSelected(false);
					hsSchedule.setSelected(false);
					higherEdSchedule.setSelected(false);
					educationLevel_schedule = msSchedule.getLabel();
				}
				
			}
		});
		
		hsSchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(hsSchedule.isSelected())
				{
					msSchedule.setSelected(false);
					elementarySchedule.setSelected(false);
					higherEdSchedule.setSelected(false);
					educationLevel_schedule = hsSchedule.getLabel();
				}
				
			}
		});
		
		higherEdSchedule.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(higherEdSchedule.isSelected())
				{
					msSchedule.setSelected(false);
					hsSchedule.setSelected(false);
					elementarySchedule.setSelected(false);
					educationLevel_schedule = higherEdSchedule.getLabel();
				}
				
			}
		});
		
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lvElementaryRadio.setSelected(false);
				lvMiddleSchoolRadio.setSelected(false);
				lvHighSchoolRadio.setSelected(false);
				lvCollegeRadio.setSelected(false);
				englishRadio.setSelected(false);
				mathRadio.setSelected(false);
				historyRadio.setSelected(false);
				scienceRadio.setSelected(false);
				artsRadio.setSelected(false);
				foreignLanguageRadio.setSelected(false);
				progressBar.setValue(0);
				progressBar.setStringPainted(true);
				progressBar.setString("0%");
				elementarySchedule.setSelected(false);
				msSchedule.setSelected(false);
				hsSchedule.setSelected(false);
				higherEdSchedule.setSelected(false);
				englishRadioSchedule.setSelected(false);
				mathRadioSchedule.setSelected(false);
				historyRadioSchedule.setSelected(false);
				scienceRadioSchedule.setSelected(false);
				artsRadioSchedule.setSelected(false);
				foreignLanRadioSchedule.setSelected(false);
				timePicker.setText(Login.time[Login.ID]);
				datePicker.setText(Login.date[Login.ID]);
				Login.apptConfirmed[Login.ID]=false;
				Login.credits[Login.ID]=0;
				Login.date[Login.ID]=null;
				Login.time[Login.ID]=null;
				Login.dateAndtime[Login.ID]=null;
				Login.hasAppt[Login.ID]=false;
				Login.apptUsedFlag[Login.ID]=0;
				Login.problem[Login.ID]="";
				Login.subscriptions[Login.ID]="NO";
				TutorMeFrame.dispose();
				JOptionPane.showMessageDialog(null, "Please wait while we reset your data.");
				TutorMe();
			}
		});		
		
		cancelAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(Login.hasAppt[Login.ID]==false)
				{
					JOptionPane.showMessageDialog(null, "FAILURE: You do not seem to have an appointment on file.", "Failed", JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					
					Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(null, "SUCCESS: You appointment has been canceled.", "Success", JOptionPane.INFORMATION_MESSAGE);
					Login.hasAppt[Login.ID]=false;
					Login.date[Login.ID]=null;
					Login.time[Login.ID]=null;
					Login.problem[Login.ID]=null;
					if(Login.subscriptions[Login.ID]=="NO")
					{
					Login.credits[Login.ID]=Login.credits[Login.ID]+50;
					}
					currentCreditsDisplay.setText("" + Login.credits[Login.ID]);
					scheduleButton.setEnabled(true);
					cancelAppointment.setEnabled(false);
					timePicker.setEnabled(true);
					datePicker.setEnabled(true);
					problemBox.setEnabled(true);
					timePicker.setText("");
					datePicker.setText("");
					problemBox.setText("");
				}
			}
		});
		
		purchaseSubscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if (Login.userType[Login.ID].equals("ADMIN") || Login.userType[Login.ID].equals("TUTOR"))
			{
				JOptionPane.showMessageDialog(null, "This account is not available for subscription funding.");
			}
			else
			{
				buySubscription();
				TutorMeFrame.dispose();
			}
			}
		});
		
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(logOutButton.isEnabled()) {TutorMeFrame.dispose();; frame.setVisible(true);;  }
			}
		});
		
		if(Login.userType[Login.ID].equals("ADMIN") || Login.userType[Login.ID].equals("TUTOR")) { 
		JButton viewManagement = new JButton("Schedule Management");
		viewManagement.setBounds(10, 11, 212, 61);
		TutorMeFrame.getContentPane().add(viewManagement);
		viewManagement.setFocusPainted(false);
		viewManagement.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				advisorPanel();
			}
		});	
	}
		
		if(Login.apptUsedFlag[Login.ID]==1)
		{
			JOptionPane.showMessageDialog(null, "Your appointment has been accepted. Starting up a new window...");
			try {
	            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome http://localhost:8080/app2/Main/"});
	        } catch (Exception e) {

	        }		
			
			Login.apptUsedFlag[Login.ID]=0;
			
		}
		else if(Login.apptUsedFlag[Login.ID]==2)
		{
			JOptionPane.showMessageDialog(null, "Your appointment has been rejected. Please reschedule.");
			Login.apptUsedFlag[Login.ID]=0;
		}
		
		TutorMeFrame.setVisible(true);

	}
	 
	/*********************************************************** START OF THE FORGOT PASSWORD *****************************************************/

	void ForgotPassword() {

		JFrame forgotPassword = new JFrame();
		JTextField usernameField;
		JTextField emailField;
		forgotPassword.setBounds(100, 100, 550, 300);
		forgotPassword.setIconImage(Toolkit.getDefaultToolkit().getImage("tutorMeIcon.png"));
		forgotPassword.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		forgotPassword.getContentPane().setLayout(null);
		forgotPassword.setResizable(false);
		forgotPassword.setTitle("Forgot Password");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		forgotPassword.setLocation(dim.width/2-forgotPassword.getSize().width/2, dim.height/2-forgotPassword.getSize().height/2);
		
		
		JLabel msg1 = new JLabel("Forgot your password? We've got you covered.");
		msg1.setBounds(10, 23, 534, 14);
		forgotPassword.getContentPane().add(msg1);
		
		JLabel msg2 = new JLabel("Simply enter your username and your email and we will show you your password!");
		msg2.setBounds(10, 39, 534, 14);
		forgotPassword.getContentPane().add(msg2);
		
		JLabel msg3 = new JLabel("However, if you cannot remember your user name, press \"Email Support\" to contact us. ");
		msg3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		msg3.setBounds(10, 55, 534, 14);
		forgotPassword.getContentPane().add(msg3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 90, 524, 2);
		forgotPassword.getContentPane().add(separator);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(151, 121, 71, 14);
		forgotPassword.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Email:");
		lblNewLabel.setBounds(151, 149, 71, 14);
		forgotPassword.getContentPane().add(lblNewLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(227, 118, 139, 20);
		forgotPassword.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(227, 146, 139, 20);
		forgotPassword.getContentPane().add(emailField);
		
		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(227, 187, 89, 23);
		forgotPassword.getContentPane().add(submitButton);
		submitButton.setFocusPainted(false);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(227, 213, 89, 23);
		forgotPassword.getContentPane().add(loginButton);
		loginButton.setFocusPainted(false);
		
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if(loginButton.isEnabled()) {forgotPassword.dispose();  frame.setVisible(true);; usernameInput.setText(""); passwordField.setText("");}
			}
		});
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				Login.Database();
				String pID = usernameField.getText();
				String pEmail = emailField.getText();
				
				if (usernameField.getText().isEmpty() || emailField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Missing a field.");
				}
				
				else if (checkArrayID(credentialDatabase_username, pID)==false)
				{
					JOptionPane.showMessageDialog(null, "Unmatching credential.");
					Toolkit.getDefaultToolkit().beep();
				}
				else if (checkArrayID(credentialDatabase_username, pID)==true)
				{
					for(int i = 0; i<Login.email.length; i++)
					{
						if(Login.credentialDatabase_username[i].equals(pID.toLowerCase())) {
							if(Login.email[i].equals(pEmail))
							{
								JOptionPane.showMessageDialog(null, "Identity has been confirmed.\nYour password is " + "`"+Login.credentialDatabase_pwd[i] +"`."
																	+ "\nTo change your password, please hit the Email Dev button on your main panel.", "Verification Success", JOptionPane.INFORMATION_MESSAGE);
								usernameField.setText("");
								emailField.setText("");
							}
							else
							{
								JOptionPane.showMessageDialog(null, "Unmatching credential.");
							}
						}
					}
				}
			}

		});	
		forgotPassword.setVisible(true);

	}
	 
	/*********************************************************** START OF THE REGISTER USER PAGE*****************************************************/

	void Register() {

		JFrame registerUser = new JFrame();
		registerUser.setBounds(100, 100, 345, 484);
		registerUser.setIconImage(Toolkit.getDefaultToolkit().getImage("tutorMeIcon.png"));
		registerUser.setTitle("Register");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		registerUser.setLocation(dim.width/2-registerUser.getSize().width/2, dim.height/2-registerUser.getSize().height/2);
		registerUser.setResizable(false);
		registerUser.getContentPane().setLayout(null);
		registerUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblRegisteringIsFast = new JLabel("Registering is fast and easy.");
		lblRegisteringIsFast.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisteringIsFast.setBounds(0, 34, 339, 14);
		registerUser.getContentPane().add(lblRegisteringIsFast);
		
		JLabel registerUsername = new JLabel("Username:");
		registerUsername.setHorizontalAlignment(SwingConstants.CENTER);
		registerUsername.setBounds(26, 91, 102, 14);
		registerUser.getContentPane().add(registerUsername);
		
		registerUsernameField = new JTextField();
		registerUsernameField.setBounds(138, 85, 147, 20);
		registerUser.getContentPane().add(registerUsernameField);
		registerUsernameField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(26, 133, 102, 14);
		registerUser.getContentPane().add(lblPassword);
		
		registerPasswordField = new JPasswordField();
		registerPasswordField.setBounds(138, 127, 147, 20);
		registerUser.getContentPane().add(registerPasswordField);
		
		JLabel confirmPassword = new JLabel("Confirm Pass:");
		confirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		confirmPassword.setBounds(26, 171, 102, 14);
		registerUser.getContentPane().add(confirmPassword);
		
		confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(138, 165, 147, 20);
		registerUser.getContentPane().add(confirmPasswordField);
		
		JLabel registerPayment = new JLabel("Payment:");
		registerPayment.setHorizontalAlignment(SwingConstants.CENTER);
		registerPayment.setBounds(26, 212, 102, 14);
		registerUser.getContentPane().add(registerPayment);
		
		JComboBox<String> paymentComboBox = new JComboBox<String>();
		paymentComboBox.setBounds(138, 206, 147, 20);
		registerUser.getContentPane().add(paymentComboBox);
		
		JLabel registerEmail = new JLabel("Email:");
		registerEmail.setHorizontalAlignment(SwingConstants.CENTER);
		registerEmail.setBounds(26, 252, 102, 14);
		registerUser.getContentPane().add(registerEmail);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(138, 246, 147, 20);
		registerUser.getContentPane().add(emailField);
		
		JLabel registerMsg1 = new JLabel("Each tutoring session will cost you 50 credits. ");
		registerMsg1.setHorizontalAlignment(SwingConstants.CENTER);
		registerMsg1.setBounds(0, 293, 339, 14);
		registerUser.getContentPane().add(registerMsg1);
		
		JLabel registerMsg2 = new JLabel("You can top up your credits on the user page.");
		registerMsg2.setHorizontalAlignment(SwingConstants.CENTER);
		registerMsg2.setBounds(0, 311, 339, 14);
		registerUser.getContentPane().add(registerMsg2);
		
		JLabel registerMsg3 = new JLabel("You may also purchase a monthly subscription");
		registerMsg3.setHorizontalAlignment(SwingConstants.CENTER);
		registerMsg3.setBounds(0, 330, 339, 14);
		registerUser.getContentPane().add(registerMsg3);
		
		JLabel lblWhenInUse = new JLabel("in lieu of credits.");
		lblWhenInUse.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhenInUse.setBounds(0, 349, 339, 14);
		registerUser.getContentPane().add(lblWhenInUse);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(84, 394, 89, 23);
		registerUser.getContentPane().add(registerButton);
		registerButton.setFocusPainted(false);
		
		JButton cancelRegister = new JButton("Cancel");
		cancelRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registerUser.dispose();
				frame.setVisible(true);
			}
		});
		cancelRegister.setBounds(176, 394, 89, 23);
		registerUser.getContentPane().add(cancelRegister);
		cancelRegister.setFocusPainted(false);
		
		String[] paymentMethodString = new String[4];
		
		paymentMethodString[0]="VISA";
		paymentMethodString[1]="MASTER";
		paymentMethodString[2]="PAYPAL";
		paymentMethodString[3]="AMAZON";
		paymentComboBox.addItem(paymentMethodString[0]);
		paymentComboBox.addItem(paymentMethodString[1]);
		paymentComboBox.addItem(paymentMethodString[2]);
		paymentComboBox.addItem(paymentMethodString[3]);
		
		registerButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0; i<credentialDatabase_username.length; i++)
				{
					
					if(registerUsernameField.getText().isEmpty() || registerPasswordField.getText().isEmpty() || emailField.getText().isEmpty())
					{
						JOptionPane.showMessageDialog(null, "You must complete all fields before proceeding.");
						break;
					}
					else 
						{
						    String tempUsername = registerUsernameField.getText();
						    
						    if (tempUsername.toLowerCase().equals(credentialDatabase_username[i]))
						    {
						    	JOptionPane.showMessageDialog(null, "You cannot register as this username.\nTry again.");
								return;
						    }
						    
						    
						    if(accountEXISTS[i]!=true)
							{
								String getUsername = registerUsernameField.getText();
								String getPassword = registerPasswordField.getText();
								String getConfirmedPassword = confirmPasswordField.getText();
								String getEmail = emailField.getText();
								String getPayment = (String) paymentComboBox.getSelectedItem();
								
									credentialDatabase_username[i] = getUsername.toLowerCase();
									
									if(getPassword.equals(getConfirmedPassword))
									{
										credentialDatabase_pwd[i]= getPassword;
									}
									else
									{
										System.out.println(i);
										JOptionPane.showMessageDialog(null, "Confirmatory passwords do not match. Try again.");
										credentialDatabase_username[i]=null;
										credentialDatabase_pwd[i]=null;
										email[i]=null;
										break;
									}
									if(getEmail.contains("@") && (getEmail.contains(".com") ||getEmail.contains(".org") || getEmail.contains(".edu") || getEmail.contains(".net") || getEmail.contains(".gov") || getEmail.contains(".int") || getEmail.contains(".mil")))
									{
										email[i] = getEmail;
									}
									else
									{
										System.out.println(i);
										JOptionPane.showMessageDialog(null, "Not a valid email. Try again.");
										credentialDatabase_username[i]=null;
										credentialDatabase_pwd[i]=null;
										email[i]=null;
										break;
									}
									subscriptions[i]="NO";
									paymentMethod[i] = getPayment;
									credits[i] = 0;
									hasAppt[i] = false;
									date[i] = "";
									time[i] = "";
									problem[i] = "";
									accountEXISTS[i]=true;
									dateAndtime[i] = date[i]+ " " + time[i];
									userType[i] = "NORMAL";
									registerButton.setEnabled(false);
									cancelRegister.setText("Login");
									System.out.println(i);
									JOptionPane.showMessageDialog(null, "Registration successful! \nReturn to login page to login.");
									break;
								}
							}
						}
					}
				});
		registerUser.setVisible(true);
	}
	
	/*********************************************************** START OF THE TOP UP PAGE*****************************************************/

	void topUp() {

		JFrame topUpFrame = new JFrame();
		topUpFrame.setBounds(100, 100, 414, 283);
		topUpFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("tutorMeIcon.png"));
		topUpFrame.setTitle("Top Up Credits");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		topUpFrame.setLocation(dim.width/2-topUpFrame.getSize().width/2, dim.height/2-topUpFrame.getSize().height/2);
		topUpFrame.setResizable(false);
		topUpFrame.getContentPane().setLayout(null);
		topUpFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JLabel TopUpmsg1 = new JLabel("You currently have " + Login.credits[Login.ID] + " credits.");
		TopUpmsg1.setBounds(10, 26, 336, 14);
		topUpFrame.getContentPane().add(TopUpmsg1);
		
		JLabel topUpMsg2 = new JLabel();
		topUpMsg2.setBounds(10, 45, 388, 14);
		topUpFrame.getContentPane().add(topUpMsg2);
		
		JButton add50Credits = new JButton("+50 Credits");
		add50Credits.setBounds(10, 105, 116, 46);
		topUpFrame.getContentPane().add(add50Credits);
		add50Credits.setFocusPainted(false);
		
		JButton topUpCustom = new JButton("Custom");
		topUpCustom.setBounds(282, 105, 116, 46);
		topUpFrame.getContentPane().add(topUpCustom);
		topUpCustom.setFocusPainted(false);
		
		JButton add200Credits = new JButton("+200 Credits");
		add200Credits.setBounds(144, 105, 116, 46);
		topUpFrame.getContentPane().add(add200Credits);
		add200Credits.setFocusPainted(false);
		
		JLabel topUpMsg3 = new JLabel("* Per policy, every 50 credits will currently cost $" + rate + "/session.");
		topUpMsg3.setBounds(10, 70, 388, 14);
		topUpFrame.getContentPane().add(topUpMsg3);
		
		JLabel topUpMsg4 = new JLabel("Your method of payment: " + Login.paymentMethod[Login.ID]);
		topUpMsg4.setHorizontalAlignment(SwingConstants.CENTER);
		topUpMsg4.setBounds(10, 190, 388, 14);
		topUpFrame.getContentPane().add(topUpMsg4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 177, 388, 2);
		topUpFrame.getContentPane().add(separator);
		
		JLabel topUpMsg5 = new JLabel("Credits will be disbursed on real-time detection.");
		topUpMsg5.setHorizontalAlignment(SwingConstants.CENTER);
		topUpMsg5.setBounds(10, 204, 388, 14);
		topUpFrame.getContentPane().add(topUpMsg5);
		
		JLabel label = new JLabel("By purchasing, you agree to comply by our Terms and Conditions.");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(10, 218, 388, 14);
		topUpFrame.getContentPane().add(label);
		
		
		if(Login.credits[Login.ID]-50<0)
		{
			topUpMsg2.setText("You cannot start appointments or queue tutor due to low balance.");
		}
		else if (Login.credits[Login.ID]==50)
		{
			topUpMsg2.setText("Credits low on balance! You can choose to top up more credits here.");
		}
		else
		{
			topUpMsg2.setText("Sufficient credits are funded on your account.");
		}
		
		
		add50Credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "You are about to purchase 50 credits with a total payment of $" + (50/50)*10 + ".\nContinue?");
				if (result == JOptionPane.YES_OPTION)
				{
					Login.credits[Login.ID]=Login.credits[Login.ID]+50;
					JOptionPane.showMessageDialog(null, "50 credits have been added to your account.\nThank you!", "Success", JOptionPane.INFORMATION_MESSAGE);
					topUpFrame.dispose();
					TutorMe();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Transaction canceled.", "Topping Up Failure", JOptionPane.INFORMATION_MESSAGE);
					topUpFrame.dispose();
					TutorMe();
				}
			}
		});
		
		add200Credits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "You are about to purchase 200 credits with a total payment of $" + (200/50)*10 + ".\nContinue?");
			if (result == JOptionPane.YES_OPTION)
			{
				Login.credits[Login.ID]=Login.credits[Login.ID]+200;
				JOptionPane.showMessageDialog(null, "200 credits have been added to your account.\nThank you!", "Success", JOptionPane.INFORMATION_MESSAGE);
				topUpFrame.dispose();
				TutorMe();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Transaction canceled.", "Topping Up Failure", JOptionPane.INFORMATION_MESSAGE);
				topUpFrame.dispose();
				TutorMe();
			}
			}
		});
		
		topUpCustom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			double input = Double.parseDouble(JOptionPane.showInputDialog("How many credits?"));
			double resultValue = (input/50)*rate;
			int option = JOptionPane.showConfirmDialog(null, "You are about to purchase " + input +" credits with a total payment of $" + df.format(resultValue) + ".\nContinue?");
			if (option == JOptionPane.YES_OPTION)
			{
				Login.credits[Login.ID]=(double)(Login.credits[Login.ID]+input);
				JOptionPane.showMessageDialog(null, input + " credits have been added to your account.\nThank you!", "Success", JOptionPane.INFORMATION_MESSAGE);
				topUpFrame.dispose();
				TutorMe();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Transaction canceled.", "Topping Up Failure", JOptionPane.INFORMATION_MESSAGE);
				topUpFrame.dispose();	
				TutorMe();
			}
			}
		});
		
		topUpFrame.setVisible(true);	
	}
	
	/*********************************************************** START OF THE FAQ *****************************************************/
	
	void FAQ() {
		
		JOptionPane.showMessageDialog(null, "A file titled 'FAQ.txt' has been generated for you under the same path of directory in which this application is stored."
										+ "\nYou can see how this application works there. ");
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("FAQ.txt"));
			out.write("|-------------------------------------------------------------------|");
			out.newLine();
			out.write("|                 Welcome to TutorMe, a JAVA Distribution           |");
			out.newLine();
			out.write("| PROJECT BY JIANXIN ZHOU, MATT PADDOCK, STEVEN SZACHARA, RYAN BULL |");
			out.newLine();
			out.write("|-------------------------------------------------------------------|");
			out.newLine();
			out.newLine();
			out.write("PREFACE");
			out.newLine();
			out.write("\nTutorMe is a locally executable JAVA application that is designed specifically for the CIS 454 curruculum; Due to limiting time and resource constraints, some of the features laid out in the SRS documentations cannot be realistically achieved. As a result, for the purpose of this project, we will not be implementing the following scopes in this distribution:");
			out.newLine();
			out.write("\n1. A maintainable Database with Dynamic Access and Configurations");
			out.newLine();
			out.write("\n2. A server along side with some essential connection services (such as emails, notifications, etc.)");
			out.newLine();
			out.write("\n3. Functional Payment APIs");
			out.newLine();
			out.write("\n4. Live Recordings / Live \"Chegg-like\" Interfaces");
			out.newLine();
			out.write("\n5. Other features that may require time and investments");
			out.newLine();
			out.newLine();
			out.write("Q: Where is all my DATA?");
			out.newLine();
			out.write("A: A: All data is session based, and can be connected to a server by modifying the write/read to any database. We did not implement external database because this is a demo!");
			out.newLine();
			out.newLine();
			out.write("Q: Will there be a transaction feature?");
			out.newLine();
			out.write("A: There is a credit feature in the client - however, charges are superficial.");
			out.newLine();
			out.newLine();
			out.write("Q: Why can't I edit the boxes under 'Schedule Properties'?");
			out.newLine();
			out.write("A: Cancel your old appointment first before making new a one!");
			out.newLine();
			out.newLine();
			out.write("Q: Why does the client lead me to a chrome page?"); //NEW 
			out.newLine();
			out.write("A: It's a place holder for the LIVE tutoring. We wrote the program in JSP - integration is our next plan.");
			out.newLine();
			out.newLine();
			out.write("Q: What does the reset button do?"); //NEW 
			out.newLine();
			out.write("A: The reset button voids and defaults all of your data - it's solely used for testing");
			out.newLine();
			out.newLine();
			out.write("Q: Can I register multiple accounts?"); //NEW 
			out.newLine();
			out.write("A: Yes! As long as you don't close the program.");
			out.newLine();
			out.newLine();
			out.write("Q: The interface seemed to be split up into 2 different panels. What are functionalities of each?"); //NEW 
			out.newLine();
			out.write("A: A: The top panel is for ready-to-queue tutoring session. In case you don't want to wait, you can simply queue for a tutor and our next available tutor will get to you. The bottom one is for scheduling. Submit your request and our tutors will get back to you as they become available.");
			out.newLine();
			out.newLine();
			out.newLine();
			out.write("Got more questions? Contact me at jzhou104@syr.edu and I will happy to answer your inquiries.");
			
			
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/*********************************************************** START OF THE SUBSCRIPTION *****************************************************/
	
	void buySubscription() {
        JFrame subframe;
       
        subframe = new JFrame();
        subframe.setBounds(100, 100, 486, 178);
        subframe.setIconImage(Toolkit.getDefaultToolkit().getImage("tutorMeIcon.png"));
        subframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        JButton btnSubscribe = new JButton("Subscribe");
        btnSubscribe.setBounds(136, 84, 92, 42);
        btnSubscribe.setFocusPainted(false);
        subframe.getContentPane().setLayout(null);
        subframe.getContentPane().add(btnSubscribe);
       
        JLabel lblClickBelowTo = new JLabel("Click below to subscribe to a premium subscription of Tutor.Me.");
        lblClickBelowTo.setHorizontalAlignment(SwingConstants.CENTER);
        lblClickBelowTo.setBounds(10, 11, 460, 29);
        subframe.getContentPane().add(lblClickBelowTo);
       
        JLabel lblWithAPremium = new JLabel("With a premium subscription, you do not have to use credits.");
        lblWithAPremium.setHorizontalAlignment(SwingConstants.CENTER);
        lblWithAPremium.setBounds(10, 33, 460, 23);
        subframe.getContentPane().add(lblWithAPremium);
       
        JButton btnNewButton = new JButton("Cancel");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                subframe.dispose();
                TutorMe();
            }
        });
        btnNewButton.setBounds(238, 84, 92, 42);
        subframe.getContentPane().add(btnNewButton);
        btnNewButton.setFocusPainted(false);
        
        JLabel lblSubscriptionFee = new JLabel("Subscription Fee: 300 Credits");
        lblSubscriptionFee.setHorizontalAlignment(SwingConstants.CENTER);
        lblSubscriptionFee.setBounds(10, 51, 460, 23);
        
        subframe.getContentPane().add(lblSubscriptionFee);
        subframe.setResizable(false);
        subframe.setTitle("Purchase Subscriptions");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        subframe.setLocation(dim.width/2-subframe.getSize().width/2, dim.height/2-subframe.getSize().height/2);
        subframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
       
        btnSubscribe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if(Login.credits[Login.ID]-300<0)
            	{
            		JOptionPane.showMessageDialog(null, "You don't have enough credits to purchase a subscription!\nTop up your credits now!", "Failure", JOptionPane.INFORMATION_MESSAGE);
            	}
            	
            	else
            	{
            		JOptionPane.showMessageDialog(null, "You are now a subscriber.", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
                subscriptions[Login.ID] = "YES";
                Login.credits[Login.ID] = Login.credits[Login.ID]-300;
            	}
                subframe.dispose();
                TutorMe();
            }
        });
       
        subframe.setVisible(true);
    }
	
	
	/*********************************************************** START OF THE ADVISORPANEL *****************************************************/
	
	
	void advisorPanel() {
		JFrame TeacherFrame;
		int appointmentCount = 0;
		String[] appointmentCombination = new String[1000];

		TeacherFrame = new JFrame();
		TeacherFrame.setBounds(100, 100, 515, 403);
		TeacherFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("tutorMeIcon.png"));
		TeacherFrame.getContentPane().setLayout(null);
		TeacherFrame.setResizable(false);
		TeacherFrame.setTitle("Tutor.Me Advisory Control");
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		TeacherFrame.setLocation(dim.width/2-TeacherFrame.getSize().width/2, dim.height/2-TeacherFrame.getSize().height/2);
		//TeacherFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(130, 135, 144)), "Request Summary", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(30, 129, 457, 132);
		TeacherFrame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel usernameDisplayManagement = new JLabel();
		usernameDisplayManagement.setBounds(85, 23, 362, 14);
		panel.add(usernameDisplayManagement);
		
		JLabel problemLabelManagement = new JLabel("Problem:");
		problemLabelManagement.setBounds(10, 48, 69, 14);
		panel.add(problemLabelManagement);
		panel.setVisible(true);
		JScrollPane scroll = new JScrollPane();
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(85, 48, 362, 73);
		panel.add(scroll);
		JTextArea problemBoxManagement = new JTextArea();
		scroll.setViewportView(problemBoxManagement);
		problemBoxManagement.setWrapStyleWord(true);
		problemBoxManagement.setLineWrap(true);
		problemBoxManagement.setEnabled(false);
		
		
		JComboBox<String> apptComboBox = new JComboBox<String>();
		apptComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t = (String) apptComboBox.getSelectedItem();
				for (int i= 0; i<hasAppt.length; i++)
				{
					if (t.equals(dateAndtime[i]))
					{

						apptComboBox.setToolTipText(credentialDatabase_username[i]);
						panel.setToolTipText(problem[i]);
						usernameDisplayManagement.setText(apptComboBox.getToolTipText());
						problemBoxManagement.setText(panel.getToolTipText());
						
					}
				}
			}
		});
		apptComboBox.setBounds(31, 98, 265, 20);
		TeacherFrame.getContentPane().add(apptComboBox);
		

		
		for(int i= 0; i<hasAppt.length; i++)
		{
			if(hasAppt[i]==true && apptConfirmed[i]==false) //problematic code
			{
				++appointmentCount;
				appointmentCombination[i] = date[i] + " " + time[i];
				apptComboBox.addItem(appointmentCombination[i]);
				apptComboBox.setToolTipText(Login.credentialDatabase_username[i]);
				panel.setToolTipText(Login.problem[i]);
			}
			
		}
		
	
		
		
		JLabel TMsg1 = new JLabel("INBOUND: You currently have " + appointmentCount + " appointments requests.");
		TMsg1.setBounds(31, 31, 429, 14);
		TeacherFrame.getContentPane().add(TMsg1);
		
		JLabel managementLabel = new JLabel("Appointment Management");
		managementLabel.setBounds(31, 75, 429, 14);
		TeacherFrame.getContentPane().add(managementLabel);
	
		
		JButton acceptRequest = new JButton("Accept");
		acceptRequest.setBounds(306, 97, 89, 23);
		TeacherFrame.getContentPane().add(acceptRequest);
		acceptRequest.setFocusPainted(false);
		
		JButton rejectRequest = new JButton("Reject");
		rejectRequest.setBounds(398, 97, 89, 23);
		TeacherFrame.getContentPane().add(rejectRequest);
		
		JSeparator adSeparator1 = new JSeparator();
		adSeparator1.setBounds(10, 62, 489, 2);
		TeacherFrame.getContentPane().add(adSeparator1);
		
		JSeparator adSeparator2 = new JSeparator();
		adSeparator2.setBounds(10, 273, 489, 2);
		TeacherFrame.getContentPane().add(adSeparator2);
		
		JLabel lblAcceptedAppointments = new JLabel("Accepted Appointments:");
		lblAcceptedAppointments.setBounds(31, 286, 190, 14);
		TeacherFrame.getContentPane().add(lblAcceptedAppointments);
		
		JLabel lblperPolicyYou = new JLabel("(Appointment will dissapear once you take the session; assumed completion.)");
		lblperPolicyYou.setBounds(31, 301, 456, 14);
		TeacherFrame.getContentPane().add(lblperPolicyYou);
		
		JComboBox<String> confirmedApptcomboBox = new JComboBox<String>();
		confirmedApptcomboBox.setBounds(31, 326, 265, 20);
		TeacherFrame.getContentPane().add(confirmedApptcomboBox);
		
		for(int i= 0; i<hasAppt.length; i++)
		{
			if(hasAppt[i]==true && apptConfirmed[i]==true) //problematic code
			{
				appointmentCombination[i] = date[i] + " " + time[i];
				confirmedApptcomboBox.addItem(appointmentCombination[i]);
			}
			
			
		}
		
		
		acceptRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String tag = (String) apptComboBox.getSelectedItem();
				if(tag==(null))
				{
					JOptionPane.showMessageDialog(null, "No appointment to confirm!", "ERROR", JOptionPane.INFORMATION_MESSAGE);

				}
				else
				{
				for (int i = 0; i<hasAppt.length; i++)
				{
					if (tag.equals(dateAndtime[i]))
					{
						System.out.println(i);
						Login.apptConfirmed[i]=true;
					
					}
				}
				JOptionPane.showMessageDialog(null, "This appointment is now confirmed.\nUser will be notified.");
				TeacherFrame.dispose();
				advisorPanel();
				}
				}
				
		});
		
		
		rejectRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tag = (String) apptComboBox.getSelectedItem();
				if(tag==(null))
				{
					JOptionPane.showMessageDialog(null, "No appointment to reject!", "ERROR", JOptionPane.INFORMATION_MESSAGE);

				}
				else
				{
				JOptionPane.showMessageDialog(null, "This appointment is now dejected.\nUser will be notified.");
				for (int i = 0; i<hasAppt.length; i++)
				{
					if (tag.equals(dateAndtime[i]))
					{
						System.out.println(i);
						Login.hasAppt[i]=false;
						Login.apptConfirmed[i]=false;
						Login.dateAndtime[i]=null;
						Login.date[i]=null;
						Login.time[i]=null;
						Login.problem[i]=null;
						Login.apptUsedFlag[i]=2;
						break;
					}
				}
				TeacherFrame.dispose();
				advisorPanel();
				}
			}
		});
		
		JButton btnTakeSession = new JButton("Take Session");
		btnTakeSession.setFocusPainted(false);
		btnTakeSession.setBounds(306, 325, 181, 23);
		TeacherFrame.getContentPane().add(btnTakeSession);
		
		
		
		JLabel usernameLabelManagement = new JLabel("Username:");
		usernameLabelManagement.setBounds(10, 23, 69, 14);
		panel.add(usernameLabelManagement);
		
		
		btnTakeSession.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tag = (String) confirmedApptcomboBox.getSelectedItem();
				if(tag==(null))
				{
					JOptionPane.showMessageDialog(null, "No appointment to start tutoring with!", "ERROR", JOptionPane.INFORMATION_MESSAGE);

				}
				else
				{
				JOptionPane.showMessageDialog(null, "This appointment is now starting.\nUser will be notified.");
				
				try {
		            Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome http://localhost:8080/app2/Main/"});
		        } catch (Exception e1) {

		        }				
				for (int i = 0; i<hasAppt.length; i++)
				{
					if (tag.equals(dateAndtime[i]))
					{
						System.out.println(i);
						Login.hasAppt[i]=false;
						Login.apptUsedFlag[i]=1;
						break;
					}
				}
				TeacherFrame.dispose();
				advisorPanel();
				}
				
			}
		});
		
		
		
		
		
	
		
		
		
		
		TeacherFrame.setVisible(true);
		
	}
	

	private boolean checkArrayID(String[] arr, String item) {
		for (String n : arr)
		{
			if (item.equals(n))
			{
				return true;
			}
		}
		return false;
	}
}
