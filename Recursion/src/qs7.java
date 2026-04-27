import java.util.ArrayList;
import java.util.List;

//Subset Sum - 1
public class qs7 {

    /*
 same as qs5

[3  1   4]      sum

y   n   y   =>  7
y   y   n   =>  4

left - pick
right - not pick
                            i
                           [3   1   2] , [] , sum=0
                      __________|_____
                     i|
                 [3   1   2] , [[3]] , sum=3
        ______________|__________________
        |   i
   [3   1   2]  , [[3,1]] , sum=4
     ___|___________________________________
     |      i                              |       i
[3   1   2]  , [[3,1,2]] , sum=6     [3    1    2]  ,  [[3,1]] , sum=4


    |----------------------------------------|
    |        f(idx,[],sum){                  |
    |            if(idx==n){                 |
    |              print([]);->add in array  |
    |              return;                   |
    |           }                            |
    |           [].add(arr[i]);              |
    |           sum+=arr[i];                 |
    |           f(idx+1,[],sum);    //TAKE   |
    |           [].remove(arr[i]);           |
    |           sum-=arr[i];                 |
    |           f(idx+1,[],sum);  //NOT TAKE |
    |       }                                |
    |----------------------------------------|


    */

    public static void printSubsetSum(int[] arr, int n) {
        //ds - dataStructure
        List<Integer> ds = new ArrayList<>();
        solve(0, arr, ds, n, 0);
    }

    public static void solve(int idx, int arr[], List<Integer> ds, int n, int sum) {
        //if result arr mein store kraana hai sum
        //result.add(new ArrayList<>(ds));
        if (idx == n) {
            if (ds.isEmpty()) {
                System.out.print("{}");
            }else{
                for (int x : ds) {
                    System.out.print(x + " ");
                }
            }
            System.out.println(" -> Sum: " + sum);
            return;
        }
        //take element and put sum
        ds.add(arr[idx]);
        sum += arr[idx];
        solve(idx + 1, arr, ds, n, sum);
        //not take
        ds.removeLast();
        sum -= arr[idx];
        solve(idx + 1, arr, ds, n, sum);
    }

    public static void main(String[] args) {
        int arr[] = {5,2,1};
        printSubsetSum(arr, 3);
    }
}
