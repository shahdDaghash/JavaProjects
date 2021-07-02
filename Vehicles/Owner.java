import java.util.*;

public class Owner implements Cloneable {
	// defining the properties of the class
	String name;
	String regestrationNo;
	String address;
	String tel;
	GregorianCalendar dateOfRegestration;

	public Owner() {
	}

	// defining an argument constructor
	public Owner(String name, String pin, String address, String tel, GregorianCalendar dateOfRegestration) {
		// using setter to check the conditions
		setName(name);
		this.regestrationNo = pin;
		this.address = address;
		setTel(tel);
		setDateOfRegestration(dateOfRegestration);
	}

	// defining getter and setter for name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// defining getter and setter for regestratinNo
	public String getRegestrationNo() {
		return regestrationNo;
	}

	public void setRegestrationNo(String regestrationNo) {
		this.regestrationNo = regestrationNo;
	}

	// defining getter and setter for address
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// defining getter and setter for tel
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		// tel consists of only numbers
		for (int i = 0; i < name.length(); i++) {
			if (tel.charAt(i) >= '1' && tel.charAt(i) <= '9') {
				this.tel = tel;
			} else
				throw new IllegalArgumentException("MobileNo can not contain anything other than number");
		}
	}

	// overriding the clone method to be able to clone deep clone the vehicle class
	@Override
	public Object clone() throws CloneNotSupportedException {
		Owner own = (Owner) super.clone();
		own.dateOfRegestration = (GregorianCalendar) own.dateOfRegestration.clone();
		// we create a copy and then set it to null as required
		own.address = null;
		own.dateOfRegestration = null;
		own.name = null;
		own.regestrationNo = null;
		own.tel = null;

		return own;

	}

	// defining getter and setter for dateOfRegestratin
	public GregorianCalendar getDateOfRegestration() {
		return dateOfRegestration;
	}

	public void setDateOfRegestration(GregorianCalendar dateOfRegestration) {
		// dateOfRegestration needs to be in the past
		if (dateOfRegestration.compareTo(new GregorianCalendar()) > 0)
			throw new IllegalArgumentException("dateOfRegestration can't be in the future");
		else
			this.dateOfRegestration = dateOfRegestration;
	}

	// unique method
	// calculate the time since the owner registered until current time
	public String getTimeFromRegestration() {
		GregorianCalendar current = new GregorianCalendar();
		int days, months, years;
		days = Math.abs(current.get(Calendar.DAY_OF_MONTH) - getDateOfRegestration().get(Calendar.DAY_OF_MONTH));
		if (current.get(Calendar.DAY_OF_MONTH) < getDateOfRegestration().get(Calendar.DAY_OF_MONTH))
			months = Math.abs(current.get(Calendar.MONTH) - getDateOfRegestration().get(Calendar.MONTH)) - 1;
		else
			months = Math.abs(current.get(Calendar.MONTH) - getDateOfRegestration().get(Calendar.MONTH));

		if (current.get(Calendar.MONTH) < getDateOfRegestration().get(Calendar.MONTH))
			years = current.get(Calendar.YEAR) - getDateOfRegestration().get(Calendar.YEAR) - 1;
		else
			years = current.get(Calendar.YEAR) - getDateOfRegestration().get(Calendar.YEAR);

		return "Time from registration is: " + years + " years, " + months + " months, " + days + " days.";
	}

	// overriding toString method that returns the info of the Owner
	@Override
	public String toString() {
		return "Name: " + name + ", RegestrationNo: " + regestrationNo + ", Address: " + address + ", Tel: " + tel
				+ ", Date of Regestration: " + dateOfRegestration + ", Age: " + getTimeFromRegestration() + "\n";
	}

}
