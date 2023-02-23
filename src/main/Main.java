package main;

import incident.Incident;
import models.DoctorFirstAider;
import models.FirstAider;
import models.TraineeFirstAider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * The main class
 *
 * @author Zac Healy
 * @since 2023-02-23
 */
public class Main {

	// An ArrayList of all FirstAiders currently registered in the system
	public static ArrayList<FirstAider> firstAiders = new ArrayList<FirstAider>();

	// The file that contains data about the FirstAiders
	public final static File firstAiderFile = new File(
			"src/resources/first-aiders.txt");
	// Scanner to read user input
	public static Scanner sc = new Scanner(System.in);

	/**
	 * Reads data from a given file and initialises the models.FirstAider objects in the
	 * system.
	 * 
	 * @param file the file containing models.FirstAider data
	 * @throws FileNotFoundException if the file is not found
	 */
	public static void readData(File file) throws FileNotFoundException {
		// Declaration of new scanner
		Scanner sc = new Scanner(file);
		// Loops while scanner has new input
		while (sc.hasNext()) {
			sc.useDelimiter("[,\n]");
			// Check if the scanners next input is equal to DOCTOR
			if (sc.next().equals("DOCTOR")) {
				// Create a new models.DoctorFirstAider object and add it to the list of FirstAiders
				firstAiders.add(new DoctorFirstAider(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt(),
													 sc.nextInt(), sc.nextInt(), Boolean.parseBoolean(sc.next())));
			} else {
				// Create a new models.TraineeFirstAider object and add it to the list of FirstAiders
				firstAiders.add(new TraineeFirstAider(sc.nextInt(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt(),
													  sc.nextInt(), (DoctorFirstAider) Main.getFirstAiderFromId(sc.nextInt())));
			}
		}
		// Closes the scanner
		sc.close();
	}

	/**
	 * Prints the program menu for the user to interact with
	 */
	public static boolean programMenu() {
		// Prints the menu options available to the user
		System.out.println("-------incident.Incident Menu-------");
		System.out.println();
		System.out.println("1. Enter a incident");
		System.out.println("2. Exit");
		System.out.println();
		System.out.print("Enter a digit to select an option: ");
		// Sets choice to the users next input
		int choice = sc.nextInt();
		// Either calls the programIncident method or exits the program
		switch (choice) {
		case 1:
			programIncident();
			break;
		case 2:
			return false;
		}
		return true;
	}

	/**
	 * Prompts the user for input about a new incident, assigns a models.FirstAider to the
	 * incident, and processes the incident.
	 */
	public static void programIncident() {

		// Prompt the user for input about the new incident
		System.out.print("Enter the X coordinate of the incident: ");
		// Stores user input in variable x
		int x = sc.nextInt();
		System.out.print("Enter the Y coordinate of the incident: ");
		// Stores user input in variable y
		int y = sc.nextInt();
		System.out.print("Enter the severity level of the incident: ");
		// Stores user input in variable severityLevel
		int severityLevel = sc.nextInt();
		// Creates new incident with the details entered by the user
		Incident latestIncident = new Incident(x, y, severityLevel);

		// Prints out the assignees of the latest incident
		System.out.println("First Aider Assigned: " + latestIncident.getAssigneeString());
	}

	/**
	 * 
	 * Get the models.FirstAider with the specified ID
	 * 
	 * @param id the ID of the models.FirstAider to get
	 * @return the models.FirstAider with the specified ID, or null if not found
	 * 
	 * @throws IllegalArgumentException If the id isn't found
	 * 
	 */
	public static FirstAider getFirstAiderFromId(int id) {
		// Loops through the first-aider array
		for (int i = 0; i < Main.firstAiders.size(); i++) {
			// Checks if the id is equal to the if of the first-aider at position i in the array
			if (Main.firstAiders.get(i).getId() == id) {
				return Main.firstAiders.get(i);
			}
		}
		throw new IllegalArgumentException("No models.FirstAider with matching ID found");
	}

	/**
	 * 
	 * Find the closest models.FirstAider to a given incident
	 * 
	 * @param incident the incident to find the closest models.FirstAider for
	 * 
	 * @return the closest models.FirstAider to the incident, or null if none are available
	 */

	public static FirstAider findClosestFirstAider(Incident incident) {
		FirstAider closestFirstAider = null;
		// Sets minDistance to maximum value of a double
		double minDistance = Double.MAX_VALUE;

		for (FirstAider fa : firstAiders) {
			// Checks if the first-aider can attend the incident
			if (fa.checkCanAttend(incident.getSeverityLevel())) {
				// Sets distance to the distance between the first-aider and the incident
				double distance = fa.calculateDistanceTo(incident.getX(), incident.getY());
				// Checks if distance is less than the minimum distance
				if (distance < minDistance) {
					// Sets closestFirstAider to the value held in fa
					closestFirstAider = fa;
					// Sets minDistance to the distance between the first-aider and the incident
					minDistance = distance;
				}
			}
		}
		return closestFirstAider;
	}

	/**
	 * Checks if a given y coordinate is within the valid range
	 *
	 * @param coordinate the y coordinate to be checked
	 * @throws IllegalArgumentException if the y coordinate is outside the valid
	 *                                  range
	 */
	public static void checkCoordinate(double coordinate) {
		// Checks if coordinate is outside the conditions
		if (coordinate < -999999999 || coordinate > 999999999) {
			throw new IllegalArgumentException("Coordinates must be an integer between -999,999,999 and 999,999,999");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		// Call the read data method
		readData(firstAiderFile);
		// Calls the program menu method and run until closed
		boolean keepRunning = true;
		while (keepRunning) {
			keepRunning = programMenu(); // programMenu returns false to exit
		}
		System.exit(0);
	}
}
