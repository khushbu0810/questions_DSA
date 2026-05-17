//Merge 2 BST
public class qs5 {
    /*
if nodes overlap -> sum

        5                   10
       / \                 / \
      3   7               9   12
     /   / \             /    /
    2   6   8           4    11


both tree have value  -> sum
Merged :
        15
       /  \
      12   19
     /    /  \
    6    17   8

node(x) exist in only 1 tree -> x+0
both have nodes (x,y) -> x+y


     */
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
    public static Node mergeBST(Node root1, Node root2) {
        if(root1==null && root2==null){
            return null;
        }
        //one null
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }

        //both exist -> SUM
        Node newRoot = new Node(root1.data+root2.data);
        //go to left & right
        newRoot.left = mergeBST(root1.left,root2.left);
        newRoot.right = mergeBST(root1.right,root2.right);
        return newRoot;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
         /*
                Tree 1
                    5
                   / \
                  3   7
                 /   / \
                2   6   8
         */
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);
        /*
                Tree 2
                    10
                   /  \
                  9   12
                 /    /
                4    11
         */

        Node root2 = new Node(10);
        root2.left = new Node(9);
        root2.right = new Node(12);
        root2.left.left = new Node(4);
        root2.right.left = new Node(11);

        Node mergedRoot = mergeBST(root1, root2);
        System.out.println("Merged Tree Inorder:");
        inorder(mergedRoot);
    }
}
