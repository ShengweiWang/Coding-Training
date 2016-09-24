import java.util.*;

/**
 * Created by Shengwei_Wang on 8/27/16.
// */
public class Dijkstra{
    public static void main(String[] args){
        int[][] dist = {{0,1,2,0},{3,4,5,6},{5,6,7,8},{93,42,23,3}};
        int s = 0;
        int t = 3;
        Dijkstra solution = new Dijkstra();
        System.out.println(solution.shortestNum(dist, s, t));
        System.out.println("Path:");
        solution.printPath(t);
    }

    int[] current;
    boolean[] finished;
    int[][] dist;
    List<Integer>[] path;
    int shortestNum(int[][] dist, int s ,int t){
        path = new List[dist.length];
        this.dist = dist;
        current = new int[dist.length];
        finished = new boolean[dist.length];
        Arrays.fill(current, Integer.MAX_VALUE);
        current[s] = 0;
        path[s] = new LinkedList<Integer>();
        path[s].add(s);
        while(true){
            int p = getSmallestUnfinished();
            if(p == -1)
                break;
            update(p);
        }
        return current[t];

    }

    int getSmallestUnfinished() {
        int p = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < dist.length; ++i)
            if(!finished[i] && current[i] < min){
                p = i;
                min = current[i];
            }
        if(p!=-1)
            finished[p] = true;
        return p;
    }

    void update(int p){
        for(int i = 0 ; i < dist.length; ++i)
            if(!finished[i] && (i != p && dist[p][i] != 0) && (current[p] + dist[p][i] < current[i])){
                current[i] = current[p] + dist[p][i];
                path[i] = new LinkedList<>(path[p]);
                path[i].add(i);
            }
    }

    void printPath(int t) {
        Iterator<Integer> i = path[t].iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
    }
}
//public class Dijkstra {
//    public List<List<Integer>> getPath(int[][] graph, int start, int end){
//        List<List<Integer>>[] path = new ArrayList<ArrayList<Integer>>[graph.length];
//
//        int[] cur = new int [graph.length];
//        for(int i = 0; i < graph.length; ++i)
//            cur[i] = Integer.MAX_VALUE;
//        cur[start] = 0;
//        boolean[] flag = new boolean[graph.length];
//        for(int i = 0; i < graph.length; ++i){
//            int min = Integer.MAX_VALUE;
//            int index = -1;
//            for(int j = 0; j < graph.length; ++j){
//                if(!flag[j] && cur[j] < min){
//                    index = j;
//                    min = cur[j];
//                }
//            }
//
//            if(index == -1)
//                break;
//            flag[index] = true;
//
//            for(int k = 0; k < graph.length; ++k){
//                if(graph[index][k] != 0){
//                    if(cur[index] + graph[index][k] < cur[k]){
//                        //create new path
//                        cur[k] = cur[index] + graph[index][k];
//                    } else if (cur[index] + graph[index][k] == cur[k]){
//                        //add new path
//                    }
//                }
//            }
//        }
//        return path[end];
//    }
//}
