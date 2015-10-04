package com.arpit.java2blog.JacksonStreamingAPIExample;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.util.DefaultPrettyPrinter;

/**
 * 
 * @author Arpit Mandliya
 *
 */
public class JacksonWriteToFileStreamingAPIExample 
{
    public static void main( String[] args )
    {
    	  try {

  			JsonFactory jfactory = new JsonFactory();

  			/*** Write JSON TO FILE ***/
  			JsonGenerator jsonGenerator = jfactory.createJsonGenerator(new File("//Users//Arpit//countryStreaming.json"), JsonEncoding.UTF8);
  			jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
  			jsonGenerator.writeStartObject(); // {
  			//"name" : "India"
  			jsonGenerator.writeStringField("name", "India");
  			// "population" : "10000"
  			jsonGenerator.writeNumberField("population", 10000);
  			
  			// "listOfStates" :
  			// This is an array object
  			jsonGenerator.writeFieldName("listOfStates");
  			// Create start of array tag  [
  			jsonGenerator.writeStartArray();
  			
  			jsonGenerator.writeString("Madhya Pradesh");
  			
  			jsonGenerator.writeString("Maharashtra");
  	
  			jsonGenerator.writeString("Rajasthan");
  			// Create End of array tag  ]
  			jsonGenerator.writeEndArray();
  			// end of JSON Object tag }
  			jsonGenerator.writeEndObject();

  			jsonGenerator.close();

  		} catch (JsonGenerationException e) {

  			e.printStackTrace();

  		} catch (IOException e) {

  			e.printStackTrace();

  		}
    }
}
