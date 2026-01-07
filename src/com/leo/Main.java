package com.leo;

import com.leo.booking.BookingService;
import com.leo.car.CarService;

public class Main {

    public static  void main(String[] args) {
        BookingService bookingService = new BookingService();
        CarService carService = new CarService(bookingService.getBookingDAO());
        MenuService menuService = new MenuService(bookingService, carService);
        menuService.displayMenu();

    }
}