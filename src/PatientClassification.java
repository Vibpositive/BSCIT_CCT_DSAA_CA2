
public enum PatientClassification {
	EMERGENCY(1, "Emergency"),
	APPOINTMENT(2, "Appointment");
	
	private final Object[] values;
	
	PatientClassification(Object... vals) {
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
}
