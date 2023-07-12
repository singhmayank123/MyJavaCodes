import java.util.*;

public class HeroGuitar{

	public static void fillQueue(double min, double max, 
		int sizeOfSamples, Queue<Double> samples){

		System.out.println("Filling the queue with random values b/w -1/2 and 1/2");

		double value = 0;

		while(sizeOfSamples > 0){

			value = (Math.random() * ((max - min))) + min;

			samples.add(value);

			sizeOfSamples--;
		}
	}

	second = second + first - 2*second;
	second += (first - 2*second);

	public static void runKarplusStrongAlgo(Queue<Double> samples){

		System.out.println("Running the karplus strong algorithm....");
		double first = samples.remove();
		double second = samples.peek();

		double updateFreq = 0.996 * 0.5 * (first + second);

		samples.add(updateFreq);
	}

	public static void printSamples(Queue<Double> samples){

		System.out.println("The samples data are: ");

		for(double d : samples){
			System.out.printf("%.2f " , d);
		}

		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Queue<Double> samples = new LinkedList<>();

		final int SAMPLING_RATE = 44100;

		Scanner console = new Scanner(System.in);

		System.out.print("Enter the initial note's frequency: ");

		int note_freq = console.nextInt();

		int sizeOfSamples = SAMPLING_RATE / note_freq;

		System.out.println(sizeOfSamples);

		fillQueue(-0.5, 0.5, sizeOfSamples, samples);

		printSamples(samples);

		System.out.print("How many times do you want to iterate the algorithm? ");

		int num_iterations = console.nextInt();

		while(num_iterations > 0){
			runKarplusStrongAlgo(samples);
			num_iterations--;
		}

		printSamples(samples);


	}

}