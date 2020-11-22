package _1394;

/**
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 *
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 *
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 *
 */
public class Solution {
    public int findLucky(int[] arr) {
        int[] times = new int[501];
        for (int i = 0; i < arr.length; i++) {
            int index = arr[i];
            times[index]++;
        }
        for (int i = times.length-1; i >0; i--) {
            if (times[i] == i){
                return times[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findLucky(new int[]{}));
    }
}
