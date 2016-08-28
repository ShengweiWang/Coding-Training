import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _241_DifferentWayToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
//        System.out.println(input);
        List<Integer> ans = new ArrayList<Integer>();
        boolean flag = false;
        List<Integer> lList;
        List<Integer> rList;
        for(int i = 0; i < input.length(); ++i){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                flag = true;
                lList = diffWaysToCompute(input.substring(0, i));
                rList = diffWaysToCompute(input.substring(i + 1, input.length()));
                for(int lOperand : lList)
                    for(int rOperand: rList){
                        if(input.charAt(i) == '+' )
                            ans.add(lOperand + rOperand);
                        else if(input.charAt(i) == '-' )
                            ans.add(lOperand - rOperand);
                        else if(input.charAt(i) == '*' )
                            ans.add(lOperand * rOperand);
                    }
            }
        }
        if (!flag){
//            System.out.println(Integer.parseInt(input));
            ans.add(Integer.parseInt(input));
        }
//        System.out.println("begin");
//        System.out.println(input);
//        for(int i : ans)
//            System.out.println(i);
//        System.out.println("finished");
        return ans;
    }
}
