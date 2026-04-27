//Count all subsequences with sum K
import java.util.ArrayList;
import java.util.List;

public class qs6 {
    /*

  |-------------------------------------------|
  |      f(){                                 |
  |          base case{                       |
  |              condition - satisfied        |
  |                  return 1                 |
  |              condition - not satisfied    |
  |                  return 0                 |
  |          }                                |
  |          left = f()     //TAKE            |
  |          right = f()    // NOT TAKE       |
  |          return left + right;             |
  |      }                                    |
  |-------------------------------------------|


    */

    public static void printSubsequences(int[] arr, int n) {
        //ds - dataStructure
        List<Integer> ds = new ArrayList<>();
        int targetSum = 2;
        System.out.println("Count is : " +solve(0, arr, ds, n, 0, targetSum));
    }

    public static int solve(int idx, int arr[], List<Integer> ds, int n, int sum, int targetsum) {
        if (idx == n) {
            //condition - satisfied
            if (sum == targetsum) {
                for (int x : ds) {
                    System.out.print(x + " ");
                }
                System.out.println();
                return 1;
            }
            if (ds.isEmpty()) {
                System.out.print("{}");
            }
            //condition - not satisfied
            return 0;
        }
        //take element
        ds.add(arr[idx]);
        sum += arr[idx];
        int left = solve(idx + 1, arr, ds, n, sum, targetsum);
        //not take
        ds.removeLast();
        sum -= arr[idx];
        int right = solve(idx + 1, arr, ds, n, sum, targetsum);
        return left + right;
    }


    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        printSubsequences(arr, 3);
    }

}
