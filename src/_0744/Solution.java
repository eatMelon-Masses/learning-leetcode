package _0744;/*
 * @lc app=leetcode.cn id=744 lang=java
 *
 * [744] 寻找比目标字母大的最小字母
 *
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/description/
 *
 * algorithms
 * Easy (43.13%)
 * Likes:    40
 * Dislikes: 0
 * Total Accepted:    8.7K
 * Total Submissions: 20.2K
 * Testcase Example:  '["c","f","j"]\n"a"'
 *
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * 
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回
 * 'a'。
 * 
 * 示例:
 * 
 * 
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "a"
 * 输出: "c"
 * 
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "c"
 * 输出: "f"
 * 
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "d"
 * 输出: "f"
 * 
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "g"
 * 输出: "j"
 * 
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "j"
 * 输出: "c"
 * 
 * 输入:
 * letters = ["c", "f", "j"]
 * target = "k"
 * 输出: "c"
 * 
 * 
 * 注:
 * 
 * 
 * letters长度范围在[2, 10000]区间内。
 * letters 仅由小写字母组成，最少包含两个不同的字母。
 * 目标字母target 是一个小写字母。
 * 
 * 
 */

// @lc code=start
class Solution {
    public char nextGreatestLetter(final char[] letters, final char target) {
        int left = 0;
        int right = letters.length;
        if (letters[0] > target || letters[letters.length - 1] <= target) return letters[0];
        while(left < right){
            final int mid = left +right >> 1;
            if((letters[mid]) <=target){
                left = mid + 1;
            //System.out.println("left"+left);
            }else{
                right = mid;
               // System.out.println("right"+right);
            }
                //System.out.println(mid);

        }
        return letters[left];
    }
}

// @lc code=end

