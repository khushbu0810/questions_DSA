import java.util.Arrays;

public class qs10 {
    /*
    4   3   6   2   1   1 , n=6 , ans=[1,5] => [repeating,missing]

arraySum = 1+1+2+6+3+4 = 17
sumOfN = 6(7)/2 = 21

arraySum - sumOfN = 17 - 21 = -4 = value
repeating - missing = 1 - 4 = -4 = value
x - y = -4 .......... 1)

arraySquareSum = 1+1+4+36+9+16
sumOfNSquare = 1+4+9+16+25+36
arraySquareSum - sumOfNSquare = -24
x^2 - y^2 = -24 .......... 2)
(x-y)(x+y)=-24
x + y = 6  .......... 3)

from 1) and 3)
x - y = -4 .......... 1)
arraySum-sumOfN=sumDiff

x^2 - y^2 = -24 .......... 2)
arraySquareSum-sumOfNSquare=squareDiff
(x-y)(x+y)=-24
(sumDiff)(x+y)=-24
(sumDiff)(x+y)=squareDiff

x = (v1+v2)/2
y = x - v1

x + y = 6  .......... 3)


x = 1 and y = 5




     */
    public static int[] repeatingMissing(int arr[]){
        int n=arr.length;
        int expectedSum=(n*(n+1))/2;
        int expectedSquareSum=(n*(n+1)*(2*n+1))/6;
        int actualSum =0;
        int actualSquareSum =0;
        for (int x : arr) {
            actualSum += x;
            actualSquareSum += x * x;
        }
        // x - y
        int sumDiff= actualSum -expectedSum;
        // x^2 - y^2 = (x - y)(x + y)
        // (x-y)(x+y) = squareDiff
        int squareDiff= actualSquareSum - expectedSquareSum;
        // x + y
        int sumOfNumbers =squareDiff/sumDiff;
        int x=(sumDiff+sumOfNumbers)/2;
        int y=x-sumDiff;
        return new int[]{x,y};
    }

    public static void main(String[] args) {
        int arr[]={4,3,6,2,1,1};
        System.out.println(Arrays.toString(repeatingMissing(arr)));
    }
}
