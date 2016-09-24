import java.util.*;

/**
 * Created by Shengwei_Wang on 9/19/16.
 */
public class _381_InsertDeleteGetRandom {
    Map<Integer, Stack<Integer>> map;
    List<Integer> list;
    Random r;
    /** Initialize your data structure here. */
    public _381_InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int cur = list.size();
        list.add(cur, val);
        if(!map.containsKey(val)){
            map.put(val, new Stack<Integer>());
            map.get(val).push(cur);
            return true;
        } else {
            map.get(val).push(cur);
            return false;
        }

    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        int last = list.get(list.size()-1);
        if(last == val){
            list.remove(list.size()-1);
            map.get(val).pop();
            return true;
        } else {
            int index = map.get(val).pop();
            list.add(index, last);
            map.get(last).pop();
            map.get(last).push(index);
            return true;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}
