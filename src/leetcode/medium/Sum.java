package leetcode.medium;

public class Sum {
    public static int getSum(int a, int b) {
        String s1 = Integer.toBinaryString(a);
        String s2 = Integer.toBinaryString(b);
        int sum = binSum(s1,s2);
        return sum;
    }

    static int binSum(String s1, String s2) {
        char[] ch1 = null;
        char[] ch2 = null;
        char[] res = new char[32];
        char carry = '0';

        if(!s1.contains("1"))
            return Integer.valueOf(s2);
        if(!s2.contains("1"))
            return Integer.valueOf(s1);
        if(!s2.contains("1") && !s1.contains("1"))
            return 0;

        ch1 = s1.toCharArray();
        ch2 = s2.toCharArray();

        if(ch1.length>=ch2.length){
            res = new char[ch1.length];
            for(int i = 0;i < ch1.length; i++){
                if(i < ch2.length){
                    if(ch1[(ch1.length-1)-i]=='1' && ch2[(ch2.length-1)-i]=='1' && carry=='0'){
                        res [(ch1.length-1)-i] = '0';
                        carry = '1';
                    }else if(ch1[(ch1.length-1)-i]=='1' && ch2[(ch2.length-1)-i]=='1' && carry=='1'){
                        res [(ch1.length-1)-i] = '1';
                        carry = '1';
                    }else if(ch1[(ch1.length-1)-i]=='0' && ch2[(ch2.length-1)-i]=='1' && carry=='1'){
                        res [(ch1.length-1)-i] = '0';
                        carry = '1';
                    }else if(ch1[(ch1.length-1)-i]=='1' && ch2[(ch2.length-1)-i]=='0' && carry=='1'){
                        res [(ch1.length-1)-i] = '0';
                        carry = '1';
                    }else if(ch1[(ch1.length-1)-i]=='1' && ch2[(ch2.length-1)-i]=='0' && carry=='0'){
                        res [(ch1.length-1)-i] = '1';
                        carry = '0';
                    }else if(ch1[(ch1.length-1)-i]=='0' && ch2[(ch2.length-1)-i]=='1' && carry=='0'){
                        res [(ch1.length-1)-i] = '1';
                        carry = '0';
                    }else if(ch1[(ch1.length-1)-i]=='0' && ch2[(ch2.length-1)-i]=='0' && carry=='0'){
                        res [(ch1.length-1)-i] = '0';
                        carry = '0';
                    }else if(ch1[(ch1.length-1)-i]=='0' && ch2[(ch2.length-1)-i]=='0' && carry=='1'){
                        res [(ch1.length-1)-i] = '1';
                        carry = '0';
                    }
                }else{
                    if(ch1[(ch1.length-1)-i]=='1' && carry=='0'){
                        res [(ch1.length-1)-i] = '1';
                        carry = '0';
                    }else if(ch1[(ch1.length-1)-i]=='1' && carry=='1'){
                        res [(ch1.length-1)-i] = '0';
                        carry = '1';
                    }else if(ch1[(ch1.length-1)-i]=='0' && carry=='1'){
                        res [(ch1.length-1)-i] = '1';
                        carry = '0';
                    }else if(ch1[(ch1.length-1)-i]=='0' && carry=='0'){
                        res [(ch1.length-1)-i] = '0';
                        carry = '0';
                    }
                }
            }
        }else {
            res = new char[ch2.length];
            for(int i = 0; i < ch2.length; i++){
                if(i < ch1.length){
                    if(ch1[(ch1.length-1)-i]=='1' && ch2[(ch2.length-1)-i]=='1' && carry=='0'){
                        res [(ch2.length-1)-i] = '0';
                        carry = '1';
                    }else if(ch1[(ch1.length-1)-i]=='1' && ch2[(ch2.length-1)-i]=='1' && carry=='1'){
                        res [(ch2.length-1)-i] = '1';
                        carry = '1';
                    }else if(ch1[(ch1.length-1)-i]=='0' && ch2[(ch2.length-1)-i]=='1' && carry=='1'){
                        res [(ch2.length-1)-i] = '0';
                        carry = '1';
                    }else if(ch1[(ch1.length-1)-i]=='1' && ch2[(ch2.length-1)-i]=='0' && carry=='1'){
                        res [(ch2.length-1)-i] = '0';
                        carry = '1';
                    }else if(ch1[(ch1.length-1)-i]=='1' && ch2[(ch2.length-1)-i]=='0' && carry=='0'){
                        res [(ch2.length-1)-i] = '1';
                        carry = '0';
                    }else if(ch1[(ch1.length-1)-i]=='0' && ch2[(ch2.length-1)-i]=='1' && carry=='0'){
                        res [(ch2.length-1)-i] = '1';
                        carry = '0';
                    }else if(ch1[(ch1.length-1)-i]=='0' && ch2[(ch2.length-1)-i]=='0' && carry=='0'){
                        res [(ch2.length-1)-i] = '0';
                        carry = '0';
                    }else if(ch1[(ch1.length-1)-i]=='0' && ch2[(ch2.length-1)-i]=='0' && carry=='1'){
                        res [(ch2.length-1)-i] = '1';
                        carry = '0';
                    }
                }else{
                    if(ch2[(ch2.length-1)-i]=='1' && carry=='0'){
                        res [(ch2.length-1)-i] = '1';
                        carry = '0';
                    }else if(ch2[(ch2.length-1)-i]=='1' && carry=='1'){
                        res [(ch2.length-1)-i] = '0';
                        carry = '1';
                    }else if(ch2[(ch2.length-1)-i]=='0' && carry=='1'){
                        res [(ch2.length-1)-i] = '1';
                        carry = '0';
                    }else if(ch2[(ch2.length-1)-i]=='0' && carry=='0'){
                        res [(ch2.length-1)-i] = '0';
                        carry = '0';
                    }
                }
            }
        }
       // String result = (carry == '1') ? "1" + new String(res) : new String(res);
        int maxLength = res.length;
        char[] combined = new char[maxLength + 1];
        if (carry == '1') {
            combined[0] = carry;
            System.arraycopy(res, 0, combined, 1, maxLength);
        } else {
            System.arraycopy(res, 0, combined, 0, maxLength);
        }
        String result = String.valueOf(combined);
        return Integer.parseInt(result, 2);

    }

    public static void main(String[] args) {
        int res = getSum(-1,1);
        System.out.println(res);
    }
}
