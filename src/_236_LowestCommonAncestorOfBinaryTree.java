/**
 * Created by Shengwei_Wang on 9/1/16.
 */
public class _236_LowestCommonAncestorOfBinaryTree {
    TreeNode ans;
    boolean foundp;
    boolean foundq;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        foundp = false;
        foundq = false;
        ans = root;
        dfs(root, p, q);
        return ans;
    }
    public void dfs(TreeNode root,TreeNode p, TreeNode q){
        if (root == null)
            return;
        if (foundp && foundq)
            return;
        if(foundp || foundq) {
            if(root == p)
                foundp = true;
            else if (root == q)
                foundq = true;
            else {
                dfs(root.left, p, q);
                dfs(root.right, p, q);
            }
        } else {
            if(root == p){
                foundp = true;
                ans = root;
            } else if (root == q){
                foundq = true;
                ans = root;
            }
            dfs(root.left, p, q);
            if(foundp && foundq)
                return;
            else {
                if(foundp || foundq){
                    ans = root;
                }
                dfs(root.right, p, q);
            }
        }

    }
}
