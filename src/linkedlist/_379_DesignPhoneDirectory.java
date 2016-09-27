package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class  _379_DesignPhoneDirectory {
    boolean[] available;
    Queue<Integer> q;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public _379_DesignPhoneDirectory(int maxNumbers) {
        q = new LinkedList<Integer>();
        available = new boolean[maxNumbers];
        for(int i = 0; i < maxNumbers; ++i)
            q.offer(i);
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if(q.size() == 0)
            return -1;
        int res = q.poll();
        available[res] = true;
        return res;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !available[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(available[number]){
            available[number] = false;
            q.offer(number);
        }
    }
}
