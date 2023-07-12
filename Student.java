import java.util.Scanner;

public class Student {

	// array to store the grade of 5 student

	public final static int STUD_NUM = 5;
	public static int grades[] = new int[STUD_NUM];

	// method to get the sum of 5 student grades
	public static int getTotal(){

		int sum = 0;

		for(int i : grades)
			sum += i;

		return sum;
	}

	// method to get the average of 5 students 
	public static double getAverage(){

		int total = getTotal();

		double avg = (double) total / STUD_NUM;

		return avg;
	}

// main driver method 
	public static void main(String[] args) {
		
		// to read user input 
		Scanner input = new Scanner(System.in);

		// loop to read grades of 5 students 
		for(int i = 0; i < STUD_NUM; i++){

			System.out.print("Enter your grades: ");
			grades[i] = input.nextInt();

		}

		System.out.println("Total : "+ getTotal());
		System.out.println("Average : "+ getAverage());

	}

}