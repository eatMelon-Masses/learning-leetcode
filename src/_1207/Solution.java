package _1207;

import java.util.HashSet;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] times = new int[2001];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] += 2001;
            }
            times[arr[i]]++;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int time : times)
            if (time > 0) {
                if (set.contains(time)) {
                    return false;
                } else {
                    set.add(time);
                }
            }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(new int[]{-1000,-1000,-3}));
    }
}
