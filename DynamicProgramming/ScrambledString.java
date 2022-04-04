package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {

    public Map<String, Boolean> mapOfDP = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
    
        if(s1.length() == 1) {
            if(s1.charAt(0) == s2.charAt(0)) {
                return true;
            } else {
                return false;
            }
        }

        if(mapOfDP.get(getKey(s1,s2)) != null){
            return mapOfDP.get(getKey(s1,s2));
        }
        // s1 = great
        // s2 = rgeat
        boolean flag = false;
        for(int i = 1; i < s1.length(); i++) {
            if(isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                flag = true;
                break;
            }
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                    flag = true;
                    break;
            }
        }

        mapOfDP.put(getKey(s1,s2), flag);
        return flag;

    }

    public String getKey(String a, String b){
        return a + "_" + b;
    }
    
}
