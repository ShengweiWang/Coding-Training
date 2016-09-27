/**
 * Created by Shengwei_Wang on 9/24/16.
 */
public class BinarySearchTree {
    public static void main(String[] args){
        int[] a = {1,2,3,42,3,4,2,3,5,6,7,9};
        BinarySearchTree solution = new BinarySearchTree();
    }

    TreeNode root;
    public BinarySearchTree(){
        root = null;
    }

    public boolean insert(int val) {
        if (root == null) {
            root = new TreeNode(val);
            return true;
        }
        TreeNode cur = root;
        while (cur.val != val) {
            if (cur.val > val) {
                if (cur.left != null)
                    cur = cur.left;
                else {
                    cur.left = new TreeNode(val);
                    return true;
                }
            } else if (cur.val < val) {
                if (cur.right != null)
                    cur = cur.right;
                else {
                    cur.right = new TreeNode(val);
                    return true;
                }
            }
        }
        return false;
    }

    public TreeNode search(int val){
        TreeNode cur = root;
        while(cur != null){
            if(cur.val == val)
                return cur;
            else if(cur.val > val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        return cur;
    }
    public boolean delete(int val){

        TreeNode pre = null;
        TreeNode cur = root;
        while(cur != null){
            if(cur.val == val){
                if(cur.left == null || cur.right == null){
                    TreeNode temp = null;
                    if(cur.left == null)
                        temp = cur.right;
                    else
                        temp = cur.left;
                    if(pre == null)
                        root = temp;
                    else {
                        if(pre.val > val)
                            pre.left = temp;
                        else
                            pre.right = temp;
                    }
                    return true;
                } else {
                    pre = cur;
                    TreeNode temp = cur.left;
                    while(temp.right!=null){
                        pre = temp;
                        temp = temp.right;
                    }
                    cur.val = temp.val;
                    temp.val = val;
                    cur = temp;
                    continue;
                }
            } else if (cur.val > val) {
                pre = cur;
                cur = cur.left;
            } else {
                pre = cur;
                cur = cur.right;
            }
        }
        return false;
    }
}
