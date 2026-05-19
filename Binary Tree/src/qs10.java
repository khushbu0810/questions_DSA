import java.util.HashMap;
import java.util.Map;

//Construct Unique Binary Trees
public class qs10 {
    /*
for unique
PreOder and PostOrder - NOT
InOrder and PreOrder  - YES
InOrder and PostOrder  - YES



inorder = [40 20 50 10 60 30]
preorder= [10 20 40 50 30 60]
        10
       /  \
     20    30
    /  \    /
   40  50  60

1) preOrder ka 1st node is -> root node
2) find this root in inOrder
            10
           /  \
     40,20,50  60,30
3) check 40,20,50 positions in preOrder 1st node is 20 -> root
            10
           /   \
         20    30
        /  \    /
      40    50 60
4) elements in right side ->
    1st -> root = preOrder[0]
    preOrder[0] + 1 -> leftSide start
    after leftTree finishes -> right start
    SO , rightStart = 1 + preStart + leftTreeSize







inorder = [40 20 50 10 60 30]
           is             ie
preorder= [10 20 40 50 30 60]
           ps             pe
          root
           |
           |----> find this root in inOrder


    ........... LEFT ................................................

inorder = [40 20 50 10 60 30]
           is       |     ie
                    |_ _ _ _->rootIdx
          <------->
          left tree = is to rootIdx-1  -> leftTreeSize

preorder= [10 20 40 50 30 60]
           ps             pe
          root
              <------>
              left tree -> stIdx= rootIdx+1 (ps+1)
                           endIdx= ps + leftTreeSize


    ........... RIGHT ................................................

inorder = [40 20 50 10 60 30]
           is       |     ie
                    |_ _ _ _->rootIdx
                       <---->
                         right tree = stIdx = rootIdx + 1

preorder= [10 20 40 50 30 60]
           ps             pe
          root
              <------> <---->
               left     right tree -> stIdx= rootIdx + leftTreeSize + 1



        10
       /  \
     20    30
    /  \    /
   40  50  60


-----------------------------------------------------------

1) postOrder -> last ele = root
2) find root in inOrder




     */
    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node inOrderPreOrder(int[] inOrder, int[] preOrder) {
        Map<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
        //put in map
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        return inOrderPreOrderHelper(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, inOrderMap);
    }

    public static Node inOrderPreOrderHelper(int[] inOrder, int inStart, int inEnd, int[] preOrder, int preStart, int preEnd, Map<Integer, Integer> inOrderMap) {
        if (inStart > inEnd || preStart > preEnd) {
            return null;
        }
        //preOrder 1st node -> root
        int rootValue = preOrder[preStart];
        Node root = new Node(rootValue);
        //find root in inOrder
        int rootIdx = inOrderMap.get(rootValue);
        // nodes in left subtree
        int leftSubtreeSize = rootIdx - inStart;
        //build left subtree
        root.left = inOrderPreOrderHelper(inOrder, inStart, rootIdx - 1, preOrder, preStart + 1, preStart + leftSubtreeSize, inOrderMap);
        //build right subtree
        /*
        preStart = root
        then preStart + 1 -> start left subtree
        when leftSubtree finishes --> then right start , SO after leftSubtreeSize
         */
        root.right = inOrderPreOrderHelper(inOrder, rootIdx + 1, inEnd, preOrder, preStart + leftSubtreeSize + 1, preEnd, inOrderMap);
        return root;
    }

    public static Node inOrderPostOrder(int[] inOrder, int[] postOrder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        //put in map
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        return inOrderPostOrderHelper(inOrder, 0, inOrder.length - 1, postOrder, 0, postOrder.length - 1, inOrderMap);
    }

    public static Node inOrderPostOrderHelper(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd, Map<Integer, Integer> inOrderMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        //last node of postOrder = root
        int rootValue = postOrder[postEnd];
        Node root = new Node(rootValue);
        //find root in inOrder
        int rootIdx = inOrderMap.get(rootValue);
        //leftSubtree size
        int leftSubtreeSize = rootIdx - inStart;
        //build left subTree
        root.left = inOrderPostOrderHelper(inOrder, inStart, rootIdx - 1, postOrder, postStart, postStart + leftSubtreeSize - 1, inOrderMap);
        //build right subTree
        root.right = inOrderPostOrderHelper(inOrder, rootIdx + 1, inEnd, postOrder, postStart + leftSubtreeSize, postEnd - 1, inOrderMap);
        return root;
    }

    // inorder traversal for checking
    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        int[] inOrder = {40, 20, 50, 10, 60, 30};
        int[] preOrder = {10, 20, 40, 50, 30, 60};
        int[] postOrder = {40, 50, 20, 60, 30, 10};
        Node root = inOrderPreOrder(inOrder, preOrder);
        printInOrder(root);
        System.out.println();
        Node root1 = inOrderPostOrder(inOrder, postOrder);
        printInOrder(root1);
    }
}
