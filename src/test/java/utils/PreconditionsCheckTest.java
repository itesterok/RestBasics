package utils;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static utils.PreconditionsCheck.validate;

public class PreconditionsCheckTest {

  @Test
  public void handlesPositiveCase() {
    String someObject = "I'm cool object";
    assertThat(validate(someObject)).isTrue();
  }

  @Test
  public void handlesNegativeCase() {
    String someObject = null;

    IllegalArgumentException e =
        assertThrows(IllegalArgumentException.class, () -> validate(someObject));

    assertThat(e).hasMessageThat().isEqualTo("Value can't be empty!");
  }
}
