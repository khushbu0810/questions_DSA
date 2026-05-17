import java.util.Stack;

//Iterative Traversal - Inorder/Postorder/Preorder/LevelOrder
public class qs2 {
    /*
-> put root in stack
-> pop from stack and print
-> if left right exist then add right then left for preorder
        (so that left remains at top)



Inorder ->
take node = root initially ....
if left exist then node becomes that left...
when nodes reaches null then start poping from stack

-> when left is null then pop print and go to right

            1
           / \
          2   3
         / \
        4   5

initially
stack =[]
node = root = 1

stack -> | 1 |
node=node.left = 2  --> !null --> push in stack

stack -> | 2 |
         | 1 |
node=node.left = 4  --> !null --> push in stack

stack -> | 4 |
         | 2 |
         | 1 |
node=node.left = (left of 4) = null --> nothing on left --> POP and print

POP - PRINT - RIGHT

stack -> |   |
         | 2 |
         | 1 |
pop = 4 -> print -> its right
node=node.right = (right of 4) = null --> nothing on right --> POP and print
ans = 4

stack -> |   |
         |   |
         | 1 |
node=node.right = (right of 2) = 5 --> !null --> push in stack
ans = 4 2

stack -> |   |
         | 5 |
         | 1 |
node=node.right = (right of 2) = 5 --> !null --> push in stack
ans = 4 2

stack -> |   |
         |   |
         | 1 |
node=node.left = (left of 5) = null --> nothing on left --> POP and print
ans = 4 2 5

stack -> |   |
         |   |
         |   |
node=node.right = (right of 5) = null --> nothing on right --> POP and print
ans = 4 2 5 1


...
.
.
.
.


POSTORDER ->

2 stacks
push left then right
pop from stack1 and add in stack2 and check if left and right exists








     */
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    //root L R
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //pop top and put its right then left in stack
            Node node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    //L root R
    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = root; //initially
        while (!stack.isEmpty() || (node != null)) {
            //if node is not null then push in stack and move its left side
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {//we reach leaf node
                //top element is left only --> print that then moves right
                node = stack.pop();
                System.out.print(node.data + " ");
                node = node.right;
            }
        }
    }

    //L R root
    public static void postOrderUsing2Stacks(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        if (root == null) {
            return;
        }
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    /*
            1
           / \
          2   3
         / \
        4   5

     */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        preOrder(root);
        System.out.println();
        inOrder(root);

    }
}
