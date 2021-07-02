import java.util.Date;

public class Employee {
	// defining the properties of Employee class as private properties
	private String name;
	private String number;
	private Date hireDate; // defining hireDate as a date object
	private Address address; // Using a created class Address to store all the address components
	private boolean flag = true;

	// creating a default constructor of Employee
	public Employee() {
		// assigning default values
		this.name = "Lama";
		this.number = "123-M";
		this.hireDate = new Date();
		this.address = new Address();
	}

	// defining a constructor with fields
	public Employee(String name, String number, Date hireDate, Address address) {
		// the conditions are checked either in toString method or in the main
		this.name = name;
		setNumber(number);
		setHireDate(hireDate);
		this.address = address;
	}

	// getter and setter of name field
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// getter and setter of number field
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		if (isEmpNumberValid(number))
			this.number = number;
		else
			flag = false;
	}

	// getter and setter of hireDate field
	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		if (isDateValid(hireDate))
			this.hireDate = hireDate;
		else
			flag = false;
	}

	// getter and setter of address field
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public boolean isFlag() {
		return flag;
	}

	// method to check if the hireDate entered is true or not
	public boolean isDateValid(Date hireDate) {
		Date currentDate = new Date();
		if (currentDate.compareTo(hireDate) >= 0)// meaning that the currentDate comes after hireDate or is the same day
			return true;
		else
			return false;
	}

	public boolean isEmpNumberValid(String number) {
		// we want to see if it's of the valid type
		if (number.contains("-")) {// making sure it has the hyphen so we can split it into two parts
			// since the number has at least one hyphen in it, we split the number to check
			// each part
			String[] parts = number.split("-");
			if (parts.length != 2)// if there are more than one hyphen then the length would be higher than 2, and
									// that is wrong
				return false;
			// check if the length of the number is 3 and each char is between 1 and 9
			if (parts[0].charAt(0) >= '0' && parts[0].charAt(0) <= '9' && parts[0].charAt(1) >= '0'
					&& parts[0].charAt(1) <= '9' && parts[0].charAt(2) >= '0' && parts[0].charAt(2) <= '9'
					&& parts[0].length() == 3) {
				// then check parts[2] if the letter is greater than A and less than Z and it's
				// only one letter (length of 1)
				if (parts[1].charAt(0) >= 'A' && parts[1].charAt(0) <= 'M' && parts[1].length() == 1) {
					// so, all conditions apply, return true
					return true;
				} else
					return false;
			} else
				return false;
		} else
			return false;
	}

	// ((((unique)))) method that gets the number of full years the employee had
	// been working so far
	public int yearsWorking() {
		if (isDateValid(getHireDate())) {
			Date currentDate = new Date();// defining a variable of type date that stores the date of the current day
			return currentDate.getYear() - getHireDate().getYear(); // simple subtraction operation
		} else
			return -1;
	}

	// defining a toString method the returns the information of the employee
	@Override
	public String toString() {
		if (flag)
			return "name= " + name + "\n" + "number= " + number + "\n" + "hireDate= " + hireDate + "\n" + "address= "
					+ address + "\n";
		else
			return "Wrong input(s)\n";

	}

}
