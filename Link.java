package finalProject;

/**
 * @author Steven BANKS
 *The link for my linked list queue of my final project
 */
public class Link {

	public Patient patient;	
	public Link next;
	
	public Link(Patient newPatient) {
		patient = newPatient;	//hold the patient object in the link
	}

	/**
	 * @return the next
	 */
	public Link getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(Link next) {
		this.next = next;
	}
	
	/**
	 * Displays patients name by LastName, FirstName
	 */
	public void displayName() {
		System.out.println(patient.getLastName() + ", " + patient.getFirstName());
	}
	/**
	 * Displays all of the patient information
	 */
	public void displayLink() {
		System.out.println(patient.toString());
	}
}
