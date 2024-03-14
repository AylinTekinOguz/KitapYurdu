package elements;

import org.openqa.selenium.By;

public class Elements {

    public By hesabim = By.id("com.mobisoft.kitapyurdu:id/btn_ic_header_account");

    public By ePosta = By.xpath("(//android.widget.EditText[@resource-id=\"com.mobisoft.kitapyurdu:id/inputEditText\"])[1]");
    public By sifre = By.xpath("(//android.widget.EditText[@resource-id=\"com.mobisoft.kitapyurdu:id/inputEditText\"])[2]");
    public By girisYap = By.id("com.mobisoft.kitapyurdu:id/btnLogin");
    public By hesabimMail = By.id("com.mobisoft.kitapyurdu:id/textViewMail");
    public By hataMesaji = By.id("com.mobisoft.kitapyurdu:id/textViewDesc1");
    public By hesapAyarlari = By.xpath("//android.widget.TextView[@text=\"Hesap Ayarları\"]");
    public By uyelikBilgileri = By.id("com.mobisoft.kitapyurdu:id/btnAccountInfo");
    public By ad = By.id("com.mobisoft.kitapyurdu:id/nameText");
    public By soyAd = By.id("com.mobisoft.kitapyurdu:id/surnameText");
    public By dogumTarihi = By.id("com.mobisoft.kitapyurdu:id/birthDateButton");
    public By paraBirimi = By.id("com.mobisoft.kitapyurdu:id/currencySpinner");
    public By dolar = By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"US Dollar\"]");
    public By bilgileriGuncelle = By.id("com.mobisoft.kitapyurdu:id/updateButton");
    public By hesapGuncellendi = By.xpath("//android.widget.Toast[@text=\"Hesabınız başarıyla güncellendi\"]");
    public By araButonu = By.id("com.mobisoft.kitapyurdu:id/navigation_search");
    public By searchBox = By.id("com.mobisoft.kitapyurdu:id/searchEditText");
    public By harryPotter = By.xpath("//android.widget.TextView[@resource-id=\"com.mobisoft.kitapyurdu:id/list_content\" and @text=\"harry potter\"]");

    public By aramaSonuclari = By.id("com.mobisoft.kitapyurdu:id/back_button_center_text");



















}
