import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _17_LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty())
            return Collections.emptyList();

        char[] lo = {'0', '1', 'a', 'd', 'g', 'j', 'm', 'p', 't', 'w'};
        char[] hi = {'0', '1', 'c', 'f', 'i', 'l', 'o', 's', 'v', 'z'};

        ArrayList<String> list = new ArrayList<>();
        list.add("");
        for(int i = 0; i < digits.length(); ++i){
            int cur = digits.charAt(i) - '0';
            ArrayList<String> temp = new ArrayList<>();
            for(char c = lo[cur] ; c <= hi[cur]; ++c){
                for(String s : list){
                    temp.add(s + c);
                }
            }
            list = temp;
        }

        return list;
    }
}
