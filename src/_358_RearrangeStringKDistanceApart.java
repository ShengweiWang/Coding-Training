import java.util.Arrays;

/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _358_RearrangeStringKDistanceApart {
    public String rearrangeString(String str, int k) {
        int[] bucket = new int[26];
        for(int i = 0; i < str.length(); ++i)
            ++bucket[str.charAt(i) - 'a'];

        int[] index = new int[26];
        Arrays.fill(index, -k);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); ++i){
            int max = 0;
            int cur = -1;
            for(int j = 0; j < 26; ++j){
                if(bucket[j] > max && i - index[j] >= k) {
                    max = bucket[j];
                    cur = j;
                }
            }
            if(cur == -1)
                return "";
            sb.append((char) ('a' + cur));
            --bucket[cur];
            index[cur] = i;
        }
        return sb.toString();
    }
}
