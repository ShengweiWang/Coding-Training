/**
 * Created by Shengwei_Wang on 9/22/16.
 */
public class _151_ReverseWordsInAString {
    public String reverseWords(String s) {
        int l = 0;
        StringBuilder sb = new StringBuilder();
        char[] ss = s.toCharArray();
        while(l < ss.length && ss[l] == ' ')
            ++l;
        while(l < ss.length){
            StringBuilder temp = new StringBuilder();
            while(l < ss.length && ss[l] != ' '){
                temp.append(ss[l]);
                ++l;
            }
            temp.append(' ');
            sb.insert(0, temp);
            while(l < ss.length && ss[l] == ' ')
                ++l;
        }

        if(sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
