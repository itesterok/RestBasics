import static com.google.common.truth.Truth.assertThat;
import static utils.EmailValidator.validateEmail;
import static utils.LookupUtil.lookupInList;

import core.client.SimpleHttpClient;
import core.service.RestServiceImpl;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import pojos.Comment;
import pojos.Post;
import pojos.User;

public class SamanthaTest {

  private SimpleHttpClient simpleHttpClient;

  @Before
  public void setUp() {
    simpleHttpClient = new SimpleHttpClient(new RestServiceImpl());
  }

  @Test
  public void noWrongEmailsInCommentsToSamanthaPosts() {
    User samantha = simpleHttpClient.getUserByUsername("Samantha");
    List<Post> samanthaPosts = simpleHttpClient.getPostsByUser(samantha);
    List<Comment> commentsToAllSamanthaPosts = simpleHttpClient.getCommentsToPosts(samanthaPosts);
    List<Comment> commentsWithWrongEmails =
        lookupInList(commentsToAllSamanthaPosts, comment -> !validateEmail(comment.getEmail()));

    assertThat(commentsWithWrongEmails).isEmpty();
  }
}
