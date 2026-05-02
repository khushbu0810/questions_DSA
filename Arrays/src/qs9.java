import java.util.HashMap;

//Subarray With Given XOR
public class qs9 {
    /*
     0 0    0
     0 1    1
     1 0    1
     1 1    0

     -> xor of same nos = 0

     4 XOR 2  ->    6
    100   010      110
    (in binary)


arr[] = 4 2 2 6 4 , k=6
->[4,2]     [6]     [2,2,6]     [4,2,2,6,4]
(these 4 have XOR = 4)


every array have some ending point
(needed k)
    ------------------------------------------
    |             y      xor = k             |
    |            <-> <----------->           |
    |            4   2   2   6   4           |
    |            <--------------->           |
    |                  xor = x               |
    |    y XOR k = x                         |
    | -> take XOR k both sides               |
    |    (y XOR k) XOR k = x XOR k           |
    |    y = x XOR k                         |
    | ----------------------------------------

4   2   2   6   4
----------- *
4 ^ 2 ^ 2 ^ 6 = 2  ====> x
k = 6 (needed)
is there any subarray ending at 6 having xor 2
--> there will be some k only if some y is there
y = x ^ k = 2 ^ 6 = 4
do we some xor 4 from start ?? -- YES
ele arr[0] = xor=4



4   2   2   6   4

|     |
| 0,1 | <- initially
-------
(front XOR, ct)


...

4   2   2   6   4
i
abhi xor = 4
we need 4 ^ 6 = 2
do we get xor 2 previously ? ---> NO

| 4,1 |
| 0,1 | <- initially
-------


...

4   2   2   6   4
    i
abhi xor = 4 ^ 2 = 6
we need 6 ^ 6 = 0
do we get xor 0 previously ? ---> YES (initially)   -----> count = 1

| 6,1 |
| 4,1 |
| 0,1 | <- initially
-------


...

4   2   2   6   4
        i
abhi xor = 4 ^ 2 ^ 2 = 4
we need 4 ^ 6 = 2
do we get xor 2 previously ? ---> NO
(increase frequency)

| 6,1 |
| 4,2 |
| 0,1 | <- initially
-------


...

4   2   2   6   4
            i
abhi xor = 4 ^ 2 ^ 2 ^ 6 = 2
we need 2 ^ 6 = 4
do we get xor 4 previously ? ---> YES ---> there r 2 subarrays
4   2   2   6                       |_ _ _ _ _-> count = 1 -> +2 =3
*
------- *

| 2,1 |
| 6,1 |
| 4,2 |
| 0,1 | <- initially
-------


...

4   2   2   6   4
                i
abhi xor = 4 ^ 2 ^ 2 ^ 6 ^ 4 = 6
we need 6 ^ 6 = 0
do we get xor 0 previously ? ---> YES (initially) --> count = 3 -> 4
(increase frequency)

| 2,1 |
| 6,2 |
| 4,2 |
| 0,1 | <- initially
-------



    */
    public static int countSubarrayWithXORk(int arr[],int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        int x=0;
        map.put(x,1); //initially (0,1)
        int count=0;
        for(int i=0;i<arr.length;i++){
            //do we have any y = x ^ k
            x = x ^ arr[i]; //udhr tk ka xor nikala
            int y=x^k;
            //how many times y appear -- add in count
            if(map.containsKey(y)){
                count+=map.get(y); //ct of that present xor
            }
            map.put(x,map.getOrDefault(x,0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[]={4,2,2,6,4};
        int k=6;
        System.out.println(countSubarrayWithXORk(arr,k));
    }
}
