import java.text.StringCharacterIterator;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _383_RansomNode {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[255];
        for(int i = 0; i < magazine.length(); ++i) {
            ++count[(int)magazine.charAt(i)];
        }
        for(int i = 0; i < ransomNote.length(); ++i){
            if(--count[(int)ransomNote.charAt(i)] < 0)
                return false;
        }
        return true;
    }
}
