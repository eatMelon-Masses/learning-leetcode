package _0117;/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii/description/
 *
 * algorithms
 * Medium (42.29%)
 * Likes:    80
 * Dislikes: 0
 * Total Accepted:    10.1K
 * Total Submissions: 23.8K
 * Testcase Example:  '{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}'
 *
 * 给定一个二叉树
 * 
 * struct Node {
 * ⁠ int val;
 * ⁠ Node *left;
 * ⁠ Node *right;
 * ⁠ Node *next;
 * }
 * 
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * 
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * 
 * 
 * 
 * 示例：
 * 
 * 
 * 
 * 
 * 输入：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":null,"right":null,"val":4},"next":null,"right":{"$id":"4","left":null,"next":null,"right":null,"val":5},"val":2},"next":null,"right":{"$id":"5","left":null,"next":null,"right":{"$id":"6","left":null,"next":null,"right":null,"val":7},"val":3},"val":1}
 * 
 * 
 * 输出：{"$id":"1","left":{"$id":"2","left":{"$id":"3","left":null,"next":{"$id":"4","left":null,"next":{"$id":"5","left":null,"next":null,"right":null,"val":7},"right":null,"val":5},"right":null,"val":4},"next":{"$id":"6","left":null,"next":null,"right":{"$ref":"5"},"val":3},"right":{"$ref":"4"},"val":2},"next":null,"right":{"$ref":"6"},"val":1}
 * 
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start

class Solution {
    public Node connect(final Node root) {
    if(root==null) return root; 
    final List<Node> curNodes=new ArrayList<Node>();
    final List<Node> nextNodes = new ArrayList<Node>();
    curNodes.add(root);
    Node p=null;
    while(!curNodes.isEmpty()){
        p=curNodes.get(0);
        for(int i=1;i<curNodes.size();i++){
        final Node temp=curNodes.get(i);
            p.next=temp;
            p=temp;            
        }
        for(int j=0;j<curNodes.size();j++){
            final Node temp=curNodes.get(j);

            if(temp.left!=null) nextNodes.add(temp.left);
            if(temp.right!=null) nextNodes.add(temp.right);

        }
        curNodes.clear();
        curNodes.addAll(nextNodes);
        nextNodes.clear();
    }
    return root;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(final int _val, final Node _left, final Node _right, final Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
// @lc code=end

