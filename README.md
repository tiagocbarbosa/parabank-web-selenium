# parabank-web-selenium
This project is a test automation of the [ParaBank](https://parabank.parasoft.com/parabank/index.htm), a demo site that simulates a realistic
online banking website, and it uses Selenium Webdriver and Java technologies.

Important: the automation is not covering all the website functionalities.

## Prerequisites
- JDK 11.8.18;
- Maven 3.8.1;
- Selenium Webdriver 4.9.0;
- ChromeDriver 113.0.5672.63;
- JUnit 5.9.3.

Note: the versions defined above can be equal or higher.

## Usage
To use this project, clone it on your machine and open it on your favorite IDE.

To run the test automation, you can simply run all the tests located  at the `src/test/java` dir. This is possible
because the ParaBank application is already running on a web server. 

But if you would like to run only one test case, you can open the
[`RegisterTest.java`](https://github.com/tiagocbarbosa/parabank-web-selenium/blob/main/src/test/java/org/parasoft/parabank/register/RegisterTest.java)
file as an example, and run its tests.

Once you run the tests, Selenium Webdriver will open a browser and execute the steps defined on the test file.

## References

[Selenium Webdriver documentation](https://www.selenium.dev/documentation/webdriver/)

[ParaBank website](https://parabank.parasoft.com/parabank/index.htm)

[Download the Chromedriver](https://chromedriver.chromium.org/downloads)
