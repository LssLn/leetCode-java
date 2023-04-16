import java.util.*;


public class Main {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
	    try {
	    	String commaSeparatedInput = input.next();
	        TreeNode root = arrayToTree(commaSeparatedInput.split(","));
	        TreeNode greatestNode = greatestNode(root);
	      	System.out.println(greatestNode.value);
	    } finally {
	    	input.close();
	    }
    }
  
    /*
		Create a new node with the value to be inserted.
		Traverse the tree starting from the root node.
		If the new node's value is less than the value of the current node, move to the left child node. If the left child is null, insert the new node there.
		If the new node's value is greater than the value of the current node, move to the right child node. If the right child is null, insert the new node there.
		Repeat steps 3-4 until a suitable position is found for the new node.
     */
    public static TreeNode arrayToTree(String[] array) {	
    	TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        
        for (int i = 1; i < array.length; i++) {
            addNode(root, Integer.parseInt(array[i]));
        }
        
        return root;
    }
    
    private static void addNode(TreeNode parent, int value) {
        if (value < parent.value) {
            if (parent.left == null) {
                parent.left = new TreeNode(value);
                parent.left.parent = parent;
            } else {
                addNode(parent.left, value);
            }
        } else {
            if (parent.right == null) {
                parent.right = new TreeNode(value);
                parent.right.parent = parent;
            } else {
                addNode(parent.right, value);
            }
        }
    }
    
    public static TreeNode greatestNode(TreeNode node) {
    	if (node == null) {
            return null;
        } else if (node.right == null) { // current value is the greatest
            return node;
        } else { //continue with the research
            return greatestNode(node.right);
        }
            
    }
}