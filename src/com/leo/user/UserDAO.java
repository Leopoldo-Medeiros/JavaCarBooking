package com.leo.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDAO {
    private static final User[] users;

    static {
        users = new User[]{
                new User(UUID.fromString("8ca51d2b-aaaf-4bf2-834a-e02964e10fc3"), "Pedro"),
                new User(UUID.fromString("b10d126a-3608-4980-9f9c-aa179f5cebc3"), "Luciana")
        };
    }

    public static User[] getUsers() {
        return users;
    }

    public List<User> findUserByName(String name) {
        // ArrayList to store matching users
        List<User> matchingUsers = new ArrayList<>();

        // Loop through all users
        for (User user : users) {
            // Here I am checking if the user's name is matching to the given name
            if (user.name().equalsIgnoreCase(name)) {
                matchingUsers.add(user);
            }
        }
        return matchingUsers;
    }
    public User findUserById(UUID id) {
            if (id == null) {
                return null;
            }

            for (User user : users) {
                // Here I am checking if the user's ID is matching to the given ID
                // As I am using Records it's fine to use only "user.id", no need to use "user.getId"
                // Using "user.getId()" would be needed if I was using final
                if (id.equals(user.id())) {
                    return user;
                }
            }
            return null;
        }
    }
