package Runner;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features",
                 glue = {"Steps","Hooks"}, 
                 plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",//Allure report
                            "html:target/cucumber-reports/cucumber.html", // HTML report
                            "json:target/cucumber-reports/cucumber.json", // JSON report
                            "junit:target/cucumber-reports/cucumber.xml"},  // JUnit XML report},
                 tags = "")
public class CucumberRunner extends AbstractTestNGCucumberTests {
}

