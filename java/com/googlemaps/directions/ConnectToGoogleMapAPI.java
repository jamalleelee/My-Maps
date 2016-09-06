package com.googlemaps.directions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ConnectToGoogleMapAPI {

	// url of google map API we are connecting to
	protected static String endpoint = "https://maps.googleapis.com/maps/api/directions/";

	// encoding of url parameters
	protected static String charset = "UTF-8";

	// key to connect to google api
	protected static String key = "AIzaSyAI-b0OwKFzq2tHeLht0JiYzgN2kF6k_l8";

	protected static void connectingToGoogleMapAPI(String origin, String destination) {
		try {

			// The return type of the response xml|json
			String returnType = "json";

			// creates the url parameters as a string encodeing them with the
			// defined charset

			if (isTransit) {
				String queryString = String.format("origin=%s&destination=%s&key=%s&mode=%s&transit_mode&language=%s",
						URLEncoder.encode(origin, charset), URLEncoder.encode(destination, charset),
						URLEncoder.encode(key, charset));

			} else {
				String queryString = String.format("origin=%s&destination=%s&key=%s&mode=%s&language=%s",
						URLEncoder.encode(origin, charset), URLEncoder.encode(destination, charset),
						URLEncoder.encode(key, charset));

			}

			String queryString = String.format("origin=%s&destination=%s&key=%s&mode=%s&transit_mode&language=%s",
					URLEncoder.encode(origin, charset), URLEncoder.encode(destination, charset),
					URLEncoder.encode(key, charset));

			// creates a new URL out of the endpoint, returnType and queryString
			URL googleDirections = new URL(endpoint + returnType + "?" + queryString);
			HttpURLConnection connection = (HttpURLConnection) googleDirections.openConnection();
			connection.setRequestMethod("GET");

			// if we did not get a 200 (success) throw an exception
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed:HTTP error code:" + connection.getResponseCode());
			}

			// read response into buffer
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			// loop of buffer line by line until there are no more lines
			while (br.readLine() != null) {

				// print out each line to the screen
				System.out.println(br.readLine());
			}

			// close connection to API
			connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
