public class ArrayListDemo{

	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<>();

		list1.add(122);
		list1.add(152);
		list1.add(162);
		list1.add(172);
		list1.add(192);

		list1.print();

		System.out.println();

		//list1.printSubList();

		ArrayList<Integer> sub = list1.subList(1, 4);
		//((SubListClass)sub).print();
	//	sub.
	}


}