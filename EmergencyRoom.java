package finalProject;

/**
 * @author Steven BANKS
 *this is my queue class for my project. It is the waiting room list for an Emergency Room at a hospital
 */
public class EmergencyRoom {
	
	private Link first;
	private int counter;
	private final int CAPACITY = 15;
	
	public EmergencyRoom() {
		newQueue();
	}
	
	/**
	 * @return true is the queue is empty
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	/**
	 * @return true if the queue is full
	 */
	public boolean isFull() {
		return (counter == CAPACITY);
	}
	/**
	 * @param patient take a patient object and adds them to the queue
	 */
	public void submit(Patient patient) {
		add(patient);
	}
	/**
	 * @return removes the first patient in line, and prints the patient name
	 */
	public Link removePatient() {
		return remove();
	}
	/**
	 * prints the information for each patient in the waitlist
	 */
	public void waitList() {
		print();
	}
	/**
	 * prints only those patients with insurance
	 */
	public void insuredPatients() {
		printInsured();
	}
	public void showCounter() {
		displayCounter();
	}
	public void sortByAlpha() {
		alphaSort();
	}
	public void sortByAge() {
		ageSort();
	}
	
	private void newQueue() {
		first = null;
		counter = 0;
	}
	/**
	 * @param patient takes a patient object and adds it to the queue
	 */
	private void add(Patient patient) {
		if (!isEmpty()) {						//if queue is not empty
			if(!isFull()) {
				Link newLink = new Link(patient);	//create a new link that takes the patient object
				Link current = first;				//set Link current to the first value
				while (current.next != null) {		//until you get to the last link
					current = current.next;			//continue through list
				}
				current.next = newLink;				//when found the last link, set the next link to the new patient
				newLink.next = null;				//set the end of the queue to null
				counter++;							//keep track of how many patients are on the list
			}
			else {
				System.out.println("Wait list is full.");	//time to remove a patient from the list										
			}
		}
		else {									//if queue is empty
			Link newLink = new Link(patient);	//create new link with the patient object
			newLink.next = first;				//update reference
			first = newLink;					//set patient to first in line
			counter++;							//keep track of how many patients are on waitlist
		}
	}
	/**
	 * @return either the value removed or null if empty
	 */
	private Link remove() {
		if (!isEmpty()) {	//if the queue is not empty
			Link temp = first; //set temp equal to the first value
			first = first.next; //update the first value in the queue
			System.out.print("This patient was seen by a doctor: "); //print the name of the patient removed from the queue
			temp.displayName();
			counter--; //keep track of how many patients are in the queue
			return temp;
		}
		else {
			System.out.println("The waitlist is empty, everyone has been seen by a doctor."); //if queue is empty, tell user
			return null;
		}
		
	}
	/**
	 * private method called by public method to print the patients on the wait list
	 */
	private void print() {
		System.out.println("\nEmergency Room Waitlist: ");	//make sure the user sees what you're doing
		Link current = first;								//start at the first value
		if (!isEmpty()) {									//if the queue is not empty	
			while (current != null) {						//loop until the last patient
				System.out.println(current.patient.toString());	//calls the toString() for the patient
				current = current.next;						//go to the next person in line
			}
		}
		else {
			System.out.println("The wailist is empty.");
		}
	}
	/**
	 * prints only those patients that are insured
	 */
	private void printInsured() {
		Link current = first;						//start at the first patient
		if (!isEmpty()) {							//if waitlist is not empty
			while (current.next != null){			//loop until the last patient
				if (current.patient.isInsured()) {	//check if the patient held in the current link is insured
					current.displayLink();			//if they are, print that patient
				}
				current = current.next;				//move on to the next patient
			}
		}
		else {
			System.out.println("The waitlist is empty.");
		}
	}
	/**
	 * simple method to display how many patients are on the waitlist
	 */
	private void displayCounter() {
		System.out.println("\nThere are currently: " + counter + " patients on the wait list."); //I like starting it on a new line
	}
	/**
	 * sorting algorithm to sort the list from youngest to oldest
	 */
	private void ageSort() {
		System.out.println("\nSorting list by age of patient: ");	//keep the user informed as to what is happening
		Link current = first;	//temporary current value
		Link tail = null;		//temporary tail value
		
		while (current != null && tail != first) {								//start a while loop that iterates through the whole list
			Link pointer = current;												//temporary pointer value
			for (; pointer.next != tail; pointer = pointer.next) {				//nested for loop that moves pointer ahead
				if (pointer.patient.getAge() > pointer.next.patient.getAge()) {	//if patient's age is less than the next patient's age
					Patient temp = pointer.patient;								//create a temp patient to hold pointer's info
					pointer.patient = pointer.next.patient;						//copy pointer info to next patient
					pointer.next.patient = temp;								//set next patient to temp patient
				}
			}
			tail = pointer;	//set tail to the end of queue
			current = first; //current back to first
		}
		while (current != null) {	//iterate through the sorted queue
			System.out.println(current.patient.toString());
			current = current.next;
		}
	}
	/**This method uses an insertion sort algorithm to sort the queue
	 * alphabetically by last name from A to Z
	 */
	private void alphaSort() {
		System.out.println("Sorting list alphabetically: ");	//Just to show on the console what's happening
		Link current = first;	//create a temporary current value equal to the first value
		Link tail = null;		//create a temporary tail value equal to null
		
		while (current != null && tail != first) {	//start a while loop that goes until current is null and tail is first			
			Link pointer = current;																		//create a pointer link that can reference ahead
			for (; pointer.next != tail; pointer = pointer.next) {										//nested for loop that moves pointer ahead
				if (pointer.patient.getLastName().compareTo(pointer.next.patient.getLastName()) > 0){	//if pointer's last name comes after pointer.next's last name	
					Patient temp = pointer.patient;														//create a temp patient to hold pointer info
					pointer.patient = pointer.next.patient;												//copy pointer info to next patient	
					pointer.next.patient = temp;														//set next patient to temp info
				}
			}
			tail = pointer;	//set tail equal to pointer, which is pointing to the end of the queue
			current = first;	//set current to the first value again
		}
		while (current != null) {																		//iterate through entire queue
			System.out.println(current.patient.toString());												//print patient info
			current = current.next;																		//move current ahead one spot in queue
		}
		//Messy, I know, but I was first sorting alphabetically the other direction, and then trying to print it in reverse. 
		//sheesh I'm glad I went back and fixed this!!! leaving it for giggles
		/**Link newCurrent = first;
		Link newTail = tail;
		while (newCurrent.next != null) {
			newCurrent = newCurrent.next;
		}
		newTail = newCurrent;
		newCurrent = first;
		for (int i = 1; i < size; i++) {
			System.out.println(newTail.name);
			while (newCurrent.next != newTail) {
				newCurrent = newCurrent.next;
			}
			newTail = newCurrent;
			newCurrent = first;
		}
		System.out.println(first.name);*/
		
	}
}
