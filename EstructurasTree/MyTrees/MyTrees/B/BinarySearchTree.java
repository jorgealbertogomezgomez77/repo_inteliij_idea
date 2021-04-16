package MyTrees.B;

import java.util.NoSuchElementException;
import java.util.Scanner;

import org.junit.experimental.max.MaxCore;

class BSTNode {

    BSTNode left = null;
    BSTNode rigth = null;
    int data = 0;

    public BSTNode() {
        super();
    }

    public BSTNode(int data) {
        this.left = null;
        this.rigth = null;
        this.data = data;
    }

    @Override
    public String toString() {
        return "BSTNode [left=" + left + ", rigth=" + rigth + ", data=" + data + "]";
    }

}


class BinarySearchTree {

    BSTNode root = null;

    public BinarySearchTree() {

    }

    public void insert(int data) {
        BSTNode node = new BSTNode(data);
        if (root == null) {
            root = node;
            return;
        }

        BSTNode currentNode = root;
        BSTNode parentNode = null;

        while (true) {
            parentNode = currentNode;
            if (currentNode.data == data)
                throw new IllegalArgumentException("Duplicates nodes note allowed in Binary Search Tree");

            if (currentNode.data > data) {
                currentNode = currentNode.left;
                if (currentNode == null) {
                    parentNode.left = node;
                    return;
                }
            } else {
                currentNode = currentNode.rigth;
                if (currentNode == null) {
                    parentNode.rigth = node;
                    return;
                }
            }
        }
    }

    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(BSTNode node) {
        if (node == null) {
            return 0;
        } else {
            int count = 1;
            count += countNodes(node.left);
            count += countNodes(node.rigth);
            return count;
        }
    }

    public boolean searchNode(int data) {
        if (empty())
            return empty();
        return searchNode(data, root);
    }

    public boolean searchNode(int data, BSTNode node) {
        if (node != null) {
            if (node.data == data)
                return true;
            else if (node.data > data)
                return searchNode(data, node.left);
            else if (node.data < data)
                return searchNode(data, node.rigth);
        }
        return false;
    }

    public boolean delete(int data) {
        if (empty())
            throw new NoSuchElementException("Tree is Empty");

        BSTNode currentNode = root;
        BSTNode parentNode = root;
        boolean isLeftChild = false;

        while (currentNode.data != data) {
            parentNode = currentNode;
            if (currentNode.data > data) {
                isLeftChild = true;
                currentNode = currentNode.left;
            } else if (currentNode.data < data) {
                isLeftChild = false;
                currentNode = currentNode.rigth;
            }
            if (currentNode == null)
                return false;
        }

        // CASE 1: node with no child
        if (currentNode.left == null && currentNode.rigth == null) {
            if (currentNode == root)
                root = null;
            if (isLeftChild)
                parentNode.left = null;
            else
                parentNode.rigth = null;
        }

        // CASE 2: if node with only one child
        else if (currentNode.left != null && currentNode.rigth == null) {
            if (root == currentNode) {
                root = currentNode.left;
            }
            if (isLeftChild)
                parentNode.left = currentNode.left;
            else
                parentNode.rigth = currentNode.left;
        } else if (currentNode.rigth != null && currentNode.left == null) {
            if (root == currentNode)
                root = currentNode.rigth;
            if (isLeftChild)
                parentNode.left = currentNode.rigth;
            else
                parentNode.rigth = currentNode.rigth;
        }

        // CASE 3: node with two child
        else if (currentNode.left != null && currentNode.rigth != null) {

            // Now we have to find minimum element in rigth sub tree
            // that is called successor
            BSTNode successor = getSuccessor(currentNode);
            if (currentNode == root)
                root = successor;
            if (isLeftChild)
                parentNode.left = successor;
            else
                parentNode.rigth = successor;
            successor.left = currentNode.left;
        }

        return true;
    }

    private BSTNode getSuccessor(BSTNode deleteNode) {

        BSTNode successor = null;
        BSTNode parentSuccessor = null;
        BSTNode currentNode = deleteNode.left;

        while (currentNode != null) {
            parentSuccessor = successor;
            successor = currentNode;
            currentNode = currentNode.left;
        }

        if (successor != deleteNode.rigth) {
            parentSuccessor.left = successor.left;
            successor.rigth = deleteNode.rigth;
        }

        return successor;
    }

    public int nodeWithMinimumValue() {
        return nodeWithMinimumValue(root);
    }

    private int nodeWithMinimumValue(BSTNode node) {
        if (node.left != null)
            return nodeWithMinimumValue(node.left);
        return node.data;
    }

    public int nodewithMaximumValue() {
        return nodewithMaximumValue(root);
    }

    private int nodewithMaximumValue(BSTNode node) {
        if (node.rigth != null)
            return nodewithMaximumValue(node.rigth);
        return node.data;
    }

    public int parent(int data) {
        return parent(root, data);
    }

    private int parent(BSTNode node, int data) {
        if (empty())
            throw new IllegalArgumentException("Empty");
        if (root.data == data)
            throw new IllegalArgumentException("No Parent node found");

        BSTNode parent = null;
        BSTNode current = node;

        while (current.data != data) {
            parent = current;
            if (current.data > data)
                current = current.left;
            else
                current = current.rigth;
            if (current == null)
                throw new IllegalArgumentException(data + " is not a node in tree");
        }
        return parent.data;
    }

    public int sibling(int data) {
        return sibling(root, data);
    }

    private int sibling(BSTNode node, int data) {
        if (empty())
            throw new IllegalArgumentException("Empty");
        if (root.data == data)
            throw new IllegalArgumentException("No Parent node found");

        BSTNode cureent = node;
        BSTNode parent = null;
        boolean isLeft = false;

        while (cureent.data != data) {
            parent = cureent;
            if (cureent.data > data) {
                cureent = cureent.left;
                isLeft = true;
            } else {
                cureent = cureent.rigth;
                isLeft = false;
            }
            if (cureent == null)
                throw new IllegalArgumentException("No Parent node found");
        }
        if (isLeft) {
            if (parent.rigth != null) {
                return parent.rigth.data;
            } else
                throw new IllegalArgumentException("No Sibling is there");
        } else {
            if (parent.left != null)
                return parent.left.data;
            else
                throw new IllegalArgumentException("No Sibling is there");
        }
    }

    public void leafNodes() {
        if (empty())
            throw new IllegalArgumentException("Empty");
        leafNode(root);
    }

    private void leafNode(BSTNode node) {
        if (node == null)
            return;
        if (node.rigth == null && node.left == null)
            System.out.print(node.data + " ");
        leafNode(node.left);
        leafNode(node.rigth);
    }

    public int level(int data) {
        if (empty())
            throw new IllegalArgumentException("Empty");
        return level(root, data, 1);
    }

    private int level(BSTNode node, int data, int level) {
        if (node == null)
            return 0;
        if (node.data == data)
            return level;
        int result = level(node.left, data, level + 1);
        if (result != 0)
            return result;
        result = level(node.rigth, data, level + 1);
        return result;
    }

    public int depth() {
        return depth(root);
    }

    private int depth(BSTNode node) {
        if (node == null)
            return 0;
        else
            return 1 + Math.max(depth(node.left), depth(node.rigth));
    }

    public int height() {
        return height(root);
    }

    private int height(BSTNode node) {
        if (node == null)
            return 0;
        else
            return 1 + Math.max(height(node.left), height(node.rigth));
    }

    public void leftView() {
        leftView(root);
    }

    private void leftView(BSTNode node) {
        if (node == null)
            return;
        int height = height(node);

        for (int i = 1; i <= height; i++) {
            printLeftView(node, i);
        }
    }

    private boolean printLeftView(BSTNode node, int level) {
        if (node == null)
            return false;

        if (level == 1) {
            System.out.print(node.data + " ");
            return true;
        } else {
            boolean left = printLeftView(node.left, level - 1);
            if (left)
                return true;
            else
                return printLeftView(node.rigth, level - 1);
        }
    }

    public void mirroeView() {
        BSTNode node = mirroeView(root);
        preorder(node);
        System.out.println();
        inorder(node);
        System.out.println();
        postorder(node);
        System.out.println();
    }

    private BSTNode mirroeView(BSTNode node) {
        if (node == null || (node.left == null && node.rigth == null))
            return node;

        BSTNode temp = node.left;
        node.left = node.rigth;
        node.rigth = temp;

        mirroeView(node.left);
        mirroeView(node.rigth);
        return node;
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(BSTNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.rigth);
        }
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(BSTNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.rigth);
        }
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(BSTNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.rigth);
            System.out.print(node.data + " ");
        }
    }

    public boolean empty() {
        return root == null;
    }

}

public class BinarySearchTreeTest {
    public static void main(String[] l) {
        System.out.println("Weleome to Binary Search Tree");
        Scanner scanner = new Scanner(System.in);
        boolean yes = true;
        BinarySearchTree tree = new BinarySearchTree();
        do {
            System.out.println("\n1. Insert");
            System.out.println("2. Search Node");
            System.out.println("3. Count Node");
            System.out.println("4. Empty Status");
            System.out.println("5. Delete Node");
            System.out.println("6. Node with Minimum Value");
            System.out.println("7. Node with Maximum Value");
            System.out.println("8. Find Parent node");
            System.out.println("9. Count no of links");
            System.out.println("10. Get the sibling of any node");
            System.out.println("11. Print all the leaf node");
            System.out.println("12. Get the level of node");
            System.out.println("13. Depth of the tree");
            System.out.println("14. Height of Binary Tree");
            System.out.println("15. Left View");
            System.out.println("16. Mirror Image of Binary Tree");
            System.out.println("Enter Your Choice :: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter Value");
                        tree.insert(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Enter the node");
                    System.out.println(tree.searchNode(scanner.nextInt()));
                    break;

                case 3:
                    System.out.println(tree.countNodes());
                    break;

                case 4:
                    System.out.println(tree.empty());
                    break;

                case 5:
                    try {
                        System.out.println("Enter the node");
                        System.out.println(tree.delete(scanner.nextInt()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                case 6:
                    try {
                        System.out.println(tree.nodeWithMinimumValue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    try {
                        System.out.println(tree.nodewithMaximumValue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    try {
                        System.out.println("Enter the node");
                        System.out.println(tree.parent(scanner.nextInt()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 9:
                    try {
                        System.out.println(tree.countNodes() - 1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 10:
                    try {
                        System.out.println("Enter the node");
                        System.out.println(tree.sibling(scanner.nextInt()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 11:
                    try {
                        tree.leafNodes();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                case 12:
                    try {
                        System.out.println("Enter the node");
                        System.out.println("Level is : " + tree.level(scanner.nextInt()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 13:
                    try {
                        System.out.println(tree.depth());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 14:
                    try {
                        System.out.println(tree.height());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 15:
                    try {
                        tree.leftView();
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 16:
                    try {
                        tree.mirroeView();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                default:
                    break;
            }
            tree.preorder();
            System.out.println();
            tree.inorder();
            System.out.println();
            tree.postorder();
        } while (yes);
        scanner.close();
    }
}