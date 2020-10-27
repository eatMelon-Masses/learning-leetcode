package _1365;

import java.util.*;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ints = new int[nums.length];
        System.arraycopy(nums, 0, ints, 0, nums.length);
        Arrays.sort(nums);
        //HashSet<Integer> tempSet = new HashSet<>();
        HashMap<Integer, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int p = i;
            while (p > 0 && nums[p]==nums[p-1]) {
                p--;
            }
            tempMap.put(nums[p], p);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < ints.length; i++) {
            result[i] = tempMap.get(ints[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.smallerNumbersThanCurrent(new int[]{2,3,3})));
    }
}
