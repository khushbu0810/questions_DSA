//Check if an BT represents a max heap
public class qs4 {
    public static boolean isMaxHeapArray(int[] arr){
        int n=arr.length;
        //last parent node -> (n-1)/2
        for(int i=1;i<n/2;i++){
            int left=2*i;
            int right=2*i+1;
            if(left < n && arr[left]>arr[i]){
                return false;
            }
            if(right < n && arr[right]>arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr={-1,30, 25, 20, 10, 15};
        System.out.println(isMaxHeapArray(arr));

    }
}
