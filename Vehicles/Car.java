public class Car extends Vehicles {
	// defining the properties of the class
	private int numberOfSeats;
	private boolean airCondition;
	// defining an extra property to calculate 10% of the consumption and store it
	// in this property
	private double tenPercentfuel;
	// defining an extra static property that returns the number of car objects
	public static int numberOfCars = 0;

	// implementing the default constructor
	// we don't need default values since we will be reading from a file
	public Car() {
	}

	// defining an argument constructor
	public Car(String modelName, String modelNo, String brand, String engineType, double tankSize,
			double fuelConsumption, Owner owner, int numberOfSeats) {
		// superclass's constructor is used in the subclass
		super(modelName, modelNo, brand, engineType, tankSize, fuelConsumption, owner);
		// using setters to check the condition
		setEngineType(engineType);
		setNumberOfSeats(numberOfSeats);
		// setting the initial value of the airCondition to false
		this.airCondition = false;
		// calculating 10% of fuelConsumption
		this.tenPercentfuel = fuelConsumption * 0.1;
		// incrementing numberOfCars
		numberOfCars++;
	}

	// overriding the setter of engineType so the new condition apply
	// new Condition: cars can only be gasoline or hybrid
	@Override
	public void setEngineType(String engineType) throws IllegalArgumentException {
		// comparing it after making it lower case since easier
		String engineTypeLower = engineType.toLowerCase();
		if (engineTypeLower.equals("gasoline") || engineTypeLower.equals("hybrid"))
			this.engineType = engineType;
		else
			throw new IllegalArgumentException("Mismatch engineType");
	}

	// defining getter and setter for numberOfSeats
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) throws IllegalArgumentException {
		// number of seats in the car needs to be positive
		// also, number of seats in a car can't exceed 9
		if (numberOfSeats > 0 || numberOfSeats < 9)
			this.numberOfSeats = numberOfSeats;
		else
			throw new IllegalArgumentException("numberOfSeats can not be less than 1 or greater than 8");
	}

	// defining a getter for airCondition
	public boolean isAirCondition() {
		return airCondition;
	}

	// defining a getter for numberOfCars
	public int getNumberOfCars() {
		return numberOfCars;
	}

	// two methods that will turn the airCondition on or off and update the value of
	// fuelConsumption
	public void setAirConditionON() {
		// the value is set on and consumption updated if it's initially turned off
		if (!isAirCondition()) {
			this.airCondition = true;
			// subtract 10% of consumption
			this.fuelConsumption = fuelConsumption - tenPercentfuel;
		}
	}

	public void setAirConditionOFF() {
		// the value is set off and consumption updated if it's initially turned on
		if (isAirCondition()) {
			this.airCondition = false;
			// add 10% of consumption
			this.fuelConsumption = fuelConsumption + tenPercentfuel;
		}
	}

	// a method that calculates the cost for 100Km
	public double costFor100Km(PetroleumType n) {
		double cost;
		cost = (100.0 / getFuelConsumption()) * PetroleumType.getGasolinePrice();
		return cost;
	}

	// overriding toString method that returns the info of the car
	@Override
	public String toString() {
		PetroleumType n = new PetroleumType();
		// we use the toString method implemented in the superclass
		return super.toString() + ", NumberOfSeats: " + numberOfSeats + ", Movable distance: " + movableDistance()
				+ " Km" + ", Cost for 100 Km: " + costFor100Km(n) + " NIS";
	}

}
