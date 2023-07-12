import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int counter = 0;
        int total = 0;

        while (counter < 10) {
            System.out.print("Enter a grade: ");
            int grade = scanner.nextInt();
            total += grade;
            counter++;
        }

        double average = (double) total / 10;
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
    }
}
