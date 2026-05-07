//Insertion & Deletion in MaxHeap
public class qs1 {
    /*
    inser/delete => 0(logN)

    heap -> complete binary tree
    every level is completely filled except last level
    (jitne child aane the uthne aagye)

    ----->> nodes always added from left


              a                  a
            /   \              /   \
          b      c            b      c
        /  \    /           /  \       \
       d    e  f          d     e       f

     complete BT           NOT complete BT

MAX HEAP (child < root)
              50
            /    \
          30      40
         /  \    /
       10   20  35



MIN HEAP (child > root)
              10
            /    \
          20      15
         /  \    /
       30   40  50


------------------>
INSERTION
(in array form)

    |-------------------------|
    | node -> ith idx         |
    | left child -> 2*i idx   |
    | right child -> 2*i+1 idx|
    | parent -> i/2 idx       |
    |   -----------------     |
    | 0 - based indexing      |
    | leftChildIdx = 2*i+1    |
    | rightChildIdx = 2*i+2   |
    |-------------------------|

              60 (1)
            /    \
      (2) 50      40 (3)
         /  \    /
       30   20   55
      (4)   (5) (6)

arr[] = *   60  50  40  30  20
idx     0   1   2   3   4   5

arr[] = *   60  50  40  30  20  55
idx     0   1   2   3   4   5   6

value -> 55 insert this at correct place
1) add that value at arr[n]
2) take value to its correct position
    |-------------------|
    | parent < child    |
    |    -> swap        |
    |-------------------|

we are at idx 6
    if this is max Heap -> parent > child
    --> parent of 55 -> i/2 = 3rd idx = 40
        parent < 55

              60 (1)
            /    \
      (2) 50      55 (3)
         /  \    /
       30   20   40
      (4)   (5) (6)

arr[] = *   60  50  55  30  20  40
idx     0   1   2   3   4   5   6


    --> parent of 55 -> i/2 = 1st idx = 60
        parent > 55






------------------>
DELETION
(root node)

1) swap root with last element /  node
    arr[1] = arr[n]
2) remove last node -> size--
3) now make sure this is heap or not
    (root node to its correct position)
    if(root < child) ->
        swap(root,maxChild)



              55 (1)
            /    \
      (2) 54      53 (3)
         /  \
       50   52
      (4)   (5)

arr[] = *   55  54  53  50  52
idx     0   1   2   3   4   5


after swaping ------>

              52 (1)
            /    \
      (2) 54      53 (3)
         /  \
       50   55
      (4)   (5)

arr[] = *   52  54  53  50  55
idx     0   1   2   3   4   5


removing last node ---->

              52 (1)
            /    \
      (2) 54      53 (3)
         /
       50
      (4)


root = 52 < child
swap(parent,maxChild)
              54 (1)
            /    \
      (2) 52      53 (3)
         /
       50
      (4)








    */
    public static int arr[]=new int[100];
    public static int sizeOfArray;

    public static void insert(int value){
        //insert this value at end --> uske liye size increase kro
        sizeOfArray=sizeOfArray+1;
        int idx=sizeOfArray;
        arr[idx]=value;
        while(idx>1){
            int parent =idx/2;
            if(arr[parent]<arr[idx]){
                swap(arr,parent,idx);
                //now idx points to parent
                idx=parent;
            }else{
                return;
            }
        }
    }

    public static void deleteFromHeap(){
        if(sizeOfArray==0){
            return;
        }
        //root node mein last node daal diya
        arr[1]=arr[sizeOfArray];
        //removing last element
        sizeOfArray--;

        //take root node to its correct position
        int idx=1; //root node index
        while(idx<sizeOfArray){
            int leftChildIdx=2*idx;
            int rightChildIdx=2*idx+1;
            if(leftChildIdx < sizeOfArray && arr[idx]<arr[leftChildIdx]){
                swap(arr,idx,leftChildIdx);
                idx=leftChildIdx;
            }else if(rightChildIdx < sizeOfArray && arr[idx]<arr[rightChildIdx]){
                swap(arr,idx,rightChildIdx);
                idx=rightChildIdx;
            }else{
                return;
            }
        }
    }

    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void print(){
        for(int i=1;i<=sizeOfArray;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        insert(55);
        insert(54);
        insert(53);
        insert(50);
        insert(52);

        System.out.println("Max Heap:");
        print();

        deleteFromHeap();
        System.out.println("After Deletion Root:");
        print();

    }
}
