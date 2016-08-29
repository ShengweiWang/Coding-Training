import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _140_WordBreakIITest {

    @Test
    public void testWordBreak() throws Exception {
        _140_WordBreakII st = new _140_WordBreakII();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Set<String> word = new HashSet<>();
        word.add("a");
        word.add("aa");
        word.add("aaa");
        word.add("aaaa");
        word.add("aaaaa");
        List<String> ans = st.wordBreak(s, word);
        for(String temp:ans)
            System.out.println(temp);
    }
}