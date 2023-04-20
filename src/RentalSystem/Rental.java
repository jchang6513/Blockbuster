package RentalSystem;

public class Rental {
	private Customer customer;
	private Movie movie;
	private SnapshotPriceTag priceTag;
	private int rentalDays;

	public Rental(Customer customer, Movie movie, int rentalDays) {
		this.customer = customer;
		this.movie = movie;
		this.rentalDays = rentalDays;

    PriceTag moviePriceTag = movie.getPriceTag();
    this.priceTag = new SnapshotPriceTag(
    		moviePriceTag.getPrice(),
    		moviePriceTag.getExtraPrice(),
    		moviePriceTag.getPoint(),
    		moviePriceTag.getDaysLimit()
    		);
	}
	
	public Customer getCustomer() {
	    return customer;
	    }

	public Movie getMovie() {
	    return movie;
	    }

	public SnapshotPriceTag getPriceTag() {
	    return priceTag;
	    }

	public int getRentalDays() {
	    return rentalDays;
	    }
}
