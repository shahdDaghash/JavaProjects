import java.util.Date;

public class ShiftSupervisor extends Employee {// this class inherits from Employee class
	// defining the properties of ShiftSupervisor class as private properties
	private double monthlySalary;
	private double bonus;
	private int produced;
	private int mustProduce;
	private boolean flag = super.isFlag();

	// creating a default constructor
	public ShiftSupervisor() {
		super();// to get the default values from superclass
		// assigning default values
		this.monthlySalary = 100;
		this.bonus = 20;
		this.produced = 40;
		this.mustProduce = 20;
	}

	// defining a constructor with fields
	public ShiftSupervisor(String name, String number, Date hireDate, Address address, double monthlySalary,
			double bonus, int produced, int mustProduce) {
		// putting the first values by using the constructor in the superclass
		// the conditions are checked either in toString method or in the main
		super(name, number, hireDate, address);
		setMonthlySalary(monthlySalary);
		setBonus(bonus);
		setProduced(produced);
		setMustProduce(mustProduce);
	}

	// getter and setter of monthlySalary field
	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		if (monthlySalary >= 0)
			this.monthlySalary = monthlySalary;
		else
			flag = false;
	}

	// getter and setter of bonus field
	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		if (bonus >= 0)
			this.bonus = bonus;
		else
			flag = false;
	}

	// getter and setter of produced field
	public int getProduced() {
		return produced;
	}

	public void setProduced(int produced) {
		if (produced >= 0)
			this.produced = produced;
		else
			flag = false;
	}

	// getter and setter of mustProduce field
	public int getMustProduce() {
		return mustProduce;
	}

	public void setMustProduce(int mustProduce) {
		if (mustProduce >= 0)
			this.mustProduce = mustProduce;
		else
			flag = false;
	}

	public boolean isFlag() {
		return flag;
	}

	public double getTotalSalary() {
		if (flag) {
			if (getProduced() >= getMustProduce())// the condition to get the bonus
				return getMonthlySalary() + getBonus();
			else
				return getMonthlySalary();// the shiftSupervisor doesn't get the bonus
		} else
			return 0;
	}

	// ((((unique)))) method that returns the percentage of produced items
	public double producedPrecentage() {
		double amount = (getProduced()) / getMustProduce();
		return amount * 100;// return the percentage
	}

	// ((((unique)))) method that calculates the bonus percentage of bonus to the
	// actual salary
	public double bonusPercentage() {
		return (getBonus() / getMonthlySalary()) * 100.0;
	}

	// defining a toString method the returns the information of the shiftSupervisor
	@Override
	public String toString() {
		if (flag && super.isFlag())
			return super.toString() + "monthlySalary= " + monthlySalary + "\n" + "bonus= " + bonus + "\n" + "produced= "
					+ produced + "\n" + "mustProduce= " + mustProduce + "\n" + "Total Salary= " + getTotalSalary()
					+ "\n";
		else
			return "Wrong input(s)\n";
	}

}
