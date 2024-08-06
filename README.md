# Online Hotel Booking System

Welcome to the Online Hotel Booking System repository. This project is a Java Swing-based desktop application that allows users to search for hotels, view room details, and make reservations.

## Contents

- User registration and login
- Hotel search functionality
- Detailed hotel and room information
- Online room reservation
- Payment integration
- Booking history for users
- Admin panel for managing hotels, rooms, and bookings

## Getting Started

To get started with the code in this repository, follow these steps:

1. **Clone the repository:**
    ```bash
    git clone https://github.com/yourusername/Online-Hotel-Booking-System.git
    cd Online-Hotel-Booking-System
    ```

2. **Install dependencies:**
    Make sure you have Java and MySQL installed on your machine.

3. **Set up the database:**
   - Create a database in MySQL.
   - Import the provided SQL file to set up the tables and initial data.

4. **Configure the database connection:**
    Update the database connection settings in the `DBConnection.java` file:
    ```java
    private static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String DB_USER = "your_database_user";
    private static final String DB_PASSWORD = "your_database_password";
    ```

5. **Run the application:**
    Compile and run the application using your preferred Java IDE or command line tools.

## Prerequisites

Make sure you have the following installed on your local machine:

- Java (version >= 8)
- MySQL
- An integrated development environment (IDE) for Java (e.g., IntelliJ IDEA, Eclipse, NetBeans)

## Usage

Once the application is running, you can use it to:

- **Home Page:** Browse and search for hotels.
- **Hotel Details:** View detailed information about a specific hotel and its rooms.
- **Booking:** Select a room and make a reservation.
- **Admin Panel:** Manage hotels, rooms, and bookings (requires admin login).

## Contributing

Contributions are welcome! If you have any improvements or new features, please follow these steps:

1. Fork the repository.
2. Create a new branch:
    ```bash
    git checkout -b feature/your-feature-name
    ```
3. Make your changes and add your features.
4. Commit your changes:
    ```bash
    git commit -m "Add your message here"
    ```
5. Push to the branch:
    ```bash
    git push origin feature/your-feature-name
    ```
6. Create a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

If you have any questions or suggestions, feel free to open an issue or contact me at [stharabi9862187405@gmail.coom](mailto:your-email@example.com).
