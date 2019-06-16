package core.service;

import pojos.Comment;
import pojos.Post;
import pojos.User;

import java.util.List;

/** Service for direct interactions with RESTful service. */
public interface RestService {
  List<User> getUsers();

  List<Post> getPosts();

  List<Comment> getComments();
}
