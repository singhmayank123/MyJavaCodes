
public class NumberFrequency 
{
    private int number;
    private int timesOccurred;
    private int lastOccurred;
         
    //no args constructor
    NumberFrequency()
        {
        this.number = 0;
        this.timesOccurred = 0;
        this.lastOccurred = 0;
    }
    
    /**
     * Constructor with number
     * @param num 
     */
    NumberFrequency(int num)
        {
        this.number = num;
        this.timesOccurred = 0;
        this.lastOccurred = 0;
    }
        
    //setter/getters
    /**
     * Set Number
     * @param n Number
     */
    public void setNumber(int n)
        {
        this.number = n;
    }
    
    /**
     * Set Times Occurred
     * @param n Times Occurred
     */
    public void setTimesOccurred(int n)
        {
        this.timesOccurred = n;
    }
    
    /**
     * Set Last Occurred
     * @param n Last Occurred
     */
    public void setLastOccurred(int n)
        {
        this.lastOccurred = n;
    }

    /**
     * Get Number
     * @return number
     */
    public int getNumber()
        {
        return this.number;
    }
    
    /**
     * Get Times Occurred
     * @return times Occurred
     */
    public int getTimesOccurred(){
        return this.timesOccurred;
    }
    
    /**
     * Get Last Occurred
     * @return last occurred
     */
    public int getLastOccurred()
        {
        return this.lastOccurred;
    }
        
}