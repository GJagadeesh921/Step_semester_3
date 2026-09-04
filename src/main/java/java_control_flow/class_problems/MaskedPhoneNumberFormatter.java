import java.util.*;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {

        // Check length
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Check whether all characters are digits
        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Get last 4 digits
        String lastFourDigits = phone.substring(6);

        // Build masked number
        StringBuilder result = new StringBuilder("XXXXXX");

        result.insert(6, "-" + lastFourDigits);

        return result.toString();
    }

    public static void main(String[] args) {

        String phone = "9876543210";

        System.out.println(maskPhoneNumber(phone));
    }
}
