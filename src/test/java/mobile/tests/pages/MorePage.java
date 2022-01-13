package mobile.tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;

public class MorePage {
    SelenideElement settings = $(MobileBy.xpath("//android.widget.TextView[contains(@text,'Setting')]"));

    public void clickSettings() {
        settings.click();
    }
}