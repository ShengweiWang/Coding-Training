/**
 * Created by Shengwei_Wang on 8/6/16.
 */
public class _344_ReverseString {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0 ; --i )
            sb.append(s.charAt(i));
        return sb.toString();
    }
}
