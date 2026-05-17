import java.util.ArrayList;
import java.util.List;

//Boundary Traversal - antiClockwise
public class qs3 {
    /*
                1
              /   \
             2     7
            /       \
           3         8
            \       /
             4     9
            / \   / \
           5   6 10 11
---------->
          |
    <-----|

1) Left boundary excluding leaf
    (if left == null --> go to right)
2) leaf nodes -> INORDER TRAVERSAL
3) right boundary excluding leaf in reverse Order

push root in queue
| 1 |
if left exists put in queue
| 2 |
| 1 |


| 3 |
| 2 |
| 1 |
if left not exist --> go to right


| 4 |
| 3 |
| 2 |
| 1 |
4 left is 5 --> leaf node (excluding)

SO LEFT BOUNDARY TRAVERSAL is DONE

Inorder ->
traverse the tree and if leaf node then add in queue
| 11|
| 10|
| 6 |
| 5 |
| 4 |
| 3 |
| 2 |
| 1 |



RIGHT BOUNDARY TRAVERSAL
go to right of root
| 7 |
if right exist add in queue
| 8 |
| 7 |
if right not exist --> go to left


| 9 |
| 8 |
| 7 |
right of 9 is 11 --> leaf node (excluding)



pop from right queue and push in left queue

| 7 |
| 8 |
| 9 |
| 11|
| 10|
| 6 |
| 5 |
| 4 |
| 3 |
| 2 |
| 1 |

     */
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean isLeafNode(Node root) {
        return root.left == null && root.right == null;
    }

    public static void leftBoundary(Node root,List<Integer> ans) {
        Node curr=root.left;
        while (curr != null) {
            //add in list if curr is not leaf node
            if(!isLeafNode(curr)){
                ans.add(curr.data);
            }
            if(curr.left!=null){
                curr=curr.left;
            }else{
                curr=curr.right;
            }
        }
    }

    public static void rightBoundary(Node root,List<Integer> ans){
        ArrayList<Integer> temp = new ArrayList<>();
        Node curr=root.right;
        while (curr != null) {
            if(!isLeafNode(curr)){
                temp.add(curr.data);
            }
            if(curr.right!=null){
                curr=curr.right;
            }else{
                curr=curr.left;
            }
        }
        //add in list from temp
        //traverse temp from back so that ele added in reverse order in list
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }

    public static void leafNode(Node node,List<Integer> ans) {
        if(isLeafNode(node)){
            ans.add(node.data);
            return;
        }
        if(node.left!=null){
            leafNode(node.left,ans);
        }
        if(node.right!=null){
            leafNode(node.right,ans);
        }
    }

    public static List<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        //add root initially
        if(!isLeafNode(root)){
            ans.add(root.data);
        }
        leftBoundary(root,ans);
        leafNode(root,ans);
        rightBoundary(root,ans);
        return ans;
    }

    public static void main(String[] args) {
        /*
                        1
                      /   \
                     2     7
                    /       \
                   3         8
                    \       /
                     4     9
                    / \   / \
                   5   6 10 11
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(7);

        root.left.left = new Node(3);

        root.left.left.right = new Node(4);

        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);

        root.right.right = new Node(8);

        root.right.right.left = new Node(9);

        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        List<Integer> ans = boundaryTraversal(root);
        for(int x:ans){
            System.out.print(x+" ");
        }

    }
}
