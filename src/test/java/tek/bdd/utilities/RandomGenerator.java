package tek.bdd.utilities;

public class RandomGenerator {

    // Generates a random email address using the provided prefix
    public static String randomEmail(String prefix) {
        int random = (int) (Math.random() * 1000); // Generates a random integer between 0 and 999
        return prefix + random + "@gmail.com"; // Concatenates the prefix, random number, and domain to form an email address
    }
}