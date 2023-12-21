package org.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.utilites.JVMReports;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources" , glue ="org.stepdefinition", tags=("@test"), dryRun = false, plugin = {"junit:C:\\Users\\PLAP016\\eclipse-workspace\\cucumber\\target\\reports\\junitreport.xml"
		,"json:C:\\Users\\PLAP016\\eclipse-workspace\\cucumber\\target\\reports\\jsonreport.json"
})


public class Runner extends JVMReports{
	
	@AfterClass
	public static void genratedRports() {
		generateJVMReport("C:\\Users\\PLAP016\\eclipse-workspace\\cucumber\\target\\reports\\jsonreport.json");    
	}

}
