package core.service;

import static core.service.RestServiceImpl.BASE_URL;
import static core.service.RestServiceImpl.GET_COMMENTS_URI;
import static core.service.RestServiceImpl.GET_POSTS_URI;
import static core.service.RestServiceImpl.GET_USERS_URI;
import static core.service.RestServiceImpl.createUrl;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that the implementation of RestService correctly interacts with the remote host. This is
 * API test and should be considered slow.
 *
 * <p>These tests establish a contract between our app and their service. If something at their side
 * is changed, tests must fail.
 */
public class RestServiceImplTest {

  private RestServiceImpl service;

  @Before
  public void setUp() {
    service = new RestServiceImpl();
  }

  @Test
  public void validateUsersSchemaInResponse() {
    Response response = service.getResponse(createUrl(BASE_URL + GET_USERS_URI));
    response.then().assertThat().body(matchesJsonSchemaInClasspath("users-schema.json"));
  }

  @Test
  public void validatePostsSchemaInResponse() {
    Response response = service.getResponse(createUrl(BASE_URL + GET_POSTS_URI));
    response.then().assertThat().body(matchesJsonSchemaInClasspath("posts-schema.json"));
  }

  @Test
  public void validateCommentsSchemaInResponse() {
    Response response = service.getResponse(createUrl(BASE_URL + GET_COMMENTS_URI));
    response.then().assertThat().body(matchesJsonSchemaInClasspath("comments-schema.json"));
  }
}
