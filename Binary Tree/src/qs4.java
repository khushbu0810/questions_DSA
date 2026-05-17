import java.util.*;

public class qs4 {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node(int data) {
            this.data = data;
        }
    }

    public List<List<Integer>> verticalTraversal(Node root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        //  (  vertical ,   level       ,  nodes in that level)
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.add(new Tuple(root, 0, 0));
        while (!queue.isEmpty()) {
            Tuple currPollTupleFromQueue = queue.poll();
            Node currNode = currPollTupleFromQueue.node;
            int level = currPollTupleFromQueue.level;
            int vertical = currPollTupleFromQueue.vertical;
            //create vertical if absent
            if (!map.containsKey(vertical)) {
                map.put(vertical, new TreeMap<>());
            }
            //create level if absent
            if (!map.get(vertical).containsKey(level)) {
                map.get(vertical).put(level, new PriorityQueue<>());
            }
            //add node value in PQ
            map.get(vertical).get(level).add(currNode.data);
            //left child
            if (currNode.left != null) {
                queue.add(new Tuple(currNode.left, vertical - 1, level + 1));
            }
            //right child
            if (currNode.right != null) {
                queue.add(new Tuple(currNode.right, vertical + 1, level + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        //traverse vertical wise
        for (TreeMap<Integer,
                PriorityQueue<Integer>> levelMap : map.values()) {
            List<Integer> list = new ArrayList<>();
            //traverse level wise
            for (PriorityQueue<Integer> pq : levelMap.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            ans.add(list);
        }
        return ans;
    }

    public class Tuple {
        Node node;
        int vertical;
        int level;

        Tuple(Node node, int vertical, int level) {
            this.node = node;
            this.vertical = vertical;
            this.level = level;
        }
    }
}
