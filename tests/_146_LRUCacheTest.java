import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _146_LRUCacheTest {

    @Test
    public void testSet() throws Exception {
        _146_LRUCache s = new _146_LRUCache(1);
        s.set(2,1);
        s.get(2);
        s.set(3,2);
        s.get(2);
        s.get(3);
    }
}