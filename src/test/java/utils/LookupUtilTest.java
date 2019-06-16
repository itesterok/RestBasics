package utils;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static utils.LookupUtil.lookupInList;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.Test;

public class LookupUtilTest {

  @Test
  public void filtersElementsAccordingToPredicate() {
    List<String> list = ImmutableList.of("First", "Second", "", "Third");
    assertThat(lookupInList(list, string -> !string.isEmpty()))
        .containsExactly("First", "Second", "Third");
  }

  @Test
  public void searchInNullList() {
    List<String> list = null;

    IllegalArgumentException e =
        assertThrows(
            IllegalArgumentException.class, () -> lookupInList(list, string -> !string.isEmpty()));

    assertThat(e).isNotNull();
  }
}
