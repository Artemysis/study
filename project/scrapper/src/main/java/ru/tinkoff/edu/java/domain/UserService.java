package ru.tinkoff.edu.java.domain;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.add(user);
    }

    public void removeUser(int id) {
        userDao.remove(id);
    }

    public List<User> findAllUsers() {
        return userDao.findAll();
    }
}