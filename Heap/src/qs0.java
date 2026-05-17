//Priority Queue
import java.util.Collections;
import java.util.PriorityQueue;
public class qs0 {
    /*
    by default priority queue -> min heap
    for max heap pass a comparator
    Collections.reverseOrder();
     */
    public static void main(String[] args) {
        //MIN HEAP
        PriorityQueue<Integer> pqMin =new PriorityQueue<>();
        pqMin.add(4);
        pqMin.add(2);
        pqMin.add(5);
        pqMin.add(3);
        int n= pqMin.size();

        //this might not give sorted order
        for(int x: pqMin){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println();

        //for sorted order - peek()
        System.out.println("Min Heap (priority order):");
        while(!pqMin.isEmpty()){
            System.out.print(pqMin.poll()+" ");
        }
        System.out.println();
        System.out.println();


//.....................


        //MAX HEAP
        PriorityQueue<Integer> pqMax=new PriorityQueue<>(Collections.reverseOrder());
        pqMax.add(4);
        pqMax.add(2);
        pqMax.add(5);
        pqMax.add(3);

        //for sorted order - peek()
        System.out.println("Max Heap (priority order):");
        while(!pqMax.isEmpty()){
            System.out.print(pqMax.poll()+" ");
        }
    }
}
