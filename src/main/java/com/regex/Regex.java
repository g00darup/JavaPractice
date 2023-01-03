package main.java.com.regex;

import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String str1= "+1A#6(78-%675*-(8765)a";
        String str2= str1.
                replace("+", "").
                replace("-","").
                replace(")","");

//        String patt = "[^A-Z0-9]";
//        System.out.println(str2);
//        String str3 = str1.replaceAll(patt,"");
//
//        System.out.println(str3);

        //Quantifiers
        /*
        Greedy	Reluctant	Possessive	Meaning
        X?	X??	X?+	X, once or not at all
        X*	X*?	X*+	X, zero or more times
        X+	X+?	X++	X, one or more times
        X{n}	X{n}?	X{n}+	X, exactly n times
        X{n,}	X{n,}?	X{n,}+	X, at least n times
        X{n,m}	X{n,m}?	X{n,m}+	X, at least n but not more than m times

         */

//        String p1= "ab(xyz){1}";
//        String t1 = "a";
//        String t2 ="ab";
//        String t3 = "abxyz";
//        String t4 ="abxyzxyz";
//
//        System.out.println(t1.matches(p1));
//        System.out.println(t2.matches(p1));
//        System.out.println(t3.matches(p1));
//        System.out.println(t4.matches(p1));

        /*
        Construct	Description
        .	Any character (may or may not match line terminators)
        \d	A digit: [0-9]
        \D	A non-digit: [^0-9]
        \s	A whitespace character: [ \t\n\x0B\f\r]
        \S	A non-whitespace character: [^\s]
        \w	A word character: [a-zA-Z_0-9]
        \W	A non-word character: [^\w]
         */

        String p1 = "abc?";
        String s1 = "abccccccc";
        //System.out.println(s1.matches(p1));


        Pattern pattern =
                Pattern.compile(p1);

        Matcher matcher =
                pattern.matcher(s1);

        boolean found = false;
        while (matcher.find()) {
            System.out.format("I found the text \"%s starting at index %d and ending at index %d.%n",
                    matcher.group(),matcher.start(),matcher.end());
            found = true;
        }
        if(!found){
            System.out.println("No match found.%n");
        }

    }
}
