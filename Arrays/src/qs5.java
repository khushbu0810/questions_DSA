import java.util.HashMap;

//Longest Subarray With Sum K (POSITIVES)
public class qs5 {
    /*
    subarray -> contiguous part
    1   2   3   1   1   1   1   4   2   3  , sum(k) = 3

METHOD - 1 (Generate all subarrays)

i=0 (starting from ele 1)------------>
j -> x ===>> till idx x
    j=0 1
    j=1 1   2
    j=2 1   2   3
    j=3 1   2   3   1
......SO on

i=1 (starting from ele 2)
2
2   3
2   3   1
2   3   1   1
.........So on

......SO ON

    -------------------------------------------------
    |    SUM OF ALL SUBARRAYS ====>                 |
    |    for(int i=0;i<n;i++){                      |
    |        for(int j=i;j<n;j++){                  |
    |            for(int k=i;k<=j;k++){             |
    |                sum+=arr[k];                   |
    |            }                                  |
    |            if(sum==k){                        |
    |                maxLen=Max(maxLen,j-i+1);      |
    |            }                                  |
    |        }                                      |
    |    }                                          |
    -------------------------------------------------


=============================================================== > > > > >

METHOD - 2 (Prefix sum)

prefixSum at idx i => sum till idx i

a   b   c   d   e   f   g   h
--------------- *
sum = X till *

subarrays with e as last element
                e
            d   e
        c   d   e ---> let sum = k
    b   c   d   e
a   b   c   d   e

some subarray have sum = k with e as last element

        ---------------------------------------
        |  <----------- sum = x -------->      |
        |  a   b   c   d   e   f   g   h       |
        |  -----  <--------->                  |
        |   x-k         k                      |
        ---------------------------------------

 if I found subarray with sum x-k then
 uske baad wala subaraay will have sum = k



sum(k) = 3
            1   2   3   1   1   1   1   4   2   3
    idx     0   1   2   3   4   5   6   7   8   9
    sum     1   3   6   7   8   9   10  14
                k
            we are looking for sum k = 3
            1 2 ---> gives sum=3
            1 2 3 ---> gives sum=6
                    (do we get some sum=3 before ???)
                    middle mein sum 3 hone k liye kya starting mein koi
                    hai with sum 3 ??

                                ==>>>> YES

            1 2 3 1 --> gives sum=7
                    beech mein koi sum 3 k liye kya phle 7-3 = 4
                    sum = 4 exist krta hai???

                                ==>>>> NO

|   ,   |
|   ,   |
|   ,   |
| 10,6  | 10 - x = 3(k) -> x=7 ? YES ---> at idx=3, newSubarrayLen = 3
|  9,5  | 9 - x = 3(k) -> x=6 ? YES  ---> at idx=2, newSubarrayLen = 3
|  8,4  | 8 - x = 3(k) -> x=5 ? NO
|  7,3  | 7 - x = 3(k) -> x=4 ? NO
|  6,2  | 6 - x = 3(k) -> x=3 ? YES ---> at idx=1, newSubarrayLen = 1
|  3,1  | ---> len = 2
|  1,0  |
---------
(currSum,idx)

currSum - x = k
kya koi x exist krta hai phle ??

SO abhi newSubarrayLen = total Length till that idx - x ka length


ZERO'S CASE =====----====>>

        2   0   0   3 , k=3
idx     0   1   2   3
sum     2   2   2   5
longest subarray is
        =>  0   0   3

but according to above logic..
|  2,0  |  ->  2,1  ->  2,2
---------

|       |
|  5,3  | 5 - x = 3(k) -> x=2 ? YES ---> at idx=2, newSubarrayLen = 1
|  2,2  |
---------

        ---------------------------------------------------------------
        | 0   0   3  ==>> valid subArray with sum = 3 , have length=3 |
        | but Zeros index got overridden .....                        |
        | SO update index in map only when 0 are not there            |
        | agr 0 hai --> sum already map mein hoga So don't update idx |
        ---------------------------------------------------------------


=============================================================== > > > > >

METHOD - 3 (2 Pointer)
sum = k move right
sum>k move left

            ----------------
            | length=r-l+1 |
            ----------------
arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
        l
        r
sum = 1  len = 0    (initially)
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
        l
            r
sum = 3  len = 0
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
        l
                r
sum = 6  len = 3
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
        l
                    r
sum = 7  len = 3
----------------------------------------------------
| now sum > k (if we move right sum only increase) |
| NOW, start moving l so that size decrease        |
----------------------------------------------------
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
            l
                    r
sum = 6  len = 3
    ----------------------------
    | again we reach sum = k , |
    | So start moving r again  |
    ----------------------------
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
            l
                        r
sum = 7  len = 3
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                l
                        r
sum = 5  len = 3
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                l
                            r
sum = 6  len = 4
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                l
                                r
sum = 7  len = 4
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                    l
                                r
sum = 4  len = 4
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                    l
                                    r
sum = 7  len = 4
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                        l
                                    r
sum = 6  len = 4
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                        l
                                        r
sum = 9  len = 4
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                            l
                                        r
sum = 8  len = 4
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                                l
                                        r
sum = 7  len = 4
_________________->

arr[] = 1   2   3   1   1   1   1   3   3  , k=6
idx     0   1   2   3   4   5   6   7   8
                                    l
                                        r
sum = 6  len = 4(max)





     */

    public static int longestSubarrayWithSumK(int arr[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sumTillIndex = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sumTillIndex += arr[i];
            if (sumTillIndex == k) {
                maxLength = Math.max(maxLength, i + 1);
            }
            //x=remainingSum -> currSum - k
            int remainingSum = sumTillIndex - k;
            if (map.containsKey(remainingSum)) {
                //len = currIndex-prevIndex
                int length = i - map.get(remainingSum);
                maxLength = Math.max(maxLength, length);
            }
            //add sum/ update index in map if not 0 (
            if (!map.containsKey(sumTillIndex)) {
                map.put(sumTillIndex, i);
            }
        }
        return maxLength;
    }

    public static int longestSubarrayWithSumK2Pointer(int arr[], int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int sum = arr[0];
        while (right < arr.length) {
            //first move to right then add
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }
            if (sum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            right++;
            if (right < arr.length) {
                sum += arr[right];
            }
        }
        return maxLength;
    }


    public static void main(String[] args) {
        int arr[] = {1,2,3,1,1,1,1,3,3};
        int k = 6;
        System.out.println(longestSubarrayWithSumK(arr, k));
        System.out.println(longestSubarrayWithSumK2Pointer(arr, k));
    }
}
