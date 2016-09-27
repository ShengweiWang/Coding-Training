import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _146_LRUCacheTest {

    @Test
    public void testSet() throws Exception {
        _146_LRUCache s = new _146_LRUCache(3);
        s.set(1,1);

        s.set(2,2);
        s.print();
        s.set(3,3);
        s.print();
        s.set(4, 4);
        s.print();

        s.get(4);
        s.get(3);
        s.get(2);
        s.get(1);

        s.print();
        s.set(5, 5);

        s.print();

        s.get(1);
        s.get(2);
        s.get(3);


        s.print();
        s.get(4);
        s.get(5);
    }
}