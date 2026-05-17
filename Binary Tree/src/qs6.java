//Symmetric BT - Mirror Image around center
public class qs6 {
    /*

left and right exchange places
root L R --> root R L

start from root.left and root.right
if same --> move to left/right



     */
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isSymmetric(Node root) {
        if(root==null){
            return true;
        }
        return isSymmetricHelper(root.left,root.right);
    }
    public static boolean isSymmetricHelper(Node left, Node right) {
        //both null
        if(left == null && right == null){
            return true;
        }
        //one null
        if(left == null || right == null){
            return false;
        }
        if(left.data!=right.data){
            return false;
        }
        return isSymmetricHelper(left.left,right.right) && isSymmetricHelper(left.right,right.left);
    }
/*
            1
          /   \
         2     2
        / \   / \
       3   4 4   3

 */
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(2);

        root.left.left = new Node(3);
        root.left.right = new Node(4);

        root.right.left = new Node(4);
        root.right.right = new Node(3);


        System.out.println(isSymmetric(root));
    }
}
