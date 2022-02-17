package DynamicProgramming;

public class LongestCommonSubstring {
    
    int result = Integer.MIN_VALUE;

    public void longestCommonSubstringRecursion(String s, String t, int currentLength) {

        if(s.length() == 0 || t.length() == 0) {
            result = Math.max(result, currentLength);
            return;
        }

        if(s.charAt(0) == t.charAt(0)) {
            longestCommonSubstringRecursion(s.substring(1), t.substring(1), currentLength + 1);
        }
        longestCommonSubstringRecursion(s.substring(1), t, 0);
        longestCommonSubstringRecursion(s, t.substring(1), 0);

    }

    public int longestCommonSubstringDP(String s, String t) {

        int dp[][] = new int[s.length() + 1][t.length() + 1];

        for(int i = 0; i <= s.length(); i++) {
            dp[i][0] = 0;
        }
        for(int i = 0; i <= t.length(); i++) {
            dp[0][i] = 0;
        }

        int result = 0;

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        
        String s = "cabd";
        String t = "zabde";
        System.out.println("The Ans --------->");
        LongestCommonSubstring lcsObj = new LongestCommonSubstring();
        int result = lcsObj.longestCommonSubstringDP(s, t);
        System.out.println(result);
    }
}
