package Trees;

class Node {
    
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Traversal {
    
    public void preOrderTraversal(Node root) {
        // we will just not make a list
        if(root == null) {
            return;
        }

        System.out.println(root.data + " ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        // Make a tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        Traversal traversalObj = new Traversal();
        traversalObj.preOrderTraversal(root);
    }
}
