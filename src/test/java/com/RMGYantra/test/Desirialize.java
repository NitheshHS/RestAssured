package com.RMGYantra.test;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

public class Desirialize {
	
	@Test
	public void desirealizeTest() throws JsonParseException, JsonMappingException, IOException {
		
		
		ObjectMapper mapper=new ObjectMapper();
		Project value = mapper.readValue(new File("./project.json"), Project.class);
		System.out.println(value.projectName);
		System.out.println(value.projectId);
		System.out.println(value.createdBy);
	}

}
