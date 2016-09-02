import java.util.Stack;

/**
 * Created by Shengwei_Wang on 9/1/16.
 */
public class _388_LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        int maxLength = 0;
        int cur = 0;
        int cCount = 0;
        int levelCount = 0;
        int index = 0;
        boolean isFile = false;
        Stack<Integer> stack = new Stack<>();
        while(index < input.length()){
            isFile = false;
            cCount = 0;
            levelCount = 0;
            while(input.charAt(index) == '\t'){
                ++levelCount;
                ++index;
            }
            while(levelCount < stack.size()){
                cur -= stack.peek();
                stack.pop();
            }
            while(index < input.length() && input.charAt(index) != '\n'){
                ++cCount;
                if(input.charAt(index) == '.')
                    isFile = true;
                ++index;
            }
            if(isFile){
                if(cur + cCount > maxLength)
                    maxLength = cur + cCount;
            } else {
                ++cCount;
                stack.push(cCount);
                cur += cCount;
            }
            ++index;
        }
        return maxLength;
    }
}
