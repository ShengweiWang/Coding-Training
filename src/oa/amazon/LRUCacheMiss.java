package oa.amazon;

import java.util.LinkedList;

/**
 * Created by Shengwei_Wang on 12/29/16.
 */
public class LRUCacheMiss {
    public static int countMiss(int[] arr, int size) {
        if (arr == null || arr.length == 0)
            return 0;
        if (size < 1)
            return arr.length;
        LinkedList<Integer> cache = new LinkedList<>();
        int miss = 0;
        for (int x : arr) {
            if (cache.contains(x))
                cache.remove(x);
            else
                ++miss;
            cache.addFirst(x);
            if (cache.size() > size)
                cache.removeLast();
        }
        return miss;
    }
}
