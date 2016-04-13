package mavenTest.binarytree;

public class BinaryTree {
	Node root;
	String print;
	
	public BinaryTree() {
		root = null;
	    print = null;
	}
	
	public void insert(int value) {
		Node newNode = new Node(value);
		
		if (root == null) {
			root = newNode;
			return;
		} 
		
		Node node = root;
		Node parent;
		
		while(true) {
			parent = node;
			if (value < node.key) {
				node = node.left;
				if (node == null) {
					parent.left = newNode;
					return;
				}
			} else {
				node = node.right;
				if (node == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public void inOrderPrint() {
		print = "";
		inOrderPrint(root);
	}
	private void inOrderPrint(Node node) {
		if (node != null) {
			inOrderPrint(node.left);
			print += node.key + ",";
			inOrderPrint(node.right);
		}
	}
	
	public void preOrderPrint() {
		print = "";
		preOrderPrint(root);
	}
	private void preOrderPrint(Node node) {
		if (node != null) {
			print += node.key + ",";
			preOrderPrint(node.left);
			preOrderPrint(node.right);
		}
	}

	public void postOrderPrint() {
		print = "";
		postOrderPrint(root);
	}
	private void postOrderPrint(Node node) {
		if (node != null) {
			postOrderPrint(node.left);
			postOrderPrint(node.right);
			print += node.key + ",";
		}
	}
	
	public Node findNode(int key) {
		Node node = root;
		while (node.key != key) {
			if (key < node.key) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return node;
	}
	
	public void delete(int value) {
		if (root == null) {
			throw new NullPointerException();
		}
		this.root = delete(this.root, value);
	}
	
	public Node delete(Node node, int value) {
	    if(node.key < value) {
	        node.right = delete(node.right, value);
	    } else if(node.key > value) {
	        node.left = delete(node.left, value);
	    } else {
	        if(node.right == null) {
	            return node.left;
	        }
	        if(node.left == null) {
	            return node.right;
	        }
	        Node temp = node;
	        node = min(temp.right);
	        node.right = deleteMin(temp.right);
	        node.left = temp.left;
	    }
	    return node;
	}
	
	private Node min(Node node) {
	    if(node.left == null) {
	        return node;
	    } else {
	        return min(node.left);
	    }
	}
	
	private Node deleteMin(Node node) {
	    if(node.left == null) {
	        return node.right;
	    }
	    node.left = deleteMin(node.left);
	    return node;
	}
}
