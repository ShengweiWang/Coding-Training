import java.util.Iterator;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _281_ZigzagIterator {
    Iterator i;
    Iterator j;
    int turn;
    public _281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        turn = 0;
        i = v1.iterator();
        j = v2.iterator();
    }

    public int next() {
        if(turn == 0 || !j.hasNext()){
            turn = 1;
            return (int)i.next();
        } else {
            turn = 0;
            return (int)j.next();
        }
    }

    public boolean hasNext() {
        if(i.hasNext() || j.hasNext())
            return true;
        else
            return false;
    }
}
