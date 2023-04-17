package ru.tinkoff.edu.java.domain;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class MyService {
private final TransactionTemplate transactionTemplate;
private final UserDao userDao;
private final LinkDao linkDao;
public MyService(TransactionTemplate transactionTemplate, UserDao userDao, LinkDao linkDao) {
    this.transactionTemplate = transactionTemplate;
    this.userDao = userDao;
    this.linkDao = linkDao;
}

@Transactional
public void addUserAndLinks(User user, List<Link> links) {
    userDao.add(user);
    for (Link link : links) {
        linkDao.add(link);
    }
}

public List<User> findAllUsers() {
    return userDao.findAll();
}

public List<Link> findAllLinks() {
    return linkDao.findAll();
}
}
