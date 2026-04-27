//Find square root of a number using BS
public class qs4 {
    public static int sqrt(int n){
        int ans=1;
        for(int i=1;i<=n;i++){
            if(i*i<=n){
                ans=i;
            }else{
                break;
            }
        }
        return ans;
    }

    public static int sqrtBS(int n){
        int low=1;
        int high=n;
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(mid*mid<=n){
                ans= mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
//        System.out.println(sqrt(100));
        System.out.println(sqrtBS(100));
    }
}
