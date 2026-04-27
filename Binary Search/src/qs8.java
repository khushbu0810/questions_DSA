//Painter's Partition OR Split Array - Largest Sum
public class qs8 {
    /*
PROBLEM - 1

    arr[i] = i units have to painted in i time , k = painters
    only consecutive task allowed [p1 p2 p1 p2] not allowed, ---> after p1 then only p2

     [10 20 30 40] , k=2
     p1             p2          t1      t2(time of painter 2)
    [10]        [20 30 40]      10      90  ---> MAX = 90
    [10 20]     [30 40]         30      70  ---> MAX = 70
    [10 20 30]  [40]            60      40  ---> MAX = 60
                                          MIN(MAX time) = 60

PROBLEM -2

split array in k subArrays such that max sum is minimum...

    [10 20 30 40] , k=2
     s1             s2         sum1    sum2(sum of subarray 2)
    [10]        [20 30 40]      10      90  ---> MAX = 90
    [10 20]     [30 40]         30      70  ---> MAX = 70
    [10 20 30]  [40]            60      40  ---> MAX = 60
                                          MIN(MAX sum) = 60

    */


//THESE BOTH PROBLEMS ARE SIMILAR TO ALLOCATION OF BOOKS PROBLEM

    public static void main(String[] args) {
        int arr[]={25,46,28,49,24};
        qs7.minOfMaxPages(arr,4);
    }
}
