/** Represents a Linked List that holds Patients.
 * @author Gabriel Oliveira
 * @author Carina Lins
 * @version 1.0
*/
public class LinkedList implements LinkedListInterface {
	
	/** The head. */
	Patient head;

	/** The length. */
	Integer length = 0;

	/**
	 * @see LinkedListInterface#push(Patient)
	 */
	public void push(Patient patient) {
		//Holds the patient to be added to the top of the list
		Patient new_patient = patient;
		//Sets the top of the list as next of the new patient (pushes the head to the next position)
		new_patient.next = head;
		//Sets the head as the new patient
		head = new_patient;
		//Increments the length of the list
		length++;
	}

	/**
	 * @see LinkedListInterface#delete(Patient)
	 */
	public void delete(Patient patient) {
		//Holds the head
		Patient temp_patient = head;
		Patient prev = null;

		// If head is the patient to be deleted
		if (temp_patient == patient) {
			//Sets the head as the next property of head (second in the list)
			head = temp_patient.next; // Changed head
			// decrements the length of the linked list
			length--;
			//stops execution
			return;
		}

		// Search for the patient to be deleted
		// until temp_patient is null and not equal to patient
		while (temp_patient != null && temp_patient != patient) {
			//sets the node before the current to temp_patient
			prev = temp_patient;
			//sets temp_patient to the next of itself
			temp_patient = temp_patient.next;
		}

		// If patient not present in the list
		if (temp_patient == null) {
			//stops execution
			return;
		}

		// Unlink the patient to be deleted
		prev.next = temp_patient.next;
		// decrements the length of the linked list
		length--;
	}

	/**
	 * @see LinkedListInterface#delete(int)
	 */
	public void delete(int position) {
		//If position is a negative number or higher than the length of the linked list
		if (position < 0 || position > length - 1) {
			//Throws an exception
			throw new IndexOutOfBoundsException(Integer.toString(position));
		}
		//If there are no patients in the linked list
		if (head == null) {
			//stops the exectution
			return;
		}

		// Holds head patient
		Patient temp_patient = head;

		// IF patient at the head needs to be removed
		if (position == 0) {
			// sets the head to be the next of head
			head = temp_patient.next; 
			// decrements the length of the linked list
			length--;
			// stops the execution
			return;
		}

		// Finds the patient before the patient to be deleted
		for (int i = 0; temp_patient != null && i < position - 1; i++) {
			// sets it to temp_patient
			temp_patient = temp_patient.next;
		}

		// If position is more than number of ndoes
		if (temp_patient == null || temp_patient.next == null) {
			return;
		}
		
		// Sets next variable to be the next of the next of the temp_patient
		Patient next = temp_patient.next.next;
		// temp_patient next is set to be next
		temp_patient.next = next; // Unlink the deleted node from list
		// decrements the length
		length--;
	}
	
	/**
	 * @see LinkedListInterface#deleteLastN(int)
	 */
	public void deleteLastN(int count) {
		//If position is a negative number or higher than the length of the linked list
		if (count < 0 || count > length) {
			System.out.println("Value is higher than lenght of the list");
			//stops the execution
			return;
		}
		
		// if head is null there is no patients in the list
		if (head == null) {
			// stops the execution
			return;
		}
		
		// sets a l variable to keep the original length of the list
		int l = length;

		// while list is longer the the desired lenght after deletion
		// invoke delete informing the last position of the list
		while(length > l - count) {

			delete(length -1);
		}

	}

	/**
	 * @see LinkedListInterface#append(Patient)
	 */
	/* (non-Javadoc)
	 * 
	 */
	public void append(Patient new_patient) {
		// if head is not set
		// sets the new patient as head
		// increments the length of the linked list
		if (head == null) {
			head = new_patient;
			length++;
			return;
		}

		// Patient is the last of the list
		// sets its next to null
		new_patient.next = null;

		// sets last to be the head
		Patient last = head;

		// finds the current last patient
		// if last has next
		// sets last to be its next
		// continues until last is null
		while (last.next != null) {
			last = last.next;
		}
		
		// sets the current last next to be the new last
		last.next = new_patient;
		// increments the length of the linked list
		length++;
	}

	/**
	 * @see LinkedListInterface#insertAt(java.lang.Integer, Patient)
	 */
	public void insertAt(Integer position, Patient patient) {
		//If position is a negative number or higher than the length of the linked list
		// throws an error
		if (position < 0 || position > length) {
			throw new IndexOutOfBoundsException(Integer.toString(position));
		}
		
		// if insertion happens to be at the head
		// invokes push
		// else
		// gets the patient at the given position
		// and insert new patient after that position
		if (position == 0) {
			push(patient);
		} else {
			Patient prev_patient = getPatient(position - 1);
			insertAfter(prev_patient, patient);
		}

	}
	
	/**
	 * @see LinkedListInterface#getPatientById(int)
	 */
	public Patient getPatientById(int id){
		// if there are no patients in the list
		// stops the execution
		// returns null
		if(length == 0) {
			return null;
		}
		
		// sets current_patient to be head
		Patient current_patient = head;

		// traverses the linked list based on length
		// checks for every patient if its id is equal to given id
		// returns patient if so
		// else assign the current patient to next
		// continues traversing
		for (int i = 0; i < length && current_patient != null; i++) {
			if(current_patient.getPID() == id) {
				return current_patient;
			}
			current_patient = current_patient.next;
		}
		
		// no patient was found by the given id
		// returns null
		return null;
	}
	
	/**
	 * @see LinkedListInterface#getPatientPositionById(int)
	 */
	/* (non-Javadoc)
	 * 
	 */
	public int getPatientPositionById(int id){
		// if there are no patients in the list
		// stops the execution
		// returns null
		if(length == 0) {
			return 0;
		}
		
		// sets current_patient to be head
		Patient current_patient = head;

		// traverses the linked list based on length
		// checks for every patient if its id is equal to given id
		// returns patient id if so
		// else assign the current patient to next
		// continues traversing
		for (int i = 0; i < length && current_patient != null; i++) {
			if(current_patient.getPID() == id) {
				return i;
			}
			current_patient = current_patient.next;
		}
		
		// no patient was found by the given id
		// returns null
		return 0;
	}

	/**
	 * @see LinkedListInterface#getPatient(int)
	 */
	public Patient getPatient(int position) {
		// sets current patient to be head
		Patient current_patient = head;
		// traverses linked list based on position
		// starts from 0 to positon
		// until i >= position and current_patient is not null
		// sets current patient to be next
		// continues traversing
		for (int i = 0; i < position && current_patient != null; i++) {
			current_patient = current_patient.next;
		}
		return current_patient;
	}

	/**
	 * @see LinkedListInterface#insertAfter(Patient, Patient)
	 */
	public void insertAfter(Patient prev_patient, Patient new_patient) {
		// if prev_patient is null
		// throws an exception
		if (prev_patient == null) {
			throw new NullPointerException("prev_patient must not be null");
		}
		// if new_patient is null
		// throws an exception
		if (new_patient == null) {
			throw new NullPointerException("new_patient must not be null");
		}
		
		// sets the new_patient next to be the previous patient next
		// inserting after previous_patient
		new_patient.next = prev_patient.next;

		// set the prev_patient next to be the newly inserted patient
		prev_patient.next = new_patient;
		
		// increments the length of the linked list
		length++;
	}

	/**
	 * Prints the list.
	 */
	public void printList() {
		Patient n = head;
		if(n == null) {
			System.out.println("No patients added");
		}
		
		int counter = 0;
		
		String leftAlignFormat = "| %-9d | %-9d | %-28s | %-9s | %-18s | %-35s | %-18s |%n";
		System.out.println();
		System.out.println("====================================================================================================================================================");
		System.out.println();
		System.out.format("|------------------------------------------------------------------ Patient List ------------------------------------------------------------------|%n");
		System.out.format("| ID        | Position  | Name                         | PPS       | Phone Number       | Email                               | City                %n");
		System.out.format("+-----------+-----------+------------------------------+-----------+--------------------+-------------------------------------+--------------------|%n");

		while (n != null) {
			System.out.printf(leftAlignFormat, n.getPID(), counter++ + 1, n.getFirstName() + " " + n.getLastName(), n.getPps(), n.getPhoneNumber(), n.getEmail(), n.getCity());
			n = n.next;
		}
	}
}
