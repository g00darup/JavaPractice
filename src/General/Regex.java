package General;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final String REGEX = "[^A-Za-z0-9]";

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(s);
//        int count = 0;
//
//        while(m.find()) {
//            count++;
//            System.out.println("Match number "+count);
//            System.out.println("start(): "+m.start());
//            System.out.println("end(): "+m.end());
//        }
        System.out.println(getString(s));
    }

    private static String getString(String s) {
        return s.replaceAll(REGEX, "");
    }
}
