/**
 * Created by Shengwei_Wang on 8/31/16.
 */
public class _331_VerifyPreorderSerializationOfaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        boolean leaf = false;
        int leafn = 0;
        int numn = 0;
        for(int i = preorder.length() - 1; i>=0; --i){
            if(preorder.charAt(i) == '#')
                leaf = true;
            else if(preorder.charAt(i) == ','){
                if(leaf)
                    ++leafn;
                else
                    ++numn;
                if(leafn <= numn)
                    return false;
                leaf = false;
            }
        }
        if(leaf)
            ++leafn;
        else
            ++numn;
        if(leafn - numn != 1)
            return false;
        return true;
    }
}
