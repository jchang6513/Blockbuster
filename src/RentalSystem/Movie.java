package RentalSystem;

public class Movie {
	private String movieName;
	private PriceTag priceTag;

	public Movie(String movieName, PriceTag priceTag) {
		this.movieName = movieName;
		this.priceTag = priceTag;
   }

	public String getMovieName() {
		return movieName;
	}

	public PriceTag getPriceTag() {
		return priceTag;
	}
}
