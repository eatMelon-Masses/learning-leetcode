package _0284;/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 *
 * https://leetcode-cn.com/problems/peeking-iterator/description/
 *
 * algorithms
 * Medium (70.11%)
 * Likes:    21
 * Dislikes: 0
 * Total Accepted:    2K
 * Total Submissions: 2.9K
 * Testcase Example:  '["PeekingIterator","next","peek","next","next","hasNext"]\n[[[1,2,3]],[],[],[],[],[]]'
 *
 * 给定一个迭代器类的接口，接口包含两个方法： next() 和 hasNext()。设计并实现一个支持 peek() 操作的顶端迭代器 --
 * 其本质就是把原本应由 next() 方法返回的元素 peek() 出来。
 * 
 * 示例:
 * 
 * 假设迭代器被初始化为列表 [1,2,3]。
 * 
 * 调用 next() 返回 1，得到列表中的第一个元素。
 * 现在调用 peek() 返回 2，下一个元素。在此之后调用 next() 仍然返回 2。
 * 最后一次调用 next() 返回 3，末尾元素。在此之后调用 hasNext() 应该返回 false。
 * 
 * 
 * 进阶：你将如何拓展你的设计？使之变得通用化，从而适应所有的类型，而不只是整数型？
 * 
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class Solution {
    public boolean lemonadeChange(final int[] bills) {
        int fiveNums=0;
        int tenNums=0;
        int twentyNums=0;
        for(int i=0;i<=bills.length-1;i++){
            switch(bills[i]){
                case 5: fiveNums++;
                    break;
                case 10:
                    if(fiveNums>=1){
                        fiveNums--;
                        tenNums++;                        
                    } 
                    else{
                        return false;
                        };
                        
                    break;
                case 20:
                    if(tenNums>0 &&fiveNums>0){
                        tenNums--;
                        fiveNums--;
                        twentyNums++;
                        
                    }else if(fiveNums>=3){
                        fiveNums=fiveNums-3;
                        twentyNums++;
                        
                    }else{
                        return false;
                    }
                    break;
            } 

        }
        return true;
    }
}
// @lc code=end

