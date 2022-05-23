package Trees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tuple {
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class PrintTopView {

    public List<Integer> printTopView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<Integer>();
        Queue<Tuple> pq = new LinkedList<>();
        pq.add(new Tuple(root, 0, 0));
        while(!pq.isEmpty()) {
            Tuple tuple = pq.poll();
            if(!hs.contains(tuple.row)) {
                result.add(tuple.node.val);
                hs.add(tuple.row);
            }
            if(tuple.node.left != null) {
                pq.add(new Tuple(tuple.node.left, tuple.row - 1, tuple.col + 1));
            }
            if(tuple.node.right != null) {
                pq.add(new Tuple(tuple.node.right, tuple.row + 1, tuple.col + 1));
            }            
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        left = new TreeNode(4);
        right = new TreeNode(5);        
        root.left.left = left;
        root.left.right = right;
        left = new TreeNode(6);
        right = new TreeNode(7); 
        root.right.left = left;
        root.right.right = right;
        System.out.println(new PrintTopView().printTopView(root));           
    }
}
