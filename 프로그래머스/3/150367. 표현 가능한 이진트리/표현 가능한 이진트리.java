import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        
        List<Integer> anslist = new ArrayList<>();
        for(long number : numbers) {
            String binary = getfullbinary(number);
            
            if(isbinarytree(binary)) anslist.add(1);
            else anslist.add(0);
        }
        
        return anslist.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public boolean isbinarytree(String binary) {
        int binarylen = binary.length();
        if(binarylen == 0) return true;
        
        int mididx = binarylen / 2;
        
        String leftsubtree = binary.substring(0, mididx);
        String rightsubtree = binary.substring(mididx+1);
        
        if(binary.charAt(mididx) == '0') {
            return issubzero(leftsubtree) && issubzero(rightsubtree);
        }
        else {
            return isbinarytree(leftsubtree) && isbinarytree(rightsubtree);
        }
    }
    
    public boolean issubzero(String binary) {
        int binarylen = binary.length();
        if(binarylen == 0) return true;
        int mididx = binarylen / 2;
        
        String leftsubtree = binary.substring(0, mididx);
        String rightsubtree = binary.substring(mididx+1);
        
        if(binary.charAt(mididx) == '1') return false;
        else {
            return issubzero(leftsubtree) && issubzero(rightsubtree);
        }
    }
    
    public String getfullbinary(long number) {
        String binary = Long.toBinaryString(number);
        
        int binarylen = binary.length();
        int start = 1;
        int offset = 1;
        
        while(binarylen > offset) {
            start *= 2;
            offset += start;
        }
        
        return "0".repeat(offset-binarylen) + binary;
    }
}