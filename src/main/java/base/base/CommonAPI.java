package base.base;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public  class CommonAPI {
    String currentDir = System.getProperty("user dir");
    String browserstackUsername = "jayvisht_Pfk9Q0";
    String browserstackPassword = "1LU5jNBFxmiUzHqGsqeT";
    String saucelabsUsername = "";
    String saucelabsPassword = "";
    public WebDriver driver;
    {
}
    public void getCloudDriver(String envName,String username,String password,String os,String osVersion,
                               String browser,String browserVersion) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("os", os);
        cap.setCapability("os_version", osVersion);
        cap.setCapability("browser", browser);
        cap.setCapability("browser_version", browserVersion);
        if (envName.equalsIgnoreCase("browserstack")) {
            cap.setCapability("resolution", "1024*768");
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@hub-cloud.browserstack.com80/wd/hub"), cap);
        } else if (envName.equalsIgnoreCase("saucelabs")) {
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }

    }
    public void getLocalDriver(String os,String browser) {
        if (os.equalsIgnoreCase("OS X")) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", currentDir + "/driver/mac/chromedriver");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", currentDir + "/driver/mac/geckodriver");
                driver = new FirefoxDriver();
            }

        } else if (os.equalsIgnoreCase("windows")) {
            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", currentDir + "\\driver\\windows\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", currentDir + "\\driver\\windows\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }

    }
    @Parameters  ({"useCloudEnv","envName","os","osVersion","browser","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false")boolean useCloudEnv, @Optional("browserstack") String envName ,
                      @Optional ("mac") String os,@Optional("Sierra") String osVersion,
                      @Optional ("chrome") String browser,@Optional("100") String browserVersion,
                      @Optional("https://www.google.com") String url) throws MalformedURLException {
       if (useCloudEnv) {
           if (envName.equalsIgnoreCase("browserstack")) {
               getCloudDriver(envName, browserstackUsername, browserstackPassword, os, osVersion , browser, browserVersion);
           } else if (envName.equalsIgnoreCase("saucelabs")) {
               getCloudDriver(envName, saucelabsUsername, saucelabsPassword, os, osVersion, browser, browserVersion);

           }
       }else {
           getLocalDriver(os,browser);
       }

       driver.manage().window().maximize();
           driver.get("url");

       }





        public String getPageTitle () {
            return driver.getTitle();
    }
        public String getElementText(WebElement element) {
             return element.getText();
        }
        public void click (WebElement element ){
              element.click();

            }
            public void type (WebElement element, String text) {
                element.sendKeys(text);
            }

        public void clear (WebElement element){
                element.clear();
        }

            public boolean isPresent(WebElement element) {
                   return element.isDisplayed();
                }

//                public static void main (String[]args) {
//                String path = System.getProperty("user.dir");
//                System.out.println(path+ "/driver/mac/chromedriver");
//
//                }

    }
