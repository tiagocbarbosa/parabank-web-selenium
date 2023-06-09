package org.parasoft.parabank.register;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.parasoft.parabank.home.HomePage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegisterTest {

    private RegisterPage registerPage;

    @AfterEach
    public void afterEach() {
        this.registerPage.close();
    }

    @Test
    public void shouldRegisterAccountWithSuccess() {
        HomePage homePage = new HomePage(null);
        this.registerPage = homePage.navigateToRegisterPage();

        String firstName = "Fulano";
        String lastName = "da Silva";
        String street = "Street";
        String city = "City";
        String state = "State";
        String zipCode = "40000000";
        String phoneNumber = "123456789";
        String ssn = "123456";
        String currentDateAndTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyHHmmss"));
        String username = "fulano" + currentDateAndTime;
        String password = "123";
        this.registerPage.fillTheRegisterForm(firstName, lastName, street, city, state, zipCode, phoneNumber, ssn,
                username, password);
        this.registerPage.registerAccount();

        Assertions.assertTrue(this.registerPage.isCurrentPage());
        Assertions.assertTrue(this.registerPage.isRegisteredTitleDisplayed());
        Assertions.assertTrue(this.registerPage.isRegisteredMessageDisplayed());
        Assertions.assertTrue(this.registerPage.isLogOutButtonDisplayed());
    }

    @Test
    public void shouldDisplayErrors() {
        HomePage homePage = new HomePage(null);
        this.registerPage = homePage.navigateToRegisterPage();

        this.registerPage.fillTheRegisterForm("", "", "", "", "", "",
                "", "", "", "");
        this.registerPage.registerAccount();

        Assertions.assertTrue(this.registerPage.isCurrentPage());
        Assertions.assertTrue(this.registerPage.isDisplayingErrorMessages());
    }
}
