package utils;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static utils.PreconditionsCheck.validate;

/** Searches for criteria given in a format of {@link Predicate} in given list. */
public final class LookupUtil {

  private LookupUtil() {}

  /** Limits the given list to items which conforms search criteria given in a form of predicate. */
  public static final <T> List<T> lookupInList(List<T> list, Predicate<T> predicate) {
    validate(list);
    try {
      return list.stream().filter(predicate).collect(Collectors.toList());
    } catch (RuntimeException e) {
      return list;
    }
  }
}
