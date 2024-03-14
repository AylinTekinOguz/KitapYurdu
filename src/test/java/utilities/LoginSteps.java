package utilities;

import elements.Elements;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static utilities.Driver.appiumDriver;

public class LoginSteps {

    private Logger logger = LoggerFactory.getLogger(getClass());

    ReusableMethods methods = new ReusableMethods();
    Elements elements = new Elements();
    @Given("Hesabim ikonuna tiklanir")
    public void hesabimIkonunaTiklanir() throws InterruptedException {
        methods.tikla(elements.hesabim);
    }

    @When("Eposta alanina gecerli mail girilir")
    public void epostaAlaninaGecerliMailGirilir() throws InterruptedException {
        methods.tikla(elements.ePosta);
        methods.elementeYaz(elements.ePosta, ConfigReader.getProperty("ePosta") );



    }

    @When("Sifre alanina gecerli sifre girilir")
    public void sifreAlaninaGecerliSifreGirilir() throws InterruptedException {
        methods.tikla(elements.sifre);
        methods.elementeYaz(elements.sifre, ConfigReader.getProperty("password") );

    }

    @When("Giris Yap butonuna tiklanir")
    public void girisYapButonunaTiklanir() throws InterruptedException {
        methods.tikla(elements.girisYap);
    }

    @Then("Giris yapildigi dogrulanir")
    public void girisYapildigiDogrulanir() throws InterruptedException {
        methods.bekle(5);
        Assert.assertEquals(appiumDriver.findElement(elements.hesabimMail).getText(), ConfigReader.getProperty("ePosta"));
    }

    @When("Eposta alanina gecersiz mail girilir")
    public void epostaAlaninaGecersizMailGirilir() throws InterruptedException {
        methods.tikla(elements.ePosta);
        methods.elementeYaz(elements.ePosta, ConfigReader.getProperty("gecersizMail") );
    }

    @Then("E-Posta Adresi ya da şifreniz yanlış mesajinin goruntulendigi dogrulanir")
    public void girisYapilmadigiDogrulanir() throws InterruptedException {
        methods.bekle(3);

        Assert.assertEquals(appiumDriver.findElement(elements.hataMesaji).getText(), "E-Posta Adresi ya da şifreniz yanlış. Şifrenizi girerken büyük küçük harf ayrımına dikkat ediniz.");
    }

    @When("Sifre alanina gecersiz sifre girilir")
    public void sifreAlaninaGecersizSifreGirilir() throws InterruptedException {
        methods.tikla(elements.sifre);
        methods.elementeYaz(elements.sifre, ConfigReader.getProperty("gecersizSifre") );
    }

    @Then("Lütfen e-posta adresinizi ve şifrenizi girin mesajinin goruntulendigi dogrulanir")
    public void lütfenEPostaAdresiniziVeŞifreniziGirinMesajininGoruntulendigiDogrulanir() {
        Assert.assertEquals(appiumDriver.findElement(elements.hataMesaji).getText(), "Lütfen e-posta adresinizi ve şifrenizi girin.");

    }


}
