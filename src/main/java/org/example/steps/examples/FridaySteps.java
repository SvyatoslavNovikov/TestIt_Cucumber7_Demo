package org.example.steps.examples;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FridaySteps {

    private String today;
    private String actualAnswer;

    @Given("сегодня воскресенье")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @When("я спрашиваю, \"сегодня пятница?\"")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = isItFriday(today);
    }

    @Then("мне следует сказать {string}")
    public void i_should_be_told(String expectedAnswer) {
        Assert.assertEquals(expectedAnswer, actualAnswer);
    }

    private static String isItFriday(String today) {
        if (today.equals("Friday")) {
            return "да";
        } else {
            return "нет";
        }
    }

}
