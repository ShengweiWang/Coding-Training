import java.util.*;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _347_TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        //get frequency
        for(int i = 0; i < nums.length; ++i){
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else
                map.put(nums[i],1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<Integer>();
            }
            bucket[freq].add(key);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0 && res.size() < k; --i){
            if(bucket[i] != null){
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
