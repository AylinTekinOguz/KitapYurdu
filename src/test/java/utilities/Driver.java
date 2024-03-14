package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    protected static AppiumDriver<MobileElement> appiumDriver;


    @Before
    public static void startUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage", "com.mobisoft.kitapyurdu");
        capabilities.setCapability("appActivity", "com.mobisoft.kitapyurdu.main.SplashActivity");
        capabilities.setCapability("platformName","Android");
        appiumDriver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);


    }

    @After
    public static void closeDriver(){
        if (appiumDriver !=null){
            appiumDriver.quit();
        }
    }
}
