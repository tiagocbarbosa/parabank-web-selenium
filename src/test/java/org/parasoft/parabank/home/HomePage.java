package org.parasoft.parabank.home;

import org.openqa.selenium.By;
import org.parasoft.parabank.PageObject;
import org.parasoft.parabank.contact.ContactPage;
import org.parasoft.parabank.register.RegisterPage;

public class HomePage extends PageObject {

    public static final String URL_HOME = "https://parabank.parasoft.com/parabank/index.htm";

    public HomePage() {
        super(null);
        browser.navigate().to(URL_HOME);
    }

    public RegisterPage navigateToRegisterPage() {
        browser.findElement(By.xpath("//a[contains(.,'Register')]")).click();
        return new RegisterPage(browser);
    }

    public ContactPage navigateToContactPage() {
        browser.findElement(By.xpath("//a[contains(.,'contact')]")).click();
        return new ContactPage(browser);
    }
}
