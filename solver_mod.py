import random # for random generation

def make_state(num_frogs, num_toads):

    # define an empty list
    lst = []
    # loop to add num of frogs
    for i in range(num_frogs):
        lst.append("Frog")
    # append empty string after adding frogs
    lst.append("")
    #append the number of toads 
    for i in range(num_toads):
        lst.append("Toad")

    # return the list to the caller 
    return lst

def find_space(state):

# iterate over each element of the state 
    for i in range(len(state)):
        # if empty string finds then return the index 
        if state[i] == "":
            return i
    # if empty string is not in the state 
    return -1

def is_frog(state, index):
    # validate the value present at index
    if state[index] == "Frog":
        # if Frog is at index, return true
        return True 
    # Otherwise, return false
    return False

def is_toad(state, index):
    # validate the value present at index
    if state[index] == "Toad":
        # if Toad is at index, return true
        return True 
    # Otherwise, return false
    return False

def move(state, index):
    def list(state):
        #define a new list 
        newList = []
        # copy contents of state list to newList
        for i in range(len(state)):
            newList.append(state[i])
        return newList

    # create a new state    
    newState = list(state) 
    # move frog at index 1
    # radomly moving the frog at other index 
    randInd = random.randrange(0, (len(newState)))
    # swap the frog at index 1 to index valu randInd
    temp = newState[index]
    newState[index] = newState[randInd]
    newState[randInd] = temp
    #return the new state
    return newState

def print_state(state):

    for i in range(len(state)):
        print("|", state[i], end = "")
    print("|")

def is_win(state):

    series_of_toads = False
    anEmptySpace = False
    series_of_frogs = False
    # for starting index 
    stop = 0

    # iterate over each element of the state 
    while stop < len(state):
        # Initialize True to series_of_toads if condition satisfies 
        if state[stop] == "Toad":
            series_of_toads = True
        else:
            #Otherwise break the loop if current value is not toad 
            break
        stop = stop + 1

    while stop < stop + 1:
        # check if value at stop if empty string 
        if state[stop] == "":
            anEmptySpace = True # set true, if condition satisfies 
        # Otherwise, check if the current value is Toad
        elif state[stop] == "Toad":
            # if so, then set False because series if not maintained
            series_of_toads = False
        else:
            # otherwise break the loop to check next series 
            break
        # incrment the index 
        stop = stop + 1

    # for third series 
    while stop < len(state):
        # if Frog then set True
        if state[stop] == "Frog":
            series_of_frogs = True
        # otherwise, set False and break the loop as series is not maintained
        else:
            series_of_frogs = False
            break
        # increment the index 
        stop = stop + 1

    # if all three are true then return True 
    if series_of_frogs and series_of_toads and anEmptySpace:
        return True
    # otherwise, return false 
    return False


# main method that simulates the entire puzzle 
def main():
    # store the return value in state 
    state = make_state(3, 2)
    print_state(state)
    print(find_space(state))
    print(is_frog(state, 4))
    print(is_toad(state, 1))
    state = ["Toad", "Toad","", "Frog", "Frog", "Frog"]
    print(is_win(state))
    print(move(state, 1))

# call the main method to run the program
main()
