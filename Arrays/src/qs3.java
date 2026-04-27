import java.util.ArrayList;
import java.util.List;

//Union Of 2 Sorted Arrays
public class qs3 {
    /*
     add 2 arrays with unique elements
arr1[] =  1   1   2   3   4   5
arr2[] =  2   3   4   4   5   6
union[] = 1   2   3   4   5   6

Approach-1
put elements in ORDERED SET then from set to union[]

==============================================================>

APPROACH - 2
i - idx of arr1[]
j - idx of arr2[]



1) take smallest of both i and j and put in unionArray[]
        if taken i -----> i++ or else j++
2) before taking next element compare that with element of union array
        - as we have to take unique
3) if jth element already present in array then j++ only



ITERATION - 1
arr1[] =  1   1   2   3   4   5
          i
arr2[] =  2   3   4   4   5   6
          j
union[] = 1


ITERATION - 2
arr1[] =  1   1   2   3   4   5
              i
arr2[] =  2   3   4   4   5   6
          j
union[] = 1
(do not take 1 again skip that as already present in union array)


ITERATION - 3
arr1[] =  1   1   2   3   4   5
                  i
arr2[] =  2   3   4   4   5   6
          j
union[] = 1   2


ITERATION - 4
arr1[] =  1   1   2   3   4   5
                      i
arr2[] =  2   3   4   4   5   6
          j
union[] = 1   2
(this time j < i ----> but 2 already present so skip but move ahead j)


ITERATION - 5
arr1[] =  1   1   2   3   4   5
                      i
arr2[] =  2   3   4   4   5   6
              j
union[] = 1   2   3


ITERATION - 6
arr1[] =  1   1   2   3   4   5
                          i
arr2[] =  2   3   4   4   5   6
              j
union[] = 1   2   3
(now j<i but 3 already so j++)


ITERATION - 7
arr1[] =  1   1   2   3   4   5
                          i
arr2[] =  2   3   4   4   5   6
                  j
union[] = 1   2   3   4


ITERATION - 7
arr1[] =  1   1   2   3   4   5
                              i
arr2[] =  2   3   4   4   5   6
                  j
union[] = 1   2   3   4
(again j++)


ITERATION - 8
arr1[] =  1   1   2   3   4   5
                              i
arr2[] =  2   3   4   4   5   6
                          j
union[] = 1   2   3   4   5


ITERATION - 9
arr1[] =  1   1   2   3   4   5
                                 i
arr2[] =  2   3   4   4   5   6
                          j
union[] = 1   2   3   4   5
(i goes out of array, SO ITERATE IN ANOTHER ARRAY)


ITERATION - 10
arr1[] =  1   1   2   3   4   5
                                 i
arr2[] =  2   3   4   4   5   6
                              j
union[] = 1   2   3   4   5   6





     */
    public static List<Integer> unionArray(int arr1[], int arr2[]) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0; //arr1 index
        int j = 0; //arr2 index
        ArrayList<Integer>union = new ArrayList<>();
        while (i < n1 && j < n2) {
            //i<j ---> take i if not in union
            if (arr1[i] <= arr2[j]) {
                //check in union (if empty take element)
                if (union.isEmpty() || union.getLast() != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else {
                if (union.isEmpty() || union.getLast() != arr2[j]) {
                    union.add(arr1[j]);
                }
                j++;
            }
        }
        //if 1st array completed but 2nd remaining
        while (i < n1) {
            if (union.isEmpty() || union.getLast() != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        //if 2nd array completed but 1st remaining
        while (j < n2) {
            if (union.isEmpty() || union.getLast() != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
//        // convert to array
//        int[] result = new int[union.size()];
//        for (int idx = 0; idx < union.size(); idx++) {
//            result[idx] = union.get(idx);
//        }

        return union;
    }

    public static void main(String[] args) {
        int arr1[]={1,1,2,3,4,5};
        int arr2[]={2,3,4,4,5,6};
//        System.out.println(Arrays.toString(unionArray(arr1, arr2)));
        System.out.println(unionArray(arr1, arr2));
    }
}
