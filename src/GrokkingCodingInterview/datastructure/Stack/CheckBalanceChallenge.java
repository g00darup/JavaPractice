package GrokkingCodingInterview.datastructure.Stack;

public class CheckBalanceChallenge {
    public static boolean isBalanced(String exp) {
        // Write -- Your -- Code
        String c[] = exp.split("");
        int len = exp.length();
        if(len%2!=0)
            return false;
        Stack st = new Stack(len);
        int count=0;
        while(count<len){
            st.push(c[count]);
            count++;
        }

        count=0;

        while(count<len-2){
            String ch = (String)st.pop();
            String match;
            switch (ch) {
                case "{":
                    match=(String)st.pop();
                    if(match.equals("}"))
                        return false;
                    break;
                case "(":
                    match=(String)st.pop();
                    if(match.equals(")"))
                        return false;
                    break;
                case "[":
                    match=(String)st.pop();
                    if(match.equals("]"))
                        return false;
                    break;
            }
            count++;
        }

        return true;

    }

    public static boolean isBalanced2(String exp) {

        //Iterate through the string exp.
        //For each opening parentheses, push it into stack
        //For every closing parenthesis check for its opening parentheses in stack
        //If you can't find the opening parentheses for any closing one then returns false.
        //and after complete traversal of string exp, if there's any opening parentheses left
        //in stack then also return false.
        //At the end return true if you haven't encountered any of the above false conditions.
        Stack<Character> stack = new Stack<>(exp.length());

        for (int i = 0; i < exp.length(); i++) {

            char character = exp.charAt(i);

            if (character == '}' || character == ')' || character == ']') {

                if (stack.isEmpty()) return false;

                if ((character == '}' && stack.pop() != '{') ||
                        (character == ')' && stack.pop() != '(') ||
                        (character == ']' && stack.pop() != '[')) return false;

            }
            else stack.push(character);

        } //end of for
        if (!stack.isEmpty()) return false;

        return true;
    }
    public static void main(String args[]) {

        System.out.println(isBalanced2("{[()]}"));
        System.out.println(isBalanced2("[{(}]"));

    }
}