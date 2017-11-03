package com.spotify.springBootExample.service;

import com.google.common.base.Strings;
import com.spotify.springBootExample.model.CommentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spotify.springBootExample.util.SpamDetector;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

  @Autowired
  private SpamDetector spamDetector;

  @Autowired
  private CommentModelRepository repository;

  @Override
  public String put(CommentModel model) throws IOException {
    if (Strings.isNullOrEmpty(model.getId())) {
      model.setId(UUID.randomUUID().toString());
    }

    if(spamDetector.containsSpam(model.getUsername()) ||
        spamDetector.containsSpam((model.getComment()))) {
      model.setSpam(true);
    }

    get(model.getId()).ifPresent(dbm -> {
      dbm.setComment(model.getUsername());
      dbm.setLastModificationDate(Calendar.getInstance());
      repository.save(dbm);
    });

    model.setCreationDate(Calendar.getInstance());
    model.setLastModificationDate(Calendar.getInstance());
    repository.save(model);

    return model.getId();
  }

  @Override
  public List<CommentModel> list(String pageId) throws IOException {
    return null;
  }

  @Override
  public Optional<CommentModel> get(String id) {
    return Optional.ofNullable(repository.findOne(id));
  }

  @Override
  public List<CommentModel> listSpamComments(String pageId) throws IOException {
    return null;
  }

  @Override
  public void delete(String id) {

  }
}
