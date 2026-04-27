import java.util.ArrayList;
import java.util.List;

//Intersection Of 2 Sorted Arrays
public class qs4 {
    /*
    element present in both(repetition is allowed)
arr1[] =  1   2   2   3   3   4    5   6
arr2[] =  2   3   3   5   6   6    7
inter[] = 2   3   3   5   6

for every element in arr1 there should be corresponding element in array 2

take i, j ---> if same take the element  and i++ and j++
-> if i<j ---> move i++ only (as this i can't have any same element in arr2)
-> if j<i ---> move j++ only (as this j can't have any same element in arr1)

    */
    public static List<Integer> intersectionArray(int arr1[], int arr2[]) {
        int n1=arr1.length;
        int n2=arr2.length;
        int i=0;
        int j=0;
        List<Integer> intersection = new ArrayList<>();
        while(i<n1&&j<n2){
            if(arr1[i]<arr2[j]){
                i++;
            }else if(arr2[j]<arr1[i]){
                j++;
            }else{
                //if arr[i] == arr[j] then add and move both
                intersection.add(arr1[i]);
                i++;
                j++;
            }
        }
        return intersection;
    }

    public static void main(String[] args) {
        int arr1[]={1,2,2,3,3,4,5,6};
        int arr2[]={2,3,3,5,6,6,7};
        System.out.println(intersectionArray(arr1,arr2));
    }
}
