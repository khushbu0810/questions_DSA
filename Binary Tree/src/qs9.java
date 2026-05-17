import java.util.*;

//Minimum Time Taken To BURN the BT from a Node
public class qs9 {
    /*
   ditto same as qs -> nodes at distance k

1 sec needed to burn nodes connected next on level
        1
       / \
      2   3
     /   / \
    4   5   6
     \
      7



node = 2    , time=0
2 can burn 1,4  time=1


parent se leaf nodes tk pahunche --> so leaf node further kisi ko burn nahi krega
--> no time increase

time will increase if new node is burned


     */
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }
    //map -> <currNode, itsParentNode>
    public static void buildParentMap(Node root, Map<Node, Node> map) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node currNode = q.poll();
            //if node ka left child is present then node becomes parent for left
            if (currNode.left != null) {
                map.put(currNode.left, currNode);
                q.add(currNode.left);
            }
            //same for right
            if (currNode.right != null) {
                map.put(currNode.right, currNode);
                q.add(currNode.right);
            }
        }
    }

    public static int burnTree(Node root, Node target) {
        Map<Node, Node> map = new HashMap<>();
        //build parent child map
        buildParentMap(root, map);
        Queue<Node> q = new LinkedList<>();
        Set<Node> vis = new HashSet<>();
        //add target initially in queue
        q.add(target);
        //mark it visited node
        vis.add(target);
        int time = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean burnNewNode=false;
            for (int i = 0; i < size; i++) {
                Node currNode = q.poll();
                //move its left / right and add in queue if not visited
                if (currNode.left != null && !vis.contains(currNode.left)) {
                    q.add(currNode.left);
                    vis.add(currNode.left);
                    burnNewNode=true;
                }
                if (currNode.right != null && !vis.contains(currNode.right)) {
                    q.add(currNode.right);
                    vis.add(currNode.right);
                    burnNewNode=true;
                }
                //moving up -> parent
                Node parent = map.get(currNode);//parent of curr node
                if (parent != null && !vis.contains(parent)) {
                    q.add(parent);
                    vis.add(parent);
                    burnNewNode=true;
                }
            }
            if(burnNewNode){
                time++;
            }
        }
        return time;
    }
    /*

        1
       / \
      2   3
     /   / \
    4   5   6
     \
      7

           */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.left.left.right = new Node(7);
        Node target = root.left;
        int ans = burnTree(root, target);

        System.out.println(ans);
    }
}
