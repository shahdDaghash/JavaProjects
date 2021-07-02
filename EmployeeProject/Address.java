//this class is made to be used as a property in the Employee class
public class Address {
	// defining the properties of Address class as private properties
	private String street;
	private String state;
	private String city;
	private int zipCode;

	// creating a default constructor
	public Address() {
		// assigning default values
		this.street = "Lincoln street";
		this.state = "california";
		this.city = "Los Angeles";
		this.zipCode = 635874;
	}

	// defining a constructor with fields
	public Address(String street, String state, String city, int zipCode) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
	}

	// getter and setter of street field
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	// getter and setter of state field
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	// getter and setter of city field
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	// getter and setter of zipCode field
	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [street= " + street + ", state= " + state + ", city= " + city + ", zipCode= " + zipCode + "]";
	}

}
