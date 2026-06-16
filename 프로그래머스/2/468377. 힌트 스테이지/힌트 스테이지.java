import java.util.*;

class Solution {
    int n;
    int[][] cost;
    int[][] hint;
    Map<String, Integer> memo = new HashMap<>();

    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;
        this.n = cost.length;

        // have[s] = s번 스테이지(0-indexed)에 대해 현재까지 모은 힌트권 수
        int[] have = new int[n];
        return rec(0, have);
    }

    // stage: 현재 처리할 스테이지 (0-indexed)
    // have: 각 스테이지별 현재까지 보유한 힌트권 수
    int rec(int stage, int[] have) {
        if (stage == n) return 0;

        String key = stage + "|" + Arrays.toString(have);
        Integer cached = memo.get(key);
        if (cached != null) return cached;

        int maxUse = Math.min(have[stage], n - 1); // 한 스테이지 최대 n-1장
        int best = Integer.MAX_VALUE;

        // 이 스테이지에서 힌트권 use장 사용 (0 ~ maxUse)
        // 그리고 번들 구매 여부 0/1
        for (int use = 0; use <= maxUse; use++) {
            int solveCost = cost[stage][use];

            // (1) 번들 안 삼
            {
                int sub = rec(stage + 1, have);
                if (sub != Integer.MAX_VALUE)
                    best = Math.min(best, solveCost + sub);
            }

            // (2) 번들 삼 (마지막 스테이지는 번들 없음)
            if (stage < n - 1) {
                int price = hint[stage][0];
                int[] next = have.clone();
                for (int j = 1; j < hint[stage].length; j++) {
                    int ticket = hint[stage][j]; // 1-indexed 스테이지 번호
                    next[ticket - 1]++;          // 0-indexed로 변환해 보유 +1
                }
                int sub = rec(stage + 1, next);
                if (sub != Integer.MAX_VALUE)
                    best = Math.min(best, solveCost + price + sub);
            }
        }

        memo.put(key, best);
        return best;
    }
}