package _0925;

import java.util.HashSet;

public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int p = 0;
        int q = 0;
        if (name.isEmpty() && !typed.isEmpty()) return false;
        if (!name.isEmpty() && typed.isEmpty()) return false;
        if (name.charAt(p)!=typed.charAt(q)) return false;
        while (p < name.length() && q < typed.length()) {

            while ( p < name.length() && q < typed.length() && name.charAt(p) == typed.charAt(q)) {
                p++;q++;
            }
            if (q == 0) {
                q++;
                continue;
            }
            if (q >= typed.length()) {
                continue;
            }
            if ( typed.charAt(q) == typed.charAt(q - 1)) {
                q++;
            }else {
                return false;
            }

        }
        while (q < typed.length() && typed.charAt(q) == typed.charAt(q - 1)) {
            q++;
        }

        if (p < name.length() || q<typed.length()) {
            return false;
        }

        return true;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isLongPressedName("aaa", "bb"));
    }
}
