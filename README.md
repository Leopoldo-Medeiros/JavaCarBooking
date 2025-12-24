# 🚗 Java Car Booking System

A command-line based Car Booking System built with Java, following Object-Oriented Programming principles. This application allows users to manage car bookings, car inventory, and user information efficiently.

## 📋 Features

- **User Management**: Create and manage user accounts
- **Car Inventory**: Maintain a list of available cars with details
- **Booking System**: Handle car reservations and bookings
- **Data Persistence**: In-memory data storage using DAO pattern
- **Modular Design**: Clean separation of concerns with Service and DAO layers

## 🏗️ Project Structure

```
src/
├── Main.java                     # Application entry point
├── leo.carbooking/
│   ├── booking/                 # Booking related classes
│   │   ├── Booking.java         # Booking entity
│   │   ├── BookingDAO.java      # Data Access Object for bookings
│   │   └── BookingService.java  # Business logic for bookings
│   │
│   ├── car/                     # Car related classes
│   │   ├── Car.java             # Car entity
│   │   ├── CarDAO.java          # Data Access Object for cars
│   │   └── CarService.java      # Business logic for cars
│   │
│   └── user/                    # User related classes
│       ├── User.java            # User entity
│       ├── UserDAO.java         # Data Access Object for users
│       └── UserService.java     # Business logic for users
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Maven (for dependency management)

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/JavaCarBooking.git
   cd JavaCarBooking
   ```

2. Compile the project:
   ```bash
   javac -d out src/*.java src/leo/carbooking/**/*.java
   ```

3. Run the application:
   ```bash
   java -cp out Main
   ```

## 🛠️ Usage

1. Start the application using the command above
2. Follow the on-screen menu to:
   - Register/Login users
   - Browse available cars
   - Make bookings
   - View booking history
   - Manage car inventory (admin functions)

## 🧪 Testing

To run tests (if available):

```bash
# Using Maven
mvn test
```

## 🤝 Contributing

Contributions are welcome! Please follow these steps:

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 👏 Acknowledgments

- Built with ❤️ using Java
- Follows clean code and OOP principles
- Perfect for learning Java programming concepts

---

Made with 💻 by [Your Name] | [GitHub Profile](https://github.com/yourusername)
