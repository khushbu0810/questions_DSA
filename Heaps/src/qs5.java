//Convert Min Heap to Max Heap
public class qs5 {
    /*
    treat given array as normal array
     */
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
    public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr ={-1,-5, -4, -3, -2, -1};
        int n=arr.length;

        System.out.println("Min heap: ");
        for(int i=1;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        for(int i=n/2;i>0;i--){
            heapify(arr,i);
        }

        System.out.println("Max heap: ");
        for(int i=1;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
