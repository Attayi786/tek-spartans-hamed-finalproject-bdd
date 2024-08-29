package tek.bdd.utilities;

public class CommonUtilities {

    // Pauses the execution of the program for the specified amount of time.
    public static void waitTime(int wait) {
        try {
            // Causes the current thread to sleep for the specified amount of time in milliseconds.
            Thread.sleep(wait);
        } catch (InterruptedException ex) {
            // If the sleep is interrupted, restore the interrupted status of the thread.
            Thread.currentThread().interrupt();
        }
    }
}