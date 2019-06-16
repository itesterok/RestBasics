package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Validates emails according to the pattern specified. */
public final class EmailValidator {

  private static final Pattern VALID_EMAIL_PATTERN =
      Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$");

  private EmailValidator() {}

  public static boolean validateEmail(String email) {
    try {
      Matcher matcher = VALID_EMAIL_PATTERN.matcher(email);
      return matcher.matches();
    } catch (RuntimeException e) {
      return false;
    }
  }
}
