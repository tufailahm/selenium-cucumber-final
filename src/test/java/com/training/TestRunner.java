package com.training;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
		features = "src\\test\\resources\\Features" , 
		glue = {"com.training.jwa"},
		plugin = { "pretty" , "html:target/HTMLReports/index.html",
				"json:target/JSONReports/report.json",
				"junit:target/XMLReports/report.xml" },
		//tags =  "@controllertest and @databasetest"
		tags =  "@databasetest or @servicetest or @repositorytest"
		)
public class TestRunner {

}
