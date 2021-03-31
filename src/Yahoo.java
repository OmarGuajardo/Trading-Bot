import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONException;
import org.json.JSONObject;
public class Yahoo {
	
	private String MAIN_ENDPOINT = "https://yahoo-finance15.p.rapidapi.com/api/yahoo/";
	private String API_KEY = "hidden";
	
	public Yahoo() {
		
	}
	
	
	//Takes in the Ticker of a stock and returns the current raw price 
	public double getStockPrice (String ticker){
		String ENDPOINT = MAIN_ENDPOINT + "qu/quote/" + ticker + "/financial-data";
		double price = 0.0;
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(ENDPOINT))
				.header("x-rapidapi-key", API_KEY)
				.header("x-rapidapi-host", "yahoo-finance15.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			String body = response.body();
			try {
				JSONObject json = new JSONObject(body);
				price = json.getJSONObject("financialData")
						.getJSONObject("currentPrice")
						.getDouble("raw");
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}
	
	
}
