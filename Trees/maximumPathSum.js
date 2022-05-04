function TreeNode(val, left, right) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
}

let maxSum = 0;

var maxPathSum = function (root) {
    maxSumHelper(root);
    return maxSum;
};

const maxSumHelper = (root) => {
    console.log(root);
    if (root == null) {
        return 0;
    }

    const leftSum = maxSumHelper(root.left); //2
    const rightSum = maxSumHelper(root.right); //3
    maxSum = Math.max(maxSum, leftSum + rightSum + root.val);

    return root.val + Math.max(leftSum, rightSum);
};

const root = new TreeNode(0, null, null);
console.log(maxPathSum(root));
