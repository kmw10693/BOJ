import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Point> cheeseList;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int[][] visited, map;
    static int cheeseCnt;
    static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cheeseList = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                  int x = Integer.parseInt(st.nextToken());
                  map[i][j] = x;
                  if(x == 1) {
                      cheeseList.add(new Point(i, j));
                      cheeseCnt++;
                  }
            }
        }

        while (cheeseCnt != 0) {
            ans++;
            visited = new int[N][M];
            dfs(0,0);
            removeCheese();
        }
        System.out.println(ans);
    }
    static void dfs(int x, int y) {
        visited[x][y] = 2;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(visited[nx][ny] != 0 || map[nx][ny] == 1) continue;
            dfs(nx, ny);
        }
    }

    static void removeCheese() {
        for(int i=0; i<cheeseList.size(); i++) {
            int x = cheeseList.get(i).x;
            int y = cheeseList.get(i).y;
            int cnt = 0;

            for(int j=0; j<4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(visited[nx][ny] == 2) cnt++;
            }

            if(cnt >= 2) {
                map[x][y] = 0;
                cheeseList.remove(i);
                cheeseCnt--;
                i--;
            }
        }
    }

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}