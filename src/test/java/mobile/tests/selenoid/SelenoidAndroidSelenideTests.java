package mobile.tests.selenoid;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static mobile.helpers.Tags.SELENOID;
import static mobile.selectors.Selectors.*;

@Tag(SELENOID)
public class SelenoidAndroidSelenideTests extends SelenoidTestBase {

    @Test
    @DisplayName("Успешный поиск в Wikipedia Android app")
    void searchTest() {
        step("Ввод в поисковую строку", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id(search)).val("GitHab");
        });
        step("Проверяем успешный поиск", () ->
                $$(MobileBy.id(searchResult))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Проверка наличия раздела About в Wikipedia Android app")
    void checkAboutSectionTest() {
        step("Нажимаем кнопку More", () ->
                $(MobileBy.id(moreButton)).click());
        step("Нажимаем кнопку Setting", () ->
                $(MobileBy.id(settingsButton)).click());
        step("Проверяем раздел About", () ->
                $$(MobileBy.id(title)).findBy(text("About")).shouldBe(visible));
    }

    @CsvSource({
            "Wikipedia language",
            "Explore Feed",
            "Show images",
            "Send usage reports"
    })
    @ParameterizedTest()
    @DisplayName("Проверка разделов настроек в Wikipedia Android app")
    void checkSettingsPageTest(String sectionName) {
        step("Нажимаем кнопку More", () ->
                $(MobileBy.id(moreButton)).click());
        step("Нажимаем кнопку Setting", () ->
                $(MobileBy.id(settingsButton)).click());
        step("Проверяем названия разделов", () -> {
            String section = $(MobileBy.xpath("//*[@text='" + sectionName + "']")).getAttribute("text");
            Assertions.assertEquals(section, sectionName);
        });
    }
}