package DynamicProgramming;

public class ShortestCommonSS {
    
    public String shortestCommonSupersequence(String s, String t) {
        
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        for(int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i <= t.length(); i++) {
            dp[0][i] = 0;
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        String finalResult = "";
        int i = s.length();
        int j = t.length();

        while(i > 0 && j > 0) {
            if(s.charAt(i - 1) == t.charAt(j - 1)) {
                finalResult = s.charAt(i - 1) + finalResult;
                i--;
                j--;
            } else if(dp[i - 1][j] > dp[i][j - 1]) {
                finalResult = s.charAt(i - 1) + finalResult;
                i--;
            } else {
                finalResult = t.charAt(j - 1) + finalResult;
                j--;
            }
        }

        while(i > 0) {
            finalResult = s.charAt(i - 1) + finalResult;
            i--;
        }
        while(j > 0) {
            finalResult = t.charAt(j - 1) + finalResult;
            j--;
        }

        return finalResult;
    }    
}
