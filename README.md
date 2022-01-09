# Wikipedia
# <img src="images/logo.jpg" width="40" height="40">  Проект для мобильного приложения Wikipedia

<img src="images/wiki.in.jpg" width="800" height="600">
___

Реализован запуск автотестов на следующем окружении:

remote emulator device (Selenoid);
local emulator device (AVD);
local real device.
___

## :person_in_tuxedo: Запуск тестов происходит в CI [Jenkins](http://localhost:9090/job/08-Veronika_Monarkhovich-8_SystemTechnologies/)

<img src="images/jenkins.jpg" width="800" height="600"> 

Создаем config.properties:

```bash
src/test/resources/config/config.properties
```
Text File Content:
```bash
webUrl=https://www.st.by
remoteUrl=http://172.17.0.1:4444/wd/hub
```
Запуск тестов:
- в параметре DvideoStorage указываем место для сохранения видео
- в параметре Dbrowser задаем браузер
```bash
clean test -Dbrowser=${BROWSER} -DvideoStorage=http://localhost:8080/video/
```

Генерация отчета:
```bash
allure serve 
```
```bash
build/allure-results
```
___

## :bar_chart: Отчет генерируется в Allure

<img src="images/all.jpg" width="800" height="600">

___

## <img src="images/ato1.jpg" width="20" height="20"> Тестовая документация, сгенерированная в Allure TestOps по итогам прохождения тестов

<img src="images/ato.jpg" width="800" height="600"> 

___
## <img src=https://github.com/VeronikaMonarkhovich/VeronikaMonarkhovich/blob/master/logo/Jira.png width="20" height="20"> Задача в таск-трекере Jira с данными, экспортированными из Allure TestOps

<img src="images/jira.jpg" width="800" height="600"> 
___

## :calling: Уведомления о прохождение тестов отправляются в Telegram

<img src="images/telegram.jpg" width="600" height="800"> 

___

## :movie_camera: Видеотчет теста "Проверка 'Связаться с нами'"

<img src="images/Connect.gif" width="1000" height="600"> 