import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/6/16.
 */
public class _344_ReverseStringTest {

    @Test
    public void testReverseString() throws Exception {

        String s = new String("wowoies");
        assertEquals(s, "wowoies");
        String s_reversed = (new _344_ReverseString()).reverseString(s);
        assertEquals(s_reversed, "seiowow");
    }
}