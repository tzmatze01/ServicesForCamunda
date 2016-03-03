package org.camunda.bpm.fhrt.testClasses;

import org.camunda.bpm.fhrt.entityClasses.*;
import org.camunda.bpm.fhrt.mockClasses.CustomMock;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.logging.Logger;


public class CustomMockDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CustomMockDelegate-LOGGER");
  
    public void execute(DelegateExecution execution) throws Exception {
      
      ProcessEntities processEntities = (ProcessEntities)execution.getVariable("processEntities"); 
 		String url = (String)execution.getVariable("url"); 
      
      processEntities.setServiceURL(url);
      
      // create instance of CustomMock with the url and reValues
      CustomMock customMock = new CustomMock();
      customMock.registerServiceCall(processEntities.getServiceURL(), ((String)execution.getVariable("retValues")));
      
      processEntities.setCustomMock(customMock);
      
      // set ProcessEntities as session var to use in CustomMockReturnDelegate
      execution.setVariable("processEntities", processEntities);
      
    	LOGGER.info("CustomMock Objekt mit URL angelegt");
    }
}