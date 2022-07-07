package Trees;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class RootToLeaf {
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
        //System.out.println(root.val);
        System.out.println(printTreePath(root, root.right.right));        
     }

    private static List<Integer> printTreePath(TreeNode root, TreeNode target) {
        List<Integer> path = new ArrayList<Integer>();
        Boolean result = printTreePathHelper(root, target, path);
        if(result == true) {
            return path;
        }
        return new ArrayList<Integer>();
    }

    private static Boolean printTreePathHelper(TreeNode root, TreeNode target, List<Integer> path) {
        if(root == target) {
            path.add(root.val);
            return true;
        }
        if(root == null) {
            return false;
        }

        path.add(root.val);
        
        Boolean leftPath = printTreePathHelper(root.left, target, path);
        if(leftPath) {
            return true;
        }
        Boolean rightPath = printTreePathHelper(root.right, target, path);
        if(rightPath) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }
}
