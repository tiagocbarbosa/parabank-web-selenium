package org.parasoft.parabank.overview;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.parasoft.parabank.home.HomePage;
import org.parasoft.parabank.register.RegisterPage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OverviewTest {

    private OverviewPage overviewPage;

    @AfterEach
    public void afterEach() {
        this.overviewPage.close();
    }

    @Test
    public void shouldLoginWithSuccess() {
        HomePage homePage = new HomePage(null);
        RegisterPage registerPage = homePage.navigateToRegisterPage();

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
        registerPage.fillTheRegisterForm(firstName, lastName, street, city, state, zipCode, phoneNumber, ssn,
                username, password);
        registerPage.registerAccount();

        homePage = registerPage.navigateToHomePage();
        homePage.fillLogInForm(username, password);
        this.overviewPage = homePage.logIn();

        Assertions.assertTrue(this.overviewPage.isCurrentPage());
        Assertions.assertTrue(this.overviewPage.isFullNameDisplayed(firstName, lastName));
        Assertions.assertTrue(this.overviewPage.isBalanceDisplayed());
        Assertions.assertTrue(this.overviewPage.isLogOutButtonDisplayed());
    }
}
