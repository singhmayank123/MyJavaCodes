import java.util.*;
public class Assignment6 {
public static void main (String[] args) {

    Scanner console = new Scanner (System.in);
    String choice;
   char command;

   int num1, num2;

   Fraction currFrac = new Fraction(0, 1);
   Fraction result;

   System.out.println("*** Start of Program ***");
   printMenu();
   System.out.println("Value:"+currFrac.toString());
   do
   {
       System.out.println("\n[Please enter a command or type ?] ");
       choice = console.next().toLowerCase();
       command = choice.charAt(0);

       switch (command)
           {
                case 'c':
                currFrac = new Fraction(0, 1);
                System.out.println("Value:"+currFrac.toString());
                break;
                case '*':
                   System.out.println("[Enter two numbers for a fraction to MULTIPLY] ");
                   num1 = console.nextInt(); num2 = console.nextInt();
                   Fraction frac2 = new Fraction(num1, num2);
                   result = Fraction.multiply(currFrac,frac2);
                   System.out.println(currFrac.toString() + " * "+frac2.toString()
                    +" = "+ result.toString());
                   currFrac.numerator = result.numerator;
                   currFrac.denominator = result.denominator;                  
                   System.out.println("\nValue:"+currFrac.toString());
                   break;
                case '/':
                   System.out.println("[Enter two numbers for a fraction to DIVIDE] ");
                   num1 = console.nextInt(); num2 = console.nextInt();
                   frac2 = new Fraction(num1, num2);
                   result = Fraction.divide(currFrac,frac2);
                    System.out.println(currFrac.toString() + " / "+frac2.toString()
                    +" = "+ result.toString());
                   currFrac.numerator = result.numerator;
                   currFrac.denominator = result.denominator;    
                   System.out.println("\nValue:"+currFrac.toString());
                   break;
               case '+':
                   System.out.println("[Enter two numbers for a fraction to ADD] ");
                   num1 = console.nextInt(); num2 = console.nextInt();
                   frac2 = new Fraction(num1, num2);
                   result = Fraction.add(currFrac,frac2);
                   System.out.println(currFrac.toString() + " + "+frac2.toString()
                    +" = "+ result.toString());
                   currFrac.numerator = result.numerator;
                   currFrac.denominator = result.denominator;     
                   System.out.println("\nValue:"+currFrac.toString());
                   break;
               case '-':
                   System.out.println("[Enter two numbers for a fraction to SUBTRACT] ");
                   num1 = console.nextInt(); num2 = console.nextInt();
                   frac2 = new Fraction(num1, num2);
                   result = Fraction.subtract(currFrac,frac2);
                    System.out.println(currFrac.toString() + " - "+frac2.toString()
                    +" = "+ result.toString());
                   currFrac.numerator = result.numerator;
                   currFrac.denominator = result.denominator;  
                   System.out.println("\nValue:"+currFrac.toString());
                   break;
               case '?':
                   printMenu();
                   break;
               case 'q':
                   break;
               default:
                   System.out.println("[Invalid input] " + command);
                   break;
           }
       } while (command != 'q');
       System.out.println("*** End of Program ***");
   }

public static void printMenu()
{
   System.out.print(
               "\nCommand Options\n"
               +"-----------------------------------\n"
               +"c: reset the value\n"
               +"+: add a fraction to the current value\n"
               +"-: subtract a fraction from the current value\n"
               +"*: multiply a fraction to the current value\n"
               +"/: divide the current value by a fraction\n"
               +"?: display the menu again\n"
               +"q: quit this program\n\n");
   }
}