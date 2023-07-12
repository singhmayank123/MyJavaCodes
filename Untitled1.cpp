// C++ program to find length
// of the shortest chain
// transformation from source
// to target
#include <bits/stdc++.h>
using namespace std;

// Returns length of shortest chain
// to reach 'target' from 'start'
// using minimum number of adjacent
// moves. D is dictionary
int shortestChainLen(
string start, string target,
set<string>& D)
{

	if(start == target)
	return 0;

	// If the target string is not
	// present in the dictionary
	if (D.find(target) == D.end())
		return 0;

	// To store the current chain length
	// and the length of the words
	int level = 0, wordlength = start.size();

	// Push the starting word into the queue
	queue<string> Q;
	Q.push(start);

	// While the queue is non-empty
	while (!Q.empty()) {

		// Increment the chain length
		++level;

		// Current size of the queue
		int sizeofQ = Q.size();

		// Since the queue is being updated while
		// it is being traversed so only the
		// elements which were already present
		// in the queue before the start of this
		// loop will be traversed for now
		for (int i = 0; i < sizeofQ; ++i) {

			// Remove the first word from the queue
			string word = Q.front();
			Q.pop();

			// For every character of the word
			for (int pos = 0; pos < wordlength; ++pos) {

				// Retain the original character
				// at the current position
				char orig_char = word[pos];

				// Replace the current character with
				// every possible lowercase alphabet
				for (char c = 'a'; c <= 'z'; ++c) {
					word[pos] = c;

					// If the new word is equal
					// to the target word
					if (word == target)
						return level + 1;

					// Remove the word from the set
					// if it is found in it
					if (D.find(word) == D.end())
						continue;
					D.erase(word);

					// And push the newly generated word
					// which will be a part of the chain
					Q.push(word);
				}

				// Restore the original character
				// at the current position
				word[pos] = orig_char;
			}
		}
	}

	return 0;
}

// Driver program
int main()
{
	// make dictionary
	set<string> D;
	D.insert("dog");
	D.insert("hog");
	D.insert("dot");
	D.insert("cog");
	D.insert("cag");
	D.insert("cot");
	D.insert("cat");
	
//	D.insert("plea");
	string start = "cat";
	string target = "dog";
	cout << "Length of shortest chain is: "
		<< shortestChainLen(start, target, D);
	return 0;
}

