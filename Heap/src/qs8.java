import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Minimum Cost To Connect Sticks
public class qs8 {
    /*
    cose of connecting 2 ropes = sum of their lengths

arr[] = 2   5   4   8   6   9

if sbse bdi length baar baar add hogi to ans max aayega
-> start with minimum length ..
take 2 minimum ropes from array and put sum in array
in place of their length.

add in pq -> 2   5   4   8   6   9
take 2 ropes -> 2,4  cost = 6   [5  6   8   6   9]
take 2 ropes -> 5,6  cost = 11  [11   8   6   9]
take 2 ropes -> 6,8  cost = 14  [11   14   9]
take 2 ropes -> 11,9 cost = 20  [20   14]
take 2 ropes -> 20,14 cost = 34  [34]
                     COST = 85



     */
    public static int connectSticks(List<Integer> sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : sticks) {
            pq.add(x);
        }
        int minCost = 0;
        while (pq.size() > 1) {
            //take 2 minimum ropes -> top 2 ele
            int first = pq.poll();
            int second = 0;
            if (!pq.isEmpty()) {
                second = pq.poll();
            }
            int cost = first + second;
            minCost += cost;
            pq.add(cost);
        }
        return minCost;
    }

    public static void main(String[] args) {
        List<Integer> sticks = new ArrayList<>();
        sticks.add(2);
        sticks.add(5);
        sticks.add(4);
        sticks.add(8);
        sticks.add(6);
        sticks.add(9);
        int ans=connectSticks(sticks);
        System.out.println(ans);
    }
}
