package ru.tinkoff.edu.java.domain;

import java.util.List;

public interface LinkRepository {
    Link addLink(Link link);
    void removeLinkById(int id);
    List<Link> findAllLinks();
}
