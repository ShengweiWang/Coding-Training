/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return mirror(root.left, root.right);
    }
    public boolean mirror(TreeNode l, TreeNode r){
        if(l == null) {
            if(r == null)
                return true;
            else
                return false;
        } else if (r == null)
            return false;
        if(l.val != r.val)
            return false;
        if(!mirror(l.left, r.right))
            return false;
        if(!mirror(l.right, r.left))
            return false;
        return true;
    }
}
