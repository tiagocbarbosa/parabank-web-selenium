package org.parasoft.parabank.contact;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.parasoft.parabank.PageObject;

public class ContactPage extends PageObject {

    public static final String URL_CONTACT = "https://parabank.parasoft.com/parabank/contact.htm";
    private static String name;

    public ContactPage(WebDriver browser) {
        super(browser);
    }

    public void fillTheContactForm(String name, String email, String phone, String message) {
        ContactPage.name = name;

        this.browser.findElement(By.id("name")).sendKeys(ContactPage.name);
        this.browser.findElement(By.id("email")).sendKeys(email);
        this.browser.findElement(By.id("phone")).sendKeys(phone);
        this.browser.findElement(By.id("message")).sendKeys(message);
    }

    public void contact() {
        this.browser.findElement(By.xpath("//input[contains(@value,'Send to Customer Care')]")).click();
    }

    public boolean isMessageDisplayed() {
        return this.browser.findElement(By.xpath("//p[contains(.,'Thank you " + ContactPage.name + "')]")).isDisplayed();
    }

    public boolean isCurrentPage() {
        return this.browser.getCurrentUrl().equals(URL_CONTACT);
    }
}
