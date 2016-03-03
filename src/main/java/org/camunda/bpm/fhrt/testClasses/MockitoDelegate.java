package org.camunda.bpm.fhrt.testClasses;

import static org.mockito.Mockito.*;

import org.camunda.bpm.fhrt.entityClasses.*;
import org.camunda.bpm.fhrt.mockClasses.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import static org.mockito.Mockito.*;


import java.util.logging.Logger;

public class MockitoDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("MockitoDelegate-LOGGER");
  
    public void execute(DelegateExecution execution) throws Exception {
      
      ProcessEntities processEntities = (ProcessEntities)execution.getVariable("processEntities"); 
      MockitoMock mockitoMock = new MockitoMock(); 
      CustomMock serviceCallObject = mockitoMock.getServiceObject();
      
      processEntities.setCustomMock(serviceCallObject);
      
    	LOGGER.info("Created Mockito Mock"); 
    }

}