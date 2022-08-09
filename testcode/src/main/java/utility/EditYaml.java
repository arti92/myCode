/*
package utility;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class EditYaml {

private static final String inputFile="C:\\Arti\\Open Api\\productOrder\\test";
private static final List<String> exclusionSchemas= Arrays.asList(new String[]{"ModelAndView","XMLGregorianCalendar","View","QName","DigitalApiPlatformStatusInfo","Link"});


public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
	File file = new File(inputFile);
	for(File fileName :file.listFiles()) {
		if(fileName.isFile())
			doProcess(fileName);
	}
	
	
	
	System.out.println("Done");
}

*/
/**
 * @param fileName
 * @throws IOException
 * @throws JsonParseException
 * @throws JsonMappingException
 * @throws JsonGenerationException
 * @param componentsNew
 * @param list
 * @param object
 * @param key
 *//*

@SuppressWarnings("unchecked")
public static void doProcess(File fileName) throws IOException, JsonParseException, JsonMappingException, JsonGenerationException {
	ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
		
	
	Map<String, Object> baseYaml = objectMapper.readValue(fileName,
            new TypeReference<Map<String, Object>>() { });
	
	Map<String, Object> components = (Map<String, Object>) baseYaml.get("components");
	
	Map<String, Object> schemas = (Map<String, Object>) components.get("schemas");
	schemas.keySet().removeAll(exclusionSchemas);
	
	for(String key:schemas.keySet()) {

		Map<String, Object> object = (Map<String, Object>) schemas.get(key);		
		
		Map<String, Object> properties = (Map<String, Object>) object.get("properties");
		
		for(String property:properties.keySet()) {
			String desc=new String(property);
			
			if(isCamelCase(property)) {
				desc=splitCamelCase(property);
			}
			
			desc=doUpperCase(desc);
			
			Map<String, Object> propertyYaml = (Map<String, Object>) properties.get(property);
			
			if(propertyYaml.containsKey("type") && !propertyYaml.containsKey("description"))
				propertyYaml.put("description", desc);
			
		}
}

	Map<String, Object> componentsNew = (Map<String, Object>) baseYaml.get("components");
	
	Map<String, Object> schemasNew = (Map<String, Object>) componentsNew.get("schemas");
	
	Map<String,Map<String, Object>> list= new HashMap<String, Map<String,Object>>();
	
	for(String key:schemasNew.keySet()) {

		Map<String, Object> object = (Map<String, Object>) schemasNew.get(key);
		
		if(object.containsKey("title")) {
			String desc=(String)object.get("title");
			object.put("description", desc);
			object.remove("title");			
		}
		
		if(key.equalsIgnoreCase("resultstatus")) {
			rearrageResultStatus(componentsNew, list, object,key);
		}
		
		extract(componentsNew, list, object,key);
}

	componentsNew.put("schemas", list);
	
	objectMapper.writeValue(new File(fileName.getAbsolutePath().replaceAll(".yaml", "-v1.yaml")), baseYaml);
}

@SuppressWarnings("unchecked")
private static void rearrageResultStatus(Map<String, Object> componentsNew, Map<String, Map<String, Object>> list,
		Map<String, Object> object, String key) {
	Map<String, Object> propertyTempYaml = new LinkedHashMap<String, Object>();
	
	if (object.containsKey("type"))
		propertyTempYaml.put("type", ((String)object.get("type")).replace("\"", " "));
	else
		System.out.println("No Type for " + key + " ....");

	if (object.containsKey("description"))
		propertyTempYaml.put("description", object.get("description"));
	
	if (object.containsKey("title") && propertyTempYaml.containsKey("description") )
		propertyTempYaml.put("description", object.get("title"));
	
	if (!propertyTempYaml.containsKey("description"))
		propertyTempYaml.put("description",key);

	if (object.containsKey("required"))
		propertyTempYaml.put("required", object.get("required"));
	else
		System.out.println("No Required Field for " + key + " ....");

	if (object.containsKey("properties")) 
		propertyTempYaml.put("properties",rearrageResultStatus((Map<String, Object>) object.get("properties")));
	else
		System.out.println("No Properties for " + key + "....");

	list.put(key, propertyTempYaml);
}




	private static Map<String, Object> rearrageResultStatus(Map<String, Object> object) {
		Map<String, Object> propertyTempYaml = new LinkedHashMap<String, Object>();

		if (object.containsKey("status"))
			propertyTempYaml.put("status", object.get("status"));

		if (object.containsKey("errorCode"))
			propertyTempYaml.put("errorCode", object.get("errorCode"));

		if (object.containsKey("errorMessage"))
			propertyTempYaml.put("errorMessage", object.get("errorMessage"));

		for (String key : object.keySet()) {
			if (key.equalsIgnoreCase("status") || key.equalsIgnoreCase("errorCode")
					|| key.equalsIgnoreCase("errorMessage")) {
				continue;
			}
			propertyTempYaml.put(key, object.get(key));
		}
		
		return propertyTempYaml;
	}

*/
/**
 * @param componentsNew
 * @param list
 * @param object
 * @param key
 *//*

@SuppressWarnings("unchecked")
public static void extract(Map<String, Object> componentsNew, Map<String, Map<String, Object>> list,
			Map<String, Object> object, String key) {
		Map<String, Object> propertyTempYaml = new LinkedHashMap<String, Object>();
		
		if (object.containsKey("type"))
			propertyTempYaml.put("type", ((String)object.get("type")).replace("\"", " "));
		else
			System.out.println("No Type for " + key + " ....");

		if (object.containsKey("description"))
			propertyTempYaml.put("description", object.get("description"));
		
		if (object.containsKey("title") && propertyTempYaml.containsKey("description") )
			propertyTempYaml.put("description", object.get("title"));
		
		if (!propertyTempYaml.containsKey("description"))
			propertyTempYaml.put("description",key);

		if (object.containsKey("required"))
			propertyTempYaml.put("required", object.get("required"));
		else
			System.out.println("No Required Field for " + key + " ....");

		if (object.containsKey("properties") && key.equalsIgnoreCase("resultstatus"))
			propertyTempYaml.put("properties",rearrageResultStatus((Map<String, Object>) object.get("properties")));
		else if(object.containsKey("properties"))
			propertyTempYaml.put("properties",object.get("properties"));
		else
			System.out.println("No Properties for " + key + "....");

		list.put(key, propertyTempYaml);

	}

static String splitCamelCase(String s) {
	   return s.replaceAll(
	      String.format("%s|%s|%s",
	         "(?<=[A-Z])(?=[A-Z][a-z])",
	         "(?<=[^A-Z])(?=[A-Z])",
	         "(?<=[A-Za-z])(?=[^A-Za-z])"
	      ),
	      " "
	   );
	}


static String doUpperCase(String name) {
	

 // create two substrings from name
 // first substring contains first letter of name
 // second substring contains remaining letters
 String firstLetter = name.substring(0, 1);
 String remainingLetters = name.substring(1, name.length());

 // change the first letter to uppercase
 firstLetter = firstLetter.toUpperCase();

 // join the two substrings
 return firstLetter + remainingLetters;
 
	}

private static boolean isCamelCase(String input) {
	String camelCasePattern = "([a-z]+[A-Z]+\\w+)+"; // 3rd edit, getting better
	return input.matches(camelCasePattern);
}
}
*/
