package org.camunda.bpm.fhrt.testClasses;

import org.camunda.bpm.fhrt.entityClasses.*;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.logging.Logger;
  
public class StartFormEvaluation implements JavaDelegate {
  
  	 private final static Logger LOGGER = Logger.getLogger("StartFormEvaluation-LOGGER");
  
    public void execute(DelegateExecution execution) throws Exception 
    {
      String mockMethod = (String)execution.getVariable("mockingModel");
      
      int createNewServiceCall = 1;
      if(mockMethod.matches("Mockito"))
      {
         createNewServiceCall = 2; 
      }
      if(mockMethod.matches("JMockit"))
      {
         createNewServiceCall = 3;  
      }
      execution.setVariable("mockMethod", createNewServiceCall);
      
      ProcessEntities processEntities = new ProcessEntities();
      processEntities.setCreateNewServiceCall(createNewServiceCall);
      
      execution.setVariable("processEntities", processEntities);
      
      LOGGER.info("Start Form evaluated.");
    }
}
