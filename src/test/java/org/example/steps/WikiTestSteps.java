package org.example.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.WikiMainPage;
import org.example.WikiSearchPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;


public class WikiTestSteps {
    @BeforeAll
    public static void setBrowserConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Given("^I open wikipedia main page$")
    public void openWikiPage() {
        WikiMainPage wiki = new WikiMainPage();
        open(wiki.getMainURL());
    }

    @Given("^I write text \"(.+)\" to search field$")
    public void setSearchText(String searchText) {
        WikiMainPage wiki = new WikiMainPage();
        wiki.getSearchInput()
                .shouldBe(Condition.enabled, Condition.visible, Condition.empty)
                .click();
        sleep(500); // без ожидания тест иногда проваливается
        wiki.getSearchInput().setValue(searchText);
    }

    @And("I click search button")
    public void clickToSearch() {
        WikiMainPage wiki = new WikiMainPage();
        wiki.getSearchButtonChild().parent()
                    .shouldBe(Condition.visible)
                    .click();
        }

    @Then("Wikipedia return > {int} results")
    public void checkResults(int expectedResCount) {
        WikiSearchPage wikiRes = new WikiSearchPage();
        int resCount = wikiRes.getSearchResultCount().size();
        System.out.print("resCount=" + resCount + "; ");
        System.out.println("minCount=" + expectedResCount);
        sleep(2000);
        assertTrue(resCount > expectedResCount);
    }

    @AfterAll
    public static void closeAll() {
        Selenide.closeWebDriver();
    }
}
