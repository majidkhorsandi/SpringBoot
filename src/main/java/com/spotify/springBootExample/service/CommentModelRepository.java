package com.spotify.springBootExample.service;

import com.spotify.springBootExample.model.CommentModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentModelRepository extends CrudRepository<CommentModel, String>{
    List<CommentModel> findByPageId(String pageId);
    List<CommentModel> findByPageIdAndSpamIsTrue(String pageId);
}
