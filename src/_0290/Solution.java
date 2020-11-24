package _0290;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] charsS = s.split(" ");
        char[] charsP = pattern.toCharArray();
        HashSet<Character> pSet = new HashSet<>();
        HashSet<String> sSet = new HashSet<String>();

        if (charsP.length != charsS.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < charsP.length; i++) {

            if (map.containsKey(charsP[i])) {
                if (!map.get(charsP[i]).equals(charsS[i])) {
                    return false;
                }
            }else {
                map.put(charsP[i],charsS[i]);
            }
            pSet.add(charsP[i]);
            sSet.add(charsS[i]);
        }
        if (sSet.size() != pSet.size()) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.wordPattern("abab","dog dog dog dog"));
    }
}
