public abstract class Vehicles implements Comparable<Vehicles>, Cloneable {
	// defining the protected properties of the class
	protected String modelName;
	protected String modelNo;
	protected String brand;
	protected String engineType;
	protected double tankSize;
	protected double fuelConsumption;
	public Owner owner;

	// implementing the default constructor
	// we don't need default values since we will be reading from a file
	public Vehicles() {
	}

	// implementing an argument constructor
	public Vehicles(String modelName, String modelNo, String brand, String engineType, double tunkSize,
			double fuelConsumption, Owner owner) {
		this.modelName = modelName;
		// use the setter to check for conditions
		setModelNo(modelNo);
		this.brand = brand;
		// use the setters to chaeck for conditions
		setEngineType(engineType);
		setTankSize(tunkSize);
		setFuelConsumption(fuelConsumption);
		this.owner = owner;

	}

	// defining a setter and getter for modelName
	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	// defining a setter and getter for modelNo
	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		// modelNo should be written in capitals so I compare between the one entered an
		// the upper case of it
		// if they are equal it means that the entered one is all capitals
		String upperModelNo = modelNo.toUpperCase();
		if (upperModelNo.equals(modelNo))
			this.modelNo = modelNo;
		// else it contains lower case letter, so we throw IllegalArgumentException
		else
			throw new IllegalArgumentException("ModelNo should be all capitals");
	}

	// defining a setter and getter for brand
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	// defining setter and getter for engineType
	public String getEngineType() {
		return engineType;
	}

	public void setEngineType(String engineType) throws IllegalArgumentException {
		// engineType can consist of lower cases and upper cases so I make it easier by
		// comparing it after making it lower case
		String engineTypeLower = engineType.toLowerCase();
		// if it's gasoline or hybrid or diesel it will be fine, anything else is wrong
		if (engineTypeLower.equals("gasoline") || engineTypeLower.equals("diesel") || engineTypeLower.equals("hybrid"))
			this.engineType = engineType;
		else
			throw new IllegalArgumentException("Mismatch engineType");
	}

	// defining a setter and getter for tankSize
	public double getTankSize() {
		return tankSize;
	}

	public void setTankSize(double tankSize) throws IllegalArgumentException {
		// tankSize should be a positive number
		if (tankSize > 0)
			this.tankSize = tankSize;
		else
			throw new IllegalArgumentException("TankSize has to be grater than 0");
	}

	// defining a setter and getter for fuelConsumption
	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		// fuel consumption should be positive number
		if (fuelConsumption > 0)
			this.fuelConsumption = fuelConsumption;
		else
			throw new IllegalArgumentException("fuelConsumption has to be grater than 0");

	}

	// defining a setter and getter for owner
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	// defining abstract classes that will be implemented in subclasses
	public abstract double costFor100Km(PetroleumType n);

	public abstract void setAirConditionON();

	public abstract void setAirConditionOFF();

	// method that returns the number of kiloMeters that a car can go with full tank
	public double movableDistance() {
		return getTankSize() * getFuelConsumption();
	}

	// Overriding compareTo method for Vehicle to compare by the cost
	@Override
	public int compareTo(Vehicles v) {
		PetroleumType n = new PetroleumType();
		if (costFor100Km(n) > v.costFor100Km(n))
			return 1;
		else if (costFor100Km(n) < v.costFor100Km(n))
			return -1;
		return 0;

	}

	// overriding the clone method to be able to clone ojects of type vehicle
	@Override
	public Object clone() throws CloneNotSupportedException {
		// make a copy that clones the object
		Vehicles copy = (Vehicles) super.clone();
		// deep cloning for Owner since it's an object that makes a reference
		// so we need to make a copy by deep cloning
		copy.owner = (Owner) owner.clone();

		return copy;
	}

	// unique method that returns a string stating if the fuelConsumption of the car
	// is considered good or bad
	public String isGoodOrBad() {
		// according to researches on the internet, 16.5 is the number dividing good
		// from bad
		if (getFuelConsumption() > 16.5) {
			return "good fuel consumption";
		} else
			return "bad fuel consumption";
	}

	// overriding toString method that returns the info of the vehicle
	@Override
	public String toString() {
		return "ModelName: " + modelName + ", brand: " + brand + ", Owner: " + owner.name + ", EngineType: "
				+ engineType + ", TankSize: " + tankSize + ", FuelConsumption: " + fuelConsumption;
	}

}
