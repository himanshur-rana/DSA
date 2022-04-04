package DynamicProgramming;

public class EggDrop {

    public int superEggDrop(int k, int n) {

        int dp[][] = new int[k + 1][n + 1];

        for(int i = 1; i <= k; i++) {
            for(int j = 0; j <= 1; j++) {
                dp[i][j] = j;
            }
        }

        for(int i = 0; i <= n; i++) {
            dp[1][i] = i; 
        }

        int result = Integer.MAX_VALUE;

        for(int i = 2; i <= k; i++) {
            for(int j = 2; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int f = 1; f <= j; f++) {
                    int tempAns = 1 + Math.max(dp[i - 1][f - 1], dp[i][j - f]);
                    dp[i][j] = Math.min(tempAns, dp[i][j]);
                }
            }
        }

        return dp[k][n];

    }

    public int superEggDropRecursion(int k, int n) {
        
        if(n == 0 || n == 1) {
            return n;
        }

        if(k == 1) {
            return n;
        }

        int finalAns = Integer.MAX_VALUE;

        for(int i = 1; i <= n; i++) {
            int result = 1 + Math.max(superEggDrop(k - 1, i - 1), superEggDrop(k, n - i));
            finalAns = Math.min(result, finalAns);
        }

        return finalAns;
    }
    
}
