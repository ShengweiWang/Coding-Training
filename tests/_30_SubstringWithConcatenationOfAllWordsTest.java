import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _30_SubstringWithConcatenationOfAllWordsTest {

    @Test
    public void testFindSubstring() throws Exception {

        String[] words = {"word","good","best","good"};
        _30_SubstringWithConcatenationOfAllWords s = new _30_SubstringWithConcatenationOfAllWords();
        List<Integer> ls = s.findSubstring("wordgoodgoodgoodbestword", words);
        for(Integer i : ls)
            System.out.println(i);
    }
}