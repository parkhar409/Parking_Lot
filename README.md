# Parking Lot Status Check Application

## 💡 Inspiration

This project was inspired by a real-life inconvenience. I often struggled to figure out which parking lots had available spaces. Many times, I ended up driving into a parking lot that was already full, forcing me to quickly find another nearby option. This frustration motivated me to build a comprehensive system that visually represents parking availability, making it easier to see at a glance which spaces are open, how long they've been occupied, and manage multiple parking lots efficiently.

---

## 📌 Overview

The Parking Lot Status Check Application is a sophisticated Java Swing application that provides real-time visual monitoring of parking lot availability. Each parking space is represented as an interactive colored square with detailed status information:

* 🟩 **Green** → Available spots
* 🟥 **Red** → Occupied spots (shows occupation duration)
* 📊 **Real-time statistics** → Available spots count and hourly rates
* 🏢 **Multiple lots** → Switch between different parking facilities

The project demonstrates **advanced Java GUI programming**, **Object-Oriented Design (OOD)** principles, and **clean code architecture** with comprehensive documentation and optimized performance.

---

## ✨ Features

### 🎯 Core Functionality
* **Interactive Grid Layout**: Visual representation of parking spaces with clickable spots
* **Real-time Status Updates**: Auto-refresh every 30 seconds to keep data current
* **Occupation Time Tracking**: Shows how long each spot has been occupied (hours/minutes)
* **Vehicle ID Management**: Track which vehicle is occupying each spot
* **Multiple Parking Lots**: Switch between different facilities with a dropdown selector

### 🎨 User Interface
* **Navigation Bar**: Displays current lot name, available spots count, and hourly rate
* **Visual Legend**: Clear color coding explanation for easy understanding
* **Responsive Design**: Scrollable interface for large parking lots
* **Status Bar**: User guidance and instructions
* **Professional Styling**: Consistent, modern GUI design

### 🏗️ Technical Features
* **Object-Oriented Architecture**: Clean separation of concerns with well-documented classes
* **Optimized Performance**: Efficient algorithms and reduced code duplication
* **Error Handling**: Robust coordinate validation and input processing
* **Modular Design**: Easy to extend and maintain
* **Comprehensive Documentation**: Full JavaDoc comments for all classes and methods

---

## 🛠️ Tech Stack

* **Language**: Java (JDK 8+)
* **GUI Toolkit**: Java Swing (`JFrame`, `JPanel`, `JButton`, `GridBagLayout`, `JScrollPane`)
* **Design Patterns**: Object-Oriented Design, Utility Pattern, MVC Architecture
* **Time Management**: `LocalDateTime` and `Duration` for precise time tracking
* **Code Quality**: Clean code principles with comprehensive documentation

---

## 📂 Project Structure

```
src/
 ├── App.java                    # Main application entry point
 ├── UserInterface.java          # Main GUI controller and window management
 ├── ParkingSpot.java            # Individual parking spot with time tracking
 ├── ParkingLot.java             # Parking lot management with grid operations
 ├── ParkingLotManager.java      # Multiple parking lot coordination
 ├── ParkingSpotPanel.java       # GUI component for individual spots
 ├── NavigationBar.java          # Top navigation with lot selection and stats
 ├── ExampleData.java            # Sample data for demonstration
 └── GUIUtils.java               # Utility class for common GUI operations
```

### 🏛️ Architecture Overview

* **`ParkingSpot`**: Core entity representing individual parking spaces with occupation tracking
* **`ParkingLot`**: Manages a grid of parking spots with availability statistics
* **`ParkingLotManager`**: Coordinates multiple parking lots and current selection
* **`UserInterface`**: Main application controller and GUI orchestration
* **`ParkingSpotPanel`**: Reusable GUI component for spot visualization
* **`NavigationBar`**: Dedicated navigation and information display
* **`GUIUtils`**: Centralized constants and helper methods for consistency
* **`ExampleData`**: Pre-configured sample data for immediate demonstration

---

## 🚀 Getting Started

### Prerequisites

* **Java JDK 8+** (recommended: JDK 11 or higher)
* IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VS Code with Java extension)

### Running the Application

1. **Navigate to the project directory**:
   ```bash
   cd "Parking Lot App/Parking_Lot"
   ```

2. **Compile the application**:
   ```bash
   javac -d bin src/*.java
   ```

3. **Run the application**:
   ```bash
   java -cp bin App
   ```

### Alternative Launch Method

You can also run the application directly through the UserInterface class:
```bash
java -cp bin UserInterface
```

---

## 🎮 How to Use

### Basic Operations
1. **Select a Parking Lot**: Use the dropdown in the top-right corner to switch between different lots
2. **View Status**: Green squares indicate available spots, red squares show occupied spots
3. **Check Duration**: Occupied spots display how long they've been occupied
4. **Toggle Status**: Click on any spot to:
   - **Occupy**: Enter a vehicle ID when prompted
   - **Vacate**: Click on an occupied spot to free it up
5. **Monitor Statistics**: View available spots count and hourly rates in the navigation bar

### Sample Data
The application comes pre-loaded with four sample parking lots:
- **Downtown Mall** (4×6 grid, $3.50/hour)
- **Airport Terminal** (3×8 grid, $5.00/hour)
- **University Campus** (5×5 grid, $2.00/hour)
- **City Hospital** (3×7 grid, $4.25/hour)

---

## 🖼️ Screenshots & Features

### Main Interface
- **Navigation Bar**: Shows current lot name, available spots, and hourly rate
- **Parking Grid**: Interactive squares representing each parking spot
- **Legend**: Color coding explanation for easy understanding
- **Status Bar**: User instructions and guidance

### Interactive Elements
- **Click to Occupy**: Click available (green) spots to occupy them
- **Click to Vacate**: Click occupied (red) spots to free them
- **Lot Switching**: Dropdown to change between different parking lots
- **Auto-refresh**: Automatic updates every 30 seconds

---

## 🔧 Technical Implementation

### Key Design Decisions
- **GridBagLayout**: Flexible grid system for parking spot arrangement
- **Action Listeners**: Event-driven architecture for user interactions
- **Timer-based Updates**: Automatic refresh for real-time data
- **Utility Pattern**: Centralized constants and helper methods
- **Modular Components**: Reusable GUI elements for consistency

### Performance Optimizations
- **Direct Array Access**: Efficient spot retrieval without redundant method calls
- **Consolidated Logic**: Eliminated duplicate code patterns
- **Centralized Validation**: Single source of truth for coordinate checking
- **Optimized Rendering**: Efficient GUI updates and repainting

---

## 📚 Code Quality

### Documentation
- **Comprehensive JavaDoc**: Every class and method fully documented
- **Clear Comments**: Inline explanations for complex logic
- **Architecture Documentation**: Clear separation of concerns
- **Usage Examples**: Well-documented public APIs

### Clean Code Principles
- **Single Responsibility**: Each class has a focused purpose
- **DRY Principle**: Eliminated code duplication through utility classes
- **Consistent Naming**: Clear, descriptive variable and method names
- **Error Handling**: Robust validation and error recovery

---

## 🔮 Future Enhancements

### Planned Features
- **Database Integration**: Persistent storage for parking lot data
- **User Authentication**: Login system for different user types
- **Reservation System**: Pre-book parking spots with time slots
- **Payment Integration**: Real-time payment processing
- **Mobile App**: Companion mobile application
- **Analytics Dashboard**: Usage statistics and reporting
- **Multi-floor Support**: Vertical parking lot management
- **Real-time Notifications**: Push notifications for spot availability

### Technical Improvements
- **Spring Framework**: Dependency injection and enterprise features
- **REST API**: Web service integration for external systems
- **Microservices**: Scalable architecture for multiple locations
- **Cloud Deployment**: AWS/Azure integration for scalability
- **Machine Learning**: Predictive analytics for spot availability

---