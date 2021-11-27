import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/testFeatureFiles/APCustomerRequests.feature",glue = {"stepDefinition"}

        //stepDefinition
        //stepDefinition
)

public class TestRunner {

}
