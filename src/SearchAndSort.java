import java.util.Arrays;
import java.util.Random;

/**
 * Created by Shengwei_Wang on 9/24/16.
 */
public class SearchAndSort {
    public static void main(String[] args){
        int n = 20;
        int[] a = new int[n];
        int[] corner1 = {1,1,1,1,1,1,1};
        int[] corner2 = {9,8,7,6,5,5,4,3,2,1};
        Random r = new Random();
        for(int i = 0; i <n; ++i)
            a[i] = r.nextInt(1000);
        int[] b = a;
        Arrays.sort(b);
        SearchAndSort solution = new SearchAndSort();
//        solution.qsort(a, 0, n-1);
//        solution.print(a);
//        System.out.println();
//
//        solution.qsort(corner1, 0, corner1.length - 1);
//        solution.print(corner1);
//        System.out.println();
//
//        solution.qsort(corner2, 0, corner2.length - 1);
//        solution.print(corner2);
//        System.out.println();
//        solution.mergeSort(a, 0, a.length - 1, new int[a.length]);
//        solution.print(a);
//        System.out.println();
//
//        solution.mergeSort(corner1, 0, corner1.length - 1, new int[corner1.length]);
//        solution.print(corner1);
//        System.out.println();
//
//        solution.mergeSort(corner2, 0, corner2.length - 1, new int[corner2.length]);
//        solution.print(corner2);
//        System.out.println();
        solution.heapSort(a);
        solution.print(a);
        System.out.println();

        solution.heapSort(corner1);
        solution.print(corner1);
        System.out.println();

        solution.heapSort(corner2);
        solution.print(corner2);
        System.out.println();

    }
    void print(int[] a){
        for(int i : a)
            System.out.println(i);
    }
    void swap (int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    void qsort(int[] a, int l, int r){
        if(l >= r)
            return;
        int mid = l + (r - l) / 2;
        int x = a[mid];
        int i = l;
        int j = r;
        while(i < j){
            while(i < j && a[i] < x)
                ++i;
            while(i < j && a[j] > x)
                --j;
            if(i < j) {
                swap(a, i, j);
                ++i;
                --j;
            }
        }
        if(l < i - 1)
            qsort(a, l, i - 1);
        if(j + 1 < r)
            qsort(a, j + 1, r);
    }

    void mergeSort(int[] a, int l, int r, int[] b){
        if(l >= r)
            return;
        int mid = l + ((r - l)>>1);
        mergeSort(a, l , mid, b);
        mergeSort(a, mid + 1, r, b);
        int i = l;
        int j = mid + 1;
        int k = l;
        while(k <= r){
            if(i > mid)
                b[k] = a[j++];
            else if (j > r)
                b[k] = a[i++];
            else if (a[i] < a[j])
                b[k] = a[i++];
            else
                b[k] = a[j++];
            ++k;
        }
        for(i = l; i <= r; ++i)
            a[i] = b[i];
    }

    void heapSort(int[] a){
        priorityq q = new priorityq();
        for(int i : a)
            q.offer(i);
        for(int i = 0; i < a.length; ++i)
            a[i] = q.poll();
    }
}
