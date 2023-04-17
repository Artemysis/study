package ru.tinkoff.edu.java.domain;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class LinkDao {
    private final JdbcTemplate jdbcTemplate;

    public LinkDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(Link link) {
        jdbcTemplate.update("INSERT INTO links (id, user_id, link) VALUES (?, ?, ?)",
                link.id(), link.userId(), link.link());
    }

    public void remove(int id) {
        jdbcTemplate.update("DELETE FROM links WHERE id = ?", id);
    }

    public List<Link> findAll() {
        return jdbcTemplate.query("SELECT * FROM links",
                (rs, rowNum) -> new Link(rs.getInt("id"), rs.getInt("user_id"), rs.getString("link")));
    }
}