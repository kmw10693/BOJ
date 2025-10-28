import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static String[] map;
    static int[][] ans;

    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new String[n];
        ans = new int[n][m];

        for(int i=0; i<n; i++) {
            map[i] = br.readLine();
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i].charAt(j) == '1') ans[i][j] = 0;
                else ans[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i].charAt(j) == '1') {
                    Queue<int[]> q = new ArrayDeque<>();
                    q.add(new int[]{i,j});

                    while (!q.isEmpty()) {
                        int[] d = q.poll();
                        int curX = d[0];
                        int curY = d[1];
                        int curDist = ans[curX][curY];

                        for(int k=0; k<4; k++) {
                            int nxtX = curX + dx[k];
                            int nxtY = curY + dy[k];

                            if(nxtX < 0 || nxtX >= n || nxtY < 0 || nxtY >= m || ans[nxtX][nxtY] <= curDist + 1) continue;
                            ans[nxtX][nxtY] = curDist + 1;
                            q.add(new int[]{nxtX, nxtY});
                        }
                    }
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}