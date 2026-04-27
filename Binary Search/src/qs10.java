//Find row with maximum 1's
public class qs10 {
    /*
    every row is sorted, which row have max ones?
    return row with low index -> row=2

idx    ones
 0      3       0   0   1   1   1
 1      0       0   0   0   0   0
 2      4       0   1   1   1   1
 3      0       0   0   0   0   0
 4      4       0   1   1   1   1


treat each row as individual array
find first one -> uske baad to 1 hi hoge kunki sorted hai
(first occurence of 1) -> lower bound of 1 OR upper bound of 0


    */

    public static int rowWithMax1s(int mat[][]) {
        int rowCount = mat.length; //rows
        int colCount = mat[0].length; //cols
        int MAX_count_Of_Ones = 0;
        int rowIndexWithMax1 = -1;
        for (int i = 0; i < rowCount; i++) {
            //index for first one ... in each row
            int FirstIndexOf1 = lowerBound(mat[i], 1);
            //total no of 1 in this row -> length - first occurence of 1
            int countOf1 = colCount - FirstIndexOf1;
            if (countOf1 > MAX_count_Of_Ones) {
                MAX_count_Of_Ones = countOf1;
                rowIndexWithMax1 = i;
            }
        }
        return rowIndexWithMax1;
    }

    public static int lowerBound(int arr[], int target) {
        int low = 0;
        int high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= target) {//possible answer
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
                {0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1}
        };
        System.out.println(rowWithMax1s(mat));
    }
}
