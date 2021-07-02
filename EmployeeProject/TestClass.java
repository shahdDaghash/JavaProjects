import java.util.*;

public class TestClass {
	public static void main(String[] args) {
		// defining the ArrayList that will contains the objects
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(new ProductionWorker("Muna", "545-M", new Date(), new Address("Shawqi", "Jenin", "Jenin", 69857), 2, 10,
				-180));
		emp.add(new ProductionWorker("Kamel", "124-L", new Date(110, 5, 5),
				new Address("main", "Ramallah", "Ramallah", 65834), 1, 10, 100));
		emp.add(new ProductionWorker("Ahmad", "123-M", new Date(120, 4, 25),
				new Address("municipality", "Betunia", "Ramallah", 46957), -1, 30, 250));
		emp.add(new ShiftSupervisor("Leena", "488-A", new Date(), new Address(), 1000, 50, 100, 50));
		emp.get(2).setHireDate(new Date(119, 11, 31));
		emp.add(new ShiftSupervisor("Lana", "44F-F", new Date(120, 4, 27),
				new Address("main", "Ramallah", "Ramallah", 65834), 500, 20, -10, 20));
		emp.add(new TeamLeader("Eyad", "123-A", new Date(110, 10, 25),
				new Address("second", "Ramallah", "Ramallah", 67589), 1, 10, 300, 100, 50, 55));
		emp.add(new TeamLeader("Mohammad", "123-M", new Date(),
				new Address("municipality", "Betunia", "Ramallah", 46957), 2, 50, -160, 100, 5, 4));
		// printing the information of all employees
		for (int i = 0; i < emp.size(); i++) {
			if (emp.get(i).isFlag()) {
				System.out.println(emp.get(i).toString());
				System.out.println("------------------------------------");
			}
		}
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		// method that prints the employees with a salary higher than the average
		salaryPrint(emp);
		// this method prints the methods implemented in the classes
		uniqueMethods(emp);
		// two (((unique))) methods that print two extra things
		liveInRamallah(emp);
		firstEmployee(emp);

	}

	public static void salaryPrint(ArrayList<Employee> emp) {
		double sum = 0;
		int counter = 0;
		for (int i = 0; i < emp.size(); i++) {
			// check what class the object is from
			if (emp.get(i) instanceof TeamLeader) {
				// check if the flag is true
				if (((TeamLeader) emp.get(i)).isFlag()) {
					// add the salary to the sum
					sum += ((TeamLeader) emp.get(i)).getTotalSalary();
					// increment the counter
					counter++;
				}
			} else if (emp.get(i) instanceof ProductionWorker) {
				if (((ProductionWorker) emp.get(i)).isFlag()) {
					sum += ((ProductionWorker) emp.get(i)).getTotalSalary();
					counter++;
				}
			} else if (emp.get(i) instanceof ShiftSupervisor) {
				if (((ShiftSupervisor) emp.get(i)).isFlag()) {
					sum += ((ShiftSupervisor) emp.get(i)).getTotalSalary();
					counter++;
				}
			}
		}
		// calculate the average
		double average = sum / counter;
		// a for loop to print the objects that have a salary higher than the average
		for (int i = 0; i < emp.size(); i++) {
			if (emp.get(i) instanceof TeamLeader) {
				if (((TeamLeader) emp.get(i)).isFlag())
					if (((TeamLeader) emp.get(i)).getTotalSalary() > average) {
						System.out.println("TeamLeader: \n" + ((TeamLeader) emp.get(i)).toString());
						System.out.println("-----------------------------------------------");

					}
			} else if (emp.get(i) instanceof ShiftSupervisor) {
				if (((ShiftSupervisor) emp.get(i)).isFlag()) {
					if (((ShiftSupervisor) emp.get(i)).getTotalSalary() > average) {
						System.out.println("ShiftSupervisor: \n" + ((ShiftSupervisor) emp.get(i)).toString());
						System.out.println("-----------------------------------------------");

					}
				}
			} else if (emp.get(i) instanceof ProductionWorker) {
				if (((ProductionWorker) emp.get(i)).isFlag()) {
					if (((ProductionWorker) emp.get(i)).getTotalSalary() > average) {
						System.out.println("ProductionWorker: \n" + ((ProductionWorker) emp.get(i)).toString());
						System.out.println("-----------------------------------------------");
					}
				}

			}
		}
		System.out.println("**************************************");
	}

	// method for all unique methods
	public static void uniqueMethods(ArrayList<Employee> emp) {
		System.out.println("A list of employee name, number and the number of full years they have been working");
		// printing the name number and yearsWorking for each employee with a true flag
		for (int i = 0; i < emp.size(); i++) {
			if (emp.get(i).isFlag()) {
				System.out.println("Name: " + emp.get(i).getName() + ", Number: " + emp.get(i).getNumber()
						+ " number of years working: " + emp.get(i).yearsWorking());
				System.out.println("------------------------------");
			}
		}
		System.out.println("*****************************************");
		System.out.println("A list for the shiftSupervisor employees with their produced items percentage");
		// printing the name number and produced percentage for each shiftSupervisor
		// employee with a true flag
		for (int i = 0; i < emp.size(); i++) {
			if (emp.get(i) instanceof ShiftSupervisor) {
				if (((ShiftSupervisor) emp.get(i)).isFlag()) {
					System.out.print("Name: " + emp.get(i).getName() + ", Number: " + emp.get(i).getNumber()
							+ " produced items percentage: ");
					System.out.printf("%.2f", ((ShiftSupervisor) emp.get(i)).producedPrecentage());
					System.out.println("%");
					System.out.println("---------------------------");
				}
			}
		}
		System.out.println("*****************************************");
		System.out.println(
				"A list of the ShiftSupervisor or Teamleader employees with their bonus ppercentage of the salary");
		// printing the name number and bonus percentage for each teamLeader employee
		// and shiftSupervisor employee with a true flag
		for (int i = 0; i < emp.size(); i++) {
			if (emp.get(i) instanceof ShiftSupervisor) {
				if (((ShiftSupervisor) emp.get(i)).isFlag()) {
					if (((ShiftSupervisor) emp.get(i)).bonusPercentage() != -1) {
						System.out.print("ShiftSupervisor: Name: " + emp.get(i).getName() + ", Number: "
								+ emp.get(i).getNumber() + " bonus percentage: ");
						System.out.printf("%.2f", ((ShiftSupervisor) emp.get(i)).bonusPercentage());
						System.out.println("%");
						System.out.println("---------------------------");
					}
				}
			} else if (emp.get(i) instanceof TeamLeader) {
				if (((TeamLeader) emp.get(i)).isFlag()) {
					if (((TeamLeader) emp.get(i)).bonusPercentage() != -1) {
						System.out.print("TeamLeader: Name: " + emp.get(i).getName() + ", Number: "
								+ emp.get(i).getNumber() + " bonus percentage: ");
						System.out.printf("%.2f", ((TeamLeader) emp.get(i)).bonusPercentage());
						System.out.println("%");
						System.out.println("---------------------------");
					}
				}
			}
		}
		System.out.println("****************************************");

	}

	// (((unique))) method that prints the number of people living in the city
	// Ramallah
	public static void liveInRamallah(ArrayList<Employee> emp) {
		int numInRamallah = 0;
		for (int i = 0; i < emp.size(); i++) {
			if (emp.get(i).getAddress().getCity() == "Ramallah" && emp.get(i).isFlag())
				numInRamallah++;
		}
		System.out.println("Number of people who live in Ramallah = " + numInRamallah);
		System.out.println("****************************************");
	}

	// (((unique))) method that prints the employee who has been working the longest
	public static void firstEmployee(ArrayList<Employee> emp) {
		Date oldest = emp.get(0).getHireDate();
		int o = 0;
		for (int i = 1; i < emp.size(); i++) {
			if (emp.get(i).isFlag()) {
				if (emp.get(i).getHireDate().compareTo(oldest) < 0) {
					oldest = emp.get(i).getHireDate();
					o = i;
				}
			}
		}
		System.out.println("Info of the employee who has been working the longest:");
		System.out.println(emp.get(o).toString());
		System.out.println("****************************************");
	}

}
