import java.io.*; // for Files 
import java.util.*; // for util classes 

/** Class that implements the Comparator interface to 
 * the compare method for sorting the Gas lists prices 
 * from low to high */
class sortLowTohigh implements Comparator<GasPrices>{
    public int compare(GasPrices a, GasPrices b)
    {
        if(a.price - b.price > 0) return 1;
        return -1;
    }
}

/** Class that implements the Comparator interface to 
 * the compare method for sorting the Gas lists prices 
 * from high to low */
class sortHighTolow implements Comparator<GasPrices>{
    public int compare(GasPrices a, GasPrices b)
    {
        if(a.price - b.price < 0) return 1;
        return -1;
    }
}

/** Public class that implments the gas prices functionality */
public class GasPrices{

	public int monthNum; // stores the month number 
	public int dayNum; // stores the day number
	public int year; // stores the year number 
	public float price; // stores the average gas prices per gallon 
	/** An static array list to store the GasPrices object */
    public static  ArrayList<GasPrices> gasPrices = new ArrayList<GasPrices>(); 
	private static int startYear = 1993; // start year of the prices list
	private static int endYear = 2013; // year of end 
	

	/* A constructor that initializes the instance variables */
	public GasPrices(int monthNum, int dayNum, int year, float price){

		this.monthNum = monthNum;
		this.dayNum = dayNum;
		this.year = year;
		this.price = price;
	}

	/* A method that prints the averages gas prices for each year starting from 
	startYear to endYear */
	public static void printYearAverage(){	

		int range = (endYear - startYear + 1); 

		double total[] = new double[range]; 

		int j = 0; 

		int count = 0; 

		for(int i = 0; i < range; i++){ 

			count = 0;

			while(gasPrices.get(j).year == (startYear + i)){

				total[i] += gasPrices.get(j).price;

				j++; 
				count++; 

				if(j == gasPrices.size())
					break;
			}
			System.out.printf("Averages prices for year %d: %.2f\n", (startYear + i), total[i]/(count));
		}

	}	

	/* A method that prints the average of each month in the file */
	public static void getMonthAverage(){

		double[] monthAverages = new double[12];
        int[] count = new int[12];
		int j = 0;

		for(int i = 0; i < 12; i++){
            for(j = 0; j < gasPrices.size(); j++){
                if(gasPrices.get(j).monthNum == i+1){
                    monthAverages[i] += gasPrices.get(j).price;
                    count[i]++;
                }
            }
        }
        for(int i = 0; i < 12; i++){
            System.out.printf("Averages prices for month %d: %.2f\n", i+1, monthAverages[i]/(count[i]));
        }
	}

	/* A method that prints the highest and lowest gas price in a year */
	public static void highAndLowPriceinYear(){

		int range = (endYear - startYear + 1);

		GasPrices high = gasPrices.get(0) , low = gasPrices.get(0);

		int j = 0; 

		for(int i = 0; i<range; i++){

			high = gasPrices.get(j);
			low = gasPrices.get(j);

			while(gasPrices.get(j).year == (startYear + i)){

				if(gasPrices.get(j).price > high.price)
					high = gasPrices.get(j); 

				if(gasPrices.get(j).price < low.price)
					low = gasPrices.get(j);			

				j++;

				if(j >= gasPrices.size()) 
					break;
			}

			System.out.printf("Highest price in year %d : %.2f\n", (startYear + i), high.price);
			System.out.println("Date: "+high.monthNum+"-"+high.dayNum+"-"+high.year);
			System.out.printf("Lowest price in year %d : %.2f\n", (startYear + i), low.price);
			System.out.println("Date: "+low.monthNum+"-"+low.dayNum+"-"+low.year);

		}

	}

	/* A method that sorts the gasPrices arraylist from low to high prices
	and prints them */

	public static void sortLowToHighByPrice(){

		Collections.sort(gasPrices, new sortLowTohigh());
		System.out.println("\nBelow are the sorted details from high to low");
		for(GasPrices g: gasPrices){
		 	System.out.println(g.monthNum+"-"+g.dayNum+"-"+g.year + ":" + g.price);
		}
	}


	/* A method that sorts the gasPrices arraylist from high to low prices 
	and prints them */

	public static void sortHighToLowByPrice(){

		Collections.sort(gasPrices, new sortHighTolow());
		System.out.println("\nBelow are the sorted details from low to high");

		for(GasPrices g: gasPrices){
			System.out.println(g.monthNum+"-"+g.dayNum+"-"+g.year + ":" + g.price);
		}

	}

	/* main driver method */

    public static void main(String[] args) throws Exception {

    /* create a File object to open and reference the file "GasPrices.txt" */
        File file = new File("GasPrices.txt");
    /* check the existence of the file */
        if(!file.exists()){
            System.out.println("Cannot open the file.");
            System.exit(0);
        }
    /* create an instance of Scanner class to read the contents from the file */
        Scanner inputFile = new Scanner(file);

    /* keep reading the content from file until the file has a next line */
        while(inputFile.hasNextLine()){

            String line = inputFile.nextLine(); // read each line from file 
            String[] data = line.split("[-:]"); // filter the words of line using split method 

        /* convert the contents to the required data type */
            int monthNum = Integer.parseInt(data[0]);
            int dayNum = Integer.parseInt(data[1]);
            int year = Integer.parseInt(data[2]);
            float price = Float.parseFloat(data[3]);

        /* add the gasPrices oject type to the arrayList */
            gasPrices.add(new GasPrices(monthNum, dayNum, year, price));

        }
		
       	printYearAverage(); // prints average year data 
        getMonthAverage(); // prints average months data 
        highAndLowPriceinYear(); // prints high and low price with date in year 
        sortHighToLowByPrice(); // prints the sorted price lists from high to low 
        sortLowToHighByPrice(); // prints the sorted price lists from low to high 

    }
}