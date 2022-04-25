package _0147;


import javax.swing.plaf.SliderUI;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode q = head;
        head = head.next;
        q.next = null;
        while(null!=head){
        ListNode pre = null;
        ListNode cur = q;
            while(cur!=null&&cur.val < head.val){
                pre = cur;
                cur = cur.next;
            }
              ListNode temp = head;
              head = head.next;
            if(pre ==null){
                pre = temp;
                pre.next = cur;
                q= pre;
            }else{
              pre.next = temp;
              temp.next = cur;
            }
        }
        return q;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        Solution solution = new Solution();
        solution.insertionSortList(head);
    }

}    class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}