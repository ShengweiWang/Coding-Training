import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/29/16.
 */
public class _321_CreateMaximumNumberTest {

    @Test
    public void testMaxNumber() throws Exception {
        _321_CreateMaximumNumber so = new _321_CreateMaximumNumber();
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        so.maxNumber(nums1,nums2,5);
    }
}