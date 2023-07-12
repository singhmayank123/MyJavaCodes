/** This program uses javafx functionality and should be 
 * tested with appropriate javafx plugins and other requirements
 *  */


/** For using the Application class which is the foundation
 * of all JavaFx applications. Every JavaFx application class 
 * must extend this class */
import javafx.application.Application; 
/** for using the Scene class which contains the collection 
 * of GUI objects */
import javafx.scene.Scene; 
/** For using the Stage class which display a Application 
 * window on which the Scene is displayed */
import javafx.stage.Stage;
/* For using Group class which groups the collection of objects */
import javafx.scene.Group;
/* for the Color class for filling colors */
import javafx.scene.paint.Color; 
/* For the Rectangle class to draw rectangular boxes */
import javafx.scene.shape.Rectangle;
/** For using MouseEvent class to handle the event listener 
 * when user clicks on the rectangular box */
import javafx.scene.input.MouseEvent;
/* For handling the event listeners */
import javafx.event.EventHandler;

/* RectangleList class that implements the Application class 
for the required JavaFx application */

public class RectangleList extends Application{

		/** Point class that holds the coordinates of point where user
	 * has clicked the mouse */
	private class Point{

		double x; // for X-cordinate 
		double y; // for Y-cordinate 

		// constructor for initializing the state 
		Point(double x, double y){

			this.x = x;
			this.y = y;
		}
	}

	/** Class for each Rectangular Node of List */
	private class RectangleNode{
		
		Point p; // Stores the top-right cordinates of Rectangle 
		double width; // for the width of the rectangle 
		double height; // for the height of the rectangle 
		double z_order; // for the z-order of the rectangle 
		Color color; // for the fill color of the Rectangle 
		RectangleNode nextRect; // for pointing the the next Rectangle Node 
		RectangleNode prevRect; // for pointing the previous Rectangle Node 
		

		// Constructor for initializing the RectangleNode object's state 
		RectangleNode(double x, double y, double width, double height,
		 double z_order, Color color) {

			this.p = new Point(x, y);
			this.width = width;
			this.height = height;
			this.z_order = z_order;
			this.color = color;
		} 

	}

	private RectangleNode head; // points to the bottom most Rectangle from user's view 
	private int size; // for the list size  

	// constructor that creates an empty list 
	public RectangleList(){
		head = null;
		size = 0;
	}

	/** Method that adds a Rectangle to the list with the specified parameters. This
	 * Method adds each rectangle in sorted order based on their z-order value. For 
	 * instance, the lowest z-order rectangle will be pointed by the head and the highest 
	 * will be the last node of the list */

	public void add(int x, int y, double width, double height,
	 double z_order, Color color){

		/* Initialize the Rectangle object */
		RectangleNode newRect = new RectangleNode(x, y, width, height, z_order, color);
		
		// for the very first Rectangle Node 
		if(head == null){			
			head = newRect;	
			size++;
		}

		// for the nodes whose Z-order is less than the head node 
		else if(head.z_order >= newRect.z_order){

			newRect.nextRect = head; // point next of new node to the head 
			// point previous to next node to the current node 
			newRect.nextRect.prevRect = newRect;
			// make the new node as head 
			head = newRect;
			// increment the list size by 1 
			size++;
		}
       
		// for the nodes whose Z-order is greater than the head node 
		else{

			RectangleNode curr = head; // starts from head  

			/** Find the Appropriate position using the curr
			 *  for the new Node based on the z-order value */
			while(curr.nextRect != null && 
				curr.nextRect.z_order <= newRect.z_order){
				curr = curr.nextRect;
			}
			/* Add the Node at the position where curr is pointing now */
			newRect.nextRect = curr.nextRect;

			if(curr.nextRect != null)
				newRect.nextRect.prevRect = newRect;
			
			curr.nextRect = newRect;
			newRect.prevRect = curr;

			size++;
		}	
	}

	/** Method that returns the last node of the list, which will be 
	 * the topmost rectangle from the user's view */

	public RectangleNode getTopMost(){

		RectangleNode temp = head; 

		while(temp.nextRect != null){
			temp = temp.nextRect;
		}

		return temp;
	}

	/** Method takes a Point P and returns true if this point lies 
	 * within the rectangle of given cordinates, otherwise return false. 
	 * */
	boolean findPoint(double x1, double y1, double x2,
               double y2, Point p) {

	    if (p.x > x1 && p.x < x2 && p.y > y1 && p.y < y2)
	        return true;
	 
	    return false;
	}

	/** Method that take out the Rectangle Node on which user 
	 * has clicked and makes it the topmost from user's view but 
	 * internally add that node to the last of the doubly linked list */
	public void makeTopmost(RectangleNode rect) throws Exception{

		RectangleNode curr = head; 

	// When the bottom most rectangle is clicked 
		if(rect == head) {

			head = head.nextRect; // move head to the next rectangle node 
			head.prevRect = null; // set the previous link to null for unlinking	
		}
	// for rest of the nodes 
		else{

			// Keep moving the next node until the clicked node finds 
			while(curr != rect){
				curr = curr.nextRect;
			}
// if finds, check whether it the last node or not 
			if(curr.nextRect != null){
// if no, take out unlink the clicked node from the list 
				curr.prevRect.nextRect = curr.nextRect;
				curr.nextRect.prevRect = curr.prevRect;
			}	
		}

// put the node at the last 
		if(rect.nextRect != null){

			rect.nextRect = null;
// get the reference of current top most node 
			RectangleNode last = getTopMost();
// make the clicked one as the new last node 
			rect.prevRect = last;

			last.nextRect = rect;
/* set the z-order of clicked one by 1 greater than the last one
 to main the z-order values */ 
			rect.z_order = last.z_order + 1;
			
		}

	}

/** This method captures the Point class object and flips 
 * rectangle based on this point */
	public void flipRects(Point p) throws Exception{

	// get the reference of last node 
		RectangleNode temp = getTopMost();

		while(temp != null){

		/* look for the rectangle on which the Point P lies first from
		the top most view */
			if(findPoint(temp.p.x, temp.p.y, (temp.p.x + temp.width)
				, (temp.p.y+temp.height), p)){
		/* if find, break the loop */
				break;
			}
		/* go the the previous node from last */
			temp = temp.prevRect;
		}

		/* make the temp node as the new last node */
		makeTopmost(temp);
	}
// method that prints the set of overlapping rectangular nodes 
	public void printRects(Stage stage) throws Exception{

		RectangleNode temp = head; // get the head node reference 

// for grouping the collection of overlapping Rectangle class objects 
		Group group = new Group();

		while(temp != null){

// Create the Rectangle class object 
			Rectangle rect = new Rectangle(temp.p.x, temp.p.y, temp.width, temp.height);
// set the color defined for this node 
			rect.setFill(temp.color);
// add this node to the list 
			group.getChildren().add(rect);
// move to the next node 
			temp = temp.nextRect;
		}

// An EventHandler class for handling the events 
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
		   @Override 
		   /** An overridden method of EventHandler class and is used to register
		    * an event handler */
		   public void handle(MouseEvent e){ 

		   		try{
		   		    // get the coordinates where the mouse is clicked 
			   		Point p = new Point(e.getX(), e.getY());
			   		// pass the point to the method to flip the rectangles
					flipRects(p);
					// print the flipped rectangles 
					printRects(stage);
				}
				catch(Exception ex){
					System.out.println("Something went wrong!");
				}
		   } 

		};

		//Registering the event handler for mouse clicking event  
    	group.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

		// Pass the group object to the Scene object type 
        Scene scene = new Scene(group, 300, 300);

        //Setting title to the Stage
        stage.setTitle("Overlapping Tabs"); 

        //Adding scene to the stage 
        stage.setScene(scene); 
         
	      //Displaying the contents of the stage 
	    stage.show(); 
	}

	// main drived method 
	public static void main(String[] args) {
		
		/** A static method defined in the Application class that 
		 * internally invokes the start method and pass the object of
		 * Stage object */
		launch(args);
	}

	/* An overridden method of Application class that is invoked by 
	the launch method */
	@Override
	public void start(Stage stage){

		try{
// create an object of RectangleList class 
			RectangleList lists = new RectangleList();
// Add the set of Rectangles to the list 
			lists.add(50, 50, 100, 100, 10, Color.RED);
			lists.add(70, 70, 100, 100, 18, Color.BLACK);
			lists.add(90, 90, 100, 100, 8, Color.BLUE);
			lists.add(110, 110, 100, 100, 6, Color.YELLOW);
			lists.add(130, 130, 100, 100, 19, Color.GRAY);
			lists.add(70, 90, 100, 150, 23, Color.GREEN);
			lists.add(40, 100, 60, 70, 13, Color.MAGENTA);
// print the rectangles 
			lists.printRects(stage);

		}

		catch(Exception e){
			System.out.println("Something went wrong! ");
		}
	}
}