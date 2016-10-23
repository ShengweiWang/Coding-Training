package Google;

import java.util.List;

/**
 * Created by Shengwei_Wang on 10/23/16.
 */
public class _422_ValidWordSquare {
    public boolean validWordSquare(List<String> words) {
        if (words.size() == 0)
            return true;
        for (int i = 1; i < words.size(); ++i) {
            for (int j = 0; j < words.get(i).length(); ++j) {
                try {
                    if (words.get(i).charAt(j) != words.get(j).charAt(i))
                        return false;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }
}
