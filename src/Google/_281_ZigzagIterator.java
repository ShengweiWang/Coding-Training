package Google;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Shengwei_Wang on 10/16/16.
 */
public class _281_ZigzagIterator {
    List<Iterator<Integer>> iterators;
    ListIterator<Iterator<Integer>> outerIterator;
    public _281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new LinkedList<>();
        iterators.add(v1.iterator());
        iterators.add(v2.iterator());
        outerIterator = iterators.listIterator();
    }

    public int next() {
        if (hasNext()) {
            return outerIterator.next().next();
        } else
            return -1;
    }

    public boolean hasNext() {
        while (iterators.size() > 0){
            while (outerIterator.hasNext()) {
                Iterator<Integer> cur = outerIterator.next();
                if (cur.hasNext()) {
                    outerIterator.previous();
                    return true;
                } else {
                    outerIterator.remove();
                }
            }
            outerIterator = iterators.listIterator();
        }
        return false;
    }
}
