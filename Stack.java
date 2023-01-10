//THIS FILE IS ALL ABOUT STACK
/*Stack has 4 methods.they are
 * push
 * pop
 * top
 * display
*/
import java.util.*;

public class stk {
    List<Integer> stk = new ArrayList<>();

    //this push method is used to push the element into stack
    public void push(int key) {
        stk.add(key);
    }

    //this pop method is used to pop the element from stack
    public void pop() {
        if(stk.size() == 0){
            System.out.println("Stk is empty");
        } else {
            int x = stk.get(stk.size()-1);
            stk.remove(stk.size()-1);
            System.out.println(x+" is poped");
        }
    }
    //this peek method is used to print the lastly entered element in the stack(top element)
    public int peek() {
        if(stk.size() == 0) {
            System.out.println("stk is empty");
        } else {
            System.out.println(stk.get(stk.size() - 1) + " is top element");
        } return 0;
    }
    //this display method is used to print the elements in the stack
    public List display() {
        System.out.println(stk);
        return stk;
    }

    public static void main(String[] args) {
        stk stack = new stk();
        for(int i=0;i<10;i++){
            stack.push(i);
        }
        stack.peek();
        stack.pop();
        stack.display();
    }

}
