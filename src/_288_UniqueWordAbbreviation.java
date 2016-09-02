import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _288_UniqueWordAbbreviation {
    Map<String, Integer> set;
    String[] dictionary;
    public _288_UniqueWordAbbreviation(String[] dictionary) {
        this.dictionary = dictionary;
        set = new HashMap<String, Integer>();
        for(int i = 0; i < dictionary.length; ++i){
            String abv = "";
            if(dictionary[i].length() < 3)
                abv = dictionary[i];
            else {
                abv += dictionary[i].charAt(0);
                abv += Integer.toString(dictionary[i].length() - 2);
                abv += dictionary[i].charAt(dictionary[i].length() - 1);
            }
            if(!set.containsKey(abv))
                set.put(abv, i);
            else{
                if(set.get(abv) != -1){
                    if(dictionary[set.get(abv)].compareTo(dictionary[i]) == 0)
                        continue;
                    else
                        set.put(abv, -1);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String abv = "";
        if(word.length() < 3)
            abv = word;
        else {
            abv += word.charAt(0);
            abv += Integer.toString(word.length() - 2);
            abv += word.charAt(word.length() - 1);
        }
        int k = set.getOrDefault(abv, -2);
        if(k == -2)
            return true;
        if(k == -1)
            return false;
        if(word.compareTo(dictionary[k]) != 0)
            return false;
        else
            return true;
    }
}
