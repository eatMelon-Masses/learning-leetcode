package _0155;/*
 * @lc app=leetcode.cn id=155 lang=java
 *
 * [155] 最小栈
 *
 * https://leetcode-cn.com/problems/min-stack/description/
 *
 * algorithms
 * Easy (50.41%)
 * Likes:    316
 * Dislikes: 0
 * Total Accepted:    55.1K
 * Total Submissions: 109.3K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * 
 * 
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 
 * 
 * 示例:
 * 
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    private final List<Integer> assStack = new ArrayList<Integer>();
    private final List<Integer>  dataStack = new ArrayList<Integer>();
    /** initialize your data structure here. */
    public Solution() {
     assStack.add(Integer.MAX_VALUE);   
    }
    
    public void push(final int x) {
     if(assStack.get(assStack.size()-1)>=x){
         assStack.add(x);
     }  
        dataStack.add(x);
    }
    
    public void pop() {
     final int dataSize = dataStack.size();
     if(dataSize==0) return;
     final int assSize = assStack.size();
     if(dataStack.get(dataSize-1).equals(assStack.get(assSize-1))){
         assStack.remove(assSize-1);
     }
     dataStack.remove(dataSize-1);
    }
    
    public int top() {
        final int dataSize = dataStack.size();
        if(dataSize==0) return -1;
        return dataStack.get(dataSize-1);
    }
    
    public int getMin() {
        int result = 0;
        final int assSize = assStack.size();
        if(assSize>1){
            result=assStack.get(assStack.size()-1);   
        }
        return result;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
// @lc code=end

