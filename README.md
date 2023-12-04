# Test demo for Webstaurantstore web app

This is a demo project desined against Webstaurantstore web app. The project is built using **[SerenityBDD](https://serenity-bdd.github.io/)**, leveraging thier **[screenplay pattern](https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals)** and integration with Cucumber/Gherkin to write better/more readable and reusable tests.

Test cases are written in Given/When/Then format, collowing gherkin syntax.
For local execution, CucumberTestSuite.java file is used.
For CI/CD type simulated build, use mvn verify -f "\proect-directory\pom.xml"
Test execution reports are generated in the /target/site/serenity folder aggregated under "index.html" file.
