package dataLoads;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader1 {

	// Method to read content from JSON file and convert into string
	//
	
	public List<HashMap<String,String>> getJsonData(String JsonFileDataPath) throws IOException {
		
		// using jackson bind & Jackson core for reading Json
		//using apache common IO for reading Json & convert into JSON string
		
		String jsonContent =
				FileUtils.readFileToString(new File(JsonFileDataPath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		//Below we are using TypeReference class to Marshal - Unmarshal the json content
		// Here we are doing Unmarshalling from JSON to List of Hashmaps
		List<HashMap<String, String >> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String >>>(){} );
		return data;
		
	}
}
