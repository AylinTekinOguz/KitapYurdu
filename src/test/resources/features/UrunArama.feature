@UrunArama
Feature: Urun arama
  Background:
    Given Hesabim ikonuna tiklanir
    When Eposta alanina gecerli mail girilir
    When Sifre alanina gecerli sifre girilir
    When Giris Yap butonuna tiklanir


  @UrunIsmiyleArama
  Scenario: Urun ismiyle arama
    When Ara butonuna tiklanir
    When Arama kutusuna "harry potter" yazilir
    Then Arama sonuclarinin "harry potter" icerdigi dogrulanir