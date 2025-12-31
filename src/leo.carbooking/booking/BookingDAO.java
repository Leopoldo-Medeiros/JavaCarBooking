package leo.carbooking.booking;

public class BookingDAO {
    // 1. Creating a constant for max capacity (something like: 100)
    private static final int MAX_CAPACITY = 100;

    // 2. Declaring the static array of Booking objects
    private static final Booking[] bookings = new Booking[MAX_CAPACITY];

    // 3. Declaring a static int to track the current number of bookings
    private static int bookingCount = 0;

    public void save(Booking booking) {
        // It assigns the booking to the array at index bookingCount
        bookings[bookingCount] = booking;
        // Increment bookingCount
        bookingCount++;
    }
    public Booking[] getAllBookings() {
        return bookings;
    }

}


