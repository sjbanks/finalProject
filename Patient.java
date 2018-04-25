package finalProject;

/**
 * @author Steven BANKS
 *This class allows the creation of a Patient object, that stores relevant information
 */
public class Patient {

	private String firstName;	//will store first name
	private String lastName;	//will store last name
	private int age;			//age of patient
	private String bloodType;	//A+-,B+-, AB, O+-
	private String condition;	//stable, unstable, critical, etc
	private String email;		//email of patient
	private boolean insured;	//yes or no for insurance
	
	/**
	 * default constructor
	 */
	public Patient() {
		firstName = "";
		lastName = "";
		age = 0;
		bloodType = "";
		condition = "";
		email = "";
		insured = false;
	}
	/**
	 * @param fName	first name
	 * @param lName	last name
	 * @param Age	age of patient
	 */
	public Patient(String fName, String lName, int Age) {
		firstName = fName;
		lastName = lName;
		age = Age;
	}
	/**
	 * @param fName	first name
	 * @param lName	last name
	 * @param Age	age of patient
	 * @param insurance if patient is insured or not
	 */
	public Patient(String fName, String lName, int Age, boolean insurance) {
		firstName = fName;
		lastName = lName;
		age = Age;
		insured = insurance;
	}
	/**
	 * @param fName		first name
	 * @param lName		last name
	 * @param Age		age of the patient
	 * @param blood		blood type
	 * @param Condition	condition of patient
	 * @param insurance	if the patient is insured
	 */
	public Patient(String fName, String lName, int Age, String blood, String Condition, boolean insurance) {
		firstName = fName;
		lastName = lName;
		age = Age;
		bloodType = blood;
		condition = Condition;
		insured = insurance;
	}
	/**
	 * @param fName		first name
	 * @param lName		last name
	 * @param Age		age of patient
	 * @param blood		blood type
	 * @param Condition condition of patient
	 * @param EMail		email of patient
	 * @param insurance	is patient insured
	 */
	public Patient(String fName, String lName, int Age, String blood, String Condition, String EMail, boolean insurance) {
		firstName = fName;
		lastName = lName;
		age = Age;
		bloodType = blood;
		condition = Condition;
		email = EMail;
		insured = insurance;
	}
	
	/**
	 * @return the firstName of the patient
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName set first name for patient
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName of the patient
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName set the last name of the patient
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the age of the patient
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age set the age of the patient
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the bloodType of the patient
	 */
	public String getBloodType() {
		return bloodType;
	}
	/**
	 * @param bloodType set the patient blood type
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	/**
	 * @return the condition of the patient
	 */
	public String getCondition() {
		return condition;
	}
	/**
	 * @param condition set the condition of the patient
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	/**
	 * @return the email of the patient
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email set the email for the patient
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return insured if the patient is insured
	 */
	public boolean isInsured() {
		return insured;
	}
	/**
	 * @param insured set if the patient is insured or not
	 */
	public void setInsured(boolean insured) {
		this.insured = insured;
	}
	
	/* a simple toString to print patient information
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ("Patient Information: " + "\nFirst Name: " + getFirstName()
				+ "\nLast Name: " + getLastName() + "\nAge: " + getAge()
				+ "\nBlood Type: " + getBloodType() + "\nCondition: " + getCondition()
				+ "\nE-Mail Address: " + getEmail() + "\nInsurance: " + isInsured()
				+ "\n----------------" + "\n");
	}
	
}
