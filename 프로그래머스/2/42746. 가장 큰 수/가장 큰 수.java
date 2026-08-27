import java.util.*;
import java.io.*;

class Solution {
    public String solution(int[] numbers) {
        
        List<String> str = new ArrayList<>();
        for(int number : numbers) {
            str.add(String.valueOf(number));
        }
        
        str.sort((a, b) -> {
            return (b+a).compareTo(a+b);
        });
        
        if(str.getFirst().equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.size(); i++) {
            sb.append(str.get(i));
        }
        return sb.toString();
    }
}