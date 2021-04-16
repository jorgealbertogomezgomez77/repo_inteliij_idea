
package test_web_site;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class example {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","D:\\Complementos, plugin, etc\\geckodriver-v0.23.0-win64\\geckodriver.exe" );
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.lawebdelprogramador.com");
        driver.close();
    }
}
