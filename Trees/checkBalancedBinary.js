function TreeNode(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
}

var isBalanced = function (root) {
    return isBalancedHelper(root).isBalanced;
};

const isBalancedHelper = (root) => {
    if (root == null) {
        let result = {};
        result.height = 0;
        result.isBalanced = true;
        return result;
    }

    const lr = isBalancedHelper(root.left);
    const rr = isBalancedHelper(root.right);

    let result = {};
    result.isBalanced = Math.abs(lr.height - rr.height) <= 1 ? true : false;
    result.isBalanced =
        result.isBalanced && lr.isBalanced && rr.isBalanced ? true : false;
    result.height = Math.max(lr.height, rr.height) + 1;
    return result;
};
