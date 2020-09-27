package _0106;

class Solution1 {
    int p = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        p = postorder.length -1;
        return dg(inorder,postorder,0,inorder.length-1);
    }
    TreeNode dg(int[] inorder,int[] postorder,int left,int right){
        if( p < 0 || left>right ){
            return null;
        }
        int e = postorder[p--];
        //System.out.println(e);
        TreeNode root = new TreeNode(e);
        if(left == right) return root;
        int index = 0;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == e){
                index = i;
                break;
            }
        }
        //System.out.println(index);
        root.right = dg(inorder,postorder,index+ 1,right);
        root.left = dg(inorder,postorder,left,index-1);
        return root;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
