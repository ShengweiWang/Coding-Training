import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/21/16.
 */
public class _338_CountingBitsTest {

    @Test
    public void testCountBits() throws Exception {

        _338_CountingBits s = new _338_CountingBits();

        int[] test1 = {0,1,1,2,1,2};
        int[] ans = s.countBits(2);
        for ( int i = 0 ; i < 2; ++i)
            System.out.println(ans[i]);

//        for (int i = 0; i < 5; ++i)
//            assert (ans[i] == test1[i]);
    }

}