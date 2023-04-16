package ru.tinkoff.edu.java.domain;

import java.util.List;

public interface UserRepository {
    User addUser(User user);
    void removeUserById(int id);
    List<User> findAllUsers();
}
