package linkedlist;

/**
 * Created by Shengwei_Wang on 9/28/16.
 */
public class _275_H_IndexII {
    public int hIndex(int[] citations) {
        if(citations.length == 0)
            return 0;
        int n = citations.length;
        int l = 0;
        int r = citations.length - 1;
        while(l < r){
            int mid = l + (r - l)/2;
            if (n - mid > citations[mid])
                l = mid + 1;
            else
                r = mid;
        }
        if(citations[l] < n - l)
            return n - l - 1;
        else
            return n - l;
    }
}
