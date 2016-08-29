import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _44_WildcardMatchingTest {

    @Test
    public void testIsMatch() throws Exception {
        String s1 = "22";
        String s2 = s1.substring(2);
        System.out.println((new _44_WildcardMatching()).isMatch("adkljslkadfjka",
                "a*****b"));
    }
}