/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _278_FirstBadVersion {
    public boolean isBadVersion(int n){
        return false;
    }
    public int firstBadVersion(int n) {
        int l = 0;
        int r = n;
        while(l < r){
            int mid = l + ((r - l) >> 1);
            if(isBadVersion(mid))
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
