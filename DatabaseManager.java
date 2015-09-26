import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class DatabaseManager {

	private String appID = "5606281f6f641d8201885766";
	private String authID = "af840c40-640c-11e5-b76f-d9089f678e7f";
	
	public String getUsers() throws IOException {
		String url = "https://api.knackhq.com/v1/objects/object_1/records";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Knack-Application-Id", appID);
		con.setRequestProperty("X-Knack-REST-API-Key", authID);
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String getResponse = response.toString();
		getResponse = getResponse.split("\\[", 2)[1].split("\\]", 2)[0];
		return getResponse;
	}
	
	public String addUser(String data) throws IOException {
		URL url;
	    HttpURLConnection connection = null;  
	    try {
	      url = new URL("https://api.knackhq.com/v1/objects/object_1/records");
	      connection = (HttpURLConnection) url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", "application/json");
	      connection.setRequestProperty("X-Knack-Application-Id", appID);
	      connection.setRequestProperty("X-Knack-REST-API-Key", authID);
	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);

	      //Send request
	      DataOutputStream wr = new DataOutputStream (
	                  connection.getOutputStream ());
	      wr.writeBytes(data);
	      wr.flush ();
	      wr.close ();

	      //Get Response	
	      InputStream is = connection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	      String line;
	      StringBuffer response = new StringBuffer(); 
	      while((line = rd.readLine()) != null) {
	        response.append(line);
	        response.append('\r');
	      }
	      rd.close();
	      return response.toString();

	    } catch (Exception e) {

	      e.printStackTrace();
	      return null;

	    } finally {
	      if(connection != null) {
	        connection.disconnect(); 
	      }
	    }
	}
}
