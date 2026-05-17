//Top / Bottom / Left / Right - View of BT
import java.util.*;
public class qs5 {
    /*
  .. -2  -1  0   1  2 ....
             1
           /   \
          2     3
        /   \    \
       4     5    7
           /
          6

top view : 4 2 1 3 7

level order -> (vertical order line concept)
    : first node in each line


queue -> | 1,0 |
queue (node,line)

pop from queue --> node = 1, line = 0
check left/right

check in map on that line ....
in map on line =0 , is something ? ---> NO --> Put in MAP
map = | 0 -> 1 |
map (line,node)

node = 2
queue -> | 2,1 |
node = 3
queue -> | 3,1 |
         | 2,-1|





pop 2
map = |-1 -> 2 |
      | 0 -> 1 |
its left / right

node = 4
queue -> | 4,-2 |
         | 3,1  |

node = 5
queue -> | 5,0  |
         | 4,-2 |
         | 3,1  |






pop 3
map = | 1 -> 3 |
      |-1 -> 2 |
      | 0 -> 1 |
its left / right

node = 7
queue -> | 7,2  |
         | 5,0  |
         | 4,-2 |






pop 4
map = |-2 -> 4 |
      | 1 -> 3 |
      |-1 -> 2 |
      | 0 -> 1 |
its left / right
-> nothing





pop 5
5 is on line 0 --> but node=1 is already on line 0 --> SKIP
map = |-2 -> 4 |
      | 1 -> 3 |
      |-1 -> 2 |
      | 0 -> 1 |
its left / right
.
.
.
.
.

SO ON






----------------------------------------------------------------------

BOTTOM VIEW

for top view we are checking if line exists in map...
                if exists --> we skip adding in map
for bottom we need last node of each line --> overwrite each line



----------------------------------------------------------------------

LEFT VIEW

level order traversal -> first node
i == 0

----------------------------------------------------------------------

RIGHT VIEW

level order traversal -> last node
i == q.size - 1






     */

    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    public static class Pair {
        int line;
        Node node;

        public Pair(int line, Node node) {
            this.line = line;
            this.node = node;
        }
    }

    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>(); // line , node
        Queue<Pair> queue = new LinkedList<Pair>();
        //add root in queue
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int line = pair.line;
            Node node = pair.node;
            //if that line not present
            if (!map.containsKey(line)) {
                map.put(line, node.data);
            }
            //add left and right
            if (node.left != null) {
                queue.add(new Pair(line - 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Pair(line + 1, node.right));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(0, root));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int line = pair.line;
            Node node = pair.node;
            //overwrite the line
            map.put(line, node.data);
            //add left and right
            if (node.left != null) {
                queue.add(new Pair(line - 1, node.left));
            }
            if (node.right != null) {
                queue.add(new Pair(line + 1, node.right));
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    public static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i<size; i++) {
                Node node = queue.poll();
                //adding first node of every level
                if (i == 0) {
                    res.add(node.data);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    public static ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                //adding last node of every level
                if (i == size-1) {
                    res.add(node.data);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    /*
                       1
                     /   \
                    2     3
                  /   \     \
                 4     5     7
                      /
                     6
           */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> top = topView(root);
        System.out.println("Top View: ");
        for (int x : top) {
            System.out.print(x + " ");
        }
        System.out.println();
        ArrayList<Integer> bottom = bottomView(root);
        System.out.println("Bottom View: ");
        for (int x : bottom) {
            System.out.print(x + " ");
        }
        System.out.println();
        ArrayList<Integer> left = leftView(root);
        System.out.println("Left View: ");
        for (int x : left) {
            System.out.print(x + " ");
        }
        System.out.println();
        ArrayList<Integer> right = rightView(root);
        System.out.println("Right View: ");
        for (int x : right) {
            System.out.print(x + " ");
        }
    }
}
