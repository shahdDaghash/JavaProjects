public class Minivan extends Vehicles {
	// defining the properties of the class
	private int numberOfSeats;
	private boolean airConditionOn;
	private boolean hasAutoDoors;
	// defining an extra property to calculate 20% of the consumption and store it
	// in this property
	private double twentyPercentfuel;
	// defining an extra static property that returns the number of car objects
	public static int numberOfMinivans = 0;

	// implementing the default constructor
	// we don't need default values since we will be reading from a file
	public Minivan() {
	}

	// defining an argument constructor
	public Minivan(String modelName, String modelNo, String brand, String engineType, double tunkSize,
			double fuelConsumption, Owner owner, int numberOfSeats, boolean hasAutoDoors) {
		// superclass's constructor is used in the subclass
		super(modelName, modelNo, brand, engineType, tunkSize, fuelConsumption, owner);
		// using setter to check the condition
		setNumberOfSeats(numberOfSeats);
		// setting the initial value of the airCondition to false
		this.airConditionOn = false;
		this.hasAutoDoors = hasAutoDoors;
		// calculating 20% of fuelConsumption
		this.twentyPercentfuel = fuelConsumption * 0.2;
		// incrementing numberOfMinivans
		numberOfMinivans++;
	}

	// defining setter and getter for numberOfSeats
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) throws IllegalArgumentException {
		// number of seats in the car needs to be positive
		// also, number of seats in a car can't exceed 20
		if (numberOfSeats > 0 || numberOfSeats < 20)
			this.numberOfSeats = numberOfSeats;
		else
			throw new IllegalArgumentException("numberOfSeats can not be less than 1 or greater than 20");
	}

	// defining a getter for airCondition
	public boolean isAirConditionOn() {
		return airConditionOn;
	}

	// defining setter and getter for hasAutoDoors
	public boolean isHasAutoDoors() {
		return hasAutoDoors;
	}

	public void setHasAutoDoors(boolean hasAutoDoors) {
		this.hasAutoDoors = hasAutoDoors;
	}

	// defining a getter for numberOfMinivans
	public int getNumberOfMinivans() {
		return numberOfMinivans;
	}

	// two methods that will turn the airCondition on or off and update the value of
	// fuelConsumption
	public void setAirConditionON() {
		// the value is set on and consumption updated if it's initially turned off
		if (!isAirConditionOn()) {
			this.airConditionOn = true;
			// subtract 20% of consumption
			this.fuelConsumption = fuelConsumption - twentyPercentfuel;
		}
	}

	public void setAirConditionOFF() {
		// the value is set off and consumption updated if it's initially turned on
		if (isAirConditionOn()) {
			this.airConditionOn = false;
			// add 20% of consumption
			this.fuelConsumption = fuelConsumption + twentyPercentfuel;
		}
	}

	// a method that calculates the cost for 100Km
	public double costFor100Km(PetroleumType n) {
		String engineTypeLower = engineType.toLowerCase();
		double cost;
		// if it's gasoline or hybrid it will be the price of gasoline
		if (engineTypeLower.equals("gasoline") || engineTypeLower.equals("hybrid"))
			cost = (100.0 / getFuelConsumption()) * PetroleumType.getGasolinePrice();
		// else it's the price of diesel (other things are eliminated before getting
		// this far
		else
			cost = (100.0 / getFuelConsumption()) * PetroleumType.getDieselPrice();
		return cost;
	}

	@Override
	public String toString() {
		PetroleumType n = new PetroleumType();
		// we use the toString method implemented in the superclass
		return super.toString() + ", NumberOfSeats: " + numberOfSeats + ", Has Auto Doors: " + hasAutoDoors
				+ ", Movable distance: " + movableDistance() + " Km" + ", Cost for 100 Km: " + costFor100Km(n) + " NIS";
	}

}
