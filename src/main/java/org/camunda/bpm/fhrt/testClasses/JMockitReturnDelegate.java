package org.camunda.bpm.fhrt.testClasses;

import org.camunda.bpm.fhrt.entityClasses.*;
import org.camunda.bpm.fhrt.mockClasses.CustomMock;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.logging.Logger;

public class JMockitReturnDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("JMockitReturnDElegateDelegate-LOGGER");
  
    public void execute(DelegateExecution execution) throws Exception {
    }
}
