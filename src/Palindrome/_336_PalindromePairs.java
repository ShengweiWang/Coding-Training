package Palindrome;

import java.util.*;

/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _336_PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Set<String>> mapf = new HashMap<>();
        for(int i = 0; i < words.length; ++i){
            Set<String> set = new HashSet<String>();
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            if(judge(words[i]))
                set.add("");
            for(int j = words[i].length(); j > 0; --j){
                if(judge(words[i].substring(j, words[i].length()))){
                    set.add(sb.toString());
                }
                sb.deleteCharAt(0);
            }
            map.put(words[i], set);
        }
        for(int i = 0; i < words.length; ++i){
            Set<String> set = new HashSet<String>();
            StringBuilder sb = new StringBuilder(words[i]);
            sb.reverse();
            if(judge(words[i]))
                set.add("");
            for(int j = 0; j < words[i].length(); ++j){
                if(judge(words[i].substring(0, j))) {
                    set.add(sb.toString());
                }
                sb.deleteCharAt(sb.length() -1);
            }
            mapf.put(words[i], set);
        }
        for(int i = 0; i < words.length; ++i){
            Set<String> temp = map.get(words[i]);
            System.out.println(words[i]);
            for(String j : temp){
                System.out.print(j + "   ");
            }
            System.out.println('/');
            for(String j : mapf.get(words[i])){
                System.out.print(j + "   ");
            }
            System.out.println();
        }
        for(int i = 0; i < words.length; ++i)
            for(int j = i+1 ; j < words.length; ++j){
                if(map.get(words[i]).contains(words[j])){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
                if(mapf.get(words[i]).contains(words[j])){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(j);
                    temp.add(i);
                    ans.add(temp);
                }
            }
        return ans;
    }

    boolean judge(String s){
        int i = 0;
        int j = s.length() -1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            ++i;
            --j;
        }
        return true;
    }
}
