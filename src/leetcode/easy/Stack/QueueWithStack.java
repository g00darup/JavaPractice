package leetcode.easy.Stack;

public class QueueWithStack {
        java.util.Stack<Integer> inStack,outStack;

        public QueueWithStack() {
            inStack = new java.util.Stack();
            outStack = new java.util.Stack();
        }

        public void push(int x) {
            if(!outStack.isEmpty()){
                while(!outStack.isEmpty()){
                    inStack.push(outStack.pop());
                }
                int temp = x;
                outStack.push(x);
                while(!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
            if(outStack.isEmpty() && inStack.isEmpty()) {
                inStack.push(x);
                outStack.push(inStack.pop());
            }

        }

        public int pop() {
            int val = 0;
            if(!outStack.isEmpty()){
                val = outStack.pop();
            }
            return val;
        }

        public int peek() {
            int val = 0;
            if(!outStack.isEmpty()){
                val = outStack.peek();
            }
            return val;
        }

        public boolean empty() {
            return outStack.isEmpty();
        }


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public static void main(String[] args) {
    QueueWithStack obj = new QueueWithStack();
    obj.push(10);
    obj.push(30);
    obj.push(50);
    int param_3 = obj.peek();
    System.out.println(param_3);
    int param_2 = obj.pop();
    boolean param_4 = obj.empty();
    int param_5 = obj.pop();
    int param_6=obj.pop();
    System.out.println(param_2);
    System.out.println(param_4);

    System.out.println(param_5);
    System.out.println(param_6);
}
}
