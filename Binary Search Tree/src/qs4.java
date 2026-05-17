import java.util.Stack;

//BST Iterator
public class qs4 {
    /*
    next -> next ele in inorder order
    hasNext -> next ele exist?

Method - 1
store inOrder traversal and traverse through it

--------------------------

Method - 2
put inOrder in Stack
L root R




-> start form root
-> go to left and put in stack
-> when next() comes -> POP --> check if right exist ? -> YES ....
        Same process again ... got to right's left and put in stack



                  7
               /    \
              3      10
             / \     /
            2   6   9
           /   /   /
          1   5   8
             /
            4
starting from root --> go to left
    | 1 |
    | 2 |
    | 3 |
    | 7 |
    |---|

when next is called -> pop from stack and check whether that node have right

1) next -> 1 ---> 1 has right ? -> NO
    |   |
    | 2 |
    | 3 |
    | 7 |
    |---|

2) next -> 2 ---> 2 has right ? -> NO
    |   |
    |   |
    | 3 |
    | 7 |
    |---|

3) next -> 3 ---> 3 has right ? -> YES ---> go to right and put in STACK
    | 4 |
    | 5 |
    | 6 |
    | 7 |
    |---|

4) next -> 4 ---> 4 has right ? -> NO
    |   |
    | 5 |
    | 6 |
    | 7 |
    |---|

5)
6) next -> 6 ---> 6 has right ? -> NO
    |   |
    |   |
    |   |
    | 7 |
    |---|

7) next -> 7 ---> 7 has right ? -> YES ---> go to right and put in STACK
    | 8 |
    | 9 |
    | 10|
    | 7 |
    |---|
.
....
.
.
..
SO ON


-----------------------------------------------------------
for predecessor -> R root L (descending sorted
--------------------------------------------------------

     */
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static final Stack<Node> stack = new Stack<Node>();
    private static final Stack<Node> stack1 = new Stack<Node>();

    //if stack have something -> true
    public static boolean hasNext(){
        return !stack.isEmpty();
    }

    public static int next(){
        //pop from stack and if right exist push its left in stack
        Node node = stack.pop();
        if(node.right!=null){
            pushInStack(node.right);
        }
        return node.data;
    }

    public static void pushInStack(Node root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public static boolean hasPrevious(){
        return !stack1.isEmpty();
    }
    public static int nextDescending(){
        //pop from stack and if left exist push its right in stack
        Node node = stack1.pop();
        if(node.left!=null){
            pushInStackReverse(node.left);
        }
        return node.data;
    }
    public static void pushInStackReverse(Node root){
        while(root!=null){
            stack1.push(root);
            root = root.right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.left.left.left = new Node(1);
        root.left.right.left = new Node(5);
        root.left.right.left.left = new Node(4);
        root.right.left = new Node(9);
        root.right.left.left = new Node(8);
        pushInStack(root);
        System.out.println("BST Iterator Traversal:");
        while(hasNext()){
            System.out.print(next()+" ");
        }
        pushInStackReverse(root);
        System.out.println("\nDescending Order:");
        while(hasPrevious()){
            System.out.print(nextDescending() + " ");
        }
    }

}
