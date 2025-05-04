import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class APIClient {
	public String getJsonFromApi(String apiUrl) throws IOException {
		HttpURLConnection con = null;
		try {
			URL url = new URI(apiUrl).toURL();
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			if (responseCode != HttpURLConnection.HTTP_OK) {
				String responseMessage = con.getResponseMessage();
				throw new IOException("Failed : HTTP error code : " + responseCode + " " + responseMessage);
			}

			try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
				String inputLine;
				StringBuilder content = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				return content.toString();
			}
		} catch (URISyntaxException | MalformedURLException | ProtocolException e) {
			throw new IOException("Invalid URL or protocol error: " + apiUrl, e);
		} finally {
			if (con != null) {
				con.disconnect();
			}
		}
	}
}
