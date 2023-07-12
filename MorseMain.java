import java.io.*;
import java.util.*;
interface MorseCodeInterface {


void inOrderPrint();


String decode(String str);


String encode(String str);
}
  

class MorseNode
{

/** a letter of the alphabet */
private char letter;
/** reference to the left child */
private MorseNode left;
/** reference to the right child */
private MorseNode right;
/** value of letter if empty (not set) */
public static final char EMPTY = ' ';

/**
* Default constructor, actual values are set in the MorseCode constructor
*/
public MorseNode() {
letter = EMPTY;
left = null;
right = null;
}

/**
* Gets letter contained in node
* @return String - letter value
*/
public char getLetter() {
return letter;
}

/**
* Sets letter in node
* @param String - letter to set
*/
public void setLetter(char letter) {
this.letter = letter;
}

/**
* Gets the node refrenced by left
* @return MorseNode - left
*/
public MorseNode getLeft() {
return left;
}

/**
* Sets left refrence
* @param left - refrence to the node to set
*/
public void setLeft(MorseNode left) {
this.left = left;
}

/**
* Gets the node refrenced by right
* @return MorseNode - right
*/
public MorseNode getRight() {
return right;
}

/**
* Sets right refrence
* @param right - refrence to the node to set
*/
public void setRight(MorseNode right) {
this.right = right;
}

/** your docs */

}

class MorseCoder implements MorseCodeInterface {

public MorseNode root;

/**
* constructor to build the tree
*/
public MorseCoder() {
root = new MorseNode();
readTreeInfo();
}

/**
* reads in the tree info from the text file (helper method)
*/
private void readTreeInfo() {
Scanner input = null;
try {
input = new Scanner(new File("encodings.txt"));
} catch (FileNotFoundException exception) {
System.out.println("File not found!");
}

while (input.hasNextLine()) {
String data = input.nextLine().trim();
if (data.length() > 0) {
add(data.substring(1).trim(), data.charAt(0));
}
}
input.close();
}

/**
* adds the letter to the tree based on the mcode string (helper method)
* @param mcode the string being fed in
* @param ltr the letter being added at the node
*/
private void add(String mcode, char ltr) {
MorseNode current = root;
String signal = " ";

for (int i = 0; i < mcode.length(); i++) {
signal = mcode.substring(i, i + 1);
if (signal.equals(".")) {
if (current.getLeft() != null) {
current = current.getLeft();
} else {
current.setLeft(new MorseNode());
current = current.getLeft();
}
} else {
if (current.getRight() != null) {
current = current.getRight();
} else {
current.setRight(new MorseNode());
current = current.getRight();
}
}
}
current.setLetter(ltr);

}

/**
* prints out inorder tree contents
*/
public void inOrderPrint() {
MorseNode current = root;
printInorder(current);
}

/**
* called by inOrderPrint to print tree contents (helper method)
* @param current the node to print
*/
private void printInorder(MorseNode current) {
if (current != null) {
printInorder(current.getLeft());
System.out.print(current.getLetter());
printInorder(current.getRight());
}
}

/**
* decodes a String of morse code to English
* @param str String of morse code
* @return result String of English
*/
public String decode(String str) {
String signal = "";
StringBuffer result = new StringBuffer("");
MorseNode current = root;

for (int i = 0; i < str.length(); i++) {
signal = str.substring(i, i + 1);
if (signal.equals(".")) {
if (current.getLeft() != null) {
current = current.getLeft();
} else {
current.setLeft(new MorseNode());
current = current.getLeft();
}
} else if (signal.equals("-")) {
if (current.getRight() != null) {
current = current.getRight();
} else {
current.setRight(new MorseNode());
current = current.getRight();
}
} else {
result = result.append(current.getLetter());
current = root;
}
}
result = result.append(current.getLetter());

return result.toString();
}

/**
* decodes a String of English to morse code
* @param str String of English
* @return result String of morse code
*/
public String encode(String str) {
MorseNode current = root;
String result = "";
String s = "";
char ltr;

for (int i = 0; i < str.length(); i++) {
ltr = str.charAt(i);
result = searchTree(current, ltr, s);
}
return result;
}   

/**
* searches the tree for the letter(s) being inputed and outputs a string of morse (helper method)
* @param current the node of the tree
* @param ltr the letter being searched for in the tree
* @param s the String being used to build the morse code
* @return the morse code corresponding to the item being checked
*/
public String searchTree(MorseNode current, char ltr, String s) {
char temp = current.getLetter(); //for debugging purposes

if (current.getLetter() == ltr) {
return s;
} else {
if (current.getLeft() != null) {
return searchTree(current.getLeft(), ltr, s + ".");
}
if (current.getRight() != null) {
return searchTree(current.getRight(), ltr, s + "-");
}   
return s;
}
}
}
public class MorseMain {

public static void main(String[] args) {
//Do not. modify this file.
MorseCoder mc = new MorseCoder();


System.out.println(mc.root.getLeft().getLeft().getLetter());

// // abcdef...xyz decode
// System.out.println("Decode Test 2");
// str = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -."
// + " --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..";
// System.out.println("str = " + str);
// System.out.println("str should decode to: abcdefghijklmnopqrstuvwxyz");
// System.out.println("decode(str) = " + mc.decode(str));
// testResults("abcdefghijklmnopqrstuvwxyz", mc.decode(str));
  
// // helpmeobiwanyouremyonlyhope decode
// System.out.println("Decode Test 3");
// str = ".... . .-.. .--. -- . --- -... .. .-- .- -. -.-- --- ..-"
// + " .-. . -- -.-- --- -. .-.. -.-- .... --- .--. .";
// System.out.println("str = " + str);
// System.out.println("str should decode to: helpmeobiwanyouremyonlyhope");
// System.out.println("decode(str) = " + mc.decode(str));
// testResults("helpmeobiwanyouremyonlyhope", mc.decode(str));

// // --.. encode
// System.out.println("Encode Test 1");
// str = "z";
// System.out.println("str = " + str);
// System.out.println("str should encode to: --..");
// System.out.println("encode(str) = " + mc.encode(str));
// testResults("--..", mc.encode(str));

// // ... --- ... encode
// System.out.println("Encode Test 2");
// str = "sos";
// System.out.println("str = " + str);
// System.out.println("str should encode to: ... --- ...");
// System.out.println("encode(str) = " + mc.encode(str));
// testResults("... --- ...", mc.encode(str));

// // .-. ..- -. ..-. --- .-. .-. . ... - .-. ..- -. encode
// System.out.println("Encode Test 3");
// str = "runforrestrun";
// System.out.println("str = " + str);
// System.out.println("str should encode to: .-. ..- -. ..-. --- .-. .-. . ... - .-. ..- -.");
// System.out.println("encode(str) = " + mc.encode(str));
// testResults(".-. ..- -. ..-. --- .-. .-. . ... - .-. ..- -.", mc.encode(str));

// }

// /**
// * Tests if the output string matches the expected.
// * Prints "Test: Passed" if they match, otherwise prints "Test: Failed"
// * @param one String - Expected output
// * @param two String - Encoded/Decoded call

}

public static void testResults(String one, String two) {
if(one.trim().equals(two.trim()))
System.out.println("Test: Passed");
else
System.out.println("Test: Failed");
System.out.println();


}

}