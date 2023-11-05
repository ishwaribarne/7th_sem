import java.util.*;

public class main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number of Items :");
        int n = sc.nextInt();

        int P[] = new int[n];

        System.out.println("Enter the Profit in order :");
        for (int i = 0; i < n; i++) {
            P[i] = sc.nextInt();
        }

        int W[] = new int[n];
        System.out.println("Enter the Weight in order :");
        for (int i = 0; i < n; i++) {
            W[i] = sc.nextInt();
        }

        System.out.println("Enter the Maximum Weight :");
        int weight = sc.nextInt();

        // Calculate profit-to-weight ratios
        double[] ratios = new double[n];
        for (int i = 0; i < n; i++) {
            ratios[i] = (double) P[i] / W[i];
        }

        // Sort items based on ratios in descending order
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ratios[j] < ratios[j + 1]) {

                    double tempRatio = ratios[j];
                    ratios[j] = ratios[j + 1];
                    ratios[j + 1] = tempRatio;

                    int tempProfit = P[j];
                    P[j] = P[j + 1];
                    P[j + 1] = tempProfit;

                    int tempWeight = W[j];
                    W[j] = W[j + 1];
                    W[j + 1] = tempWeight;
                }
            }
        }

        double maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (W[i] <= weight) {
                maxProfit += P[i];
                weight -= W[i];
            } else {
                maxProfit += (weight / (double) W[i]) * P[i];
                break;
            }
        }

        System.out.println("Profit: " + maxProfit);
    }
}
