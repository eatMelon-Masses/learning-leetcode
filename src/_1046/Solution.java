package _1046;

import java.util.Arrays;

class Solution {
    public int lastStoneWeight(int[] stones) {

        while (stones.length > 1) {
            Arrays.sort(stones);
            int[] temp = new int[stones.length - 1];
            System.arraycopy(stones, 0, temp, 0, stones.length - 2);
            temp[temp.length - 1] = stones[stones.length - 1] - stones[stones.length - 2];
            stones = temp;
        }
            return stones[0];
    }

    public static void main(String[] args) {
        int[] ints = {};
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeight(ints));
    }
}
