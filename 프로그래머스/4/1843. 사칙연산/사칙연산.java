import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] arr) {

        // 숫자의 개수
        int n = (arr.length + 1) / 2;

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        // 초기값
        for (int i = 0; i < n; i++) {
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);

            int num = Integer.parseInt(arr[i * 2]);

            maxDp[i][i] = num;
            minDp[i][i] = num;
        }

        // 구간에 들어있는 숫자 개수
        for (int len = 2; len <= n; len++) {

            // 구간 시작
            for (int start = 0; start + len - 1 < n; start++) {

                int end = start + len - 1;

                // 마지막 연산 위치
                for (int mid = start; mid < end; mid++) {

                    String op = arr[mid * 2 + 1];

                    if (op.equals("+")) {

                        int maxValue =
                            maxDp[start][mid]
                            + maxDp[mid + 1][end];

                        int minValue =
                            minDp[start][mid]
                            + minDp[mid + 1][end];

                        maxDp[start][end] =
                            Math.max(maxDp[start][end], maxValue);

                        minDp[start][end] =
                            Math.min(minDp[start][end], minValue);

                    } else {

                        int maxValue =
                            maxDp[start][mid]
                            - minDp[mid + 1][end];

                        int minValue =
                            minDp[start][mid]
                            - maxDp[mid + 1][end];

                        maxDp[start][end] =
                            Math.max(maxDp[start][end], maxValue);

                        minDp[start][end] =
                            Math.min(minDp[start][end], minValue);
                    }
                }
            }
        }

        return maxDp[0][n - 1];
    }
}