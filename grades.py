#list for storing the grades of 5 subjects
grades = [45, 60, 70, 80, 55]

# for storing average grades or final grades
avg = 0

# function for displaying the menu 

def menu():

	print("------------- Menu ------------")
	print("Change grades ------------ press 1")
	print("Display grades ----------- press 2")
	print("Calculate final grades --- press 3")
	print("Exit---------------------- press 4")

	userIn = int(input("Press a key: "))

	return userIn

# function to drop the lowest grade in a list
def dropLowestGrade():

	# find the minium grade 
	mini = min(grades)
	# remove the minimum grade from the list
	grades.remove(mini)

# method to display the grades 
def displayGrades():


	print("Grades are: ")
	for i in grades:
		print(i, end =" ")

	print()

# method to return the grade letter 
def getLetterGrade():
# change the grades and ranges as per your own convenience
	if avg >= 90:
		return "A"
	elif avg >= 80:
		return "B"
	elif avg >= 70:
		return "C"
	elif avg >= 60:
		return "D"
	elif avg < 60:
		return "F"

# function for calculating the grades 
def calcGrades():


	# drop the lowest grade before calculating the final grade
	dropLowestGrade()

	sum = 0 

	# sum up all the grades
	for i in grades:
		sum += i

	# calculate the average 
	avg = sum / len(grades)

	print("Final grades are: ", avg)

	print("Grade letter is : ", getLetterGrade())


def main():

	while True:

		userIn = menu()
# add here your own code for option 1 
		if userIn == 1:
			pass
		elif userIn == 2:
			displayGrades()
		elif userIn == 3:
			calcGrades()
		elif userIn == 4:
			break
		else:
			print("Invalid choice!!")


# call the main function to execute the program 
main()