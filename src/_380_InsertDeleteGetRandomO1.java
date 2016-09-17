import java.util.*;

/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _380_InsertDeleteGetRandomO1 {
    Map<Integer, Integer> index;
    List<Integer> value;
    Random r;
    /** Initialize your data structure here. */
    public _380_InsertDeleteGetRandomO1() {
        index = new HashMap<Integer, Integer>();
        value = new ArrayList<>();
        r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(index.containsKey(val))
            return false;
        index.put(val, value.size());
        value.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        int ind = index.getOrDefault(val, -1);
        if(ind == -1)
            return false;
        if(val != value.get(value.size() - 1)){
            index.put(value.get(value.size() - 1), ind);
            value.set(ind, value.get(value.size() - 1));
        }
        index.remove(val);
        value.remove(value.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return value.get(r.nextInt(value.size()));
    }
}
