/**
 * Created by Shengwei_Wang on 11/8/16.
 */
public class _65_ValidNumber {
    public boolean isNumber(String s) {
        if(s == null)
            return false;
        s = s.trim();
        if(s.length() == 0)
            return false;
        char [] isNum = s.toCharArray();
        boolean isDot = false;
        boolean isDigit = false;
        boolean isE = false;
        for(int index = 0; index < isNum.length; index++){
            char ele = isNum[index];
            if(ele == '+' || ele == '-'){
                if(index != 0 && isNum[index - 1] != 'e')
                    return false;
                if(index == isNum.length - 1)
                    return false;
                continue;
            }

            if(ele == '.'){
                if(isE || isDot || isNum.length == 1)
                    return false;
                if(index == isNum.length - 1 && !isDigit)
                    return false;
                isDot = true;
                continue;
            }

            if(ele == 'e'){
                if(isE || !isDigit)
                    return false;
                if(index == isNum.length - 1)
                    return false;
                isE = true;
                continue;
            }

            if(ele - '0' > 9 || ele - '0' < 0)
                return false;
            else
                isDigit = true;

        }

        return true;
    }
}
