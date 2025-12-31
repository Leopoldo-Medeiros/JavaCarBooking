package leo.carbooking.booking;

import leo.carbooking.car.Car;
import leo.carbooking.car.CarDAO;
import leo.carbooking.user.User;
import leo.carbooking.user.UserDAO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookingService {

    private final BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public void bookCar(UUID userId, String regNumber) {
        // 1. Find the user
        User user = null;
        for(User currentUser : UserDAO.getUsers()) {
            if(currentUser.getId().equals(userId)) {
                user = currentUser;
                break;
            }
        }

        // 🚩I had to FIX: Stop the process if user is null!
        if (user == null) {
            System.out.println("❌ User with ID " + userId + " not found");
            return;
        }

        // 2. Find the car
        Car car = null;
        
        // Loop through each car in the list
        for(Car currentCar : CarDAO.getCar()) {
            // Check if the current car's registration number matches the one we're looking for
            if (currentCar.getRegNumber().equals(regNumber)) {
                // If found, store the reference to this car
                car = currentCar;
                // Exit the loop early since we found our car
                break;
            }
        }

        if(car == null) {
            System.out.println("❌ Car with reg " + regNumber + " not found");
            return;
        }

        // 3. Check availability (Using your nice new helper!)
        if (isCarBooked(regNumber)) {
            System.out.println("❌ Car " + regNumber + " is already booked");
            return;
        }

        // 4. Create and Save
        bookingDAO.save(new Booking(user, car));
        System.out.println("✅ Successfully booked " + car.getBrand() + " for " + user.getName());
    }

    public Booking[] getBookings() {
        return bookingDAO.getAllBookings();
    }

    public void printUserBookings(UUID userId) {
        boolean found = false;
        for(Booking b : bookingDAO.getAllBookings()) {

            // Here we need to check if the booking exists and if it belongs to the user ID
            if(b != null && b.getUser().getId().equals(userId)) {
                System.out.println(b.getCar().getBrand() + " [" + b.getCar().getRegNumber() + "]" );
                found = true;
            }
        }
        if(!found) {
            System.out.println("❌No bookings found for user with ID: " + userId);
        }
    }

    // Adding Helper
    // It checks if a car with a specific regNumber is booked
    public boolean isCarBooked(String regNumber) {
        // Let's check all bookings in the system
        for (Booking booking : bookingDAO.getAllBookings()) {
            // Checking if the booking exists and if the car's regNumber matches the given regNumber
            if (booking != null && booking.getCar().getRegNumber().equals(regNumber)) {
                return true; // Booked
            }
        }
        return false; // Not booked
    }
    
    // Returns an array of all available (not booked) cars
    public Car[] getAvailableCars() {
        // Initialize an empty list to store available cars
        List<Car> availableCars = new ArrayList<>();
        
        // Loop through all cars in the system
        for (Car car : CarDAO.getCar()) {
            // Check if the car exists and is not currently booked
            if (car != null && !isCarBooked(car.getRegNumber())) {
                // Add the available car to our list
                availableCars.add(car);
            }
        }
        // Convert the list to an array and return it
        return availableCars.toArray(new Car[0]);
    }
    
    // Returns an array of all available electric cars
    public Car[] getAvailableElectricCars() {
        // Initialize an empty list to store electric cars
        List<Car> electricCars = new ArrayList<>();
        
        // Loop through all cars in the system
        for (Car car : CarDAO.getCar()) {
            // Check if the car exists, is electric, and not currently booked
            if (car != null && car.isElectric() && !isCarBooked(car.getRegNumber())) {
                // Add the available electric car to our list
                electricCars.add(car);
            }
        }
        // Convert the list to an array and return it
        return electricCars.toArray(new Car[0]);
    }
}
