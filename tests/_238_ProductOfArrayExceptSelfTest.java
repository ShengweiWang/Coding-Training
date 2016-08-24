import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _238_ProductOfArrayExceptSelfTest {

    @Test
    public void testProductExceptSelf() throws Exception {
        int[] test1 = {1,2,3,4};
        int[] ans = (new _238_ProductOfArrayExceptSelf()).productExceptSelf(test1);
        for(int i = 0; i < ans.length; ++i)
            System.out.println(ans[i]);
    }
}