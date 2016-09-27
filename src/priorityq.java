import java.util.Vector;

/**
 * Created by Shengwei_Wang on 9/24/16.
 */
public class priorityq {
    Vector<Integer> a;
    public priorityq(){
        a = new Vector<Integer>();
    }

    void swap(Vector<Integer> t, int i, int j){
        int temp = t.get(i);
        t.set(i, t.get(j));
        t.set(j, temp);
    }
    public void offer(int k){
        a.add(k);
        int s = a.size() - 1;
        while(s != 0){
            int p = (s - 1) >> 1;
            if(a.get(s) < a.get(p)){
                swap(a, s, p);
                s = p;
            } else
                break;
        }
    }

    public int poll(){
        int ans = a.get(0);
        swap(a, 0, a.size() - 1);
        a.remove(a.size() - 1);
        int index = 0;
        while(index < a.size()){
            int leftChild = (index << 1) + 1;
            int rightChild = (index << 1) + 2;
            if(leftChild < a.size() && a.get(index) > a.get(leftChild) && (rightChild >= a.size() || a.get(leftChild) < a.get(rightChild))) {
                swap(a, index, leftChild);
                index = leftChild;
            } else if (rightChild < a.size() &&  a.get(index) > a.get(rightChild)) {
                swap(a, index, rightChild);
                index = rightChild;
            } else
                break;
        }
        return ans;

    }
}
