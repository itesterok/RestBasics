package core.client;

import com.google.common.collect.ImmutableList;
import core.client.SimpleHttpClient;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import pojos.Comment;
import pojos.Post;
import pojos.User;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.doReturn;

public class SimpleHttpClientTest {

  private static final User FAKE_USER = createFakeUser();
  private static final User FAKE_USER2 = createFakeUser2();
  private static final Post FAKE_POST = createFakePost();
  private static final Post FAKE_POST2 = createFakePost2();
  private static final Comment FAKE_COMMENT = createFakeComment();
  private static final Comment FAKE_COMMENT2 = createFakeComment2();
  @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();
  private SimpleHttpClient simpleHttpClient;
  @Mock private RestService service;

  private static final User createFakeUser() {
    User user = new User();
    user.setId(1);
    user.setUsername("Samantha");
    return user;
  }

  private static final User createFakeUser2() {
    User user = new User();
    user.setId(2);
    user.setUsername("Bill Smith");
    return user;
  }

  private static final Post createFakePost() {
    Post post = new Post();
    post.setId(1);
    post.setUserId(1);
    return post;
  }

  private static final Post createFakePost2() {
    Post post = new Post();
    post.setId(2);
    post.setUserId(2);
    return post;
  }

  private static final Comment createFakeComment() {
    Comment comment = new Comment();
    comment.setId(1);
    comment.setPostId(1);
    return comment;
  }

  private static final Comment createFakeComment2() {
    Comment comment = new Comment();
    comment.setId(2);
    comment.setPostId(2);
    return comment;
  }

  @Before
  public void setUp() {
    simpleHttpClient = new SimpleHttpClient(service);
  }

  @Test
  public void getUsers() {
    doReturn(ImmutableList.of(FAKE_USER, FAKE_USER2)).when(service).getUsers();
    List<User> users = simpleHttpClient.getUsers();
    assertThat(users).containsExactly(FAKE_USER, FAKE_USER2);
  }

  @Test
  public void getUserByUsername() {
    doReturn(ImmutableList.of(FAKE_USER, FAKE_USER2)).when(service).getUsers();
    User user = simpleHttpClient.getUserByUsername("Samantha");
    assertThat(user).isEqualTo(FAKE_USER);
  }

  @Test
  public void getPosts() {
    doReturn(ImmutableList.of(FAKE_POST, FAKE_POST2)).when(service).getPosts();
    List<Post> posts = simpleHttpClient.getPosts();
    assertThat(posts).containsExactly(FAKE_POST, FAKE_POST2);
  }

  @Test
  public void getPostsByUser() {
    doReturn(ImmutableList.of(FAKE_POST, FAKE_POST2)).when(service).getPosts();
    List<Post> post = simpleHttpClient.getPostsByUser(FAKE_USER);
    assertThat(post).containsExactly(FAKE_POST);
  }

  @Test
  public void getComments() {
    doReturn(ImmutableList.of(FAKE_COMMENT, FAKE_COMMENT2)).when(service).getComments();
    List<Comment> comments = simpleHttpClient.getComments();
    assertThat(comments).containsExactly(FAKE_COMMENT, FAKE_COMMENT2);
  }

  @Test
  public void getCommentsToPosts() {
    doReturn(ImmutableList.of(FAKE_COMMENT, FAKE_COMMENT2)).when(service).getComments();
    List<Comment> comments = simpleHttpClient.getCommentsToPosts(ImmutableList.of(FAKE_POST));
    assertThat(comments).containsExactly(FAKE_COMMENT);
  }
}
