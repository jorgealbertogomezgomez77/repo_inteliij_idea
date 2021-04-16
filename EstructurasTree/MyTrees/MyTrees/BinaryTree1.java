package MyTrees;


// Java program to print top
// view of binary tree
import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;

// class to create a node
class Node {
    int data;
    MyTrees.A.Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// class of binary tree
class BinaryTree {
    MyTrees.A.Node root;

    public BinaryTree() {
        root = null;
    }

    // function should print the topView of
    // the binary tree
    private void TopView(MyTrees.A.Node root) {
        class QueueObj {
            MyTrees.A.Node node;
            int hd;

            QueueObj(MyTrees.A.Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, MyTrees.A.Node> topViewMap = new TreeMap<Integer, MyTrees.A.Node>();

        if (root == null) {
            return;
        } else {
            q.add(new QueueObj(root, 0));
        }

        System.out.println("The top view of the tree is : ");

        // count function returns 1 if the container
        // contains an element whose key is equivalent
        // to hd, or returns zero otherwise.
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }

            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
            }

        }
        for (Entry<Integer, MyTrees.A.Node> entry : topViewMap.entrySet()) {
            System.out.print(entry.getValue().data);
        }
    }

    // Driver Program to test above functions
    public static void main(String[] args)
    {
		/* Create following Binary Tree
			1
		/ \
		2 3
		\
			4
			\
			5
			\
				6*/
        MyTrees.A.BinaryTree tree = new MyTrees.A.BinaryTree();
        tree.root = new MyTrees.A.Node(1);
        tree.root.left = new MyTrees.A.Node(2);
        tree.root.right = new MyTrees.A.Node(3);
        tree.root.left.right = new MyTrees.A.Node(4);
        tree.root.left.right.right = new MyTrees.A.Node(5);
        tree.root.left.right.right.right = new MyTrees.A.Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.TopView(tree.root);
    }

}
