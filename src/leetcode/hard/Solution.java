package leetcode.hard;

import java.util.ArrayDeque;


public class Solution {
    public int calculate(String s) {
        ArrayDeque queue = new ArrayDeque();
        String result = s.replaceAll("\\s", "");
        String tokens[] = result.split("");
        for(int i=0;i<tokens.length;i++){
            queue.addLast(tokens[i]);
        }

        while(!queue.isEmpty()) {
            if(queue.size()==1)
                break;
            int x=0, y=0;
            String ch;
            if(queue.peek() instanceof String)
                x= Integer.parseInt((String) queue.pop());
            else
                x = (int) queue.pop();

            ch = (String)queue.pop();

            if(queue.peek() instanceof String)
                y = Integer.parseInt((String) queue.pop());
            else
                x = (int) queue.pop();

                   switch (ch) {
                       case "+":
                           queue.push(x + y);
                           break;
                       case "-":
                           queue.push(x - y);
                           break;
                       case "*":
                           queue.push(x * y);
                           break;
                       case "/":
                           queue.push(x / y);
                           break;
                   }


        }
        return (int)queue.pop();
    }

    public static void main(String[] args) {
        String  tok = "(1+(4+5+2)-3)+(6+8)";
        Solution d = new Solution();
        System.out.println(d.calculate(tok));
    }
}