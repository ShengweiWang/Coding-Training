import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _359_LoggerRateLimiter {
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public _359_LoggerRateLimiter() {
        map = new HashMap<String, Integer>();

    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if(timestamp - map.getOrDefault(message, -10) >= 10){
            map.put(message, timestamp);
            return true;
        } else
            return false;
    }
}
