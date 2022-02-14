package DynamicProgramming;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceDP(text1, text2);    
    }

    private int longestCommonSubsequenceRecursion(String text1, String text2) {
        
        if(text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;

        if(text1.charAt(0) == text2.charAt(0)) {
            result = 1 + longestCommonSubsequenceRecursion(text1.substring(1), text2.substring(1));
        }
        result = Math.max(result, longestCommonSubsequenceRecursion(text1.substring(1), text2));
        result = Math.max(result, longestCommonSubsequenceRecursion(text1, text2.substring(1)));

        return result;
    }

    private int longestCommonSubsequenceDP(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        
        for(int i = 0; i <= text1.length(); i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i <= text2.length(); i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
            }
        }

        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "abe";
        
        new LongestCommonSubsequence().longestCommonSubsequence(text1, text2);
    }
    
}
