import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            if (checkRow(i)) ans++;
            if (checkCol(i)) ans++;
        }

        System.out.println(ans);
    }

    // 행 검사
    static boolean checkRow(int r) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[r][i + 1] - map[r][i];
            if (diff == 0) continue;

            // 높이 차이 1 초과
            if (Math.abs(diff) > 1) return false;

            // 오르막
            if (diff == 1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || visited[j] || map[r][j] != map[r][i]) return false;
                    visited[j] = true;
                }
            }

            // 내리막
            else if (diff == -1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || visited[j] || map[r][j] != map[r][i + 1]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }

    // 열 검사
    static boolean checkCol(int c) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[i + 1][c] - map[i][c];
            if (diff == 0) continue;

            if (Math.abs(diff) > 1) return false;

            if (diff == 1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || visited[j] || map[j][c] != map[i][c]) return false;
                    visited[j] = true;
                }
            }

            else if (diff == -1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || visited[j] || map[j][c] != map[i + 1][c]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}
