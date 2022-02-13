package DynamicProgramming;

public class CoinChange2 {

    public int coinChange(int[] coins, int amount) {
        
        return coinChangeRecursion(coins, amount, coins.length);
    }

    private int coinChangeRecursion(int[] coins, int amount, int size) {
        
        if(amount == 0) {
            return 0;
        }

        if(size == 0){
            return - 1;
        }

        int firstResult = 0;
        if(coins[size - 1] <= amount) {
            firstResult = 1 + coinChangeRecursion(coins, amount - coins[size - 1], size);
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
    
}
