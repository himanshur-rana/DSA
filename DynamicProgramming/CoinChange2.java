package DynamicProgramming;

public class CoinChange2 {

    public int coinChange(int[] coins, int amount) {
        
        return coinChangeRecursionDP(coins, amount);
    }

    private int coinChangeRecursion(int[] coins, int amount, int size) {
        
        if(amount == 0) {
            return 0;
        }

        if(size == 0){
            return - 1;
        }

        int firstResult = -1;
        if(coins[size - 1] <= amount) {
            
            int recursionResult  = coinChangeRecursion(coins, amount - coins[size - 1], size);
            if(recursionResult != -1) {
                firstResult = 1 + recursionResult;
            }
        }
        int secondResult = coinChangeRecursion(coins, amount, size - 1);

        if(firstResult == -1) {
            return secondResult;
        }
        if(secondResult == -1) {
            return firstResult;
        }

        return Math.min(firstResult, secondResult);
    }    

    private int coinChangeRecursionDP(int[] coins, int amount) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        for(int i = 0; i <= amount; i++) {
            dp[0][i] = -1;
        }
        for(int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }

        for(int i = 1; i <= coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                int firstResult = -1;
                if(coins[i - 1] <= j) {
                    int previousResult = dp[i][j - coins[i - 1]];
                    if(previousResult != -1) {
                        firstResult = 1 + previousResult;
                    }
                }
                int secondResult = dp[i - 1][j];
                
                if(firstResult == -1) {
                    dp[i][j] = secondResult;
                }
                else if(secondResult == - 1) {
                    dp[i][j] = firstResult;
                } else {
                    dp[i][j] = Math.min(firstResult, secondResult);
                }
                
            }
        }

        return dp[coins.length][amount];
    }   

}
