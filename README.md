# First Aider Management System

This project is a first-aider management system for managing first-aid personnel and incidents. It provides the ability to categorise first-aiders into various types, log incidents, and maintain an organised structure for handling emergency resources. 

**This work was completed as a part of my undergraduate degree in Applied Software Engineering at Swansea University, which CGI Inc. sponsored.**

## Project Structure

The project is organised into the following packages:

- **app**: The main entry point for running the application.
- **model**: Holds the core data models representing different types of first-aiders and incidents.
- **util**: Contains supporting resources such as the data file with first-aider information.

### Files Overview

- `Main.java` (in `app`): This is the main class that initiates the program, providing a command-line interface for interacting with the system.
- `DoctorFirstAider.java` (in `model`): Represents a first-aider with doctor-level expertise, extending the base `FirstAider` class.
- `FirstAider.java` (in `model`): A base class representing a general first-aider containing common properties and methods.
- `TraineeFirstAider.java` (in `model`): Represents a trainee first-aider, extending the `FirstAider` class with trainee-specific attributes.
- `Incident.java` (in `model`): Logs information about incidents requiring first aid.
- `firstaiders.txt` (in `resources`): A data file with information on various first-aiders used to populate the system.

## Features

- **First Aider Types**: Supports different first-aiders (Doctor, General, Trainee).
- **Incident Management**: Allows logging and managing incidents.
- **Console Menu**: A user-friendly menu for navigating the program's features.

## Getting Started

### Prerequisites

- Java 8 or later
- An IDE like Eclipse or IntelliJ for running the project

### Setup

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Ensure that the project’s directory structure matches the package names.

### Running the Application

1. Compile the project files.
2. Run the `Main` class in the `app` package.
3. Follow the console instructions to interact with the application.

## Usage

1. **Loading Data**: The application loads first-aider data from `firstaiders.txt`.
2. **Menu Navigation**: The main menu allows users to add, update, or view first-aiders and incidents.
3. **Incident Logging**: Users can log new incidents, associating them with available first-aiders.

