import java.util.*;
import java.io.*;

class Solution {
    Number[] numberArr;
    
    public String solution(int[] numbers, String hand) {
       init();  
       String result = "";
       // 왼쪽 시작 좌표
       int startL = 10, startR = 11;
       for(int num: numbers) {
           // 만약 1, 4, 7인 경우
           if(num == 1 || num == 4 || num == 7) {
               result += "L";
               startL = num;
           }
           // 만약 3, 6, 9인 경우
           if(num == 3 || num == 6 || num == 9) {
               result += "R";
               startR = num;
           }
           // 2, 5, 8, 0 입력할 경우
           if(num == 2 || num == 5 || num == 8 || num == 0) {
               // 두 엄지손가락 중 가까운 엄지
               Number LNumber= numberArr[startL];
               Number RNumber= numberArr[startR];
               if(check(LNumber, numberArr[num]) > check(RNumber, numberArr[num])) {
                       result += "R";
                       startR = num;
                }
                else if(check(LNumber, numberArr[num]) < check(RNumber, numberArr[num])) {
                       result += "L";
                       startL = num;
               } else {
                   if(hand.equals("right")) {
                       result += "R";
                       startR = num;
                   } else {
                       result += "L";
                       startL = num;
                   }
               }
               // 만약 엄지 같다면 오른손잡이
           }
       }
        return result;
    }
    public int check(Number n1, Number n2) {
        return Math.abs(n1.x - n2.x) + Math.abs(n1.y - n2.y);
    }
    public void init() {
        numberArr = new Number[12];
        int start = 1;
        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++) {
                numberArr[start++] = new Number(i, j);
            }
        }
        numberArr[0] = new Number(3, 1);
        // *
        numberArr[10] = new Number(3,0);
        // #
        numberArr[11] = new Number(3,2);
    }
    class Number {
        int x, y;
        Number(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}