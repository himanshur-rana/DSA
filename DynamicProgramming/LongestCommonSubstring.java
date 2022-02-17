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

    public static void main(String[] args) {
        
        String s = "abcde";
        String t = "abcde";
        System.out.println("The Ans --------->");
        LongestCommonSubstring lcsObj = new LongestCommonSubstring();
        lcsObj.longestCommonSubstringRecursion(s, t, 0);
        System.out.println(lcsObj.result);
    }
}
