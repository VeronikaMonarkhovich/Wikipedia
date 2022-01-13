package mobile.tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class EditsPage {
    SelenideElement header = $(MobileBy.xpath("//*[@text='Did you know that everyone can edit Wikipedia?']"));

    public void checkHeader() {
        header.shouldBe(visible);
    }
}