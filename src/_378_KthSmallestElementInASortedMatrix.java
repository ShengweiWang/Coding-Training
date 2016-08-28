import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _378_KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < matrix.length; ++i)
            for(int j = 0; j < matrix[0].length; ++j)
                pq.add(matrix[i][j]);
        for(int i = 1; i < k; ++i)
            pq.poll();
        return pq.poll();
    }
}
