import java.util.Iterator;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/7/16.
 */
public class _251_Flatten2DVector {
    Iterator<List<Integer>> outer;
    Iterator<Integer> inner;
    List<Integer> t;
    public _251_Flatten2DVector(List<List<Integer>> vec2d) {
        outer = vec2d.iterator();
        if(outer.hasNext()) {
            t = outer.next();
            inner = t.iterator();
        } else {
            t = new
            inner = t.iterator();
        }

    }

    public Integer next() {

    }

    public boolean hasNext() {
        if(outer.hasNext() || inner. )
    }
}
