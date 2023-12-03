package webstaurantstore.stepdefinitions;

import java.util.List;

import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import com.google.common.base.Splitter;
/**
 * Methods for identifying cucumber scenario format and setting up/tearing down config steps in before and after.
 */
public class ParameterDefinitions {

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

    @ParameterType(".*")
    public List<String> items(String listOfItems) {
        return Splitter.on(",").trimResults().omitEmptyStrings().splitToList(listOfItems);
    }

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }
}
