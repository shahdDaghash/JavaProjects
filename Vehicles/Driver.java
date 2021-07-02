import java.util.*;
import java.io.*;

public class Driver {

	public static void main(String[] args) throws IllegalArgumentException, CloneNotSupportedException, IOException {

		File myFile = new File("inputdata.txt"); // defining a file for input
		Scanner scFile = new Scanner(myFile); // scanner from file
		Scanner sc = new Scanner(System.in); // scanner from console
		File output = new File("output.txt"); // file for output
		FileWriter outFile = new FileWriter(output, false);
		PrintWriter out = new PrintWriter(outFile, true); // defining a PrintWriter and store the FileWriter in it

		ArrayList<Vehicles> veh = new ArrayList<Vehicles>(); // defining an ArrayList that will include the vehicles
																// objects

		// while loop that will repeat until exiting from the program
		while (true) {
			// show the menu in the console
			displayMenu();
			// variable to store the choice
			int choice = sc.nextInt();
			// create a switch depending on choice
			switch (choice) {
			case 1:// read from file
				one(veh, myFile, sc, scFile, out);
				break;
			case 2:// set prices of petroleum
				two(sc);
				break;
			case 3:// sort by costFor100KM
					// when there are elements to sort
				if (veh.size() > 0)
					three(veh, out);
				else
					System.out.println("Can't sort with no elements");
				break;
			case 4:// sort by name
					// when there are elements to sort
				if (veh.size() > 0)
					four(veh, out);
				else
					System.out.println("Can't sort with no elements");
				break;
			case 5:// sort by brand
					// when there are elements to sort
				if (veh.size() > 0)
					five(veh, out);
				else
					System.out.println("Can't sort with no elements");
				break;
			case 6:// clone
					// when there are elements to clone
				if (veh.size() > 0)
					six(veh, sc, out);
				else
					System.out.println("Can't clone with no elements");
				break;
			case 7:// turn air-condition on/off
				seven(veh, sc);
				break;
			case 8:// write output after sorting
				eight(veh, out);
				break;
			case 9:// exit from program after closing everything
				sc.close();
				scFile.close();
				out.flush();
				out.close();
				System.exit(0);
				break;
			case 10:// enter the menu of unique methods
				// infinite loop until told to break
				while (true) {
					// display the menu of unique methods
					uniqueMenu();
					char select = sc.next().charAt(0);
					switch (select) {
					case 'a':
						numberOfRefills(veh, sc, out);
						break;
					case 'b':
						percentageOfEachType(veh, out);
						break;
					case 'c':
						c(veh, out);
						break;
					case 'd':
						d(veh, out);
						break;
					case 'e':
						e(veh,out);
						break;
					case 'f':
						break;
					default: // none of the listed letters is entered
						System.out.println("Wrong selection, Try again please");
					}
					// if asked to break, break the while loop so we get back to the other menu
					if (select == 'f')
						break;
				}
				break;
			default: // none of the listed numbers is entered
				System.out.println("Wrong choice, Try again please");
			}
		}
	}

	public static void displayMenu() {
		// new line
		System.out.println("");
		System.out.println("Choose one of the following by entering the number:");
		System.out.println("1. Read new data from the file and store them.");
		System.out.println("2. Set prices of Petroleum");
		System.out.println("3. Print sorted order Vehicles in an ascending order based on COSTFOR100KM.");
		System.out.println("4. Print sorted order Vehicles in an ascending order based on OWNER NAME.");
		System.out.println("5. Print sorted order Vehicles in an ascending order based on BRAND.");
		System.out.println("6. Clone Vehicle without owner.");
		System.out.println("7. Turn air-condition on/off.");
		System.out.println("8. Write Output on the output.txt file after sorting them.");
		System.out.println("9. Exit from System.");
		System.out.println("10. Execute unique methods.");
	}

	public static void uniqueMenu() {
		System.out.println("");
		System.out.println("Choose one of the following by entering the suitable letter to execute unique methods:");
		System.out.println("a. Print number of refills a vehicle needs to go k KMs.");
		System.out.println("b. Print percentage of each type of vehicle.");
		System.out.println("c. Print for each car if the fuel Consumption is good or bad.");
		System.out.println("d. Print Time from registration for each owner(Years,months,days).");
		System.out.println("e. Print the average power and the trucks with power above average and the ones under average.");
		System.out.println("f. Return to the main menu.");
	}

	// method one reads the input file
	public static void one(ArrayList<Vehicles> veh, File myFile, Scanner sc, Scanner scFile, PrintWriter out) {
		// read all lines
		while (scFile.hasNext()) {
			String line = scFile.nextLine();
			StringBuilder nextLine = new StringBuilder(line);
			String lowerLine = nextLine.toString().toLowerCase();
			// if it's car object
			if (lowerLine.matches("car.*")) {
				String[] parts = line.split(",");
				// wrong number of elements
				if (parts.length != 9) {
					sc.close();
					scFile.close();
					out.close();
					throw new IllegalArgumentException("Wrong input for car");
				} else {
					// creating an Owner object to put it in the car object
					Owner owner = new Owner(parts[4].trim(), "54G7", "Ramallah", "123123123",
							new GregorianCalendar(1999, 5, 20));
					// use trim to get rid of any spacing not needed
					// use parseInt and parseDouble to convert from String to int/double
					veh.add(new Car(parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[5].trim(),
							Double.parseDouble(parts[6].trim()), Double.parseDouble(parts[7].trim()), owner,
							Integer.parseInt(parts[8].trim())));
				}
				// else if it's minivan's object
			} else if (lowerLine.matches("minivan.*")) {
				String[] parts = line.split(",");
				// wrong number of elements
				if (parts.length != 10) {
					sc.close();
					scFile.close();
					out.close();
					throw new IllegalArgumentException("Wrong input for Minivan");
				} else {
					// creating an Owner object to put it in the minivan object
					Owner owner = new Owner(parts[4].trim(), "7777", "Tulkarem", "123456789",
							new GregorianCalendar(2010, 11, 30));
					// use trim to get rid of any spacing not needed
					// use parseInt and parseDouble to convert from String to int/double

					// if statement to see if hasAutoDoors is true or false
					if (parts[9].toLowerCase().matches(".*true.*"))
						veh.add(new Minivan(parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[5].trim(),
								Double.parseDouble(parts[6].trim()), Double.parseDouble(parts[7].trim()), owner,
								Integer.parseInt(parts[8].trim()), true));
					else if (parts[9].toLowerCase().matches(".*false.*"))
						veh.add(new Minivan(parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[5].trim(),
								Double.parseDouble(parts[6].trim()), Double.parseDouble(parts[7].trim()), owner,
								Integer.parseInt(parts[8].trim()), false));
					else {// neither true nor false
						sc.close();
						scFile.close();
						out.close();
						throw new IllegalArgumentException("Wrong input for hasAutoDoors");
					}
				}
				// else if it's truck's object
			} else if (lowerLine.matches("truck.*")) {
				String[] parts = line.split(",");
				// wrong number of elements
				if (parts.length != 10) {
					sc.close();
					scFile.close();
					out.close();
					throw new IllegalArgumentException("Wrong input for Minivan");
				} else {
					// creating an Owner object to put it in the minivan object
					Owner owner = new Owner(parts[4].trim(), "1010", "Hebron", "123789456",
							new GregorianCalendar(2019, 1, 2));
					// use trim to get rid of any spacing not needed
					// use parseInt and parseDouble to convert from String to int/double
					veh.add(new Truck(parts[1].trim(), parts[2].trim(), parts[3].trim(), parts[5].trim(),
							Double.parseDouble(parts[6].trim()), Double.parseDouble(parts[7].trim()), owner,
							Integer.parseInt(parts[8].trim()), Integer.parseInt(parts[9].trim())));
				}
			}

		}
		System.out.println("Information has been read successfully");
	}

	// method two to setPrices of petroleum
	public static void two(Scanner sc) {
		//ask the user which one they want to change
		System.out.println("Enter the corresponding number to change the price:");
		System.out.println("1 for DIESEL");
		System.out.println("2 for Gasoline");
		//read the number entered
		int entry = sc.nextInt();
		//if the entered number equals the value of diesel set in the PetroleumType class
		if (entry == PetroleumType.DIESEL) {// equals 1
			System.out.println("Enter the price of Diesel:");
			//read the new value and set it as the new value of gasoline
			PetroleumType.setGasolinePrice(sc.nextDouble());
		//if the entered number equals the value of gasoline set in the PetroleumType class
		} else if (entry == PetroleumType.GASOLINE) {// equals 2
			System.out.println("Enter the price of gasoline:");
			//read the new value and set it as the new value of diesel
			PetroleumType.setDieselPrice(sc.nextDouble());
		//else if the number entered is neither 1 nor 2
		} else {
			throw new IllegalArgumentException("Wrong input for price changing");
		}
		System.out.println("Setting the price is completed");
	}

	// method three to sort by costFor100Km
	public static void three(ArrayList<Vehicles> veh, PrintWriter out) {
		out.println("List sorted by COSTFOR100KM:");
		System.out.println("List sorted by COSTFOR100KM:");
		// when sorting the arrayList, it will be sorted based on cost according to how
		// the compareTo method was implemented
		Collections.sort(veh);
		for (int i = 0; i < veh.size(); i++) {
			// print to the console and the file
			out.println(veh.get(i).toString());
			System.out.println(veh.get(i).toString());
		}
		// new Lines
		out.println(
				"........................................................................................................................................");
		System.out.println(
				"........................................................................................................................................");
	}

	// method four to sort by name
	public static void four(ArrayList<Vehicles> veh, PrintWriter out) {
		out.println("List sorted by NAME:");
		System.out.println("List sorted by NAME:");
		Vehicles temp;
		// bubble sorting
		for (int i = 0; i < veh.size() - 1; i++) {
			for (int j = 0; j < veh.size() - i - 1; j++) {
				if (veh.get(j).owner.getName().compareTo(veh.get(j + 1).owner.getName()) > 0) {
					temp = veh.get(j);
					// when removing an object, the whole arraylist will be shifted to the left
					veh.remove(j);
					// add at the next position
					veh.add(j + 1, temp);
				}
			}
		}
		for (int i = 0; i < veh.size(); i++) {
			// print to the console and the file
			out.println(veh.get(i).toString());
			System.out.println(veh.get(i).toString());
		}
		// new Lines
		out.println(
				"........................................................................................................................................");
		System.out.println(
				"........................................................................................................................................");
	}

	// method five to sort by brand
	public static void five(ArrayList<Vehicles> veh, PrintWriter out) {
		out.println("List sorted by BRAND:");
		System.out.println("List sorted by BRAND:");
		Vehicles temp;
		// bubble sorting
		for (int i = 0; i < veh.size() - 1; i++) {
			for (int j = 0; j < veh.size() - i - 1; j++) {
				if (veh.get(j).getBrand().compareTo(veh.get(j + 1).getBrand()) > 0) {
					temp = veh.get(j);
					// when removing an object, the whole arraylist will be shifted to the left
					veh.remove(j);
					// add at the next position
					veh.add(j + 1, temp);
				}
			}
		}
		for (int i = 0; i < veh.size(); i++) {
			// print to the console and the file
			out.println(veh.get(i).toString());
			System.out.println(veh.get(i).toString());
		}
		// new Lines
		out.println(
				"........................................................................................................................................");
		System.out.println(
				"........................................................................................................................................");

	}

	// method 6 to clone an object
	public static void six(ArrayList<Vehicles> veh, Scanner sc, PrintWriter out) throws CloneNotSupportedException {
		System.out.println("Choose one from the following list:");
		for(int i=0;i<veh.size();i++) {
			System.out.println((i+1)+"  "+veh.get(i).toString());
		}
		System.out.println("What is your selection:");
		// choose the object to clone
		int i = sc.nextInt();

		if (i > 0 && i <= veh.size()) {
			// if it's a car object
			if (veh.get(i - 1) instanceof Car) {
				Car cloned = (Car) veh.get(i - 1).clone();
				out.println("cloned car is: " + cloned.toString());
				System.out.println("cloned car is: " + cloned.toString());

				// else if it's a minivan object
			} else if (veh.get(i - 1) instanceof Minivan) {
				Minivan cloned = (Minivan) veh.get(i - 1).clone();
				out.println("cloned minivan is: " + cloned.toString());
				System.out.println("cloned minivan is: " + cloned.toString());

				// else a truck object
			} else {
				Truck cloned = (Truck) veh.get(i - 1).clone();
				out.println("cloned truck is: " + cloned.toString());
				System.out.println("cloned Truck is: " + cloned.toString());
			}
		} else {
			System.out.println("Vehicle does not exist");
		}
		// new Lines
		out.println(
				"........................................................................................................................................");
		System.out.println(
				"........................................................................................................................................");
	}

	//method seven to turn on/off the condition
	public static void seven(ArrayList<Vehicles> veh, Scanner sc) {
		System.out.println("Press 1 to turn air-condition ON");
		System.out.println("Press 2 to turn air-condition OFF");
		//read the selection
		int selection = sc.nextInt();
		if (selection == 1) {
			//turn the air-condition on for all elements of the arrayList
			for (int i = 0; i < veh.size(); i++)
				veh.get(i).setAirConditionON();
			System.out.println("Air-Condition is set on");
		} else if (selection == 2) {
			for (int i = 0; i < veh.size(); i++)
				veh.get(i).setAirConditionOFF();
			System.out.println("Air-Condition is set off");
		} else //else neither 1 nor 2 are selected
			System.out.println("Wrong selection");
	}

	//method eight that prints the sorted list to the file
	public static void eight(ArrayList<Vehicles> veh, PrintWriter out) {
		out.println("Sorted list:");
		System.out.println("Sorted list:");
		//sort the list based on costFor100Km
		Collections.sort(veh);
		//print the elements on the console and in the file
		for (int i = 0; i < veh.size(); i++) {
			out.println(veh.get(i).toString());
			System.out.println(veh.get(i).toString());
		}
		// new Lines
		out.println(
				"........................................................................................................................................");
		System.out.println(
				"........................................................................................................................................");
	}

	// unique method
	// method that returns the number of times we need to refill the tank to go k
	// kms starting from full tank
	// it prints model name, brand, and result
	public static void numberOfRefills(ArrayList<Vehicles> veh, Scanner sc, PrintWriter out) {
		System.out.println("Enter number of kilos:");
		//read # of kilos the cars need to go
		double k = sc.nextDouble();
		for (int i = 0; i < veh.size(); i++) {
			//distance divided by movable distance
			int result = (int) (k / veh.get(i).movableDistance());
			//print some information with number of refills needed
			out.println("ModelName: " + veh.get(i).getModelName() + ", brand: " + veh.get(i).getBrand()
					+ ", Number of refills needed to go " + k + " kms: " + result);
			System.out.println("ModelName: " + veh.get(i).getModelName() + ", brand: " + veh.get(i).getBrand()
					+ ", Number of refills needed to go " + k + " kms: " + result);
		}
		// new Lines
		out.println(
				"........................................................................................................................................");
		System.out.println(
				"........................................................................................................................................");

	}

	// unique methods
	//print the percentage of each type to the total number
	//extra properties have been defined in the classes for counting purposes
	public static void percentageOfEachType(ArrayList<Vehicles> veh, PrintWriter out) {
		//total number of cars
		double sum = Car.numberOfCars + Truck.numberOfTrucks + Minivan.numberOfMinivans;
		//caculate percentage of each type
		double percentageOfCars = (Car.numberOfCars / sum) * 100;
		double percentageOfMinivans = (Minivan.numberOfMinivans / sum) * 100;
		double percentageOfTrucks = (Truck.numberOfTrucks / sum) * 100;
		//print the results
		System.out.println("The percentage of each type:");
		out.println("The percentage of each type:");
		System.out.println("Percentage Of cars: " + percentageOfCars + "% , Percentage Of Minivans: "
				+ percentageOfMinivans + "% , Percentage Of Trucks: " + percentageOfTrucks + "%.");
		out.println("Percentage Of cars: " + percentageOfCars + "% , Percentage Of Minivans: " + percentageOfMinivans
				+ "% , Percentage Of Trucks: " + percentageOfTrucks + "%.");
		// new Lines
		out.println(
				"........................................................................................................................................");
		System.out.println(
				"........................................................................................................................................");

	}

	//prints wether the fuel consumption of the car is good or bad (number taken to compare is based on researches)
	public static void c(ArrayList<Vehicles> veh, PrintWriter out) {
		System.out.println("Status of fuel consumption:");
		out.println("Status of fuel consumption:");
		//I use a method I already implemented in the Vehicles class
		for (int i = 0; i < veh.size(); i++) {
			out.println("ModelName: " + veh.get(i).getModelName() + ", brand: " + veh.get(i).getBrand() + ", status: "
					+ veh.get(i).isGoodOrBad());
			System.out.println("ModelName: " + veh.get(i).getModelName() + ", brand: " + veh.get(i).getBrand()
					+ ", status: " + veh.get(i).isGoodOrBad());
		}
		// new Lines
		out.println(
				"........................................................................................................................................");
		System.out.println(
				"........................................................................................................................................");

	}

	//print the time from registration (days,months,years)
	public static void d(ArrayList<Vehicles> veh, PrintWriter out) {
		System.out.println("Time from registration:");
		out.println("Time from registration:");
		for (int i = 0; i < veh.size(); i++) {
			out.println("ModelName: " + veh.get(i).getModelName() + ", brand: " + veh.get(i).getBrand()
					+ "Time from Regestration: " + veh.get(i).owner.getTimeFromRegestration());
			System.out.println("ModelName: " + veh.get(i).getModelName() + ", brand: " + veh.get(i).getBrand()
					+ veh.get(i).owner.getTimeFromRegestration());
		}
		// new Lines
		out.println(
				"........................................................................................................................................");
		System.out.println(
				"........................................................................................................................................");

	}
	
	//print the average power of trucks with the trucks above average and trucks less than the average
	public static void e(ArrayList<Vehicles> veh, PrintWriter out) {
		//calculate the average
		double result = (double)Truck.sumOfPower / Truck.numberOfTrucks;
		//print the average
		System.out.println("The average power of trucks is: "+ result);
		out.println("The average power of trucks is: "+ result);
		System.out.println("Trucks with power above the average:");
		out.println("Trucks with power above the average:");
		for(int i =0; i<veh.size();i++) {
			if(veh.get(i) instanceof Truck) {
				//if above average
				if(((Truck)veh.get(i)).getPower()>=result) {
					System.out.println(veh.get(i).toString());
					out.println(veh.get(i).toString());
				}
			}
		}
		System.out.println("Trucks with power less than the average:");
		out.println("Trucks with power less than the average:");
		for(int i =0; i<veh.size();i++) {
			if(veh.get(i) instanceof Truck) {
				//if less than average
				if(((Truck)veh.get(i)).getPower()<result) {
					System.out.println(veh.get(i).toString());
					out.println(veh.get(i).toString());
				}
			}
		}
		
	}

}
