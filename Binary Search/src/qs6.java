import java.util.Arrays;

//Aggressive cows
public class qs6 {
    /*
    n stalls with coordinates of their position are given,
    place x cows such that minimum distance between any 2 cow is maximum

    0   3   4   7   10  9
    minimum distance can be between consecutive cows only after sorting

        =====> cows positions
      arr[] = [0,3,4,7,10,9]

          -distance- between cows
            0 <---3---> 3 <---1---> 4 <---3---> 7 <---2---> 9 <---1---> 10
minDis=1   c1           c2          c3          c4
minDis=1   c1                       c2                      c3          c4
minDis=3   c1                       c2          c3                      c4

Max(minDis) => 3

first maintain dis=1 and put cows then dis=2 maintain this.... so on




    */
    public static int MaxOfMinDistance(int arr[], int cows) {
        int ans = 0;
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            //is it possible to place a cow at distance => mid
            int mid = low + (high - low) / 2;
            if (isPossibleToPlaceCows(arr, mid, cows)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isPossibleToPlaceCows(int arr[], int distance, int cows) {
        int countOfCows = 1;
        int lastCowPositon = arr[0];//first cow placed at 1st index
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastCowPositon >= distance) {
                //place one more cow at arr[i] as last cow was at lastCowPosition
                countOfCows++;
                lastCowPositon = arr[i];
            }
            if (countOfCows >= cows) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[]={0,3,4,7,10,9};
        System.out.println(MaxOfMinDistance(arr, 4));
    }
}
