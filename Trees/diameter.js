function TreeNode(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
}

var diameterOfBinaryTree = function (root) {
    return diameterOfBinaryTreeHelper(root).diameter;
};

const diameterOfBinaryTreeHelper = (root) => {
    if (root == null) {
        const result = {};
        result.height = 0;
        result.diameter = 0;
        return result;
    }

    const lr = diameterOfBinaryTreeHelper(root.left);
    const rr = diameterOfBinaryTreeHelper(root.right);

    let result = {};
    result.height = Math.max(lr.height, rr.height) + 1;
    result.diameter = lr.height + rr.height;
    result.diameter = Math.max(result.diameter, lr.diameter, rr.diameter);

    return result;
};
