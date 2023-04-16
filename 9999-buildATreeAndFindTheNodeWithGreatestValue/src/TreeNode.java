class TreeNode {
    TreeNode parent;
    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode(int value) {
        this.value = value;
    }
    
    public TreeNode withLeaves(int leftVal, int rightVal) {
        left = new TreeNode(leftVal);
        right = new TreeNode(rightVal);
        return this;
    }

    public TreeNode withParent(TreeNode parent) {
        this.parent = parent;
        return this;
    }
  
    public TreeNode withLeaves(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        return this;
    }
}