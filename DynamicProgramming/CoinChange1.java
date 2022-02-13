package DynamicProgramming;

public class CoinChange1 {
    
    public int change(int amount, int[] coins) {
        return changeDP(amount, coins);
    }
    
    public int changeRecursion(int amount, int[] coins, int size) {
        
        if(amount == 0) {
            return 1;
        }

        if(size == 0) {
            return 0;
        }

        int coinIncludedCount = 0;
        if(coins[size - 1] <= amount) {
            coinIncludedCount = changeRecursion(amount - coins[size - 1], coins, size);
        }
        int coinNotIncludedCount = changeRecursion(amount, coins, size - 1);

        int totalCount = coinIncludedCount + coinNotIncludedCount;
        return totalCount;

    }

    public int changeDP(int amount, int[] coins) {
         
        int dp[][] = new int[coins.length + 1][amount + 1];
        for(int i = 0; i <= amount; i++) {
            dp[0][i] = 0; 
        }
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j<= amount; j++) {
                int totalCount = 0;
                if(coins[i - 1] <= j) {
                    totalCount += dp[i][j - coins[i - 1]];
                }
                totalCount += dp[i - 1][j];
                dp[i][j] = totalCount;
            }
        }

        return dp[coins.length][amount];
    }

}
