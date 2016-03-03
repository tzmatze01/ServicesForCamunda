package org.camunda.bpm.fhrt.testClasses;

import org.camunda.bpm.fhrt.entityClasses.*;
import org.camunda.bpm.fhrt.mockClasses.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class MockitoReturnDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("MockitoReturnDelegate-LOGGER");
  
    public void execute(DelegateExecution execution) throws Exception {
      
      	ProcessEntities processEntities = (ProcessEntities)execution.getVariable("processEntities"); 
      	CustomMock serviceCallObject = processEntities.getCustomMock(); 
      
 			String returnValue1 = serviceCallObject.callService("www.myServiceCall.com"); 
 			String returnValue2 = serviceCallObject.callService("www.myServiceCall.com"); 
      
    		LOGGER.info("Value of first service call: \n" + returnValue1);
    		LOGGER.info("Value of second service call: \n" + returnValue2);
    }

}