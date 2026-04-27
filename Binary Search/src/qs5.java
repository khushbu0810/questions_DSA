//Find Nth root of a number
public class qs5 {
    //nthRoot(16,4) -> 16th ka 4th root
    public static int nthRoot(int number, int power) { //root and power are same
        int low = 1;
        int high = number;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = power2(mid, power, number);
            if (value == 1) {
                return mid;
            } else if (value == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int power(int number, int power) { // (number)^power
        int ans = 1;
        /*
                2^5 = 2 * 2^4
                2^4 = (2^2)^2

            even power -> double number and half the power
                instead of 2^8 = 2×2×2×2×2×2×2×2
                we do 2^8 → 4^4 → 16^2 → 256^1
            odd power -> reduce power by 1 and multiply in ans


10th root of 10^9 //overflow
if overflowing -> return 2
return 1 if ==n
return 0 if <n
return 2 if >n


| Return | Meaning                     |
| ---- | ----------------------------- |
| 1    | equal → `base^exp == number`  |
| 0    | less → `base^exp < number`    |
| 2    | greater → `base^exp > number` |

base = 2, exp = 4, number = 16 ,
we are checking 2^4 == 16 ?


                * */
        while (power > 0) {
            if (power % 2 == 1) {//odd power
                ans = ans * number;
                power = power - 1;
            } else {
                number = number * number;
                power = power / 2;
            }
        }
        return ans;
    }

    public static int power2(int base, int power, int number) {
        long ans = 1;
        for (int i = 1; i <= power; i++) {
            ans = ans * base;
            if (ans > number) {
                return 2;
        }
            }
        if (ans == number) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(nthRoot(16, 4)); //2*2*2*2=16, ans=2    power(2,4)
    }
}
