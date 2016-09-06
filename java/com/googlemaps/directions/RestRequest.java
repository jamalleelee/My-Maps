package com.googlemaps.directions;

import java.util.Scanner;

/**
 * Class that gets and stores user input and sends it to Google Map API
 * 
 * @author Jamal McDowell
 * @since 09-06-2016
 */
public class RestRequest {

	public static void main(String[] args) {

		// starting point for directions
		String origin = null;

		// ending point for directions
		String destination = null;

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter the starting location:");

		// getting input from user
		origin = sc.nextLine();

		System.out.println("Please enter your destination:");

		// getting input from user
		destination = sc.nextLine();

		// calling Google map method and sending it user input.
		ConnectToGoogleMapAPI.connectingToGoogleMapAPI(origin, destination);

	}

}
