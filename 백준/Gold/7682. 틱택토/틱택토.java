import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.*;

// X의 갯수가 더 크다면, X가 이겨야 한다. (X가 먼저 시작하기 때문)
// X의 갯수와 O의 갯수가 같다면, O가 이기는 것이다. (X가 먼저 시작하므로)
public class Main {

   static char[][] board;
   static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            if(str.equals("end")) break;

            int[] cntArr = new int[2];
            int idx = 0;

            board = new char[3][3];
            for(int i=0; i<3; i++) {
                for(int j=0; j<3; j++) {
                    board[i][j] = str.charAt(idx++);

                    if(board[i][j] == 'X') cntArr[0]++;
                    else if(board[i][j] == 'O') cntArr[1]++;
                }
            }

            if(cntArr[0] == cntArr[1] + 1) {
                if(cntArr[0] + cntArr[1] == 9 && !bingo('O')) ans.append("valid");
                else if(!bingo('O') && bingo('X')) ans.append("valid");
                else ans.append("invalid");
            }
            else if(cntArr[0] == cntArr[1]) {
                if(!bingo('X') && bingo('O')) ans.append("valid");
                else ans.append("invalid");
            } else {
                ans.append("invalid");
            }
            ans.append("\n");
        }
        System.out.println(ans.toString());
    }

    private static boolean bingo(char c) {

        // 행 확인
        for(int i=0; i<3; i++) {
            if(board[i][0] == c && board[i][1] == c && board[i][2] == c) return true;
        }

        for(int i=0; i<3; i++) {
            if(board[0][i] == c && board[1][i] == c && board[2][i] == c ) return true;
        }

        if(board[0][0] == c && board[1][1] == c && board[2][2] == c) return true;

        if(board[0][2] == c && board[1][1] == c && board[2][0] == c) return true;

        return false;
    }
}