package models;

import incident.Incident;
import models.DoctorFirstAider;
import models.FirstAider;

/**
 * A class representing a trainee first-aider who can attend to incidents based
 * on their experience level.
 *
 * @author Zac Healy
 * @since 2023-02-23
 */
public class TraineeFirstAider extends FirstAider {

	// instance variable representing the supervisor of the trainee first-aider
	private DoctorFirstAider supervisor;

	/**
	 * Constructs a models.TraineeFirstAider object with the given parameters.
	 *
	 * @param id                The ID of the first-aider
	 * @param firstName         The first name of the first-aider
	 * @param lastName          The last name of the first-aider
	 * @param xCoordinate       The X-coordinate of the location of the first-aider
	 * @param yCoordinate       The Y-coordinate of the location of the first-aider
	 * @param incidentsAttended The number of incidents attended by the first-aider
	 * @param supervisor        The supervisor of the trainee first-aider.
	 */
	public TraineeFirstAider(int id, String firstName, String lastName, int xCoordinate, int yCoordinate,
							 int incidentsAttended, DoctorFirstAider supervisor) {
		// Calls the super constructor
		super(id, firstName, lastName, xCoordinate, yCoordinate, incidentsAttended);
		// Sets supervisor to the value of the parameter
		setSupervisor(supervisor);
	}

	/**
	 * Returns the supervisor of the trainee first-aider
	 *
	 * @return The supervisor of the trainee first-aider
	 */
	public DoctorFirstAider getSupervisor() {
		return supervisor;
	}

	/**
	 * Sets the supervisor of the trainee first-aider to the given supervisor
	 *
	 * @param supervisor The supervisor to set
	 * @throws IllegalArgumentException if the supervisor is null
	 */
	public void setSupervisor(DoctorFirstAider supervisor) {
		if (supervisor == null) {
			throw new IllegalArgumentException("Trainee must have a supervisor");
		}
		this.supervisor = supervisor;
	}

	/**
	 * Returns true if the trainee first-aider needs a supervisor for the given
	 * incident level, false otherwise
	 *
	 * @param level The severity level of the incident
	 * @return True if the trainee first-aider needs a supervisor for the given
	 * incident level, false otherwise
	 */
	public static boolean supervisorNeeded(int level) {
		return level == 1 || level == 2;
	}

	/**
	 * Returns the full name of the trainee first-aider and their supervisor
	 *
	 * @return The full name of the trainee first-aider and their supervisor
	 */
	public String getFirstAiderAndSupervisor() {
		return this.getFullName() + " and " + this.getSupervisor().getFullName();
	}


	/**
	 *
	 * Returns true if the trainee first-aider can attend to an incident of the
	 * given severity level, false otherwise
	 *
	 * @param level The severity level of the incident
	 * @return True if the trainee first-aider can attend to an incident of the
	 *         given severity level, false otherwise
	 */
	@Override
	public boolean checkCanAttend(int level) {
		// Checks if level is equal to 5
		if (level == 5) {
			return true;
			// Checks if level is equal to 4
		} else if (level == 4) {
			// Checks if the trainee first-aider has attended over 50 incidents
			return this.getIncidentsAttended() > 50;
			// Checks if level is equal to 3
		} else if (level == 3) {
			// Checks that supervisor is a rapid responder
			return supervisor.isRapidResponder();
			// Checks if level is equal to 1 or 2
		} else
			return level == 2 || level == 1;
	}

	/**
	 * Returns a string representation of the models.TraineeFirstAider object
	 *
	 * @return a string representation of the models.TraineeFirstAider object
	 */
	@Override
	public String toString() {
		return "Trainee first-aider" + super.toString() + supervisor.getFirstName() + " " + supervisor.getLastName() + "}";
	}

	/**
	 * Processes an incident for the models.TraineeFirstAider object. If the severity level
	 * of the incident requires a supervisor, the trainee's and supervisor's
	 * incidents attended counters are incremented. If the severity level does not
	 * require a supervisor, their incidents attended counter is incremented. Also
	 * sets the coordinates of the first-aider equal to the coordinates of the
	 * incident.
	 *
	 * @param incident the incident to be processed
	 */
	@Override
	public void processIncident(Incident incident) {
		// Increments the number of incidents the assignee has attended
		this.incrementIncidentsAttended();
		// Setting coordinates equal to the coordinates of the incident
		this.setXCoordinate(incident.getX());
		this.setYCoordinate(incident.getY());
		// Checks if a supervisor is needed to attend the incident
		if (supervisorNeeded(incident.getSeverityLevel())) {
			// Assigns the trainees supervisor as the supervisor in the incident
			incident.setAssigneeSupervisor(this.getSupervisor());
			// Increments the number of incidents the assignees supervisor has attended
			this.getSupervisor().incrementIncidentsAttended();

		}
	}
}