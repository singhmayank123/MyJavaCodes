import java.util.Scanner;

class Main
{
	public static void main(String ags[])
	{
		Scanner obj=new Scanner(System.in);
		System.out.print("enter your name: ");
		String name=obj.nextLine();
		System.out.print("enter your age: ");
		int age=obj.nextInt();
		System.out.print("enter your gender: ");
		char gender=obj.next().charAt(0);

		if((gender == 'm' || gender == 'M') && age>18)
			System.out.println(name+" is "+age+" years old and can go to military");
		else
			System.out.println(name+" is "+age+" years old and can not go to military");
	}
}