# Wikipedia
# <img src="images/logo.jpg" width="40" height="40">  Проект для мобильного приложения Wikipedia

<img src="images/wiki.in.jpg" width="600" height="300">

___

Реализован запуск автотестов на следующем окружении:

remote emulator device (Selenoid);

local emulator device (AVD);

local real device.
___

## :person_in_tuxedo: Запуск тестов происходит в CI [Jenkins](http://localhost:9090/job/08-Veronika_Monarkhovich-Wikipedia/)

<img src="images/jenkins.jpg" width="600" height="300"> 

**Создаем emulator.properties:**

```bash
src/test/resources/emulator.properties
```
Text File Content:
```bash
url = http://172.17.0.1:4723/wd/hub
device = Test2
ver = 11.0
```
**Создаем local.properties:**

```bash
src/test/resources/local.properties
```
Text File Content:
```bash
url = http://172.17.0.1:4723/wd/hub
device = XSQ4C18B14000291
ver = 8.1
```
**Создаем selenoid.properties:**

```bash
src/test/resources/selenoid.properties
```
Text File Content:
```bash
url=http://172.17.0.1:4444/wd/hub
```
Запуск тестов:
- в параметре -DdeviceHost=${DEVICE_HOST} задаем хост
```bash
clean test -DdeviceHost=${DEVICE_HOST} 
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

<img src="images/allure.jpg" width="600" height="300">

___

## <img src="images/ato1.jpg" width="20" height="20"> Тестовая документация, сгенерированная в Allure TestOps по итогам прохождения тестов

<img src="images/ato1.jpg" width="600" height="300"> 

___
## <img src=https://github.com/VeronikaMonarkhovich/VeronikaMonarkhovich/blob/master/logo/Jira.png width="20" height="20"> Задача в таск-трекере Jira с данными, экспортированными из Allure TestOps

<img src="images/jira.jpg" width="600" height="300"> 

___

## :calling: Уведомления о прохождение тестов отправляются в Telegram

<img src="images/telegram.jpg" width="300" height="600"> 

___

## :movie_camera: Видеотчет теста "Успешный поиск в Wikipedia Android app"

<img src="images/emulator.gif" width="300" height="600"> 

## :movie_camera: Видеотчет теста "Проверка раздела Edits в Wikipedia Android app"

<img src="images/selenoid.gif" width="600" height="300"> 