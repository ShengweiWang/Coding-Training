import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/22/16.
 */
public class _167_TwoSumII_InputArrayIsSortedTest {

    @Test
    public void testTwoSum() throws Exception {

        int[] test1 = {3, 24, 50, 79, 88, 150, 345};
        int test_target = 200;
        int[] ans = (new _167_TwoSumII_InputArrayIsSorted()).twoSum(test1, test_target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}