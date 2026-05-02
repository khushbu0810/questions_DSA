import java.util.ArrayList;

//Count Inversion
public class qs11 {
    /*
    5   3   2   4   1  , ans = 8
i < j && arr[i] > arr[j]
          left > right
ct = 8 pairs:
(5,3) (5,2) (5,4) (5,1) (3,2) (3,1) (2,1) (4,1)

2 3 5 6     2 2 4 4 8
  |_ x_ _ _ _ _y _|
         |
       (x,y) , x > y
    (3,2) (5,4) .....
 x from left array and y from right array such that x > y

    -------------------------------------------
    | -> if l > r --> all after l will be > r |
    | -> then put r in ans and r++            |
    | -> if l < r --> put l in ans and l++    |
    | -> if l/r crosses array then put left   |
    | elements from other array               |
    -------------------------------------------


ans = []
2   3   5   6           2   2   4   4   8
l                       r
 put l in ans and l++
ans = [2]



2   3   5   6           2   2   4   4   8
    l                   r
 l > r , all elements after l in arr1 will definitely > r
 (3,2) (5,2) (6,2)  ct = +3
 put r in ans and r++
ans = [2 , 2]



2   3   5   6           2   2   4   4   8
    l                       r
 l > r , all elements after l in arr1 will definitely > r
 (3,2) (5,2) (6,2)  ct = +3
 put r in ans and r++
ans = [2 , 2 , 2]



2   3   5   6           2   2   4   4   8
    l                           r
 l < r
 put l in ans and l++
ans = [2 , 2 , 2 , 3]



2   3   5   6           2   2   4   4   8
        l                       r
 l > r , all elements after l in arr1 will definitely > r
 (5,4) (6,4)  ct = +2
 put r in ans and r++
ans = [2 , 2 , 2 , 3 , 4]



2   3   5   6           2   2   4   4   8
        l                           r
 l > r , all elements after l in arr1 will definitely > r
 (5,4) (6,4)  ct = +2
 put r in ans and r++
ans = [2 , 2 , 2 , 3 , 4 , 4]



2   3   5   6           2   2   4   4   8
        l                               r
 l < r
 put l in ans and l++
ans = [2 , 2 , 2 , 3 , 4 , 4 , 5]



2   3   5   6           2   2   4   4   8
            l                           r
 l < r
 put l in ans and l++
ans = [2 , 2 , 2 , 3 , 4 , 4 , 5 , 6]



2   3   5   6           2   2   4   4   8
                l                       r
 l crosses arr1 so put left over elements in ans from arr2
ans = [2 , 2 , 2 , 3 , 4 , 4 , 5 , 6 , 8]



.
.
.
.
.
.
.
.
.
...........>>>>>>>>>>>

split array in 2 half
        5   3   2   4   1
        _ _ _ _ | _ _ _ _ _
        |                   |
    5   3   2             4    1
    _ _ | _ _           _ _ _|_ _ _ _
   |         |          |           |
 5   3       2          4           1
_ _|_ _ _
|        |
5        3


2 arrays [5] and [3]
          l       r
     l > r ---> ct =+1 and take r in ans and r++
     ans = [3]
        [5] and [3]
         l           r
    r comes out of boundary .. so take left over elements in ans
    ans = [3 , 5]



        5   3   2   4   1
        _ _ _ _ | _ _ _ _ _
        |                   |
    5   3   2             4    1
    _ _ | _ _           _ _ _|_ _ _ _
   |         |          |           |
 3   5       2          4           1

 2 arrays [3 , 5] and [2]
           l           r
     l > r ---> all ele after l will also be > r
        SO, ct =+2 and take r in ans and r++
     ans = [2]
        [3 , 5] and [2]
         l               r
    r comes out of boundary .. so take left over elements in ans
    ans = [2 , 3 , 5]



        5   3   2   4   1
        _ _ _ _ | _ _ _ _ _
        |                   |
    2   3   5             4    1
                       _ _ _|_ _ _ _
                       |           |
                       4           1
left half is completed ....
 2 arrays [4] and [1]
           l       r
     l > r ---> ct =+1 and take r in ans and r++
     ans = [1]
        [4] and [1]
         l           r
    r comes out of boundary .. so take left over elements in ans
    ans = [1 , 4]



        5   3   2   4   1
        _ _ _ _ | _ _ _ _ _
        |                   |
    2   3   5             1    4
right half is completed ....

 2 arrays are left is
            [2 , 3 , 5] and [1 , 4]
             l               r
     l > r ---> all ele after l will also be > r
        SO, ct =+3 and take r in ans and r++
     ans = [1]

            [2 , 3 , 5] and [1 , 4]
             l                   r
     l < r --> take l in ans and l++
     ans = [1 , 2]

            [2 , 3 , 5] and [1 , 4]
                 l               r
     l < r --> take l in ans and l++
     ans = [1 , 2 , 3]

            [2 , 3 , 5] and [1 , 4]
                     l           r
     l > r --> take r in ans and r++
     ans = [1 , 2 , 3 , 4]

            [2 , 3 , 5] and [1 , 4]
                     l               r
     l > r --> take r in ans and r++
     r comes out of boundary ... so take left over elements in ans
     ans = [1 , 2 , 3 , 4 , 5]

     -------------------------------------
    |       [2 , 3 , 5]      [1 , 4]     |
    |       low     mid    mid+1  high   |
    |       left           right         |
    | nos on Left -> mid - left + 1      |
    -------------------------------------

     */

    public static int ct=0;

    public static int countInversion(int arr[]){
        //when right<left ----> just set ct = mid-left+1 (in algo)
        mergeSortAlgo(arr,0,arr.length-1);
        return ct;
    }

    public static void mergeSortHelper(int arr[],int low,int mid,int high){
        ArrayList<Integer>ans=new ArrayList<>();
        int left=low;
        int right=mid+1; //starting idx of right half of array
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                ans.add(arr[left]);
                left++;
            }else{
                //right < left
                ans.add(arr[right]);
                ct+=(mid-left+1);
                right++;
            }
        }
        //elements on left side are left
        while(left<=mid){
            ans.add(arr[left]);
            left++;
        }
        //elements on right are left
        while(right<=high){
            ans.add(arr[right]);
            right++;
        }
        //transfer elements from list to array
        for(int i=low;i<=high;i++){
            arr[i]=ans.get(i-low);
        }
    }
    public static void mergeSortAlgo(int arr[],int low,int high) {
        if(low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortAlgo(arr,low,mid);
        mergeSortAlgo(arr,mid+1,high);
        mergeSortHelper(arr,low,mid,high);
    }

    public static void main(String[] args) {
        int arr[]={5,3,2,4,1};
        System.out.println(countInversion(arr));
    }
}
