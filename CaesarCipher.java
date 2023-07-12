import java.util.Scanner;

public class CaesarCipher{

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		String message = "";
		String result = "";
		String method = "";
		int ascii = 0;
		int key = 0;
		int chpoint = 0;
		int pos = 0;

		do{
			result = "";

			System.out.print("Enter key: ");
			key = input.nextInt();
			System.out.print("Enter E for Encoding or D for Decoding: ");
			method = input.next();
			method = method.toUpperCase();
			if(method.equals("E")){
				key = -1*key;
			}
			input.nextLine();
			System.out.println("Enter message: ");
			message = input.nextLine();
			message.replaceAll(" ", "");
			
			for(chpoint = 0; chpoint < message.length(); chpoint++){

				ascii = (int)message.charAt(chpoint);

				if(method.equals("E")){

					if((ascii + key) > 90 ){
						result = result + (char)(ascii + key - 26);
					}
					else{
						result = result + (char)(ascii + key);
					}
				}

				else{

					if((ascii + key) < 65){
						result = result + (char)(ascii - key + 26);
					}
					else {
						result = result + (char)(ascii + key);
					}
				}
			}

			System.out.println("Message is \""+ result+"\"");
			System.out.print("Type C to continue or Q to quit: ");
			message = input.next();
			message = message.toUpperCase();
		}

		while(!message.equals("Q"));

		input.close();
	}
}