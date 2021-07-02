import java.util.Date;

public class TeamLeader extends ProductionWorker {// this class inherits from Employee class
	// defining the properties of TeamLeader class as private properties
	private double monthlyBonus;
	private int requiredHours;
	private int attendedHours;
	private boolean flag = super.isFlag();

	// creating a default constructor
	public TeamLeader() {
		super();// to get the default values from superclass
		// assigning default values
		this.monthlyBonus = 100;
		this.requiredHours = 10;
		this.attendedHours = 15;
	}

	// defining a constructor with fields
	public TeamLeader(String name, String number, Date hireDate, Address address, int shift, double hourlyRate,
			int hoursPerMonth, double monthlyBonus, int requiredHours, int attendedHours) {
		// putting the first values by using the constructor in the superclass
		// the conditions are checked either in toString method or in the main
		super(name, number, hireDate, address, shift, hourlyRate, hoursPerMonth);
		setMonthlyBonus(monthlyBonus);
		setRequiredHours(requiredHours);
		setAttendedHours(attendedHours);
	}

	// getter and setter of monthlyBonus field
	public double getMonthlyBonus() {
		return monthlyBonus;
	}

	public void setMonthlyBonus(double monthlyBonus) {
		if (monthlyBonus >= 0)
			this.monthlyBonus = monthlyBonus;
		else
			flag = false;
	}

	// getter and setter of requiredHours field
	public int getRequiredHours() {
		return requiredHours;
	}

	public void setRequiredHours(int requiredHours) {
		if (requiredHours >= 0)
			this.requiredHours = requiredHours;
		else
			flag = false;
	}

	// getter and setter of attendedHours field
	public int getAttendedHours() {
		return attendedHours;
	}

	public void setAttendedHours(int attendedHours) {
		if (attendedHours >= 0)
			this.attendedHours = attendedHours;
		else
			flag = false;
	}

	public boolean isFlag() {
		return flag;
	}

	public double getTotalSalary() {
		if (flag) {
			// it would be zero if the attended hours are less than the required hours
			double bonusAchieved = getMonthlyBonus() * (getAttendedHours() / getRequiredHours());
			return super.getTotalSalary() + bonusAchieved;
		} else
			return 0;
	}

	// ((((unique)))) method that calculates the bonus percentage of the actual
	// salary
	public double bonusPercentage() {
		if (super.getTotalSalary() > 0)
			return (getMonthlyBonus() / super.getTotalSalary()) * 100.0;
		else
			return -1;
	}

	// defining a toString method the returns the information of the TeamLeader
	@Override
	public String toString() {
		if (flag && super.isFlag()) {
			return super.toString() + "monthlyBonus= " + monthlyBonus + "\n" + "requiredHours= " + requiredHours + "\n"
					+ "attendedHours= " + attendedHours + "\n" + "Total Salary= " + getTotalSalary() + "\n";
		} else
			return "Wrong input(s)";
	}

}
