package org.example;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.example.BasePage.driver;
public class DriverManager extends Utils {
    String browserName = "chrome";

    public void openBrowser() {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
            //open chrome
            driver = new ChromeDriver();
        } else if
        (browserName.equalsIgnoreCase("firefox")) {
        System.setProperty("webdriver.gecko.driver", "src/test/java/drivers/geckodriver.exe");
        //open firefox
        driver = new FirefoxDriver();
       }else if
            (browserName.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "src/test/java/drivers/msedgedriver.exe");
            //open Edge
            driver = new EdgeDriver();
        }else {
            System.out.println("your browser name is wrong or not provided" +browserName);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com");
    }

        public void closeBrowser
                () {
            driver.quit();
        }

    }

