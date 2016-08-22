/**
 * Created by Shengwei_Wang on 8/21/16.
 */
public class _167_TwoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {0,0};
        int i = 0;
        while ( (i < (numbers.length - 1)) && numbers[i] <= target){
            int l = i + 1;
            int r = numbers.length - 1;
            int find_target = target - numbers[i];
            int mid;
            while (l < r){
//                System.out.println("----");
//                System.out.println(l);
//                System.out.println(r);
                mid = l + (r - l)/2;
//                System.out.println(mid);
                if (numbers[mid] >= find_target)
                    r = mid;
                else
                    l = mid + 1;
            }
            if (l != numbers.length && numbers[l] == find_target){
                ans[0] = i + 1;
                ans[1] = l + 1;
                return ans;
            }
            ++i;
//            System.out.println(i);
        }
        return ans;
    }
}
