package scrapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ru.tinkoff.edu.java.domain.Link;
import ru.tinkoff.edu.java.domain.LinkDao;
import ru.tinkoff.edu.java.scrapper.ScrapperApplication;

@SpringBootTest(classes = ScrapperApplication.class)
public class LinkDaoTest extends IntegrationEnvironment {

    @Autowired
    private LinkDao linkDao;
    

    @Transactional
    @Rollback
    @Test
    void addTest() {
        Link link = new Link(1, 1, "https://www.example.com");
        linkDao.add(link);
        List<Link> links = linkDao.findAll();
        assertEquals(1, links.size());
        assertEquals(link, links.get(0));
    }}
