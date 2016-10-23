package Google;
import java.util.Iterator;

class _284_PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer cache;
    boolean cachedHasNext;
    public _284_PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
        this.next();

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return cache;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer temp = cache;
        cachedHasNext = iterator.hasNext();
        if (cachedHasNext)
            cache = iterator.next();
        return temp;
    }

    @Override
    public boolean hasNext() {
        return cachedHasNext;
    }
}