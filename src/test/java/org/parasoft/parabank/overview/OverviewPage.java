package org.parasoft.parabank.overview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.parasoft.parabank.PageObject;

public class OverviewPage extends PageObject {

    public static final String URL_OVERVIEW = "https://parabank.parasoft.com/parabank/overview.htm";

    public OverviewPage(WebDriver browser) {
        super(browser);
    }

    public boolean isCurrentPage() {
        return this.browser.getCurrentUrl().equals(URL_OVERVIEW);
    }

    public boolean isLogOutButtonDisplayed() {
        return this.browser.findElement(By.xpath("//a[contains(.,'Log Out')]")).isDisplayed();
    }

    public boolean isFullNameDisplayed(String firstName, String lastName) {
        return this.browser.findElement(By.xpath("//p[@class='smallText'][contains(.,'Welcome " + firstName + " " + lastName + "')]")).isDisplayed();
    }

    public boolean isBalanceDisplayed() {
        WebElement tableRow = this.browser.findElement(By.cssSelector("#accountTable tbody tr"));
        WebElement balanceColumn = tableRow.findElement(By.cssSelector("td:nth-child(2)"));

        return balanceColumn.getText().equals("$10000.00");
    }
}
