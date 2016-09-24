/**
 * Created by Shengwei_Wang on 9/19/16.
 */
public class _72_EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] f = new int[word1.length() + 1][word2.length() + 1];
        for(int j = 0; j <= word2.length(); ++j)
            f[0][j] = j;
        for(int i = 1; i <= word1.length(); ++i){
            f[i][0] = i;
            for(int j = 1; j <= word2.length(); ++j){

                if(word1.charAt(i-1) == word2.charAt(j-1))
                    f[i][j] = f[i-1][j-1];
                else
                    f[i][j] = Math.min(f[i-1][j], Math.min(f[i][j-1],f[i-1][j-1])) + 1;
            }
        }
        return f[word1.length()][word2.length()];
    }
}
