package org.parasoft.parabank.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.parasoft.parabank.PageObject;
import org.parasoft.parabank.contact.ContactPage;
import org.parasoft.parabank.overview.OverviewPage;
import org.parasoft.parabank.register.RegisterPage;

public class HomePage extends PageObject {

    public static final String URL_HOME = "https://parabank.parasoft.com/parabank/index.htm";

    public HomePage(WebDriver browser) {
        super(browser);
        this.browser.navigate().to(URL_HOME);
    }

    public RegisterPage navigateToRegisterPage() {
        browser.findElement(By.xpath("//a[contains(.,'Register')]")).click();
        return new RegisterPage(browser);
    }

    public ContactPage navigateToContactPage() {
        browser.findElement(By.xpath("//a[contains(.,'contact')]")).click();
        return new ContactPage(browser);
    }

    public void fillLoginForm(String username, String password) {
        this.browser.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(username);
        this.browser.findElement(By.xpath("//input[contains(@type,'password')]")).sendKeys(password);
    }

    public OverviewPage login() {
        this.browser.findElement(By.xpath("//input[contains(@type,'password')]")).submit();
        return new OverviewPage(this.browser);
    }
}
