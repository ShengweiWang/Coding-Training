import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class Dijkstra {
    public List<List<Integer>> getPath(int[][] graph, int start, int end){
        List<List<Integer>>[] path = new List<List<Integer>>[graph.length];

        int[] cur = new int [graph.length];
        for(int i = 0; i < graph.length; ++i)
            cur[i] = Integer.MAX_VALUE;
        cur[start] = 0;
        boolean[] flag = new boolean[graph.length];
        for(int i = 0; i < graph.length; ++i){
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j = 0; j < graph.length; ++j){
                if(!flag[j] && cur[j] < min){
                    index = j;
                    min = cur[j];
                }
            }

            if(index == -1)
                break;
            flag[index] = true;

            for(int k = 0; k < graph.length; ++k){
                if(graph[index, k] != 0){
                    if(cur[index] + graph[index, k] < cur[k]){
                        //create new path
                        cur[k] = cur[index] + graph[index, k]
                    } else if (cur[index] + graph[index, k] == cur[k]){
                        //add new path
                    }
                }
            }
        }
        return path[end];
    }
}
