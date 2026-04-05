import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static int[] dy = {1,2,2,1,-1,-2,-2,-1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int i = Integer.parseInt(br.readLine());
            boolean[][] board = new boolean[i][i];

            int initX, initY;
            StringTokenizer st = new StringTokenizer(br.readLine());
            initX = Integer.parseInt(st.nextToken());
            initY = Integer.parseInt(st.nextToken());

            board[initX][initY] = true;
            Queue<int[]> q = new ArrayDeque<>();
            q.add(new int[]{initX, initY, 0});

            int destX, destY;
            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());

            while(!q.isEmpty()) {
                int[] curdest = q.poll();
                int curX = curdest[0];
                int curY = curdest[1];
                int curmovecnt = curdest[2];

                if(curX == destX && curY == destY) {
                    System.out.println(curmovecnt);
                    break;
                }

                for(int d=0; d<8; d++) {
                    int nxtX = curX + dx[d];
                    int nxtY = curY + dy[d];

                    if(nxtX < 0 || nxtX >= i || nxtY < 0 || nxtY >= i) continue;
                    if(board[nxtX][nxtY]) continue;
                    board[nxtX][nxtY] = true;
                    q.add(new int[]{nxtX, nxtY, curmovecnt+1});
                }
            }
        }
    }
}