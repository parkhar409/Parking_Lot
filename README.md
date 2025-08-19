# Parking Lot Availability System

## 💡 Inspiration

This project was inspired by a real-life inconvenience. I often struggled to figure out which parking lots had available spaces. Many times, I ended up driving into a parking lot that was already full, forcing me to quickly find another nearby option. This frustration motivated me to build a system that visually represents parking availability, making it easier to see at a glance which spaces are open and which are occupied. 

---

## 📌 Overview

The Parking Lot Availability System is a Java Swing application that visually represents a parking lot's availability status. Each parking space is represented as a colored square:

* 🟩 **Green** → Available
* 🟥 **Red** → Occupied

The project demonstrates **Java GUI programming** and **Object-Oriented Design (OOD)** principles, providing a clean foundation for further enhancements such as multiple floors, reservations, or database integration.

---

## ✨ Features

* Interactive grid layout representing parking spaces.
* Clickable spaces toggle between **occupied** and **available**.
* Color-coded visual feedback for easy status recognition.
* Modular OOD design: `ParkingLot`, `ParkingSpot`, and `ParkingLotUI` classes.
* Easily configurable parking lot size (rows × columns).

---

## 🛠️ Tech Stack

* **Language**: Java (JDK 8+)
* **GUI Toolkit**: Java Swing (`JFrame`, `JPanel`, `JButton`, `GridLayout`)
* **Design Pattern**: Object-Oriented Design with clear separation of logic and UI

---

## 📂 Project Structure

```
src/
 ├── Main.java             # Entry point of the program
 ├── ParkingSpot.java      # Represents a single parking space
 ├── ParkingLot.java       # Manages the grid of parking spots
 └── ParkingLotUI.java     # GUI implementation (Swing-based)
```

---

## 🚀 Getting Started

### Prerequisites

* Install **Java JDK 8+**
* IDE or text editor (e.g., IntelliJ, Eclipse, VS Code with Java extension)

### Running the Program

1. Clone this repository:

   ```bash
   git clone https://github.com/your-username/parking-lot-availability.git
   cd parking-lot-availability/src
   ```
2. Compile the program:

   ```bash
   javac *.java
   ```
3. Run the application:

   ```bash
   java Main
   ```

---

## 🖼️ Example

When launched, the program displays a grid of parking spaces. Clicking on a square toggles its state between **available (green)** and **occupied (red)**.

---

## 🔮 Future Improvements

* Display the number of available/occupied spots.
* Support for multiple floors or different lot layouts.
* Support for managing multiple parking lots, with the ability to switch between them using a navigation or options panel.
* User-friendly interface with spot numbers/labels.
* Reservation system (e.g., reserve a spot for a car).
* Database integration for persistent storage.

---
