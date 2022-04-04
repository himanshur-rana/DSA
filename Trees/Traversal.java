package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        System.out.print(root.data + " ");

        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void levelOrderTraversal(Node root) {
        Queue<Node> pendingNodes = new LinkedList<>();
        if(root == null) {
            return;
        }
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()) {
            Node currentNode = (Node)pendingNodes.poll();
            System.out.println(currentNode.data);

            if(currentNode.left != null) {
                pendingNodes.add(currentNode.left);
            }
            if(currentNode.right != null) {
                pendingNodes.add(currentNode.right);
            }            
        }
    }

    public void preOrderTraversalIterative(Node root) {
        Stack<Node> pendingNodes = new Stack<>();
        if(root == null) {
            return;
        }
        pendingNodes.add(root);
        while(!pendingNodes.isEmpty()) {
            Node currentNode = pendingNodes.pop();
            System.out.print(currentNode.data + " ");
            if(currentNode.right != null) {
                pendingNodes.add(currentNode.right);
            }
            if(currentNode.left != null) {
                pendingNodes.add(currentNode.left);
            }
        }
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
        System.out.println();
        traversalObj.preOrderTraversalIterative(root);
    }
}
