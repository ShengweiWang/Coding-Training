import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/22/16.
 */
public class _260_SingleNumberIIITest {

    @Test
    public void testSingleNumber() throws Exception {
        int[] test1 = {-1,0};
        int[] ans = (new _260_SingleNumberIII()).singleNumber(test1);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}