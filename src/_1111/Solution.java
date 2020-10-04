package _1111;

import java.util.Arrays;

public class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int d = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                d++;
                result[i] = d % 2;
            }else {
                result[i] = d % 2;
                d--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.maxDepthAfterSplit("()()")));
    }
}
