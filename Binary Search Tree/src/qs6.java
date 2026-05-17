//Largest BST in Binary Tree
public class qs6 {
    /*

max node from left < Root < min node from right
 left have x nodes             right have y nodes
        SIZE OF BST = 1 + x + y

postOrder = L R root

[size,max,min]

leftMax < node < rightMin  --> TRUE
            --> size++
            --> update min/max to node
    if FALSE
        -> pass infinity to max/min for that node



          15
       /     \
      14     18
       \     / \
        17  16  19

[size,max,min]

    15
    /
   14 [2 , 17 , 14]  ---------------> leftMax = Infinity , rightMin = 17
    \
     17 [1 , 17 , 17]



                     18 [2 , 19 , 16] -----------> leftMax = 16 , rightMin = 19
                /          \                        16 < 18 < 19
    16 [1 , 16 , 16 ]    19 [1 , 19 , 19]



         15 [2, infinity , infinity]  -----------> leftMax = 17 , rightMin = 16
       /     \                      17 < 15 < 16 ---> WRONG (RIGHT OK
      14      18 [2, 19, 16]                                  LEFT NOT OK)
 [2, 17 , 14]

     */

    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    public static class Info{
        int min;
        int max;
        int size;
        public Info(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }

    static int largestBSTSize=0;

    public static Info largestBST(Node root) {
        if(root==null){
            return new Info(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        //postOrder -> L R root
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        //root --> leftMax < currNode < rightMin
        if(leftInfo.max < root.data && root.data < rightInfo.min){ //it is BST
            // min -> MIN(rightMin , curr)
            // max -> MAX(leftMax , curr)
            int currSize = leftInfo.size + rightInfo.size + 1;
            largestBSTSize = Math.max(largestBSTSize, currSize);
            int currMin = Math.min(root.data,leftInfo.min);
            int currMax = Math.max(root.data,rightInfo.max);
            return new Info(currMin,currMax,currSize);
        }else{
            //not BST
            return new Info(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
        }
    }

    public static void main(String[] args) {
          /*
                    50
                  /    \
                30      60
               /  \    /  \
              5   20  45   70
                           / \
                          65 80

        Largest BST:
                    60
                   /  \
                  45   70
                       / \
                      65 80

        Size = 5
         */
        Node root = new Node(50);
        root.left = new Node(30);
        root.right = new Node(60);
        root.left.left = new Node(5);
        root.left.right = new Node(20);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);
        largestBST(root);
        System.out.println("Largest BST Size = "+ largestBSTSize);
    }
}
