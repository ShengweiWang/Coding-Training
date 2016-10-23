package Google;

import java.util.Set;

/**
 * Created by Shengwei_Wang on 10/16/16.
 */
public class _139_WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        int i = 0;
        while(s.length() > 0){
            if (f[i]) {
                for (String sub : wordDict) {
                    if (s.startsWith(sub)) {
                        f[i + sub.length()] = true;
                    }
                }
            }
            s = s.substring(1);
            ++i;
        }
        return f[n];
    }
}
