class Solution {
    public int solution(String[] board) {
        int ocnt = 0;
        int xcnt = 0;
        for(int i=0; i<board.length; i++) {
            ocnt += getCnt(board[i], 'O');
            xcnt += getCnt(board[i], 'X');
        }
        if(xcnt > ocnt) return 0;
        if(ocnt > xcnt + 1) return 0;
        // o가 완성되었을때 x가 같으면 안됨
        if(hasWin(board, 'X')) {
            if(ocnt > xcnt) return 0;
        }
        if(hasWin(board, 'O')) {
            if(xcnt >= ocnt) return 0;
        }
        // x가 완성되었을때 o가 크면 안됨
        return 1;
    }
    public boolean hasWin(String[] board, char c) {
        for(int i=0; i<3; i++) {
            if(board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
        }
        for(int i=0; i<3; i++) {
            if(board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
        }
        if(board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
        if(board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
        return false;
    }
    public int getCnt(String s, char c) {
        return s.length() - s.replace(String.valueOf(c), "").length();
    }
}