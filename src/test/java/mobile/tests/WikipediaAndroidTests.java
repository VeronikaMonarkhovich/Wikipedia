package mobile.tests;

import io.appium.java_client.MobileBy;
import mobile.tests.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static mobile.selectors.Selectors.*;

public class WikipediaAndroidTests extends TestBase {

    @Test
    @DisplayName("Успешный поиск в Wikipedia Android app")
    void searchTest() {
        step("Ввод в поисковую строку", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id(searchId)).val("GitHub");
        });
        step("Проверяем успешный поиск", () ->
                $$(MobileBy.id(searchResultId))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка наличия раздела General в Wikipedia Android app")
    void checkGeneralSectionTest() {
        step("Нажимаем кнопку More", () ->
                $(MobileBy.AccessibilityId("More")).click());
        step("Нажимаем кнопку Settings", () ->
                $(MobileBy.xpath(settings)).click());
        step("Проверяем раздел General", () ->
                $(MobileBy.xpath(general)).shouldBe(visible));
    }

    @CsvSource({
            "Wikipedia languages",
            "Explore Feed",
            "Collapse tables",
            "App theme"
    })

    @ParameterizedTest(name = "Проверка разделов настроек в Wikipedia Android app")
    void checkSettingsPageTest(String sectionName) {
        step("Нажимаем кнопку More", () ->
                $(MobileBy.AccessibilityId("More")).click());
        step("Нажимаем кнопку Settings", () ->
                $(MobileBy.xpath(settings)).click());
        step("Проверяем названия разделов", () -> {
            String section = $(MobileBy.xpath("//*[@text='" + sectionName + "']")).getAttribute("text");
            Assertions.assertEquals(section, sectionName);
        });
    }

    @Test
    @DisplayName("Проверка раздела Edits в Wikipedia Android app")
    void checkEditsTest() {
        step("Нажимаем кнопку Edits", () ->
                $(MobileBy.AccessibilityId("Edits")).click());
        step("Проверяем текст", () ->
                $(MobileBy.xpath(text)).shouldBe(visible));
    }
}