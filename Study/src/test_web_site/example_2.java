package test_web_site;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class example_2 {
    public static void main(String[] args) {
        // Write your code here.
        //System.out.println("Hello");
        System.setProperty("webdriver.gecko.driver","D:\\Complementos, plugin, etc\\geckodriver-v0.23.0-win64\\geckodriver.exe" );
        WebDriver obj = new FirefoxDriver();
        obj.get("http://www.google.com");
    }
}
