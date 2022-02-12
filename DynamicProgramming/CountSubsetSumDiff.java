package DynamicProgramming;

public class CountSubsetSumDiff {
    
    public static int countSubsetSumDiff(int[] arr, int diff) {

        int totalSum = 0;
        for(int a : arr) {
            totalSum += a;
        }
        int requiredFirstSetSum = (totalSum + diff) / 2;
        int[][] dp = new int[arr.length + 1][requiredFirstSetSum + 1];
        for(int i = 0; i <= requiredFirstSetSum; i++) {
            dp[0][i] = 0;
        }
        for(int i = 0; i <= arr.length; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= arr.length; i++) {
            for(int j = 1; j <= requiredFirstSetSum; j++) {
                dp[i][j] = 0;
                if(arr[i - 1] <= j) {
                    dp[i][j] += dp[i - 1][j - arr[i - 1]];
                } 

                dp[i][j] += dp[i - 1][j];

            }
        }
        
        return dp[arr.length][requiredFirstSetSum];

    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int diff = 1;
        System.out.println("The answer is++");
        int count = countSubsetSumDiff(arr, diff);
        System.out.println(count);
    }
}
