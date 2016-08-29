/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        if(s.length() == 0){
            for(int i = 0; i < p.length(); ++i){
                if(p.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        int ppoint = 0;
        for(int i = 0; i < s.length(); ++i){
            if(i == p.length())
                return false;
            if(s.charAt(i) == p.charAt(ppoint) || p.charAt(ppoint) == '?'){
                ++ppoint;
                continue;
            }

            if(p.charAt(ppoint) == '*'){
//                System.out.println(s);
//                System.out.println(p);
                while(ppoint != p.length() && p.charAt(ppoint) == '*')
                    ++ppoint;
                for(int j = i; j <= s.length(); ++j){
                    if (isMatch(s.substring(j), p.substring(ppoint)))
                        return true;
                }
                return false;
            }
            return false;
        }

        while(ppoint != p.length()){
            if(p.charAt(ppoint) != '*')
                return false;
            ++ppoint;
        }
        return true;
    }
}
