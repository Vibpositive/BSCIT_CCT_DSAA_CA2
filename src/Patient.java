
// TODO: Auto-generated Javadoc
/**
 * Represents a patient.
 */
public class Patient{
	
	/** The number of patients. */
	private static int numberOfPatients = 0;
	
	/** The pps. */
	private String pps;
	
	/** The first name. */
	private String firstName;
	
	/** The last name. */
	private String lastName;
	
	/** The phone number. */
	private String phoneNumber;
	
	/** The email. */
	private String email;
	
	/** The city. */
	private String city;
	
	/** The pid. */
	private int PID;
	
	/** The next. */
	public Patient next = null;
	
	/**
	 * Instantiates a new patient.
	 *
	 * @param pps the pps
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param phoneNumber the phone number
	 * @param email the email
	 * @param city the city
	 */
	public Patient(String pps, String firstName, String lastName, String phoneNumber, String email, String city) {
		this.pps = pps;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.city = city;
		this.PID = ++numberOfPatients;
	}

	/**
	 * Gets the pps.
	 *
	 * @return the pps
	 */
	public String getPps() {
		return pps;
	}

	/**
	 * Sets the pps.
	 *
	 * @param pps the new pps
	 */
	public void setPps(String pps) {
		this.pps = pps;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.getFirstName() + " " + this.getLastName() + ": ID: " + this.getPID();
	}

	/**
	 * Gets the pid.
	 *
	 * @return the pid
	 */
	public int getPID() {
		return PID;
	}


}
