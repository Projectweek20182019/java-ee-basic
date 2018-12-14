package ucll.project.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

class ChromeDriverHelper {
    static ChromeDriver getDriver() {
        // Setup the Chrome driver for the whole class
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
}
