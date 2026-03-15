import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int D = drops.length;
        int INF = D + 1;

        // 1) 각 칸의 비 오는 순서 기록
        int[][] time = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(time[i], INF);
        }

        for (int i = 0; i < D; i++) {
            int r = drops[i][0];
            int c = drops[i][1];
            time[r][c] = i + 1;
        }

        // 2) 각 행에 대해 너비 w 구간 최소값
        int cols = n - w + 1;
        int[][] rowMin = new int[m][cols];

        for (int r = 0; r < m; r++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int c = 0; c < n; c++) {
                while (!dq.isEmpty() && time[r][dq.peekLast()] >= time[r][c]) {
                    dq.pollLast();
                }
                dq.addLast(c);

                // 윈도우 범위 밖 제거
                while (!dq.isEmpty() && dq.peekFirst() <= c - w) {
                    dq.pollFirst();
                }

                // 길이 w 완성되면 최소값 기록
                if (c >= w - 1) {
                    rowMin[r][c - w + 1] = time[r][dq.peekFirst()];
                }
            }
        }

        // 3) 각 열에 대해 높이 h 구간 최소값
        int rows = m - h + 1;
        int bestValue = -1;
        int bestR = 0;
        int bestC = 0;

        for (int c = 0; c < cols; c++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int r = 0; r < m; r++) {
                while (!dq.isEmpty() && rowMin[dq.peekLast()][c] >= rowMin[r][c]) {
                    dq.pollLast();
                }
                dq.addLast(r);

                // 윈도우 범위 밖 제거
                while (!dq.isEmpty() && dq.peekFirst() <= r - h) {
                    dq.pollFirst();
                }

                // 높이 h 완성되면 (r-h+1, c) 직사각형 최소값 완성
                if (r >= h - 1) {
                    int top = r - h + 1;
                    int value = rowMin[dq.peekFirst()][c];

                    if (value > bestValue) {
                        bestValue = value;
                        bestR = top;
                        bestC = c;
                    } else if (value == bestValue) {
                        if (top < bestR || (top == bestR && c < bestC)) {
                            bestR = top;
                            bestC = c;
                        }
                    }
                }
            }
        }

        return new int[]{bestR, bestC};
    }
}