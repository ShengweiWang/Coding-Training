package Google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shengwei_Wang on 10/14/16.
 */
public class _388_LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int curLen = 0;
        int maxLen = 0;
        int layer = 0;
        boolean isFile = false;
        char c;
        Deque<Integer> deque = new ArrayDeque<>();
        int dequeLen = 0;
        for(int i = 0; i <= input.length(); ++i){
            if(i == input.length())
                c = '\n';
            else
                c = input.charAt(i);
            if (c == '\t')
                ++layer;
            else if (c == '\n'){
                deque.push(curLen);
                dequeLen += curLen;
                curLen = 0;
                if(isFile)
                    maxLen = Math.max(maxLen, dequeLen + layer);
                layer = 0;
                isFile = false;
            } else {
                if (curLen == 0) {
                    while (deque.size() > layer) {
                        dequeLen -= deque.pop();
                    }
                }
                if (c == '.')
                    isFile = true;
                ++curLen;
            }
        }
        return maxLen;
    }

    public static void main(String[] argv){
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        int ans =new _388_LongestAbsoluteFilePath().lengthLongestPath(s);
        System.out.println(s.length());
        System.out.print(ans);

    }
}
