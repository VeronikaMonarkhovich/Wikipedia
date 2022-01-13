package mobile.tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {
    SelenideElement general = $(MobileBy.xpath("//android.widget.TextView[contains(@text,'General')]"));

    public void checkGeneral() {
        general.shouldBe(visible);
    }

    public void checkChapters(String sectionName) {
        String section = $(MobileBy.xpath("//*[@text='" + sectionName + "']"))
                .getAttribute("text");
        Assertions.assertEquals(section, sectionName);
    }
}