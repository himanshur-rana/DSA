package DynamicProgramming;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequenceRecursion(text1, text2);    
    }

    private int longestCommonSubsequenceRecursion(String text1, String text2) {
        
        if(text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int result = Integer.MIN_VALUE;

        if(text1.charAt(0) == text2.charAt(0)) {
            result = 1 + longestCommonSubsequenceRecursion(text1.substring(1), text2.substring(1));
        }
        result = Math.max(result, longestCommonSubsequence(text1.substring(1), text2));
        result = Math.max(result, longestCommonSubsequence(text1, text2.substring(1)));

        return result;
    }
    
}
