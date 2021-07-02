public class Truck extends Vehicles {
	// defining the properties of the class
	private boolean airConditionOn;
	private int power;
	private int numberOfSeats;
	// defining an extra property to calculate 20% of the consumption and store it
	// in this property
	private double twentyPercentfuel;
	// defining an extra static property that returns the number of car objects
	public static int numberOfTrucks = 0;
	public static int sumOfPower=0;
	// implementing the default constructor
	// we don't need default values since we will be reading from a file
	public Truck() {
	}

	// defining an argument constructor
	public Truck(String modelName, String modelNo, String brand, String engineType, double tunkSize,
			double fuelConsumption, Owner owner, int numberOfSeats, int power) {
		// superclass's constructor is used in the subclass
		super(modelName, modelNo, brand, engineType, tunkSize, fuelConsumption, owner);
		// using setter to check the condition
		setEngineType(engineType);
		setNumberOfSeats(numberOfSeats);
		// setting the initial value of the airCondition to false
		this.airConditionOn = false;
		setPower(power);
		// calculating 20% of fuelConsumption
		this.twentyPercentfuel = fuelConsumption * 0.2;
		// incrementing numberOfTrucks
		numberOfTrucks++;
		sumOfPower+=power;
	}

	// overriding the setter of engineType so the new condition apply
	// new Condition: cars can only be gasoline or hybrid
	public void setEngineType(String engineType) throws IllegalArgumentException {
		// comparing it after making it lower case since easier
		String engineTypeLower = engineType.toLowerCase();
		if (engineTypeLower.equals("diesel"))
			this.engineType = engineType;
		else
			throw new IllegalArgumentException("Mismatch engineType");
	}

	// defining a getter for airCondition
	public boolean isAirConditionOn() {
		return airConditionOn;
	}

	// defining getter and setter for power
	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		if (power > 0)
			this.power = power;
		else
			throw new IllegalArgumentException("Power of the truck can not be negative");
	}

	// defining getter and setter for numberOfSeats
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) throws IllegalArgumentException {
		// number of seats in the car needs to be positive
		// also, number of seats in a car can't exceed 10(personal estimation)
		if (numberOfSeats > 0 || numberOfSeats < 10)
			this.numberOfSeats = numberOfSeats;
		else
			throw new IllegalArgumentException("numberOfSeats can not be less than 1 or greater than 10");
	}

	// defining a getter for numberOfTrucks
	public int getNumberOfTrucks() {
		return numberOfTrucks;
	}
	
	public int getSumOfPower() {
		return sumOfPower;
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
		double cost;
		cost = (100.0 / getFuelConsumption()) * PetroleumType.getDieselPrice();
		return cost;
	}

	@Override
	public String toString() {
		PetroleumType n = new PetroleumType();
		// we use the toString method implemented in the superclass
		return super.toString() + ", NumberOfSeats: " + numberOfSeats + ", Power: " + power + ", Movable distance: "
				+ movableDistance() + " Km" + ", Cost for 100 Km: " + costFor100Km(n) + " NIS";
	}

}
