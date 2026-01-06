package leo.carbooking.user;

import java.util.UUID;

/**
 * Represents a user in the car booking system.
 *
 * <p>Java record providing immutable data storage with auto-generated:
 * - Private final fields
 * - Public constructor
 * - Accessor methods (id(), name())
 * - equals(), hashCode(), and toString()
 *
 * @param id   Unique user identifier (UUID)
 * @param name User's full name
 */

public record User (UUID id, String name){}
