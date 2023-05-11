package org.parasoft.parabank.contact;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.parasoft.parabank.home.HomePage;

public class ContactTest {

    ContactPage contactPage;

    @AfterEach
    public void afterEach() {
        contactPage.close();
    }

    @Test
    public void shouldContactWithSuccess() {
        HomePage homePage = new HomePage(null);
        this.contactPage = homePage.navigateToContactPage();

        String name = "Fulano";
        String email = "fulano@email.com";
        String phone = "123456";
        String message = "This is a message";
        this.contactPage.fillTheContactForm(name, email, phone, message);
        this.contactPage.contact();

        Assertions.assertTrue(this.contactPage.isCurrentPage());
        Assertions.assertTrue(this.contactPage.isMessageDisplayed());
    }
}
