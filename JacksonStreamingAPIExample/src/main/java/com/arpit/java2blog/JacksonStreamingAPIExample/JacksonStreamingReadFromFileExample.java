package com.arpit.java2blog.JacksonStreamingAPIExample;

import java.io.File;
import java.io.IOException;


import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;


public class JacksonStreamingReadFromFileExample {

	public static void main(String[] args)
	{
		try {

			JsonFactory jfactory = new JsonFactory();

			System.out.println("Reading data from json file");
			System.out.println("--------------------------");
			JsonParser jParser = jfactory
					.createJsonParser(new File("//Users//Arpit//countryStreaming.json"));

			// We need to loop until we reach to the end object.
			while (jParser.nextToken() != JsonToken.END_OBJECT) {

				String fieldname = jParser.getCurrentName();
				if ("name".equals(fieldname)) {
				
					jParser.nextToken();
					System.out.println("Name of Country:"+jParser.getText());
				}
				
				if ("population".equals(fieldname)) {
					jParser.nextToken();
					System.out.println("Population: "+jParser.getText());
				}
				// reading the listOfStates which is an array
				if ("listOfStates".equals(fieldname)) {
					// current token is "[" beginning of array. So we wii go to  next
					jParser.nextToken();
					System.out.println("List of states:");
					// iterate through the array until token equal to "]"
					while (jParser.nextToken() != JsonToken.END_ARRAY) {
						
						System.out.println(jParser.getText());
					}
				}

			}
			jParser.close();

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}
}
