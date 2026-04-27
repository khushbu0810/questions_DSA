import java.util.Stack;

public class qs2 {
    /*
    stack s pop kro -> insert at bottom

     -----------------------------
    | ||stack.peek()<=currElement |   ye condition ht jaayegi from QUESTION 1
     ------------------------------         (jahaan sorted order m daalna tha)

    */
    public static Stack<Integer> reverseStack(Stack<Integer> stack){
        if(stack.isEmpty() || stack.size()==1){
            return stack;
        }
        int top = stack.pop();
        reverseStack(stack);
        insertAtBottom(top,stack);
        return stack;
    }
    //insert at bottom
    public static void insertAtBottom(int currElement,Stack<Integer> stack){
        if(stack.isEmpty()){
            stack.push(currElement);
            return;
        }
        int top=stack.pop();
        insertAtBottom(currElement,stack);
        // Put back the popped element
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(reverseStack(stack));
    }
}
