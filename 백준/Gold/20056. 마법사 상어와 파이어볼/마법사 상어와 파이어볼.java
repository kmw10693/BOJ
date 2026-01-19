import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n,m,k;
    static List<Fireball>[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // map에 저장된 List
        map = new ArrayList[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int r,c,mass,d,s;
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            mass = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            map[r-1][c-1].add(new Fireball(r-1,c-1,mass,d,s));
        }
        for(int i=0; i<k; i++) {
            instruct();
            sum();
            clear();
        }
        System.out.print(ans());
    }
    static void clear() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                map[i][j].removeIf(fireball -> fireball.m == 0);
            }
        }
    }
    static int ans() {
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                for(Fireball fireball : map[i][j]) sum += fireball.m;
            }
        }
        return sum;
    }
    static void instruct() {
        List<Fireball>[][] nextMap = new ArrayList[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
               nextMap[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!map[i][j].isEmpty()) {
                    move(i, j, nextMap);
                }
            }
        }
        map = nextMap;
    }

    static void sum() {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j].size() >= 2) {
                    // 질량 합치자
                    int weight = 0;
                    // 속력
                    int speed = 0;
                    // 첫번째 방향으로 모두 홀수 이거나 짝수 판별
                    boolean all = true;
                    int firstM = 0;
                    for(int k=0; k<map[i][j].size(); k++) {
                        Fireball fireball = map[i][j].get(k);
                        // 첫번째 방향 가져오기
                        if(k == 0) {
                            firstM = fireball.d;
                        }
                        if((fireball.d % 2) != (firstM % 2)) all =false;
                        weight += fireball.m;
                        speed += fireball.s;
                    }
                    int newM = weight/5;
                    int newS = speed/map[i][j].size();
                    map[i][j].clear();

                    if(all) {
                        map[i][j].add(new Fireball(i, j, newM, 0, newS));
                        map[i][j].add(new Fireball(i, j, newM, 2, newS));
                        map[i][j].add(new Fireball(i, j, newM, 4, newS));
                        map[i][j].add(new Fireball(i, j, newM, 6, newS));
                    } else {
                        map[i][j].add(new Fireball(i, j, newM, 1, newS));
                        map[i][j].add(new Fireball(i, j, newM, 3, newS));
                        map[i][j].add(new Fireball(i, j, newM, 5, newS));
                        map[i][j].add(new Fireball(i, j, newM, 7, newS));
                    }

                }
            }
        }
    }
    // i번째 움직임
    static void move(int i, int j, List<Fireball>[][] nextMap) {
        // i번째 파이어볼 움직임
        List<Fireball> fireball = map[i][j];
        for(int p=0; p<fireball.size(); p++) {
            int curX = fireball.get(p).r;
            int curY = fireball.get(p).c;

            // 방향 만큼 움직여야지
            curX += fireball.get(p).s * dx[fireball.get(p).d];
            curY += fireball.get(p).s * dy[fireball.get(p).d];

            if (curX >= n) curX %= n;
            if (curX < 0) {
                // 1을 더해주고 -1 곱함
                int tmp = (curX + 1) * -1;
                curX += (tmp / n + 1) * n;
            }
            if (curY >= n) curY %= n;
            if (curY < 0) {
                int tmp = (curY + 1) * -1;
                curY += (tmp / n + 1) * n;
            }
            nextMap[curX][curY].add(new Fireball(curX, curY, fireball.get(p).m, fireball.get(p).d, fireball.get(p).s));
        }
    }

    static class Fireball {
        int r,c,m,d,s;
        Fireball(int r, int c, int m, int d, int s) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.d = d;
            this.s = s;
        }
    }
}