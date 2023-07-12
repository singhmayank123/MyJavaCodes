// TODO: FILE HEADER

public class GuitarString {

    private RingBuffer buffer; // ring buffer
    // TODO: YOUR OTHER INSTANCE VARIABLES HERE (IF ANY)

    /**
     * Constructor: Creates a guitar string of the given frequency
     */
    public GuitarString(double frequency) {
        // TODO: YOUR CODE HERE
    }

    // TODO: Add a method header comment
    public void pluck() {
        // TODO: YOUR CODE HERE
    }

    // TODO: Add a method header comment
    public void tic() {
        // TODO: YOUR CODE HERE
    }

    // TODO: Add a method header comment
    public double sample() {
        // TODO: YOUR CODE HERE

        return 0.0; // dummy return statement so the code compiles
    }

    // TODO: Add a method header comment
    public int time() {
        // TODO: YOUR CODE HERE

        return 0; // dummy return statement so the code compiles
    }

    // GuitarString checkpoint test
    public static void main(String[] args) {
        // how many samples should we "play"
        int numSamplesToPlay = Integer.parseInt(args[0]);

        // a starting set of samples; it's pretty easy to calculate
        // the new samples that will get generated with a calculator
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  

        // create a guitar string to test with exactly samples.length,
        // this looks a little funny because the HarpString constructor
        // expects a frequency, not a number of elements
        GuitarString testString = new GuitarString(44100.0 / samples.length);

        // at this point the RingBuffer underlying testString should have
        // a capacity of samples.length and should be full
        System.out.println("testString.buffer.isEmpty(): " + 
                            testString.buffer.isEmpty());
        System.out.println("testString.buffer.isFull():  " + 
                            testString.buffer.isFull());

        // replace all the zeroes with the starting samples
        for (int i = 0; i < samples.length; i++) {
            testString.buffer.dequeue();
            testString.buffer.enqueue(samples[i]);
        }

        // "play" for numSamples samples; printing each one for inspection
        for (int i = 0; i < numSamplesToPlay; i++) {
            int t = testString.time();
            double sample = testString.sample();

            // this statement prints the time t, padded to 6 digits wide
            // and the value of sample padded to a total of 8 characters
            // including the decimal point and any - sign, and rounded
            // to four decimal places
            System.out.printf("%6d %8.4f\n", t, sample);

            testString.tic(); // advance to next sample
        }
    }
}
