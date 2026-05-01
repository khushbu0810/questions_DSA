import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

//Leaders In Array
public class qs7 {
    /*
     Everything on right must be smaller
     arr[] = 10 22  12  3   0   6
     22 12  6 -> leaders

     let 22, max ele on right -> 12 so if
     22 > 12 then it must be > than all other ele also

     arr[i] > maxOnRight -> leader

     last element always a leader.



     */
    public static int[] leaders(int arr[]){
        int max=Integer.MIN_VALUE;
        ArrayList<Integer>res=new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>max){
                max=arr[i];
                res.add(arr[i]);
            }
        }
        Collections.sort(res);
        // Convert ArrayList<Integer> to int[]
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[]={10,22,12,3,0,6};
        System.out.println(Arrays.toString(leaders(arr)));
    }
}
