package utilities;

import com.github.javafaker.Faker;
import elements.Elements;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.Duration.ofMillis;
import static utilities.Driver.appiumDriver;

public class ReusableMethods {

    private Logger logger = LoggerFactory.getLogger(getClass());

    Elements elements = new Elements();
    Faker faker = new Faker(Locale.forLanguageTag("TR"));

    public void tikla(By element) throws InterruptedException {
        visibleElement(element);
        appiumDriver.findElement(element).click();
        logger.info("Elemente tıklandı");

    }

    public void elementeYaz(By locator, String value) {
        appiumDriver.findElement(locator).sendKeys(value);
        logger.info(locator + " elementine " + " değeri yazıldı.");

    }

    public void bekle(int saniye) throws InterruptedException {
        Thread.sleep(1000 * saniye);

    }

    public String getText(By locater) {
        WebElement element = appiumDriver.findElement(locater);
        String text = element.getText();
        return text;
    }

    public List<WebElement> findAll(By locator) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 10);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));


    }

    public  void visibleElement(By locator) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void listtenRandomSec(By element) throws InterruptedException {
        List<WebElement> list = findAll(element);
        int elementCount = list.size();
        Random random = new Random();
        int randomValueOfElements = random.nextInt(elementCount);
        list.get(randomValueOfElements).click();
        bekle(2);
    }

    public  void swipeUpAccordingToPhoneSize() {
        if (appiumDriver instanceof AndroidDriver) {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;
            System.out.println("Android1 : " + width + " - " + height);
            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 60) / 100;
            int swipeEndHeight = (height * 20) / 100;
            System.out.println("Start width: " + swipeStartWidth + " - Start height: " + swipeStartHeight + " - End height: " + swipeEndHeight);
            //appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeEndHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeStartHeight))
                    .release()
                    .perform();
        } else {
            Dimension d = appiumDriver.manage().window().getSize();
            int height = d.height;
            int width = d.width;

            int swipeStartWidth = width / 2, swipeEndWidth = width / 2;
            int swipeStartHeight = (height * 40) / 100;
            int swipeEndHeight = (height * 20) / 100;
            // appiumDriver.swipe(swipeStartWidth, swipeStartHeight, swipeEndWidth, swipeEndHeight, 1000);
            new TouchAction(appiumDriver)
                    .press(PointOption.point(swipeStartWidth, swipeStartHeight))
                    .waitAction(WaitOptions.waitOptions(ofMillis(1000)))
                    .moveTo(PointOption.point(swipeEndWidth, swipeEndHeight))
                    .release()
                    .perform();
        }
    }




}
