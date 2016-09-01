import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/29/16.
 */
public class _76_MinimumWindowSubstringTest {

    @Test
    public void testMinWindow() throws Exception {
        _76_MinimumWindowSubstring solu = new _76_MinimumWindowSubstring();
        String s = solu.minWindow("ADOBECODEBANC", "ABCC");
        System.out.println(s);
    }
}