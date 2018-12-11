
public enum Operations {
	ADD_NEW_PATIENT(1, "Add new patient"),
	FIND_PATIENT_BY_ID(2, "Find Patient by ID"),
	PRINT_ALL_PATIENTS(3, "Print all Patients"),
	REMOVE_PATIENT(4, "Remove a patient from the queue"),
	REMOVE_PATIENTS(5, "Remove the last n patients from the queue"),
	UPDATE_PATIENT(6, "Update a patient"),
	EXIT(0, "Exit");
	
	private final Object[] values;

	Operations(Object... vals) {
        values = vals;
    }
	
	public int INT() {
        return (int) values[0];
    }
	
	public String VAL() {
        return (String) values[0].toString();
    }
	
	public String DES() {
        return (String) values[1];
    }
	
	/*
	private Operations(int operation, String description) {
		this.operation = operation;
		this.description = description;
	}
	/**/
}