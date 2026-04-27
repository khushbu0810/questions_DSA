//Floor and Ceil
/*
floor -> largest no in array <= x
ceil -> smallest no in array >= x
 */
public class qs2 {
    public static int ceil(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        int ans=arr[arr.length-1];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target) {//possible answer
                ans=arr[mid];
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static int floor(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]<=target) {//possible answer
                ans=arr[mid];
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={10,20,30,40,50};
        System.out.println("ceil: "+ceil(arr,25)); //30
        System.out.println("floor: "+floor(arr,25)); //20
    }


}
