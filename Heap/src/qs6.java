import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//BUCKET METHOD - Top k Frequent Elements
public class qs6 {
    /*
arr[] =     1   1   1   3   2   2   , k=2
 index      0   1   2   3   4   5
freq[] =    0   3   2   1
freq[i] -> frequency of ith element



index = freq
ele = arr[i]
arr[] =     1   1   1   3   2   2   , k=2
 index      0   1   2   3   4   5

MAP ==>
| 1,3 |
| 3,1 |
| 2,2 |
| 5,3 |
(ele,freq)

 index      0   1   2   3    4   5
freq[] =        3   2  {1,5}
                |   |   |_-> freq 3 kiska hai ? ele 1 & 5
                |   |_->freq 2 kiska hai ? = ele 2
                |_-> kiski freq 1 hai ? = ele 3


 index      0   1   2   3    4   5
freq[] =    _   3   2   1    _   _
                |   |   |_-> freq 3 kiska hai ? ele 1
                |   |_->freq 2 kiska hai ? = ele 2
                |_-> kiski freq 1 hai ? = ele 3

    -------------------------------------------|
    | freq[i] -> elements having i frequency   |
    |   |                                      |
    |   |-> bucket                             |
    | -----------------------------------------|


     */
    public static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>(); //(ele,freq)
        for(int x:arr){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        List<Integer>[] bucket=new List[arr.length+1];
        //index -> freq  , bucket[i] = ele having freq i
        for(int x:map.keySet()){
            int freq=map.get(x);
            // create list first , let freq=3
            if (bucket[freq] == null) { //abhi freq 3 pr koi nahi aaya hai
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(x);
        }
        //traverse in bucket and give ele
        int [] res=new int[k];
        int idx=0;
        // traverse from high freq -> low freq
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]==null){ //i frequency ka koi hai hi nahi
                continue;
            }
            for(int x:bucket[i]) {
                res[idx] = x;
                idx++;
                if(idx==k){
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2,2,3};
        int k=2;
        int[]ans= topKFrequent(arr,k);
        for(int x:ans){
            System.out.print(x+" ");
        }
    }
}
