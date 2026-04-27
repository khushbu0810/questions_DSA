//Book Allocation Problem
public class qs7 {
    /*
     arr[] -> number of pages of n books
     arr[i] -> ith book have arr[i] pages
     - distribute these 'i' books among 'm' students such that each student
        get atLeast 1 book
     - one book can only be allocated to only one student
     - BOOK ALLOCATION MUST BE IN CONTIGUOUS MANNER
        (stud1 then stud 2 not back to stud1)

==> maximum pages assigned to a student should be minimum ====>

books   B1      B2      B3      B4      B5
pages   25      46      28      49      24

stud    s1      s2      s3      <---s4---->     Max(pages) = 49+24 = 73
        s1      s2     <----s3--->      s4      Max(pages) = 28+49 = 77
        s1      <----s2--->     s3      s4      Max(pages) = 46+28 = 74
        <----s1--->     s2      s3      s4      Max(pages) = 25+46 = 71
                                                ans = Min(MAX) => 71

RANGE===>>>>
to hold any of the book, pages needed -> 49 -> maxPages of arr [LOW]
[HIGH] -> sum of all pages




[25,46,28,49,24]
        low                                 high
pages   49  50  51 ........... 71 ......... 172
stud    5 ...................  4 ...........1
                            (25+46) to one student
                                         (172) all pages to one student
(students required to assign these 5 books where max pages can be assigned is pages[i] )

     */
    public static int minOfMaxPages(int pages[],int students){
        if(pages.length<students){
            return -1;
        }
        int low=0; //max of array
        int high=0; //sum
        int ans=0;
        for(int x:pages){
            low=Math.max(low,x);
            high+=x;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(requiredStudent(pages,mid)<=students){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

    public static int requiredStudent(int pages[],int pagesAllowed){
        //  [ pagesAllowed=x ]
       //how many student are needed to assign them x pages

        int studCount=1;
        int pagesAssignedToStudent=0; //initially pages assigned to stud 1 = 0
        for(int i=0;i<pages.length;i++){
            if(pagesAssignedToStudent+pages[i]<=pagesAllowed){
                //if assigned pages+ curr page < pages allowed to hold
                //assign that page to same student
                pagesAssignedToStudent+=pages[i];
            }else{
                //assign to next student
                studCount++;
                pagesAssignedToStudent=pages[i];
            }
        }
        return studCount;
    }

    public static void main(String[] args) {
        int arr[]={25,46,28,49,24};
        System.out.println(minOfMaxPages(arr,4));
    }

}
