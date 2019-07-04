package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Conexion {
    static WebDriver driver;

    public static WebDriver creaConexion(String browser){
        driver = null;
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
