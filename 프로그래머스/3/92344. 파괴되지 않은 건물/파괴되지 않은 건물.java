class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] sum = new int[n+1][m+1];
        
        for(int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            int value;
            
            if(type == 1) {
                value = -degree;
            } else {
                value = degree;
            }
            
            sum[r1][c1] += value;
            sum[r1][c2+1] -= value;
            sum[r2+1][c1] -= value;
            sum[r2+1][c2+1] += value;
        }
        
        for(int r=0; r<=n; r++) {
            for(int c=1; c<=m; c++) {
                sum[r][c] += sum[r][c-1];
            }
        }
        
        for(int c=0; c<=m; c++) {
            for(int r=1; r<=n; r++) {
                sum[r][c] += sum[r-1][c];
            }
        }
        
        int answer = 0;
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(board[r][c] + sum[r][c] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}