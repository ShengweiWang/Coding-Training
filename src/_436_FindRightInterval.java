import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Shengwei_Wang on 11/5/16.
 */
public class _436_FindRightInterval {
    public int[] findRightInterval(Interval[] intervals) {
        int n = intervals.length;
        int [] res = new int[n];
        int [][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i][0] = intervals[i].start;
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int k = 0; k < n; ++k) {
            int x = intervals[k].end;
            int l = 0;
            int r = n - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid][0] >= x)
                    r = mid;
                else
                    l = mid + 1;
            }
            if (arr[l][0] >= x)
                res[k] = arr[l][1];
            else
                res[k] = -1;
        }
        return res;
    }
}
