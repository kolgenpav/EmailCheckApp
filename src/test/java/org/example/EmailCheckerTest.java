package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailCheckerTest {

    private EmailChecker emailChecker;

    @BeforeEach
    void setUp() {
        emailChecker = new EmailChecker();
    }

    /**
     * Email address variants provider.
     */
    private static Stream<Arguments> emailAddressProvider() {
        return Stream.of(
                Arguments.of("auser_1@gmail.com", false),
                Arguments.of("Auser.1.1@gmail.com", false),
                Arguments.of("1user@gmail.com", false),
                Arguments.of("1zuser.@gmail.com", false),
                Arguments.of("Zuser@com", false),
                Arguments.of("user@gmail.c", false),
                Arguments.of("zuser.@gmail.com", false),
                Arguments.of("Zuser@com", false),
                Arguments.of("user1@com", false),
                Arguments.of("user@gmail.c", false),
                Arguments.of("user@gmail.com", true)
        );
    }

    /**
     * Email address verifying test.
     *
     * @param email   address ti be verified
     * @param isValid verification result
     */
    @DisplayName("Email address checking test")
    @ParameterizedTest(name = "Email address {0} is valid: {1}")
    @MethodSource("emailAddressProvider")
    void checkEmail(String email, boolean isValid) {
        assertTrue(emailChecker.checkEmail(email) == isValid);
    }
}