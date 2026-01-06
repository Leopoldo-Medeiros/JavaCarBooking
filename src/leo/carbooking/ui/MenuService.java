package leo.carbooking.ui;

import leo.carbooking.booking.BookingService;
import leo.carbooking.car.CarService;
import java.util.Scanner;
import leo.carbooking.booking.Booking;
import leo.carbooking.car.Car;
import leo.carbooking.user.User;
import leo.carbooking.user.UserDAO;

import java.util.UUID;

public class MenuService {
    private static final String DIVIDER = "---";
    private final Scanner scanner;
    private final BookingService bookingService;
    private final CarService carService;

    public MenuService(BookingService bookingService, CarService carService) {
        this.scanner = new Scanner(System.in);
        this.bookingService = bookingService;
        this.carService = carService;
    }

    public void displayMenu() {
        boolean keepRunning = true;

        while (keepRunning) {
            printMenu();
            String input = getInput("\nSelect an option: ");

            switch (input) {
                case "1" -> handleBookCar();
                case "2" -> handleUserBookings();
                case "3" -> displayAllBookings();
                case "4" -> displayAvailableCars();
                case "5" -> displayAvailableElectricCars();
                case "6" -> displayAllUsers();
                case "7" -> keepRunning = confirmExit();
                default -> System.out.println("❌ " + input + " is not a valid option");
            }
        }
        scanner.close();
    }
    
    /**
     * Displays the main menu options to the user.
     * The menu includes options for booking cars, viewing bookings, and other operations.
     */
    private void printMenu() {
        System.out.println("\n" + DIVIDER + " Car Booking System " + DIVIDER);
        System.out.println("1. Book a car");
        System.out.println("2. View my bookings");
        System.out.println("3. View all bookings");
        System.out.println("4. View available cars");
        System.out.println("5. View available electric cars");
        System.out.println("6. View all users");
        System.out.println("7. Exit");
    }

    /**
     * Handles the car booking process by collecting user input and delegating to the booking service.
     * <p>
     * This method will:
     * 1. Prompt the user for their User ID (validated as a UUID)
     * 2. Prompt for the car's registration number
     * 3. Attempt to book the car using the booking service
     *
     * @throws IllegalArgumentException if the user ID format is invalid
     * @see BookingService#bookCar(UUID, String)
     */
    private void handleBookCar() {
        try {
            UUID userId = getValidUUID();
            String regNumber = getUserInput("Enter Car Registration Number: ");
            bookingService.bookCar(userId, regNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    /**
     * Displays all bookings for a specific user by collecting their User ID.
     * <p>
     * This method will:
     * 1. Prompt the user for their User ID (validated as a UUID)
     * 2. Display all bookings associated with that user
     *
     * @throws IllegalArgumentException if the provided User ID is not a valid UUID
     * @see BookingService#printUserBookings(UUID)
     */
    private void handleUserBookings() {
        try {
            UUID userId = getValidUUID();
            bookingService.printUserBookings(userId);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Invalid User ID format. Please enter a valid UUID.");
        }
    }

    /**
     * Displays all bookings in the system in a formatted list.
     * <p>
     * This method will:
     * 1. Retrieve all bookings from the booking service
     * 2. Display a message if no bookings are found
     * 3. For each booking, show the user's name and the booked car's details
     * The output format for each booking is:
     * [User Name] has booked: [Car Brand] ([Registration Number])
     * @see BookingService#getBookings()
     * @see Booking
     */
    private void displayAllBookings() {
        System.out.println("\n" + DIVIDER + " All Bookings " + DIVIDER);
        Booking[] bookings = bookingService.getBookings();

        if (bookings.length == 0) {
            System.out.println("No bookings found.");
            return;
        }

        for (Booking booking : bookings) {
            if (booking != null) {
                Car car = booking.getCar();
                System.out.printf("%s has booked: %s (%s)%n",
                        booking.getUser().name(),
                        car.getBrand(),
                        car.getRegNumber());
            }
        }
    }

    private void displayAvailableCars() {
        System.out.println("\n" + DIVIDER + " Available Cars " + DIVIDER);
        displayCars(carService.getAvailableCars(), "No available cars at the moment.");
    }

    private void displayAvailableElectricCars() {
        System.out.println("\n" + DIVIDER + " Available Electric Cars " + DIVIDER);
        displayCars(carService.getAvailableElectricCars(), "No electric cars available at the moment.");
    }

    private static void displayCars(Car[] cars, String emptyMessage) {
        if (cars.length == 0) {
            System.out.println(emptyMessage);
            return;
        }

        for (Car car : cars) {
            System.out.printf("%s (%s)%n", car.getBrand(), car.getRegNumber());
        }
    }

    private static void displayAllUsers() {
        System.out.println("\n" + DIVIDER + " List of Users " + DIVIDER);
        User[] users = UserDAO.getUsers();

        if (users.length == 0) {
            System.out.println("No users found.");
            return;
        }

        for (User user : users) {
            System.out.printf("%s - %s%n", user.id(), user.name());
        }
    }

    /**
     * Prompts the user to enter a valid UUID.
     * @return The parsed UUID from user input
     * @throws IllegalArgumentException if the input is not a valid UUID
     */
    private static UUID getValidUUID() throws IllegalArgumentException {
        return UUID.fromString(getInput("Enter User ID: "));
    }

    private static boolean confirmExit() {
        String input = getInput("Are you sure you want to exit? (y/n): ");
        if (input.equalsIgnoreCase("y")) {
            System.out.println("\nGoodbye!");
            return true;
        }
        return false;
    }

    /**
     * Displays a prompt to the user and reads their input from the console.
     * @param prompt The message to display to the user
     * @return The user's input as a String with leading/trailing whitespace removed
     */
    private static String getUserInput(String prompt) {
        System.out.print(prompt);
        return new Scanner(System.in).nextLine().trim();
    }
    
    /**
     * Gets user input by displaying a prompt and reading from standard input.
     * @param prompt The prompt to display to the user
     * @return The user's input as a String with leading/trailing whitespace removed
     */
    private static String getInput(String prompt) {
        return getUserInput(prompt);
    }


}
