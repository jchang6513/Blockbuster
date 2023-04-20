package RentalSystem;

public class PriceTag {
	private int basePrice;
	private int extraPrice;
	private double point;
	private int daysLimit;

	public PriceTag(int basePrice, int extraPrice, double point, int daysLimit) {
	    this.basePrice = basePrice;
	    this.extraPrice = extraPrice;
	    this.point = point;
	    this.daysLimit = daysLimit;
	}

	public int getPrice() {
		return basePrice;
	}

	public int getExtraPrice() {
		return extraPrice;
	}

	public double getPoint() {
		return point;
	}

   public int getDaysLimit() {
		return daysLimit;
	}

}
