package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddingHotelDetails {
	static ArrayList<HotelDetails> hotel = new ArrayList<HotelDetails>();

	public static void main(String args[]) {

		HotelDetails hotel1 = new HotelDetails("Lakewood", 110, 90, 80, 80, 3);
		HotelDetails hotel2 = new HotelDetails("Bridgewood", 160, 60, 110, 50, 4);
		HotelDetails hotel3 = new HotelDetails("Ridgewood", 220, 150, 100, 40, 5);
		hotel.add(hotel1);
		hotel.add(hotel2);
		hotel.add(hotel3);

		// Method for UC2
		findCheapestHotel();

	}

	private static void hotelfunction(int weekdays, int weekenddays) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 if you are a regular customer or press 2 in case of reward customer");
		int choice = sc.nextInt();
		HashMap<String, Integer> hotelBill = new HashMap<>();

		switch (choice) {
		case 1:
			List<Integer> priceregular = hotel.stream().map(h -> {
				return h.getRegular_weekday() * weekdays + h.getRegular_weekend() * weekenddays;
			}).collect(Collectors.toList());
			int min = priceregular.get(0);
			String cheapestHotel=null;
			for (int i = 0; i < priceregular.size(); i++) {
				hotelBill.put(hotel.get(i).getHotelName(), priceregular.get(i));
				if (priceregular.get(i)<= min)
					min = priceregular.get(i);
				cheapestHotel=hotel.get(i).getHotelName();
			}
			System.out.println(
					"Cheapest hotel in the given price range is: " + hotelBill.get(min) + "and the bill is:" + min);

			break;

		case 2:
			List<Integer> pricereward = hotel.stream().map(h -> {
				return h.getReward_weekday() * weekdays + h.getReward_weekend() * weekenddays;
			}).collect(Collectors.toList());
			
			int min1 = pricereward.get(0);
			String cheapestHotel1=null;
			for (int i = 0; i < pricereward.size(); i++) {
				hotelBill.put(hotel.get(i).getHotelName(), pricereward.get(i));
				if (pricereward.get(i)<= min1)
					min = pricereward.get(i);
				cheapestHotel1=hotel.get(i).getHotelName();
			}
			System.out.println(
					"Cheapest hotel in the given price range is: " + hotelBill.get(min1) + "and the bill is:" + min1);

			break;
		default:
			System.out.println("Invalid input");
		}
	}

	public static int getWeekdaysBetweenTwoDates(Date startdate, Date enddate) {
		Calendar startCal = Calendar.getInstance();
		startCal.setTime(startdate);

		Calendar endCal = Calendar.getInstance();
		endCal.setTime(enddate);

		int workDays = 0;

		// Return 0 if start and end are the same
		if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
			return 0;
		}

		if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
			startCal.setTime(enddate);
			endCal.setTime(startdate);
		}

		do {
			startCal.add(Calendar.DAY_OF_MONTH, 1);// excluding start date

			if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
					&& startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				++workDays;

			}

		} while (startCal.getTimeInMillis() < endCal.getTimeInMillis()); // excluding end date
		return workDays;
	}

	private static void findCheapestHotel() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the start date in format ddMMyyyy");
		String startdate = sc.nextLine();
		System.out.println("Enter the end date in format ddMMyyyy");
		String enddate = sc.nextLine();
		Date startsfrom = null, endson = null;
		long noDays = 0;

		SimpleDateFormat myFormat = new SimpleDateFormat("ddMMyyyy");
		try {
			startsfrom = myFormat.parse(startdate);
			endson = myFormat.parse(enddate);

			noDays = (endson.getTime() - startsfrom.getTime()) / (1000 * 60 * 60 * 24);
			System.out.println("No. of days: " + noDays);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		int weekdays = getWeekdaysBetweenTwoDates(startsfrom, endson);
		int weekenddays = (int) noDays - weekdays;

		List<Integer> price = hotel.stream().map(h -> {
			return h.getRegular_weekday() * weekdays + h.getRegular_weekend() * weekenddays;
		}).collect(Collectors.toList());

		for (int i : price)
			System.out.println(+i);

	}
}
