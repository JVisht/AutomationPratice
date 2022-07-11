package base.base;


import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.LoginPages;
import reporting.ExtentManager;
import reporting.ExtentTestManager;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class CommonAPI {



    String currentDir = System.getProperty("user.dir");
    String browserstackUsername = "jayvisht_Pfk9Q0";
    String browserstackPassword = "1LU5jNBFxmiUzHqGsqeT";
    String saucelabsUsername = "";
    String saucelabsPassword = "";


    public WebDriver driver;
    

        public static com.relevantcodes.extentreports.ExtentReports extent;

        @BeforeSuite
        public void extentSetup(ITestContext context) {
        ExtentManager.setOutputDirectory(context);
        extent = ExtentManager.getInstance();
    }

        @BeforeMethod

        public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        String methodName = method.getName().toLowerCase();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }
        protected String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        t.printStackTrace(pw);
        return sw.toString();
    }

        @AfterMethod
        public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(getTime(result.getEndMillis()));

        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
        }
        ExtentTestManager.endTest();
        extent.flush();
//            String takeScreenshot;
//            if (takeScreenshot.equalsIgnoreCase("true")){
//            if (result.getStatus() == ITestResult.FAILURE) {
//                takeScreenshot(result.getName());
//            }
//        }
        driver.quit();
    }

        @AfterSuite
        public void generateReport() {
        extent.close();
    }

        private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
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
            driver = new RemoteWebDriver(new URL("http://" + username + ":" + password + "@hub-cloud.browserstack.com:80/wd/hub"), cap);
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
                      @Optional("https://www.google.com") String url ) throws MalformedURLException {
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
           driver.get(url);

       }
//       @AfterMethod
//       public void tearDown(){
//        driver.close();
//       }
//
public WebDriver getDriver(){
    return driver;
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
        public void typeAndEnter(WebElement element, String text){
        element.sendKeys(text, Keys.ENTER);
       }
            public boolean isPresent(WebElement element) {
                   return element.isDisplayed();
                }

         public void hoverOver(WebElement element,String text) {
             Actions actions =new Actions(driver);
             actions.moveToElement(element).build().perform();
        }




    }
