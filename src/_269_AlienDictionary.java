import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 9/19/16.
 */
public class _269_AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> st = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        for(int i = 0; i < words.length - 1; ++i){
            for(int k = 0; k < words[i].length(); ++k){
                char small = words[i].charAt(k);
                char large = words[i+1].charAt(k);
                if(small != large){
                    if(!st.containsKey(small)){
                        st.put(small, new HashSet<Character>());
                    }
                    st.get(small).add(large);
                    degree.put(small, degree.getOrDefault(small , 0));
                    degree.put(large, degree.getOrDefault(large , 0) + 1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder largesb = new StringBuilder();
        for(int i = 0; i < words.length; ++i)
            for(int k = 0; k < words[i].length(); ++k){
                if(!degree.containsKey(words[i].charAt(k)))
                    largesb.append(words[i].charAt(k));
            }
        char current = ' ';
        for(char c : degree.keySet()){
            if(degree.get(c) == 0){
                current = c;
                break;
            }
        }
        while(current != ' '){
            char next = ' ';
            for(char c : st.get(current)){
                int cur = degree.get(c) - 1;
                degree.put(c, cur);
                if(cur == 0)
                    current = c;
            }
            sb.append(next);
            st.remove(next);
            next = current;
        }
        sb.append(largesb);
        return sb.toString();
    }
}
