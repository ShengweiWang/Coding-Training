package oa.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 12/16/16.
 */
public class WindowSum {
    public static List<Integer> windowSum(int[] array, int k) {
        if (array == null || array.length == 0)
            return new ArrayList<>();
        if (k > array.length)
            return null;
        ArrayList<Integer> ans = new ArrayList<>();
        int accumulator = 0;
        for (int i = 0; i < k - 1; ++i)
            accumulator += array[i];
        for (int i = k - 1; i < array.length; ++i) {
            accumulator += array[i];
            ans.add(accumulator);
            accumulator -= array[i - k + 1];
        }
        return ans;
    }
}
