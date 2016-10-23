package twopointer;

import java.util.*;

/**
 * Created by Shengwei_Wang on 9/29/16.
 */
public class _15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int target = 0;
        List<List<Integer>> ans = new LinkedList<>();
        for(int i = 0; i < nums.length - 2; ++i){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            if(nums[i] * 3 > target)
                break;
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                if(nums[i] + nums[l] + nums[r] == target){
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1])
                        ++l;
                    while(l < r && nums[r] == nums[r - 1])
                        --r;
                    ++l;
                    --r;
                } else {
                    if(nums[i] + nums[l] + nums[r] > target)
                        --r;
                    else
                        ++l;
                }
            }
        }
        return ans;
    }
//    List<List<Integer>> ans;
//    public List<List<Integer>> threeSum(int[] nums) {
//        Arrays.sort(nums);
//        ans = new LinkedList<>();
//        int target = 0;
//        int max = nums[nums.length - 1];
//        for(int i = 0; i < nums.length; ++i){
//            if(nums[i] * 3 > target)
//                break;
//            if(nums[i] + max * 2 < target)
//                continue;
//            twoSum(nums, i, target);
//        }
//        return ans;
//    }
//    void twoSum(int[] nums, int k, int target){
//        target = target - nums[k];
//
//        Set<Integer> set = new HashSet<>();
//        Set<Integer> aset = new HashSet<>();
//        for(int i = k + 1; i < nums.length; ++i){
//            if(aset.contains(nums[i]))
//                continue;
//            if(set.contains(target - nums[i])){
//                List<Integer> tempList = new LinkedList<>();
//                tempList.add(nums[k]);
//                tempList.add(nums[i]);
//                tempList.add(target - nums[i]);
//                aset.add(nums[i]);
//            }
//            set.add(nums[i]);
//        }
//    }
}
