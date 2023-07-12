/** we have considered ideal days in months and years 
 * for this example, that is, 1 year = 365 days and 1 
 * month = 30 days **/

import java.util.ArrayList; // for ArrayList class 
import java.util.Arrays;
public class Athelete{
// stores the list of events participated by Athelete 	
	private ArrayList<String> events = new ArrayList<>();
	private String fname; // first name
	private String lname; // last name 
	private int birthYear; // for birth year 
	private int birthMonth;
	private int birthDay; 

	
	int day; // for storing number of days since birth day
	int month; // stores months since birth
	int year; // stores years since birth


	/** constructor for initialization **/

	public Athelete(String fname, String lname, 
		int birthYear, int birthMonth, int birthDay){

		this.fname = fname;
		this.lname = lname;
		this.birthYear = birthYear;
		this.birthMonth = birthMonth;
		this.birthDay = birthDay;

	}

	/** Method to compute the age **/

	public String computeAge(){
		/** there is nowhere mentioned to use the 
		 * time methods for getting the current month, day, 
		 * and year. So, I am using the user-defined values 
		 * for this program. **/

		int currentYear = 2021;
		int currentMonth = 9;
		int currentDay = 16;
		int diffDays = 0;
		int diffYear = 0;
		int diffMonths = 0;

		diffYear = currentYear - birthYear;

		if(currentMonth > birthMonth)
			diffMonths = Math.abs(currentMonth - birthMonth);
		else{

			diffMonths = Math.abs(currentMonth - birthMonth);
			int totalMonths = (diffMonths * 12) - diffMonths;
			diffYear = totalMonths / 12;
			diffMonths = totalMonths % 12;
		}

		if(currentDay > birthDay) 
			diffDays = currentDay - birthDay;

		else{

			diffDays = Math.abs(currentDay - birthDay);
			int totalDays = (diffMonths * 30) - diffDays; 

			diffMonths = totalDays / 30;
			diffDays = totalDays % 30;
		}

		year = diffYear;
		month = diffMonths;
		day = diffDays;
		

		StringBuilder age = new StringBuilder();

		boolean term1 = false, term2 = false, term3 = false;
		boolean pluralYear = false, pluralMonth = false, pluralDay = false;

		if(diffYear > 0){
			term1 = true;

			if(diffYear > 1)
				pluralYear = true;
		}
		if(diffMonths > 0){
			term2 = true;

			if(diffMonths > 1)
				pluralMonth = true;
		}

		if(diffDays > 0){
			term3 = true;

			if(diffDays > 1)
				pluralDay = true;
		}

		if(term1){

			if(term2 && term3){

				if(pluralYear)
					age.append(diffYear+" years, ");
				else
					age.append(diffYear+ " year, ");
			}

			else if(term2 && !term3){

				if(pluralYear)
					age.append(diffYear+" years and ");
				else
					age.append(diffYear+ " year and ");
			}

			else if(!term2 && !term3){

				if(pluralYear)
					age.append(diffYear+" years");
				else
					age.append(diffYear+ " year");
			}
		}

		if(term2){

			if(term1 && term3){

				if(pluralMonth)
					age.append(diffMonths+" months, and ");
				else
					age.append(diffMonths+ " month, and ");
			}

			else if(!term1 && term3){

				if(pluralMonth)
					age.append(diffMonths+" months and ");
				else
					age.append(diffMonths+ " month and ");
			}

			else{

				if(pluralMonth)
					age.append(diffMonths+" months ");
				else
					age.append(diffMonths+ " month ");
			}
		}

		if(term3){

			if(term1 && term2){

				if(pluralDay)
					age.append(diffDays+" days old");
				else
					age.append(diffDays+ " day old");
			}

			else{

				if(pluralDay)
					age.append(diffDays+" days old");
				else
					age.append(diffDays+ " day old");
			}
		}

		return age.toString();

	}

	public long daysSinceBirth(){

		int totalDays = year*365 + month*30 + day;
		return totalDays;
	}

	public String getFName(){

		return fname;
	}

	public String getLName(){

		return lname;
	}

	public String toString(){

		 String s = fname + " "+ lname + " " + computeAge();
		 return s;
	}

	public boolean equals(Object o){
// check if the given object is an instance of Athelete 
		if(o instanceof Athelete){
// if so, match each paarameter and return true for success 
			if(((Athelete)o).getFName().equals(fname) && 
				((Athelete)o).getFName().equals(lname) &&
				((Athelete)o).daysSinceBirth() == daysSinceBirth()){

				return true;
			}
		}

		return false;
	}

	public ArrayList<String> getEvents(){
		// return the events array list 
		return events;
	}

	public int addEvents(String event){

	/** if event is null or already exists in the arrayList **/
		if(event == null || events.indexOf(event) != -1)
			return 0;
		/** otherwise, add the event in the events list and return 1 fo
		 * success **/
		events.add(event);
		return 1;
	}
// main driver method to test the class 
	public static void main(String[] args) {
		
		Athelete ath = new Athelete("Mayank", "Singh", 2020, 10, 23);
		System.out.println(ath.computeAge());
		System.out.println(ath.daysSinceBirth() + " days");
		System.out.println(ath.toString());

	}
}