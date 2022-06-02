package GrokkingCodingInterview.datastructure.Stack;

import java.util.Stack;
import java.util.StringTokenizer;

public  class EvaluatePostfixChallenge2 {
    private  final char ADD = '+', SUBTRACT = '-';
    private  final char MULTIPLY = '*', DIVIDE = '/';
    private  Stack<Integer> stack;


   private  boolean isOperator (String token)
    {
        return ( token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/") );
    }

    private  int evalOp (char operation, int op1, int op2)
    {
        int result = 0;

        switch (operation)
        {
            case ADD:
                result = op1 + op2;
                break;
            case SUBTRACT:
                result = op1 - op2;
                break;
            case MULTIPLY:
                result = op1 * op2;
                break;
            case DIVIDE:
                result = op1 / op2;
        }

        return result;
    }

    public  int evaluatePostFix (String expr) {
        int op1, op2, result = 0;
        String token;
        StringTokenizer tokenizer = new StringTokenizer(expr);
        while (tokenizer.hasMoreTokens())
        {
            token = tokenizer.nextToken();

            if (isOperator(token))
            {
                op2 = (stack.pop()).intValue();
                op1 = (stack.pop()).intValue();
                result = evalOp (token.charAt(0), op1, op2);
                stack.push ((result));
            }
            else
                stack.push ((Integer.parseInt(token)));
        }

        return result;
    }
}