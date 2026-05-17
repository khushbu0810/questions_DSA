//Floor & Ceil in BST
public class qs2 {
    /*

ceil -> value>=key
node > key --> (possible) left side
node < key --> right side

floor -> value<=key
node > key --> left side
node < key --> (possible) right side

     */

    public static class Node {
        int data;
        Node left;
        Node right;
        public Node (int data) {
            this.data = data;
        }
    }
    public static int ceil(Node root,int key){
        int ceil=-1;
        while(root!=null){
            if(root.data == key){
                ceil=root.data;
                return ceil;
            }
            if(key>root.data){
                root=root.right;
            }else{ // =<
                ceil=root.data;
                root=root.left;
            }
        }
        return ceil;
    }

    public static int floor(Node root,int key){
        int floor=-1;
        while(root!=null){
            if(root.data == key){
                floor=root.data;
                return floor;
            }
            if(key>root.data){
                floor=root.data;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }
    /*
             8
           /   \
          3     10
         / \      \
        1   6      14
           / \     /
          4   7   13

     */
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
        System.out.println(ceil(root,13));
        System.out.println(floor(root,11));
    }
}