package org.parasoft.parabank.register;

import org.junit.jupiter.api.Test;
import org.parasoft.parabank.home.HomePage;

public class RegisterTest {

    @Test
    public void shouldRegisterAccountWithSuccess() {
        HomePage homePage = new HomePage();
        RegisterPage registerPage = homePage.registerNewCustomer();
        registerPage.close();
    }
}
