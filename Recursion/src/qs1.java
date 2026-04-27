import java.util.Stack;

//Sort Stack Using Recursion
public class qs1 {
    /*
    stack -> 1 3 2      | 2 |
                        |---|
                        | 3 |
                        |---|
                        | 1 |
                        -----

1 -> pop topmost element from stack = top
2 -> recursive call on remaining stack
3 -> insert top

    top = 2
   peek = 3             |   |
                        |   |
                        | 3 |
                        |---|
                        | 1 |
                        -----

    top = 3             |   |
   peek = 1             |   |
                        |   |
                        |---|
                        | 1 |
                        -----


    top = 1             |   |
   peek = -             |   |
                        |   |
                        |   |
                        |   |
                        -----
                   stack is empty ===> call insert Function



    sorted
    stack -> 3 2 1      | 1 |
                        |---|
                        | 2 |
                        |---|
                        | 3 |
                        -----


single element / empty stack -> already sorted

1 -> pop topmost element from stack = top
2 -> recursive call on remaining stack
3 -> insert top

insertElement() FUNCTION ===>
1 -> if stack.isEmpty -> push
1 -> stack.peek()<=currElement --> push that element
2 -> stack.peek() > currElement  -> pop already present ele and push currElement then push poped ele

    */

    public static Stack<Integer> sortStack(Stack<Integer> stack){
        if(stack.isEmpty() || stack.size()==1){
            return stack;
        }
        int top = stack.pop();
        sortStack(stack);
        insertInSortedOrder(top,stack);
        return stack;
    }
    public static void insertInSortedOrder(int currElement,Stack<Integer> stack){
        if(stack.isEmpty()||stack.peek()<=currElement){
            stack.push(currElement);
            return;
        }
        int top=stack.pop();
        insertInSortedOrder(currElement,stack);
        // Put back the popped element
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        System.out.println(sortStack(stack));
    }
}