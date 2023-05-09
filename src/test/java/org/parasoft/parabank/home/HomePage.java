package org.parasoft.parabank.home;

import org.openqa.selenium.By;
import org.parasoft.parabank.PageObject;
import org.parasoft.parabank.register.RegisterPage;

public class HomePage extends PageObject {

    public static final String URL_HOME = "https://parabank.parasoft.com/parabank/index.htm";

    public HomePage() {
        super(null);
        browser.navigate().to(URL_HOME);
    }

    public RegisterPage registerNewCustomer() {
        browser.findElement(By.xpath("//a[contains(.,'Register')]")).click();
        return new RegisterPage(browser);
    }
}
