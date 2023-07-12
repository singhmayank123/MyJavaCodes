import java.io.File;
import java.util.*;
import java.util.Map.Entry;  

/** PowerBall class **/
public class PowerBall{

/** Method that sorts a list in descending order and returns
 * the sorted list **/
	public static ArrayList<Integer>
	 getSortedCommonNums(ArrayList<Integer> common_numbers){

// create the hashmap to store the number and the frequencies 
	 	HashMap<Integer, Integer> hmap = new HashMap<>();
// push the keys and the frequencies in the hash map 
	 	for(int i = 1; i < common_numbers.size(); i++){
	 		hmap.put(i, common_numbers.get(i));
	 	}

// sort  the hash map in descending order by values 

		//LinkedHashMap preserve the ordering of elements in which they are inserted
		LinkedHashMap<Integer, Integer> reverseSortedMap = new LinkedHashMap<>();
		 
		//Use Comparator.reverseOrder() for reverse ordering
		hmap.entrySet()
		    .stream()
		    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
		    .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

		 /** push the sorted values again in the array list **/

		int i = 0;
		
		for (Entry<Integer, Integer> entry : reverseSortedMap.entrySet()){ 

			common_numbers.set(i++, entry.getKey()); 
		}  
		 
	   	return common_numbers;
	}

	public static void main(String[] args) {

		ArrayList<String> lines = new ArrayList<>();
		try{

			File file = new File("pbnumbers.txt");
			Scanner readFile = new Scanner(file);

			while(readFile.hasNextLine()){
				lines.add(readFile.nextLine());			
			}

			ArrayList<Integer> frequency_of_powerball_numbers = new ArrayList<Integer>(70);
			ArrayList<Integer> frequency_of_normal_numbers = new ArrayList<Integer>(70);
			ArrayList<Integer> common_numbers = new ArrayList<Integer>(70);
			LinkedList<Integer> overdue_numbers = new LinkedList<Integer>();

			// fill with zeroes 
			for(int i = 0; i<70; i++){

				frequency_of_powerball_numbers.add(0);
				frequency_of_normal_numbers.add(0);
				common_numbers.add(0);
			}

			for(int i = 0; i<lines.size(); i++){

				String line = lines.get(i);
	
				String []numbers = line.split(" ");

				for(int j = 0; j < 6; j++){

					int num = Integer.parseInt(numbers[j]);
		
					// if is in the list 
					if(overdue_numbers.indexOf(num) != -1){
						overdue_numbers.remove(overdue_numbers.indexOf(num));				
					}
					
					overdue_numbers.add(num);
				
					if(common_numbers.get(num) == 0){
						common_numbers.set(num, 1);				
					}
					else{
						common_numbers.set(num, common_numbers.get(num) + 1);
					}
				
					if(j < 5 && frequency_of_normal_numbers.get(num) == 0){
						frequency_of_normal_numbers.set(num, 1);
						
					}
					else{
						frequency_of_normal_numbers.set(num,
						 frequency_of_normal_numbers.get(num) + 1);
					}

			
					if(j >= 5 && frequency_of_powerball_numbers.get(num) == 0){
						frequency_of_powerball_numbers.set(num, 1);	
					}
					else if(j >= 5){
						
						frequency_of_powerball_numbers.set(num,
						 frequency_of_powerball_numbers.get(num) + 1);
					}
				}
			}

			common_numbers = getSortedCommonNums(common_numbers);
			printTenMostCommonNums(common_numbers);
			printTenLeastCommonNums(common_numbers);
			printTopTenOverDue(overdue_numbers);
			printFreqOfNormalNums(frequency_of_normal_numbers);
			printFreqOfPBNums(frequency_of_powerball_numbers);
		}

		catch(Exception e){
			System.out.println("Error:"+e.getMessage());
			e.printStackTrace();
		}

	}

	public static void printTenMostCommonNums(List<Integer> list){

		System.out.print("\nThe 10 most common numbers: ");
		
		for(int i = 1; i <= 10; i++){
			System.out.print(list.get(i) + " ");
		}
	}

	public static void printTenLeastCommonNums(List<Integer> list){

		System.out.print("\nThe 10 least common numbers: ");
		
		for(int i = list.size() - 10; i < list.size(); i++){
			System.out.print(list.get(i) + " ");
		}
	}

	public static void printTopTenOverDue(List<Integer> list){

		System.out.print("\nThe top ten overdue numbers: ");
		for(int i = 1; i <= 10; i++){
			System.out.print(list.get(i)+" ");
		}
	}

	public static void printFreqOfNormalNums(List<Integer> list){

		System.out.println("\nfrequency of normal numbers 1-69: ");
		
		for(int i = 1; i < list.size(); i++){
			System.out.println(i + " = "+list.get(i));
		}
	}

	public static void printFreqOfPBNums(List<Integer> list){

		System.out.println("\nfrequency of powerball numbers 1-26: ");
		
		for(int i = 1; i <=26; i++){
			System.out.println(i + " = "+list.get(i));
		}
	}
}