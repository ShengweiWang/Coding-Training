import java.util.Set;

/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _139_WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
        for(int i = 0; i < s.length(); ++i){
            if(!f[i])
                continue;
            String sub = s.substring(i);
            for(String dic : wordDict)
                if(sub.startsWith(dic))
                    f[i + dic.length()] = true;
        }
        return f[s.length()];
    }
}
