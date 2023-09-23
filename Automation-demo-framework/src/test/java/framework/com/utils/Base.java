package framework.com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import static framework.com.constants.constant.BROWSER;
import static framework.com.constants.constant.CHROME;
import static framework.com.constants.constant.FIREFOX;

public class Base {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public WebDriver initializeDriver() {
        String browser = readPropertiesFile().getProperty(BROWSER);
        if (browser.equals(CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals(FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public Properties readPropertiesFile() {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            String filepath = System.getProperty("user.dir") + "/src/test/resources/input.properties";
            File fileName = new File(filepath);
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch (IOException fnfe) {
            fnfe.printStackTrace();
        }
        return prop;
    }
}
