import org.junit.Test;

/**
 * Created by Shengwei_Wang on 9/24/16.
 */
public class stringMatchTest {

    @Test
    public void testMatch() throws Exception {
        StringMatch solution = new StringMatch();
        String s = "tititit";
        String t = "tititiotititit";
        System.out.println(solution.kmp(s, t));
    }
}