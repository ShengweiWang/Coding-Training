import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _354_RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0)
            return 0;
        Integer[] index = new Integer[envelopes.length];
        for(int i = 0; i < index.length; ++i)
            index[i] = i;
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (envelopes[o1][0] == envelopes[o2][0])
                    return Integer.compare(envelopes[o2][1], envelopes[o1][1]);
                else
                    return Integer.compare(envelopes[o1][0], envelopes[o2][0]);
            }
        });
        int[] len = new int[envelopes.length];
        int size = 1;
        len[0] = envelopes[index[0]][1];
        for(int i = 1; i < index.length; ++i){
            int cur = envelopes[index[i]][1];
            int l = 0;
            int r = size - 1;
            while(l < r){
                int mid = l + (r - l)/2;
                if(len[mid] >= cur)
                    r = mid;
                else
                    l = mid + 1;
            }
            if(r == size - 1 && len[r] < cur) {
                len[size] = cur;
                ++size;
            } else {
                len[r] = cur;
            }
        }
        return size;
    }
}
