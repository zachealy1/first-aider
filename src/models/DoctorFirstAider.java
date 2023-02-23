package models;

import incident.Incident;

/**
 * 
 * A class representing a first aider with medical doctor qualifications and
 * specialised experience in responding to incidents. Inherits from the
 * models.FirstAider class.
 * @author Zac Healy
 * @since 2023-02-23
 */
public class DoctorFirstAider extends FirstAider {

	// Instance variables
	private int yearsOfExperience; // Number of years of experience in the field
	private boolean isRapidResponder; // Whether the doctor is a rapid responder or not

	/**
	 * 
	 * Constructs a models.DoctorFirstAider object with specified attributes.
	 * 
	 * @param id                the unique identifier of the doctor
	 * @param firstName         the first name of the doctor
	 * @param lastName          the last name of the doctor
	 * @param xCoordinate       the x-coordinate of the doctor's location
	 * @param yCoordinate       the y-coordinate of the doctor's location
	 * @param incidentsAttended the number of incidents attended by the doctor
	 * @param yearsOfExperience the number of years of experience in the field
	 * @param isRapidResponder  whether the doctor is a rapid responder or not
	 */
	public DoctorFirstAider(int id, String firstName, String lastName, int xCoordinate, int yCoordinate,
			int incidentsAttended, int yearsOfExperience, boolean isRapidResponder) {
		// Calls the super constructor
		super(id, firstName, lastName, xCoordinate, yCoordinate, incidentsAttended);
		// Sets the instance variables to the value of the parameters
		this.yearsOfExperience = yearsOfExperience;
		this.isRapidResponder = isRapidResponder;
	}

	/**
	 * 
	 * Returns the number of years of experience in the field of the doctor
	 * 
	 * @return the years of experience
	 */
	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	/**
	 * 
	 * Sets the number of years of experience in the field of the doctor
	 * 
	 * @param yearsOfExperience the years of experience to set
	 */
	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	/**
	 * 
	 * Returns whether the doctor is a rapid responder or not
	 * 
	 * @return true if the doctor is a rapid responder, false otherwise
	 */
	public boolean isRapidResponder() {
		return isRapidResponder;
	}

	/**
	 * 
	 * Sets whether the doctor is a rapid responder or not
	 * 
	 * @param rapidResponder whether the doctor is a rapid responder or not
	 */
	public void setRapidResponder(boolean rapidResponder) {
		isRapidResponder = rapidResponder;
	}

	/**
	 * 
	 * Returns true always, indicating that the doctor can attend to any incident
	 * 
	 * @param level the level of the incident
	 * @return true
	 */
	@Override
	public boolean checkCanAttend(int level) {
		return true;
	}

	/**
	 * 
	 * Returns a string representation of the models.DoctorFirstAider object
	 * 
	 * @return the string representation
	 */
	@Override
	public String toString() {
		return "Doctor First Aider" + super.toString() + ", yearsOfExperience=" + yearsOfExperience
				+ ", isRapidResponder=" + isRapidResponder + "}";
	}

	/**
	 * 
	 * Processes the given incident by incrementing the number of incidents attended
	 * by the and setting the coordinates of the first aider equal to the
	 * coordinates of the incident doctor.
	 * 
	 * @param incident the incident to be processed
	 */
	@Override
	public void processIncident(Incident incident) {
		this.incrementIncidentsAttended();
		// Setting coordinates equal to the coordinates of the incident
		this.setXCoordinate(incident.getX());
		this.setYCoordinate(incident.getY());
	}
}
