package DynamicProgramming;

public class LPS {
    
    public int minInsertions(String s) {
    
        String t = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            t += s.charAt(i);
        }

        System.out.println(t);

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
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[s.length()][t.length()]);
        return s.length() - dp[s.length()][t.length()];
        
    }

    public static void main(String[] args) {
        
        String s = "zzazz";
        System.out.println(new LPS().minInsertions(s));
    }
}
