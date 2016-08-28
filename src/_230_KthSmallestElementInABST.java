/**
 * Created by Shengwei_Wang on 8/25/16.
 */
public class _230_KthSmallestElementInABST {
    int gk;
    int count;
    boolean found;
    int ans;
    public int kthSmallest(TreeNode root, int k) {
        gk = k;
        found = false;
        count = 0;
        inOrder(root);
        return ans;
    }
    public void inOrder(TreeNode root){
        if(found||root == null)
            return;
        inOrder(root.left);
        ++count;
        if(count == gk){
            ans = root.val;
            found = true;
            return;
        }
        inOrder(root.right);
    }
}
