package DynamicProgramming;
public class MinimumSubsetDiff {
    
    public static int minimumSubsetDiffRec(int[] arr, int size, int first, int second) {
        
        if(size == 0) {
            int diff = Math.abs(first - second);
            return diff;
        }

        int includedInFirstSetDiff = minimumSubsetDiffRec(arr, size - 1, first + arr[size - 1], second);
        int includedInSecondSetDiff = minimumSubsetDiffRec(arr, size - 1, first, second + arr[size - 1]);

        int minDiff = Math.min(includedInFirstSetDiff, includedInSecondSetDiff);
        return minDiff;

    }

    public static int minimumSubsetDiffDP(int[] arr) {

        int totalSum = 0;
        for(int i : arr) {
            totalSum  += i;
        }

        boolean[][] dp = new boolean[arr.length + 1][totalSum + 1];
        for(int i = 0; i <= totalSum; i++) {
            dp[0][i] = false;
        }
        for(int i = 0; i <= arr.length; i++) {
            dp[i][0] = true;
        }

        int ans = Integer.MAX_VALUE;

        for(int i = 1; i <= arr.length; i++) {
            for(int j = 1; j <= totalSum/2; j++) {
                if(arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                
                if(dp[i][j] == true) {
                    int diff = totalSum - 2 * j;
                    ans = Math.min(ans, diff);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 5, 11, 1};
        int ans = minimumSubsetDiffDP(arr);
        System.out.println("Ans +++");
        System.out.println(ans);
    }
}
