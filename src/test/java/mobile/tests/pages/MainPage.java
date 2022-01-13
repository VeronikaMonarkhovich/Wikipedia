package mobile.tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    SelenideElement skip = $(MobileBy.xpath("//android.widget.Button[contains(@text,'SKIP')]"));
    SelenideElement search = $(MobileBy.AccessibilityId("Search Wikipedia"));
    SelenideElement enter = $(MobileBy.id("org.wikipedia.alpha:id/search_src_text"));
    SelenideElement more = $(MobileBy.AccessibilityId("More"));
    SelenideElement edits = $(MobileBy.AccessibilityId("Edits"));

    public void setSkip() {
        skip.click();
    }

    public void enterTheSearchBar(String value) {
        search.click();
        enter.val(value);
    }

    public void clickMore() {
        more.click();
    }

    public void clickEdits() {
        edits.click();
    }
}