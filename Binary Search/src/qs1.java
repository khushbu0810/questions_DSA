//Lower and upper bound

import java.util.Arrays;

/*
    lower bound
given number -> x
then arr[idx] >= x if no element then size of array

    upper bound
arr[idx] > x

idx can be my answer when arr[idx]>=x jbki or elements at some lower idxes exists that are >= x so this idx is possible answer

 */
public class qs1 {
    public static int lowerBound(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=target) {//possible answer
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int upperBound(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>target) {//possible answer
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[]={2,4,1,5,8,7};
        Arrays.sort(arr);
        for(int x:arr){
            System.out.print(x+" ");
        }
        System.out.println();
        System.out.println("lower bound: "+lowerBound(arr,2));
        System.out.println("upper bound: "+upperBound(arr,2));

    }
}
