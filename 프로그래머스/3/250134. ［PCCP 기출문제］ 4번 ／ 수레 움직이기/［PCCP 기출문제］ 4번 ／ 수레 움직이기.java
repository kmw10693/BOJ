class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static boolean[][][] visited;
    static boolean isdestR = false;
    static boolean isdestB = false;

    static int answer = Integer.MAX_VALUE; // 최소값 찾는다고 가정
    static int row, col;

    public int solution(int[][] maze) {
        visited = new boolean[maze.length][maze[0].length][2];
        row = maze.length;
        col = maze[0].length;

        Point startR = null, startB = null;

        for (int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (maze[i][j] == 1) {
                    startR = new Point(i, j);
                    visited[i][j][0] = true;
                }
                if (maze[i][j] == 2) {
                    startB = new Point(i, j);
                    visited[i][j][1] = true;
                }
            }
        }

        bt(0, startR, startB, maze); 

        return (answer == Integer.MAX_VALUE) ? 0 : answer; 
    }

    public void bt(int cnt, Point curR, Point curB, int[][] maze) {
        if (isdestR && isdestB) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                int nxtRx = isdestR ? curR.x : curR.x + dx[i];
                int nxtRy = isdestR ? curR.y : curR.y + dy[i];

                int nxtBx = isdestB ? curB.x : curB.x + dx[j]; 
                int nxtBy = isdestB ? curB.y : curB.y + dy[j]; 

                Point nxtR = new Point(nxtRx, nxtRy);
                Point nxtB = new Point(nxtBx, nxtBy);

                if (isPossible(curR, curB, nxtR, nxtB, maze)) {
                    boolean prevDestR = isdestR;
                    boolean prevDestB = isdestB;

                    visited[nxtR.x][nxtR.y][0] = true;
                    visited[nxtB.x][nxtB.y][1] = true;

                    if (maze[nxtR.x][nxtR.y] == 3) isdestR = true;
                    if (maze[nxtB.x][nxtB.y] == 4) isdestB = true;

                    bt(cnt+1, nxtR, nxtB, maze);

                    visited[nxtR.x][nxtR.y][0] = false;
                    visited[nxtB.x][nxtB.y][1] = false;

                    isdestR = prevDestR;
                    isdestB = prevDestB;
                }
            }
        }
    }

    public boolean isPossible(Point prevR, Point prevB, Point R, Point B, int[][] maze) {
        if (R.x < 0 || R.x >= row || R.y < 0 || R.y >= col) return false;
        if (B.x < 0 || B.x >= row || B.y < 0 || B.y >= col) return false;

        if (maze[R.x][R.y] == 5 || maze[B.x][B.y] == 5) return false;

        if (!isdestR && visited[R.x][R.y][0]) return false;
        if (!isdestB && visited[B.x][B.y][1]) return false;

        if (R.x == B.x && R.y == B.y) return false;
        if (R.x == prevB.x && R.y == prevB.y && B.x == prevR.x && B.y == prevR.y) return false;

        return true;
    }

    public class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }
}