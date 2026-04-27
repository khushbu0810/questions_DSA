//Kth element of 2 sorted arrays
public class qs9 {
    /*
    arr1[]= [2 3 6 7 9]     arr2[]= [1 4 8 10]      k=4
       combined arr[] = [1 2 3 4 6 7 8 9 10]
       4th ele after merging => 4

    find l1 , l2 .... further no need for median
    max(l1,l2) -> kth ele

    LEFT            RIGHT
    (k ele)         (n-k ele)



k=7 , arr1[]=[6 ele] , arr2[]=[5 ele]
we take....
arr1[] -> 0 ele
arr2[] -> 5 ele

k=7, means we need  ele on left so if we take all ele from arr2 (5)
so we still need 2 ele from arr1 , we can't take 0 from arr1

all from arr2 then how much more needed -> k-n2
        -----------------------------------------
        | SO LOW CAN'T BE 0 -> low= max(0,k-n2)  |
        -----------------------------------------



k=2 , arr1[]=[6 ele] , arr2[]=[5 ele]
so, no need to pick 6 ele from arr1 as k=2 so 2 are enough

at max we have to match value of k on left if k is itself a smaller value
than size of array then no need to pick complete array we simply take MIN
        -----------------------------------------
        | SO High CAN'T BE n -> high= min(k,n1)  |
        -----------------------------------------


    */

    public static int kthElement(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        //first array always be smaller array
        if (n1 > n2) {
            return kthElement(nums2, nums1, k);
        }
        int n = n1 + n2;
        int low = Math.max(0, k-n2);
        int high = Math.min(n1, k);
        //elements required on left
        int left = k;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            if (mid1 < n1) {
                r1 = nums1[mid1];
            }
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }
            //possible case
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr1[]={2,3,45};
        int arr2[]={4,6,7,8};
        int k=4;
        System.out.println(kthElement(arr1,arr2,k));
    }

}
