package _1438;


import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhouye
 * @date 2021/2/22
 *
 *
 * 1438. 绝对差不超过限制的最长连续子数组
 *
 *给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
 *
 * 如果不存在满足条件的子数组，则返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [8,2,4,7], limit = 4
 * 输出：2
 * 解释：所有子数组如下：
 * [8] 最大绝对差 |8-8| = 0 <= 4.
 * [8,2] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4] 最大绝对差 |8-2| = 6 > 4.
 * [8,2,4,7] 最大绝对差 |8-2| = 6 > 4.
 * [2] 最大绝对差 |2-2| = 0 <= 4.
 * [2,4] 最大绝对差 |2-4| = 2 <= 4.
 * [2,4,7] 最大绝对差 |2-7| = 5 > 4.
 * [4] 最大绝对差 |4-4| = 0 <= 4.
 * [4,7] 最大绝对差 |4-7| = 3 <= 4.
 * [7] 最大绝对差 |7-7| = 0 <= 4.
 * 因此，满足题意的最长子数组的长度为 2 。
 * 解题思路：优先队列+滑动窗口
 *
 */
public class Solution {
    HashMap<Integer, Integer> countSmallQueue = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> countBigQueue = new HashMap<Integer, Integer>();

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> bigQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }

        });
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>();
        int result = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = Math.abs(nums[i]);
            bigQueue.add(num);
            smallQueue.add(num);
            if (check(bigQueue, smallQueue, limit)) {
                 result = Math.max(result, i - left + 1);
            }else {
                delete(nums[left],countBigQueue);
                delete(nums[left],countSmallQueue);
                left++;

            }
        }
        return result;
    }

    public void parse(Queue<Integer> queue,HashMap<Integer,Integer> counts){
        while (!queue.isEmpty()) {
            Integer peek = queue.peek();
            if (counts.containsKey(peek) && counts.get(peek) >0) {
                queue.poll();
                counts.put(peek, counts.get(peek) - 1);
            }else{
                break;
            }
        }
    }
    public boolean check(Queue<Integer> bigQueue,Queue<Integer> smallQueue,int limit){
        parse(bigQueue,countBigQueue);
        parse(smallQueue,countSmallQueue);
        if (bigQueue.isEmpty() || smallQueue.isEmpty()) {
            return true;
        }
        return (bigQueue.peek() - smallQueue.peek()) <= limit;
    }
    public  void  delete(int num,HashMap<Integer,Integer> counts) {
        counts.put(num, counts.getOrDefault(num, 0)+1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {2};
        System.out.println(solution.longestSubarray(ints,2));
    }
}
