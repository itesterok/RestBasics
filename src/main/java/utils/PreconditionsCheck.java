package utils;

/** Performs required checks for arguments. */
public final class PreconditionsCheck {

  private PreconditionsCheck() {}

  public static final <T> boolean validate(T value) {
    if (value == null) {
      throw new IllegalArgumentException("Value can't be empty!");
    }
    return true;
  }
}
