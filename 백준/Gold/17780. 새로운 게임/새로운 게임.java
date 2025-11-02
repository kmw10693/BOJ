import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int WHITE = 0, RED = 1, BLUE = 2;
    static int[] change = {1,0,3,2};

    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};

    static int N, K;
    static int[][] map;
    static LinkedList<Integer>[][] state;
    static Horse[] horses;

    static class Horse {
        int r,c,dir;
        Horse(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        state = new LinkedList[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                state[i][j] = new LinkedList<>();
            }
        }

        horses = new Horse[K+1];
        for(int i=1; i<=K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) -1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) -1;
            horses[i] = new Horse(r,c,dir);
            state[r][c].add(i);
        }

        System.out.println(start());
    }
    private static int start() {
        boolean flag = true;
        int times = 0;
        while (flag) {
            times++;
            if(times > 1000) break;

            for(int i=1; i<=K; i++) {
                Horse h = horses[i];
                int r = h.r;
                int c = h.c;

                if(state[r][c].get(0) != i) continue;

                int nr = r + dr[h.dir];
                int nc = c + dc[h.dir];

                if(!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    h.dir = change[h.dir];
                    nr = r + dr[h.dir];
                    nc = c + dc[h.dir];
                }

                if(!isRange(nr, nc) || map[nr][nc] == BLUE) {
                    continue;
                }

                else if(map[nr][nc] == RED) {
                    for(int j=state[r][c].size()-1; j>=0; j--) {
                        int tmp = state[r][c].get(j);
                        state[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    state[r][c].clear();
                }

                else {
                    for(int j=0; j<state[r][c].size(); j++) {
                        int tmp = state[r][c].get(j);
                        state[nr][nc].add(tmp);
                        horses[tmp].r = nr;
                        horses[tmp].c = nc;
                    }
                    state[r][c].clear();
                }

                if(state[nr][nc].size() >= 4) {
                    flag = false;
                    break;
                }
            }
        }
        return flag ? -1 : times;
    }

    static boolean isRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}