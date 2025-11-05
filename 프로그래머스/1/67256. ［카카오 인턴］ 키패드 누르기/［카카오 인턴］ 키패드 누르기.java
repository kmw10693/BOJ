import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        
        for(int i : numbers) {
            if(i == 1 || i==4 || i==7){
                answer += "L";
                left = i;
            } else if (i==3 || i==6|| i==9) {
                answer += "R";
                right = i;
            } else {
                if(i==0) i = 11;
                
                int leftdis = Math.abs(i-left) / 3 + Math.abs(i-left) % 3;
                int rightdis = Math.abs(i-right) / 3 + Math.abs(i-right) % 3;
                
                if(leftdis < rightdis) {
                    answer += "L";
                    left = i;
                } else if (leftdis > rightdis) {
                    answer += "R";
                    right = i;
                } else {
                    if(hand.equals("left")) {
                        answer += "L";
                        left = i;
                    } else {
                        answer += "R";
                        right = i;
                    }
                }
            }
        }
        return answer;
    }
}