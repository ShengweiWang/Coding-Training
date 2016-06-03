import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 6/3/16.
 */
public class _1_TwoSumTest {

    @Test
    public void testTwoSum() throws Exception {
        int[] nums = {3,2,4};
        int target = 6;
        _1_TwoSum a = new _1_TwoSum();
        int[] res = a.twoSum(nums, target);
        assert 1 == res[0];
        assert 2 == res[1];
    }
}