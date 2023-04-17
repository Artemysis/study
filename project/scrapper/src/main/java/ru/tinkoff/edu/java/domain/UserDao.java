package ru.tinkoff.edu.java.domain;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(User user) {
        jdbcTemplate.update("INSERT INTO users (id, chat_id, username) VALUES (?, ?, ?)",
                user.id(), user.chatId(), user.username());
    }

    public void remove(int id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users",
                (rs, rowNum) -> new User(rs.getInt("id"), rs.getInt("chat_id"), rs.getString("username")));
    }
}