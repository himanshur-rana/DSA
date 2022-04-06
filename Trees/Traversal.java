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

    public void inorderTraversalIterative(Node root) {
        Stack<Node> pendingNodes = new Stack<>();
        if(root == null) {
            return;
        }
        pendingNodes.push(root);
        Node currentNode = root;
        while(!pendingNodes.isEmpty()) {
            if(currentNode == null) {
                Node poppedNode = pendingNodes.pop();
                System.out.println(poppedNode.data);
                currentNode = poppedNode.right;
                if(currentNode != null) {
                    pendingNodes.push(currentNode);
                }
                continue;
            }
            Node nextNode = currentNode.left;
            if(nextNode != null) {
                pendingNodes.push(nextNode);
            }
            currentNode = nextNode;
        }
    }

    public void postOrderTraversalIterative1(Node root) {
        // This is using 2 stacks
        if(root == null) {
            return;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()) {
            Node poppedNode = st1.pop();
            st2.push(poppedNode);
            if(poppedNode.left != null) {
                st1.push(poppedNode.left);
            }
            if(poppedNode.right != null) {
                st1.push(poppedNode.right);
            }
        }
        while(!st2.empty()) {
            System.out.print(st2.pop().data + " ");
        }
    }

    public void postOrderTraversalIterative2(Node root) {
        // Using 1 stack
        if(root == null) {
            return;
        }
        Stack<Node> st = new Stack<>();
        Node currentNode = root;
        while(currentNode != null || !st.isEmpty()) {
            if(currentNode != null) {
                st.push(currentNode);
                currentNode = currentNode.left;                
            } else {
                Node temp = st.peek().right;
                if(temp == null) {
                    temp = st.pop();
                    System.out.print(temp.data + " ");
                    while(!st.isEmpty() && st.peek().right == temp) {
                        temp = st.pop();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    currentNode = temp;
                }
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
        traversalObj.postOrderTraversalIterative1(root);
        System.out.println();
        traversalObj.postOrderTraversalIterative2(root);
    }
}
