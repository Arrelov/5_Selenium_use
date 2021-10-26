package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikiPage {
    private final WebDriver driver;
    private final WebElement searchInputElement;
    private final WebElement searchButton;
    private final WebElement searchButton2;
    //private int searchResultCount;

    public WikiPage(WebDriver driver) {
        this.driver = driver;
        this.searchInputElement = driver.findElement(By.cssSelector("input[id='searchInput']"));
        this.searchButton = driver.findElements(By.id("searchButton")).get(0);
        this.searchButton2 = driver.findElements(By.className("oo-ui-labelElement-label")).get(0);
        //this.searchResultCount = driver.findElements(By.className("searchresult")).size();
    }

    public void setSearchText(String text) {
        this.searchInputElement.sendKeys(text);
    }

    public void clickToSearch(){
        this.searchButton.click();
    }

    public void clickToSearch2(){
        this.searchButton2.click();
    }

//    public String getSearchResultCount() {
//        return driver.searchResultCount;
//    }

}
