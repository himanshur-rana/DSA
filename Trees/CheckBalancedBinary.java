package Trees;

public class CheckBalancedBinary {

    public Boolean checkBalancedBinary(Node node) {
        Result result = checkBalancedBinaryHelper(node);
        return result.isBalancedBinaryTree;
    }

    private Result checkBalancedBinaryHelper(Node node) {
        if(node == null) {
            return new Result(true, 0);
        }

        Result lr = checkBalancedBinaryHelper(node.left);
        Result rr = checkBalancedBinaryHelper(node.right);

        Result returnResult = new Result();
        Boolean isBalancedBinaryTree = Math.abs(lr.height - rr.height) <= 1 ? true : false;
        isBalancedBinaryTree = (isBalancedBinaryTree && lr.isBalancedBinaryTree && rr.isBalancedBinaryTree) ? true : false;
        returnResult.isBalancedBinaryTree = isBalancedBinaryTree;
        returnResult.height = Math.max(lr.height, rr.height) + 1;
        return returnResult;
    }
}

class Result {
    Boolean isBalancedBinaryTree;
    int height;

    Result(Boolean isBalancedBinaryTree, int height) {
        this.isBalancedBinaryTree = isBalancedBinaryTree;
        this.height = height;
    }

    Result() {

    }
}
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