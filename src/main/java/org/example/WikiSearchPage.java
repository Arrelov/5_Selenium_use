package org.example;

import com.codeborne.selenide.ElementsCollection;
import lombok.Data;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

@Data
public class WikiSearchPage {
    ElementsCollection searchResultCount = $$(By.className("searchresult"));
}
