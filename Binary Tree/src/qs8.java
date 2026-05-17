//Children Sum Property
public class qs8 {
    /*
value at any node = left node + right node
-> can add +1 to any node any number of times

     2                    45
   /   \                /    \
  35    10   ==>       35     10
 /  \   / \           /  \    / \
2    3 5   2         30   5  8   2

     40
   /   \
  10    20
 /  \   / \
2    5 30  40
node = 40
left + right = 30 < root ---> assign node value to left and right

     40
   /   \
  40    40
 /  \   / \
2    5 30  40
now node = 40 (which actually was 10)
left + right = 7 < node ---> assign node value to left and right

     40
   /   \
  40    40
 /  \   / \
40  40 30  40
now while coming back from leaf ...
assign left + right to node

     40
   /   \
  80    40
 /  \   / \
40  40 30  40
now node = 40 (which actually was 20)
left + right = 70 > node ---> assign sum value to node

     40
   /   \
  80    70
 /  \   / \
40  40 30  40
going back -->

    150
   /   \
  80    70
 /  \   / \
40  40 30  40



     */
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    public static void childrenSum(Node root){
        if (root==null){
            return;
        }
        int leftRightSum=0;
        if(root.left!=null){
            leftRightSum+=root.left.data;
        }
        if(root.right!=null){
            leftRightSum+=root.right.data;
        }
        //if root < left+right --> assign sum to root
        if(root.data<=leftRightSum){
            root.data=leftRightSum;
        }else{ //root > left+right --> assign root to left and right
            if(root.left!=null){
                root.left.data=root.data;
            }
            if(root.right!=null){
                root.right.data=root.data;
            }
        }
        childrenSum(root.left);
        childrenSum(root.right);
        //while backtracking assign child sum to root
        int childrenSum=0;
        if(root.left!=null){
            childrenSum+=root.left.data;
        }
        if(root.right!=null){
            childrenSum+=root.right.data;
        }
        //if not leaf node
        if(root.left != null || root.right != null){
            root.data = childrenSum;
        }
    }
    // inorder traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    /*

initially
        40
       /  \
     10    20
    / \    / \
   2   5  30  40


after children sum
          150
         /   \
       80     70
      /  \   /  \
     40  40 30  40


     */

    public static void main(String[] args) {
        Node root = new Node(40);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.left = new Node(30);
        root.right.right = new Node(40);
        System.out.println("Before Conversion:");
        inorder(root);
        childrenSum(root);
        System.out.println("\nAfter Conversion:");
        inorder(root);
    }
}
