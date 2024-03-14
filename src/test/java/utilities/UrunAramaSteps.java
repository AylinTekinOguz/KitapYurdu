package utilities;

import elements.Elements;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static utilities.Driver.appiumDriver;

public class UrunAramaSteps {
    private Logger logger = LoggerFactory.getLogger(getClass());

    ReusableMethods methods = new ReusableMethods();
    Elements elements = new Elements();

    @When("Ara butonuna tiklanir")
    public void araButonunaTiklanir() throws InterruptedException {
        methods.tikla(elements.araButonu);
    }

    @When("Arama kutusuna {string} yazilir")
    public void aramaKutusunaYazilir(String arg0) throws InterruptedException {
        methods.visibleElement(elements.searchBox);
        methods.tikla(elements.searchBox);
        methods.elementeYaz(elements.searchBox, arg0);
        methods.tikla(elements.harryPotter);
    }

    @Then("Arama sonuclarinin {string} icerdigi dogrulanir")
    public void aramaSonuclarininIcerdigiDogrulanir(String arg0) {
        methods.visibleElement(elements.aramaSonuclari);
        Assert.assertTrue(appiumDriver.findElement(elements.aramaSonuclari).getText().contains(arg0));
    }
}
