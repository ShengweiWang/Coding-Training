import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _249_GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> hashmap = new HashMap<>();
        for(int i = 0; i < strings.length; ++i){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < strings[i].length(); ++j){
                if(strings[i].charAt(j) - strings[i].charAt(0) >= 0)
                    sb.append(strings[i].charAt(j) - strings[i].charAt(0) + 'a');
                else
                    sb.append(strings[i].charAt(j) - strings[i].charAt(0) + 26 + 'a');
            }
            String temp = sb.toString();
            List<String> group = hashmap.getOrDefault(temp, new ArrayList<String>());
            group.add(strings[i]);
            if(group.size() == 1){
                hashmap.put(temp, group);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key: hashmap.keySet()){
            ans.add(hashmap.get(key));
        }
        return ans;
    }
}
