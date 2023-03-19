package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

class EmailCheckerTest {

    private EmailChecker emailChecker;

    @BeforeClass
    void setUp() {
        emailChecker = new EmailChecker();
    }

    /**
     * Email address variants provider.
     */
    @DataProvider
    Object[][] emailAddressProvider() {
        return new Object[][]{
                {"auser_1@gmail.com", false},
                {"Auser.1.1@gmail.com", false},
                {"1user@gmail.com", false},
                {"1zuser.@gmail.com", false},
                {"Zuser@com", false},
                {"user@gmail.c", false},
                {"zuser.@gmail.com", false},
                {"Zuser@com", false},
                {"user1@com", false},
                {"user@gmail.c", false},
                {"user@gmail.com", true}
        };
    }

    /**
     * Email address verifying test.
     *
     * @param email   address ti be verified
     * @param isValid verification result
     */
    @Test(dataProvider = "emailAddressProvider")
    public void checkEmail(String email, boolean isValid) {
       Assert.assertTrue(emailChecker.checkEmail(email) == isValid);
    }
}