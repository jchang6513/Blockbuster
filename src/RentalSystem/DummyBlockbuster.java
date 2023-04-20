package RentalSystem;

public class DummyBlockbuster {
	private static final String CUSTOMER_APRIL = "April";
	private static final String CUSTOMER_JOE = "Joe";
	private static final String MOVIE_WONDER_WOMAN = "神力女超人";
	private static final String MOVIE_JUSTICE_LEAGUE = "正義聯盟";
	private static final String MOVIE_THOR_3 = "雷神索爾3";
	
	public static void main(String[] args) {
		CRM crm = new CRM();
		
		// create customer April, Joe
	    crm.createCustomer(CUSTOMER_APRIL);
	    crm.createCustomer(CUSTOMER_JOE);
	    
	    // 神力女超人 舊片, 正義聯盟超人 新片, 雷神索爾3 新片
	    crm.createMovie(MOVIE_WONDER_WOMAN, new OldMoviePriceTag());
	    crm.createMovie(MOVIE_JUSTICE_LEAGUE, new NewMoviePriceTag());
	    crm.createMovie(MOVIE_THOR_3, new NewMoviePriceTag());
	    
	    // April 神力女超人 3天
	    crm.createRental(CUSTOMER_APRIL, MOVIE_WONDER_WOMAN, 3);
	    // Joe 神力女超人 2天
	    crm.createRental(CUSTOMER_JOE, MOVIE_WONDER_WOMAN, 2);
	    // April 正義聯盟 5天
	    crm.createRental(CUSTOMER_APRIL, MOVIE_JUSTICE_LEAGUE, 5);
	    // Joe 雷神索爾3 1天
	    crm.createRental(CUSTOMER_JOE, MOVIE_THOR_3, 1);
	    
	    // print April 報表
	    crm.printStatement(CUSTOMER_APRIL);
	    // print Joe 報表
	    crm.printStatement(CUSTOMER_JOE);
	}
}
