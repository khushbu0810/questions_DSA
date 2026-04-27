//Generate Binary Strings Without Consecutive 1s
public class qs3 {
    /*
          (ct of strings)     (strings)
    n=1 =>      2 =>         0 , 1
    n=2 =>      3 =>         00 , 01 , 10
    n=3 =>      5 =>         101 , 001 , 000 , 010 , 100
    n=4 =>      8 =>         0000 , 0001 , 0010 , 0100 , 1000 , 1001 , 1010 , 0101
    n=5 =>      13 =>       ...

this is a fibonacci series starting with 2 & 3 of non-consecutive 1's


   n=1 ===> n=2  --------
    0       00  |attach 0
    1       10  |at end
                 ------
                 --------
            01  |attach 1   ==> we will not take string that have 1
         ***11  |at end                             in the end
                 ------
            (we have
            one integer
            in n=1)

   n=2 ===> n=3  --------
    00      000  |attach 0
    10      100  |at end
    01      010   ------
                 --------
            001  |attach 1
            101  |at end
          **011   ------

 ---------------------------------------------------------------
| adding 0 at end OR adding 1 at end to those not ending with 1 |
 ---------------------------------------------------------------

count of string
when -->           n=2      n=3     n=4     n=5
adding 0            2       3       5       8
adding 1            1       2       3       5

ct of strings ending with 0 of n ==> all strings ending with 0 and 1 of (n-1) ->kunki 0 to add kr hi skte hain end mein
        ctEndingWith0 = prev0 + prev1
ct of strings ending with 1 of n ==> only string ending with 0 of (n-1)
        ctEndingWith1 = prev0


    */
    static int MOD = 10000007;

    public static int countStrings(int n) {
        //initially n=1 -> end with 0 and 1 both = 1
        int ctEndingWith0 = 1; //"0"
        int ctEndingWith1 = 1; //"1"
        int sumTotalStrings = ctEndingWith0 + ctEndingWith1;
        if (n == 1) {
            return 2; //2
        }
        int i = 2;
        while (i <= n) {
            ctEndingWith1 = ctEndingWith0;
            ctEndingWith0 = sumTotalStrings;
            sumTotalStrings = ctEndingWith0 + ctEndingWith1;
            i++;
        }
        return sumTotalStrings;
    }

    public static void main(String[] args) {
        System.out.println(countStrings(4));
    }
}
