package MyTrees.A;

import java.util.Scanner;

class Node {
    Integer data;
    Node left;
    Node right;
    Node()
    {
        data = null;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node head;
    Scanner input = new Scanner(System.in);
    BinaryTree() {
        head = null;
    }

    public void createNode(Node temp,Node newnode) {

        if(head==null) {
            System.out.println("No value exist in tree, the value just entered is set to Root");
            head = newnode;
            return;
        }
        if(temp==null)
            temp = head;

        System.out.println("where you want to insert this value, l for left of ("+temp.data+") ,r for right of ("+temp.data+")");
        char inputValue=input.next().charAt(0);
        if(inputValue=='l') {
            if(temp.left==null) {
                temp.left=newnode;
                System.out.println("value got successfully added to left of ("+temp.data+")");
                return;
            }
            else {
                System.out.println("value left to ("+temp.data+") is occupied 1by ("+temp.left.data+")");
                createNode(temp.left,newnode);
            }
        }
        else if(inputValue=='r') {
            if(temp.right==null) {
                temp.right=newnode;
                System.out.println("value got successfully added to right of ("+temp.data+")");
                return;

            }
            else {
                System.out.println("value right to ("+temp.data+") is occupied by ("+temp.right.data+")");
                createNode(temp.right,newnode);
            }
        }
        else {
            System.out.println("incorrect input plz try again , correctly");
            return;
        }
    }

    public Node generateTree() {
        int [] a = new int[10];
        int index = 0;
        while(index<a.length) {
            a[index]=getData();
            index++;
        }
        if(a.length==0 ) {
            return null;
        }
        Node newnode= new Node();
        /*newnode.left=null;
        newnode.right=null;*/
        return generateTreeWithArray(newnode,a,0);
    }

    public Node generateTreeWithArray(Node head,int [] a,int index) {

        if(index >= a.length)
            return null;
        System.out.println("at index "+index+" value is "+a[index]);
        if(head==null)
            head= new Node();
        head.data = a[index];
        head.left=generateTreeWithArray(head.left,a,index*2+1);
        head.right=generateTreeWithArray(head.right,a,index*2+2);
        return head;
    }

    public Integer getData() {
        System.out.println("Enter the value to insert:");
        return (Integer)input.nextInt();
    }

    public void print() {
        inorder(head);
    }
    public void inorder(Node node) {
        if(node!=null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
        else
            return;
    }
}

public class BinaryTreeWorker {
    static BinaryTree treeObj = null;
    static Scanner input = new Scanner(System.in);
    public static void displaymenu() {
        int choice;
        do {
            System.out.print("\n Basic operations on a tree:");
            System.out.print("\n 1. Create tree  \n 2. Insert \n 3. Search value \n 4. print list\n 5. generate a tree \n Else. Exit \n Choice:");
            choice = input.nextInt();

            switch(choice) {
                case 1:
                    treeObj = createBTree();
                    break;
                case 2:
                    Node newnode= new Node();
                    newnode.data = getData();
                    newnode.left=null;
                    newnode.right=null;
                    treeObj.createNode(treeObj.head,newnode);
                    break;
                case 3:
                    //searchnode();
                    break;
                case 4:
                    System.out.println("inorder traversal of list gives follows");
                    treeObj.print();
                    break;
                case 5:
                    Node tempHead = treeObj.generateTree();
                    System.out.println("inorder traversal of list with head = ("+tempHead.data+")gives follows");
                    treeObj.inorder(tempHead);
                    break;
                default:
                    return;
            }
        }
        while(true);
    }

    public static Integer getData() {
        System.out.println("Enter the value to insert:");
        return (Integer)input.nextInt();
    }

    public static BinaryTree createBTree() {
        return new BinaryTree();
    }

    public static void main(String[] args) {
        displaymenu();
    }
}