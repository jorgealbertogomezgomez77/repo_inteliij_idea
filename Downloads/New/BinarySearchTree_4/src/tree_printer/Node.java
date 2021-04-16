package tree_printer;

import java.util.Scanner;

class Node {
	public int data;
	public Node left;
	public Node right;
	public Node(int data, Node left, Node right) {
		this.data = data;
		this.left = left;
		this.right=right;
	}
	public void prettyPrint(int height) {
		System.out.println(prettyPrint(this, 1, height));
	}
	private StringBuilder prettyPrint(Node root, int currentHeight, int totalHeight) {
		StringBuilder sb = new StringBuilder();
		int spaces = getSpaceCount(totalHeight-currentHeight + 1);
		if(root == null) {
			//create a 'spatial' block and return it
			String row = String.format("%"+(2*spaces+1)+"s%n", "");
			//now repeat this row space+1 times
			String block = new String(new char[spaces+1]).replace("\0", row);
			return new StringBuilder(block);
		}
		if(currentHeight==totalHeight) return new StringBuilder(root.data+"");
		int slashes = getSlashCount(totalHeight-currentHeight +1);
		sb.append(String.format("%"+(spaces+1)+"s%"+spaces+"s", root.data+"", ""));
		sb.append("\n");
		//now print / and \
		// but make sure that left and right exists
		char leftSlash = root.left == null? ' ':'/';
		char rightSlash = root.right==null? ' ':'\\';
		int spaceInBetween = 1;
		for(int i=0, space = spaces-1; i<slashes; i++, space --, spaceInBetween+=2) {
			for(int j=0; j<space; j++) sb.append(" ");
			sb.append(leftSlash);
			for(int j=0; j<spaceInBetween; j++) sb.append(" ");
			sb.append(rightSlash+"");
			for(int j=0; j<space; j++) sb.append(" ");
			sb.append("\n");
		}
		//sb.append("\n");

		//now get string representations of left and right subtrees
		StringBuilder leftTree = prettyPrint(root.left, currentHeight+1, totalHeight);
		StringBuilder rightTree = prettyPrint(root.right, currentHeight+1, totalHeight);
		// now line by line print the trees side by side
		Scanner leftScanner = new Scanner(leftTree.toString());
		Scanner rightScanner = new Scanner(rightTree.toString());
//		spaceInBetween+=1;
		while(leftScanner.hasNextLine()) {
			if(currentHeight==totalHeight-1) {
				sb.append(String.format("%-2s %2s", leftScanner.nextLine(), rightScanner.nextLine()));
				sb.append("\n");
				spaceInBetween-=2;
			}
			else {
				sb.append(leftScanner.nextLine());
				sb.append(" ");
				sb.append(rightScanner.nextLine()+"\n");
			}
		}

		return sb;

	}
	private int getSlashCount(int height) {
		if(height <= 3) return height -1;
		return (int) (3*Math.pow(2, height-3)-1);
	}
	private int getSpaceCount(int height) {
		return (int) (3*Math.pow(2, height-2)-1);
	}
	public void print() {
		inorder(this);
		System.out.println();
	}
	private void inorder(Node root) {
		if (root==null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	public int getHeight() {
		return getHeight(this);
	}
	private int getHeight(Node root) {
		if (root == null) return 0;
		return Math.max(getHeight(root.left), getHeight(root.right))+1;
	}
	@Override
	public String  toString() {
		return this.data+"";
	}
}
