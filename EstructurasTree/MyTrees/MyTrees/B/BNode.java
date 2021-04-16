package MyTrees.B;

class BNode{
    int data;
    BNode left, right;

    public BNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BST {
    static BNode root;

    public int add(int value){
        BNode newNode, current;

        newNode = new BNode(value);
        if(root == null){
            root = newNode;
            current = root;
        }
        else{
            current = root;
            while(current.left != null || current.right != null){
                if(newNode.data < current.data){
                    if(current.left != null)
                        current = current.left;
                    else
                        break;
                }
                else{
                    if(current.right != null)
                        current = current.right;
                    else
                        break;
                }
            }
            if(newNode.data < current.data)
                current.left = newNode;
            else
                current.right = newNode;
        }

        return value;
    }

    public void inorder(BNode root){
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    public boolean find(int value){
        boolean flag = false;
        BNode current;
        current = root;
        while(current!= null){
            if(current.data == value){
                flag = true;
                break;
            }
            else if(current.data > value)
                current = current.left;
            else
                current = current.right;
        }
        System.out.println("Is "+value+" present in tree? : "+flag);
        return flag;
    }

    public void successor(int value){
        BNode current;
        current = root;

        if(find(value)){
            while(current.data != value){
                if(value < current.data && current.left != null){
                    System.out.println("Node is: "+current.data);
                    current = current.left;
                }
                else if(value > current.data && current.right != null){
                    System.out.println("Node is: "+current.data);
                    current = current.right;
                }
            }
        }
        else
            System.out.println(value+" Element is not present in tree");
    }

    public static void main(String[] args) {

        BST b = new BST();
        b.add(50);
        b.add(30);
        b.add(20);
        b.add(40);
        b.add(70);
        b.add(60);
        b.add(80);
        b.add(90);

        b.inorder(root);
        b.find(30);
        b.find(90);
        b.find(100);
        b.find(50);

        b.successor(90);
        System.out.println();
        b.successor(70);
    }

}
