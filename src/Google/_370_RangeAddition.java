package Google;

/**
 * Created by Shengwei_Wang on 10/25/16.
 */
public class _370_RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] f = new int[length];
        for (int i = 0; i < updates.length; ++i) {
            f[updates[i][0]] += updates[i][2];
            if (updates[i][1] < length - 1)
                f[updates[i][1] + 1] -= updates[i][2];
        }
        for (int i = 1; i < length; ++i) {
            f[i] += f[i - 1];
        }
        return f;
    }
}
