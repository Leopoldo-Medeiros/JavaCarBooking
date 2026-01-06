package com.leo.car;

import com.leo.booking.BookingDAO;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final BookingDAO bookingDAO;

    // Constructor
    public CarService (BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    // Returns an array of all available (not booked) cars
    public Car[] getAvailableCars() {
        // Initialize an empty list to store available cars
        List<Car> availableCars = new ArrayList<>();

        // Loop through all cars in the system
        for (Car car : CarDAO.getCar()) {
            // Check if the car exists and not currently booked
            if (car != null && bookingDAO.isCarAvailable(car.getRegNumber())) {
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
            if (car != null && car.isElectric() && bookingDAO.isCarAvailable(car.getRegNumber())) {
                // Add the available electric car to our list
                electricCars.add(car);
            }
        }
        // Convert the list to an array and return it
        return electricCars.toArray(new Car[0]);
    }
}
