// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.
import java.util.*;

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

class SearchTreeIterator<E extends Comparable<E>> {

    Deque<SearchTreeNode<E>> st = new LinkedList<>();

    boolean hasNextCalled = false; 
    E currentData;
    SearchTreeNode<E> treeRoot;
    SearchTree<E> tree;

    public SearchTreeIterator(SearchTreeNode<E> root, SearchTree<E> tree) {
        treeRoot = root;
        this.tree = tree;
        pushNodes(root); 
    }
    
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

    public boolean hasNext() {
        return !st.isEmpty();
    }

    public void remove(){
              
        if(!hasNextCalled){
            throw new IllegalStateException();
        } 

        tree.remove(currentData);
        hasNextCalled = false;
    }

    void pushNodes(SearchTreeNode<E> node) {

        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }
    
}


public class SearchTree<E extends Comparable<E>> {

    private SearchTreeNode<E> overallRoot; // root of overall tree

    // post: constructs an empty search tree
    public SearchTree() {
        overallRoot = null;
    }

    // post: value added to tree so as to preserve binary search tree
    public void add(E value) {
        overallRoot = add(overallRoot, value);
    }

    // post: value added to tree so as to preserve binary search tree
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

    // post: returns true if tree contains value, returns false otherwise
    public boolean contains(E value) {
        
    }   

    // post: returns true if given tree contains value, returns false otherwise
    private boolean contains(SearchTreeNode<E> root, E value) {
        // 
    }

    // post: prints the data of the tree, one per line
    public void print() {
        System.out.print("[");
        printInorder(overallRoot);
        System.out.println("]");
    }

    // post: prints the data of the tree using an inorder traversal
    private void printInorder(SearchTreeNode<E> root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(" " + root.data);
            printInorder(root.right);
        }
    }

    public void addAll(SearchTree<E> tree){

        Queue<SearchTreeNode<E>> nodes = new LinkedList<SearchTreeNode<E>>();

        nodes.add(tree.overallRoot);

        while(!nodes.isEmpty()){

            SearchTreeNode<E> front = nodes.remove();        
            add(front.data);

            if(front.left != null){
                nodes.add(front.left);
            }

            if(front.right != null){
                nodes.add(front.right);
            }
        }        
    }

    /** helper method for the clear() method */
    private void clear(SearchTreeNode<E> current){
        // Setting all the values in left subtree as null
        if(current.left != null){
            clear(current.left);
            current.left = null;
        }

        // Setting all the values in right subtree as null
        if(current.right != null){
            clear(current.right);
            current.right = null;
        }

        // Now since the left and right are set as null, setting this node as null
        current = null;
    }

    public void clear(){
        if(!isEmpty()){   
            // Clear the references, so that gc can free up the spaces
            clear(overallRoot); 
            // Set the root as null
            overallRoot = null;
        }
    }

    public boolean containsAll(SearchTree<E> tree){

        Queue<SearchTreeNode<E>> nodes = new LinkedList<>();

        nodes.add(tree.overallRoot);
        add(tree.overallRoot.data);

        boolean found = true;

        while(!nodes.isEmpty()){

            SearchTreeNode<E> front = nodes.remove();

            if(!contains(front.data))
                found = false;

            if(front.left != null){
                nodes.add(front.left);
            }

            if(front.right != null){
                nodes.add(front.right);
            }
        
        }

        return found;
    }

     /** helper method for the clear() method */
    private boolean equals(SearchTreeNode current, SearchTreeNode<E> root){
        // Setting all the values in left subtree as null       
        
        if(current == null || root == null)
            return false;

        if(current.left != null && root.left != null){
            return equals(current.left, root.left);
        }
        // Setting all the values in right subtree as null
        else if(current.right != null && root.right != null){
            return equals(current.right, root.right);
        }

        else
            return (current.data == root.data);

        //return false;
    }

    public SearchTreeNode<E> getRoot(){
        return overallRoot;
    }

    @Override
    public boolean equals(Object o){

        if(o instanceof SearchTree){
            SearchTreeNode root = ((SearchTree)o).getRoot();
            return equals(root, overallRoot);
        }
        else
            return false;
    }

    public boolean isEmpty(){
        return overallRoot == null;
    }

    // Helper function to find minimum value node in the subtree rooted at `curr`
    public  SearchTreeNode<E> getMinimumKey(SearchTreeNode<E> curr)
    {
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
   
    // Function to delete a node from a BST
    public boolean remove(E key){
    
        // start with the root node
        SearchTreeNode<E> curr = overallRoot;
        
        // search key in the BST and set its parent pointer
        while (curr != null && curr.data != key)
        {
            // if the given key is less than the current node, go to the left subtree;
            // otherwise, go to the right subtree
            if (key.compareTo(curr.data) < 0) {
                curr = curr.left;
            }
            else {
                curr = curr.right;
            }
        }
 
        // return if the key is not found in the tree
        if (curr == null) {
            return false;
        }
 
        // Case 1: node to be deleted has no children, i.e., it is a leaf node
        if (curr.left == null && curr.right == null)
        {
            // if the node to be deleted is not a root node, then set its
            // parent left/right child to null
            if (curr != overallRoot)
            {
                if (curr.parent.left == curr) {
                    curr.parent.left = null;
                }
                else {
                    curr.parent.right = null;
                }
            }
            // if the tree has only a root node, set it to null
            else {
                overallRoot = null;
            }
        }
 
        // Case 2: node to be deleted has two children
        else if (curr.left != null && curr.right != null)
        {
            // find its inorder successor node
            SearchTreeNode<E> successor = getMinimumKey(curr.right);
 
            // store successor value
            E val = successor.data;
 
            // recursively delete the successor. Note that the successor
            // will have at most one child (right child)
            remove(successor.data);
 
            // copy value of the successor to the current node
            curr.data = val;
        }
 
        // Case 3: node to be deleted has only one child
        else {
            // choose a child node
            SearchTreeNode<E> child = (curr.left != null)? curr.left: curr.right;
 
            // if the node to be deleted is not a root node, set its parent
            // to its child
            if (curr != overallRoot)
            {
                if (curr == curr.parent.left) {
                    curr.parent.left = child;
                }
                else {
                    curr.parent.right = child;
                }
            }
 
            // if the node to be deleted is a root node, then set the root to the child
            else {
                overallRoot = child;
            }
        }

        return true;
    }

    public SearchTreeIterator<E> iterator(){

        return new SearchTreeIterator<E>(overallRoot, this);

    }

}
