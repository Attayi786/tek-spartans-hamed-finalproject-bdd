package tek.bdd.exceptions;

// Define a custom exception class named ExceptionsHandling that extends RuntimeException
public class ExceptionsHandling extends RuntimeException {

    // Constructor that accepts a reason for the exception and passes it to the superclass
    public ExceptionsHandling(String reason) {
        super(reason); // Pass the reason string to the RuntimeException constructor
    }
}
