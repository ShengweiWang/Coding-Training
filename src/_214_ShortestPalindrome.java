/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _214_ShortestPalindrome {
    public String shortestPalindrome(String s) {
        String right = "";
        String mid = "";
        boolean f = false;
        for(int i = (s.length() >> 1); i >= 0; --i){

            if (i + i + 1 <= s.length()) {
                f = true;
                for (int j = 0; j < i; ++j) {
                    if (s.charAt((j)) != s.charAt(i + 1 + i - j - 1)) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    right = s.substring(i + 1, s.length());
                    mid = s.substring(i, i + 1);
                    break;
                }
            }


            f = true;
            for(int j = 0; j < i; ++j){
                if(s.charAt((j)) != s.charAt(i + i - j - 1)) {
                    f = false;
                    break;
                }
            }
            if(f) {
                right = s.substring(i, s.length());
                mid = "";
                break;
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = right.length() - 1; i >=0 ; --i)
            sb.append(right.charAt(i));
        sb.append(mid);
        sb.append(right);
//        System.out.println(sb.toString());
        return sb.toString();
    }
}
