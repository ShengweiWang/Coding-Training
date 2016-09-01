import java.util.HashMap;

/**
 * Created by Shengwei_Wang on 8/29/16.
 */
public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        String ans = s + t;
        for(int i = 0 ; i < t.length(); ++i){
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0) - 1);
        }
//        for(char c : hashMap.keySet()){
//            System.out.println(c);
//            System.out.println(hashMap.get(c));
//        }
        int start = -1;
        int count = 0;
        for(int i = 0; i < s.length(); ++i) {

            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
                if (hashMap.get(s.charAt(i)) <= 0)
                    ++count;
                if (start == -1)
                    start = i;
                else {
                    while (hashMap.getOrDefault(s.charAt(start), 1) > 0 && start < i) {
                        if(hashMap.containsKey(s.charAt(start)))
                            hashMap.put(s.charAt(start), hashMap.get(s.charAt(start)) - 1);
                        ++start;
                    }
                }
                if (count == t.length() && i - start < ans.length())
                    ans = s.substring(start, i + 1);
            }
//            System.out.println(start);
        }
        if(ans.length() > s.length())
            ans = "";
        return ans;
    }
}
