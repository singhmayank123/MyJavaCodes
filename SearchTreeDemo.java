import java.util.*;

// updated SearchTreeNode that also links each node to its parent 
class SearchTreeNode<E> {
    
    public E data;                   // data stored in this node
    public SearchTreeNode<E> left;   // left subtree
    public SearchTreeNode<E> right;  //  right subtree
    public SearchTreeNode<E> parent;

    // post: constructs a leaf node with given data
    public SearchTreeNode(E data) {
        this(data, null, null, null);
    }
    
    // post: constructs a node with the given data and links
    public SearchTreeNode(E data, SearchTreeNode<E> left,
                          SearchTreeNode<E> right, SearchTreeNode<E>  parent ) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}

// Iterator class to iterate the tree elements 
class SearchTreeIterator<E extends Comparable<E>> {

// use Deque to store the tree nodes 
    Deque<SearchTreeNode<E>> st = new LinkedList<>();
// to indicate whether the next is called before calling the remove
    boolean hasNextCalled = false; 
    E currentData; // currentData returns by next() method 
    SearchTreeNode<E> treeRoot; // root tree 
    SearchTree<E> tree; // for storing tree object 

// COnstructor 
    public SearchTreeIterator(SearchTreeNode<E> root, SearchTree<E> tree) {
        treeRoot = root;
        this.tree = tree;
        pushNodes(root); 
    }
  
/** method that returns the next iterating element data */  
    public E next() {

        hasNextCalled = true;

        if(!hasNext()){
            throw new NoSuchElementException("No nodes left to visit.");
        }

        SearchTreeNode<E> node = st.pop();
        pushNodes(node.right);
        currentData = node.data;
        return node.data;
    }

/** method that checks whether there are any elements for iterating or not */
    public boolean hasNext() {
        return !st.isEmpty();
    }

/** method that removes the element returns next() from the tree */
    public void remove(){
              
        if(!hasNextCalled){
            throw new IllegalStateException();
        } 

        tree.remove(currentData);
        hasNextCalled = false;
    }

// method for pushing the nodes into the deque */
    private void pushNodes(SearchTreeNode<E> node) {

        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }
    
}


public class SearchTree<E extends Comparable<E>> {

    private SearchTreeNode<E> overallRoot;

    public SearchTree() {
        // refer it from boook
    }

    public void add(E value) {
       // refer it from book
    }

// update add method that links each node the parent node 
    private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
        if (root == null) {
            root = new SearchTreeNode<E>(value);
        } else if (root.data.compareTo(value) >= 0) {
            SearchTreeNode<E> lChild = add(root.left, value);
            root.left = lChild;
            lChild.parent = root;

        } else {
            SearchTreeNode<E> rChild = add(root.right, value);
            root.right = rChild;
            rChild.parent = root;
        }

        return root;
    }

    public boolean contains(E value) {
        // refer it from the book
    }   

    private boolean contains(SearchTreeNode<E> root, E value) {
        // refer it from the book
    }

    public void print() {
      // refer it from question 4 for this chapter 
    }

    private void printInorder(SearchTreeNode<E> root) {
       // refer it from the book 
    }

    public void addAll(SearchTree<E> tree){
        // refer it from question 4 for this chapter 
    }

    /** helper method for the clear() method */
    private void clear(SearchTreeNode<E> current){
      // refer it from question 4 for this chapter 
    }

    public void clear(){
   // refer it from question 4 for this chapter 
    }

    public boolean containsAll(SearchTree<E> tree){
    // refer it from question 4 for this chapter 
    }

     /** helper method for the clear() method */
    private boolean equals(SearchTreeNode current, SearchTreeNode<E> root){
        // refer it from question 4 for this chapter    
    }

    @Override
    public boolean equals(Object o){
        // refer it from question 4 for this chapter 
    }

    public boolean isEmpty(){
        // refer it from question 4 for this chapter 
    }

    // Helper function to find minimum value node in the subtree rooted at `curr`
    public  SearchTreeNode<E> getMinimumKey(SearchTreeNode<E> curr)
    {
        // refer it from question 4 for this chapter 
    }
   
    // Function to delete a node from a BST
    public boolean remove(E key){
    
       // refer it from question 4 for this chapter 
    }

/** iterator method that return an object of SearchTreeIterator class **/
    public SearchTreeIterator<E> iterator(){

        return new SearchTreeIterator<E>(overallRoot, this);

    }

}
