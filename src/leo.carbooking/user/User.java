package leo.carbooking.user;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String name;

    // Constructor
    public User(UUID id, String name) {
        // Assigning the values
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getId() {
        return id;
    }
}
