//Find out how many times the array is rotated
public class qs3 {
    public static int minimumTimesRotation(int arr[]){
        int low=0;
        int high=arr.length-1;
        int ans=Integer.MAX_VALUE;
        int index=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            //if left sorted eliminate left after taking minimum
            if(arr[low]<=arr[mid]){
                //ans=Math.min(ans,arr[low]);
                if(arr[low]<ans){
                    index=low;
                    ans=arr[low];
                }
                low=mid+1;
            }else{
                //ans=Math.min(ans,arr[mid]);
                if(arr[mid]<ans){
                    index=mid;
                    ans=arr[mid];
                }
                high=mid-1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int arr[]={4,5,6,7,0,1,2};
        System.out.println("minimum times: "+minimumTimesRotation(arr));

    }
}
