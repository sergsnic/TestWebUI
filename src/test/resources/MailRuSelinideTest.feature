Feature: Mail.ru

  Background:
    Given Пользователь зашел на сайт

  Scenario:
    When Выбираем подстроку Погода в Белгороде
    And Выбираем подстроку
    And Проверяем наличие пункта меню Mail
    Then Проверяем наличие результата поиска Gismeteo
