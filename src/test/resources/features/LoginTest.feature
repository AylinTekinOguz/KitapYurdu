@LoginTests
Feature: Login Testi
  Background:
    Given Hesabim ikonuna tiklanir

  @BasariliLogin
  Scenario: Basarili login
    When Eposta alanina gecerli mail girilir
    When Sifre alanina gecerli sifre girilir
    When Giris Yap butonuna tiklanir
    Then Giris yapildigi dogrulanir

  @YanlisEposta
  Scenario: Yanlis eposta ile login
    When Eposta alanina gecersiz mail girilir
    When Sifre alanina gecerli sifre girilir
    When Giris Yap butonuna tiklanir
    Then E-Posta Adresi ya da şifreniz yanlış mesajinin goruntulendigi dogrulanir

  @YanlisSifre
  Scenario: Yanlis sifre ile login
    When Eposta alanina gecerli mail girilir
    When Sifre alanina gecersiz sifre girilir
    When Giris Yap butonuna tiklanir
    Then E-Posta Adresi ya da şifreniz yanlış mesajinin goruntulendigi dogrulanir

  @BosEposta
  Scenario: Eposta girmeden login
    When Sifre alanina gecerli sifre girilir
    When Giris Yap butonuna tiklanir
    Then Lütfen e-posta adresinizi ve şifrenizi girin mesajinin goruntulendigi dogrulanir

  @BosSifre
  Scenario: Sifre girmeden login
    When Eposta alanina gecerli mail girilir
    When Giris Yap butonuna tiklanir
    Then Lütfen e-posta adresinizi ve şifrenizi girin mesajinin goruntulendigi dogrulanir

  @BosSifreVeEposta
  Scenario: Sifre girmeden login
    When Giris Yap butonuna tiklanir
    Then Lütfen e-posta adresinizi ve şifrenizi girin mesajinin goruntulendigi dogrulanir











