package _0105;

class Solution3 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dg(preorder,inorder,0,0,inorder.length-1);
    }
    public TreeNode dg(int[] preorder, int[] inorder,Integer p,int left,int right){
        if(p == inorder.length) return null;
        TreeNode root=new TreeNode(preorder[p]);
        if(left == right) return root;
        int index = 0;
        for(int i =left;i<=right;i++){
            if(root.val == inorder[i]){
                index = i;
                break;
            }
        }
        root.left = dg(preorder,inorder,p++,left,index-1);
        root.right = dg(preorder,inorder,p++,index+1,right);
        return root;
    }

    public static void main(String[] args) {

        Solution3 solution3 = new Solution3();
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
