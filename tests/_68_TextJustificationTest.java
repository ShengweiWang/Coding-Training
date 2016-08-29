import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _68_TextJustificationTest {

    @Test
    public void testFullJustify() throws Exception {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = (new _68_TextJustification()).fullJustify(words, 10);
        for(String s : res){
            System.out.println(s);
        }
    }
}