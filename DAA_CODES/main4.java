import java.util.*;

public class main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Items :");
        int N = sc.nextInt();

        int P[] = new int[N];
        System.out.println("Enter the profit in orders :");
        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        int W[] = new int[N];
        System.out.println("Enter the weight in orders :");
        for (int i = 0; i < N; i++) {
            W[i] = sc.nextInt();
        }

        System.out.println("Enter the Maximum Profit :");
        int weight = sc.nextInt();

        int dp[] = new int[weight + 1];

        for (int i = 0; i < N; i++) {
            for (int w = weight; w >= 0; w--) {
                if (W[i] <= w)
                    dp[w] = Math.max(dp[w], dp[w - W[i]] + P[i]);
            }
        }
        System.out.println("Profit :" + dp[weight]);

    }
}
