package incident;

import main.Main;
import models.FirstAider;

/**
 * 
 * The incident.Incident class represents an incident with coordinates, severity level,
 * assignee, and an assignees supervisor that requires assistance from a first-aider.
 *
 * @author Zac Healy
 * @since 2023-02-23
 */
public class Incident {

	// Instance variables
	private int x; // the X coordinate of the incident
	private int y; // the Y coordinate of the incident
	private int severityLevel; // the severity level of the incident
	private FirstAider assignee; // the models.FirstAider assigned to the incident
	private FirstAider assigneeSupervisor; // assignees supervisor if required

	/**
	 * 
	 * Constructs an incident.Incident object with the given coordinates and severity level.
	 * 
	 * @param x             the X coordinate of the incident
	 * @param y             the Y coordinate of the incident
	 * @param severityLevel the severity level of the incident
	 */
	public Incident(int x, int y, int severityLevel) {
		// Sets the instance variables to the value of the parameters
		setX(x);
		setY(y);
		this.severityLevel = severityLevel;
		// Sets the assignee to the nearest first-aider
		setAssignee(Main.findClosestFirstAider(this));
	}

	/**
	 * 
	 * Returns the X coordinate of the incident.
	 * 
	 * @return the X coordinate of the incident
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets and validates the X coordinate of the incident.
	 * 
	 * @param x the new x coordinate
	 */
	public void setX(int x) {
		Main.checkCoordinate(x);
		this.x = x;
	}

	/**
	 * 
	 * Returns the Y coordinate of the incident.
	 * 
	 * @return the Y coordinate of the incident
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets and validates the y coordinate of the incident.
	 * 
	 * @param y the new x coordinate
	 */
	public void setY(int y) {
		Main.checkCoordinate(y);
		this.y = y;
	}

	/**
	 * Sets the severityLevel of the incident.
	 * 
	 * @param severityLevel the new severityLevel of the incident
	 */
	public void setSeverityLevel(int severityLevel) {
		this.severityLevel = severityLevel;
	}

	/**
	 * 
	 * Returns the severity level of the incident.
	 * 
	 * @return the severity level of the incident
	 */
	public int getSeverityLevel() {
		return severityLevel;
	}

	/**
	 * 
	 * Sets the models.FirstAider assigned to the incident.
	 * 
	 * @param assignee the models.FirstAider assigned to the incident
	 */
	public void setAssignee(FirstAider assignee) {
		this.assignee = assignee;
		this.assignee.processIncident(this);
	}

	/**
	 * Gets the models.FirstAider assigned to handle the incident.
	 * 
	 * @return the models.FirstAider assigned to handle the incident
	 */
	public FirstAider getAssignee() {
		return assignee;
	}

	/**
	 * Gets the supervisor of the models.FirstAider assigned to handle the incident.
	 * 
	 * @return the supervisor of the assigned models.FirstAider
	 */
	public FirstAider getAssigneeSupervisor() {
		return assigneeSupervisor;
	}

	/**
	 * Sets the supervisor of the models.FirstAider assigned to handle the incident and
	 * processes the incident with the supervisor.
	 * 
	 * @param assigneeSupervisor the supervisor of the assigned models.FirstAider
	 */
	public void setAssigneeSupervisor(FirstAider assigneeSupervisor) {
		// set the supervisor
		this.assigneeSupervisor = assigneeSupervisor;
		// process the incident with the supervisor
		this.assigneeSupervisor.processIncident(this);
	}

	/**
	 * Gets a string representation of the assigned models.FirstAider and their supervisor,
	 * if any.
	 * 
	 * @return a string representing the assigned models.FirstAider and supervisor, if any
	 */
	public String getAssigneeString() {
		if (assigneeSupervisor == null) {
			// if there is no supervisor, return just the assigned models.FirstAider's name
			return assignee.getFullName();
		} else {
			// if there is a supervisor, return the assigned models.FirstAider's name and the
			// supervisor's name
			return assignee.getFullName() + " and " + assigneeSupervisor.getFullName();
		}
	}

	/**
	 * 
	 * Returns a string representation of the incident.Incident object
	 * 
	 * @return a string representation of the incident.Incident object
	 */
	@Override
	public String toString() {
		return "incident.Incident" + " x = " + x + " y = " + y + " Severity level = " + severityLevel + " assignee = " + assignee
				+ " assignee supervisor = " + assigneeSupervisor + "}";
	}
}