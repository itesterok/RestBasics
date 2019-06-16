package core.service;

import java.util.List;
import pojos.Comment;
import pojos.Post;
import pojos.User;

/** Service for direct interactions with RESTful service. */
public interface RestService {
  List<User> getUsers();

  List<Post> getPosts();

  List<Comment> getComments();
}
