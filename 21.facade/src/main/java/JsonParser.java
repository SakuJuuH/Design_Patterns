import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

	public String extractValueFromJson(String json, String attributeName)
			throws ParseException, IllegalArgumentException {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(json);
		Object valueObject = jsonObject.get(attributeName);

		if (valueObject == null) {
			throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON response.");
		}

		return valueObject.toString();
	}
}
