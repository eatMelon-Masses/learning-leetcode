package _0241;/*
 * @lc app=leetcode.cn id=241 lang=java
 *
 * [241] 为运算表达式设计优先级
 *
 * https://leetcode-cn.com/problems/different-ways-to-add-parentheses/description/
 *
 * algorithms
 * Medium (69.30%)
 * Likes:    94
 * Dislikes: 0
 * Total Accepted:    4.8K
 * Total Submissions: 7K
 * Testcase Example:  '"2-1-1"'
 *
 * 给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及
 * * 。
 * 
 * 示例 1:
 * 
 * 输入: "2-1-1"
 * 输出: [0, 2]
 * 解释: 
 * ((2-1)-1) = 0 
 * (2-(1-1)) = 2
 * 
 * 示例 2:
 * 
 * 输入: "2*3-4*5"
 * 输出: [-34, -14, -10, -10, 10]
 * 解释: 
 * (2*(3-(4*5))) = -34 
 * ((2*3)-(4*5)) = -14 
 * ((2*(3-4))*5) = -10 
 * (2*((3-4)*5)) = -10 
 * (((2*3)-4)*5) = 10
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Solution {
    public List<Integer> diffWaysToCompute(final String input) {
        if(input.isEmpty()) return new ArrayList<Integer>();
        final List<Integer> res = dg(input.toCharArray());
        //Collections.sort(res);
        return res;
    }
    public List<Integer> dg(final char[] chars){
        final List<Integer> res = new ArrayList<Integer>();
        
        int count = 0;
        for(int i = 0;i<chars.length;i++){
            final char e = chars[i];
            
            if(e > 41 && e <46){
                //System.out.println("e,"+e);
                count++;
                final List<Integer> left = dg(Arrays.copyOfRange(chars,0,i));
                final List<Integer> right =dg(Arrays.copyOfRange(chars,i+1,chars.length));
                for(final Integer leftN:left){
                    for(final Integer rightN:right){
                        int tempResult = 0;
                        switch(e){
                            case '-':
                                tempResult=leftN - rightN;
                                break;
                            case '*':
                                tempResult=leftN * rightN;     
                                break;
                            case '+':
                                tempResult=leftN + rightN;
                                break;
                        }
                        res.add(tempResult);
                    }
                }
            }
        }
        if(chars.length == 0){
            res.add(1);
        }else if(count == 0) {
            res.add(Integer.valueOf(String.valueOf(chars)));
        }
        return res;
    }
}
// @lc code=end

