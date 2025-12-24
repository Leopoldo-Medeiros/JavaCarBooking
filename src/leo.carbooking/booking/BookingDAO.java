package leo.carbooking.booking;

public class BookingDAO {
    // 1. Creating a constant for max capacity (something like: 100)
    private static final int MAX_CAPACITY = 100;

    // 2. Declaring the static array of Booking objects
    private static Booking[] bookings = new Booking[MAX_CAPACITY];

    // 3. Declaring a static int to track the current number of bookings
    private static int bookingCount = 0;

}
