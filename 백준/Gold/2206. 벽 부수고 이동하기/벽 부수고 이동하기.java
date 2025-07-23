import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if(N-1 == 0 && M-1 == 0) {
            System.out.println(1);
            System.exit(0);
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        char[][] miro = new char[N][M];
        int[][] dist = new int[N][M];
        boolean[][][] visit = new boolean[2][N][M];
        Queue<int[]> qu = new LinkedList<>();

        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                miro[i][j] = s.charAt(j);
            }
        }

        qu.offer(new int[]{0,0,0});

        while(!qu.isEmpty()) {
            int[] cur = qu.poll();

            for(int i=0; i<4; i++){
                int nX = cur[0] + dx[i];
                int nY = cur[1] + dy[i];

                if(nX < 0 || nX >=N || nY<0 || nY >=M) {
                    continue;
                }

                if(miro[nX][nY] == '1') {
                    if(cur[2] == 0 && !visit[1][nX][nY]) {
                        visit[cur[2]][nX][nY] = true;
                        dist[nX][nY] = dist[cur[0]][cur[1]] + 1;
                        qu.offer(new int[]{nX, nY, 1});
                    }
                }

                else {
                    if(!visit[cur[2]][nX][nY]) {
                        visit[cur[2]][nX][nY] = true;
                        dist[nX][nY] = dist[cur[0]][cur[1]] + 1;
                        qu.offer(new int[]{nX, nY, cur[2]});
                    }
                }
                if(nX == N-1 && nY == M-1) {
                    System.out.println(dist[nX][nY] + 1);
                    System.exit(0);
                }

            }
        }
        System.out.print(-1);
    }
}