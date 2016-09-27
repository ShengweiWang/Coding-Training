import java.util.Arrays;

/**
 * Created by Shengwei_Wang on 9/24/16.
 */
public class StringMatch {
    public boolean kmp(String s, String t){ //s is the substring of t;
        int[] next = new int[s.length()];
        int j = 0;
        for(int i = 1; i < s.length(); ++i){
            while(j > 0 && s.charAt(i) != s.charAt(j))
                j = next[j-1];
            if(s.charAt(i) == s.charAt(j))
                ++j;
            next[i] = j;
        }
        for(int i = 0; i < s.length(); ++i)
            System.out.println(next[i]);

        int i = 0;
        j = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                ++i;
                ++j;
            } else if (i == 0){
                ++j;
            } else
                i = next[i-1];
        }
        return i == s.length();

    }


    public boolean bm (String s, String t) {
        int[] bc = new int[256];
        int[] gs = new int[s.length()];
        return false;

    }
    void generateBc(int[] bc, String s){
        Arrays.fill(bc, s.length());
        for(int i = 0; i < s.length(); ++i)
            bc[s.charAt(i)] = s.length() - i - 1;
    }
    void generateGs(int[] gs, String s){
//        int[]
//        for(int i = s.length() - 2; i >= 0; ++i){
//            int cur = i;
//            int j = s.length() - 1;
//            while(cur >= 0 && s.charAt(cur) == s.charAt(s.length() - 1 - i + cur))
//                --cur;
//            gs[i] = i - cur;
//        }
    }

}
