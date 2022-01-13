package mobile.tests;

import io.qameta.allure.AllureId;
import mobile.tests.pages.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.step;

public class WikipediaAndroidTests extends TestBase {
    MainPage mainPage = new MainPage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    MorePage morePage = new MorePage();
    SettingsPage settingsPage = new SettingsPage();
    EditsPage editsPage = new EditsPage();

    @Test
    @AllureId("6583")
    @DisplayName("Успешный поиск в Wikipedia Android app")
    void searchTest() {
        mainPage.setSkip();
        step("Ввод в поисковую строку", () ->
                mainPage.enterTheSearchBar("GitHub"));
        step("Проверяем успешный поиск", () ->
                searchResultsPage.checkResults());
    }

    @Test
    @AllureId("6586")
    @DisplayName("Проверка наличия раздела General в Wikipedia Android app")
    void checkGeneralSectionTest() {
        mainPage.setSkip();
        step("Нажимаем кнопку More", () ->
                mainPage.clickMore());
        step("Нажимаем кнопку Settings", () ->
                morePage.clickSettings());
        step("Проверяем раздел General", () ->
                settingsPage.checkGeneral());
    }

    @CsvSource({
            "Wikipedia languages",
            "Explore Feed",
            "Collapse tables",
            "App theme"
    })
    @AllureId("6585")
    @ParameterizedTest(name = "Проверка разделов настроек в Wikipedia Android app")
    void checkSettingsPageTest(String sectionName) {
        mainPage.setSkip();
        step("Нажимаем кнопку More", () ->
                mainPage.clickMore());
        step("Нажимаем кнопку Settings", () ->
                morePage.clickSettings());
        step("Проверяем названия разделов", () ->
                settingsPage.checkChapters(sectionName));
    }

    @Test
    @AllureId("6584")
    @DisplayName("Проверка раздела Edits в Wikipedia Android app")
    void checkEditsTest() {
        mainPage.setSkip();
        step("Нажимаем кнопку Edits", () ->
                mainPage.clickEdits());
        step("Проверяем текст заголовка", () ->
                editsPage.checkHeader());
    }
}