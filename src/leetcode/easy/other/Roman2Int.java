package leetcode.easy.other;

public class Roman2Int {
    public static int romanToInt(String s){
        boolean operate=false;
        char currChar=' ', nextChar=' ';
        int sum=0;
        int count =0;
        char ch[] = s.toCharArray();

        if(ch.length==1){
            return lookUpSymbol2Val(ch[0]);
        }
        if(ch.length>1) {
            for (int i = 0; i < ch.length - 1; i++) {
                currChar = ch[i];
                nextChar = ch[i+1];

                if(lookUpSymbol2Val(nextChar)>lookUpSymbol2Val(currChar)){
                    operate = true;
                }

                if(operate){
                    sum = sum - lookUpSymbol2Val(currChar);
                    operate = false;
                }else{
                    sum = sum + lookUpSymbol2Val(currChar);
                }
                count++;
            }

            if(count < ch.length){
                sum = sum+lookUpSymbol2Val(ch[ch.length-1]);
            }

        }
        return sum;
    }

    static int lookUpSymbol2Val(char c){
        if(c=='I')
            return 1;
        if(c=='V')
            return 5;
        if(c=='X')
            return 10;
        if(c=='L')
            return 50;
        if(c=='C')
            return 100;
        if(c=='D')
            return 500;
        if(c=='M')
            return 1000;
        return 0;
    }

    public static void main(String[] args) {
        String s = "MCMXC";
        System.out.println(romanToInt(s));
    }
}
