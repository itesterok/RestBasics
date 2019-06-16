package core.service;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojos.Comment;
import pojos.Post;
import pojos.User;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static utils.PreconditionsCheck.validate;

/** Interacts with {@link https://jsonplaceholder.typicode.com}. */
public class RestServiceImpl implements RestService {

  private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
  private static final String GET_USERS_URI = "/users";
  private static final String GET_POSTS_URI = "/posts";
  private static final String GET_COMMENTS_URI = "/comments";

  public Response getResponse(URL url) {
    return RestAssured.get(url);
  }

  public <T> T getResponseAs(URL url, Class<T> clazz) {
    Response response = getResponse(url);
    return response.getBody().as(clazz);
  }

  @Override
  public List<User> getUsers() {
    return Arrays.asList(getResponseAs(createUrl(BASE_URL + GET_USERS_URI), User[].class));
  }

  @Override
  public final List<Post> getPosts() {
    return Arrays.asList(getResponseAs(createUrl(BASE_URL + GET_POSTS_URI), Post[].class));
  }

  @Override
  public final List<Comment> getComments() {
    return Arrays.asList(getResponseAs(createUrl(BASE_URL + GET_COMMENTS_URI), Comment[].class));
  }

  private URL createUrl(String url) {
    validate(url);
    try {
      return new URL(url);
    } catch (MalformedURLException e) {
      throw new Error("Wrong endpoint!", e);
    }
  }
}
