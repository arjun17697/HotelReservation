package src;

public class HotelDetails {
	private int regular_weekday;
	private int regular_weekend;
	private int reward_weekday;
	private int reward_weekend;
	private int rating;
	private String hotelName;

	public HotelDetails(String hotelName, int regular_weekday, int regular_weekend, int reward_weekday,
			int reward_weekend, int rating) {

		this.hotelName = hotelName;
		this.regular_weekday = regular_weekday;
		this.regular_weekend = regular_weekend;
		this.reward_weekday = reward_weekday;
		this.reward_weekend = reward_weekend;
		this.rating = rating;
	}

	public int getRegular_weekend() {
		return regular_weekend;
	}

	public void setRegular_weekend(int regular_weekend) {
		this.regular_weekend = regular_weekend;
	}

	public int getReward_weekday() {
		return reward_weekday;
	}

	public void setReward_weekday(int reward_weekday) {
		this.reward_weekday = reward_weekday;
	}

	public int getReward_weekend() {
		return reward_weekend;
	}

	public void setReward_weekend(int reward_weekend) {
		this.reward_weekend = reward_weekend;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

}
