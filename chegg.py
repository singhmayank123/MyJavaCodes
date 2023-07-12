# First creating a file object to read the file 'pbnumbers.txt'
pbnumbers = open('pbnumbers.txt', 'r')
# checking if our file is opened in read mode if not then we stop our program execution
if pbnumbers.mode != 'r':
    print('Error : File not in read mode. Exiting')
    pbnumbers.close()
    exit(0)

# if everything is okay then we read all the lines in the file and store all the lines as a list
lines = pbnumbers.readlines()
# closing the file object
pbnumbers.close()

# creating a dictionary to store the frequencies of the numbers
frequency_of_powerball_numbers = {}
frequency_of_normal_numbers = {}
common_numbers = {}
# creating a list to store the order in which numbers are drawn
# for every new number drawn we first check if it's present in the list
# if it's present then we first remove the number from the list and add the number to the end of list
# thus the list is in order of most overdue to least overdue from front to end
overdue_numbers = []

for each_line in lines:
    # first converting the string list to an integer list
    line = [int(number) for number in each_line.split(' ')]

    # for each line we then loop through all numbers
    for i in range(0, 6):
        # for every new number drawn we first check if it's present in the list
        # if it's present then we first remove the number from the list and add the number to the end of list
        # thus the list is in order of most overdue to least overdue from front to end
        if line[i] in overdue_numbers:
            overdue_numbers.remove(line[i])
        overdue_numbers.append(line[i])

        # updating the frequency of each number in dictionary
        if line[i] in common_numbers:
            common_numbers[line[i]] += 1
        else:
            common_numbers[line[i]] = 1

        # updating the frequency of normal numbers & powerball numbers
        if (i < 5) and (line[i] in frequency_of_normal_numbers):
            frequency_of_normal_numbers[line[i]] += 1
        elif (i < 5) and (line[i] not in frequency_of_normal_numbers):
            frequency_of_normal_numbers[line[i]] = 1
        elif (i == 5) and (line[i] in frequency_of_powerball_numbers):
            frequency_of_powerball_numbers[line[i]] += 1
        else:
            frequency_of_powerball_numbers[line[i]] = 1

# first converting the dictionary to list so that it can be sorted
common_numbers_as_list = [(k, v) for k, v in common_numbers.items()]
# then sorting the list with respect to the values
sorted_common_numbers = sorted(common_numbers_as_list, reverse=True, key=lambda x: x[1])

# printing the 10 most common numbers
print('The 10 most common numbers are: ', end='')
for i in sorted_common_numbers[:10]:
    print(i[0], end=' ')
print()

sorted_common_numbers = sorted(common_numbers_as_list, key=lambda x: x[1])
# printing the 10 least common numbers
print('The 10 least common numbers are: ', end='')
for i in sorted_common_numbers[:10]:
    print(i[0], end=' ')
print()

# printing the 10 most overdue numbers
print('The 10 most overdue numbers are: ', end='')
for i in overdue_numbers[:10]:
    print(i, end=' ')
print()

# displaying the frequency of each number 1-69, and the frequency of each Powerball number 1-26
print('Frequency of each number 1-69: ')
for i in range(1, 70):
    if i in frequency_of_normal_numbers:
        print(i, '-', frequency_of_normal_numbers[i])
    else:
        print(i, '-', 0)

print('Frequency of each Powerball number 1-26: ')
for i in range(1, 27):
    if i in frequency_of_powerball_numbers:
        print(i, '-', frequency_of_powerball_numbers[i])
    else:
        print(i, '-', 0)