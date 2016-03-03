package org.camunda.bpm.fhrt.entityClasses;

import org.camunda.bpm.fhrt.mockClasses.*;

public class ProcessEntities 
{
  protected String mockModel; 
  protected int createNewServiceCall; 
  
  protected String serviceURL; 
  protected String returnValues; 
  
  protected CustomMock customMock;
  
  public CustomMock getCustomMock()
  {
    return this.customMock;  
  }
  
  public void setCustomMock(CustomMock customMock)
  {
    this.customMock = customMock; 
  }
  
  
  public String getServiceURL()
  {
    return this.serviceURL; 
  }
  
  public void setServiceURL(String serviceURL)
  {
    this.serviceURL = serviceURL; 
  }
  
  public String getReturnValues()
  {
    return this.returnValues; 
  }
  
  public void setReturnVlaues(String returnValues)
  {
    this.returnValues = returnValues;  
  }
  
  public void setMockModel(String mockModel)
  {
    this.mockModel = mockModel;  
  }
  
  public String getMockModel()
  {
  	 return this.mockModel;
  }
  
  public void setCreateNewServiceCall(int createNewServiceCall)
  {
    this.createNewServiceCall = createNewServiceCall;  
  }
  
  public int getCreateNewServiceCall()
  {
  	 return this.createNewServiceCall;   
  }
}
