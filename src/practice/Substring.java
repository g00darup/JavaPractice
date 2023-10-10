package practice;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.stream.Stream;

public class Substring {
    byte[] checkEquality(int n, int m,int i, int j){
    byte[] nArr = ByteBuffer.allocate(32).putInt(n).array();
    byte[] mArr = ByteBuffer.allocate(32).putInt(m).array();
    int count=0;
    for(int k=i;k<j+1;k++){
        nArr[k] = mArr[count];
        count++;
        }
    return nArr;
    }

    boolean bitc(int n){
        return (((n&(n-1))==0));
    }

    int bytesRequired(int n, int m){
        byte [] nArr = ByteBuffer.allocate(32).putInt(n).array();
        byte [] mArr = ByteBuffer.allocate(32).putInt(m).array();

//        int nCount = extracted(nArr);
//        int mCount = extracted(mArr);

//        return nCount-mCount;
        return 0;
    }

//    private void  int extracted(byte[] nArr) {
//        int count=0;
//        for(int i = 0; i< nArr.length; i++){
//            if(nArr[i]==1){
//                count++;
//            }
//        }
//    }
}
