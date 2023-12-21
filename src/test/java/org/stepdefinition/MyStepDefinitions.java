package org.stepdefinition;


import io.cucumber.java.en.*;

import java.io.IOException;
import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyStepDefinitions {

	private static final Logger logger = LogManager.getLogger(MyStepDefinitions.class);

	 

    @Given("Create file Log")

    public static void create_file_log() throws IOException {

        File file = new File("C:\\Users\\PLAP016\\eclipse-workspace\\cucumber\\target\\output.log");

        file.createNewFile();

 

    }
    @When("I perform some action")
    public void i_perform_some_action() {
        // Your test logic here...
    	logger.info("transactionId");
    }

    // Other step definitions...
}