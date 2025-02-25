package runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/swag_labs.feature"},
        tags = "@ComprarProducto or @LoginFallido",
        glue = "stepdefinitions",
        plugin = "json:target/cucumber-reports/cucumber.json",
        snippets = CucumberOptions.SnippetType.CAMELCASE)

public class SwagLabsRunner {


}
