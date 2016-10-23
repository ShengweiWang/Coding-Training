package Google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/18/16.
 */
public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
