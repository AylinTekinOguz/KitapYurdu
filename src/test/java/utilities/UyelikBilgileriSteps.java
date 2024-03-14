package utilities;

import com.github.javafaker.Faker;
import elements.Elements;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

import static utilities.Driver.appiumDriver;

public class UyelikBilgileriSteps {
    private Logger logger = LoggerFactory.getLogger(getClass());

    ReusableMethods methods = new ReusableMethods();
    Elements elements = new Elements();
    Faker faker = new Faker(Locale.forLanguageTag("TR"));
    @When("Hesap Ayarlarina tiklanir")
    public void hesapAyarlarinaTiklanir() throws InterruptedException {
        methods.tikla(elements.hesapAyarlari);
    }

    @When("Uyelik Bilgilerime tiklanir")
    public void uyelikBilgilerimeTiklanir() throws InterruptedException {
        methods.tikla(elements.uyelikBilgileri);
    }

    @When("Ad alanindaki isim degistirilir")
    public void adAlanindakiIsimDegistirilir() {
        methods.visibleElement(elements.ad);
        appiumDriver.findElement(elements.ad).clear();
        methods.elementeYaz(elements.ad, faker.name().firstName());
    }

    @When("Bilgileri guncelle butonuna tiklanir")
    public void bilgileriGuncelleButonunaTiklanir() throws InterruptedException {
        methods.tikla(elements.bilgileriGuncelle);
    }

    @Then("Hesabiniz basariyla guncellendi mesajinin goruntulendigi dogrulanir")
    public void hesabinizBasariylaGuncellendiMesajininGoruntulendigiDogrulanir() throws InterruptedException {

        Assert.assertEquals(appiumDriver.findElement(elements.hesapGuncellendi).getText(), "Hesabınız başarıyla güncellendi");

    }

    @When("Soyisim alanindaki soyisim degistirilir")
    public void soyisimAlanindakiSoyisimDegistirilir() {
        methods.visibleElement(elements.soyAd);
        appiumDriver.findElement(elements.soyAd).clear();
        methods.elementeYaz(elements.soyAd, faker.name().firstName());
    }

    @When("Para birimi dolar secilir")
    public void paraBirimiDolarSecilir() throws InterruptedException {
        methods.tikla(elements.paraBirimi);
        methods.tikla(elements.dolar);
    }


}
