package Divide_and_Conquer;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/12/16.
 */
public class _241_DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new LinkedList<>();
        boolean single = true;
        for(int i = 0; i < input.length(); ++i){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                single = false;
                List<Integer> leftList = diffWaysToCompute(input.substring(0, i));
                List<Integer> rightList = diffWaysToCompute(input.substring( i + 1, input.length()));
                for( int l : leftList){
                    for( int r : rightList){
                        if(c == '+')
                            ans.add(l + r);
                        if(c == '-')
                            ans.add(l - r);
                        if(c == '*')
                            ans.add(l * r);
                    }
                }
            }
        }
        if(single)
            ans.add(Integer.valueOf(input));
        return ans;
    }
}
