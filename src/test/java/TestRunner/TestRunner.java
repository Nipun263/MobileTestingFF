package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( 
	    features ="C://Users//nipunverma//eclipse-workspace//MobileTesting//src//test//java//Feature//Amazon.feature", 
	    glue = {"StepDefinationAmazon"}
	    ,monochrome = true )



	public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	
	
	
	

}
