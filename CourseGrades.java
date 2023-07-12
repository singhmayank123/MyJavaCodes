/** This is main class that includes main method and 
 * allows to find the grades and scores */
/** This file can be tested on Eclipse IDE, java 11 */

public class CourseGrades implements Analyzable{
	
	/** A GradedActivity type array */
	private GradedActivity[] grades; 

	/** A no-arg constructor that initializes the initial object state of 
	 * GradedActivity array */

	public CourseGrades(){
	// Allocate memory for 4 elements
		grades = new GradedActivity[4];

	// Initialize defalut object state of each reference 
		grades[0] = new LabActivity(0);
		grades[1] = new PassFailExam(0);
		grades[2] = new Essay(0,0,0,0);
		grades[3] = new FinalExam(0);
	}

	/** This method accepts an object type of labActivity that holds the 
	 * student's score. The index 0 element references this object */

	public void setLab(GradedActivity ga){
		grades[0] = ga;
	}

	/** This method accepts an object type of PassFailExam that holds the 
	 * student's score. The index 1 element references this object */

	public void setPassFailExam(GradedActivity ga){
		grades[1] = ga;
	}

	/** This method accepts an object type of Essay that holds the 
	 * student's score. The index 0 element references this object */

	public void setEssay(GradedActivity ga){
		grades[2] = ga;
	}

	/** This method accepts an object type of FinalExam that holds the 
	 * student's score. The index 0 element references this object */

	public void setFinalExam(GradedActivity ga){
		grades[3] = ga;
	}

	/** This method returns a string that shows the grades and scores of each 
	 * element of the GradedActivity array */
	public String toString(){

		String res =
		 "LabActivity => Scores: "+grades[0].getScore()+", Grade: "+ grades[0].getGrade()
	    +"\nPass/fail exam => Scores: "+grades[1].getScore()+", Grade: "+ grades[1].getGrade()
	    +"\nEssay => Scores: "+grades[2].getScore()+", Grade: "+ grades[2].getGrade()
	    +"\nFinal Exam => Scores: "+grades[3].getScore()+", Grade: "+ grades[3].getGrade();

	    return res;
	}

	/** Overriden method of interface Analyzable for getting the average scores */
	@Override
	public double getAverage(){

		double total = 0; 
	// Sum up the score of each element 
		for(int i = 0; i<4; i++)
			total += grades[i].getScore();
	// find out the average 
		double avg = (double) total / grades.length; 
	// return the average 
		return avg;

	}

	/** Overriden method of interface Analyzable for getting the reference of highest score 
	 * element */

	@Override 
	public GradedActivity getHighest(){

		GradedActivity high = grades[0]; 

		for(int i = 1; i<4; i++){

			if(high.getScore() < grades[i].getScore())
				high = grades[i];
		}

		return high;

	}

	/** Overriden method of interface Analyzable for getting the reference of lowest score 
	 * element */

	@Override 
	public GradedActivity getLowest(){

		GradedActivity low = grades[0]; 

		for(int i = 1; i<4; i++){

			if(low.getScore() > grades[i].getScore())
				low = grades[i];
		}

		return low;

	}

	/** main driver method to simulate the whole program */

	public static void main(String[] args) {

		/* create an instance of CourseGrades */
		CourseGrades cg = new CourseGrades();

		/** Pass an LabActivity object type that holds the score 
		 * as parameter to the setLab method */
		cg.setLab(new LabActivity(80));

		/** Pass an PassFailExam object type that holds the score 
		 * as parameter to the setPassFailExam method */
		cg.setPassFailExam(new PassFailExam(75));

		/** Pass an Essay object type that holds the score in each field 
		 * as parameters to the setEssay method */
		cg.setEssay(new Essay(20, 17, 10, 7));

		/** Pass an FinalExam object type that holds the score 
		 * as parameter to the setFinalExam method */
		cg.setFinalExam(new FinalExam(80));

		/** Call the toString method to print the results */
		System.out.println(cg.toString());

		System.out.println("\nAverage Marks: "+cg.getAverage());
		System.out.println("Highest Marks: "+cg.getHighest().getScore());
		System.out.println("Lowest Marks: "+cg.getLowest().getScore());
	}
}