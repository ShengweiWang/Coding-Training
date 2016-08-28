/**
 * Created by Shengwei_Wang on 8/25/16.
 */
public class _318_MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        int[] hash = new int[words.length];
        for(int i = 0; i < hash.length; ++i){
            int hashf = 0;
            for(int j = 0; j < words[i].length(); ++j){
                hashf |= (1<<(words[i].charAt(j) - 'a'));
            }
            hash[i] = hashf;
        }
        int max = 0;
        for(int i = 0; i < words.length; ++i)
            for(int j = 0; j < words.length; ++j)
                if((hash[i] & hash[j]) == 0){
                    int temp = words[i].length() * words[j].length();
                    if(temp > max)
                        max = temp;
                }
        return max;
    }
}
