package StepDefs;

import PageObjects.Hooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class HooksSteps {
    Hooks hooks= new Hooks();

    @After
    public void tearDown(Scenario scenario){
        hooks.cleanUp(scenario.getName());

    }
}
