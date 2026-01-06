package com.leo.booking;

import com.leo.car.Car;
import com.leo.user.User;

public class Booking {
    private final User user;
    private final Car car;

    public Booking(User user, Car car) {
        this.user = user;
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public User getUser() {
        return user;
    }
}
