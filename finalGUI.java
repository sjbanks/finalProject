package finalProject;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**This is my GUI file that creates the frame from which the program runs
 * @author Steven BANKS
 *
 */
public class finalGUI extends JFrame {

	//global variables for certain controls on the frame
	private JPanel contentPane;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAge;
	private JTextField txtBloodType;
	private JTextField txtCondition;
	private JTextField txtEmail;
	private JCheckBox chkInsured;
	private boolean insurance;
	private EmergencyRoom newER = new EmergencyRoom();		//create a new queue
	private EmergencyRoom ageSortedER = new EmergencyRoom(); //so that I don't lose the original sort order
	private EmergencyRoom nameSortedER = new EmergencyRoom(); //so I don't lose the original sort order
	//these are 'preset' patient objects that can be added automatically into the queue if need bes
	private Patient geralt = new Patient("Geralt", "Rivian", 65, "O-", "stable", "killingmonster@lodge.com", false);
	private Patient kara = new Patient("Kara", "Thrace", 25, "B+", "stable", "kthrace@BSG.com", true);
	private Patient lee = new Patient("Lee", "Adama", 27, "A-", "unstable", "leeloveskara@hotmail.com", true);
	private Patient harry = new Patient("Harry", "Potter", 38, "O+", "critical", "theboywholived@hogwarts.net", false);
	private Patient kayleigh = new Patient("Kayleigh", "Carington", 30,"B-", "unstable", "mechanicLove@serenity.com", false);
	private Patient stephen = new Patient("Stephen", "King", 63, "B-", "stable", "masterOfHorror@King.com", true);
	private Patient al = new Patient("Weird", "Al", 55, "AB+", "unstable", "polkapolkapolka@weird.com", true);
	private Patient zol = new Patient("Richard", "Zolnosky", 82, "A+", "critical", "rzol@gmail.com", true);
	private Patient herbert = new Patient("Herbert", "Devin", 20, "B+", "stable", "herb2000@hotmail.com", false);
	private Patient vader = new Patient("Darth", "Vader", 34, "B-", "unstable", "cometothedarkside@empire.com", false);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finalGUI frame = new finalGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public finalGUI() {
		startProgram();	//call a private method to put stuff on my frame
		//EmergencyRoom newER = new EmergencyRoom();	//make a new queue upon starting the program
	}
	
	/**
	 * This initializes all the components I will need on my frame
	 */
	private void startProgram() {
		
		setTitle("Emergency Room Waiting List");		//Title of the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//make sure to close when you hit the exit button
		setBounds(100, 100, 450, 365);					//drag and drop!
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		//I'm gonna be honest, this doesn't mean a whole lot to me
		//This code was automatically generated from windowBuilder
		JLabel lblEnterPatientInformation = new JLabel("Enter Patient Information Below:");
		lblEnterPatientInformation.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblEnterPatientInformation = new GridBagConstraints();
		gbc_lblEnterPatientInformation.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEnterPatientInformation.insets = new Insets(0, 0, 5, 5);
		gbc_lblEnterPatientInformation.gridx = 0;
		gbc_lblEnterPatientInformation.gridy = 0;
		contentPane.add(lblEnterPatientInformation, gbc_lblEnterPatientInformation);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.WEST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 1;
		contentPane.add(lblFirstName, gbc_lblFirstName);
		
		txtFirstName = new JTextField();
		GridBagConstraints gbc_txtFirstName = new GridBagConstraints();
		gbc_txtFirstName.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstName.gridx = 1;
		gbc_txtFirstName.gridy = 1;
		contentPane.add(txtFirstName, gbc_txtFirstName);
		txtFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.WEST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 2;
		contentPane.add(lblLastName, gbc_lblLastName);
		
		txtLastName = new JTextField();
		GridBagConstraints gbc_txtLastName = new GridBagConstraints();
		gbc_txtLastName.insets = new Insets(0, 0, 5, 0);
		gbc_txtLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLastName.gridx = 1;
		gbc_txtLastName.gridy = 2;
		contentPane.add(txtLastName, gbc_txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.WEST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 0;
		gbc_lblAge.gridy = 3;
		contentPane.add(lblAge, gbc_lblAge);
		
		txtAge = new JTextField();
		GridBagConstraints gbc_txtAge = new GridBagConstraints();
		gbc_txtAge.insets = new Insets(0, 0, 5, 0);
		gbc_txtAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAge.gridx = 1;
		gbc_txtAge.gridy = 3;
		contentPane.add(txtAge, gbc_txtAge);
		txtAge.setColumns(10);
		
		JLabel lblBloodType = new JLabel("Blood Type:");
		GridBagConstraints gbc_lblBloodType = new GridBagConstraints();
		gbc_lblBloodType.anchor = GridBagConstraints.WEST;
		gbc_lblBloodType.insets = new Insets(0, 0, 5, 5);
		gbc_lblBloodType.gridx = 0;
		gbc_lblBloodType.gridy = 4;
		contentPane.add(lblBloodType, gbc_lblBloodType);
		
		txtBloodType = new JTextField();
		GridBagConstraints gbc_txtBloodType = new GridBagConstraints();
		gbc_txtBloodType.insets = new Insets(0, 0, 5, 0);
		gbc_txtBloodType.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBloodType.gridx = 1;
		gbc_txtBloodType.gridy = 4;
		contentPane.add(txtBloodType, gbc_txtBloodType);
		txtBloodType.setColumns(10);
		
		JLabel lblCondition = new JLabel("Condition:");
		GridBagConstraints gbc_lblCondition = new GridBagConstraints();
		gbc_lblCondition.anchor = GridBagConstraints.WEST;
		gbc_lblCondition.insets = new Insets(0, 0, 5, 5);
		gbc_lblCondition.gridx = 0;
		gbc_lblCondition.gridy = 5;
		contentPane.add(lblCondition, gbc_lblCondition);
		
		txtCondition = new JTextField();
		GridBagConstraints gbc_txtCondition = new GridBagConstraints();
		gbc_txtCondition.insets = new Insets(0, 0, 5, 0);
		gbc_txtCondition.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCondition.gridx = 1;
		gbc_txtCondition.gridy = 5;
		contentPane.add(txtCondition, gbc_txtCondition);
		txtCondition.setColumns(10);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.WEST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		contentPane.add(lblEmail, gbc_lblEmail);
		
		txtEmail = new JTextField();
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 1;
		gbc_txtEmail.gridy = 6;
		contentPane.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblInsurance = new JLabel("Insurance (check for yes)");
		GridBagConstraints gbc_lblInsurance = new GridBagConstraints();
		gbc_lblInsurance.anchor = GridBagConstraints.WEST;
		gbc_lblInsurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsurance.gridx = 0;
		gbc_lblInsurance.gridy = 7;
		contentPane.add(lblInsurance, gbc_lblInsurance);
		
		chkInsured = new JCheckBox("");
		GridBagConstraints gbc_chkInsured = new GridBagConstraints();
		gbc_chkInsured.anchor = GridBagConstraints.WEST;
		gbc_chkInsured.insets = new Insets(0, 0, 5, 0);
		gbc_chkInsured.gridx = 1;
		gbc_chkInsured.gridy = 7;
		contentPane.add(chkInsured, gbc_chkInsured);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {			//what happens when submit is clicked
			public void actionPerformed(ActionEvent arg0) {
				
				//declare local, temporary variables to grab user entered information
				String fName = txtFirstName.getText();
				String lName = txtLastName.getText();
				String tempAge = txtAge.getText();
				int age = Integer.parseInt(tempAge);	//make sure to grab an int value from that string
				String blood = txtBloodType.getText();
				String condition = txtCondition.getText();
				String email = txtEmail.getText();
				
				if (chkInsured.isSelected()) {				//check if insurance is selected
					insurance = true;						//if yes, set the value to true
				}
				else {										//if no
					insurance = false;						//set to false
				}
				
				Patient newPatient = new Patient(fName, lName, age, blood, condition, email, insurance);	//create a new patient with the user information
				newER.submit(newPatient);	//Add the new patient to the wait list
				JOptionPane.showMessageDialog(null, lName + ", " + fName + " added to the waitlist");	//confirmation that patient was added
				
				txtFirstName.setText("");			//I found these all on my own, after putting the period after the variable
				txtLastName.setText("");
				txtAge.setText("");
				txtBloodType.setText("");
				txtCondition.setText("");
				txtEmail.setText("");
				
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btnSubmit.gridx = 0;
		gbc_btnSubmit.gridy = 8;
		contentPane.add(btnSubmit, gbc_btnSubmit);
		
		JButton btnShowWaitList = new JButton("Show Wait List");
		btnShowWaitList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newER.waitList();	//this prints the wait list when the button is clicked
			}
		});
		
		JButton btnAutoFill = new JButton("Auto Fill (10)");
		btnAutoFill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//add all of the premade patient objects to the queue
				newER.submit(geralt);
				newER.submit(kara);
				newER.submit(al);
				newER.submit(harry);
				newER.submit(herbert);
				newER.submit(kayleigh);
				newER.submit(lee);
				newER.submit(stephen);
				newER.submit(vader);
				newER.submit(zol);
				//these are a big large, but can use the X at the top right just fine
				JOptionPane.showMessageDialog(null, "Added " + geralt.toString() + kara.toString() + al.toString() + harry.toString() + herbert.toString());
				JOptionPane.showMessageDialog(null, "Added " + kayleigh.toString() + lee.toString() + stephen.toString() + vader.toString() + zol.toString());
			}
		});
		GridBagConstraints gbc_btnAutoFill = new GridBagConstraints();
		gbc_btnAutoFill.insets = new Insets(0, 0, 5, 0);
		gbc_btnAutoFill.gridx = 1;
		gbc_btnAutoFill.gridy = 8;
		contentPane.add(btnAutoFill, gbc_btnAutoFill);
		GridBagConstraints gbc_btnShowWaitList = new GridBagConstraints();
		gbc_btnShowWaitList.insets = new Insets(0, 0, 5, 5);
		gbc_btnShowWaitList.gridx = 0;
		gbc_btnShowWaitList.gridy = 9;
		contentPane.add(btnShowWaitList, gbc_btnShowWaitList);
		
		JButton btnSortByLast = new JButton("Sort by Last Name");
		btnSortByLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameSortedER = newER;				//update new queue with patients
				nameSortedER.sortByAlpha();			//Sort by last name, A-Z
			}
		});
		GridBagConstraints gbc_btnSortByLast = new GridBagConstraints();
		gbc_btnSortByLast.insets = new Insets(0, 0, 5, 0);
		gbc_btnSortByLast.gridx = 1;
		gbc_btnSortByLast.gridy = 9;
		contentPane.add(btnSortByLast, gbc_btnSortByLast);
		
		JButton btnSortByAge = new JButton("Sort by Age");
		btnSortByAge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ageSortedER = newER;					//update new queue with patients
				ageSortedER.sortByAge(); 				//Sort by age
			}
		});
		GridBagConstraints gbc_btnSortByAge = new GridBagConstraints();
		gbc_btnSortByAge.insets = new Insets(0, 0, 5, 5);
		gbc_btnSortByAge.gridx = 0;
		gbc_btnSortByAge.gridy = 10;
		contentPane.add(btnSortByAge, gbc_btnSortByAge);
		
		JButton btnShowInsured = new JButton("Show Insured");
		btnShowInsured.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newER.insuredPatients();					//display only the insured patients
			}
		});
		GridBagConstraints gbc_btnShowInsured = new GridBagConstraints();
		gbc_btnShowInsured.insets = new Insets(0, 0, 5, 0);
		gbc_btnShowInsured.gridx = 1;
		gbc_btnShowInsured.gridy = 10;
		contentPane.add(btnShowInsured, gbc_btnShowInsured);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newER.removePatient();						//remove the first patient  in the queue
			}
		});
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.insets = new Insets(0, 0, 0, 5);
		gbc_btnRemove.gridx = 0;
		gbc_btnRemove.gridy = 11;
		contentPane.add(btnRemove, gbc_btnRemove);
		
		JButton btnWaitTime = new JButton("Wait Time");
		btnWaitTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newER.showCounter();	//prints wait time and wait list size
			}
		});
		GridBagConstraints gbc_btnWaitTime = new GridBagConstraints();
		gbc_btnWaitTime.gridx = 1;
		gbc_btnWaitTime.gridy = 11;
		contentPane.add(btnWaitTime, gbc_btnWaitTime);
		
	}

}
