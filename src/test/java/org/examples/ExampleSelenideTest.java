package org.examples;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.testit.annotations.WorkItemIds;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertEquals;

public class ExampleSelenideTest {

    MainPage mainPage = new MainPage();

    @BeforeClass
    public static void setUpAll() {
            Configuration.browserSize = "1280x800";
        }

    @BeforeMethod
    public void setUp() {
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
        open("https://www.jetbrains.com/");
    }

    @Test
    @WorkItemIds("9492")
    public void search() {
        mainPage.searchButton.click();

        $("[data-test-id='search-input']").sendKeys("Selenium");
        $("button[data-test='full-search-button']").click();
        $("input[data-test-id='search-input']").shouldHave(attribute("value", "Selenium"));
    }

    @Test
    @WorkItemIds("9493")
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        $("div[data-test='main-submenu']").shouldBe(visible);
    }

    @Test
    @WorkItemIds("9494")
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        $("#products-page").shouldBe(visible);

        assertEquals(Selenide.title(), "All Developer Tools and Products by JetBrains");
    }

    // page_url = https://www.jetbrains.com/
    public static class MainPage {

        public SelenideElement seeDeveloperToolsButton = $x("//*[@data-test-marker='Developer Tools']");
        public SelenideElement findYourToolsButton = $x("//*[@data-test='suggestion-action']");
        public SelenideElement toolsMenu = $x("//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']");
        public SelenideElement searchButton = $("[data-test='site-header-search-action']");

    }
}
