public class NestedLoop {
    public static void main(String[] args) {
        for (int k = 5; k >= 1; k--) {
            for (int i = 0; i <= 10; i += 2) {
                System.out.println("k = " + k + ", i = " + i);
            }
        }
    }
}
