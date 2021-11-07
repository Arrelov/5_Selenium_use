package org.example;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Data
public class WikiMainPage {
    @Getter
    private static String mainURL = "https://ru.wikipedia.org";
    private final SelenideElement searchInput = $(By.id("searchInput"));
    private final SelenideElement searchButton = $(By.xpath(".//div[@class='suggestions-special']/..")); // через xpath
    private final SelenideElement searchButtonChild = $(By.cssSelector("div.suggestions-special"));  // нам нужен родитель

}
