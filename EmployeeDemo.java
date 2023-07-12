import java.util.Scanner; 

public class EmployeeDemo
{
	public static void main(String[] args)
	{
		String name, empNumber, hireDate;
		int shift;
		double payRate;

	
		Scanner keyboard = new Scanner(System.in);

		//Get the employees information from the user.
		System.out.println("Enter the following information of the employee ");
		System.out.print("Name: ");
		name = keyboard.nextLine();

	

			System.out.print("Employee Number: ");
			empNumber = keyboard.nextLine();

			System.out.print("Hire Date:");
			hireDate = keyboard.nextLine();

			System.out.print("Which Shift 1 or 2: ");
			shift = keyboard.nextInt();

			System.out.print("Pay Rate: ");
			payRate = keyboard.nextDouble();

			ProductionWorker prodWorker = new ProductionWorker(name, empNumber, hireDate, shift, payRate);

			System.out.println();
			System.out.println("Here is the information of the Employee");
			System.out.println("Name: " + prodWorker.getName());
			System.out.println("Employee Number: " + prodWorker.getEmpNumber());
			System.out.println("Hire Date: " + prodWorker.getHireDate());
			System.out.println("Shift: " + prodWorker.getShift());
			System.out.println("Pay Rate: " + prodWorker.getPayRate());
				
	}

}
