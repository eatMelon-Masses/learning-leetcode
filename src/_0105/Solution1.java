package _0105;

/**
 * 理清思路，中序遍历框架，先序遍历数组挂载根节点节点，切割左右子树，递归
 */
class Solution1 {
    int[] inorder=null;
    int[] postorder=null;
    int pStart = 0;
    public TreeNode buildTree(final int[] preorder, final int[] inorder) {
        this.inorder=inorder;
        this.postorder=preorder;
        return magic(preorder, inorder, 0, inorder.length);
    }

    public TreeNode magic(final int[] preorder, final int[] inorder, int iStart, int iEnd) {
        if(pStart==preorder.length || iStart == iEnd) return null;
        int e = preorder[pStart++];
        TreeNode root = new TreeNode(e);
        int mid = findIndex(e, inorder,iStart,iEnd );
        root.left = magic(preorder, inorder, iStart,mid );
        root.right = magic(preorder,inorder, mid + 1, iEnd);
        return root;
    }
    public int findIndex(int target,int[] people,int iStart,int iEnd){
        for (int i = iStart; i < iEnd; i++) {
            if (target == people[i]) {
                return i;
            }
        }
        return -1;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(final int x) { val = x; }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        TreeNode magic = solution1.magic(new int[]{3, 9, 20}, new int[]{9, 3, 20}, 0, 3);
        System.out.println();
    }
}