package leetcode.easy.string;

class BinaryAdd {
//    public String addBinary(String a, String b) {
//        char [] c1 = a.toCharArray();
//        char [] c2 = b.toCharArray();
//        StringBuilder sb = new StringBuilder();
//
//        int aL=a.length();
//        int bL=b.length();
//
//        if(aL>bL){
//            sb = binSum(aL,c1,c2,sb,false);
//        }else if(bL>aL){
//            sb = binSum(bL,c2,c1,sb,false);
//        }else if(aL==bL){
//            sb = binSum(bL,c2,c1,sb,true);
//        }
//
//        return sb.toString();
//
//    }

    static String sum(int a, int b,int prefix){
        if(a+b+prefix>1) {
            int num = (a+b+prefix)%2;
            String c1="1";
            String c2 =  Integer.toString(num);
            return c1.concat(c2);
        }
        else if(a+b+prefix==1)
            return "1";
        //else if (a+b+prefix==0)
        else
            return "0";
    }

//    static StringBuilder binSum(int bigLen,char[] bg,char sm[],StringBuilder sb,boolean isSame){
//        int prefix = 0;
//        if(isSame){
//            for(int i=bigLen-1;i>0;i--){
//                String out = sum(bg[i],sm[i],prefix);
//                if(out.equals("10")){
//                    prefix='1';
//                    out="0";
//                } else if(out=="11"){
//                    prefix='1';
//                    out="1";
//                }
//                sb.insert(0,out);
//            }
//            if(prefix=='1')
//                sb.insert(0,prefix);
//        }else{
//            int count=0;
//            for(int j=sm.length;j>0;i--){
//                char out = sum(bg[j],sm[j],prefix);
//                if(out=='10'){
//                    prefix='1';
//                    out='0';
//                } else if(out=='11'){
//                    prefix='1';
//                    out='1';
//                }
//                sb.insert(0,out);
//                count++;
//            }
//
//            for(int k=(bigLen-count);k>0;k--){
//                char out = sum(bg[k],0,prefix);
//                if(out == '10'){
//                    prefix='1';
//                    out='0';
//                } else if(out == '11'){
//                    prefix='1';
//                    out='1';
//                }
//                sb.insert(0,out);
//                count++;
//            }
//            if(prefix=='1')
//                sb.insert(0,prefix);
//        }
//
//        return sb;
//    }


}