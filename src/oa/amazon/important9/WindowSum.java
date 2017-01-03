package oa.amazon.important9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 1/1/17.
 */
public class WindowSum {
    public static List<Integer> windowSum(int[] array, int k) {

        if (array == null || array.length == 0)
            return new ArrayList<Integer>();
        if (k < 1 || k > array.length)
            return null;
        int sum = 0;
        List<Integer> ans = new LinkedList<Integer>();
        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
            if (i + 1 >= k) {
                ans.add(sum);
                sum -= array[i - k];
            }
        }
        return ans;
    }
}
