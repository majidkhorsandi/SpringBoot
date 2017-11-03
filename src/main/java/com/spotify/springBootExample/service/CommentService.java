package com.spotify.springBootExample.service;

import com.spotify.springBootExample.model.CommentModel;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CommentService {
  String put(CommentModel model) throws IOException;

  List<CommentModel> list(String pageId) throws IOException;

  Optional<CommentModel> get(String id);

  List<CommentModel> listSpamComments(String pageId) throws IOException;

  void delete(String id);

}
