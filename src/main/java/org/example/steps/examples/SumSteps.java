package org.example.steps.examples;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class SumSteps {

    private int result;

    @Given("сложение {int} + {int}")
    public void summing(int left, int right) {
        this.result = left + right;
    }

    @Then("сумма = {int}")
    public void result(int result){
        Assert.assertEquals(this.result, result);
    }

}
