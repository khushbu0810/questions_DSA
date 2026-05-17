//Heapify -> Min / Max Heap
public class qs2 {
    /*
    TC = O(logN) -> heapify method
    convert given array to heap

--> place a node at its correct position in array/heap

arr[] = *   54  53  55  52  50
idx     0   1   2   3   4   5

              54 (1)
            /    \
      (2) 53      55 (3)
         /  \
       52   50
      (4)   (5)

    |-----------------------------------|
    | leaf node in CBT                  |
    | (n/2 + 1) idx --- to ---> n idx   |
    | n = total nodes                   |
    |-----------------------------------|

  1) leaf nodes need not be checked whether they are heap or not
        -> as they are single nodes , SO definitely HEAP
  2) idx=1 ---> idx= n/2 tk process kro and make this a heap
        parent < child --> swap

    --> leaf nodes k liye call krenge hi nahi
    --> leaf k baad sbse bda index p heapify call krenge .. kya vo sahi jagah pr hai?
    --> if parent < child se to largestIdx change hojayega na acc to 2 if conditions
    (see in code) --> SWAP



traverse from last

->
       52   50   53
all individually are heap

->
          55
        /   \
       52   50
also a Max heap

->
              54 (1)
            /    \
      (2) 55      53 (3)
         /  \
       52   50
      (4)   (5)
not a heap

leaf nodes -> 5/2 +1 ---> 5
                3 -> 5 idx
    leaf nodes at idx = 3,4,5




              54 (1)
            /    \
      (2) 55      53 (3)
         /  \
       52   50
      (4)   (5)


idx     1   2   3   4   5
        *   y   y   y   y

    now ab idx 1 pr pahunche and usko correct place pr leke jaana h

    --> SWAP
              55 (1)
            /    \
      (2) 54      53 (3)
         /  \
       52   50
      (4)   (5)


    |-----------------------------------|
    |   MIN HEAP ---->                  |
    |                                   |
    |         50 (1)                    |
    |       /    \                      |
    | (2) 52      53 (3)                |
    |    /  \                           |
    |  54   55                          |
    | (4)   (5)                         |
    |-----------------------------------|


     */

    //For max Heap
    public static void heapify(int[] arr, int currIdx){
        int n=arr.length;
        int largestIdx = currIdx;
        int leftChildIdx=2* currIdx;
        int rightChildIdx=2* currIdx +1;
        if(leftChildIdx<n && arr[largestIdx]<arr[leftChildIdx]){
            largestIdx =leftChildIdx;
        }
        if(rightChildIdx<n && arr[largestIdx]<arr[rightChildIdx]){
            largestIdx =rightChildIdx;
        }
        //found idx for swaping
        if(largestIdx != currIdx){
            swap(arr, largestIdx, currIdx);
            heapify(arr, largestIdx);
        }
    }

    //For min Heap
    // just checking someone smaller
    public static void heapifyMin(int[] arr, int currIdx){
        int n=arr.length;
        int smallestIdx = currIdx;
        int leftChildIdx=2* currIdx;
        int rightChildIdx=2* currIdx +1;
        if(leftChildIdx<n && arr[smallestIdx]>arr[leftChildIdx]){
            smallestIdx =leftChildIdx;
        }
        if(rightChildIdx<n && arr[smallestIdx]>arr[rightChildIdx]){
            smallestIdx =rightChildIdx;
        }
        //found idx for swaping
        if(smallestIdx != currIdx){
            swap(arr, smallestIdx, currIdx);
            heapifyMin(arr, smallestIdx);
        }
    }
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr ={-1,54,55,53,52,50};
        int[] arr1 ={-1,54,55,53,52,50};
        int n=arr.length;

        for(int i=1;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        for(int i=n/2;i>0;i--){
            heapify(arr,i);
        }
        for(int i=n/2;i>0;i--){
            heapifyMin(arr1,i);
        }

        System.out.println("After heapify: ");
        for(int i=1;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("After Min heapify: ");
        for(int i=1;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }
}
