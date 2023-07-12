

class Student:

	def __init__(self):
		self.name = ""
		self.marks = []
		self.avg = 0.0

	def calcAvg(self):

		sum = 0
			# sum up all the grades
		for i in self.marks:
			sum += i

		# calculate the average 
		self.avg = sum / len(self.marks)

		return self.avg

	# method to return the grade letter 
	def getGrade(self):
		self.calcAvg()
	# change the grades and ranges as per your own convenience
		if self.avg >= 90:
			return "A"
		elif self.avg >= 80:
			return "B"
		elif self.avg >= 70:
			return "C"
		elif self.avg >= 60:
			return "D"
		elif self.avg < 60:
			return "F"

	def readMarksAndName(self):
		self.name = input("\nEnter student name: ")
		for i in range(5):
			while True:
				mark = float(input("Enter ex {ind} marks ".format(ind = (i + 1))))
				if(mark > 0 and mark < 110):
					self.marks.append(mark)
					break
				else:
					print("Invalid marks!!")


	def sortAsc(self):
		marks.sort()

marks = []
students = []

def display():

	print("\nName \t Marks\t\t\t\tAverage\t\tGrade")
	print("\n**********************************************")
	for stud in students:	
		print(stud.name,"\t", stud.marks, "\t", stud.calcAvg(), "\t\t",stud.getGrade())

def main():
	
	numStudent = int(input("Enter number of students: "))

	# list for storing student names 

	for i in range(numStudent):
		std = None
		std = Student()
		std.readMarksAndName()
		students.append(std)

	display()

main()


