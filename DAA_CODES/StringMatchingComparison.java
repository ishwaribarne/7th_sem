import java.util.Random;

public class StringMatchingComparison {
    public static void main(String[] args) {
        String text = generateRandomText(10000); // Generate a long random text for testing
        String pattern = "ab"; // Pattern to search for in the text

        // Measure time taken by the Naive string matching algorithm
        long startTimeNaive = System.nanoTime();
        naiveStringMatch(text, pattern);
        long endTimeNaive = System.nanoTime();
        long timeTakenNaive = endTimeNaive - startTimeNaive;

        // Measure time taken by the Rabin-Karp algorithm
        long startTimeRabinKarp = System.nanoTime();
        rabinKarpStringMatch(text, pattern);
        long endTimeRabinKarp = System.nanoTime();
        long timeTakenRabinKarp = endTimeRabinKarp - startTimeRabinKarp;

        System.out.println("Naive String Matching Time: " + timeTakenNaive + " nanoseconds");
        System.out.println("Rabin-Karp Time: " + timeTakenRabinKarp + " nanoseconds");
        System.out.println("Time Difference: " + (timeTakenNaive - timeTakenRabinKarp) + " nanoseconds");
    }

    public static void naiveStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void rabinKarpStringMatch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int d = 256; // Number of possible characters in the input alphabet
        int q = 101; // A prime number for hash calculation
        int h = 1;

        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        int p = 0;
        int t = 0;

        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        for (int i = 0; i <= n - m; i++) {
            if (p == t) {
                int j;
                for (j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                if (j == m) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }

    public static String generateRandomText(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            char randomChar = characters.charAt(random.nextInt(characters.length()));
            sb.append(randomChar);
        }

        return sb.toString();
    }
}
