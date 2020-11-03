package com.RMGYantra.test;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

public class Serialize{
	
	@Test
	public void serializationTest() throws JsonGenerationException, JsonMappingException, IOException {
		
		
		Project proj=new Project("NitheshHS", "03/11/2020", "TY_002", "JIO", "OnGoing", 5);
		ObjectMapper mapper=new ObjectMapper();
		mapper.writeValue(new File("./project.json"), proj);
		System.out.println("success");
	}

}
