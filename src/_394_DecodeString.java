import java.util.Stack;

/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _394_DecodeString {
    public String decodeString(String s) {
        Stack<Integer> sn = new Stack<>();
        Stack<String> ss = new Stack<>();
        int cur = 0;
        String curs = "";
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                if(cur == 0){
                    ss.push(curs);
                    curs = "";
                }
                cur = cur * 10 + c - '0';
            } else if (c == '['){
                sn.push(cur);
                cur = 0;
            } else if (c == ']') {
                String slast = ss.pop();
                int n = sn.pop();
                for(int k = 0; k < n; ++k){
                    slast += curs;
                }
                curs = slast;
            } else {
                curs = curs + c;
            }
        }

        return curs;
    }
}
