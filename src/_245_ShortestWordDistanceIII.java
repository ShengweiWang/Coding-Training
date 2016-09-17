/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _245_ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int last1 = -1;
        int last2 = -1;
        int ans = Integer.MAX_VALUE;
        boolean flag = (word1.compareTo(word2) == 0);
        for(int i = 0; i < words.length; ++i){
            if(words[i].compareTo(word1) == 0){
                if(flag){
                    if(last1 != -1){
                        ans = Math.min(i - last1, ans);
                    }
                    last1 = i;
                } else{
                    last1 = i;
                    if(last1 != -1 && last2 != -1){
                        ans = Math.min(last1 - last2, ans);
                    }
                }
            } else if(words[i].compareTo(word2) == 0){
                last2 = i;
                if(last1 != -1 && last2 != -1){
                    ans = Math.min(last2 - last1, ans);
                }
            }
        }
        return ans;
    }
}
