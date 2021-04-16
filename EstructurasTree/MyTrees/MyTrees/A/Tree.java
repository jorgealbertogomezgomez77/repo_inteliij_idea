package MyTrees.A;

public class Tree
{
    private Node parent;

    private int  data;

    private int  size = 0;

    public Tree() {
        parent = new Node(data);
    }

    public void add(int data) {

        if (size == 0) {
            parent.data = data;
            size++;
        } else {
            add(parent, new Node(data));
        }
    }

    private void add(Node root, Node newNode) {

        if (root == null) {
            return;
        }

        if (newNode.data < root.data) {

            if (root.left == null) {
                root.left = newNode;
                size++;
            } else {
                add(root.left, newNode);
            }
        } else {

            if (root.right == null) {
                root.right = newNode;
                size++;
            } else {
                add(root.right, newNode);
            }
        }
    }

    public int getLow() {

        Node current = parent;

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    public int getHigh() {

        Node current = parent;

        while (current.right != null) {
            current = current.right;
        }

        return current.data;
    }

    private void in(Node node) {

        if (node != null) {

            in(node.left);
            System.out.print(node.data + " ");
            in(node.right);
        }
    }

    private void pre(Node node) {

        if (node != null) {

            System.out.print(node.data + " ");
            pre(node.left);
            pre(node.right);
        }
    }

    private void post(Node node) {

        if (node != null) {

            post(node.left);
            post(node.right);
            System.out.print(node.data + " ");
        }
    }

    public void preorder() {

        System.out.print("Preorder Traversal->");
        pre(parent);
        System.out.println();
    }

    public void postorder() {

        System.out.print("Postorder Traversal->");
        post(parent);
        System.out.println();
    }

    public void inorder() {

        System.out.print("Inorder Traversal->");
        in(parent);
        System.out.println();
    }

    private class Node {

        Node left;

        Node right;

        int  data;

        public Node(int data) {
            this.data = data;
        }
    }

    public String toString() {

        Node current = parent;
        System.out.print("Traverse From Left ");

        while (current.left != null && current.right != null) {

            System.out.print(current.data + "->[" + current.left.data + " " + current.right.data + "] ");
            current = current.left;
        }

        System.out.println();
        System.out.print("Traverse From Right ");

        current = parent;

        while (current.left != null && current.right != null) {

            System.out.print(current.data + "->[" + current.left.data + " " + current.right.data + "] ");
            current = current.right;
        }

        return "";
    }

    public static void main(String af[]) {

        Tree t = new Tree();

        t.add(40);
        t.add(25);
        t.add(78);
        t.add(10);
        t.add(32);
        t.add(50);
        t.add(93);
        t.add(3);
        t.add(17);
        t.add(30);
        t.add(38);

        System.out.println(t.getLow());

        System.out.println(t.getHigh());

        System.out.println("Size-" + t.size);

        System.out.println(t);

        t.inorder();

        t.preorder();

        t.postorder();
    }
}