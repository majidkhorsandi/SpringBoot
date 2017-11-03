package com.spotify.springBootExample.service;

import com.spotify.springBootExample.model.CommentModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CommentServiceImpl.class, CommentModelRepository.class})
@EnableConfigurationProperties
public class CommentServiceImplTest {

  @Autowired
  private CommentModelRepository repository;

  @Autowired
  private CommentService service;

  private CommentModel model;

  @Before
  public void setup() {
    model = new CommentModel();
    model.setUsername("testuser");
    model.setId("1234");
    model.setPageId("p1");
    model.setEmailAddress("e@abc.com");
    model.setComment("comment");
    repository.deleteAll();
  }

  @Test
  public void testListNotFound() throws IOException {
    service.put(model);
    List<CommentModel> r = service.list("sdfds");
    assertTrue(r.isEmpty());
  }
}
