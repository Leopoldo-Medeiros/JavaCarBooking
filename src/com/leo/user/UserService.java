package com.leo.user;

import java.util.List;
import java.util.UUID;

// This class will be used in the future
@SuppressWarnings("unused")
public class UserService {
    private final UserDAO userDAO;

    public UserService (UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User[] getAllUsers() {
        return UserDAO.getUsers();
    }

    public User findUserById(UUID id) {
        return userDAO.findUserById(id);
    }

    public List<User> findUserByName(String name) {
        return userDAO.findUserByName(name);
    }
}
