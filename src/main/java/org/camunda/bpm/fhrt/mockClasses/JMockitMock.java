package org.camunda.bpm.fhrt.mockClasses;

import mockit.*; 

public class JMockitMock {
  
  @Mocked
  CustomMock customMock;
  
  public JMockitMock()
  {
    /*
    The purpose of Expectations is to allow a test to record expected results for mocked methods and/or constructors, 
    as needed by the code under test.

	 The purpose of Verifications is to allow a test to verify expected invocations to mocked methods and/or constructors, 
    as made by the code under test.
    */
    customMock = new CustomMock(); 
    
    new Expectations()
    {{
       
    }};
  }
	
  public void callService()
    {
}
}
