//PRINT SUBSEQUENCES
import java.util.ArrayList;
import java.util.List;

public class qs4 {
    /*
    follows the order of array... need not be contiguous
    arr = [3,1,2]
    => [ {},
         3  1   2,
         {3,1}  {1,2}   {3,2},
         {3,1,2} ]

    |----------------------------------------|
    |        f(idx,[]){                      |
    |            if(idx>=n){                 |
    |               print([]);               |
    |               return;                  |
    |           }                            |
    |           [].add(arr[i]);              |
    |           f(idx+1,[]);    //TAKE       |
    |           [].remove(arr[i]);           |
    |           f(idx+1,[]);    //NOT TAKE   |
    |       }                                |
    |----------------------------------------|

   [3  1   2]
idx 0  1   2
f(0,[]) -> [3]
           f(1,[3])
               |
               |____->  [3].add(arr[1])=[3,1]
                        f(2,[3,1])
                            |
                            |____-> [3,1].add(arr[2])=[3,1,2]
                                    f(3,[3,1,2]
                                                 idx=3 ....
                                                 print [3,1,2] and RETURN
                                             |
                      if(picked)    <-_______|
                    it becomes = [3,1,2]
                  SO NOW DON'T PICK IT
                    ==> Remove 2 from arr
                    SO, [3,1]
                        |
                        |___________-> now don't take 1
                                    ==> Remove 1 from arr
                                    SO, [3]

                                                ...........SO ON

    */
    public static void printSubsequences(int[] arr,int n) {
        //ds - dataStructure
        List<Integer> ds = new ArrayList<>();
        solve(0,arr,ds,n);
    }

    public static void solve(int idx,int arr[],List<Integer> ds, int n){
        if(idx==n){
            for(int x:ds){
                System.out.print(x+" ");
            }
            if(ds.isEmpty()){
                System.out.print("{}");
            }
            System.out.println();
            return;
        }
        //take element
        ds.add(arr[idx]);
        solve(idx+1,arr,ds,n);
        //not take
        ds.removeLast();
        solve(idx+1,arr,ds,n);
    }

    public static void main(String[] args) {
        int arr[]={3,1,2};
        printSubsequences(arr,3);
    }

}
