/** refer the import packages from the chapter **/
import java.util.Arrays;
import java.util.NoSuchElementException;

public class ThreeHeapIntPriorityQueue {

    private int[] elementData;
    private int size;
    // Constructs an empty queue.
    public ThreeHeapIntPriorityQueue() {
        elementData = new int[10];
        size = 0;
    }

     public static long totaltime = 0;
    // Adds the given element to this queue.
    public void add(int value) {       

        // resize if necessary
        if (size + 1 >= elementData.length) {
            elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        
        // insert as new rightmost leaf
        elementData[size + 1] = value;
        
        // "bubble up" toward root as necessary to fix ordering
        int index = size + 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasParent(index)) {

            int parent = parent(index);
           
            if (elementData[index] < elementData[parent]) {

                swap(elementData, index, parent(index));
                index = parent(index);

            } 
            else {
                found = true;  // found proper location; stop the loop
            }

        }
        
        size++;
    }
    
    // Returns true if there are no elements in this queue.
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Returns the minimum value in the queue without modifying the queue.
    // If the queue is empty, throws a NoSuchElementException.
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return elementData[1];
    }
   
   /** the modified method to remove the root from 3-ary heap **/
    public int remove() {

        // get the first element of the heAP array 
        int result = peek();

        elementData[1] = elementData[size];
        size--;
        
        int index = 1;
        boolean found = false;   // have we found the proper place yet?
        while (!found && hasLeftChild(index)) {

            int left = leftChild(index); // get the left element index 
            int middle = middleChild(index); // get the middle element index 
            int right = rightChild(index); // get the right element index 

            int child = left;

            /* check if middle child is the minimum one */
            if(hasMiddleChild(index) && isMin(elementData[middle], 
                elementData[left], elementData[right])){
                /** if so, make this middle as the new child **/
                child = middle;
            }

            /** check if the right child is the minimum one **/
            if (hasRightChild(index) && isMin(elementData[right],
             elementData[left], elementData[middle])) {
                child = right;
            }

            /* compare child with current index element **/
            if (elementData[index] > elementData[child]) {
                swap(elementData, index, child);
                index = child;
            } else {
                found = true;  // found proper location; stop the loop
            }
        }
        
        return result;
    }

/* additional helper method that returns true
 if the first parameter is less than
second and third one **/
    public boolean isMin(int first, int second, int third){

        if(first <= second && first <= third){
            return true;
        }

        return false;
    }
    
    public int size() {
        /** no modifications are required for this method **/
        return 0;
    }
    
    public String toString() {
        /** no modifications are required for this method **/
        return "";
    }
    
    /** modified parent method **/
    private int parent(int index) {
        return (int)Math.round((double)index / 3);
    }
    
   /** modified leftChild method **/
    private int leftChild(int index) {
        return index * 3 - 1;
    }

    /** additional helper method **/
    private int middleChild(int index){
        return index * 3;
    }
    
    /* modified rightChild method **/
    private int rightChild(int index) {
        return index * 3 + 1;
    }

   // returns true if the node at the given index has a parent (is not the root)
    private boolean hasParent(int index) {
        return index > 1;
    }
    
    // returns true if the node at the given index has a non-empty left child
    private boolean hasLeftChild(int index) {
        return leftChild(index) <= size;
    }

/** additional helper method **/
    private boolean hasMiddleChild(int index) {
        return middleChild(index) <= size;
    }
   
    private boolean hasRightChild(int index) {
        return rightChild(index) <= size;
    }
 
    private void swap(int[] a, int index1, int index2) {
        /** no modifications **/
         int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

}
