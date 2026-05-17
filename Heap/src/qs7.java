import java.util.Arrays;
import java.util.PriorityQueue;

//Maximum Sum Combinations
public class qs7 {
    /*
arr1    arr2
find all j
arr1[i] > arr1[j]
 for those j index go in arr2[]
 arr2[j] --> sum of maximum k elements

arr1[] = 4  2   1   5   3  ,k=2
arr2[] = 10 20  30  40  50
output[] = {80, 30, 0, 80, 50}



arr1[i] > arr1[j]
arr1[] = 4  2   1   5   3
idx      0  1   2   3   4
         i  j   j       j
   j={1,2,4}
   find those j where arr[i] > arr[j]

arr2[] = 10 20  30  40  50
idx      0  1   2   3   4
            *   *       *
           maximum k elements -> max 2 elements = {30,50}
           sum = 80






arr1[i] > arr1[j]
arr1[] = 4  2   1   5   3
idx      0  1   2   3   4
            i   j
   j={2}
   find those j where arr[i] > arr[j]

arr2[] = 10 20  30  40  50
idx      0  1   2   3   4
                *
           maximum k elements -> max 2 elements = {30} only
           sum = 30





arr1[i] > arr1[j]
arr1[] = 4  2   1   5   3
idx      0  1   2   3   4
                i
  no one less than 1 SO -> sum=0





arr1[i] > arr1[j]
arr1[] = 4  2   1   5   3
idx      0  1   2   3   4
         j  j   j   i   j
   j={0,1,2,4}
   find those j where arr[i] > arr[j]

arr2[] = 10 20  30  40  50
idx      0  1   2   3   4
         *  *   *       *
           maximum k elements -> max 2 elements = {50,30} only
           sum = 80






arr1[i] > arr1[j]
arr1[] = 4  2   1   5   3
idx      0  1   2   3   4
            j   j       i
   j={1,2}
   find those j where arr[i] > arr[j]

arr2[] = 10 20  30  40  50
idx      0  1   2   3   4
            *   *
           maximum k elements -> max 2 elements = {20,30} only
           sum = 50


.
.
.
.
.
.
.....................
.......................
...........................
.................................
......................................

put (ele,idx) -> sort them on basis of 1st ele
arr1[] = {(4,0), (2,1), (1,2), (5,3), (3,4)}
sorted = {(1,2), (2,1), (3,4), (4,0), (5,3)}
(ele,idx)

arr2[] = 10 20  30  40  50
idx      0  1   2   3   4
store arr2 also in sorted array


------------------------------
sum ko minHeap mein store kraate jao taaki k=2 elements hi le ske
and sum se bhi hta do jo pop kiya hai.....
---------------------------------------


(arr1,idx,arr2)
sorted = {(1,2,30), (2,1,20), (3,4,50), (4,0,10), (5,3,40)}
            i
       iss arr1[i] se chota koi nahi hai, SO , sum = 0 , idx=2
| 0 |

sorted = {(1,2,30), (2,1,20), (3,4,50), (4,0,10), (5,3,40)}
                        i
      iss arr[i] se chota left side hoga, SO , sum = 30 , idx=1
|    |
| 30 |

sorted = {(1,2,30), (2,1,20), (3,4,50), (4,0,10), (5,3,40)}
                                i
      iss arr[i] se chota left side hoga, SO , sum = 30+20 , idx=4
| 20 |
| 30 |

sorted = {(1,2,30), (2,1,20), (3,4,50), (4,0,10), (5,3,40)}
                                            i
      iss arr[i] se chota left side hoga, SO , sum = 30+20+50 ->> sum-=pq.top() , idx=0
| 20 |                                             |    |
| 30 |                                             | 30 |
| 50 |   -> heap.size > k ---> pop topElement      | 50 |

sorted = {(1,2,30), (2,1,20), (3,4,50), (4,0,10), (5,3,40)}
                                                    i
      iss arr[i] se chota left side hoga, SO , sum = 30+ 50 , idx=3
| 10 |                                             |    |
| 30 |                                             | 30 |
| 50 |   -> heap.size > k ---> pop topElement      | 50 |



     */
    public static int[] maxSumCombination(int[] arr1, int[] arr2, int k) {
        int n=arr1.length;
        int[][] data = new int[n][3];
        //store (arr1[i], i, arr2[i]) at ith index
        for(int i=0;i<n;i++){
            data[i][0]=arr1[i];
            data[i][1]=i; //idx
            data[i][2]=arr2[i];
        }
        Arrays.sort(data,(a, b)->a[0]-b[0]); //according to arr1 elements as arr1 is stored in first
        PriorityQueue<Integer> sumPq = new PriorityQueue<>(); //minHeap
        int sum=0;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            int idx=data[i][1];
            //add arr2[i] in pq --> this contains sum
            res[idx]=sum;
            sumPq.add(data[i][2]);
            sum+=data[i][2];

            if(sumPq.size()>k){
                sum-=sumPq.poll();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 2, 1, 5, 3};
        int[] arr2 = {10, 20, 30, 40, 50};
        int k = 2;
        int[] ans = maxSumCombination(arr1, arr2, k);
        System.out.println(Arrays.toString(ans));
    }
}
