import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _68_TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int startIndex = 0;
        int curl = 0;
        int count = 0;
        for(int i = 0; i < words.length; ++i){
            if(i < words.length && curl + words[i].length() + count <= maxWidth) {
                curl += words[i].length();
                ++count;
            } else {
                StringBuilder sb = new StringBuilder();
                int extra = 0;
                StringBuilder space = new StringBuilder();
                if(count > 1) {
                    extra = (maxWidth - curl) % (count - 1);

                    int spaces = (maxWidth - curl) / (count - 1);
                    while (spaces > 0) {
                        space.append(" ");
                        --spaces;
                    }
                } else {
                    int spaces = (maxWidth - curl);
                    while (spaces > 0) {
                        space.append(" ");
                        --spaces;
                    }
                }
                for(int j = startIndex; j < i - 1; ++j){
                    sb.append(words[j]);
                    if(extra > 0){
                        --extra;
                        sb.append(" ");
                    }
                    sb.append(space.toString());
                }
                sb.append(words[i - 1]);
                if(startIndex == i - 1){
                    sb.append(space.toString());
                }
                res.add(sb.toString());
                startIndex = i;
                curl = words[i].length();
                count = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int k = startIndex; k < words.length - 1; ++k){
            sb.append(words[k]);
            sb.append(" ");
        }
        sb.append(words[words.length - 1]);
        int spaces = maxWidth - curl - count + 1;
        while(spaces > 0){
            sb.append(" ");
            --spaces;
        }
        res.add(sb.toString());

        return res;
    }
}
