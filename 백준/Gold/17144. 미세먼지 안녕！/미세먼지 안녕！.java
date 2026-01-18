import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int r,c,t;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    static int[][] map;
    static int[][] tmpmap;
    static List<Node> munji = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) munji.add(new Node(i, j));
            }
        }
        for(int i=0; i<t; i++) {
            spread();
            run();
        }
        print();
    }
    private static void print() {
        int ans = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(map[i][j] > 0) ans+= map[i][j];
            }
        }
        System.out.print(ans);
    }
    private static void run() {
        // 위는 반시계로 돌리자
        Node up = munji.get(0);
        Node down = munji.get(1);

        // 0,0은 무시
        for(int i=up.x-1; i>0; i--) {
            // 공기 청정기 위에 있는건 0이지
            map[i][0] = map[i-1][0];
        }
        for(int j=0; j<c-1; j++) {
            map[0][j] = map[0][j+1];
        }
        for(int i=0; i<up.x; i++) {
            map[i][c-1] = map[i+1][c-1];
        }
        for(int j=c-1; j>1; j--) {
            map[up.x][j] = map[up.x][j-1];
        }
        map[up.x][1] = 0;

        // 세로
        for(int i=down.x+1; i<r-1; i++) {
            map[i][0] = map[i+1][0];
        }
        for(int j=0; j<c-1; j++) {
            map[r-1][j] = map[r-1][j+1];
        }
        for(int i=r-1; i>down.x; i--) {
            map[i][c-1] = map[i-1][c-1];
        }
        for(int j=c-1; j>1; j--) {
            map[down.x][j] = map[down.x][j-1];
        }
        map[down.x][1] = 0;
    }
    private static void debug() {
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                System.out.print(map[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void spread() {
        // 임시 맵 초기화
        tmpmap = new int[r][c];

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(map[i][j] > 0) {
                    int curX = i, curY = j;
                    for(int p=0; p<4; p++) {
                        int nxtX = curX + dx[p];
                        int nxtY = curY + dy[p];
                        if(nxtX < 0 || nxtX >= r || nxtY < 0 || nxtY >= c) continue;
                        if(map[nxtX][nxtY] == -1) continue;
                        // map에서 인자 체크 후
                        // 일단 tmpMap에 기록하고 map 업데이트
                        tmpmap[nxtX][nxtY] += map[curX][curY] / 5;
                    }
                }
            }
        }

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                // 만약 미세먼지가 있던 경우 빼고 더하기
                if(map[i][j] > 0) {
                    // 인정 방향 몇개인지 구하기
                    int cnt = 0;
                    for(int p=0; p<4; p++) {
                        int nxtX = i + dx[p];
                        int nxtY = j + dy[p];
                        if(nxtX < 0 || nxtX >= r || nxtY < 0 || nxtY >= c) continue;
                        if(map[nxtX][nxtY] == -1) continue;
                        cnt++;
                    }
                    map[i][j] -= (map[i][j]/5) * cnt;
                    map[i][j] += tmpmap[i][j];
                } else if(map[i][j] != -1) {
                    map[i][j] = tmpmap[i][j];
                }
            }
        }
    }

    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}