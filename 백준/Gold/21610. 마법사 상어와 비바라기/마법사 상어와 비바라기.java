import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] a;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    static int[] lx = {-1, -1, 1, 1};
    static int[] ly = {-1, 1, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 구름 초기화
        List<Cloud> cloud = new ArrayList<>();
        cloud.add(new Cloud(N-1, 0));
        cloud.add(new Cloud(N-1, 1));
        cloud.add(new Cloud(N-2, 0));
        cloud.add(new Cloud(N-2, 1));

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            move(d,s,cloud);
            // 비
            rain(cloud);
            // 구름 사라짐
            // 대각선 마법
            magic(cloud);
            // 구름 초기화
            addrain(cloud);
            //debug();
        }
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(a[i][j] > 0) count += a[i][j];
            }
        }
        System.out.print(count);
    }
    static void debug() {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(a[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void addrain(List<Cloud> c) {
        List<Cloud> tmp = new ArrayList<>();

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(a[i][j] >= 2) {
                    boolean check = false;
                    for(int k=0; k<c.size(); k++) {
                        if(c.get(k).x == i && c.get(k).y == j) {
                            check = true;
                            break;
                        }
                    }
                    if(!check) {
                        tmp.add(new Cloud(i, j));
                        a[i][j] -= 2;
                    }
                }
            }
        }
        c.clear();
        for(int i=0; i<tmp.size(); i++) {
            c.add(tmp.get(i));
        }
    }
    static void magic(List<Cloud> c) {
        for(int i=0; i<c.size(); i++) {
            int x = c.get(i).x;
            int y = c.get(i).y;

            int count = 0;
            for(int j=0; j<4; j++) {
                int nxtX = x + lx[j];
                int nxtY = y + ly[j];
                if(nxtX < 0 || nxtX >= N || nxtY < 0 || nxtY >= N) continue;
                if(a[nxtX][nxtY] > 0) count++;
            }
            a[x][y] += count;
        }
    }
    static void rain(List<Cloud> c) {
        for(int i=0; i<c.size(); i++) {
            a[c.get(i).x][c.get(i).y]++;
        }
    }
    static void move(int d, int s, List<Cloud> c) {
        for(int i=0; i<c.size(); i++) {
            for(int j=0; j<s; j++) {
                c.get(i).x += dx[d-1];
                c.get(i).y += dy[d-1];
                if(c.get(i).x < 0) c.get(i).x = N-1;
                if(c.get(i).x >= N) c.get(i).x = 0;
                if(c.get(i).y < 0) c.get(i).y = N-1;
                if(c.get(i).y >= N) c.get(i).y = 0;
            }
        }
    }

    static class Cloud {
        int x, y;
        Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}