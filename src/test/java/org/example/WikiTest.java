package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;


public class WikiTest {
    @Before
    public void setBrowserConfig() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }

    @Test
    public void wikiTest_1() {
        WikiMainPage wiki = new WikiMainPage();
        open(wiki.getMainURL());
        wiki.searchInput
                .shouldBe(Condition.enabled, Condition.visible, Condition.empty)
                .click();
        sleep(500); // без ожидания тест иногда проваливается
        wiki.searchInput.setValue("a cake is a lie");
        wiki.searchButtonChild.parent()
                .shouldBe(Condition.visible)
                .click();

        WikiSearchPage wiki2 = new WikiSearchPage();
        int resCount = wiki2.searchResultCount.size();
        int minCount = 1;
        System.out.print("resCount=" + resCount + "; ");
        System.out.println("minCount=" + minCount);
        sleep(2000);
        assertTrue(resCount > minCount);
    }

    @Test
    public void wikiTest_2() {
        WikiMainPage wiki = new WikiMainPage();
        open(wiki.getMainURL());
        wiki.searchInput
                .shouldBe(Condition.enabled, Condition.visible, Condition.empty)
                .click();
        sleep(500);
        wiki.searchInput.setValue("Jonh Smith");
        wiki.searchButtonChild.parent()
                .shouldBe(Condition.visible)
                .click();

        WikiSearchPage wiki2 = new WikiSearchPage();
        int resCount = wiki2.searchResultCount.size();
        int minCount = 1;
        System.out.print("resCount=" + resCount + "; ");
        System.out.println("minCount=" + minCount);
        sleep(2000);
        assertTrue(resCount > minCount);
    }

    @Test
    public void wikiTest_3() {
        WikiMainPage wiki = new WikiMainPage();
        open(wiki.getMainURL());
        wiki.searchInput
                .shouldBe(Condition.enabled, Condition.visible, Condition.empty)
                .click();
        sleep(500);
        wiki.searchInput.setValue("hdkfkshdfiuoeghhfhak");
        wiki.searchButtonChild.parent()
                .shouldBe(Condition.visible)
                .click();

        WikiSearchPage wiki2 = new WikiSearchPage();
        int resCount = wiki2.searchResultCount.size();
        int minCount = 1;
        System.out.print("resCount=" + resCount + "; ");
        System.out.println("minCount=" + minCount);
        sleep(2000);
        assertTrue(resCount > minCount);
    }

    @After
    public void closeAll() {
        Selenide.closeWebDriver();
    }
}
