package core;

import core.service.RestService;
import pojos.Comment;
import pojos.Post;
import pojos.User;

import java.util.ArrayList;
import java.util.List;

import static utils.LookupUtil.lookupInList;
import static utils.PreconditionsCheck.validate;

/** Http client which allows communication with {@link "https://jsonplaceholder.typicode.com}. */
public final class SimpleHttpClient {

  private RestService service;

  public SimpleHttpClient(RestService service) {
    this.service = service;
  }

  public final List<User> getUsers() {
    return service.getUsers();
  }

  /**
   * Gets user by username.
   *
   * <p>Pay attention. Instead of exception throwing, this method might return null value in case no
   * match is found.
   */
  public final User getUserByUsername(String username) {
    validate(username);
    return lookupInList(getUsers(), user -> user.getUsername().equals(username)).stream()
        .findAny()
        .orElseGet(null);
  }

  public final List<Post> getPosts() {
    return service.getPosts();
  }

  public final List<Post> getPostsByUser(User user) {
    validate(user);
    return lookupInList(getPosts(), post -> post.getUserId() == user.getId());
  }

  public final List<Comment> getComments() {
    return service.getComments();
  }

  public final List<Comment> getCommentsToPosts(List<Post> posts) {
    validate(posts);
    List<Comment> comments = new ArrayList<>();
    posts.forEach(
        post -> {
          List<Comment> commentsForThePost =
              lookupInList(getComments(), comment -> comment.getPostId() == post.getId());
          comments.addAll(commentsForThePost);
        });
    return comments;
  }
}
