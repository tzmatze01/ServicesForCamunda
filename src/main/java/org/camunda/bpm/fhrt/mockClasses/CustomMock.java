package org.camunda.bpm.fhrt.mockClasses;

/*
	This is a class to mock of a service. This class should be used, if i you want to quickly implemet a mock, 
   during the runtime of the process. 
*/
import java.util.Map;
import java.util.HashMap; 
import java.lang.Thread;
import java.util.logging.Logger;

public class CustomMock
{  
  // key: address of the service, value: return value of the service
  private Map<String, String> registeredServices; 
  private final static Logger LOGGER = Logger.getLogger("CustomMock-LOGGER");
  
  public CustomMock() 
  {  
    registeredServices = new HashMap<String, String>(); 
  }
  
  public void registerServiceCall(String url, String returnValues) 
  {
    String json = parseToJSON(returnValues);
    registeredServices.put(url, json);
  }
  
  public void setReturnForService(String url, String newReturnValues) 
  {  
    if(registeredServices.containsKey(url))
    {
 	   String json = parseToJSON(newReturnValues);
      registeredServices.remove(url); 
      registeredServices.put(url, json); 
    }
    else
    {
    	LOGGER.info("This service adress does not exist!");  
    }
  }
  
  public String callService(String url)
  {
    if(registeredServices.containsKey(url))
    {
      return registeredServices.get(url); 
    }
  	 else
    {
     	LOGGER.info("Service URL does not exist!"); 
      return ""; 
    }
  }
  
  public String callServiceWithDelay(String url, int delayInMS)
  {
    if(!registeredServices.containsKey(url))
    {
      LOGGER.info("Service URL does not exist!"); 
      return ""; 
    }
    
    // wait delay time
    try
    {
      Thread.sleep(delayInMS);  
    }
  	 catch(InterruptedException ie)
    {
    	ie.printStackTrace();  
    }

    return registeredServices.get(url);  
  }
  
  public String callServiceWithEmptyReturn(String url)
  {
  	 return "{}";  
  }
  
  private String parseToJSON(String returnValues)
  {
    String[] keyValuePairs = returnValues.split(";"); 
    String json = "{\n"; 
    StringBuilder builder = new StringBuilder(json); 
    
    for(String currentPair : keyValuePairs)
    {
      //delete whitespace
      currentPair.replaceAll("\\s","");
      String[] pair = currentPair.split(","); 
      builder.append("\t{ \n\t\t\""  + pair[0] + "\": \"" + pair[1] + "\"\n\t}\n"); 
    }
    builder.append("\n}"); 
    json = builder.toString(); 
    
  	 return json; 
  }
}
