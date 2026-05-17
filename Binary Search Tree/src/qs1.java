//Introduction to BST
public class qs1 {
    /*
    1) Left < root < right
    2) Left & Right should be BST individually

  ->  max node from Left < Root < min node from Right
             8
           /   \
          3     10
         / \      \
        1   6      14
           / \     /
          4   7   13



     */
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int[] minMax(Node root) {
        int min = minNode(root);
        int max = maxNode(root);
        return new int[]{min, max};
    }

    //minimum will lie in left part only
    public static int minNode(Node root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root=root.left;
        }
        return root.data;
    }

    //maximum will lie in right part only
    public static int maxNode(Node root) {
        if (root == null) {
            return -1;
        }
        while (root.right != null) {
            root=root.right;
        }
        return root.data;
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        int[] ans = minMax(root);
        System.out.println("Minimum Node = " + ans[0]);
        System.out.println("Maximum Node = " + ans[1]);
    }
}
