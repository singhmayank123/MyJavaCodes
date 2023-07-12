/** This is the Essay class that inherits the GradedActivity class.
 * It allows to manage the marks in Essay based on the four fields */

public class Essay extends GradedActivity{


   private double grammar; // 30 points 
   private double spelling; // 20 points 
   private double cor_length; // 20 points 
   private double content; // 30 points
   private double final_marks;
    

/** A constructor that takes scores in four fields and calls the setScore 
 * method to set the private score variable in the super class */

   public Essay(double g, double s, double cl, double cont){

      grammar = g;
      spelling = s;
      cor_length = cl;
      content = cont;
      /** Sum up the score of each field */
      final_marks = g+s+cl+cont;
      /* Method define in GradedActivity for setting the final score */
      setScore(final_marks);
   }
   
}
