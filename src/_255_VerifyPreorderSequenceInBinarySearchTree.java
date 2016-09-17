/**
 * Created by Shengwei_Wang on 9/13/16.
 */
public class _255_VerifyPreorderSequenceInBinarySearchTree {
    int[] preorder;
    public boolean verifyPreorder(int[] preorder) {
        this.preorder = preorder;
        return dfs(0, preorder.length);
    }
    public boolean dfs(int l, int r){
        if(l + 2 >= r)
            return true;
        boolean f = false;
        int div = 0;
        for(int i = l + 1; i < r; ++i) {
            if(preorder[i] > preorder[l] && !f){
                div = i;
                f = true;
            }
            else if(preorder[i] < preorder[l] && f)
                return false;
        }
        if(div == 0){
            if(dfs(l + 1, r))
                return true;
            else
                return false;
        }
        if(dfs(l + 1, div) && dfs(div, r))
            return true;
        else
            return false;
    }
}
