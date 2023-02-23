package models;

import incident.Incident;
import main.Main;

/**
 * 
 * Abstract class for first-aider's that contains common attributes and methods
 *
 * @author Zac Healy
 * @since 2023-02-23
 */
public abstract class FirstAider {
	// Instance variables
	private final int id; // The unique identifier of the first-aider
	private final String firstName; // The first name of the first-aider
	private final String lastName; // The last name of the first-aider
	private int xCoordinate; // The x coordinate of the first-aider's location
	private int yCoordinate; // The y coordinate of the first-aider's location
	private int incidentsAttended; // The number of incidents the first-aider has attended.

	/**
	 * 
	 * Constructor to initialise a models.FirstAider object
	 * 
	 * @param id                The unique identifier of the first-aider
	 * @param firstName         The first name of the first-aider
	 * @param lastName          The last name of the first-aider
	 * @param xCoordinate       The x coordinate of the first-aider's location
	 * @param yCoordinate       The y coordinate of the first-aider's location
	 * @param incidentsAttended The number of incidents the first-aider has
	 *                          attended.
	 */
	public FirstAider(int id, String firstName, String lastName, int xCoordinate, int yCoordinate,
			int incidentsAttended) {
		// Calls method to validate the ID
		validateId(id);
		// Sets the instance variables to the value of the parameters
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		// Sets the instance variables to the value of the parameters via the setter
		// methods for validation
		setXCoordinate(xCoordinate);
		setYCoordinate(yCoordinate);
		setIncidentsAttended(incidentsAttended);
	}

	/**
	 * 
	 * Returns the unique identifier of the first-aider
	 * 
	 * @return The unique identifier of the first-aider
	 */
	public int getId() {
		return id;
	}

	/**
	 * Validates the id of the first-aider
	 *
	 * @param id The id to be validated
	 * @throws IllegalArgumentException If the id is not valid
	 */
	public void validateId(int id) {
		// Checks if id is of a valid format
		if (id < 0 || id > 500000) {
			throw new IllegalArgumentException("ID must be an integer between 0 and 500,000");
		}
	}

	/**
	 * 
	 * Returns the first name of the first-aider
	 * 
	 * @return The first name of the first-aider
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * Returns the last name of the first-aider
	 * 
	 * @return The last name of the first-aider
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * Returns the x coordinate of the first-aider's location
	 * 
	 * @return The x coordinate of the first-aider's location
	 */
	public double getXCoordinate() {
		return xCoordinate;
	}

	/**
	 * 
	 * Sets the x coordinate of the first-aider's location
	 * 
	 * @param xCoordinate The x coordinate to be set
	 */
	public void setXCoordinate(int xCoordinate) {
		// Calls method to check that coordinates are valid
		Main.checkCoordinate(xCoordinate);
		this.xCoordinate = xCoordinate;
	}

	/**
	 * 
	 * Returns the y coordinate of the first-aider's location
	 * 
	 * @return The y coordinate of the first-aider's location
	 */
	public double getYCoordinate() {
		return yCoordinate;
	}

	/**
	 * 
	 * Sets the y coordinate of the first-aider's location
	 * 
	 * @param yCoordinate The y coordinate to be set
	 */
	public void setYCoordinate(int yCoordinate) {
		// Calls method to check that coordinates are valid
		Main.checkCoordinate(yCoordinate);
		this.yCoordinate = yCoordinate;
	}

	/**
	 * 
	 * Returns the number of incidents the first-aider has attended
	 * 
	 * @return The number of incidents the first-aider has attended
	 */

	public int getIncidentsAttended() {
		return incidentsAttended;
	}

	/**
	 * 
	 * Set the number of incidents attended by this models.FirstAider
	 * 
	 * @param incidentsAttended the number of incidents attended
	 */
	public void setIncidentsAttended(int incidentsAttended) {
		this.incidentsAttended = incidentsAttended;
	}

	/**
	 * 
	 * Increment the number of incidents attended by this models.FirstAider
	 */
	public void incrementIncidentsAttended() {
		incidentsAttended++;
	}

	/**
	 * 
	 * Get the full name of this models.FirstAider
	 * 
	 * @return the full name of this models.FirstAider
	 */
	public String getFullName() {
		return firstName + " " + lastName;
	}

	/**
	 * 
	 * Check if this models.FirstAider can attend an incident of a given severity level
	 * 
	 * @param level the severity level of the incident
	 * @return true if this models.FirstAider can attend the incident, false otherwise
	 */
	public abstract boolean checkCanAttend(int level);

	/**
	 * 
	 * Process an incident for this models.FirstAider
	 * 
	 * @param incident the incident to process
	 */
	public abstract void processIncident(Incident incident);

	/**
	 * 
	 * Calculate the distance between this models.FirstAider and a set of coordinates
	 * 
	 * @param x the x-coordinate to calculate the distance to
	 * @param y the y-coordinate to calculate the distance to
	 * @return the distance between this models.FirstAider and the specified coordinates
	 */
	public double calculateDistanceTo(double x, double y) {
		return Math.sqrt(Math.pow(x - this.xCoordinate, 2) + Math.pow(y - this.yCoordinate, 2));
	}

	/**
	 * 
	 * Returns a string representation of the models.FirstAider object
	 * 
	 * @return a string representation of the models.FirstAider object
	 */
	@Override
	public String toString() {
		return "{id=" + id + ", firstName='" + firstName + " " + ", lastName='" + lastName + " " + ", xCoordinate="
				+ xCoordinate + ", yCoordinate=" + yCoordinate + ", incidentsAttended=" + incidentsAttended;
	}
}