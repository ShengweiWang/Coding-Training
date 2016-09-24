import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _403_FrogJump {
    public boolean canCross(int[] stones) {
        if(stones.length == 0)
            return true;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int stone : stones){
            map.put(stone, new HashSet<Integer>());
        }

        map.get(0).add(0);
        for(int stone : stones){
            Set<Integer> curset = map.get(stone);
            for(int step : curset){
                if(map.containsKey(step - 1 + stone) && step - 1 > 0)
                    map.get(step - 1 + stone).add(step - 1);
                if(map.containsKey(step + stone) && step > 0)
                    map.get(step + stone).add(step);
                if(map.containsKey(step + 1 + stone) && step + 1 > 0)
                    map.get(step + 1 + stone).add(step + 1);
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}
