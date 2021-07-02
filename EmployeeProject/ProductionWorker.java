import java.util.Date;

public class ProductionWorker extends Employee {// this class inherits from Employee class
	// defining the properties of ProductionWorker class as private properties
	private int shift;
	private double hourlyRate;
	private int hoursPerMonth;
	private boolean flag = super.isFlag();

	// creating a default constructor
	public ProductionWorker() {
		super(); // to get the default values from superclass
		// assigning default values
		this.shift = 1;
		this.hourlyRate = 1;
		this.hoursPerMonth = 208;
	}

	// defining a constructor with fields
	public ProductionWorker(String name, String number, Date hireDate, Address address, int shift, double hourlyRate,
			int hoursPerMonth) {
		// putting the first values by using the constructor in the superclass
		// the conditions are checked either in toString method or in the main
		super(name, number, hireDate, address);
		setShift(shift); // the condition is checked in the toString method and the getTotalSalary method
		setHourlyRate(hourlyRate);
		setHoursPerMonth(hoursPerMonth);
	}

	// getter and setter of shift field
	public int getShift() {
		return shift;
	}

	public void setShift(int shift) {
		if (shift == 1 || shift == 2)
			this.shift = shift;
		else {
			flag = false;
		}
	}

	// getter and setter of hourlyRate field
	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		if (hourlyRate >= 0)
			this.hourlyRate = hourlyRate;
		else
			flag = false;
	}

	// getter and setter of hoursPerMonth field
	public int getHoursPerMonth() {
		return hoursPerMonth;
	}

	public void setHoursPerMonth(int hoursPerMonth) {
		if (hoursPerMonth >= 0)
			this.hoursPerMonth = hoursPerMonth;
		else
			flag = false;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isFlag() {
		return flag;
	}

	public double getTotalSalary() {
		if (flag) {
			if (getShift() == 1) {// for day shift
				// the first 208 days will get normal rate and the rest will get 1.25 the rate
				return (208 * getHourlyRate() + (getHoursPerMonth() - 208) * 1.25 * getHourlyRate());
			} else if (getShift() == 2) { // for night shift
				// the first 182 days will get normal rate and the rest will get 1.5 the rate
				return (182 * getHourlyRate() + (getHoursPerMonth() - 182) * 1.5 * getHourlyRate());
			} else
				return 0;
		} else
			return 0; // else if the shift is neither 1 nor 2

	}

	// ToString method
	@Override
	public String toString() {
		if (flag && super.isFlag()) {
			return super.toString() + "Shift= " + getShift() + "\n" + "hourly Rate= " + getHourlyRate() + "\n"
					+ "Hours per month= " + getHoursPerMonth() + "\n" + "Total Salary= " + getTotalSalary() + "\n";
		} else
			return "Wrong Input(s)\n";
	}

}
