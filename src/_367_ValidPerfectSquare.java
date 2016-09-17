/**
 * Created by Shengwei_Wang on 9/12/16.
 */
public class _367_ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1)
            return true;
        int l = 1;
        int h = num;
        while(l<h){
            int mid = l + (h - l)/2;
            long sq = (long)mid * (long)mid;
            if(sq == num){
                return true;
            } else if (sq < num){
                l = mid + 1;
            } else
                h = mid;
        }
        long sq = (long)l * (long) l;
        if(sq == num)
            return true;
        else
            return false;

    }
}
