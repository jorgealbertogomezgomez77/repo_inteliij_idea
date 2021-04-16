package tree_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TreePrinter {

	int N, height;
	Node root =  new Node(1,null,null);
	public static void main(String[] args) {
		new TreePrinter();
	}
	public TreePrinter() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			ArrayList<Node> q = new ArrayList<Node>();
			q.add(root);
			for(int i=0; i<N && !q.isEmpty(); i++) {
				String ab[] = br.readLine().split(" ");
				int a = Integer.parseInt(ab[0]);
				int b = Integer.parseInt(ab[1]);
				Node current = q.remove(0);
				if(a==-1) current.left = null;
				else {
					current.left = new Node(a,null,null);
					q.add(current.left);
				}
				
				if(b==-1) current.right=null;
				else {
					current.right = new Node(b,null,null);
					q.add(current.right);
				}
			}
			//root.print();
			height = root.getHeight();
			root.prettyPrint(height);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/*

11
2 3
4 -1
5 -1
6 -1
7 8
-1 9
-1 -1
10 11
-1 -1
-1 -1
-1 -1

2
2 -1
-1 -1

3
2 3
-1 -1
-1 -1

4
32 -1
3 4
-1 -1
-1 -1
-1 -1
-1 -1

4
2 -1
3 4
-1 -1
-1 -1
-1 -1
-1 -1

7
12 13
4 5
6 7
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1

7
12 13
14 15
16 17
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1

15
2 3
4 5
6 7
8 9
0 1
2 3
4 5
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1

15
12 13
24 25
26 27
38 39
30 31
32 33
34 35
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1

31
2 3
4 5
6 7
8 9
0 1
2 3
4 5
6 7
8 9
0 1
2 3
4 5
6 7
8 9
0 1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1

31
2 3
4 5
6 7
8 9
10 11
12 13
14 15
16 17
18 19
20 21
22 23
24 25
26 27
28 29
30 31
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1
-1 -1

*/
