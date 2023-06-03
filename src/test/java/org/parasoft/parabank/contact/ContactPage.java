package org.parasoft.parabank.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.parasoft.parabank.PageObject;

public class ContactPage extends PageObject {

    public static final String URL_CONTACT = "https://parabank.parasoft.com/parabank/contact.htm";

    private final By nameInput = By.id("name");
    private final By emailInput = By.id("email");
    private final By phoneInput = By.id("phone");
    private final By messageInput = By.id("message");
    private final By sendButton = By.cssSelector("#contactForm input[type=\"submit\"]");
    private final By feedbackMessage = By.cssSelector("#rightPanel > p:nth-child(2)");

    private static String name;

    public ContactPage(WebDriver browser) {
        super(browser);
    }

    public void fillTheContactForm(String name, String email, String phone, String message) {
        ContactPage.name = name;

        insertText(nameInput, ContactPage.name);
        insertText(emailInput, email);
        insertText(phoneInput, phone);
        insertText(messageInput, message);
    }

    public void contact() {
        clickOnButton(sendButton);
    }

    public boolean isMessageDisplayed() {
        return isElementDisplayed(feedbackMessage);
    }

    public boolean isCurrentPage() {
        return getUrl().equals(URL_CONTACT);
    }
}
