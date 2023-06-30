package curs12;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import org.json.simple.parser.ParseException;
/*
 * 
 * {
 * name : "ceva",
 * 
 * },
 * {
 * 
 * }
 */

public class JsonFileProcessor {

	@SuppressWarnings("unchecked")
	public void writeJson() {
	JSONObject obj =new JSONObject();
	obj.put("name" , "Tester");
	obj.put("email" , "email@test.com");
	
	JSONArray list = new JSONArray();
	list.add("Obj 1");
	list.add("Obj 2");
	list.add("Obj 3");
	list.add("Obj 4");
	obj.put("lista obiecte" , list);
	
	
	try{
		FileWriter file = new FileWriter("test.json");
		file.write(obj.toJSONString());
		}catch (IOException e) {
		
	}
 }
	
	public void readJson(String  key) {
		JSONParser pars = new JSONParser ();
		
		try {
			FileReader file =new FileReader("test.json");
			JSONObject jsonObj = (JSONObject) pars.parse(file);
			System.out.println(jsonObj.get(key));
		}catch (Exception e) {
		
	}
}
	
	public void updateJson(String key, String value) {
		JSONParser pars = new JSONParser ();
		
		try {
			FileReader file =new FileReader("test.json");
			JSONObject jsonObj = (JSONObject) pars.parse(file);
			System.out.println(jsonObj.get(key));
			
			JSONArray list = (JSONArray) jsonObj.get("lista obiecte");
			list.set(0, "Obj 0");
			
			jsonObj.put(key, value);
			jsonObj.put("lista obiecte", list);
			
			try {FileWriter fileWriter =new FileWriter ("test.json");
			fileWriter.write(jsonObj.toJSONString());
			fileWriter.close();
			}catch (Exception e) {
				
		    }
		}catch (Exception e) {
		
	    }	
		
	 }
	public void deleteJson(String  key) {
		
		try {
			FileReader reader =new FileReader("test.json");
			JSONParser jsonParser = new JSONParser ();
			JSONObject jsonObj = (JSONObject) jsonParser.parse(reader);
			
			jsonObj.remove(key);
			try(FileWriter file =new FileWriter ("test.json")){
				file.write(jsonObj.toJSONString());
			}catch (Exception e) {
			}
		}catch (Exception e) {
		
	}
	
}
}
