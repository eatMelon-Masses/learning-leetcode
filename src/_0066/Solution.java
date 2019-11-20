package _0066;/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 *
 * https://leetcode-cn.com/problems/plus-one/description/
 *
 * algorithms
 * Easy (41.79%)
 * Likes:    372
 * Dislikes: 0
 * Total Accepted:    93K
 * Total Submissions: 222.6K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1:
 * 
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 
 * 
 * 示例 2:
 * 
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits.length==0) return null;
        int[] a;
        boolean sign=false;
            int i=digits.length-1;

                if(digits[i]<9) {
                    digits[i]++;
                    
                }
                else{
                    do{
                      digits[i]=0;
                      i--;
                        
                    }while(i>=0&&digits[i]>8);
                    
                    if(i<0)  
                        sign=true;
                    else
                        digits[i]++;
                }

            
            if(sign){
                a=new int[digits.length+1];
                a[0]=1;
                for(int j=1;j<=a[a.length-1];j++)
                    a[j]=digits[j-1];
                digits=a;
                a=null;
                sign=false;
            }        
        return digits;
    }
}
// @lc code=end

