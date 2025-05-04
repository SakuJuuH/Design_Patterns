import org.json.simple.parser.ParseException;

public class APIClientFacade {

	static APIClient apiClient = new APIClient();
	static JsonParser jsonParser = new JsonParser();

	public static String getAttributeValueFromJson(String urlString, String attributeName)
			throws Exception {
		try {
			String json = apiClient.getJsonFromApi(urlString);
			return jsonParser.extractValueFromJson(json, attributeName);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Error parsing JSON. ", e);
		}
	}
}