package leo.carbooking.booking;

import leo.carbooking.car.Car;
import leo.carbooking.user.User;
import java.util.UUID;

public class Booking {
    private final UUID id;
    private final User user;
    private final Car car;

    public Booking(UUID id, User user, Car car) {
        this.id = id;
        this.user = user;
        this.car = car;
    }
}
