import java.util.ArrayList;
import java.util.List;

//Printing Subsequences With Sum K
public class qs5 {
    /*

    PATTERN - 1 => ALL

    arr = [1,2,1] , sum=2
    ===> { [1,1], [2] }

    f(idx,ds,sum) = f(0,'',0)
        /          \
       /             \
    add in sum      not taking
    (if take)


   if(sum == givenSum) -> print that subsequence

    |----------------------------------------|
    |        f(idx,[],sum){                  |
    |            if(idx>=n){                 |
    |               if(sum==givenSum){       |
    |                    print([]);          |
    |                }                       |
    |               return;                  |
    |           }                            |
    |           [].add(arr[i]);              |
    |           sum+=arr[i];                 |
    |           f(idx+1,[],sum);    //TAKE   |
    |           [].remove(arr[i]);           |
    |           sum-=arr[i];                 |
    |           f(idx+1,[],sum);  //NOT TAKE |
    |       }                                |
    |----------------------------------------|


=========================================================================>

    PATTERN - 2 => ANY ONE


  |-------------------------------------------|
  |      f(){                                 |
  |          base case{                       |
  |              condition - satisfied        |
  |                  return true              |
  |              condition - not satisfied    |
  |                  return false             |
  |          }                                |
  |          if(f()==true){                   |
  |              return true;                 |
  |              //no need to move further    |
  |          }else{                           |
  |              return false;                |
  |          }                                |
  |      }                                    |
  |-------------------------------------------|




    */



    public static void printSubsequences(int[] arr, int n,int targetSum) {
        //ds - dataStructure
        List<Integer> ds = new ArrayList<>();
        solve(0, arr, ds, n,0,targetSum);
    }

    public static void solve(int idx, int arr[], List<Integer> ds, int n, int sum, int targetsum) {
        if (idx == n) {
            if (sum == targetsum) {
                for (int x : ds) {
                    System.out.print(x + " ");
                }
            System.out.println();
            }
            if (ds.isEmpty()) {
                System.out.print("{}");
            }
            return;
        }
        //take element
        ds.add(arr[idx]);
        sum += arr[idx];
        solve(idx + 1, arr, ds, n,sum,targetsum);
        //not take
        ds.removeLast();
        sum-=arr[idx];
        solve(idx + 1, arr, ds, n,sum,targetsum);
    }


    //PATTERN - 2

    /*

    public static void printSubsequences(int[] arr, int n) {
        //ds - dataStructure
        List<Integer> ds = new ArrayList<>();
        int targetSum = 2;
        if (solve(0, arr, ds, n, 0, targetSum)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean solve(int idx, int arr[], List<Integer> ds, int n, int sum, int targetsum) {
        if (idx == n) {
            //condition - satisfied
            if (sum == targetsum) {
                for (int x : ds) {
                    System.out.print(x + " ");
                }
                System.out.println();
                return true;
            }
            if (ds.isEmpty()) {
                System.out.print("{}");
            }
            //condition - not satisfied
            return false;
        }
        //take element
        ds.add(arr[idx]);
        sum += arr[idx];
        if (solve(idx + 1, arr, ds, n, sum, targetsum)) {
            return true;
        }
        //not take
        ds.removeLast();
        sum -= arr[idx];
        if (solve(idx + 1, arr, ds, n, sum, targetsum)) {
            return true;
        }
        return false;
    }
*/

    public static void main(String[] args) {
        int arr[] = {2,5,2,1,2};
        printSubsequences(arr, 5,5);
    }
}
