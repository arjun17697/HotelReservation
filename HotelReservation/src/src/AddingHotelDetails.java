package src;

import java.util.ArrayList;

public class AddingHotelDetails {
	public static void main(String args[]) {
		ArrayList<HotelDetails> hotel= new ArrayList<HotelDetails>();
		HotelDetails hotel1 = new HotelDetails("Lakewood",110,90,80,80,3);
		HotelDetails hotel2 = new HotelDetails("Bridgewood",160,60,110,50,4);
		HotelDetails hotel3 = new HotelDetails("Ridgewood",220,150,100,40,5);
	hotel.add(hotel1);
	hotel.add(hotel2);
	hotel.add(hotel3);
	}
	
	
}
