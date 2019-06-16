package utils;

import static com.google.common.truth.Truth.assertThat;
import static utils.EmailValidator.validateEmail;

import org.junit.Test;

public class EmailValidatorTest {

  @Test
  public void validEmail() {
    String email = "test@gmail.com";
    assertThat(validateEmail(email)).isTrue();
  }

  @Test
  public void validEmailWithDot() {
    String email = "Lottie.Zieme@ruben.us";
    assertThat(validateEmail(email)).isTrue();
  }

  @Test
  public void invalidEmailMissedDomain() {
    String email = "test";
    assertThat(validateEmail(email)).isFalse();
  }

  @Test
  public void invalidEmailMissedUsername() {
    String email = "@blabla.com";
    assertThat(validateEmail(email)).isFalse();
  }

  @Test
  public void invalidEmailEmpty() {
    String email = "";
    assertThat(validateEmail(email)).isFalse();
  }

  @Test
  public void invalidEmailNullPointer() {
    String email = null;
    assertThat(validateEmail(email)).isFalse();
  }

  @Test
  public void invalidEmailNumbers() {
    String email = "9849843";
    assertThat(validateEmail(email)).isFalse();
  }
}
