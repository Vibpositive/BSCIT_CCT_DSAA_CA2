import java.util.Scanner;

//import com.gasandeoliveira.MySQLAccess;

/**
 * 
 */

/**
 * @author Gabriel
 *
 */
public class Hospital {

	/**
	 * @param args
	 * 
	 */

	private static Scanner scanner = new Scanner(System.in);
	private static LinkedList patientList = new LinkedList();

	public void display_menu() {
		System.out.println("What would you like to do: ");

		for (Operations op : Operations.values()) {
			System.out.println(op.VAL() + ") " + op.DES());			
		}

		System.out.print("Selection: ");
		pick();
	}

	public void lineBreak() {
		System.out.println();
		System.out.println("=============================================================");
		System.out.println();
	}

	public void exit() {
		System.out.println("You've exited the program");
		lineBreak();
		System.exit(0);
	}

	public void isExit(String input) {
		if (input.equals("99")) {
			System.exit(0);
		}
	}

	public boolean yesOrNoQuestion(String question) {
		System.out.print(question + " yes (1) | no (0) ");
		switch (scanner.next()) {
		case "yes":
			return true;
		case "ye":
			return true;
		case "y":
			return true;
		case "1":
			return true;
		case "0":
			return false;
		case "n":
			return false;
		case "no":
			return false;

		default:
			return yesOrNoQuestion(question);
		}
	}

	public void addPatient() {

		boolean requirePositioning = false;
		boolean emergency = false;
		int position = patientList.length;

		String pps;
		String fn;
		String ln;
		String pn;
		String em;
		String ct;

		if(patientList.length > 0) {
			System.out.println(patientList.length);
			emergency = yesOrNoQuestion("Is this an emergency?");
			if(!emergency) {				
				requirePositioning = yesOrNoQuestion("Would you like to choose a position for the patient?");
			}
		}

		if (requirePositioning) {
			if (position == 0) {
				System.out.println("There are no patients, patient will be added to the first position");
				requirePositioning = false;
			} else {
				position = getIntInput("Inform a number between (1 and " + patientList.length + ")") - 1;
				System.out.println("\t\t\t\tposition: " + position);
			}
		}

		System.out.print("Inform patient's PPS: ");
		pps = scanner.next();
		System.out.print("Inform patient's First Name: ");
		fn = scanner.next();
		System.out.print("Inform patient's Last Name: ");
		ln = scanner.next();
		System.out.print("Inform patient's Phone Number: ");
		pn = scanner.next();
		System.out.print("Inform patient's email: ");
		em = scanner.next();
		System.out.print("Inform patient's city: ");
		ct = scanner.next();
		Patient pt = new Patient(pps, fn, ln, pn, em, ct);

		if (requirePositioning || emergency) {
			patientList.insertAt(position, pt);
		} else {
			patientList.append(pt);
		}

		int pp = patientList.getPatientPositionById(pt.getPID()) + 1;

		System.out.println("Patient: " + pt.getFirstName() + " " + pt.getLastName() + " added to the queue");
		System.out.println("\t" + pt.getFirstName() + " " + pt.getLastName() + "'s position is: " + pp);
		System.out.println("\t" + pt.getFirstName() + " " + pt.getLastName() + "'s ID is: " + pt.getPID());

		lineBreak();
		display_menu();
	}

	public int getIntInput(String question) {

		System.out.print(question + ": ");
		while (!scanner.hasNextInt()) {
			scanner.next();
		}

		int output = scanner.nextInt();
		return output;
	}
	
	public void removePatient() {
		if (patientList.length == 0) {
			System.out.println("There are " + patientList.length + " patients in the queue");
		}
		else {
			int pid = getIntInput("Inform patient's ID");
			Patient pt   = patientList.getPatientById(pid);
			patientList.delete(pt);
		}

		lineBreak();
		display_menu();
	}
	
	
	public void removePatients() {
		if (patientList.length == 0) {
			System.out.println("There are " + patientList.length + " patients in the queue");
		}
		else {
			int count = getIntInput("How many patients?");
			patientList.deleteLastN(count);
		}
		lineBreak();
		display_menu();
	}

	public void findPatient() {
		if (patientList.length == 0) {
			System.out.println("There are " + patientList.length + " patients in the queue");
		} else {
			int pid = getIntInput("Inform patient's ID");
			
			Patient pt   = patientList.getPatientById(pid);
			int position = patientList.getPatientPositionById(pt.getPID());
			

			if (pt != null) {
				System.out
						.println(pt.getFirstName() + " " + pt.getLastName() + "'s position is: " + (position + 1));
			} else {
				System.out.println("Patient ID not found in the Queue");
			}
		}

		lineBreak();
		display_menu();
	}

	public void pick() {
		
		int choice = scanner.nextInt(); 

		if(choice == Operations.ADD_NEW_PATIENT.INT()) {
			addPatient();
		}
		else if(choice == Operations.PRINT_ALL_PATIENTS.INT()) {
			patientList.printList();
			lineBreak();
			display_menu();
		}
		else if(choice == Operations.FIND_PATIENT_BY_ID.INT()) {
			findPatient();
		}
		else if(choice == Operations.REMOVE_PATIENT.INT()) {
			removePatient();
		}

		else if(choice == Operations.REMOVE_PATIENTS.INT()) {
			removePatients();
		}
		else if(choice == Operations.EXIT.INT()) {
			exit();
		}
		else {
			System.err.println("Unrecognized option");
			lineBreak();
			display_menu();
		}
		
	}

	public Hospital() {
		display_menu();
		
	}

	public static void main(String[] args) {
		/**/
		for (int i = 1; i < 10; i++) {
			patientList.append(new Patient(
					Integer.toString(i),
					Integer.toString(i),
					Integer.toString(i),
					Integer.toString(i),
					Integer.toString(i),
					Integer.toString(i)));
		}
		/**/
		new Hospital();
	}

}
