package Google;

/**
 * Created by Shengwei_Wang on 10/17/16.
 */
public class _280_WiggleSort {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i){
            if ((((i & 1) == 0) && (nums[i] > nums[i + 1]))
            || (((i & 1) == 1) && (nums[i] < nums[i + 1]))) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
}
