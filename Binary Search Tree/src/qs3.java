//Inorder Successor
public class qs3 {
    /*
    value next greater to node
Method - 1
Store Inorder then find greater than given node

------------------------------------
Method - 2

node = 8
              5
           /    \
          3       7
         / \     / \
        2   4   6   9
       /           / \
      1           8  10

root < node ---> everything on left can't be successor for 8 (root is less than root)








     */
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int inOrderSuccessor(Node root, Node key) {
        int successor = -1;
        while (root != null) {
            if (root.data <= key.data) {
                root = root.right;
            } else {
                //can be possible successor
                successor = root.data;
                root = root.left;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        /*
              5
           /    \
          3       7
         / \     / \
        2   4   6   9
       /           / \
      1           8  10

         */
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);
        root.right.left = new Node(6);
        root.right.right = new Node(9);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(10);
        Node key = root.right.right.left; // node 8
        int ans = inOrderSuccessor(root, key);
        System.out.println("Inorder Successor of " + key.data + " = " + ans);
    }
}
