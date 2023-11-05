import java.util.Scanner;

public class main1 {
    public static void iterativeFibonacci(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b);

        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }
    }

    public static int recursiveFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms to generate: ");
        int n = sc.nextInt();

        System.out.println("1. Iterative Fibonacci");
        iterativeFibonacci(n);
        System.out.println("\n2. Recursive Fibonacci");
        for (int i = 0; i < n; i++) {
            System.out.print(recursiveFibonacci(i) + " ");
        }
    }
}
