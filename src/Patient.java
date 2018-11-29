
public class Patient{
	private static int numberOfPatients = 0;
	private String pps;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String city;
	private int PID;
	
	public Patient next = null;
	
	public Patient(String pps, String firstName, String lastName, String phoneNumber, String email, String city) {
		this.pps = pps;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.city = city;
		this.PID = ++numberOfPatients;
	}

	public String getPps() {
		return pps;
	}

	public void setPps(String pps) {
		this.pps = pps;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + ": ID: " + this.getPID();
	}

	public int getPID() {
		return PID;
	}


}
