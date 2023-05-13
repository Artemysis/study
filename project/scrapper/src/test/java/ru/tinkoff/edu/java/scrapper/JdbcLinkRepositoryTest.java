//package ru.tinkoff.edu.java.scrapper;


//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.dao.DataIntegrityViolationException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.jdbc.Sql;
//import org.springframework.transaction.annotation.Transactional;
//import ru.tinkoff.edu.java.scrapper.model.Link;
//import ru.tinkoff.edu.java.scrapper.repository.jdbc.JdbcLinkRepository;
//import util.IntegrationEnvironment;

//import java.util.List;

//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertThrows;

//@Slf4j
//@SpringBootTest
//@Rollback
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class JdbcLinkRepositoryTest extends IntegrationEnvironment {

  //  @Autowired
   // JdbcTemplate jdbcTemplate;

  //  @Autowired
  //  JdbcLinkRepository linkRepository;

  //  @Test
   // @Transactional
   // @Sql({"/sql/fill_in_links.sql"})
   // public void save__LinkUrlDoesntExistInDb_addedLink() {
        // given
    //    var link = new Link().setUrl("https://meta.com");

        // when
      //  var addedLink = linkRepository.save(link);


      //  assertThat(addedLink.getUrl()).isEqualTo(link.getUrl());
   // }

   // @Test
  //  @Transactional
   // @Sql({"/sql/fill_in_links.sql"})
   // public void save__LinkUrlAlreadyExistsInDb_throwException() {
        // given
       // var link = new Link().setUrl("https://stackoverflow.com/7777777");

        // when, then
      //  assertThrows(DataIntegrityViolationException.class, () -> linkRepository.save(link));
    //}

   // @Test
  //  @Transactional
  //  @Sql("/sql/fill_in_chat_link_pairs.sql")
  //  public void removeById__LinkIsBeingTrackedInChat_throwException() {
        // given
       // var linkId = 2222;

        // when, then
      //  assertThrows(DataIntegrityViolationException.class, () -> linkRepository.removeById(linkId));
  //  }

   // @Test
   // @Transactional
   // @Sql("/sql/fill_in_links.sql")
   // public void removeById__LinkIsNotBeingTrackedInChat_oneRemovedLink() {
        // given
       // var linkId = linkRepository.findAll().get(0).getId();


        // then
      //  assertThat(linkRepository.removeById(linkId)).isTrue();

        
      //  Boolean ifRemoved = jdbcTemplate.queryForObject("SELECT COUNT(*) = 0 FROM link WHERE id = ?",
             //   Boolean.class, linkId);
     //   assertThat(ifRemoved).isTrue();
 //   }

    //@Test
   // @Transactional
   // @Sql("/sql/fill_in_links.sql") 
  //  public void findAll__SomeLinksInDb_listOfLinks() {
        // given
     //   var expectedSize = 3;

        // when
      //  List<Link> links = linkRepository.findAll();


        // then
      //  assertThat(links).hasSize(expectedSize);

   // }

   // @Test
   // @Transactional
   // public void findAll__NoLinksInDb_emptyList() {
        // when
     //   List<Link> links = linkRepository.findAll();

        // then
      //  assertThat(links).isEmpty();
//
   // }
// }