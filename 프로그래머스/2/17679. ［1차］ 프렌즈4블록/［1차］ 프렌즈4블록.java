import java.io.*;
import java.util.*;

class Solution {
    int totalremove = 0;
    public int solution(int m, int n, String[] board) {
        int cnt = 0;
        while(true) {
            int subtotal = remove(board, m, n);
            if(subtotal == 0) break;
            totalremove += subtotal;
        }
        return totalremove;
    }

    public int remove(String[] board, int m, int n) {
        String[] tempboard = new String[m];

        for(int i=0; i<m; i++) {
            StringBuilder sb = new StringBuilder(board[i]);
            tempboard[i] = sb.toString();
        }

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length(); j++) {

                char c = board[i].charAt(j);
                if(j+1 >= n || i+1 >= m) continue;
                if(c == ' ') continue;
                if(c == board[i].charAt(j+1) && c == board[i+1].charAt(j) && c == board[i+1].charAt(j+1)) {
                    StringBuilder sb1 = new StringBuilder(tempboard[i]);
                    sb1.setCharAt(j, 'x');
                    sb1.setCharAt(j+1, 'x');
                    StringBuilder sb2 = new StringBuilder(tempboard[i+1]);
                    sb2.setCharAt(j, 'x');
                    sb2.setCharAt(j+1, 'x');

                    tempboard[i] = sb1.toString();
                    tempboard[i+1] = sb2.toString();
                }
            }
        }

        int removeCnt = 0;
        for(int i=0; i<tempboard.length; i++) {
            for(int j=0; j<tempboard[i].length(); j++) {
                if(tempboard[i].charAt(j) == 'x') {
                    removeCnt++;
                }
            }
        }

        if(removeCnt == 0) return removeCnt;

        for(int i=0; i< tempboard.length; i++) {
            for(int j=0; j<tempboard[i].length(); j++) {
                if(tempboard[i].charAt(j) == 'x') {
                    int firstIndex = i;

                    while(firstIndex-1 >= 0) {

                        if(tempboard[firstIndex-1].charAt(j) == ' ') break;
                        StringBuilder sb = new StringBuilder(tempboard[firstIndex]);

                        char replaceChar = tempboard[firstIndex-1].charAt(j);

                        sb.setCharAt(j, replaceChar);
                        tempboard[firstIndex] = sb.toString();
                        firstIndex--;
                    }
                    StringBuilder sb = new StringBuilder(tempboard[firstIndex]);
                    sb.setCharAt(j, ' ');
                    tempboard[firstIndex] = sb.toString();
                }
            }
        }


        for(int i=0; i<m; i++) {
            StringBuilder sb = new StringBuilder(tempboard[i]);
            board[i] = sb.toString();
            board[i] = board[i].replace('x', ' ');
        }
        return removeCnt;
    }
}