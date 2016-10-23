package Google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 10/23/16.
 */
public class CodingSample {
    public int solution(String S) {
        // write your code in Java SE 8
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> imageExtension = new HashSet<>();
        imageExtension.add("gif");
        imageExtension.add("jpeg");
        imageExtension.add("png");
        int curLen = 0;
        int maxLen = 0;

        String[] dirs = S.split("\n");
        for (String name : dirs) {
            int space = 0;
            while (name.charAt(space) == ' ' && space < name.length())
                ++space;
            while (stack.size() > space) {
                curLen -= stack.pop();
            }
            int k = name.indexOf('.');

            if ( k < 0 ) {
                curLen += name.length() - space + 1;
                stack.push(name.length() - space + 1);
            } else {
                if (imageExtension.contains(name.substring(k + 1))) {
                    maxLen = Math.max(maxLen, curLen);
                }
            }
        }
        return maxLen;
    }
}
