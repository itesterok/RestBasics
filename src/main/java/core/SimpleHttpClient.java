package core;

import io.restassured.response.Response;
import pojos.Comment;
import pojos.Post;
import pojos.User;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.get;
import static utils.LookupUtil.lookupInList;
import static utils.PreconditionsCheck.validate;

/** Http client which allows communication with {@link "https://jsonplaceholder.typicode.com}. */
public final class SimpleHttpClient {
  private static final String GET_USERS_URI = "/users";
  private static final String GET_POSTS_URI = "/posts";
  private static final String GET_COMMENTS_URI = "/comments";
  private static URL baseUrl;
  private static SimpleHttpClient simpleHttpClient;

  private SimpleHttpClient() {}

  public static SimpleHttpClient getInstance() {
    if (simpleHttpClient == null) {
      try {
        baseUrl = new URL("https://jsonplaceholder.typicode.com");
      } catch (MalformedURLException e) {
        throw new Error("Wrong endpoint!", e);
      }
      simpleHttpClient = new SimpleHttpClient();
    }
    return simpleHttpClient;
  }

  public final List<User> getUsers() {
    Response response = get(baseUrl + GET_USERS_URI);
    return Arrays.asList(response.getBody().as(User[].class));
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
    Response response = get(baseUrl + GET_POSTS_URI);
    return Arrays.asList(response.getBody().as(Post[].class));
  }

  public final List<Post> getPostsByUser(User user) {
    validate(user);
    return lookupInList(getPosts(), post -> post.getUserId() == user.getId());
  }

  public final List<Comment> getComments() {
    Response response = get(baseUrl + GET_COMMENTS_URI);
    return Arrays.asList(response.getBody().as(Comment[].class));
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
