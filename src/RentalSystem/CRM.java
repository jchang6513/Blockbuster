package RentalSystem;

import java.util.ArrayList;
import java.util.List;

public class CRM {
	private List<Customer> customers = new ArrayList<Customer>();
	private List<Movie> movies = new ArrayList<Movie>();
	private List<Rental> rentals = new ArrayList<Rental>();

	public CRM() {}

	public void createCustomer(String customerName) {
	    customers.add(new Customer(customerName));
	    }

	public Customer getCustomerByCustomerName(String customerName) {
		for (Customer customer : customers) {
			if (customer.getName().equals(customerName)) {
		        return customer;
			}
		}
	return null;
	}

	public void createMovie(String movieName, PriceTag priceTag) {
		movies.add(new Movie(movieName, priceTag));
	}

	public Movie getMovieByMovieName(String movieName) {
		for (Movie movie : movies) {
			if (movie.getMovieName().equals(movieName)) {
		        return movie;
			}
		}
		return null;
	}

	public void updateMoviePriceTag(String movieName, PriceTag priceTag) {
		Movie movie = getMovieByMovieName(movieName)
		movie.updatePriceTag(priceTag)
	}

	public void createRental(String customerName, String movieName, int days) {
		Customer customer = getCustomerByCustomerName(customerName);
		Movie movie = getMovieByMovieName(movieName);
		if (customer == null || movie == null) {
			throw new Error("customer or movie not exist");
		}
		rentals.add(new Rental(customer, movie, days));
	}

	public void printStatement(String customerName ) {
		Customer customer = getCustomerByCustomerName(customerName);
		List<Rental> rentalOfCustomer = getRentalsByCustomer(customer);

		int totalPrice = 0;
	    double totalPoint = 0;

	    System.out.println(String.format("%s 的租借紀錄:", customerName));

	    // 過去租過的片子
	    for (Rental rental : rentalOfCustomer) {
	    	Movie movie = rental.getMovie();
	    	SnapshotPriceTag priceTag = rental.getPriceTag();
	    	totalPrice += calculateRentalPrice(priceTag, rental.getRentalDays());
	        totalPoint += priceTag.getPoint();
	        System.out.println(movie.getMovieName());
	    }

	    // 總消費金額
	    System.out.println(String.format("總消費金額: %s", totalPrice));

	    // 總累積點數
	    System.out.println(String.format("總累積點數: %s", totalPoint));
	}

	private List<Rental> getRentalsByCustomer(Customer customer) {
		List<Rental> rentalsOfCustomer = new ArrayList<Rental>();
		for (Rental rental : rentals) {
			Customer theCustomerOfCurrentRental = rental.getCustomer();
			if (theCustomerOfCurrentRental.equals(customer)) {
				rentalsOfCustomer.add(rental);
			}
		}

		return rentalsOfCustomer;
	}

	private int calculateRentalPrice(PriceTag priceTag, int daysCount) {
		int rentalPrice = priceTag.getPrice();
		int extraPrice = priceTag.getExtraPrice();
		int daysLimit = priceTag.getDaysLimit();

		if(daysCount > daysLimit) {
			rentalPrice += (daysCount - daysLimit) * extraPrice;
		}

		return rentalPrice;
	}
}
