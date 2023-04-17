package ru.tinkoff.edu.java.domain;

import java.util.List;

public class LinkService {
    private final LinkDao linkDao;

    public LinkService(LinkDao linkDao) {
        this.linkDao = linkDao;
    }

    public void addLink(Link link) {
        linkDao.add(link);
    }

    public void removeLink(int id) {
        linkDao.remove(id);
    }

    public List<Link> findAllLinks() {
        return linkDao.findAll();
    }
}