package org.camunda.bpm.fhrt.mockClasses;

import static org.mockito.Mockito.*;
import org.camunda.bpm.fhrt.mockClasses.CustomMock; 

public class MockitoMock {
  
  CustomMock mock; 
  
  public MockitoMock()
  {
    mock = mock(CustomMock.class);
    
    when(mock.callService("www.myServiceCall.com")).thenReturn("{\n\t{\n\t\t\"mockito\": \"test1\"\n\t}\n}")
      															.thenReturn("{\n\t{\n\t\t\"mockito\": \"test2\"\n\t}\n}");
 
  }
  
  public CustomMock getServiceObject()
  {
    return this.mock; 
  }
}
