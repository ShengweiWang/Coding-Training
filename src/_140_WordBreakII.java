import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _140_WordBreakII {
//    String s;
//    int end;
//    List<String> ans;
//    Set<String> wordDict;
    public List<String> wordBreak(String s, Set<String> wordDict) {
//        this.s = s;
//        this.wordDict = wordDict;
//        end = s.length();
//        ans = new ArrayList<String>();
//        dfs(0,"");
        int max = 0;
        List<String>[] ans = new List[s.length() + 1];
        for(int i = 0; i < ans.length; ++i)
            ans[i] = new ArrayList<String>();
        ans[0].add("");
        for(int i = 0; i < s.length(); ++i){
            if(i > max)
                return ans[s.length()];
            if(ans[i].size() == 0)
                continue;
            for(String temp : wordDict){
                if(temp.length() + i > s.length())
                    continue;
                else {
                    if(temp.compareTo(s.substring(i, i + temp.length())) == 0){
                        for(String prev : ans[i]){
                            if(i + temp.length() > max)
                                max = i + temp.length();
                            if(prev.length() == 0)
                                ans[i + temp.length()].add(temp);
                            else
                                ans[i + temp.length()].add(prev + " " + temp);
                        }
                    }
                }
            }
        }
        return ans[s.length()];
    }



//    public void dfs(int start, String anss){
////        System.out.println(start);
//        if(start == end){
//            ans.add(anss.substring(0, anss.length() - 1));
//            return;
//        }
//        for(String temp : wordDict){
//            if(end - start < temp.length())
//                continue;
//            if(temp.compareTo(s.substring(start, start + temp.length()))==0){
//                dfs(start + temp.length(), anss + temp + " ");
//            }
//        }
//    }
}
