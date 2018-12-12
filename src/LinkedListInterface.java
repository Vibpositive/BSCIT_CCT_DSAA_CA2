
// TODO: Auto-generated Javadoc
/**
 * The Interface LinkedListInterface.
 */
public interface LinkedListInterface {
	
	/**
	 * Adds a patient to the top of the linked list.
	 *
	 * @param patient the patient
	 */
	public void 			push(Patient patient);
	
	/**
	 * Appends a patient to the end of the list
	 *
	 * @param patient the new patient
	 */
	public void 			append(Patient patient);
	
	/**
	 * Deletes a patient from the linked list based on its position
	 *
	 * @param position the position
	 */
	public void 			delete(int position);
	
	/**
	 * Deletes a patient from the list
	 *
	 * @param patient the patient
	 */
	public void 			delete(Patient patient);
	
	/**
	 * Delete a range of patients from the last
	 *
	 * @param count the count
	 */
	public void 			deleteLastN(int count);
	
	/**
	 * Insert a patient at the given position
	 *
	 * @param position the position
	 * @param patient the new patient
	 */
	public void 			insertAt(Integer position, Patient patient);
	
	/**
	 * Gets a patient by id
	 *
	 * @param id the id
	 * @return the patient by id
	 */
	public Patient 			getPatientById(int id);
	
	/**
	 * Gets the patient position by id.
	 *
	 * @param id the id
	 * @return the patient position by id
	 */
	public int 				getPatientPositionById(int id);
	
	/**
	 * Gets the patient by position
	 *
	 * @param position the position
	 * @return the patient
	 */
	public Patient 			getPatient(int position);
	
	/**
	 * Insert a patient after a given patient.
	 *
	 * @param prev_patient the previous patient
	 * @param new_patient the new patient
	 */
	public void 			insertAfter(Patient prev_patient, Patient new_patient);
}