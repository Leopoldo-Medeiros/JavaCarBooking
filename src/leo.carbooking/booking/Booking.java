package leo.carbooking.booking;

import leo.carbooking.car.Car;
import leo.carbooking.user.User;

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
