package ru.tinkoff.edu.java.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class LinkRepositoryImpl implements LinkRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LinkRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Link addLink(Link link) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update("INSERT INTO links(user_id, link) VALUES (?, ?)", link.userId(), link.link(), keyHolder);
        int id = (int) keyHolder.getKeys().get("id");
        return new Link(id, link.userId(), link.link());
        }
    @Override
    public void removeLinkById(int id) {
        jdbcTemplate.update("DELETE FROM links WHERE id = ?", id);
    }

    @Override
    public List<Link> findAllLinks() {
        return jdbcTemplate.query("SELECT * FROM links", (rs, rowNum) ->
                new Link(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getString("link")
                )
        );
    }
}

