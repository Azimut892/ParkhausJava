# Parkhaus Management System 🚗

A console-based parking garage management system built in Java that allows users to park vehicles, manage parking spaces, and track vehicle locations.

## Features

### Core Functionality
- **Vehicle Parking**: Park cars and motorcycles with automatic space allocation
- **Vehicle Retrieval**: Remove vehicles from the parking garage using license plates
- **Multi-Floor Support**: Separate floors for different vehicle types
- **Real-time Availability**: Track and display available parking spaces

### Vehicle Types
- **Cars**: Parked on floors 1 and above
- **Motorcycles**: Parked exclusively on floor 0 (ground level)

### Management Features
- **Floor Management**: Add or modify the number of floors
- **Space Configuration**: Customize parking spaces per floor
- **Vehicle Search**: Find any parked vehicle by license plate
- **Availability Reports**: View free spaces by floor or total

## Project Structure

```
src/
├── Main.java           # Application entry point
├── Parkhaus.java       # Main menu and core data structures
├── Parken.java         # Vehicle parking logic
├── AusParken.java      # Vehicle retrieval logic
└── Einstellungen.java  # Settings and management features
```

## How to Run

1. **Compile the project**:
   ```bash
   javac src/*.java
   ```

2. **Run the application**:
   ```bash
   java -cp src Main
   ```

## Usage Guide

### Main Menu Options
- **[P]** - Park a vehicle
- **[A]** - Remove a parked vehicle  
- **[E]** - Access settings and management
- **[Q]** - Exit the application

### Parking Process
1. Select vehicle type (Car or Motorcycle)
2. Enter license plate number
3. System automatically assigns optimal parking space
4. Receive parking location confirmation

### Settings Menu
- **[E]** - Modify number of floors
- **[P]** - Configure parking spaces per floor
- **[W]** - Search for a specific vehicle
- **[F]** - View total available spaces
- **[H]** - View spaces available per floor
- **[Z]** - Return to main menu

## Technical Implementation

### Key Java Concepts Demonstrated
- **Object-Oriented Programming**: Separate classes for different functionalities
- **Collections Framework**: 
  - `HashMap` for license plate to location mapping
  - `ArrayList` for managing floor and parking space lists
- **Static Methods**: Utility methods for system operations
- **Switch Statements**: Menu navigation and user input handling
- **Exception Handling**: Input validation and error management
- **Scanner Class**: Console input processing

### Data Structures
- `HashMap<String, String> geparkteAutos`: Maps license plates to parking locations
- `HashMap<Integer, List<Integer>> etageUndParkplatz`: Maps floor numbers to available parking spaces
- `List<Integer> etagenListe`: Tracks all available floors

### Parking Logic
- **Cars**: Automatically assigned to the first available space on floors 1+
- **Motorcycles**: Assigned to floor 0 (ground level)
- **Space Management**: Parking spaces are removed when occupied and restored when vacated
- **Duplicate Prevention**: System prevents parking the same license plate twice

## Example Usage

```
Parken [P] Ausparken [A] Einstellungen [E] Beenden [Q]
> p

Was möchten Sie parken? Auto [A] Motorrad [M]
> a

Geben Sie Ihr Kennzeichen an oder [A] um abzubrechen
> ABC123

Ihr Auto ist auf Etage 1, Parkplatz 1 geparkt.
```

## Future Enhancements

Potential improvements for learning purposes:
- Add parking fee calculation based on duration
- Implement reservation system
- Add vehicle size categories (compact, standard, large)
- Create a graphical user interface
- Add data persistence (save/load parking data)
- Implement time-based parking limits

## Learning Objectives

This project demonstrates practical application of:
- Java syntax and basic programming concepts
- Object-oriented design principles
- Data structure usage and manipulation
- User input handling and validation
- Menu-driven application architecture
- Code organization and modularity

## Requirements

- Java Development Kit (JDK) 8 or higher
- Console/Terminal for running the application

---

*This project was created as a learning exercise to practice Java programming concepts including object-oriented programming, data structures, and console-based user interaction.*
