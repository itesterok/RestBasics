package core;

import org.junit.Before;
import org.junit.Test;
import pojos.User;

import static com.google.common.truth.Truth.assertThat;

public class SimpleHttpClientTest {

  private SimpleHttpClient simpleHttpClient;

  @Before
  public void setUp() {
    simpleHttpClient = SimpleHttpClient.getInstance();
  }

  @Test
  public void usersListIsFetched() {
    User user1 = simpleHttpClient.getUsers().get(0);
    User user2 = simpleHttpClient.getUsers().get(0);
    boolean d = user1.equals(user2);
    assertThat(simpleHttpClient.getUsers()).hasSize(10);
  }

  @Test
  public void postsListIsFetched() {
    assertThat(simpleHttpClient.getPosts()).hasSize(10);
  }
}
