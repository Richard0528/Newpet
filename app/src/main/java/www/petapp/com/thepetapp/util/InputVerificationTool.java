package www.petapp.com.thepetapp.util;


import android.text.TextUtils;

import java.util.regex.Pattern;

/**
 * Utility class to check is the username, first name, last name, password, email
 * match the requirement
 * @author Matthew Chen
 */
public class InputVerificationTool {
    /**
     * Regular expression
     **/
    private static final Pattern REG_EX_USERNAME = Pattern.compile("[^a-zA-Z_0-9]");
    private static final Pattern REG_EX_NAME = Pattern.compile("[^a-zA-Z]");
    /** at least 1 lower case and one upper case and one digit, only _ is allowed as special character**/
    private static final Pattern REG_EX_PASSWORD =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*(_|[^\\w])).+$");

    public static boolean isUsername(String theString) {
        if (TextUtils.isEmpty(theString)) {
            return false;
        }
        return !REG_EX_USERNAME.matcher(theString).find();
    }

    public static boolean isName(String theString) {
        if (TextUtils.isEmpty(theString)) {
            return false;
        }
        return !REG_EX_NAME.matcher(theString).find();
    }

    public static boolean isPassword(String theString) {
        if (TextUtils.isEmpty(theString)) {
            return false;
        }
        return REG_EX_PASSWORD.matcher(theString).matches();
    }

    public static boolean isEmail (final String theString) {
        if (TextUtils.isEmpty(theString)) {
            return false;
        }
        return android.util.Patterns.EMAIL_ADDRESS.matcher(theString).matches();
    }
}
