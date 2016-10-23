package twopointer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/29/16.
 */
public class _18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0; i < nums.length - 3; ++i){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            if(nums[i] * 4 > target)
                break;
            for(int j = i + 1; j < nums.length - 2; ++j){
                if(j > i + 1 && nums[j] == nums[j-1])
                    continue;
                if(nums[i] + nums[j] * 3 > target)
                    break;
                int l = j + 1;
                int r = nums.length - 1;
                while(l < r){
                    if(nums[i] + nums[j] + nums[l] + nums[r] == target){
                        ans.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while(l < r && nums[l] == nums[l + 1])
                            ++l;
                        while(l < r && nums[r] == nums[r - 1])
                            --r;
                        ++l;
                        --r;
                    } else {
                        if(nums[i] + nums[j] + nums[l] + nums[r] > target)
                            --r;
                        else
                            ++l;
                    }
                }
            }
        }
        return ans;
    }
}
