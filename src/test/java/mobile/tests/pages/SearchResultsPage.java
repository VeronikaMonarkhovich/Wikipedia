package mobile.tests.pages;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultsPage {
    ElementsCollection searchResults = $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title"));

    public void checkResults() {
        searchResults.shouldHave(sizeGreaterThan(0));
    }
}