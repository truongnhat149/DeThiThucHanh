package utils;
import java.util.regex.Pattern;

public class Validation {
    public static final String PHONE_REGEX ="(^([+84]|0)[1-9])+([0-9]{8})\\b";
    public static final String EMAIL_REGEX = "^\\w+\\w*@\\w+(\\.\\w+)$";
    public static boolean isPhoneValid(String number) {
        return Pattern.compile(PHONE_REGEX).matcher(number).matches();
    }
    public static boolean isEmailValid(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }
}
