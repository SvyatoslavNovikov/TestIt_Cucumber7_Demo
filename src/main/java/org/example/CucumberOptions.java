package org.example;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

public class CucumberOptions {

    @After
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    @AfterStep
    public void makeScreenshot() {
        Selenide.screenshot(System.currentTimeMillis() + "_step");
    }

}
