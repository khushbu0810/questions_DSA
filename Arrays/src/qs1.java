import java.util.Arrays;

//Second Largest/Smallest
public class qs1 {
    /*
    1   2   4   7   7   5  =>  1    2   4   5   7   7
                                (largest =7) -> arr[n-1]
                                second Largest = 5 -> arr[n-2] * (WRONG)


start fron 2nd last element
for(int i=n-2 ---> i>0){
    if(arr[i]!=largest){ //if ele = largest skip that
        second=arr[i];
        break;
    }
}


===========================================================>>>>>>.

APPROACH - 2

if someone becomes largest then previous largest ==> second-largest
array p traverse kro if arr[i]>largest ----> second=largest && largest=arr[i]

but if any ele < largest then check if it is > second

    */
    public static int largestEle(int arr[]) {
        int largest = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }

    public static int[] secondOrderElements(int arr[]) {
        int secondLargest = secondLargest(arr);
        int secondSmallest = secondSmallest(arr);
        System.out.println("secondLargest & secondSmallest : ");
        return new int[]{secondLargest, secondSmallest};
    }

    public static int secondLargest(int arr[]) {
        int largest = arr[0];
        int second = -1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>largest){
                second = largest;
                largest = arr[i];
            }
            else if(arr[i]<largest && arr[i]>second){
                second = arr[i];
            }
        }
        return second;
    }

    public static int secondSmallest(int arr[]) {
        int smallest = arr[0];
        int second = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<smallest){
                second = smallest;
                smallest = arr[i];
            }
            else if(arr[i]!=smallest && arr[i]<second){
                second = arr[i];
            }
        }
        return second;

    }

    public static void main(String[] args) {
        int arr[] = {8,8,7,6,5};
        System.out.println(largestEle(arr));
        System.out.println(Arrays.toString(secondOrderElements(arr)));
    }
}
