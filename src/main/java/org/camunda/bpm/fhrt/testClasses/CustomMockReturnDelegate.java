package org.camunda.bpm.fhrt.testClasses;

import org.camunda.bpm.fhrt.entityClasses.*;
import org.camunda.bpm.fhrt.mockClasses.CustomMock;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import java.util.logging.Logger;

public class CustomMockReturnDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CustomMockReturnDelegate-LOGGER");
  
    public void execute(DelegateExecution execution) throws Exception {
      
      ProcessEntities processEntities = (ProcessEntities)execution.getVariable("processEntities"); 
      CustomMock customMock = processEntities.getCustomMock(); 
      
      String json = customMock.callService(processEntities.getServiceURL()); 
      processEntities.setReturnVlaues(json); 
      
    	LOGGER.info("Called Mock Service with result: \n" + processEntities.getReturnValues());
    }
}