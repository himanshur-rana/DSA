package Trees;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

class NodeDetail {

    int row;
    int column;
    int value;

    public NodeDetail(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }
}

class SortNodeDetail implements Comparator<NodeDetail> {

    @Override
    public int compare(NodeDetail o1, NodeDetail o2) {
        
        return o1.row - o2.row;
    }
    
}

public class TreeMapImpl {

    public static void main(String[] args) {
        TreeMap<NodeDetail, String> treeMap = new TreeMap<NodeDetail, String>(new SortNodeDetail());
        NodeDetail nd1 = new NodeDetail(0, 0, 1);
        treeMap.put(nd1, "Himanshu");
        NodeDetail nd2 = new NodeDetail(-1, 1, 2);
        treeMap.put(nd2, "Upasana");
        NodeDetail nd3 = new NodeDetail(1, 1, 3);
        treeMap.put(nd3, "Rishi");        
        System.out.println(treeMap);

        

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(4);
        pq.add(5);
        pq.add(1);
        while(!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
