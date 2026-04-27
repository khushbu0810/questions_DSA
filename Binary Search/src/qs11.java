//Matrix Median
public class qs11 {
    /*
    given a Row-wise sorted matrix with odd no of integers

    1   5   7   9   11
    2   3   4   5   10
    9   10  12  14  16

LOW HIGH ====>
     -------------------------------------------------
    | matrix is row wise sorted like ---------        |
    | so in each row 1st ele is lowest ,              |
    | SO go through first col and find lowest of all  |
    | ||ly go through last col and find largest       |
     -------------------------------------------------

    n*m elements -> middle ele:(n*m)/2

    1   2   3   4   5   5   7     9    9   10  10  11  12  14  16
                                median

RANGE -> lowest ele to highest ele

        1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16
<= ele  1   2   3   4   6   6   7   7   9   11  12  13  13  14  14  15
(no. of elements <= this ele)

    -------------------------------------
    | n*m elements -> 5*3 =15           |
    | median -> n*m/2 -> 15/2 = 7.5 ->  |
    | 8th elements is median            |
    -------------------------------------
            ||
    no. of elements <= median ====> >7
    first index of ele greater than 7


ele     1   2   3   4   5   6   7   8   9   10  11  12  13  14  15  16
<= ele  1   2   3   4   6   6   7   7   9   11  12  13  13  14  14  15
(ct)   low                         mid                              high

at this mid 7 elements <= 8 but we need more than 7 elements,
So eliminate left half -> low=mid+1
(ct < =7 ----> eliminate left half ) else right half eliminate




every row is sorted ->
we need how many elements are <= x ->
upperBound(x) -> first index of greater than x let say 3 ->
        3 elements must be less than x yaani idx = 0,1,2

=============================================================>>>>>>

in first row i.e mat[0] -> upperBound(8) -> first ele >8 = 9 , idx=3
(SO FIRST ROW HAS 3 ELEMENTS <= 8)  ->  on 0th row = 3 elements

in mat[1] -> upperBound(8) -> ele >8 = 10 , idx=4
(SO SECOND ROW HAS 4 ELEMENTS <= 8)  ->  on 1st row = 4 elements

in mat[2] -> upperBound(8) -> ele >8 = 9 , idx=0
(SO THIRD ROW HAS 0 ELEMENTS <= 8)  ->  on 3rd row = 0 elements

----------------------------------------------------------
| Condition        | Meaning           | Action          |
| ---------------- | ----------------- | --------------- |
| count ≤ required | mid too small     | go right        |
| count > required | mid can be answer | store & go left |
----------------------------------------------------------


    */

    public static int matrixMedian(int matrix[][]) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        int low = Integer.MAX_VALUE; //smallest in 1st col
        int high = Integer.MIN_VALUE; //highest in last col
        for (int i = 0; i < rowCount; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][colCount - 1]);
        }
        int countOfLessOREqual = 0;
        int requiredIndex = (rowCount * colCount) / 2;
        int median = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            countOfLessOREqual = CountOfLessThanEqualElements(matrix, mid);
            if (countOfLessOREqual > requiredIndex) {
                median = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return median;
    }

    public static int CountOfLessThanEqualElements(int matrix[][], int target) {
        //less than or equal to target
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            ans += upperBound(matrix[i], target);
        }
        return ans;
    }

    public static int upperBound(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > target) {//possible answer
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int mat[][] = {
                {1, 5, 7, 9, 11},
                {2, 3, 4, 5, 10},
                {9, 10, 12, 14, 16}
        };
        System.out.println(matrixMedian(mat));
    }
}
