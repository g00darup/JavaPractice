package leetcode.easy.Stack;

import java.util.Stack;

public class BaseBallGameWithStacks {
    /*
    You are keeping the scores for a baseball game with strange rules.
    At the beginning of the game, you start with an empty record.
    You are given a list of strings operations,
    where operations[i] is the ith operation you must apply to the record and is one of the following:
    An integer x. Record a new score of x.
    '+'.
        Record a new score that is the sum of the previous two scores.
    'D'.
        Record a new score that is the double of the previous score.
    'C'.
        Invalidate the previous score, removing it from the record.
        Return the sum of all the scores on the record after applying all the operations.
        The test cases are generated such that the answer and all intermediate
        calculations fit in a 32-bit integer and that all operations are valid.
     */
//    public int calPoints(String[] operations) {
//        Stack in = new Stack();
//        int res = 0;
//        int count = 0;
//        for(String val: operations){
//            switch (val){
//                case "+":
//                    return add(in.pop(),in.pop());
//                case "D":
//                    return dubs(in.pop());
//                case "C":
//                    return clear(in.pop());
//            }
//        }
//    }
}
