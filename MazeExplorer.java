import java.util.LinkedList; // for creating adjacency list
import java.util.Stack; // for using Stack class 

/** MazeExplorer class that implements the given algorithms
and helps to escape from the maze **/ 
public class MazeExplorer {

/** A private class that represent the each edge of the 
 * maze explorer game */
	private class ExplorableEdge {

	    int targetVertex; // stores the target vertex value 
	    String locValue; // stores the value of the location

	    /** A constructor to initialize the edge */
	    ExplorableEdge(int targetVertex, String locValue) {

	        this.targetVertex = targetVertex;
	        this.locValue = locValue;

	    }

	}

    private int locations; // stores number of explorable locations

    private LinkedList<ExplorableEdge> adj[]; // Stores the list of adjacent edges to each edge 

/** A constructor that initialized the adjacent list */
    public MazeExplorer(int locations) {

        this.locations = locations;

        adj = new LinkedList[locations];

        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<>();

    }

/** Method to create an explorable edge from u to v with the given edge value */
    public void addEdge(int source, int target, String locValue) {
        adj[source].add(new ExplorableEdge(target, locValue)); // Add w to v’s list.
    }

/** method that runs the game algorithm and prints the explored locations */
    public void runExplorer(int initialVertex) {

        // Initially mark all vertices as not visited
        boolean visited[] = new boolean[locations];
        // create an empty stack of edges to explore 
        Stack<ExplorableEdge> stack = new Stack<>(); 
        // push the initial edge to the stack 
        stack.push(adj[initialVertex].get(0)); 

        // while stack is not empty 
        while (!stack.empty()) {

        	// get the top edge from the edge and popped it out 
            ExplorableEdge e = stack.peek(); 
            stack.pop();

            // skip the loop if the popped vertex is already visited 
            if(visited[e.targetVertex])
            	continue;

            // if the vertex is not visited before 
            else {

            	// if the popped vertex is the end location
            	if(e.locValue.equalsIgnoreCase("end")){
            		System.out.print("Reached at "+ e.locValue);
            		break;	
            	}

            	else
                	System.out.println("Go to "+e.locValue);

                // mark visited 
                visited[e.targetVertex] = true;
            }
       		
       		// explore the non-visited vertex 
            for (ExplorableEdge eg: adj[e.targetVertex]) {
            	// add all the adjacent edges to the stack which is not visited before 
            	if(!visited[eg.targetVertex])
                    stack.push(eg);
            }

        }
/** if the stack is empty after coming out the loop, then it means 
 * end is not reachable **/
        if(stack.empty()){
        	System.out.println("End location is unreachable!");
        }
    }

    // main driver method to test the class 
    public static void main(String[] args) {
  	
  	// create an object of MazeExplorer, having 17 explorable locations 
        MazeExplorer g = new MazeExplorer(17);

    // add all the 17 explorable locations 
        g.addEdge(0, 0, "Start position");
        g.addEdge(0, 1, "location 1");
        g.addEdge(0, 2, "location 2");
        g.addEdge(0, 3, "location 3");
        g.addEdge(1, 4, "location 4");
        g.addEdge(4, 8, "location 5");
        g.addEdge(8, 12, "location 6");
        g.addEdge(8, 13, "location 16");
        g.addEdge(2, 5, "location 7");
        g.addEdge(2, 6, "location 8");
        g.addEdge(6, 9, "location 9");
        g.addEdge(3, 7, "location 10");
        g.addEdge(7, 10, "location 11");
        g.addEdge(7, 11, "location 12");
        g.addEdge(10, 14, "location 13");
        g.addEdge(10, 15, "location 14");
        g.addEdge(15, 16, "location 15");
        
        System.out.println("There are total 17 explorable locactions\n");
        System.out.println("Below is the followed path to reach the end: \n");
        // call the method to start the game from start position 
        g.runExplorer(0);
    }
}