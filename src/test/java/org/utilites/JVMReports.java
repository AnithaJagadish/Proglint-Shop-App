package org.utilites;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
public class JVMReports {
	
public static void generateJVMReport(String jsonpath)
{
	File f = new File("C:\\Users\\PLAP016\\eclipse-workspace\\cucumber\\target\\reports\\JVMReport");
	
	Configuration c= new Configuration(f, "Cucumber concept");
	c.addClassifications("Project Name", "Cucumber concept");
	c.addClassifications("Browser name", "Chrome");
	c.addClassifications("Browser version", "114");
	c.addClassifications("Sprint name", "Sprint");
	c.addClassifications("Release version", "1.0.0");
	List<String> list = new ArrayList<String>();
	list.add(jsonpath);
	ReportBuilder r= new ReportBuilder(list,c);
	r.generateReports();
	
	
}
}
