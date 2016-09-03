/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _243_ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int last1 = -1;
        int last2 = -1;
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; ++i){
            if(words[i].compareTo(word1) == 0){
                last1 = i;
                if(last1 != -1 && last2 != -1){
                    ans = Math.min(last1 - last2, ans);
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
