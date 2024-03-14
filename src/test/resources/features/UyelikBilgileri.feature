@UyelikBilgileri
Feature: Uyelik bilgileri degisikligi
  Background:
    Given Hesabim ikonuna tiklanir
    When Eposta alanina gecerli mail girilir
    When Sifre alanina gecerli sifre girilir
    When Giris Yap butonuna tiklanir
    When Hesap Ayarlarina tiklanir
    When Uyelik Bilgilerime tiklanir

  @İsimDegisikligi
  Scenario: İsim degisikligi
    When Ad alanindaki isim degistirilir
    When Bilgileri guncelle butonuna tiklanir
    Then Hesabiniz basariyla guncellendi mesajinin goruntulendigi dogrulanir

  @SoyisimDegisikligi
  Scenario: Soyisim degisikligi
    When Soyisim alanindaki soyisim degistirilir
    When Bilgileri guncelle butonuna tiklanir
    Then Hesabiniz basariyla guncellendi mesajinin goruntulendigi dogrulanir

  @ParaBirimiDegisikligi
  Scenario: Para Birimi degisikligi
    When Para birimi dolar secilir
    When Bilgileri guncelle butonuna tiklanir
    Then Hesabiniz basariyla guncellendi mesajinin goruntulendigi dogrulanir










