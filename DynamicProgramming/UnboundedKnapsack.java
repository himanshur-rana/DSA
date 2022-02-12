package DynamicProgramming;

public class UnboundedKnapsack {
    
    public static int unboundedKnapsackRecursion(int[] weights, int[] values, int maxCapacity, int size) {

        if(size == 0 || maxCapacity == 0) {
            return 0;
        }

        int valueWithIncluded = 0;
        if(weights[size - 1] <= maxCapacity) {
            valueWithIncluded = values[size - 1] + unboundedKnapsackRecursion(weights, values, maxCapacity - weights[size - 1], size);
        }
        int valueWithoutIncluded = unboundedKnapsackRecursion(weights, values, maxCapacity, size - 1);

        return Math.max(valueWithIncluded, valueWithoutIncluded);
    }

    public static int unboundedKnapsackDP(int[] weights, int[] values, int maxCapacity, int size) {

        int dp[][] = new int[size + 1][maxCapacity + 1];
        for(int i = 0; i <= size; i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i <= maxCapacity; i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= maxCapacity; j++) {
                int includedSum = 0;
                if(weights[i - 1] <= j) {
                    includedSum = values[i - 1] + dp[i - 1][j- weights[i - 1]];
                    includedSum = Math.max(includedSum, values[i - 1] + dp[i][j - weights[i - 1]]);
                }
                int notIncludedSum = dp[i - 1][j];
                dp[i][j] = Math.max(includedSum, notIncludedSum);
            }
        }

        return dp[size][maxCapacity];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3};
        int[] values = {6, 18};
        int maxCapacity = 50;
        System.out.println("Answere is ++");
        System.out.println(unboundedKnapsackDP(weights, values, maxCapacity, weights.length));
    }

}

