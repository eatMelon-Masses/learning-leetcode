package _0567;

import java.util.HashMap;

/**
 * @author zhouye
 * @date 2021/2/20
 */
public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            char b = s2.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
            map.put(b, map.getOrDefault(b, 0)-1);
            if (map.containsKey(b) && map.get(b) == 0) {

                map.remove(b);
            }
            if (map.containsKey(c) && map.get(c) == 0) {

                map.remove(c);
            }
        }
        if (map.size() == 0) {
            return true;
        }
        for (int left = 0, i = s1.length(); i < s2.length(); left++,i++) {
            char p = s2.charAt(left);
            char q = s2.charAt(i);
            map.put(p, map.getOrDefault(p, 0)+1);
            map.put(q, map.getOrDefault(q, 0)-1);
            if (map.containsKey(p) && map.get(p) == 0) {
                map.remove(p);
            }
            if (map.containsKey(q) && map.get(q) == 0) {
                map.remove(q);
            }
            if (map.size() == 0) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("aaa","aa"));

    }
}
