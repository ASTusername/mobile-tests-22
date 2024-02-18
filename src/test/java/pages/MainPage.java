package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;
import static io.appium.java_client.MobileBy.AccessibilityId;

public class MainPage {
    private final SelenideElement searchBtn = $(AccessibilityId("Search Wikipedia")),
            firstArticleDescription = $(id("org.wikipedia.alpha:id/page_list_item_description")),
            wikiErrorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text")),
            wikiErrorBtn = $(id("org.wikipedia.alpha:id/view_wiki_error_button"));

    public void clickSearchButton() {
        $(searchBtn).click();
    }

    public void clickFirstArticle() {
        firstArticleDescription.click();
    }

    public void verifyErrorAfterOpeningArticle(String error) {
        wikiErrorText.shouldHave(text(error));
        wikiErrorBtn.click();    }
}
