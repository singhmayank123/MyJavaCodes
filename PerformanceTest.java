/** rename the modified class to ThreeHeapIntPriorityQueue
 * to compare the differences **/

import java.util.Random;

public class PerformanceTest{

	public static Random rand = new Random();

	public static int getRandVal(int min, int max){
		int value = rand.nextInt(max) + min;
		return value;
	}

	public static void main(String[] args) {
		
		// create an object of HeapIntPriorityQueue
		HeapIntPriorityQueue heap1 = new HeapIntPriorityQueue();
		// create an object of ThreeHeapIntPriorityQueue
		ThreeHeapIntPriorityQueue heap2 = new ThreeHeapIntPriorityQueue();

		// create both the heaps with random values 

		long start = 0, stop = 0;

		final int MAX_SIZE = 5000000;

		int arr[] = new int[MAX_SIZE];

		for(int i = 0; i < MAX_SIZE; i++){
			arr[i] = getRandVal(1, MAX_SIZE);
		}

		start = System.currentTimeMillis();

		for(int i = 0; i < MAX_SIZE; i++){
			heap1.add(arr[i]);
		}

		stop = System.currentTimeMillis();

		System.out.println("Insertion time for binary heap: "
			+ (stop - start) + " milliSeconds");

		stop = 0; start = 0;

		start = System.currentTimeMillis();

		for(int i = 0; i < MAX_SIZE; i++){
			heap2.add(arr[i]);
		}

		stop = System.currentTimeMillis();

		System.out.println("Insertion time for 3-ary heap: "
			+ (stop - start) + " milliSeconds");

		stop = 0; start = 0;

		start = System.currentTimeMillis();

		while(!heap1.isEmpty())
			heap1.remove();

		stop = System.currentTimeMillis();

		System.out.println("deletion time for binary heap: "
			+ (stop - start) + " milliSeconds");

		start = System.currentTimeMillis();

		while(!heap2.isEmpty())
			heap2.remove();

		stop = System.currentTimeMillis();

		System.out.println("deletion time for 3-ary heap: "
			+ (stop - start) + " milliSeconds");

	}
}