import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _30_SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int[] times = new int[words.length];
        int[] num = new int[s.length()];
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < words.length; ++i){
            int index = hashMap.getOrDefault(words[i], -1);
            if (index == -1) {
                hashMap.put(words[i], i);
                times[i] = 1;
            }
            else {
                ++times[index];
            }
        }
        int maxIndex = s.length() - words.length * words[0].length() + 1;
        for(int i = 0; i < s.length() - words[0].length() + 1; ++i){
            num[i] = hashMap.getOrDefault(s.substring(i, i + words[0].length()), -1);
        }
//        for(String key : hashMap.keySet()){
//            System.out.println(key);
//        }
//        for(int i = 0; i < s.length(); ++i)
//            System.out.println(num[i]);

        for(int i = 0; i < maxIndex; ++i){

            int[] cur = times.clone();

            boolean t = true;
            for(int j = 0; j < words.length; ++j){
                if(num[i + j * words[0].length()] == -1 || cur[num[i + j * words[0].length()]] <= 0){
                    t = false;
                    break;
                } else{
                    --cur[num[i + j * words[0].length()]];
                }
            }
            if(t){
                ans.add(i);
            }
        }
        return ans;
    }
}
