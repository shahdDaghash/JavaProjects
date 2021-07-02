public class PetroleumType {
	//defining the constants
	public static final int DIESEL = 1;
	public static final int GASOLINE = 2;
	//defining the prices and setting their initial value
	private static double gasolinePrice = 5.23;
	private static double dieselPrice = 4.02;

	//defining setter and getter for gasolinePrice
	public static double getGasolinePrice() {
		return gasolinePrice;
	}
	public static void setGasolinePrice(double gasolinePrice) throws IllegalArgumentException {
		//can't be negative
		if (gasolinePrice >= 0)
			PetroleumType.gasolinePrice = gasolinePrice;
		else
			throw new IllegalArgumentException("gasolinePrice can not be negative");
	}
	
	//defining setter and getter for dieselPrice
	public static double getDieselPrice() {
		//can't be negative
		return dieselPrice;
	}
	public static void setDieselPrice(double dieselPrice) throws IllegalArgumentException {
		if (dieselPrice >= 0)
			PetroleumType.dieselPrice = dieselPrice;
		else
			throw new IllegalArgumentException("dieselPrice can not be negative");
	}

}
