//Heap Sort
public class qs3 {
    /*
    TC = O(nLogN)
max heap -> ascending sorting
min heap-> descending sorting

MAX Heap -->

              70 (1)
            /    \
      (2) 60      55 (3)
         /  \
       45   50
      (4)   (5)

arr[] = *   70  60  55  45  50
idx     0   1   2   3   4   5

1) rootIdx pr hoga sbse bda element as it is max heap , SO
2) swap(root , last)
    arr[1] -> arr[n]
3) sbse bda last m aagya --> ye sahi jagah pahunch gya ab size--
4) basically us node ko hta diya last waali ko
    ab check jo root pr hai .. kya vo sahi position pr h apni ??

    -> root node ko correct position pr --> (heapify)

    |---------------------------------|
    | 2 STEPS -->                     |
    | --> swap(root,last)             |
    | --> root at correct position    |
    |---------------------------------|


              50 (1)
            /    \
      (2) 60      55 (3)
         /  \
       45   70
      (4)   (5)

arr[] = *   50  60  55  45  70
idx     0   1   2   3   4   5


size-- ==> mtlb us node ko hta diya
              50 (1)
            /    \
      (2) 60      55 (3)
         /
       45
      (4)

arr[] = *   50  60  55  45
idx     0   1   2   3   4


.... SO ON

     */

    public static void heapSort(int[] arr){
        int n=arr.length-1;
        int lastIdx=n;
        while (lastIdx>1){
            swap(arr,lastIdx,1); //root node at idx=1
            lastIdx--;
            heapify(arr,1);//root node at correct place
        }

    }

    public static void heapSort2(int[] arr){
        int n=arr.length-1;
        int lastIdx=n;
        while (lastIdx>1){
            swap(arr,lastIdx,1); //root node at idx=1
            lastIdx--;
            heapifyMin(arr,1);//root node at correct place
        }

    }

    public static void heapify(int arr[],int currIdx){
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
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int arr[]={-1,54,55,53,52,50};
        int arr1[]={-1,54,55,53,52,50};
        int n=arr.length;

        System.out.println("Array: ");
        for(int i=1;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();


        //build max heap first
        for(int i=n/2;i>0;i--){
            heapify(arr,i);
        }
        //build min heap first
        for(int i=n/2;i>0;i--){
            heapifyMin(arr1,i);
        }

        heapSort(arr);
        heapSort2(arr1);

        System.out.println("After heap Sort (Ascending): ");
        for(int i=1;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        System.out.println("After heap Sort (Descending): ");
        for(int i=1;i<n;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }
}
