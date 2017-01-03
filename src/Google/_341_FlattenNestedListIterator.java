package Google;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Shengwei_Wang on 11/2/16.
 */
public class _341_FlattenNestedListIterator implements Iterator{
        Deque<Iterator<NestedInteger>> stack;
        int cache;
        boolean hasNext;
        public _341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
            stack = new ArrayDeque<>();
            stack.push(nestedList.iterator());
            this.next();
        }

        @Override
        public Integer next() {
            NestedInteger nextI;
            int temp = cache;
            hasNext = false;
            while (stack.size() > 0) {
                if (!stack.peek().hasNext())
                    stack.pop();
                else if ((nextI = stack.peek().next()).isInteger()) {
                    cache = nextI.getInteger();
                    hasNext = true;
                    break;
                } else
                    stack.push(nextI.getList().iterator());
            }

            return temp;
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }
}
