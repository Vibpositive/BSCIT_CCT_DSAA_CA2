// A simple Java program to introduce a linked list 
class LinkedList {
	Patient head; // head of list
	Patient tail; // tail of list
	
	Integer length = 0;

	/* method to create a simple linked list with 3 nodes */
	/*public static void main(String[] args) {

		LinkedList llist = new LinkedList();

		Patient first = new Patient("pps1", "first", "ln1", "pn1", "em1", "city1");
		Patient second = new Patient("pps2", "second", "ln2", "pn2", "em2", "city2");
		Patient third = new Patient("pps3", "third", "ln3", "pn3", "em3", "city3");
		Patient fourth = new Patient("pps4", "fourth", "ln4", "pn4", "em4", "city4");

		
//		  llist.head.next = second; second.next = third; /
		 

		llist.append(first);
		llist.append(second);
		llist.append(third);
		llist.append(fourth);
//		llist.insertAt(1, fourth);

//		llist.delete(second);
//		System.out.println();
//		llist.printList();
//		System.out.println();
//		System.out.println(llist.getPatient(2));

//		llist.printList();
		
		llist.printList();
		llist.delete(0);
		System.out.println();
		llist.printList();
	}
	/**/

	/*
	 * This function is in LinkedList class. Inserts a new Node at front of the
	 * list. This method is defined inside LinkedList class shown above
	 */
	public void push(Patient patient) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Patient new_patient = patient;

		/* 3. Make next of new Node as head */
		new_patient.next = head;

		/* 4. Move the head to point to new Node */
		head = new_patient;
		length++;
	}

	/* Given a key, deletes the first occurrence of key in linked list */
	void delete(Patient patient) {
		// Store head node
		Patient temp_patient = head;
		Patient prev = null;

		// If head node itself holds the key to be deleted
		// if (temp_patient += null)
		if (temp_patient == patient) {
			head = temp_patient.next; // Changed head
			length--;
			return;
		}

		// Search for the key to be deleted, keep track of the
		// previous node as we need to change temp.next
		while (temp_patient != null && temp_patient != patient) {
			prev = temp_patient;
			temp_patient = temp_patient.next;
		}

		// If key was not present in linked list
		if (temp_patient == null) {
			return;
		}

		// Unlink the node from linked list
		prev.next = temp_patient.next;
		length--;
	}

	/*
	 * Given a reference (pointer to pointer) to the head of a list and a position,
	 * deletes the node at the given position
	 */
	public void delete(int position) {

		if (position < 0 || position > length - 1) {
			throw new IndexOutOfBoundsException(Integer.toString(position));
		}
		
		if (head == null) {
			return;
		}

		// Store head node
		Patient temp_patient = head;

		// If head needs to be removed
		if (position == 0) {
			// Change head
			head = temp_patient.next; 
			length--;
			return;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp_patient != null && i < position - 1; i++) {
			temp_patient = temp_patient.next;
			System.out.println("Previous node: " + temp_patient);
		}

		// If position is more than number of ndoes
		if (temp_patient == null || temp_patient.next == null) {
			return;
		}
		
		// Node temp->next is the node to be deleted
		// Store pointer to the next of node to be deleted
		Patient next = temp_patient.next.next;

		temp_patient.next = next; // Unlink the deleted node from list
		length--;
	}
	
	public void deleteLastN(int count) {
		
		int l = length;

		while(length > l - count) {
			delete(length -1);
		}

	}

	public void append(Patient new_patient) {
		/*
		 * 1. Allocate the Node & 2. Put in the data 3. Set next as null
		 */
		// Node new_node = new Node(new_data);

		/*
		 * 4. If the Linked List is empty, then make the new node as head
		 */
		if (head == null) {
			head = new_patient;
			length++;
			return;
		}

		/*
		 * 4. This new node is going to be the last node, so make next of it as null
		 */
		new_patient.next = null;

		/* 5. Else traverse till the last node */
		Patient last = head;

		while (last.next != null) {
			last = last.next;
		}

		/* 6. Change the next of last node */
		last.next = new_patient;
		length++;
	}

	public void insertAt(Integer position, Patient new_patient) {
		if (position < 0 || position > length) {
			throw new IndexOutOfBoundsException(Integer.toString(position));
		}

		if (position == 0) {
			push(new_patient);
		} else {
			Patient prev_patient = getPatient(position - 1);
			insertAfter(prev_patient, new_patient);
		}

//		return n;
	}
	
	public Patient getPatientById(int id){
		
		if(length == 0) {
			return null;
		}
		
		Patient current_patient = head;
		if(current_patient.getPID() == id) {
			return current_patient;
		}
		
		for (int i = 0; i < length && current_patient != null; i++) {
			if(current_patient.getPID() == id) {
				return current_patient;
			}
			current_patient = current_patient.next;
		}
		return null;
	}
	
	public int getPatientPositionById(int id){
		
		if(length == 0) {
			return 0;
		}
		
		Patient current_patient = head;
		if(current_patient.getPID() == id) {
			return 0;
		}
		
		for (int i = 0; i < length && current_patient != null; i++) {
			if(current_patient.getPID() == id) {
				return i;
			}
			current_patient = current_patient.next;
		}
		return 0;
	}

	public Patient getPatient(int position) {
		Patient current_patient = head;
		for (int i = 0; i < position && current_patient != null; i++) {
			current_patient = current_patient.next;
		}
		return current_patient;
	}

	public void insertAfter(Patient prev_patient, Patient new_patient) {
		/* 1. Check if the given Node is null */
		if (prev_patient == null) {
			throw new NullPointerException("prev_patient must not be null");
		}
		if (new_patient == null) {
			throw new NullPointerException("new_patient must not be null");
		}

		/*
		 * 2. Allocate the Node & 3. Put in the data
		 */
		// Patient new_node = new_patient;

		/* 4. Make next of new Node as next of prev_node */
		new_patient.next = prev_patient.next;

		/* 5. make next of prev_node as new_node */
		prev_patient.next = new_patient;
		length++;
	}

	/* This function prints contents of linked list starting from head */
	public void printList() {
		Patient n = head;
		if(n == null) {
			System.out.println("No patients added");
		}
		while (n != null) {

			System.out.println("===========================================");
			
			System.out.println();
			System.out.print("PPS: ");
			System.out.print(n.getPps());

			System.out.println();
			System.out.print("ID: ");
			System.out.print(n.getPID());
			System.out.println();
			
			System.out.print("Name: ");
			System.out.print(n.getFirstName() + " " + n.getLastName());
			
			System.out.println();
			System.out.print("City: ");
			System.out.print(n.getCity());
			
			System.out.println();
			System.out.print("Email: ");
			System.out.print(n.getEmail());
			
			System.out.println();
			System.out.print("Phone: ");
			System.out.print(n.getPhoneNumber());
			System.out.println();
			
			System.out.println("===========================================");
			
			n = n.next;
		}
	}
}
