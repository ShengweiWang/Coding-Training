/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _226_PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        char[] A = new char[256];
        int count=0;
        for(int i=0; i<s.length(); i++){
            if(A[s.charAt(i)]>0)A[s.charAt(i)]--;
            else A[s.charAt(i)]++;
        }
        for(int i=0; i<256; i++){
            if(A[i]!=0)count++;
        }
        return count<=1;
    }
}
