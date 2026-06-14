import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        final int INF = Integer.MAX_VALUE;

        // grid[i*n + j] = 처음 비 맞는 순번(1-base), 안 맞으면 INF
        int[] grid = new int[m * n];
        Arrays.fill(grid, INF);
        for (int t = 0; t < drops.length; t++) {
            grid[drops[t][0] * n + drops[t][1]] = t + 1;
        }

        // 1단계: 가로(폭 w) 슬라이딩 윈도우 최솟값
        int cols = n - w + 1;              // 유효한 열 시작 개수
        int[] rowMin = new int[m * cols];
        int[] dq = new int[n];
        for (int i = 0; i < m; i++) {
            int head = 0, tail = 0, base = i * n, out = i * cols;
            for (int j = 0; j < n; j++) {
                int val = grid[base + j];
                while (tail > head && grid[base + dq[tail - 1]] >= val) tail--;
                dq[tail++] = j;
                if (dq[head] <= j - w) head++;
                if (j >= w - 1) rowMin[out + (j - w + 1)] = grid[base + dq[head]];
            }
        }

        // 2단계: 세로(높이 h) 슬라이딩 윈도우 최솟값 → 동시에 최댓값 위치 추적
        long bestVal = -1;
        int bestR = -1, bestC = -1;
        int[] vdq = new int[m];
        for (int j = 0; j < cols; j++) {
            int head = 0, tail = 0;
            for (int i = 0; i < m; i++) {
                int val = rowMin[i * cols + j];
                while (tail > head && rowMin[vdq[tail - 1] * cols + j] >= val) tail--;
                vdq[tail++] = i;
                if (vdq[head] <= i - h) head++;
                if (i >= h - 1) {
                    int top = i - h + 1;                       // 윈도우의 맨 위 행
                    int wm = rowMin[vdq[head] * cols + j];     // 이 위치의 첫 비 시각
                    // 더 늦게(값이 큼) > 더 위 행 > 더 왼쪽 열
                    if (wm > bestVal ||
                        (wm == bestVal && (top < bestR || (top == bestR && j < bestC)))) {
                        bestVal = wm;
                        bestR = top;
                        bestC = j;
                    }
                }
            }
        }

        return new int[]{bestR, bestC};
    }
}