package org.example;

import java.util.regex.Pattern;

/**
 * Check the correctness of the email address.
 *
 * @author Hennadii Kolomoiets
 * @see <a href="https://softserve.academy/mod/assign/view.php?id=15640">...</a>
 */
public class EmailChecker {

    /**
     * Checks the email address correctness.
     *
     * @param text email address
     * @return is email address correct
     */
    public boolean checkEmail(String text) {
        String regex = "^[A-Za-z]([A-Za-z0-9]+\\.{0,1})[^\\.]" +
                "@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.matches(regex, text);
    }
}
