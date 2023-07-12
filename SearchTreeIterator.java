import java.util.*;

public class SearchTreeIterator {

    Deque<SearchTreeNode<E>> st = new LinkedList<>();

    public SearchTreeIterator(SearchTreeNode<E> root) {
        pushNodes(root);   
    }
    
    public int next() {

        SearchTreeNode<E> node = st.pop();
        pushNodes(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    void pushNodes(SearchTreeNode<E> node) {
        while(node != null) {

            st.push(node);
            node = node.left;
        }
    }
    
}