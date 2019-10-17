package _0873;

import java.util.HashMap;
import java.util.Map;

/**
 * url: https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence/
 * dp
 */
public class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int len = A.length;
        int ans = 0;
        HashMap<Integer, Integer> longest = new HashMap<>(A.length);
        HashMap<Integer, Integer> local = new HashMap<>(A.length);
        for (int i = 0; i <len; i++) {
            local.put(A[i], i);
        }

        for (int k = 0; k < len; k++) {
            for (int j = 0; j < k; j++) {
                int i = local.getOrDefault(A[k] - A[j], -1);
                if (i >= 0 && i < j) {
                    int cand = longest.getOrDefault(i * len + j,2)+1;
                    ans=Math.max(ans, cand);
                    longest.put(j * len + k, cand);
                }
            }
        }
        return ans >= 3 ? ans : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,3,7,11,12,14,18};
        System.out.println(solution.lenLongestFibSubseq(arr));

    }
}

