//Binary Tree Traversal - Inorder/Postorder/Preorder/LevelOrder
//      (Using Recursion)

import java.util.*;

public class qs1 {
    /*
Full BT = each node have 2/0 children
Complete BT = all level are fully filled except last level (leaf nodes)
              last level has nodes on left side first.
Perfect BT = all leaf nodes are at same level
Balanced BT = height of tree at max = logN (N=nodes)
Degenerate Tree = straight tree in one line like a vertical linked list


                1
              /   \
             2     3
            / \   / \
           4   5 6   7

DFS ->
Inorder   (L Root R)    4 2 5 1 6 3 7
PreOrder  (Root L R)    1 2 4 5 3 6 7
PostOrder (L R Root)    4 5 2 6 7 3 1

BFS (level by level)    1 2 3 4 5 6 7
     */
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    //Root L R
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //L Root R
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //L R Root
    public static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    /*
queue

initially store root in queue
if left exist -> put in queue
if right exist -> put in queue

pop from queue and store in list


1) add root in queue
2) pop from queue
3) check its left and right


                1
              /   \
             2     3
            / \   / \
           4   5 6   7

--> add root node first
    queue = [1]
--> pop from queue and print root
        1 ,  left/right exist ? ---> YES ---> Add in queue
    queue = [2 3]
--> pop from queue and print root = 2
        2 ,  left/right exist ? ---> YES ---> Add in queue,
    queue = [4 5]

    pop from queue and print root = 3
        3 ,  left/right exist ? ---> YES ---> Add in queue
    queue = [4 5 6 7]
--> pop from queue and print root = 4
        4 ,  left/right exist ? ---> NO
    queue = [5 6 7]

    pop from queue and print root = 5
        5 ,  left/right exist ? ---> NO
    queue = [6 7]

    pop from queue and print root = 6
        6 ,  left/right exist ? ---> NO
    queue = [7]

    pop from queue and print root = 7
        7 ,  left/right exist ? ---> NO
    queue = [ ]

     */

    public static void levelOrder(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //pop from queue and check for its left and right
            Node curr = queue.poll();
            //print curr
            System.out.print(curr.data + " ");
            //add its left and right in queue if present
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        levelOrder(root);
    }


}
