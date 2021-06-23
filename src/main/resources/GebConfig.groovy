import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver

import java.util.logging.Level

driver = {
    WebDriverManager.chromedriver().setup()
    driver = new ChromeDriver()
    driver.manage().window().maximize()
    driver
}

environments {

    'chrome' {
        driver = {
            WebDriverManager.chromedriver().setup()
            driver = new ChromeDriver()
            driver.manage().window().maximize()
            driver
        }
    }

    'IE' {
        driver = {
            WebDriverManager.iedriver().setup()
            driver = new InternetExplorerDriver()
            driver.setLogLevel(Level.WARNING)
            driver.manage().window().maximize()
            driver
        }
    }

    'firefox' {
        driver = {
            WebDriverManager.firefoxdriver().setup()
            driver = new FirefoxDriver()
            driver.setLogLevel(Level.WARNING)
            driver.manage().window().maximize()
            driver
        }
    }

}

baseNavigatorWaiting = true
atCheckWaiting = true
cacheDriver = false
autoClearCookies = true

waiting {
    timeout = 15
    retryInterval = 1
    slow { timeout = 15 }
    reallyslow { timeout = 20 }
}

