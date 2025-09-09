import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    private static int[] dx = {-1, 1, 0, 0, -1,-1, 1, 1,0};
    private static int[] dy = {0, 0, 1, -1, 1,-1,1,-1,0};
    private static char[][] map;
    private static boolean[][] vis;
    private static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[8][8];
        for(int i=0; i<8; i++) {
            map[i] = br.readLine().toCharArray();
        }
        ans = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{7, 0});

        while(!q.isEmpty() && ans == 0) {
            q = player(q);
            mapmove();
        }
        System.out.println(ans);
    }

    public static void mapmove() {
        for(int i=7; i>=0; i--) {
            for(int j=0; j<8; j++) {
                if(map[i][j] == '#') {
                    map[i][j] = '.';
                    if(i != 7) {
                        map[i+1][j] = '#';
                    }
                }
            }
        }
    }

    public static Queue<int[]> player(Queue<int[]> q) {
        Queue<int[]> tmpq = new ArrayDeque<>();

        while(!q.isEmpty()) {
            int[] r = q.poll();
            int curX = r[0];
            int curY = r[1];

            if(map[curX][curY] == '#') continue;

            if(curX == 0 && curY == 7) {
                ans = 1;
                break;
            }

            for(int i=0; i<9; i++) {
                int nxtX = curX + dx[i];
                int nxtY = curY + dy[i];

                if(nxtX < 0 || nxtX >= 8 || nxtY < 0 || nxtY >=8) continue;
                if(map[nxtX][nxtY] == '#') continue;

                tmpq.add(new int[]{nxtX, nxtY});
            }
        }
        return tmpq;
    }
}